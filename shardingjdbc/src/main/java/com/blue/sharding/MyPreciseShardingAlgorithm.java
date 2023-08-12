package com.blue.sharding;

/**
 * @author : chengdu
 * @date :  2023/8/12-08
 **/

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Collection;

@Slf4j
public class MyPreciseShardingAlgorithm implements PreciseShardingAlgorithm, RangeShardingAlgorithm {


    @Override
    public String doSharding(Collection collection, PreciseShardingValue preciseShardingValue) {
        log.info("collection:{}", collection);
        log.info("preciseShardingValue:{}", preciseShardingValue);
        Comparable valueValue = preciseShardingValue.getValue();
        long idValue = 0;
        if (valueValue instanceof Integer){
           Integer integer = (Integer) valueValue;
            idValue = integer.longValue();
        }else if (valueValue instanceof Long){
            Long aLong = (Long)valueValue;
            idValue = aLong.longValue();
        }
        //表一共4个
        final int tableSize = 4;
        String index = String.valueOf((idValue % tableSize) + 1);
        String tableReal = preciseShardingValue.getLogicTableName().concat("_").concat(index);
        return tableReal;
    }

    @Override
    public Collection<String> doSharding(Collection collection, RangeShardingValue rangeShardingValue) {
        return null;
    }
}
