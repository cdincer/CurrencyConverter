package com.cdincer.currencyconverter.rest;

import com.cdincer.currencyconverter.entity.CurrencyConversion;
import com.cdincer.currencyconverter.exception.ExchangeNotFoundException;
import com.cdincer.currencyconverter.service.CCLService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


//CurrencyConversionList Controller
@RestController
public class CclController {



    private CCLService mCCLService;
    public CclController(CCLService cclServiceT)
    {
        this.mCCLService = cclServiceT;
    }

    @GetMapping("/cclist")
    public List<CurrencyConversion> exchangeRate(@RequestParam(value = "home_currency")
                                       String homecur, @RequestParam(value ="time") String time) {

        if(homecur.equals("") && time.equals(""))
        {   //Specialized error catch instead of global one
            throw new ExchangeNotFoundException("Please enter a currency to search or time frame (yyyy-MM-dd)");
        }


        return  mCCLService.findRows(homecur,time);
    }
}
