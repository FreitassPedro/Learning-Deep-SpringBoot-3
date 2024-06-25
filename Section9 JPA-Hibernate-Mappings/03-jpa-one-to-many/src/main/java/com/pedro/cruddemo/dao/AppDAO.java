package com.pedro.cruddemo.dao;

import com.pedro.cruddemo.entity.Course;
import com.pedro.cruddemo.entity.Instructor;
import com.pedro.cruddemo.entity.InstructorDetail;

import java.util.List;


public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteById(int id);

    InstructorDetail findInstructorDetailByiD(int id);
    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);
}
