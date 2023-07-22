package com.ng.todo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface CommonSchoolFractionInfoService {
    List<String> findUuidList(BaseMapper baseMapper, Wrapper queryWrapper);
}
