package com.jpa.app.entity;

import javax.persistence.*;

@Entity
public class EOAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long primaryKey;

    public String addressStr;

    @OneToOne
    @JoinColumn(name = "EOCityID",nullable = false)
    public EOCity eoCity;

    @ManyToOne()
    @JoinColumn(name = "EOPersonID")
    public EOPerson eoPerson;

    public EOAddress(String addressStr){
        this();
        this.addressStr =addressStr;
    }

    public EOAddress() { }

    public Long primaryKey(){
        return this.primaryKey;
    }


    @Override
    public String toString() {
        return "EOAddress{" +
                "primaryKey=" + primaryKey +
                ", addressStr='" + addressStr + '\'' +
                '}';
    }
}
