package com.utils.con_mysql;

import java.sql.*;
import java.util.Vector;

public class con_mysql {

    // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/sx?useSSL=false";
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PWD = "root";

    public Vector<Vector<Object>> getresult(String sql, String seg[]) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Vector<Vector<Object>> data = new Vector<>();
        try{

            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 通过DriverManager获取数据库链接
            conn = DriverManager.getConnection(DB_URL,USER,PWD);

            // 通过conn创建执行对象，执行查询
            stmt = conn.createStatement();
            if(sql.contains("insert") || sql.contains("update")|| sql.contains("delete")) {
                stmt.executeUpdate(sql);
            }else {
                rs = stmt.executeQuery(sql);
            }

            // 展开结果集数据库
            if (rs != null) {
                while(rs.next()){
                    // 通过字段检索
                    Vector<Object> rowVector = new Vector<>();
                    for (String se: seg) {
                        rowVector.add(rs.getString(se));
                    }
                    data.add(rowVector);
                }
                rs.close();
            }

            // 完成后关闭
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
//        System.out.println("==========================");
//        for (Vector<Object> d: data) {
//            System.out.println(d);
//        }
//        System.out.println("==========================");
        return data;
    }

    public static void main(String[] args) {

    }
}