package com.gxa.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @AllArgsConstructor : 也是lombok提供的注释，表示自动生成全参的构造方法
 * @NoArgsConstuctor :: 自动生成空参的构造方法
 * 在类中通常用T声明一个泛型
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class R<T> implements Serializable {

    private Integer code; //返回数据类型中的状态码
    private String msg; //返回数据类型中的消息
    private T data;


    /**
     * 创建一个成功的响应对象，并设置返回的数据
     *
     * @param <T>  泛型类型，表示返回的数据类型
     * @param data 要返回的数据
     * @return 包含成功信息的响应对象
     */
    public static <T> R<T> success(T data) {

        R<T> r = new R<>();
        r.setMsg("success");
        r.setCode(200);
        r.setData(data);
        return r;
    }


    /**
     * 创建一个默认的成功响应对象
     *
     * @param <T>  泛型类型
     * @return 默认的成功响应对象
     */
    public static <T> R<T> success() {
        R<T> r = new R<>();
        r.setMsg("success");
        r.setCode(200);
        r.setData(null);
        return r;
    }


    /**
     * 创建一个默认的失败响应对象
     *
     * @param <T>  泛型类型
     * @return 默认的失败响应对象
     */
    public static <T> R<T> failed() {
        R<T> r = new R<>();
        r.setMsg("failed");
        r.setCode(500);
        r.setData(null);
        return r;
    }

    /**
     * 创建一个失败的响应对象
     *
     * @param <T>  泛型类型
     * @param msg  错误信息
     * @return 失败的响应对象
     */
    public static <T> R<T> failed(String msg) {
        R<T> r = new R<>();
        r.setMsg(msg);
        r.setCode(500);
        r.setData(null);
        return r;
    }

    /**
     * 创建一个失败的响应对象
     *
     * @param <T>   泛型类型
     * @param code  错误码
     * @param msg   错误信息
     * @return 包含错误信息的响应对象
     */
    public static <T> R<T> failed(Integer code, String msg){
        R<T> r = new R<>();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(null);
        return r;
    }

}
