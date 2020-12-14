package com.jerome.dao;

import com.jerome.bean.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class bookDao {
    /*
     * 图书的数据库操作类
     * 增删改查
     */



    public static boolean insert (bookInfo info) {
        String sql = "INSERT INTO `book` (`Id`, `ISBN`, `Name`, `Type`, `Exist`, `Price`, `Author`) VALUES (NULL,?,?,?,?,?,?)";

        List<Object> params = new ArrayList<Object>();
        params.add(info.getISBN());
        params.add(info.getName());
        params.add(info.getType());
        params.add(info.getExist());
        params.add(info.getPrice());
        params.add(info.getAuthor());

        try {
            return mysqlDao.getMysqlutil().executeUpdate(sql , params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean delete (Object field , Object where) {
        String sql = "DELETE FROM `book` where " + field + " = ?";

        List<Object> params = new ArrayList<Object>();
        params.add(where);

        try {
            return mysqlDao.getMysqlutil().executeUpdate(sql , params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean update (bookInfo info) {
        String sql = "UPDATE `book` SET `id`=?,`ISBN`=?,`name`=?,`type`=?,`exist`=?,`price`=?,`author`=? WHERE id = ?";

        List<Object> params = new ArrayList<Object>();
        params.add(info.getId());
        params.add(info.getISBN());
        params.add(info.getName());
        params.add(info.getType());
        params.add(info.getExist());
        params.add(info.getPrice());
        params.add(info.getAuthor());
        params.add(info.getId());

        try {
            return mysqlDao.getMysqlutil().executeUpdate(sql , params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static bookInfo findSimpleBook (int id) {
        String sql = "select * from book where id = ?";

        List<Object> params = new ArrayList<Object>();
        params.add(id);

        try {
            return mysqlDao.getMysqlutil().findSimpleRefResult(sql , params , bookInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<bookInfo> findAllBook () {
        String sql = "select * from book";

        try {
            return mysqlDao.getMysqlutil().findMoreRefResult(sql , null , bookInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
