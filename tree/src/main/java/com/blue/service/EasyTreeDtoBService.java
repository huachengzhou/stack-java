package com.blue.service;

import com.blue.dal.dto.EasyTreeDtoB;
import org.springframework.stereotype.Service;
import tool.help.Zhou_String;
import tool.web.BootstrapTableVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @createDate 2018/12/20
 **/
@Service
public class EasyTreeDtoBService {

    public BootstrapTableVo getBootstrapTableVo() {
        BootstrapTableVo vo = new BootstrapTableVo();
        List<EasyTreeDtoB> treeDtoBList = new ArrayList<EasyTreeDtoB>(20);
        int num = 5;
        for (int i = 1; i <= num; i++) {
            EasyTreeDtoB dtoB = new EasyTreeDtoB();
            dtoB.setId(i);
            dtoB.setName(Zhou_String.toLowerCase(4));
            treeDtoBList.add(dtoB);
            for (int j = num * 10; j < num * 10 + 10; j++) {
                EasyTreeDtoB treeDtoB = new EasyTreeDtoB();
                treeDtoB.set_parentId(i);
                treeDtoB.setId(j);
                treeDtoB.setName(Zhou_String.toWord(6));
                treeDtoBList.add(treeDtoB);
                dtoB.getChildren().add(treeDtoB) ;
            }
        }
        vo.setRows(treeDtoBList);
        vo.setTotal(Integer.toUnsignedLong(treeDtoBList.size()));
        return vo;
    }



}
