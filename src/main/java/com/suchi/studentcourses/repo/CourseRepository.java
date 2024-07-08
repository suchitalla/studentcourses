package com.suchi.studentcourses.repo;

import com.suchi.studentcourses.model.Course;
import com.suchi.studentcourses.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course,Long> {

    public Course findByName(String name);
}
