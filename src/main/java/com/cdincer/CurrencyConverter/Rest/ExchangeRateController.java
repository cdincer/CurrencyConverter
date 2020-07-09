package com.cdincer.CurrencyConverter.Rest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.cdincer.CurrencyConverter.Dao.CurrencyRepository;
import com.cdincer.CurrencyConverter.Entity.Currency;
import com.cdincer.CurrencyConverter.Service.CurrencyService;
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

@RestController
public class ExchangeRateController {

    private final AtomicLong counter = new AtomicLong();

    private CurrencyService currencyService;
    public ExchangeRateController(CurrencyService mCurrencyService)
    {
        this.currencyService = mCurrencyService;
    }

    @GetMapping("/exrate")
    public String ExchangeRate(@RequestParam(value = "home_currency")
                                          String homecur,@RequestParam(value ="target_currency") String tcur) {

        RestTemplateBuilder MyTemplateBuilder = new RestTemplateBuilder();
        if(homecur == null || homecur == "")
        {   //Specialized error catch instead of global one
            throw new ExchangeNotFoundException("Please enter a base currency");
        }

        if(tcur == null || tcur == "")
        {   //Specialized error catch instead of global one
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

        Map<String, String> params = new HashMap<String, String>();
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
        String excrater  = response.getBody().toString();

        return excrater;
    }

}