package com.jpa.app.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class EOPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long primaryKey;

    public String name;

    @Temporal(TemporalType.DATE)
    public Date dob;

    @OneToMany(mappedBy = "eoPerson", cascade = CascadeType.PERSIST)
    public Set<EOAddress> eoAddressArray = new HashSet<EOAddress>();

    public EOPerson(String name,Date dob){
        this();
        this.name = name;
        this.dob = dob;
    }

    public EOPerson(){ }

    public Long primaryKey(){
        return  this.primaryKey;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + primaryKey +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}
