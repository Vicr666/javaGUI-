package com.service.impl;

import com.Dao.UserDao;
import com.utils.con_mysql.con_mysql;

import java.util.Vector;


public class Repair_add_ServiceImpl {

    private String commnuity_id;
    private String house_id;
    private String username;
    private String info;


    private String sql;
    private String[] str;
    private Vector<Vector<Object>> data;

    public Repair_add_ServiceImpl(UserDao userDao) {

        this.commnuity_id = userDao.getCommnuity_id();
        this.house_id = userDao.getHouse_id();
        this.username = userDao.getUsername();
        this.info = userDao.getInfo();
        sql = "insert  into  repairmanage  values('"+commnuity_id+"','"+house_id+"','"+username+"','"+info+"')";
        System.out.println(sql);
        str = new String[]{"commnuity_id", "house_id", "username", "info"};
        new con_mysql().getresult(sql, str);
        String sql2 = "insert  into  repair_total  values('"+commnuity_id+"','"+house_id+"','"+username+"','"+info+"')";
        new con_mysql().getresult(sql2, str);
        data = new Repair_retrieve_ServiceImpl("").getData();
    }

    public Vector<Vector<Object>> getData() {
        return data;
    }
}