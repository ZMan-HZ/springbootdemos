package com.zzm.applications.mvc.beans;

import com.zzm.applications.enums.ResultCode;

/**
 * <b>Description</b>  ResultTool
 *
 * @Author Zhenzhen
 * @Since 2020-07-03 周五 13:09
 * @Info ResultTool
 */
public class ResultTool {

    public static JsonResult success() {
        return new JsonResult(true);
    }

    public static <T> JsonResult<T> success(T data) {
        return new JsonResult(true, data);
    }

    public static JsonResult fail() {
        return new JsonResult(false);
    }

    public static JsonResult fail(ResultCode resultEnum) {
        return new JsonResult(false, resultEnum);
    }
}
