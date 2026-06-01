package cn.edu.ctbu.thymeleaf02.core;


public enum ResultCode {


    SUCCESS(0,"操作成功"),
    ERROR(500,"系统内部错误"),

    BAD_REQUEST(400,"bad request"),
    UNAUTHORIZED(401,"unauthorized"),
    FORBIDDEN(403,"forbidden"),
    NOT_FOUND(404,"not found"),

    USER_NOT_EXIST(1001,"user not exist"),
    USER_LOCKED(1002,"user locked"),
    FILE_UPLOAD_ERROR(2001,"file upload error"),
    ;

      private final Integer code;
      private final String msg;

      ResultCode(Integer code, String msg) {
          this.code = code;
          this.msg = msg;
      }

      public Integer getCode() {
          return code;
      }
      public String getMsg() {
          return msg;
      }






}
