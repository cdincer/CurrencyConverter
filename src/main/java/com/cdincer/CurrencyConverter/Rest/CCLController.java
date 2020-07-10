package com.cdincer.CurrencyConverter.Rest;

import com.cdincer.CurrencyConverter.Entity.CurrencyConversion;
import com.cdincer.CurrencyConverter.Service.CCLService;
import com.cdincer.CurrencyConverter.Service.CurrencyConversionService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


//CurrencyConversionList Controller
@RestController
public class CCLController {



    private CCLService mCCLService;
    public CCLController(CCLService CCLServiceT)
    {
        this.mCCLService = CCLServiceT;
    }

    @GetMapping("/cclisr")
    public List<CurrencyConversion> ExchangeRate(@RequestParam(value = "home_currency")
                                       String homecur, @RequestParam(value ="time") String time) {

        if(homecur == "" && time =="")
        {   //Specialized error catch instead of global one
            throw new ExchangeNotFoundException("Please enter a currency to search or time frame (yyyy-MM-dd)");
        }




        List<CurrencyConversion> myList = mCCLService.findRows(homecur,time);

        return myList;
    }
}
