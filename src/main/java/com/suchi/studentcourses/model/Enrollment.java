package com.suchi.studentcourses.model;

import jakarta.persistence.*;

@Entity
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "enrollment_generator")
    @SequenceGenerator(name="enrollment_generator", sequenceName = "enroll_seq",
                    initialValue = 10,
                    allocationSize=50)
    long eid;
    @Column
    long sid;
    @Column
    long cid;

    public Enrollment() {
    }

    public Enrollment( long sid, long cid) {
        this.sid = sid;
        this.cid = cid;
    }

    public long getEid() {
        return eid;
    }

//    public void setEid(long eid) {
//        this.eid = eid;
//    }

    public long getSid() {
        return sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }




}
