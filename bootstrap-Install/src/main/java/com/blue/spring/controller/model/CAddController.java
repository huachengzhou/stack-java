package com.blue.spring.controller.model;

import com.blue.common.enums_common.Views;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * @Author noatn
 * @Description
 * @createDate 2018/11/21
 **/
@RequestMapping(value = "/c++")
@Controller
public class CAddController {

    private final Logger logger = LoggerFactory.getLogger(getClass()) ;

    @RequestMapping(value = "/helloWorld")
    public ModelAndView helloWorld(){
        ModelAndView mv = new ModelAndView(String.format("%s%s", Views.CORE_VIEW.getVar(),"helloWorld"));
        logger.info(String.format("request method:%s","helloWorld"));
        return mv;
    }

}
