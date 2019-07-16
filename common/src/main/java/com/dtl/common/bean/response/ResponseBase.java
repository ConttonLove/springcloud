package com.dtl.common.bean.response;

import java.io.Serializable;

/**
 * dtl返参格式
 *
 * @author LBZ
 */
public class ResponseBase implements Serializable {

    public static final int STATUS_SUCCESS = 1;

    private static final long serialVersionUID = 1L;

    public static ResponseBase buildErrorResponse(int status, String message) {
        return new ResponseBase(status, message);
    }

    public static ResponseBase buildErrorResponse(ResponseStatus responseStatus) {
        return new ResponseBase(responseStatus.getStatus(), responseStatus.getName());
    }

    public static ResponseBase buildErrorResponse(String message) {
        return new ResponseBase(0, message);
    }

    public static ResponseBase buildErrorResponse(String message, Object data) {
        ResponseBase responseBase = buildErrorResponse(message);
        responseBase.setData(data);
        return responseBase;
    }

    private int status;

    private String message;

    private Object data;

    public ResponseBase() {
        this.status = 1;
        this.message = "成功";
    }

    public ResponseBase(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseBase(Object data) {
        this();
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ResponseBase [status=" + status + ", message=" + message + ", data=" + data + "]";
    }

}