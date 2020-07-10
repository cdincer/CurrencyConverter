package com.cdincer.CurrencyConverter.Service;

import com.cdincer.CurrencyConverter.Dao.CCLRepository;
import com.cdincer.CurrencyConverter.Dao.CurrencyConversionRepository;
import com.cdincer.CurrencyConverter.Entity.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CCLServiceImpl implements  CCLService
{

    private CCLRepository cclRepository;

    @Autowired
    public CCLServiceImpl (CCLRepository thecclRepository)
    {
        cclRepository = thecclRepository;
    }



    @Override
    public List<CurrencyConversion> findRows(String home_currency, String Time) {
     List<CurrencyConversion> mItems=   cclRepository.findCurrencyByBase(home_currency);

     return  mItems;
    }

    @Override
    public List<CurrencyConversion> findAll() {
        return cclRepository.findAll();
    }


}
