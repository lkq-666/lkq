package com.wwt.wwt_crm.utils;

import org.junit.Test;

public class ShiroUtilsTest {

    @Test
    public void encryptPassword() {
        System.out.println("随机盐"+ShiroUtils.randomSalt());
    }

    @Test
    public void randomSalt() {
        System.out.println("密码"+ShiroUtils.encryptPassword("123456","admineb990ab7569b"));
    }
}