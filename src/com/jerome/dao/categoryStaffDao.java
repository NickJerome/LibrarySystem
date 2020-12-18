package com.jerome.dao;

import com.jerome.bean.categoryStaffInfo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class categoryStaffDao {
    public static boolean insert (categoryStaffInfo info) {
        String sql = "INSERT INTO `categorystaff`(`id`, `name`, `sex`, `telephone`, `bookid`, `contact`) VALUES (NULL,?,?,?,?,?)";

        List<Object> params = new ArrayList<Object>();
        params.add(info.getName());
        params.add(info.getSex());
        params.add(info.getTelephone());
        params.add(info.getBookid());
        params.add(info.getContact());

        try {
            return mysqlDao.getMysqlutil().executeUpdate(sql , params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean delete (Object field , Object where) {
        String sql = "DELETE FROM `categoryStaff` where " + field + " = ?";

        List<Object> params = new ArrayList<Object>();
        params.add(where);

        try {
            return mysqlDao.getMysqlutil().executeUpdate(sql , params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean update (categoryStaffInfo info) {
        String sql = "UPDATE `categorystaff` SET `id`=?,`name`=?,`sex`=?,`telephone`=?,`bookid`=?,`contact`=? WHERE id = ?";

        List<Object> params = new ArrayList<Object>();
        params.add(info.getId());
        params.add(info.getName());
        params.add(info.getSex());
        params.add(info.getTelephone());
        params.add(info.getBookid());
        params.add(info.getContact());
        params.add(info.getId());

        try {
            return mysqlDao.getMysqlutil().executeUpdate(sql , params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static categoryStaffInfo findSimpleCategoryStaff (int id) {
        String sql = "select * from categoryStaff where id = ?";

        List<Object> params = new ArrayList<Object>();
        params.add(id);

        try {
            return mysqlDao.getMysqlutil().findSimpleRefResult(sql , params , categoryStaffInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<categoryStaffInfo> findAllCategoryStaff () {
        String sql = "select * from categoryStaff";

        try {
            return mysqlDao.getMysqlutil().findMoreRefResult(sql , null , categoryStaffInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
