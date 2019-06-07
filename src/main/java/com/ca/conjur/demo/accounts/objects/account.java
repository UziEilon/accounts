package com.ca.conjur.demo.accounts.objects;

public class account {

    String name;
    String phone;

    public account(String name,String phone)
    {
        this.name = name;
        this.phone = phone;
    }
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

}
