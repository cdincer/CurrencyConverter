package com.cdincer.currencyconverter.entity;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class CurrencyConversion {

    public CurrencyConversion(long id, String homeCurrency, String targetCurrency, double amount) {
        this.id = id;
        this.homeCurrency = homeCurrency;
        this.targetCurrency = targetCurrency;
        this.amount = amount;
        setTimeofday();

    }
    public CurrencyConversion()
    {

    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private  long id;

    @Column(name="home_currency")
    private String homeCurrency;

    @Column(name="target_currency")
    private String targetCurrency;

    @Column(name="amount")
    private double amount;

    @Column(name="timeofday")
    private String  timeofday;

    public long getId() {
        return id;
    }

    public String getHomeCurrency() {
        return homeCurrency;
    }

    public void setHomeCurrency(String homeCurrency) {
        this.homeCurrency = homeCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getTimeofday() {
        return timeofday;
    }

    public void setTimeofday() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        this.timeofday = formatter.format(date);
    }

}
