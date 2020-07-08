package com.cdincer.CurrencyConverter.Service;

import java.util.concurrent.atomic.AtomicLong;

import com.cdincer.CurrencyConverter.Entity.Currency;
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
}