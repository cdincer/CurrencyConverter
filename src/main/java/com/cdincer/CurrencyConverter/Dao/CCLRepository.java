package com.cdincer.CurrencyConverter.Dao;

import com.cdincer.CurrencyConverter.Entity.CurrencyConversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CCLRepository  extends JpaRepository<CurrencyConversion,Integer> {

    @Query("select u from CurrencyConversion u where u.home_currency =  :item")
    List<CurrencyConversion> findCurrencyByBase(@Param("item") String my_base);
}
