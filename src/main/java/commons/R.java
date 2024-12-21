package commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;

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

    /*返回成功登录的方法有参数*/
    public static <T> R<T> success(T data) {

        R<T> r = new R<>();
        r.setMsg("success");
        r.setCode(200);
        r.setData(data);
        return r;
    }

    /*返回成功的方法没有参数*/
    public static <T> R<T> success() {
        R<T> r = new R<>();
        r.setMsg("success");
        r.setCode(200);
        r.setData(null);
        return r;
    }

    /*返回成功的方法没有参数*/
    public static <T> R<T> success(T data, String msg) {
        R<T> r = new R<>();
        r.setMsg(msg);
        r.setCode(200);
        r.setData(data);
        return r;
    }

    /*返回失败的方法*/
    public static <T> R<T> failed() {
        R<T> r = new R<>();
        r.setMsg("failed");
        r.setCode(500);
        r.setData(null);
        return r;
    }

    public static <T> R<T> failed(String msg) {
        R<T> r = new R<>();
        r.setMsg(msg);
        r.setCode(500);
        r.setData(null);
        return r;
    }

    public static <T> R<T> failed(Integer code, String msg){
        R<T> r = new R<>();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(null);
        return r;
    }

    public static R ok(){
        R r = new R();
        r.code=200;
        r.msg="成功";
        return r;
    }

    public static <T> R ok(String msg){
        R r = new R();
        r.code=200;
        r.msg=msg;
        return r;
    }

    public static <T> R ok(T data){
        R r = new R();
        r.code=200;
        r.msg="成功";
        r.data=data;
        return r;
    }

    public static <T> R ok(String msg,T data){
        R r = new R();
        r.code=200;
        r.msg=msg;
        r.data=data;
        return r;
    }

    public static R error(){
        R r = new R();
        r.code=-1;
        r.msg="失败";
        return r;
    }

    public static R error(String msg){
        R r = new R();
        r.code=-1;
        r.msg=msg;
        return r;
    }

    public R addData(String key,Object value){
        if (this.data==null){
            this.data=(T)new HashMap<>();
            ((HashMap<String,Object>)this.data).put(key,value);
        }else if (this.data instanceof HashMap){
            ((HashMap<String,Object>)this.data).put(key,value);
        }else {
            throw new RuntimeException("R结果集设置错误");
        }
        return this;
    }

}
