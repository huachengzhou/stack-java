package com.blue.dal.dao;

import com.blue.dal.entity.TreeNode;
import com.blue.dal.entity.TreeNodeExample;
import com.blue.dal.mapper.TreeNodeMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zch on 2019-12-6.
 */
@Repository
public class TreeNodeDao {

    @Autowired
    private TreeNodeMapper treeNodeMapper;

    public void  saveTreeNode(TreeNode treeNode){
        treeNodeMapper.insertSelective(treeNode) ;
    }

    public void updateTreeNode(TreeNode treeNode){
        treeNodeMapper.updateByPrimaryKeySelective(treeNode) ;
    }

    public void deleteTreeNodeById(Integer masterId){
        treeNodeMapper.deleteByPrimaryKey(masterId) ;
    }

    public TreeNode getTreeNodeById(Integer masterId){
        return treeNodeMapper.selectByPrimaryKey(masterId) ;
    }

    public List<TreeNode> getTreeNodeList(TreeNode treeNode){
        TreeNodeExample example = new TreeNodeExample();
        TreeNodeExample.Criteria criteria = example.createCriteria();

        if (treeNode.getId() != null && treeNode.getId()!=0){
            criteria.andIdEqualTo(treeNode.getId()) ;
        }

        if (StringUtils.isNotEmpty(treeNode.getPid())){
            criteria.andPidEqualTo(treeNode.getPid()) ;
        }

        if (StringUtils.isNotEmpty(treeNode.getName())){
            criteria.andNameLike(String.join("","%","'",treeNode.getName(),"'","%")) ;
        }

        if (StringUtils.isNotEmpty(treeNode.getParentName())){
            criteria.andParentNameLike(String.join("","%","'",treeNode.getParentName(),"'","%")) ;
        }
        return treeNodeMapper.selectByExample(example) ;
    }

}
