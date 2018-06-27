package com.wyh.web.es.entity;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Parent;

import javax.persistence.Id;

@Document(indexName = OrderDocument.INDEX, type = OrderDocument.DETAIL_TYPE, shards = 10, replicas = 2, refreshInterval = "-1")
public class DetailOrderDocument {
    
    
    @Id
    private String id;
    
    // 指定主订单关联的父子关系
    @Field(type = FieldType.Auto, store = true)
    @Parent(type = OrderDocument.ORDER_TYPE)
    private String parentId;
    
    
    // 子订单价格
    @Field(type = FieldType.Long)
    private Long price;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getParentId() {
        return parentId;
    }
    
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    
    public Long getPrice() {
        return price;
    }
    
    public void setPrice(Long price) {
        this.price = price;
    }
}