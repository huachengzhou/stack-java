package com.gold.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gold.dal.entity.UcGovInfo;
import com.gold.service.base.IUcGovInfoService;
import com.gold.vo.BootstrapTableVo;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UcGovInfoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private IUcGovInfoService iUcGovInfoService;

    public List<UcGovInfo> findUcGovInfoList(UcGovInfo obj) {
        QueryWrapper<UcGovInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(obj);
        List<UcGovInfo> list = iUcGovInfoService.list(queryWrapper);
        return list;
    }

    public BootstrapTableVo<UcGovInfo> getDataTableList(UcGovInfo obj, IPage<UcGovInfo> requestPage) {
        QueryWrapper<UcGovInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(obj);
        IPage<UcGovInfo> page = iUcGovInfoService.page(requestPage, queryWrapper);
        BootstrapTableVo<UcGovInfo> vo = new BootstrapTableVo<>();
        vo.setRows(page.getRecords());
        vo.setTotal(page.getTotal());
        return vo;
    }

    private void saveUcGovInfo(UcGovInfo oo) {
        if (oo.getVersion() == null || oo.getVersion() == 0) {
            oo.setVersion(RandomUtils.nextInt(1, 100));
        }
        iUcGovInfoService.save(oo);
    }

    private void updateById(UcGovInfo obj) {
        iUcGovInfoService.updateById(obj);
    }


    public void saveAndUpdate(UcGovInfo obj) {
        if (obj.getId() == null || obj.getId() == 0) {
            saveUcGovInfo(obj);
        } else {
            updateById(obj);
        }
    }

}
