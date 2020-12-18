package com.jerome.dao;

import com.jerome.bean.libraryInfo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class libraryDao {
    public static boolean insert (libraryInfo info) {
        String sql = "INSERT INTO `library`(`id`, `name`, `address`, `manager`) VALUES (NULL,?,?,?)";

        List<Object> params = new ArrayList<Object>();
        params.add(info.getName());
        params.add(info.getAddress());
        params.add(info.getManager());

        try {
            return mysqlDao.getMysqlutil().executeUpdate(sql , params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean delete (Object field , Object where) {
        String sql = "DELETE FROM `library` where " + field + " = ?";

        List<Object> params = new ArrayList<Object>();
        params.add(where);

        try {
            return mysqlDao.getMysqlutil().executeUpdate(sql , params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean update (libraryInfo info) {
        String sql = "UPDATE `library` SET `id`=?,`name`=?,`address`=?,`manager`=? WHERE id = ?";

        List<Object> params = new ArrayList<Object>();
        params.add(info.getId());
        params.add(info.getName());
        params.add(info.getAddress());
        params.add(info.getManager());
        params.add(info.getId());

        try {
            return mysqlDao.getMysqlutil().executeUpdate(sql , params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static libraryInfo findSimplelibrary (int id) {
        String sql = "select * from library where id = ?";

        List<Object> params = new ArrayList<Object>();
        params.add(id);

        try {
            return mysqlDao.getMysqlutil().findSimpleRefResult(sql , params , libraryInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<libraryInfo> findAlllibrary () {
        String sql = "select * from library";

        try {
            return mysqlDao.getMysqlutil().findMoreRefResult(sql , null , libraryInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}