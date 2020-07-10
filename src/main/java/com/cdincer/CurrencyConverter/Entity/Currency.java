package com.cdincer.CurrencyConverter.Entity;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Currency {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="home_currency")
    private String home_currency;

    @Column(name="target_currency")
    private String target_currency;

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



    public Currency(long id, String home_currency,String target_currency,String result) {
        this.id = id;
        this.home_currency = home_currency;
        this.target_currency = target_currency;
        this.result = result;
        setTimeofday();
    }

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
}