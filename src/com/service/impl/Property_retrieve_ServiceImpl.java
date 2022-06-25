package com.service.impl;

import com.utils.con_mysql.con_mysql;

import java.util.Vector;

public class Property_retrieve_ServiceImpl {
    private String sql;
    private String[] str= {"commnuity_id","house_id","username", "money"};
    private Vector<Vector<Object>> data;

    public Property_retrieve_ServiceImpl(String key) {
         sql = "select * from propertyfees where username like " + '"' + key + "%"+ '"';
        System.out.println(sql);
         data = new con_mysql().getresult(sql, str);
    }

    public Vector<Vector<Object>> getData() {
        return data;
    }
}
