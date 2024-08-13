package com.devarifkhan.jpa_one_to_one_uni.dao;

import com.devarifkhan.jpa_one_to_one_uni.entity.Instructor;
import com.devarifkhan.jpa_one_to_one_uni.entity.InstructorDetail;

public interface AppDAO  {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailsById(int theId);

    void deleteInstructorDetailById(int theId);
}
