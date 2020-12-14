package com.jerome.util;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mysqlUtllImpl implements mysqlUtil {
    //数据库驱动
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    //数据库用户名
    private static final String USERNAME = "root";
    //数据库密码
    private static final String PASSWORD = "123456";
    //数据库地址
    private static final String URL = "jdbc:mysql://localhost:3306/library?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Shanghai";

    private Connection connection = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public mysqlUtllImpl() {
        try {
            Class.forName(DRIVER);
        } catch (Exception e) {

        }
    }

    /*
     * 获取数据库连接
     */
    public Connection getConnection () {
        try {
            connection = DriverManager.getConnection(URL , USERNAME , PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /*
     * 增删改
     */
    public boolean executeUpdate (String sql , List<Object>params) throws SQLException {
        pstmt = connection.prepareStatement(sql);
        if (params != null && !params.isEmpty()) {
            for (int i = 0 ; i < params.size() ; ++i) {
                pstmt.setObject(i+1 , params.get(i));
            }
        }
        return pstmt.executeUpdate() > 0 ? true : false;
    }

    /*
     * 查询单条记录
     */

    public <T> List<T> findMoreRefResult (String sql , List<Object>params , Class<T> cls) throws Exception {
        List<T> list = new ArrayList<T>();
        pstmt = connection.prepareStatement(sql);
        if (params != null && !params.isEmpty()) {
            for (int i = 0 ; i < params.size() ; ++i) {
                pstmt.setObject(i+1 , params.get(i));
            }
        }
        rs = pstmt.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();
        int cols_len = metaData.getColumnCount();
        while(rs.next()){
            //通过反射机制创建一个实例
            T resultObject = cls.newInstance();
            for(int i = 0; i<cols_len; i++){
                String cols_name = metaData.getColumnName(i+1);
                Object cols_value = rs.getObject(cols_name);
                if(cols_value == null){
                    cols_value = "";
                }
                Field field = cls.getDeclaredField(cols_name);
                field.setAccessible(true); //打开javabean的访问权限
                field.set(resultObject, cols_value);
            }
            list.add(resultObject);
        }

        return list;
    }

    public <T> T findSimpleRefResult (String sql , List<Object> params , Class<T> cls) throws Exception {
        T resultObject = null;
        pstmt = connection.prepareStatement(sql);
        if(params != null && !params.isEmpty()){
            for(int i = 0; i<params.size(); i++){
                pstmt.setObject(i+1, params.get(i));
            }
        }
        rs = pstmt.executeQuery();
        ResultSetMetaData metaData  = rs.getMetaData();
        int cols_len = metaData.getColumnCount();
        while(rs.next()){
            //通过反射机制创建一个实例
            resultObject = cls.newInstance();
            for(int i = 0; i<cols_len; i++){
                String cols_name = metaData.getColumnName(i+1);
                Object cols_value = rs.getObject(cols_name);
                if(cols_value == null){
                    cols_value = "";
                }
                Field field = cls.getDeclaredField(cols_name);
                field.setAccessible(true); //打开javabean的访问权限
                field.set(resultObject, cols_value);
            }
        }
        return resultObject;
    }

    /*
     * 释放数据库连接
     */
    public void releaseConn(){
        if(rs != null){
            try{
                rs.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
