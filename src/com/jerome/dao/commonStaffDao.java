package com.jerome.dao;

import com.jerome.bean.commonStaffInfo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class commonStaffDao {
    public static boolean insert (commonStaffInfo info) {
        String sql = "INSERT INTO `commonstaff`(`id`, `name`, `sex`, `telephone`) VALUES (NULL,?,?,?)";

        List<Object> params = new ArrayList<Object>();
        params.add(info.getName());
        params.add(info.getSex());
        params.add(info.getTelephone());

        try {
            return mysqlDao.getMysqlutil().executeUpdate(sql , params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean delete (Object field , Object where) {
        String sql = "DELETE FROM `commonstaff` where " + field + " = ?";

        List<Object> params = new ArrayList<Object>();
        params.add(where);

        try {
            return mysqlDao.getMysqlutil().executeUpdate(sql , params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean update (commonStaffInfo info) {
        String sql = "UPDATE `commonstaff` SET `id`=?,`name`=?,`sex`=?,`telephone`=? WHERE id = ?";

        List<Object> params = new ArrayList<Object>();
        params.add(info.getId());
        params.add(info.getName());
        params.add(info.getSex());
        params.add(info.getTelephone());
        params.add(info.getId());

        try {
            return mysqlDao.getMysqlutil().executeUpdate(sql , params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static commonStaffInfo findSimpleCommonStaff (int id) {
        String sql = "select * from commonstaff where id = ?";

        List<Object> params = new ArrayList<Object>();
        params.add(id);

        try {
            return mysqlDao.getMysqlutil().findSimpleRefResult(sql , params , commonStaffInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<commonStaffInfo> findAllCommonStaff () {
        String sql = "select * from commonstaff";

        try {
            return mysqlDao.getMysqlutil().findMoreRefResult(sql , null , commonStaffInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
