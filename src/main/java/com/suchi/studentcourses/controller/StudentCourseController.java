package com.suchi.studentcourses.controller;

import com.suchi.studentcourses.model.Course;
import com.suchi.studentcourses.model.Enrollment;
import com.suchi.studentcourses.model.Student;
import com.suchi.studentcourses.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/SCS")
public class StudentCourseController {

@Autowired
    StudentCourseService scs;

    @GetMapping("/students")
    public List<Student> getStudents(){
        return scs.retrieveAllStudents();
    }
    @GetMapping("/students/{id}")
    public Student getStudents(@PathVariable("id") long studentId){
        return scs.retrieveStudent(studentId);
    }

    @GetMapping("/courses")
    public List<Course> getCourses(){
        return scs.retrieveAllCourses();
    }
    @GetMapping("/courses/{id}")
    public Course getCourses(@PathVariable("id") long id){
        return scs.retrieveCourse(id);
    }

    @GetMapping("/students/{id1}/courses/{id2}")
    public Course getEnrolledCourses(@PathVariable("id1") long studentid,@PathVariable("id2") long courseid){
        return scs.retrieveEnrolledCourse(studentid,courseid);
    }

    @PostMapping("/students/{id}")
    public Enrollment addStudent(@PathVariable("id") long studentid, @RequestBody String cs){
        return scs.addCourse(studentid,cs);
    }

    @DeleteMapping("/students/{id}")
    public List<Enrollment> removeCourse(@PathVariable("id") long studentid, @RequestBody String cs){
        return scs.deleteEnrollment(studentid,cs);
    }
}
