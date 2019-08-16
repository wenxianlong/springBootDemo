package com.xkw.zujuan.domain.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 人员实体
 *
 * @author wenxianlong
 * @date 2019-08-14
 */
@Data
@Document(indexName = "test", type = "person", refreshInterval = "-1")
public class Person implements Serializable {

    @Id
    private Integer id;

    @Field(type = FieldType.Text, searchAnalyzer = "ik", analyzer = "ik")
    private String name;

    @Field(type = FieldType.Long)
    private Integer age;

    @Field(type = FieldType.Text, index = false)
    private String address;

    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    private Date birthDay;
}
