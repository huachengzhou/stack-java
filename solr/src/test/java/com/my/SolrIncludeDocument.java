package com.my;

import cn.hutool.json.JSONUtil;
import com.solr.entity.Dept;
import com.solr.entity.Emp;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.UpdateRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SolrIncludeDocument {
    //include_document.xml

    final String coreName = "include_document";
    //设置solr客户端url地址
    final String solrUrl = "http://localhost:8983/solr";


    @Test
    public void testDeleteAll() throws Exception {
        HttpSolrClient solrClient = getHttpSolrClient();
        UpdateRequest updateRequest = new UpdateRequest();
        List<String> deleteQuery = new ArrayList<>(1);
        deleteQuery.add("*:*");
        updateRequest.setDeleteQuery(deleteQuery);
        updateRequest.commit(solrClient, coreName);
    }

    /**
     * 获取部门
     *
     * @throws Exception
     */
    @Test
    public void testFindParent() throws Exception {
        HttpSolrClient solrClient = getHttpSolrClient();
        SolrQuery solrQuery = new SolrQuery("{!parent which=docParent:isParent}");
        //包含like
//        solrQuery.set("fq","dept_dname:*开发*") ;
        solrQuery.set("fq", "dept_dname:开发");
        QueryResponse queryResponse = solrClient.query(coreName, solrQuery);
        SolrDocumentList documents = queryResponse.getResults();
        for (SolrDocument solrDocument : documents) {
            //获取的 child是空的
            List<SolrDocument> documentList = solrDocument.getChildDocuments();
            System.out.println(JSONUtil.toJsonStr(solrDocument));
        }
    }

    /**
     * 获取员工
     *
     * @throws Exception
     */
    @Test
    public void testFindChildRen() throws Exception {
        HttpSolrClient solrClient = getHttpSolrClient();
        SolrQuery solrQuery = new SolrQuery("{!child of=docParent:isParent}");
        solrQuery.set("fq", "dept_uuid:c396f183-2af2-4e18-a213-fb0e2b96a3f8");
        solrQuery.setRows(20);
        solrQuery.setStart(0);
        QueryResponse queryResponse = solrClient.query(coreName, solrQuery);
        SolrDocumentList documents = queryResponse.getResults();
        for (SolrDocument solrDocument : documents) {
            System.out.println(JSONUtil.toJsonStr(solrDocument));
        }
    }

    @Test
    public void testAdd() throws IOException, SolrServerException {
        HttpSolrClient solrClient = getHttpSolrClient();
        List<Dept> depts = selectAll();
        //迭代每一个部门
        for (Dept dept : depts) {
            //每个部门转化为一个Document
            System.out.println(dept);
            SolrInputDocument deptDocument = new SolrInputDocument();
            deptDocument.setField("id", dept.getUuid());
            deptDocument.setField("dept_dname", dept.getDname());
            deptDocument.setField("dept_loc", dept.getLoc());
            deptDocument.setField("docParent", "isParent");
            //获取每个部门的员工。
            List<SolrInputDocument> inputDocuments = findSolrInputEmpSByDeptByUuid(dept.getUuid());
            //建立父子关系的API方法。
            deptDocument.addChildDocuments(inputDocuments);
            solrClient.add(coreName, deptDocument);
        }

        //4.提交
        solrClient.commit(coreName, true, true);
        solrClient.close();
    }

    private List<SolrInputDocument> findSolrInputEmpSByDeptByUuid(String uuid) {
        List<Emp> empList = findEmpSByDeptByUuid(uuid);
        if (CollectionUtils.isEmpty(empList)) {
            return new ArrayList<>(0);
        }
        List<SolrInputDocument> solrInputDocuments = new ArrayList<>(empList.size());
        for (Emp emp : empList) {
            SolrInputDocument document = new SolrInputDocument();
            document.setField("id", emp.getUuid());
            document.setField("dept_uuid", emp.getDeptUuid());
            document.setField("emp_ename", emp.getEname());
            document.setField("emp_job", emp.getJob());
            document.setField("emp_mgr", emp.getMgr());
            document.setField("emp_hiredate", emp.getHiredate());
            document.setField("emp_sal", emp.getSal());
            document.setField("emp_comm", emp.getComm());
            document.setField("emp_cv", emp.getCv());
            solrInputDocuments.add(document);
        }
        return solrInputDocuments;
    }

    private List<Emp> findEmpSByDeptByUuid(String deptUuid) {
        List<Emp> empList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Emp emp = new Emp();
            emp.setDeptUuid(deptUuid);
            emp.setUuid(UUID.randomUUID().toString());
            emp.setCv(RandomStringUtils.random(10));
            emp.setEname("员工-" + RandomStringUtils.random(10));
            emp.setComm(RandomStringUtils.randomNumeric(10));
            emp.setJob(RandomStringUtils.random(10));
            emp.setHiredate(RandomStringUtils.random(10));
            emp.setSal(RandomStringUtils.randomNumeric(10));
            emp.setMgr(RandomStringUtils.random(10));
            empList.add(emp);
        }
        return empList;
    }

    private List<Dept> selectAll() {
        List<Dept> deptList = new ArrayList<>();
        String[] strings = "开发部门,财务部门,行政部门".split(",");
        for (int i = 0; i < strings.length; i++) {
            Dept dept = new Dept();
            dept.setLoc(RandomStringUtils.random(5));
            dept.setDname(strings[i]);
            dept.setDepto(RandomStringUtils.random(5));
            dept.setUuid(UUID.randomUUID().toString());
            deptList.add(dept);
        }
        return deptList;
    }

    private HttpSolrClient getHttpSolrClient() {
        return new HttpSolrClient.Builder(solrUrl)
                .build();
    }
}
