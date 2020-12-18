package com.jerome.service;

import com.jerome.bean.*;
import com.jerome.dao.*;
import com.jerome.util.md5UtilImpl;

public class userService {
    private static userInfo LoginUserInfo = null;

    public static boolean login (String userName , String passWord) {
       LoginUserInfo = userDao.findSimpleUser("userName" , userName);
       try {
           if (md5UtilImpl.Encryption(passWord).equals(LoginUserInfo.getPassWord())) {
               return true;
           }
       } catch (NullPointerException e) {
           //TODO
       }
       return false;
    }
}
