package com.wyh.web.es.entity;


import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;

@Document(indexName = OrderDocument.INDEX, type = OrderDocument.ORDER_TYPE, refreshInterval = "-1")
public class OrderDocument {
    
    public static final String INDEX = "orders-test";
    public static final String ORDER_TYPE = "order-document";
    public static final String DETAIL_TYPE = "order-detail-document";
    
    
    @Id
    private String id;
    
    // 订单备注，不需要分词，可以搜索
    @Field(index = false)
    private String note;
    
    // 订单名称，可以通过ik 分词器进行分词
    @Field(searchAnalyzer = "ik", analyzer = "ik")
    private String name;
    
    
    // 订单价格
    @Field(type = FieldType.Long)
    private Long price;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getNote() {
        return note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Long getPrice() {
        return price;
    }
    
    public void setPrice(Long price) {
        this.price = price;
    }
}
