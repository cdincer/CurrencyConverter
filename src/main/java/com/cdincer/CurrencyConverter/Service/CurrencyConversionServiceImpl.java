package com.cdincer.CurrencyConverter.Service;

import com.cdincer.CurrencyConverter.Dao.CurrencyConversionRepository;
import com.cdincer.CurrencyConverter.Entity.CurrencyConversion;
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
        String Stamp = theCurrencyConversion.getTimeofday();

        return String.valueOf(transactionId) +" "+Stamp;
    }
}
