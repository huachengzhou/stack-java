package com.blue.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: zch
 * @Date: 2018/8/26 10:07
 * @Description:
 */
@Service
public class ModelAndViewService {

    /**
     *
     * 功能描述: 以后需要封装一些参数在里面
     *
     * @param:
     * @return:
     * @auther: zch
     * @date: 2018/8/26 10:09
     */
    public ModelAndView changeModelAndView(){
        ModelAndView mv = new ModelAndView();
        return mv;
    }

    /**
     *
     * 功能描述: 以后需要封装一些参数在里面
     *
     * @param:
     * @return:
     * @auther: zch
     * @date: 2018/8/26 10:09
     */
    public ModelAndView changeModelAndView(String view){
        ModelAndView mv = new ModelAndView(view);
        return mv;
    }
}
