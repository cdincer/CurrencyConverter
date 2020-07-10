package com.cdincer.currencyconverter.rest;

import java.util.HashMap;
import java.util.Map;

import com.cdincer.currencyconverter.entity.Currency;
import com.cdincer.currencyconverter.exception.ExchangeNotFoundException;
import com.cdincer.currencyconverter.service.CurrencyService;
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

//You just get amounts for entered pairs and default base.
@RestController
public class ExchangeRateController {


    private CurrencyService currencyService;
    public ExchangeRateController(CurrencyService mCurrencyService)
    {
        this.currencyService = mCurrencyService;
    }

    @GetMapping("/exrate")
    public String exchangeRate(@RequestParam(value = "home_currency")
                                          String homecur, @RequestParam(value ="target_currency") String tcur) {

        if(homecur == null || homecur.equals(""))
        {
            throw new ExchangeNotFoundException("Please enter a base currency");
        }

        if(tcur == null || tcur.equals(""))
        {
            throw new ExchangeNotFoundException("Please enter a target currency");
        }


        String result = currencyConversionRate(homecur,tcur);

        Currency mResult = new Currency(0,homecur,tcur,result);
        currencyService.save(mResult);

        return result;
    }



    public String currencyConversionRate(String curr1,String curr2)
    {

        RestTemplate mrestTemplate;
        RestTemplateBuilder nrestTemplateB = new RestTemplateBuilder() ;
        mrestTemplate = nrestTemplateB.build();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        String msisdn=curr1+","+curr2;

        Map<String, String> params = new HashMap<>();
        params.put("symbols", msisdn);
        String url="https://api.ratesapi.io/api/latest";
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("symbols", msisdn);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<String> response = mrestTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class);

        return  response.getBody();
    }

}