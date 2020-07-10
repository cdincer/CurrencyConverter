package com.cdincer.CurrencyConverter.Service;

import com.cdincer.CurrencyConverter.Entity.CurrencyConversion;


import java.util.List;
//CurrencyConversionList
public interface CCLService {
    public List<CurrencyConversion> findRows(String home_currency, String Time);
    public List<CurrencyConversion> findAll();

}
