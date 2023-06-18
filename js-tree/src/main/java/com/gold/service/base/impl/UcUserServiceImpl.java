package com.gold.service.base.impl;

import com.gold.dal.entity.UcUser;
import com.gold.dal.mapper.UcUserMapper;
import com.gold.service.base.IUcUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author zch
 * @since 2020-06-27
 */
@Service
public class UcUserServiceImpl extends ServiceImpl<UcUserMapper, UcUser> implements IUcUserService {

}
