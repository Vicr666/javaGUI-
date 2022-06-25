package com.service.impl;

import com.Dao.UserDao;
import com.Handler.Property.add_PropertyHandler;
import com.utils.con_mysql.con_mysql;

import java.util.Vector;

public class Property_add_ServiceImpl {

    private String commnuity_id;
    private String house_id;
    private String username;
    private String money;


    private String sql;
    private String[] str;
    private Vector<Vector<Object>> data;

    public Property_add_ServiceImpl(UserDao userDao) {

        this.commnuity_id = userDao.getCommnuity_id();
        this.house_id = userDao.getHouse_id();
        this.username = userDao.getUsername();
        this.money = userDao.getMoney();
        sql = "insert  into  propertyfees  values('"+commnuity_id+"','"+house_id+"','"+username+"','"+money+"')";
        System.out.println(sql);
        str = new String[]{commnuity_id, house_id, username, money};
        new con_mysql().getresult(sql, str);
        String sql2 = "insert  into  Charge_total  values('"+commnuity_id+"','"+house_id+"','"+username+"','"+money+"')";
        new con_mysql().getresult(sql2, str);
        data = new Property_retrieve_ServiceImpl("").getData();
        for(Vector<Object>d : data){
            System.out.println(d);
        }
    }

    public Vector<Vector<Object>> getData() {
        return data;
    }
}
