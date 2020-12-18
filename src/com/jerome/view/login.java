package com.jerome.view;

import com.jerome.service.*;

import java.util.Scanner;

public class login {
    public static void main (String[] argv) {
        Scanner sc = new Scanner();

        init(sc);
    }

    public void init (Scanner sc) {
        while (true) {
            System.out.println("---------------图书馆管理系统--------------");
            System.out.println("【1】登录系统");
            System.out.println("【2】退出系统");
            System.out.println("----------------------------------------");


            if (sc.nextInt() == 1) {
                loginInit();
            } else {
                return ;
            }
        }
    }

    public void loginInit (Scanner sc) {
        System.out.println("请输入账号：");
        String userName = sc.nextLine();
        System.out.println("请输入密码：");
        String passWord = sc.nextLine();

        if (userService.login(userName,passWord)) {

        } else {
            loginInit();
        }
    }
}
