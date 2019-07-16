package com.dtl.common.bean.response;

/**
 * dtl返参格式
 *
 * @author LBZ
 */
public class ResponseStatus {

    private int status;
    private String name;

    private ResponseStatus(int status, String name) {
        this.status = status;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }

}
