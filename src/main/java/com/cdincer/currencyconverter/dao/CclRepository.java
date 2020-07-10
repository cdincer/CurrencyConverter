package com.cdincer.currencyconverter.dao;

import com.cdincer.currencyconverter.entity.CurrencyConversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CclRepository extends JpaRepository<CurrencyConversion,Integer> {

    @Query("select u from CurrencyConversion u where u.homeCurrency =  :item")
    List<CurrencyConversion> findCurrencyByBase(@Param("item") String myBase);

    @Query("select u from CurrencyConversion u where u.timeofday =  :item")
    List<CurrencyConversion> findCurrencyByTime(@Param("item") String myTime);

    @Query("select u from CurrencyConversion u where u.homeCurrency =  :item and u.timeofday =  :item2")
    List<CurrencyConversion> findCurrencyByBaseAndTime(@Param("item") String myBase, @Param("item2")String myTime);
}
