package com.pedro.cruddemo.dao;

import com.pedro.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);
    List<Student> findAll();

    List<Student> findByLastName(String theLastName);
}
