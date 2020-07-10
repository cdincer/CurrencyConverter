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
                                       String homecur, @RequestParam(value ="target_currency") String tcur) {


        //Trying LocalDate for later experimentation -- to be erased later.
        LocalDate newFormat =LocalDate.now();
        //

        List<CurrencyConversion> myList = mCCLService.findRows(homecur,"1");

        return myList;
    }
}
