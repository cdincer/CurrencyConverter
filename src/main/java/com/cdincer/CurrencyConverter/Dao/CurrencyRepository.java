package com.cdincer.CurrencyConverter.Dao;

import com.cdincer.CurrencyConverter.Entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CurrencyRepository extends JpaRepository<Currency,Integer> {

}
