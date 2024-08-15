package com.devarifkhan.aspect_oriented_programming.dao;

import com.devarifkhan.aspect_oriented_programming.Account;

public interface AccountDAO {

    void addAccount(Account theAccount,boolean vipFlag);

    boolean doWork();


    public String getName() ;

    public void setName(String name);

    public String getServiceCode() ;

    public void setServiceCode(String serviceCode) ;
}
