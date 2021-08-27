package com.jpa.app;

import com.jpa.app.entity.EOAddress;
import com.jpa.app.entity.EOCity;
import com.jpa.app.entity.EOPerson;
import com.jpa.app.factory.GlbEntityManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.TransactionManager;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BootStrap {
    public static void main(String[] args) throws ParseException {
       EntityManager  entityManager = GlbEntityManagerFactory.entityManager();
       EntityTransaction entityTransaction = entityManager.getTransaction();

        EOPerson person = new EOPerson();
        person.name ="Adam Saleh"+Math.random();
        person.dob = new SimpleDateFormat("yyyy/MM/dd").parse("1991/12/01");
        EOAddress eoAddress = new EOAddress("A 2 Noida Sector 122");

        EOCity eoCity = new EOCity("Noida","201301");
        eoAddress.eoCity = eoCity;
        // person.eoAddress = eoAddress;
        entityTransaction.begin();
        entityManager.persist(person);
        entityManager.persist(eoCity);
        entityManager.persist(eoAddress);
        entityTransaction.commit();

        EOPerson person1 = entityManager.find(EOPerson.class,1l);

        if(person1 !=null){
            System.out.println(person1.toString());
        }

    }

}
