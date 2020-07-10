package com.cdincer.currencyconverter.service;

import com.cdincer.currencyconverter.entity.CurrencyConversion;


import java.util.List;
//CurrencyConversionList
public interface CCLService {
     List<CurrencyConversion> findRows(String homeCurrency, String time);
     List<CurrencyConversion> findAll();

}
