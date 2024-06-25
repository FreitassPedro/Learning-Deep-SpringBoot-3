package com.pedro.cruddemo.dao;

import com.pedro.cruddemo.entity.Instructor;


public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteById(int id);
}
