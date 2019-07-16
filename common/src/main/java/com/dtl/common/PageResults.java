package com.dtl.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * github.pagehelper
 * 分页获取数据
 *
 * @author LBZ
 */
@Data
public class PageResults implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 返回每页的数据的集合
     */
    private List<?> list;
    /**
     * 最大页
     */
    private long totalPage;
    /**
     * 总条数
     */
    private long totalRow;
}