package com.blue.spring.controller.core;

import com.blue.enums.Views;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: zch
 * @Date: 2018/7/30 21:47
 * @Description:控制器
 */
@RequestMapping(value = "/core")
@Controller
public class ThymeleafController {
    private final Logger logger = LoggerFactory.getLogger(getClass()) ;

    @RequestMapping(value = "/coreHome",method = {RequestMethod.GET},name = "主页面")
    public ModelAndView coreHome(){
        ModelAndView mv = new ModelAndView();
        logger.info(String.format("method:%s","coreHome"));
        mv.setViewName(String.format("%s%s", Views.WEB_INF.getKey(),"coreHome"));
        return mv;
    }

    @RequestMapping(value = "/exampleHome",method = {RequestMethod.GET},name = "例子学习主页面")
    public ModelAndView exampleHome(){
        ModelAndView mv = new ModelAndView();
        logger.info(String.format("method:%s","exampleHome"));
        mv.setViewName(String.format("%s%s", Views.WEB_INF.getKey(),"exampleHome"));
        return mv;
    }

    @RequestMapping(value = "/jsHome",method = {RequestMethod.GET},name = "js 主页面")
    public ModelAndView jsMethodHome(){
        ModelAndView mv = new ModelAndView();
        logger.info(String.format("method:%s","jsHome"));
        mv.setViewName(String.format("%s%s", Views.WEB_INF.getKey(),"jsHome"));
        return mv;
    }
}
