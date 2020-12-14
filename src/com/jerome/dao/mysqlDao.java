package com.jerome.dao;

import com.jerome.util.mysqlUtllImpl;

import java.sql.Connection;

public class mysqlDao {
    private static final mysqlUtllImpl mysqlutil = new mysqlUtllImpl();
    private static final Connection conn = mysqlutil.getConnection();

    public static mysqlUtllImpl getMysqlutil () {
        return mysqlutil;
    }

    public static Connection getMysqlConnection () {
        return conn;
    }
}
