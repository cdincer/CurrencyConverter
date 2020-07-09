package com.cdincer.CurrencyConverter.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import java.util.HashMap;
import java.util.Map;


@Service
public class ExchangeRateServiceImpl implements ExchangeRateService{

    private final RestTemplate restTemplate;

    public ExchangeRateServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();

    }

    //Qualifier added in there to show what happens when you have 2 beans that have the same blueprint
    //Specify which one to use



    @Override
    public String currencyConversionRate(String curr1,String curr2)
    {
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

        HttpEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class);
        String excrater  = response.getBody().toString();

        return excrater;
    }

}

