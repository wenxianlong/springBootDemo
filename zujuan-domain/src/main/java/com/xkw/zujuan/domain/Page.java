package com.xkw.zujuan.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页信息
 *
 * @author wenxianlong
 * @date 2019-08-16
 */
@Data
public class Page implements Serializable {

    /**
     * 默认页数
     */
    private static final Integer PAGE_NO_DEFAULT = 1;

    /**
     * 默认每页显示数量
     */
    private static final Integer PAGE_SIZE_DEFAULT = 10;

    /**
     * 页数
     */
    private int pageNo;

    /**
     * 每页显示数量
     */
    private int pageSize;

    /**
     * 起始值
     */
    private int start;

    /**
     * 总页数
     */
    private int totalPages;

    /**
     * 总记录数
     */
    private long totalCount;

    public Page() {
        this.pageNo = PAGE_NO_DEFAULT;
        this.pageSize = PAGE_SIZE_DEFAULT;
        this.start = (this.pageNo - 1) * this.pageSize;
    }
}
