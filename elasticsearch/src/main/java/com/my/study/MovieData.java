package com.my.study;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONUtil;
import com.my.entity.MovieEntity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : chengdu
 * @date :  2023/7/24-07
 **/
public class MovieData {

    public static List<MovieEntity> getMovieEntityList() {
        List<MovieEntity> movieEntityList = new ArrayList<>(0);
        String projectPath = System.getProperty("user.dir") + File.separator + "src\\main\\resources\\movie.json";
        String string = FileUtil.readString(projectPath, "UTF-8");
        movieEntityList = JSONUtil.toList(string, MovieEntity.class);
        return movieEntityList;
    }
}
