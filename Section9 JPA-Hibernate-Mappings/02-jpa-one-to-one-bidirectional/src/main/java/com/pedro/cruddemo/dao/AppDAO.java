package com.pedro.cruddemo.dao;

import com.pedro.cruddemo.entity.Instructor;
import com.pedro.cruddemo.entity.InstructorDetail;


public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteById(int id);

    InstructorDetail findInstructorDetailByiD(int id);
    void deleteInstructorDetailById(int id);
}
