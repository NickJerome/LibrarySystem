package com.jerome.dao;

import com.jerome.bean.administratorInfo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class administratorDao {
    public static boolean insert (administratorInfo info) {
        String sql = "INSERT INTO `administrator`(`id`, `name`, `telephone`, `email`) VALUES (NULL,?,?,?)";

        List<Object> params = new ArrayList<Object>();
        params.add(info.getName());
        params.add(info.getTelephone());
        params.add(info.getEmail());

        try {
            return mysqlDao.getMysqlutil().executeUpdate(sql , params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean delete (Object field , Object where) {
        String sql = "DELETE FROM `administrator` where " + field + " = ?";

        List<Object> params = new ArrayList<Object>();
        params.add(where);

        try {
            return mysqlDao.getMysqlutil().executeUpdate(sql , params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean update (administratorInfo info) {
        String sql = "UPDATE `administrator` SET `id`=?,`name`=?,`telephone`=?,`email`=? WHERE id = ?";

        List<Object> params = new ArrayList<Object>();
        params.add(info.getId());
        params.add(info.getName());
        params.add(info.getTelephone());
        params.add(info.getEmail());
        params.add(info.getId());

        try {
            return mysqlDao.getMysqlutil().executeUpdate(sql , params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static administratorInfo findSimpleadministrator (int id) {
        String sql = "select * from administrator where id = ?";

        List<Object> params = new ArrayList<Object>();
        params.add(id);

        try {
            return mysqlDao.getMysqlutil().findSimpleRefResult(sql , params , administratorInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<administratorInfo> findAlladministrator () {
        String sql = "select * from administrator";

        try {
            return mysqlDao.getMysqlutil().findMoreRefResult(sql , null , administratorInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
