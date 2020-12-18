package com.jerome.dao;

import com.jerome.bean.permissionInfo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class permissionDao {
    public static boolean insert (permissionInfo info) {
        String sql = "INSERT INTO `permission`(`id`, `type`, `person`) VALUES (NULL,?,?)";

        List<Object> params = new ArrayList<Object>();
        params.add(info.getType());
        params.add(info.getPerson());

        try {
            return mysqlDao.getMysqlutil().executeUpdate(sql , params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean delete (Object field , Object where) {
        String sql = "DELETE FROM `permission` where " + field + " = ?";

        List<Object> params = new ArrayList<Object>();
        params.add(where);

        try {
            return mysqlDao.getMysqlutil().executeUpdate(sql , params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean update (permissionInfo info) {
        String sql = "UPDATE `permission` SET `id`=?,`type`=?,`person`=? WHERE id = ?";

        List<Object> params = new ArrayList<Object>();
        params.add(info.getId());
        params.add(info.getType());
        params.add(info.getPerson());
        params.add(info.getId());

        try {
            return mysqlDao.getMysqlutil().executeUpdate(sql , params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static permissionInfo findSimplepermission (int id) {
        String sql = "select * from permission where id = ?";

        List<Object> params = new ArrayList<Object>();
        params.add(id);

        try {
            return mysqlDao.getMysqlutil().findSimpleRefResult(sql , params , permissionInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<permissionInfo> findAllpermission () {
        String sql = "select * from permission";

        try {
            return mysqlDao.getMysqlutil().findMoreRefResult(sql , null , permissionInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
