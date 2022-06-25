package com.service.impl;

import com.Dao.UserDao;
import com.utils.con_mysql.con_mysql;

import java.util.Vector;

public class Property_update_ServiceImpl {

    private String commnuity_id;
    private String house_id;
    private String username;
    private String money;


    private String sql;
    private String[] str;
    private Vector<Vector<Object>> data;

    public Property_update_ServiceImpl(UserDao userDao) {

        this.commnuity_id = userDao.getCommnuity_id();
        this.house_id = userDao.getHouse_id();
        this.username = userDao.getUsername();
        this.money = userDao.getMoney();
        sql = "update propertyfees  set " + "commnuity_id=" + commnuity_id + "," +
                "money=" + money + "," + "username=" + '"'+ username +'"' +" where house_id=" + house_id;
        System.out.println(sql);
        str = new String[]{house_id};
        new con_mysql().getresult(sql, str);
        data = new Property_retrieve_ServiceImpl("").getData();
    }

    public Vector<Vector<Object>> getData() {
        return data;
    }
}