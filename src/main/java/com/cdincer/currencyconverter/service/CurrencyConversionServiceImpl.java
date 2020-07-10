package com.cdincer.currencyconverter.service;

import com.cdincer.currencyconverter.dao.CurrencyConversionRepository;
import com.cdincer.currencyconverter.entity.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService{


    private CurrencyConversionRepository currencyConversionRepository;

    @Autowired
    public CurrencyConversionServiceImpl (CurrencyConversionRepository theCurrencyConversionRepository)
    {
        currencyConversionRepository = theCurrencyConversionRepository;
    }


    @Override
    public String save(CurrencyConversion theCurrencyConversion) {
        currencyConversionRepository.save(theCurrencyConversion);
        long transactionId = theCurrencyConversion.getId();
        String stamp = theCurrencyConversion.getTimeofday();

        return transactionId +" "+stamp;
    }
}
