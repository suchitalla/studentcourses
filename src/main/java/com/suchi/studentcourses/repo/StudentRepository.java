package com.suchi.studentcourses.repo;

import com.suchi.studentcourses.model.Student;
import org.springframework.data.repository.CrudRepository;

public  interface StudentRepository extends CrudRepository<Student,Long> {


}
