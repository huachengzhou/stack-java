package com.solr.study;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.solr.entity.SchoolFractionInfo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : chengdu
 * @date :  2023/9/18-09
 **/
public class SchoolFractionInfoData {

    public static List<SchoolFractionInfo> getSchoolFractionInfoList() {
        List<SchoolFractionInfo> infoArrayList = new ArrayList<>(0);
        String projectPath = System.getProperty("user.dir") + File.separator + "src\\main\\resources\\tb_school_fraction_info.json";
        String string = FileUtil.readString(projectPath, "UTF-8");
        infoArrayList = JSONUtil.toList(string, SchoolFractionInfo.class);
        return infoArrayList;
    }

}
