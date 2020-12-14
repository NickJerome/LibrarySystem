package com.jerome.dao;

import com.jerome.bean.userInfo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class userDao {
    /*
     * 用户的数据库操作类
     * 增删改查
     */



    public static boolean insert (userInfo info) {
        String sql = "INSERT INTO `user`(`id`, `userName`, `passWord`) VALUES (NULL,?,?)";

        List<Object> params = new ArrayList<Object>();
        params.add(info.getUserName());
        params.add(info.getPassWord());

        try {
            return mysqlDao.getMysqlutil().executeUpdate(sql , params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean delete (Object field , Object where) {
        String sql = "DELETE FROM `user` where " + field + " = ?";

        List<Object> params = new ArrayList<Object>();
        params.add(where);

        try {
            return mysqlDao.getMysqlutil().executeUpdate(sql , params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean update (userInfo info) {
        String sql = "UPDATE `user` SET `id`=?,`userName`=?,`passWord`=? WHERE id = ?";

        List<Object> params = new ArrayList<Object>();
        params.add(info.getId());
        params.add(info.getUserName());
        params.add(info.getPassWord());
        params.add(info.getId());

        try {
            return mysqlDao.getMysqlutil().executeUpdate(sql , params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static userInfo findSimpleUser (int id) {
        String sql = "select * from user where id = ?";

        List<Object> params = new ArrayList<Object>();
        params.add(id);

        try {
            return mysqlDao.getMysqlutil().findSimpleRefResult(sql , params , userInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<userInfo> findAllUser () {
        String sql = "select * from user";

        try {
            return mysqlDao.getMysqlutil().findMoreRefResult(sql , null , userInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
