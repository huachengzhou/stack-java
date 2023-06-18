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
 * @Date: 2018/7/30 22:58
 * @Description:js控制器
 */
@RequestMapping(value = "/js")
@Controller
public class JavaScriptController {

    private final Logger logger = LoggerFactory.getLogger(getClass()) ;

    @RequestMapping(value = "/helloWorld", method = RequestMethod.GET,name = "js 参数检测")
    public ModelAndView helloWorld() {
        ModelAndView mv = new ModelAndView();
        logger.info(String.format("method:%s","helloWorld"));
        mv.setViewName(String.format("%s%s", Views.templates.getKey(),"helloWorld"));
        return mv;
    }

    @RequestMapping(value = "/functionA", method = RequestMethod.GET,name = "js 函数")
    public ModelAndView functionA() {
        ModelAndView mv = new ModelAndView();
        logger.info(String.format("method:%s","functionA"));
        mv.setViewName(String.format("%s%s", Views.templates.getKey(),"functionA"));
        return mv;
    }

    @RequestMapping(value = "/objectA", method = RequestMethod.GET,name = "js 对象A")
    public ModelAndView objectA() {
        ModelAndView mv = new ModelAndView();
        logger.info(String.format("method:%s","objectA"));
        mv.setViewName(String.format("%s%s", Views.templates.getKey(),"objectA"));
        return mv;
    }

    @RequestMapping(value = "/extendsA", method = RequestMethod.GET,name = "js 继承")
    public ModelAndView extendsA() {
        ModelAndView mv = new ModelAndView();
        logger.info(String.format("method:%s","extendsA"));
        mv.setViewName(String.format("%s%s", Views.templates.getKey(),"extendsA"));
        return mv;
    }

    @RequestMapping(value = "/practiceA", method = RequestMethod.GET,name = "js 练习A")
    public ModelAndView practiceA() {
        ModelAndView mv = new ModelAndView();
        logger.info(String.format("method:%s","practiceA"));
        mv.setViewName(String.format("%s%s", Views.templates.getKey(),"practiceA"));
        return mv;
    }

    @RequestMapping(value = "/callAndApply", method = RequestMethod.GET,name = "js call apply")
    public ModelAndView callAndApply() {
        ModelAndView mv = new ModelAndView();
        logger.info(String.format("method:%s","callAndApply"));
        mv.setViewName(String.format("%s%s", Views.templates.getKey(),"callAndApply"));
        return mv;
    }

    @RequestMapping(value = "/windowOpen", method = RequestMethod.GET,name = "js windowOpen")
    public ModelAndView windowOpen() {
        ModelAndView mv = new ModelAndView();
        logger.info(String.format("method:%s","windowOpen"));
        mv.setViewName(String.format("%s%s", Views.templates.getKey(),"windowOpen"));
        return mv;
    }

    @RequestMapping(value = "/regexA", method = RequestMethod.GET,name = "js 正则表达式")
    public ModelAndView regexA() {
        ModelAndView mv = new ModelAndView();
        logger.info(String.format("method:%s","regexA"));
        mv.setViewName(String.format("%s%s", Views.templates.getKey(),"regexA"));
        return mv;
    }

    @RequestMapping(value = "/rotateA", method = RequestMethod.GET,name = "jquery 图片旋转")
    public ModelAndView rotateA() {
        ModelAndView mv = new ModelAndView();
        logger.info(String.format("method:%s","rotateA"));
        mv.setViewName(String.format("%s%s", Views.templates.getKey(),"rotateA"));
        return mv;
    }

    @RequestMapping(value = "/rotateB", method = RequestMethod.GET,name = "jquery 图片旋转")
    public ModelAndView rotateB() {
        ModelAndView mv = new ModelAndView();
        logger.info(String.format("method:%s","rotateB"));
        mv.setViewName(String.format("%s%s", Views.templates.getKey(),"rotateB"));
        return mv;
    }

    @RequestMapping(value = "/rotateC", method = RequestMethod.GET,name = "jquery 图片旋转")
    public ModelAndView rotateC() {
        ModelAndView mv = new ModelAndView();
        logger.info(String.format("method:%s","rotateC"));
        mv.setViewName(String.format("%s%s", Views.templates.getKey(),"rotateC"));
        return mv;
    }
}
