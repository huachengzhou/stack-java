package com.blue.spring.controller.core;

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
 * @Date: 2018/8/26 09:59
 * @Description:
 */
@RequestMapping(value = "/sys",name = "核心控制器")
@Controller
public class HomeController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ModelAndViewService modelAndViewService;

    @RequestMapping(value = "/home",method = {RequestMethod.GET})
    public ModelAndView home(){
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName("index");
        return mv;
    }


    @RequestMapping(value = "/easyUiHome", name = "easyUi 主页面",method = {RequestMethod.GET})
    public ModelAndView easyUiHome() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s",Views.WEB_INF.getVar(),"easyUiHome"));
        logger.info(String.format("easyUiHome() %s %s","---------->"," easyUiHome"));
        return mv;
    }

    @RequestMapping(value = "/baseJqueryHome", name = "jquery base 主页面",method = {RequestMethod.GET})
    public ModelAndView baseJqueryHome() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s",Views.WEB_INF.getVar(),"baseJqueryHome"));
        logger.info(String.format("easyUiHome() %s %s","---------->"," baseJqueryHome"));
        return mv;
    }

    @RequestMapping(value = "/jqueryValidation", name = "jqueryValidation 主页面",method = {RequestMethod.GET})
    public ModelAndView jqueryValidation() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s",Views.WEB_INF.getVar(),"jqueryValidationHome"));
        logger.info(String.format("easyUiHome() %s %s","---------->"," jqueryValidationHome"));
        return mv;
    }
}
