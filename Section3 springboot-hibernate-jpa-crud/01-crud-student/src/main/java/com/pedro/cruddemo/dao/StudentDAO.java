package com.pedro.cruddemo.dao;

import com.pedro.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);
}
