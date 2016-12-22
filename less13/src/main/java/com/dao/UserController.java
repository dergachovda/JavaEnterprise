package com.dao;

import com.models.UsersEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class UserController {
    public static void main(String[] args) {
        EntityManagerFactory newPersistenceUnit = Persistence
                .createEntityManagerFactory("NewPersistenceUnit");
        EntityManager entityManager = newPersistenceUnit.createEntityManager();
        Query nativeQuery = entityManager
                .createNativeQuery("SELECT * FROM users", UsersEntity.class);
        List resultList = nativeQuery.getResultList();
        System.out.println("resultList = " + resultList);
    }
}
