package com.dtl.common.bean.base;

import lombok.Data;

import java.io.Serializable;

/**
 * 前台传参格式
 *
 * @author LBZ
 */
@Data
public class BaseRequestData implements Serializable {

    private String service_provider;

    private String height;

    private String timestamp;

    private String platform;

    private String app_version;

    private String network_type;

    private String session_token;

    private String phone_model;

    private String width;

}