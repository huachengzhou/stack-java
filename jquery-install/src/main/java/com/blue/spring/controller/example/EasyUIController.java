package com.blue.spring.controller.example;

import com.blue.enums.Views;
import com.blue.service.ModelAndViewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * @Auther: zch
 * @Date: 2018/8/8 20:21
 * @Description:
 */

@RequestMapping(value = "/easyUI")
@Controller
public class EasyUIController {
    private final Logger logger = LoggerFactory.getLogger(getClass()) ;
    @Autowired
    private ModelAndViewService modelAndViewService;

    @RequestMapping(value = "/helloWorld", method = {RequestMethod.GET})
    public ModelAndView helloWorld() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s%s", Views.NAVIGATION.getVar(), Views.EasyUI.getVar(), "helloWorld"));
        logger.info(String.format("method:%s()", "helloWorld"));
        return mv;
    }

    @RequestMapping(value = "/draggable", method = {RequestMethod.GET},name = "拖动")
    public ModelAndView draggable() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s%s", Views.NAVIGATION.getVar(), Views.EasyUI.getVar(), "draggable"));
        return mv;
    }

    @RequestMapping(value = "/panel", method = {RequestMethod.GET}, name = "面板")
    public ModelAndView panel() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s%s", Views.NAVIGATION.getVar(), Views.EasyUI.getVar(), "panel"));
        logger.info(String.format("panel:%s()", "panel"));
        return mv;
    }

    @RequestMapping(value = "/pagination", method = {RequestMethod.GET}, name = "分页")
    public ModelAndView pagination() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s%s", Views.NAVIGATION.getVar(), Views.EasyUI.getVar(), "pagination"));
        logger.info(String.format("pagination:%s()", "pagination"));
        return mv;
    }

    @RequestMapping(value = "/tab", method = {RequestMethod.GET}, name = "选项卡")
    public ModelAndView tab() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s%s", Views.NAVIGATION.getVar(), Views.EasyUI.getVar(), "tab"));
        logger.info(String.format("tab:%s()", "tab"));
        return mv;
    }


}
