package com.jerome.dao;

import com.jerome.bean.categoryInfo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class categoryDao {

    public static boolean insert (categoryInfo info) {
        String sql = "INSERT INTO `category`(`id`, `name`) VALUES (NULL,?)";

        List<Object> params = new ArrayList<Object>();
        params.add(info.getName());

        try {
            return mysqlDao.getMysqlutil().executeUpdate(sql , params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean delete (Object field , Object where) {
        String sql = "DELETE FROM `category` where " + field + " = ?";

        List<Object> params = new ArrayList<Object>();
        params.add(where);

        try {
            return mysqlDao.getMysqlutil().executeUpdate(sql , params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean update (categoryInfo info) {
        String sql = "UPDATE `category` SET `id`=?,`name`=? WHERE id = ?";

        List<Object> params = new ArrayList<Object>();
        params.add(info.getId());
        params.add(info.getName());
        params.add(info.getId());

        try {
            return mysqlDao.getMysqlutil().executeUpdate(sql , params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static categoryInfo findSimpleCategory (int id) {
        String sql = "select * from category where id = ?";

        List<Object> params = new ArrayList<Object>();
        params.add(id);

        try {
            return mysqlDao.getMysqlutil().findSimpleRefResult(sql , params , categoryInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<categoryInfo> findAllCategory () {
        String sql = "select * from category";

        try {
            return mysqlDao.getMysqlutil().findMoreRefResult(sql , null , categoryInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
