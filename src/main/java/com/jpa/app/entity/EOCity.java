package com.jpa.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EOCity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long primaryKey;
    public String name;
    public String pinCode;

    public EOCity(){}
    public EOCity(String name,String pinCode){
        this.name = name;
        this.pinCode =pinCode;
    }

}
