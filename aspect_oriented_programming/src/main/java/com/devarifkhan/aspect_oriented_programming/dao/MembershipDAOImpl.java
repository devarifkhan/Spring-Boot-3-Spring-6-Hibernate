package com.devarifkhan.aspect_oriented_programming.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{
    @Override
    public boolean addSillyMember() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN MEMBERSHIP ACCOUNT");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + ": I'm going to sleep now...");
    }
}
