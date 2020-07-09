package com.cdincer.CurrencyConverter.Service;

import com.cdincer.CurrencyConverter.Dao.CurrencyRepository;
import com.cdincer.CurrencyConverter.Entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyServiceImpl (CurrencyRepository theCurrencyRepository)
    {
        currencyRepository = theCurrencyRepository;
    }


    @Override
    public void save(Currency theCurrency) {
     currencyRepository.save(theCurrency);
    }
}
