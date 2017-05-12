package com.wechat.common.util;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 返回统一结果信息
 * Created by hztps on 2017/5/12.
 */
public class ResultResponse {

    /**
     * 返回成功结果
     *
     * @param msg
     * @param result
     * @return
     */
    public static Object success(String msg, Object result) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 1);
        jsonObject.put("msg", msg);
        jsonObject.put("result", result);

        return jsonObject.toJSONString(jsonObject, SerializerFeature.WriteMapNullValue);
    }

    /**
     * 返回错误结果
     *
     * @param msg
     * @return
     */
    public static Object error(String msg) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("msg", msg);

        return jsonObject.toJSONString();
    }
}
