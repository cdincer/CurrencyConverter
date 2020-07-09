package com.cdincer.CurrencyConverter.Dao;

import com.cdincer.CurrencyConverter.Entity.Currency;
import com.cdincer.CurrencyConverter.Entity.CurrencyConversion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyConversionRepository extends JpaRepository<CurrencyConversion,Integer> {
}
