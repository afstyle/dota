package com.huanghao.util;

import cn.hutool.json.JSONUtil;

import java.util.List;

/**
 * @author HuangHao
 */
public class JsonUtil {


    /**
     * 将对象转换成json字符串。
     * @param data
     * @return
     */
    public static String objectToJson(Object data) {
        return JSONUtil.toJsonStr(data);
    }
    
    /**
     * 将json结果集转化为对象
     * 
     * @param jsonData json数据
     * @param beanType 对象中的object类型
     * @return
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = JSONUtil.toBean(jsonData, beanType);
            return t;
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 将json数据转换成pojo对象list
     * @param jsonData
     * @param beanType
     * @return
     */
    public static <T>List<T> jsonToList(String jsonData, Class<T> beanType) {
    	try {
            List<T> list = JSONUtil.toList(jsonData, beanType);
    		return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
    
}
