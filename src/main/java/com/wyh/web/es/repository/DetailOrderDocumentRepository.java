package com.wyh.web.es.repository;

import com.wyh.web.es.entity.DetailOrderDocument;
import org.apache.lucene.search.Sort;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface DetailOrderDocumentRepository extends ElasticsearchRepository<DetailOrderDocument, String> {
    
    
    List<DetailOrderDocument> findByParentId(String parentId, Sort sort);
    
    DetailOrderDocument findDetailOrderDocumentById(String id);
}