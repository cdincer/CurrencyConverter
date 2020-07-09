package com.cdincer.CurrencyConverter.Rest;

import java.util.concurrent.atomic.AtomicLong;

import com.cdincer.CurrencyConverter.Dao.CurrencyRepository;
import com.cdincer.CurrencyConverter.Entity.Currency;
import com.cdincer.CurrencyConverter.Service.ExchangeRateServiceImpl;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeRateController {

    private final AtomicLong counter = new AtomicLong();



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



        ExchangeRateServiceImpl Servicep = new ExchangeRateServiceImpl(MyTemplateBuilder);

        String result = Servicep.currencyConversionRate(homecur,tcur);

        return result;
    }
}