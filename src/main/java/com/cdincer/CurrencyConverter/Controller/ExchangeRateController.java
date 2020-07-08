package com.cdincer.CurrencyConverter.Controller;

import java.util.concurrent.atomic.AtomicLong;

import com.cdincer.CurrencyConverter.Entity.Currency;
import com.cdincer.CurrencyConverter.Service.RestService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeRateController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Currency greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Currency(counter.incrementAndGet(), String.format(template, name));
    }




    @GetMapping("/exrate")
    public Currency ExchangeRate(@RequestParam(value = "home_currency", defaultValue = "World")
                                          String homecur,@RequestParam(value ="target_currency" ,defaultValue = "World2") String currency) {

        String test = homecur;
        String test2 = currency;
        RestTemplateBuilder MyTemplateBuilder = new RestTemplateBuilder();
        RestService MyService = new RestService(MyTemplateBuilder);
        String random = MyService.getPostsPlainJSON();

        return new Currency(counter.incrementAndGet(), String.format(template, homecur));
    }
}