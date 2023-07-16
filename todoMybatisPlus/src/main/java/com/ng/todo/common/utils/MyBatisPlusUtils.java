package com.ng.todo.common.utils;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author : chengdu
 * @date :  2023/7/15-07
 **/
public class MyBatisPlusUtils {

    /**
     * 获取uuid
     *
     * @param baseMapper
     * @param queryWrapper
     * @return
     */
    public static List<String> findUuidList(BaseMapper baseMapper, QueryWrapper queryWrapper) {
        queryWrapper.select("uuid") ;
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

}
