package com.devarifkhan.jpa_one_to_one_uni.dao;

import com.devarifkhan.jpa_one_to_one_uni.entity.Instructor;

public interface AppDAO  {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);
}
