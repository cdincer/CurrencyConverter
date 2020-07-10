package com.cdincer.currencyconverter.service;

import com.cdincer.currencyconverter.dao.CclRepository;
import com.cdincer.currencyconverter.entity.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CCLServiceImpl implements  CCLService
{

    private CclRepository cclRepository;

    @Autowired
    public CCLServiceImpl (CclRepository thecclRepository)
    {
        cclRepository = thecclRepository;
    }



    @Override
    public List<CurrencyConversion> findRows(String homeCurrency, String time) {
        List<CurrencyConversion> mItems = new ArrayList<>() ;

        if((!homeCurrency.equals("") ) && (!time.equals("") ))
        {
         mItems = cclRepository.findCurrencyByBaseAndTime(homeCurrency, time);
        }
        else
        if(!homeCurrency.equals("") && time.equals("") )
        {
            mItems=   cclRepository.findCurrencyByBase(homeCurrency);
        }
        else
        if (!time.equals("")  && homeCurrency.equals(""))
        {
            mItems=   cclRepository.findCurrencyByTime(time);
        }
     return  mItems;
    }

    @Override
    public List<CurrencyConversion> findAll() {
        return cclRepository.findAll();
    }


}
