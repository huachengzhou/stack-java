package com.blue.service;

import com.blue.dal.dto.EasyTreeDtoA;
import org.springframework.stereotype.Service;
import tool.help.Zhou_StdRandom;
import tool.help.Zhou_String;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @createDate 2018/12/15
 **/

@Service
public class EasyTreeDtoAService {

    public List<EasyTreeDtoA> treeDtoAs(){
        final int num = 10;
        List<EasyTreeDtoA> easyTreeDtoAS = new ArrayList<EasyTreeDtoA>(num);
        for (int i = 0; i < num; i++) {
            EasyTreeDtoA treeDtoA = new EasyTreeDtoA();
            treeDtoA.setAttribute(Zhou_String.toWord(5));
            treeDtoA.setItemid(Zhou_StdRandom.uniform(1,1000));
            treeDtoA.setProductid(Zhou_StdRandom.uniform(2,1000));
            for (int j = 0; j < 20; j++) {
                treeDtoA.getListprice().add(new BigDecimal(Zhou_StdRandom.uniform(10.2,22222.5)));
            }
            for (int j = 0; j < 30; j++) {
                treeDtoA.getUnitcost().add(UUID.randomUUID().toString().substring(0,6));
            }
            treeDtoA.setStatus("run");
            easyTreeDtoAS.add(treeDtoA) ;
        }
        return easyTreeDtoAS;
    }
}
