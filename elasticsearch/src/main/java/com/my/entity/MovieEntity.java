package com.my.entity;

import lombok.Data;

/**
 * @author : chengdu
 * @date :  2023/7/24-07
 **/
@Data
public class MovieEntity {
    private String episodes_info;
    private String rate;
    private int cover_x;
    private String title;
    private String url;
    private boolean playable;
    private String cover;
    private String id;
    private int cover_y;
    private boolean is_new;
}
