package com.cdincer.CurrencyConverter.Service;

import com.cdincer.CurrencyConverter.Entity.CurrencyConversion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
//CurrencyConversionList
public interface CCLService {
    public List<CurrencyConversion> findRows(String home_currency, String Time);
    public List<CurrencyConversion> findAll();

}
