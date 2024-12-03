package com.model;

import org.bson.codecs.pojo.annotations.BsonProperty;


public class Production {

    @BsonProperty(value="date")
    private String date;

    @BsonProperty(value="cow")
    private Cow cow;

    @BsonProperty(value="liters")
    private Double liters;

    public Production(){}

    public Production(String date, Cow cow, Double liters) {
        this.date = date;
        this.cow = cow;
        this.liters = liters;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Cow getCow() {
        return cow;
    }

    public void setCow(Cow cow) {
        this.cow = cow;
    }

    public Double getLiters() {
        return liters;
    }

    public void setLiters(Double liters) {
        this.liters = liters;
    }
}
