package com.jerome.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class md5UtilImpl {
    private static MessageDigest md5 = null;
    static {
        try {
            md5 = MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException nsaex) {
            nsaex.printStackTrace();
            //log.output("error" , "初始化失败，MessageDigest不支持MD5Util");
        }
    }

    //@Override
    public static String Encryption (String Content) {
        try {
            byte[] b = Content.getBytes();
            byte[] digest = md5.digest(b);
            char[] chars = new char[] { '0', '1', '2', '3', '4', '5', '6', '7' , '8', '9', 'A', 'B', 'C', 'D', 'E','F' };
            StringBuffer sb = new StringBuffer();
            for (byte bb : digest) {
                sb.append(chars[(bb >> 4) & 15]);
                sb.append(chars[bb & 15]);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            //log.output("Error" , "MD5加密失败，Encryption抛出了异常");
            return "";
        }
    }
}
