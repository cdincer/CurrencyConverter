package com.cdincer.currencyconverter.dao;

import com.cdincer.currencyconverter.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CurrencyRepository extends JpaRepository<Currency,Integer> {

}
