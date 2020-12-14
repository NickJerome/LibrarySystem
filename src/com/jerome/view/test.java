package com.jerome.view;

import com.jerome.dao.*;
import com.jerome.bean.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class test {
    public static String upperFirstWord (String word) {
        char[] arr = word.toCharArray();
        if(arr[0]>='a' && arr[0]<='z'){
            arr[0] = (char) (arr[0]-32);
        }
        return new String(arr);
    }

    public static void main (String[] args) {
        /*bookInfo info = new bookInfo();
        info.setISBN("9787519456788");
        info.setName("家人闲坐，灯火可亲");
        info.setType("中国现当代随笔");
        info.setExist(2);
        info.setPrice(37.90);
        info.setAuthor("汪曾祺");*/

        //bookDao.insert(info);
        //System.out.println(bookDao.update(info));
        //System.out.println(bookDao.delete("id" , "5"));

        /*
         * 通过反射输出所有字段
         */
        /*try {
            Field[] fields = bookInfo.class.getDeclaredFields();
            List<bookInfo> infos = bookDao.findAllBook();
            for (int j = 0 ; j < infos.size() ; ++j) {
                for (int i = 0 ; i < fields.length ; ++i) {
                    String methodName = "get" + upperFirstWord(fields[i].getName());

                    Method m = bookInfo.class.getMethod(methodName);
                    System.out.println("[" + fields[i].getName() + "]" + m.invoke(infos.get(j)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/


        try {
            Field[] fields = curatorInfo.class.getDeclaredFields();
            List<curatorInfo> infos = curatorDao.findAllCurator();
            for (int j = 0 ; j < infos.size() ; ++j) {
                for (int i = 0 ; i < fields.length ; ++i) {
                    String methodName = "get" + upperFirstWord(fields[i].getName());

                    Method m = curatorInfo.class.getMethod(methodName);
                    System.out.println("[" + fields[i].getName() + "]" + m.invoke(infos.get(j)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
