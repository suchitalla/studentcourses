package com.suchi.studentcourses.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class  Course{

    @Id
    long id;
    @Column
    String name;

    public long getId(){ return id;}
    public void setId(long id){ this.id = id;}

    public String getName(){return name;}
    public void setName(){this.name = name;}




}