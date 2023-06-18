package com.blue.spring.controller.model;

import com.blue.common.enums_common.Views;
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
 * @Date: 2018/9/13 23:24
 * @Description:
 */
@RequestMapping(value = "/sucai17")
@Controller
public class SUCAI17Controller {
    private final Logger logger = LoggerFactory.getLogger(getClass()) ;
    @Autowired
    private ModelAndViewService modelAndViewService;

    @RequestMapping(value = "/helloWorld",method = {RequestMethod.GET})
    public ModelAndView hello(){
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s", Views.SUCAIVIEW.getVar(),"helloWorld"));
        return mv;
    }
}
