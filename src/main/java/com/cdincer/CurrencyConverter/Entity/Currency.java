package com.cdincer.CurrencyConverter.Entity;

import javax.persistence.Entity;

public class Currency {

    private final long id;
    private final String content;

    public Currency(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}