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
 * @Date: 2018/8/26 12:46
 * @Description:
 */
@RequestMapping(value = "/baseJquery")
@Controller
public class JqueryBaseController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ModelAndViewService modelAndViewService;

    @RequestMapping(value = "/helloWorld")
    public ModelAndView helloWorld() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s%s", Views.NAVIGATION.getVar(), Views.BASE_VIEW.getVar(), "helloWorld"));
        logger.info(String.format("method:%s()", "helloWorld"));
        return mv;
    }
}
