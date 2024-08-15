package com.devarifkhan.aspect_oriented_programming.dao;

import com.devarifkhan.aspect_oriented_programming.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{


    private String name;

    private String serviceCode;


    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public void addAccount(Account theAccount,boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": DOING MY WORK");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        if(tripWire){
            throw new RuntimeException("Tripwire is on. Cannot retrieve accounts");
        }


        List<Account> myAccounts= new ArrayList<>();
        Account account1= new Account("john","Silver");
        Account account2= new Account("jane","Gold");
        Account account3= new Account("Arif","Platinum");

        myAccounts.add(account1);
        myAccounts.add(account2);
        myAccounts.add(account3);
        return myAccounts;
    }
}
