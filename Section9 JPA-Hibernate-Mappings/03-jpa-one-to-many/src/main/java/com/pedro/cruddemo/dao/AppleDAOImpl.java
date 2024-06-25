package com.pedro.cruddemo.dao;

import com.pedro.cruddemo.entity.Instructor;
import com.pedro.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppleDAOImpl implements AppDAO{
    private EntityManager entityManager;

    public AppleDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
       return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        entityManager.remove(findInstructorById(id));
    }

    @Override
    public InstructorDetail findInstructorDetailByiD(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        entityManager.remove(findInstructorDetailByiD(id));
    }
}
