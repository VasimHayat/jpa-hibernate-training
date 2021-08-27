package com.jpa.app.service;


import com.jpa.app.entity.EOAddress;
import com.jpa.app.entity.EOCity;
import com.jpa.app.entity.EOPerson;
import com.jpa.app.factory.GlbEntityManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Date;

public class TransactionService {
   private static EntityManager entityManager = GlbEntityManagerFactory.entityManager();

    public static EntityTransaction getTransaction(){
        return entityManager.getTransaction();
    }

    public static EOPerson addPerson(String name, Date dob){
        EOPerson eoPerson = new EOPerson(name,dob);
        getTransaction().begin();
        entityManager.persist(eoPerson);
        getTransaction().commit();
        return eoPerson;
    }

    public static void deletePerson(long primaryKey){
        getTransaction().begin();
        EOPerson eoPerson = entityManager.find(EOPerson.class,primaryKey);
        if(eoPerson !=null){
            entityManager.remove(eoPerson);
        }
        getTransaction().commit();
    }

    public static EOPerson assignAddressToPerson(long personPk, EOAddress eoAddress) throws Exception {
         EOPerson person = entityManager.find(EOPerson.class,personPk);
         if(person == null){
             throw  new Exception("No Person found ");
         }
         eoAddress.eoPerson =person;
         person.eoAddressArray.add(eoAddress);

         getTransaction().begin();
         entityManager.persist(person);
         getTransaction().commit();
        return eoAddress.eoPerson;
    }

    public static EOAddress addAddress(String addrStr,EOCity eoCity){
        EOAddress eoAddress = new EOAddress(addrStr);
        eoAddress.eoCity =eoCity;
       // getTransaction().begin();
       // entityManager.persist(eoAddress);
       // getTransaction().commit();
        return eoAddress;
    }

    public static void deleteAddress(long primaryKey){
        getTransaction().begin();
        EOAddress eoAddress = entityManager.find(EOAddress.class,primaryKey);
        if(eoAddress !=null){
            entityManager.remove(eoAddress);
        }
        getTransaction().commit();
    }

    public static EOCity addCity(String name,String pinCode){
        EOCity city = new EOCity(name,pinCode);
        getTransaction().begin();
        entityManager.persist(city);
        getTransaction().commit();
        return city;
    }

    public static void deleteCity(long primaryKey){
        getTransaction().begin();
        EOCity city = entityManager.find(EOCity.class,primaryKey);
        if(city !=null){
            entityManager.remove(city);
        }
        getTransaction().commit();
    }

    public static EOAddress addCityToAddress(long addressPk,EOCity city) throws Exception {
        EOAddress address = entityManager.find(EOAddress.class,addressPk);
        if(address == null){
            throw  new Exception("No Address found ");
        }
        address.eoCity = city;

        getTransaction().begin();
        entityManager.persist(address);
        //entityManager.persist(eoCity);
        getTransaction().commit();
        return address;
    }



}
