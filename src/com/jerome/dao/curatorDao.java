package com.jerome.dao;

import com.jerome.bean.curatorInfo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class curatorDao {
    
    public static boolean insert (curatorInfo info) {
        String sql = "INSERT INTO `curator`(`id`, `name`, `sex`, `telephone`, `email`) VALUES (NULL,?,?,?,?)";

        List<Object> params = new ArrayList<Object>();
        params.add(info.getName());
        params.add(info.getSex());
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
        String sql = "DELETE FROM `curator` where " + field + " = ?";

        List<Object> params = new ArrayList<Object>();
        params.add(where);

        try {
            return mysqlDao.getMysqlutil().executeUpdate(sql , params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean update (curatorInfo info) {
        String sql = "UPDATE `curator` SET `id`=?,`name`=?,`sex`=?,`telephone`=?,`email`=? WHERE id = ?";

        List<Object> params = new ArrayList<Object>();
        params.add(info.getId());
        params.add(info.getName());
        params.add(info.getSex());
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

    public static curatorInfo findSimpleCurator (int id) {
        String sql = "select * from curator where id = ?";

        List<Object> params = new ArrayList<Object>();
        params.add(id);

        try {
            return mysqlDao.getMysqlutil().findSimpleRefResult(sql , params , curatorInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<curatorInfo> findAllCurator () {
        String sql = "select * from curator";

        try {
            return mysqlDao.getMysqlutil().findMoreRefResult(sql , null , curatorInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
