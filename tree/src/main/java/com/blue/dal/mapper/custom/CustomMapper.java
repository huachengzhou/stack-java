package com.blue.dal.mapper.custom;


import com.blue.common.page.PageRequest;
import com.blue.dal.entity.UserBoot;

import java.util.List;

public interface CustomMapper {

    /**
     *
     * @param pageRequest
     * @return
     */
    List<UserBoot> selectPageByQuery(PageRequest pageRequest);




}
