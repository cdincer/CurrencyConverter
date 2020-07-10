package com.cdincer.CurrencyConverter.Dao;

import com.cdincer.CurrencyConverter.Entity.CurrencyConversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CCLRepository  extends JpaRepository<CurrencyConversion,Integer> {

    @Query("select u from CurrencyConversion u where u.home_currency =  :item")
    List<CurrencyConversion> findCurrencyByBase(@Param("item") String my_base);

    @Query("select u from CurrencyConversion u where u.timeofday =  :item")
    List<CurrencyConversion> findCurrencyByTime(@Param("item") String my_time);

    @Query("select u from CurrencyConversion u where u.home_currency =  :item and u.timeofday =  :item2")
    List<CurrencyConversion> findCurrencyByBaseAndTime(@Param("item") String my_base,@Param("item2")String my_time);
}
