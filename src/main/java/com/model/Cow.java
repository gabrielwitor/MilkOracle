package com.model;

import org.bson.codecs.pojo.annotations.BsonProperty;

public class Cow {
    @BsonProperty(value="eartag") // unico para cada vaca
    private String eartag;
    
    @BsonProperty(value="name")
    private String name;
    
    @BsonProperty(value="breed")
    private String breed;

    public Cow(){}
    
    public Cow(String eartag, String name, String breed){
        this.eartag = eartag;
        this.name = name;
        this.breed = breed;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getEartag() {
        return eartag;
    }

    public void setEartag(String eartag) {
        this.eartag = eartag;
    }

        
}
