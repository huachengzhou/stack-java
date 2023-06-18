package com.blue.dal.dao;

import com.blue.dal.entity.UserBoot;
import com.blue.dal.entity.UserBootExample;
import com.blue.dal.mapper.UserBootMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zch
 * @Description
 * @createDate 2018/11/18
 **/
@Repository
public class UserBootDao {


    @Autowired(required = true)
    private UserBootMapper userBootMapper;

    public void saveUserBoot(UserBoot userBoot){
       userBootMapper.insertSelective(userBoot);
    }

    public UserBoot getUserBoot(Integer id){
        return userBootMapper.selectByPrimaryKey(id);
    }

    public boolean deleteUserBoot(Integer id){
        return userBootMapper.deleteByPrimaryKey(id)==1;
    }

    public boolean updateUserBoot(UserBoot userBoot){
        return userBootMapper.updateByPrimaryKey(userBoot)==1;
    }

    public List<UserBoot> findListUserBoot(){
        UserBootExample example = new UserBootExample();
        UserBootExample.Criteria criteria = example.createCriteria();
        criteria.andIdIsNotNull();
        return userBootMapper.selectByExample(example);
    }


}
