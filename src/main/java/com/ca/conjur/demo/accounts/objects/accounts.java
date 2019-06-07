package com.ca.conjur.demo.accounts.objects;

import java.util.LinkedList;

public class accounts {

    public accounts()
    {}

    LinkedList<account> accounts = new  LinkedList<account>();

    public void addAccount(account a) {
        accounts.add(a);
    }

    public  LinkedList<account>  getAccounts() {
        return accounts;
    }
}
