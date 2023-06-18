package com.blue.spring.controller.sys;

import com.blue.common.ViewEnum;
import org.apache.tools.ant.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@RequestMapping(value = "/sys", name = "系统核心控制器")
@Controller
public class SysController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping(value = "/home", name = "主页")
    public ModelAndView sys() {
        ModelAndView mv = new ModelAndView(String.format("%s%s", ViewEnum.WEB.getKey(), "home"));
        logger.info("home " + DateUtils.format(new Date(), "yyyy-MM-dd HH:mm"));
        return mv;
    }

    @GetMapping(value = "/easy", name = "主页")
    public ModelAndView easy() {
        ModelAndView mv = new ModelAndView(String.format("%s%s", ViewEnum.WEB.getKey(), "easy"));
        logger.info("easy " + DateUtils.format(new Date(), "yyyy-MM-dd HH:mm"));
        return mv;
    }

    @GetMapping(value = "/jquery", name = "主页")
    public ModelAndView jquery() {
        ModelAndView mv = new ModelAndView(String.format("%s%s", ViewEnum.WEB.getKey(), "jquery"));
        logger.info("easy " + DateUtils.format(new Date(), "yyyy-MM-dd HH:mm"));
        return mv;
    }

    @GetMapping(value = "/ztree", name = "主页")
    public ModelAndView ztree() {
        ModelAndView mv = new ModelAndView(String.format("%s%s", ViewEnum.WEB.getKey(), "ztree"));
        logger.info("ztree" + DateUtils.format(new Date(), "yyyy-MM-dd HH:mm"));
        return mv;
    }

    @GetMapping(value = "/jstl", name = "主页")
    public ModelAndView jstl() {
        ModelAndView mv = new ModelAndView(String.format("%s%s", ViewEnum.WEB.getKey(), "jstl"));
        return mv;
    }
}
