package com.wyh.web;

import com.taojin.commons.utils.beans.BeanMapper;
import com.wyh.web.entity.Employee;
import com.wyh.web.es.EsEmployeeDao;
import com.wyh.web.es.entity.DetailOrderDocument;
import com.wyh.web.es.entity.EsEmployee;
import com.wyh.web.es.entity.EsUserInfo;
import com.wyh.web.es.entity.OrderDocument;
import com.wyh.web.es.repository.DetailOrderDocumentRepository;
import com.wyh.web.es.repository.EsEmployeeRepository;
import com.wyh.web.es.repository.EsUserInfoRepository;
import com.wyh.web.repository.EmployeeRepository;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;


@SpringBootApplication
@RestController
//@Import(ElasticSearchFactory.class)
public class ElasticsearchController {
    
    
//    @Resource
//    ElasticSearch elasticSearch;
    
    @Resource
    EmployeeRepository employeeRepository;
    
    @Resource
    EsEmployeeRepository esEmployeeRepository;
    
    @Resource
    EsUserInfoRepository esUserInfoRepository;
    
    @Resource
    DetailOrderDocumentRepository detailOrderDocumentRepository;
    
    @Autowired(required=false)
    EsEmployeeDao esEmployeeDao;
    
    //单一查询
    @GetMapping("/es")
    @ResponseBody
    public ResponseEntity getEefundorder(@RequestParam(name = "id", defaultValue = "1") String id) throws Exception {
        if (id.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        
        Map<String, Object> resultMap = null;//elasticSearch.get("employee,userinfo", "doc", id);
        return new ResponseEntity(resultMap, HttpStatus.OK);
    }
    
    //单一查询
    @GetMapping("/employee")
    @ResponseBody
    public ResponseEntity getEmployee(@RequestParam(name = "id", defaultValue = "1") String id) throws Exception {
        
        
        Employee employee = employeeRepository.queryEmployeeById(id);
        EsEmployee esEmployee = esEmployeeRepository.queryEmployeeById(id);
        
        return new ResponseEntity(ToStringBuilder.reflectionToString(employee) + "\n" + ToStringBuilder.reflectionToString(esEmployee), HttpStatus.OK);
    }
    
    
    //单一查询
    @GetMapping("/saveEmployee")
    @ResponseBody
    public ResponseEntity saveEmployee(@RequestParam(name = "id", defaultValue = "1") String id) throws Exception {
    
    
   
        Employee employee = new Employee();
        employee.setAddress("Address");
        employee.setLastName("lastName");
        employee.setFirstName("firstName");
        employee.setAge(12);
        employeeRepository.save(employee);
    
        EsEmployee esEmployee = new EsEmployee();
        BeanMapper.copy(employee, esEmployee);

        //esEmployeeDao.insert(esEmployee);
        esEmployeeRepository.save(esEmployee);
    
        EsUserInfo userInfo=new EsUserInfo();
        userInfo.setId(employee.getId());
        userInfo.setPassword("123223");
        userInfo.setRealname("lastName");
        userInfo.setUsername("wyh");
        
        esUserInfoRepository.save(userInfo);
        
        return new ResponseEntity(ToStringBuilder.reflectionToString(employee) + "\n" + ToStringBuilder.reflectionToString(esEmployee), HttpStatus.OK);
    }
    
    
    //单一查询
    @GetMapping("/saveOrderDocument")
    @ResponseBody
    public ResponseEntity saveOrderDocument(@RequestParam(name = "id", defaultValue = "1") String id) throws Exception {
    
        OrderDocument orderDocument=new OrderDocument();
        orderDocument.setName("orderDocumentName");
        orderDocument.setNote("orderDocumentNote");
        orderDocument.setPrice(1000l);
    
        DetailOrderDocument detailOrderDocument=new DetailOrderDocument();
        detailOrderDocument.setPrice(2000l);
        
        detailOrderDocumentRepository.save(detailOrderDocument);
        
        return new ResponseEntity(ToStringBuilder.reflectionToString(orderDocument) + "\n" + ToStringBuilder.reflectionToString(detailOrderDocument), HttpStatus.OK);
    }
    
    //单一查询
    @GetMapping("/delteOrderDocument")
    @ResponseBody
    public String delteOrderDocument(@RequestParam(name = "id", defaultValue = "1") String id) throws Exception {
        

        detailOrderDocumentRepository.deleteAll();
        
        return "SUCCESS";
    }
}
