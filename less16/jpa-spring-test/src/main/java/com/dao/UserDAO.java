package com.dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class UserDAO {

    @PersistenceContext(name = "persistenceJpaTest")
    private EntityManager entityManager;


//    public List<UsersEntity> getAllUsers() {
//        return entityManager.createQuery("select u from UsersEntity u").
//                getResultList();
//
//    }

    public List getAllUsers() {
        return entityManager.createQuery("select u from UsersEntity u").
                getResultList();
    }

}
