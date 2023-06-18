package com.gold.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gold.dal.entity.UcUser;
import com.gold.service.base.IUcUserService;
import com.gold.vo.BootstrapTableVo;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UcUserService {

    @Autowired
    private IUcUserService iUcUserService;

    public List<UcUser> findUcUserList(UcUser obj) {
        QueryWrapper<UcUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(obj);
        List<UcUser> list = iUcUserService.list(queryWrapper);
        return list;
    }

    public BootstrapTableVo<UcUser> getDataTableList(UcUser obj, IPage<UcUser> requestPage) {
        QueryWrapper<UcUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(obj);
        IPage<UcUser> page = iUcUserService.page(requestPage, queryWrapper);
        BootstrapTableVo<UcUser> vo = new BootstrapTableVo<>();
        vo.setRows(page.getRecords());
        vo.setTotal(page.getTotal());
        return vo;
    }

    private Integer saveUcUser(UcUser oo) {
        if (oo.getVersion() == null || oo.getVersion() == 0) {
            oo.setVersion(RandomUtils.nextInt(1,100));
        }
        iUcUserService.save(oo);
        return oo.getVersion() ;
    }

    private Integer updateById(UcUser obj) {
        iUcUserService.updateById(obj);
        return iUcUserService.getById(obj.getId()).getVersion();
    }


    public Integer saveAndUpdate(UcUser obj) {
        if (obj.getId() == null || obj.getId() == 0) {
            return saveUcUser(obj) ;
        }else {
            return updateById(obj);
        }
    }

}
