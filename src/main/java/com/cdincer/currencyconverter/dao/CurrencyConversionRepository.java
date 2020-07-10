package com.cdincer.currencyconverter.dao;

import com.cdincer.currencyconverter.entity.CurrencyConversion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyConversionRepository extends JpaRepository<CurrencyConversion,Integer> {
}
