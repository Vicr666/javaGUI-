package com.Dao;

public class UserDao {
    private String commnuity_id;
    private String house_id;
    private String username;
    private String money;
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCommnuity_id() {
        return commnuity_id;
    }

    public void setCommnuity_id(String commnuity_id) {
        this.commnuity_id = commnuity_id;
    }

    public String getHouse_id() {
        return house_id;
    }

    public void setHouse_id(String house_id) {
        this.house_id = house_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
