package com.cdincer.CurrencyConverter.Dao;

import com.cdincer.CurrencyConverter.Entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurrencyRepository extends JpaRepository<Currency,Integer> {

}
