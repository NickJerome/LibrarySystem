package com.jerome.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface mysqlUtil {
    /*
     * 获取数据库连接
     * @return
     */
    public Connection getConnection ();

    /*
     * 通用增删改
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
    public boolean executeUpdate (String sql , List<Object> params) throws SQLException;

    /*
     * 查询单个项目 [反射实现]
     * @param sql
     * @param params
     * @param cls
     * @return
     * @throws Exception
     */
    public <T> List<T> findMoreRefResult (String sql , List<Object>params , Class<T> cls) throws Exception;

    /*
     * 查询多个项目 [反射实现]
     * @param sql
     * @param params
     * @param cls
     * @return
     * @throws Exception
     */
    public <T> T findSimpleRefResult (String sql , List<Object> params , Class<T> cls) throws Exception;

    /*
     * 释放数据库连接
     */
    public void releaseConn();
}
