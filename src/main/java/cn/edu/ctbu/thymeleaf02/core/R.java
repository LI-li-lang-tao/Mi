package cn.edu.ctbu.thymeleaf02.core;


import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
public class R<T> {




    private Integer code;
    private String msg;
    private T data;


    private Long count;


    private R()  {}


    public static <T> R<T> ok() {

        return new R<T>().setCode(ResultCode.SUCCESS.getCode()).setMsg(ResultCode.SUCCESS.getMsg());
    }

    public static <T> R<T> ok(T data) {
       return R.<T>ok().setData(data);
    }


    public static <T> R<T> ok(String msg, T data){
        return R.<T>ok().setMsg(msg).setData(data);
    }


    //失效响应
    public static <T> R<T> error() {
        return new R<T>().setCode(ResultCode.ERROR.getCode()).setMsg(ResultCode.ERROR.getMsg());
    }

    public static <T> R<T> error(String msg) {
        return new R<T>().setCode(ResultCode.ERROR.getCode()).setMsg(msg);
    }

    public static <T> R<T> error(Integer code, String msg) {
        return new R<T>().setCode(code).setMsg(msg);
    }
    public static <T> R<T> error(ResultCode  resultCode) {
        return new R<T>().setCode(resultCode.getCode()).setMsg(resultCode.getMsg()) ;

    }



    public static <E> R<List<E>> page(Long count , List<E> data){
        return R.<List<E>>ok()
                .setCount(count)
                .setData(data);
    }



}
