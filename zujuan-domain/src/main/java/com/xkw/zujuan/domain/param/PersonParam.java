package com.xkw.zujuan.domain.param;

import lombok.Data;

/**
 * 查询用户的参数配置
 *
 * @author wenxianlong
 * @date 2019-08-15
 */
@Data
public class PersonParam {

    private String name;

    private Integer id;

    private Integer age;

    private Integer pageNo;

    private Integer pageSize;

    private String sort;
}
