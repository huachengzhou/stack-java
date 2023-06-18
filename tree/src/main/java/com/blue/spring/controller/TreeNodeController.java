package com.blue.spring.controller;

import com.alibaba.fastjson.JSONObject;
import com.blue.dal.entity.TreeNode;
import com.blue.service.TreeNodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tool.utils.FormatUtils;
import tool.web.HttpResult;

@RequestMapping(value = "/treeNode")
@RestController
public class TreeNodeController {
    private final Logger logger = LoggerFactory.getLogger(getClass()) ;
    @Autowired
    private TreeNodeService treeNodeService;

    @PostMapping(value = "/saveAndUpdate")
    public HttpResult saveTreeNode(String fomData){
        try {
            TreeNode treeNode = JSONObject.parseObject(fomData,TreeNode.class) ;
            treeNodeService.saveAndUpdate(treeNode);
            return HttpResult.newCorrectResult(200,treeNode);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            return HttpResult.newErrorResult(500,e) ;
        }
    }

    @GetMapping(value = "/getTreeNodeById/{id}")
    public HttpResult getTreeNodeById(@PathVariable(name = "id") Integer id){
        try {
            TreeNode treeNode = treeNodeService.getTreeNodeById(id) ;
            return HttpResult.newCorrectResult(200,treeNode);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            return HttpResult.newErrorResult(500,e) ;
        }
    }

    @GetMapping(value = "/getTreeNodeList")
    public HttpResult getTreeNodeList(TreeNode treeNode){
        try {
            return HttpResult.newCorrectResult(200,treeNodeService.getTreeNodeList(treeNode)) ;
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            return HttpResult.newErrorResult(200,String.join("","没有获取到数据",e.getMessage())) ;
        }
    }

    @DeleteMapping(value = "/deleteTreeNodeById/{id}")
    public HttpResult deleteTreeNodeById(@PathVariable (name = "id") String id){
        try {
            FormatUtils.transformString2List(id).forEach(s -> treeNodeService.deleteTreeNodeById(Integer.parseInt(s)));
            return HttpResult.newCorrectResult(200,"success") ;
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            return HttpResult.newErrorResult(500,e) ;
        }
    }

    @GetMapping(value = "/treeviewData")
    public HttpResult treeviewData(){
        try {
            return HttpResult.newCorrectResult(200,treeNodeService.getBootstrapTreeNodeList()) ;
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            return HttpResult.newErrorResult(500,e) ;
        }
    }

}
