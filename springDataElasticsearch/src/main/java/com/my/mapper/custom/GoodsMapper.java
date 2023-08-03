package com.my.mapper.custom;


import com.my.jpa.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Mapper接口
 *
 * @author zch
 */
@Repository
@Mapper
public interface GoodsMapper {
    /**
     * 查询所有
     */
    List<Goods> findAll();
}
