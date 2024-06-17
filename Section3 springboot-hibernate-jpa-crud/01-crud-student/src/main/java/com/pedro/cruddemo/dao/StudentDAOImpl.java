package com.pedro.cruddemo.dao;

import com.pedro.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
    // define campos para entity manager

    private EntityManager entityManager;
    // injeta entity manager usando constrcutor

    @Autowired // opcional
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    // implementa save method

    @Transactional
    @Override
    public void save(Student student) {
        entityManager.persist(student);
    }
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create query, order by EntityField
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        // return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student WHERE lastName=:theData", Student.class);

        // set query parameters
        theQuery.setParameter("theData", theLastName);

        // return query
        return theQuery.getResultList();

    }

    @Transactional
    @Override
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        // retrieve the student
        Student theStudent = entityManager.find(Student.class, id);
        if (theStudent != null) entityManager.remove(theStudent);
    }

    @Transactional
    @Override
    public int deleteAll() {
        int numRowsDeleted = entityManager.
                createQuery("DELETE FROM Student")
                .executeUpdate();
        return numRowsDeleted;
    }
}
