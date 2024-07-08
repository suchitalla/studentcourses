package com.suchi.studentcourses.repo;

import com.suchi.studentcourses.model.Enrollment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EnrollmentRepository extends CrudRepository<Enrollment,Long> {

//    @Query("Select eid from ENROLLMENT where sid= ?1 and cid = ?2")
//    public long exists(long studentId,long courseId);

    public List<Enrollment> findDistinctBySidAndCid(long sid,long cid);

}
