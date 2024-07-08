package com.suchi.studentcourses.service;

import com.suchi.studentcourses.model.Course;
import com.suchi.studentcourses.model.Enrollment;
import com.suchi.studentcourses.model.Student;
import com.suchi.studentcourses.repo.CourseRepository;
import com.suchi.studentcourses.repo.EnrollmentRepository;
import com.suchi.studentcourses.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentCourseService {

@Autowired
StudentRepository st;
    @Autowired
    CourseRepository cr;

    @Autowired
    EnrollmentRepository er;




    public List<Student> retrieveAllStudents(){
        return (List<Student>) st.findAll();

    }
    public Student retrieveStudent(long studentId){

                if(st.findById(studentId).isPresent())
                    return st.findById(studentId).get();
                else
                    return null;
    }
    public List<Course> retrieveAllCourses(){
        return (List<Course>) cr.findAll();

    }
    public Course retrieveCourse(long courseId){

        if(cr.findById(courseId).isPresent())
            return cr.findById(courseId).get();
        else
            return null;
    }
    public Course retrieveEnrolledCourse(long studentId, long courseId){
    List<Enrollment> erlist = er.findDistinctBySidAndCid(studentId,courseId);
        if( erlist != null && erlist.size() ==1 && cr.findById(courseId).isPresent())
            return cr.findById(courseId).get();
        else
            return new Course();
    }

    public Enrollment addCourse(long studentId, String course){
        if(!st.findById(studentId).isPresent() || cr.findByName(course) == null){
            return new Enrollment();
        }
        else {
            Student stud = st.findById(studentId).get();
            Course newCourse = cr.findByName(course);
            Enrollment erObj = new Enrollment(studentId, newCourse.getId());
            return er.save(erObj);

        }
    }


    public List<Enrollment> deleteEnrollment(long studentId, String course){

        if(!st.findById(studentId).isPresent() || cr.findByName(course) == null){
           List<Enrollment> enlist  = new ArrayList<Enrollment>();
            enlist.add(new Enrollment());
            return enlist;
        }
        else {
            Student stud = st.findById(studentId).get();
            Course newCourse = cr.findByName(course);
            List<Enrollment> enrObj = er.findDistinctBySidAndCid(studentId, newCourse.getId());
            er.deleteAll(enrObj);
            return enrObj;

        }
    }

}
