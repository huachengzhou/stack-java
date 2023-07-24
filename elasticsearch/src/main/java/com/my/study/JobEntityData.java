package com.my.study;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONUtil;
import com.my.entity.JobEntity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : chengdu
 * @date :  2023/7/24-07
 **/
public class JobEntityData {

    public static List<JobEntity> getJobEntityList(){
        List<JobEntity> jobEntities = new ArrayList<>(0);
        String projectPath = System.getProperty("user.dir") + File.separator + "src\\main\\resources\\jobArea.json";
        String string = FileUtil.readString(projectPath, "UTF-8");
        jobEntities = JSONUtil.toList(string, JobEntity.class);
        return jobEntities;
    }


}
