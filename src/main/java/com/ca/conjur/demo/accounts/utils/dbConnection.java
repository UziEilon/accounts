package com.ca.conjur.demo.accounts.utils;

import com.ca.conjur.demo.accounts.objects.account;
import com.ca.conjur.demo.accounts.objects.accounts;

import java.sql.*;

import java.util.*;

public class dbConnection {

    Connection conn=null;
    public dbConnection(String ip,String user,String pass) {
        getConnection(ip,user,pass);
    }

    public void closeConnection()
    {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void getConnection(String ip,String user,String pass)
    {
        String addr = ip;
        String dbName="conjurdemo";
         String url = "jdbc:postgresql://"+addr+":5432/"+dbName;
        Properties props = new Properties();
        props.setProperty("user",user);
        props.setProperty("password",pass);
        props.setProperty("ssl","false");
        try {
            conn = DriverManager.getConnection(url, props);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    

    public accounts getAccounts()
    {
        accounts a = new accounts();

        Statement st = null;
        TreeMap<String,String> tokens = new TreeMap();
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from accounts");
            while (rs.next())
            {
                String user = rs.getString(1);
                String phone = rs.getString(2);
                a.addAccount(new account(user,phone.toString()));
            }
            rs.close();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }


}
