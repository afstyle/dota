package com.huanghao.util;

import com.huanghao.enums.ErrorEnum;
import com.huanghao.exception.DotaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 抛出异常的工具类
 * @author HuangHao
 * @date 2021/8/12 15:03
 */
public class AssertUtil {

    final static Logger logger = LoggerFactory.getLogger(AssertUtil.class);

    public static void assertTrue(Boolean condition) {
        assertTrue(condition, ErrorEnum.COMMON_ERROR);
    }
    public static void assertTrue(Boolean condition, String message) {
        if (condition) {
            logger.error("[assertTrue] message={}", message);
            throw new DotaException(ErrorEnum.COMMON_ERROR, message);
        }
    }
    public static void assertTrue(Boolean condition, ErrorEnum errorEnum) {
        if (condition) {
            logger.error("[assertTrue] message={}", errorEnum.getMessage());
            throw new DotaException(errorEnum);
        }
    }
}
