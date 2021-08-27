package com.jpa.app.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GlbEntityManagerFactory {

    private static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPA_PU");

    private static EntityManager entityManagerInstance = null;

   public static EntityManager entityManager(){
        if(entityManagerInstance == null){
            entityManagerInstance = emFactory.createEntityManager();
        }
        return entityManagerInstance;
   }

}
