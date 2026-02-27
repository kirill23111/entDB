package com.example.entDB.repository;

import com.example.entDB.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        return entityManager
                .createQuery("""
                        select p
                        from Person p
                        where lower(p.cityOfLiving) = lower(:city)
                        """, Person.class)
                .setParameter("city", city)
                .getResultList();
    }
}