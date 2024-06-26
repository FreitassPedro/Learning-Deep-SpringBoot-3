package com.pedro.cruddemo.dao;

import com.pedro.cruddemo.entity.Course;
import com.pedro.cruddemo.entity.Instructor;
import com.pedro.cruddemo.entity.InstructorDetail;
import com.pedro.cruddemo.entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppleDAOImpl implements AppDAO {
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
    public void deleteInstructorById(int id) {
        // Não podemos simplesmente apagar o instrutor, antes evemos alterar cada curso associado a ele.
        Instructor instructorById = findInstructorById(id);
        List<Course> courses = instructorById.getCourses();

        courses.forEach(cors -> cors.setInstructor(null));

        entityManager.remove(instructorById);
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

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i "
                        + "JOIN FETCH i.courses "
                       // Opcional + "JOIN FETCH i.instructorDetail "
                        + "where i.id = :id", Instructor.class);

        query.setParameter("id", id);
        Instructor instructor = query.getSingleResult();

        return instructor;
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        entityManager.remove(findCourseById(id));
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewByCourseId(int id) {
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c "
                + "JOIN FETCH c.reviews "
                + "where c.id = :id", Course.class
        );

        query.setParameter("id", id);

        Course course = query.getSingleResult();

        return course;
    }
}
