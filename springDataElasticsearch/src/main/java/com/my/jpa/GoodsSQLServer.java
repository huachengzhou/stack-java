package com.my.jpa;

/**
 * @author noatn
 * @description
 * @date 2023-08-02
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 * Goods实体对象
 */
@Data
@Accessors(chain = true)   // 链式赋值(连续set方法)
@AllArgsConstructor        // 全参构造
@NoArgsConstructor         // 无参构造
// 指定当前类对象对应哪个ES中的索引
// 如果索引不存在
@Document(indexName = "goods")
public class GoodsSQLServer {


    /**
     * 商品编号
     */
    @Id
    @Field(type = FieldType.Long)
    private Long id;

    /**
     * 商品标题
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String title;

    /**
     * 商品价格
     */
    @Field(type = FieldType.Double)
    private BigDecimal price;

    /**
     * 商品库存
     */
    @Field(type = FieldType.Integer)
    private Integer stock;

    /**
     * 商品销售数量
     */
    @Field(type = FieldType.Integer)
    private Integer saleNum;

    /**
     * 商品分类
     */
    @Field(type = FieldType.Keyword)
    private String categoryName;

    /**
     * 商品品牌
     */
    @Field(type = FieldType.Keyword)
    private String brandName;

    /**
     * 上下架状态
     */
    @Field(type = FieldType.Integer)
    private Integer status;

    /**
     * sqlServer 只能是Date
     * 商品创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;



}

