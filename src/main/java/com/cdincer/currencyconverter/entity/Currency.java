package com.cdincer.currencyconverter.entity;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Currency {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="home_currency")
    private String homeCurrency;

    @Column(name="target_currency")
    private String targetCurrency;

    @Column(name="timeofday")
    private String  timeofday;

    @Column(name="result")
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTimeofday() {
        return timeofday;
    }

    public void setTimeofday() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        this.timeofday = formatter.format(date);
    }



    public Currency(long id, String homeCurrency, String targetCurrency, String result) {
        this.id = id;
        this.homeCurrency = homeCurrency;
        this.targetCurrency = targetCurrency;
        this.result = result;
        setTimeofday();
    }

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
}