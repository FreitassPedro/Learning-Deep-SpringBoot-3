package com.pedro.cruddemo.dao;

import com.pedro.cruddemo.entity.Course;
import com.pedro.cruddemo.entity.Instructor;
import com.pedro.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        // Create a query
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :id", Course.class);
        query.setParameter("id", id);

        List<Course> courses = query.getResultList();

        return courses;
    }
}
