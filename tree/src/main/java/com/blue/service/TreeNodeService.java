package com.blue.service;

import com.blue.common.BootstrapTreeNode;
import com.blue.dal.dao.TreeNodeDao;
import com.blue.dal.entity.TreeNode;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zch on 2019-12-6.
 */

@Service
public class TreeNodeService {

    @Autowired
    private TreeNodeDao treeNodeDao;

    public void saveTreeNode(TreeNode treeNode) {
        treeNode.setIpType("ipv4");
        treeNodeDao.saveTreeNode(treeNode);
    }

    public void saveAndUpdate(TreeNode treeNode) {
        if (treeNode.getId() == null || treeNode.getId() == 0) {
            saveTreeNode(treeNode);
        } else {
            updateTreeNode(treeNode);
        }
    }

    public List<BootstrapTreeNode> getBootstrapTreeNodeList() {
        TreeNode query = new TreeNode();
        query.setPid("0");
        List<TreeNode> treeNodeList = getTreeNodeList(query);
        List<BootstrapTreeNode> bootstrapTreeNodeList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(treeNodeList)){
            treeNodeList.forEach(treeNode -> {
                BootstrapTreeNode target = getBootstrapTreeNode(treeNode) ;
                settingBootstrapTreeNode(target) ;
                bootstrapTreeNodeList.add(target) ;
            });
        }
        return bootstrapTreeNodeList;
    }

    private BootstrapTreeNode getBootstrapTreeNode(TreeNode treeNode) {
        BootstrapTreeNode bootstrapTreeNode = new BootstrapTreeNode();
        BeanUtils.copyProperties(treeNode, bootstrapTreeNode);
        return bootstrapTreeNode;
    }

    private void settingBootstrapTreeNode(BootstrapTreeNode bootstrapTreeNode){
        if (bootstrapTreeNode == null){
            return;
        }
        TreeNode query = new TreeNode();
        query.setPid(bootstrapTreeNode.getId().toString());
        List<TreeNode> treeNodeList = getTreeNodeList(query) ;
        if (CollectionUtils.isNotEmpty(treeNodeList)){
            for (TreeNode treeNode:treeNodeList){
                BootstrapTreeNode target = getBootstrapTreeNode(treeNode) ;
                settingBootstrapTreeNode(target);
                bootstrapTreeNode.getNodes().add(target) ;
            }
        }
    }

    public void updateTreeNode(TreeNode treeNode) {
        treeNode.setLastUpdateTime(new Date());
        treeNodeDao.updateTreeNode(treeNode);
    }

    public void deleteTreeNodeById(Integer masterId) {
        treeNodeDao.deleteTreeNodeById(masterId);
    }

    public TreeNode getTreeNodeById(Integer masterId) {
        return treeNodeDao.getTreeNodeById(masterId);
    }

    public List<TreeNode> getTreeNodeList(TreeNode treeNode) {
        return treeNodeDao.getTreeNodeList(treeNode);
    }

}
