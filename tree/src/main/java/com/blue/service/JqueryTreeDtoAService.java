package com.blue.service;

import com.blue.dal.dto.JqueryTreeDtoA;
import org.springframework.stereotype.Service;
import tool.help.Zhou_StdRandom;
import tool.help.Zhou_String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @createDate 2018/12/22
 **/
@Service
public class JqueryTreeDtoAService {

    public List<JqueryTreeDtoA> treeDtoAList() {
        List<JqueryTreeDtoA> dtoAList = new ArrayList<JqueryTreeDtoA>();
        final int num = 10;
        for (int i = 1; i <= num; i++) {
            JqueryTreeDtoA dtoA = new JqueryTreeDtoA();
            dtoA.setCreateTime(new Date()).setId(i).setText(Zhou_String.toWord(5)).setNum(Zhou_StdRandom.uniform(1.02, 1000));
            for (int j = i * 10; j < i * 10 + 10; j++) {
                JqueryTreeDtoA treeDtoA = new JqueryTreeDtoA();
                treeDtoA.setNum(Zhou_StdRandom.uniform(10,2000.2)).setId(j).setText(Zhou_String.toLowerCase(5)).setCreateTime(new Date());
                dtoA.getNodes().add(treeDtoA);
            }
            dtoAList.add(dtoA);
        }
        return dtoAList;
    }

}
