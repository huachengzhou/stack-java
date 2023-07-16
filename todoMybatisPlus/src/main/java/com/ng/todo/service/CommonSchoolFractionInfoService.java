package com.ng.todo.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ng.todo.entity.CommonSchoolFractionInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.function.Consumer;

/**
 * <p>
 * 大学高考分数(普通) 服务类
 * </p>
 *
 * @author zch
 * @since 2023-06-10
 */
public interface CommonSchoolFractionInfoService extends IService<CommonSchoolFractionInfo> {
    /**
     * 根据年份获取信息uuid
     * @param year
     * @return
     */
    List<String> findDataUuidList(Integer year);

    List<String> findUuidList(BaseMapper baseMapper, Wrapper queryWrapper);

    <T> void removeEntity(Class<T> aClass, Consumer<T> settingBisFieldValue, QueryWrapper queryWrapper) throws Exception;
}
