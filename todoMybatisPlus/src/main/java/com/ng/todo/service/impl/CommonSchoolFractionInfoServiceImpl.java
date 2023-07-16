package com.ng.todo.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ng.todo.common.utils.MyBatisPlusUtils;
import com.ng.todo.entity.CommonSchoolFractionInfo;
import com.ng.todo.mapper.CommonSchoolFractionInfoMapper;
import com.ng.todo.service.CommonSchoolFractionInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;


/**
 * <p>
 * 大学高考分数(普通) 服务实现类
 * </p>
 *
 * @author zch
 * @since 2023-06-10
 */
@Service
public class CommonSchoolFractionInfoServiceImpl extends ServiceImpl<CommonSchoolFractionInfoMapper, CommonSchoolFractionInfo> implements CommonSchoolFractionInfoService {


    /**
     * 根据年份获取信息uuid
     *
     * @param year
     * @return
     */
    @Override
    public List<String> findDataUuidList(Integer year) {
        QueryWrapper<CommonSchoolFractionInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("uuid");
        queryWrapper.eq(CommonSchoolFractionInfo.YEAR, year);
        return findUuidList(baseMapper, queryWrapper);
    }


    /**
     * 获取uuid
     *
     * @param baseMapper
     * @param queryWrapper
     * @return
     */
    @Override
    public List<String> findUuidList(BaseMapper baseMapper, Wrapper queryWrapper) {
        List<Map<String, Object>> mapList = baseMapper.selectMaps(queryWrapper);
        if (CollUtil.isEmpty(mapList)) {
            return new ArrayList<>(0);
        }
        List<String> uuidList = new ArrayList<>();
        mapList.stream().forEach(stringObjectMap -> {
            uuidList.add(String.valueOf(stringObjectMap.get("uuid")));
        });
        return uuidList;
    }

    @Override
    public <T> void removeEntity(Class<T> aClass, Consumer<T> settingBisFieldValue, QueryWrapper queryWrapper) throws Exception {
        String beanId = String.format("%s%s", StrUtil.lowerFirst(StrUtil.toCamelCase(aClass.getSimpleName())), "Mapper");
        BaseMapper<T> tBaseMapper = SpringUtil.getBean(beanId);
        T o = aClass.newInstance();
        settingBisFieldValue.accept(o);
        List<String> uuidList = MyBatisPlusUtils.findUuidList(tBaseMapper, queryWrapper);
        tBaseMapper.update(o, new QueryWrapper<T>().in("uuid", uuidList));
    }


}
