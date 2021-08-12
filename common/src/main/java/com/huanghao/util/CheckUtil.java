package com.huanghao.util;

import com.huanghao.enums.ErrorEnum;

/**
 * @author HuangHao
 * @date 2021/8/12 15:01
 */
public class CheckUtil {

    public static void checkPassword(String passwordDb, String password) {
        AssertUtil.assertTrue(!passwordDb.equals(password), ErrorEnum.PASSWORD_ERROR);
    }
}
