package com.service.impl;

import com.utils.con_mysql.con_mysql;

import java.util.Vector;


public class Repair_retrieve_ServiceImpl {
    private String sql;
    private String[] str= {"commnuity_id","house_id","username", "info"};
    private Vector<Vector<Object>> data;

    public Repair_retrieve_ServiceImpl(String key) {
        sql = "select *  from repairmanage where username like " + '"' + key + "%"+ '"';
        System.out.println(sql);
        data = new con_mysql().getresult(sql, str);
    }

    public Vector<Vector<Object>> getData() {
        return data;
    }
}