package com.cdincer.currencyconverter.rest;


import com.cdincer.currencyconverter.entity.CurrencyConversion;
import com.cdincer.currencyconverter.exception.ExchangeNotFoundException;
import com.cdincer.currencyconverter.service.CurrencyConversionService;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

//Main spot where amounts are calculated.
@RestController
public class CurrencyConversionController {

    private CurrencyConversionService  currencyConversionService;
    public CurrencyConversionController(CurrencyConversionService mCurrencyConversionService)
    {
        this.currencyConversionService = mCurrencyConversionService;
    }



    @GetMapping("/changerate")
    public String exchangeRate(@RequestParam(value = "home_currency")
                                       String homecur, @RequestParam(value ="target_currency") String tcur, @RequestParam(value="amount")String amountS) {


        if(amountS.equals(""))
        {
            throw new ExchangeNotFoundException("Please enter a valid amount");
        }

        double amount = Double.parseDouble(amountS);

        if(homecur == null || homecur.equals("") )
        {   //Specialized error catch instead of global one
            throw new ExchangeNotFoundException("Please enter a base currency");
        }

        if(tcur == null || tcur.equals(""))
        {
            throw new ExchangeNotFoundException("Please enter a target currency");
        }




        String result = currencyConversionTarget(homecur,tcur);
        result = result.substring(5,15);
        amount = Double.parseDouble(result) * amount;
        CurrencyConversion mResult = new CurrencyConversion(0,homecur,tcur,amount);
        currencyConversionService.save(mResult);

        return mResult.getId() +" is your transaction ID. Your conversions comes to "+ amount;
    }



    public String currencyConversionTarget(String curr1,String curr2)
    {

        RestTemplate mrestTemplate;
        RestTemplateBuilder nrestTemplateB = new RestTemplateBuilder() ;
        mrestTemplate = nrestTemplateB.build();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        String foundation=curr1;
        String destination=curr2;

        /*
        * "https://api.ratesapi.io/api/latest?base=USD&symbols=GBP"
        * */
        Map<String, String> params = new HashMap<>();
        params.put("base",foundation);
        params.put("symbols", destination);
        String url="https://api.ratesapi.io/api/latest";
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("base", foundation).queryParam("symbols",destination);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<String> response = mrestTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class);
        String excrater  = response.getBody();
        excrater= jsonBreaker(excrater);
        return excrater;
    }


    public String jsonBreaker(String unprocessed)
    {

        String result="";
        JsonParser springParser = JsonParserFactory.getJsonParser();
        Map<String, Object> map = springParser.parseMap(unprocessed);


        for (Map.Entry<String, Object> entry : map.entrySet()) {

            if(entry.getKey().equals("rates"))
            {
                result=entry.getValue().toString();
              return result ;
            }
        }


        return "1";
    }

}
