package com.blue.spring.controller.core;

import com.blue.common.common_str.HomeFinalString;
import com.blue.common.enums_common.Views;
import com.blue.service.ModelAndViewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = "/sys", name = "系统核心控制器")
@Controller
public class HomeController {
    private final Logger logger = LoggerFactory.getLogger(getClass()) ;
    @Autowired
    private ModelAndViewService modelAndViewService;

    @RequestMapping(value = "/home", name = "主页面")
    public ModelAndView home() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s",Views.WEB_INF.getVar(),HomeFinalString.HOME));
        return mv;
    }

    @RequestMapping(value = "/suCai17", name = "素材 主页面")
    public ModelAndView suCai17() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s",Views.WEB_INF.getVar(),HomeFinalString.SUCAI_HOME));
        return mv;
    }

    @RequestMapping(value = "/gaode", name = "高德 主页面")
    public ModelAndView gaode() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s",Views.WEB_INF.getVar(),HomeFinalString.MAP_HOME));
        return mv;
    }


}
