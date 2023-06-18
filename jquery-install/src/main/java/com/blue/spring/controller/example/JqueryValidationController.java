package com.blue.spring.controller.example;

import com.blue.enums.Views;
import com.blue.service.ModelAndViewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: zch
 * @Date: 2018/8/26 12:58
 * @Description:
 */
@RequestMapping(value = "/jqueryValidation")
@Controller
public class JqueryValidationController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ModelAndViewService modelAndViewService;

    @RequestMapping(value = "/validationForm",name = "form 表单验证")
    public ModelAndView validationForm() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s%s", Views.NAVIGATION.getVar(), Views.VALIDATION.getVar(), "validationForm"));
        logger.info(String.format("method:%s()", "validationForm"));
        return mv;
    }

    @RequestMapping(value = "/testA",name = "form 表单验证")
    public ModelAndView testA() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s%s", Views.NAVIGATION.getVar(), Views.VALIDATION.getVar(), "testA"));
        logger.info(String.format("method:%s()", "testA"));
        return mv;
    }

    @RequestMapping(value = "/initForm",name = "form 表单赋值")
    public ModelAndView initForm() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s%s", Views.NAVIGATION.getVar(), Views.VALIDATION.getVar(), "initForm"));
        logger.info(String.format("method:%s()", "initForm"));
        return mv;
    }
}
