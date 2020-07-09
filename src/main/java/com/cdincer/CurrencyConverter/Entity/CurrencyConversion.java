package com.cdincer.CurrencyConverter.Entity;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class CurrencyConversion {

    public CurrencyConversion(long id, String home_currency,String target_currency,double amount) {
        this.id = id;
        this.home_currency = home_currency;
        this.target_currency = target_currency;
        this.amount = amount;
        setTimeofday();

    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private final long id;

    @Column(name="home_currency")
    private String home_currency;

    @Column(name="target_currency")
    private String target_currency;

    @Column(name="amount")
    private double amount;

    @Column(name="timeofday")
    private String  timeofday;

    public long getId() {
        return id;
    }

    public String getHome_currency() {
        return home_currency;
    }

    public void setHome_currency(String home_currency) {
        this.home_currency = home_currency;
    }

    public String getTarget_currency() {
        return target_currency;
    }

    public void setTarget_currency(String target_currency) {
        this.target_currency = target_currency;
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
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        this.timeofday = formatter.format(date);
    }

}
