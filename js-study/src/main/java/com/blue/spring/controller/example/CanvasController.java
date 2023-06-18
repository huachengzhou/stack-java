package com.blue.spring.controller.example;

import com.blue.enums.Views;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: zch
 * @Date: 2018/11/27 11:33
 * @Description:canvas
 */
@RequestMapping(value = "/canvas")
@Controller
public class CanvasController {

    private final Logger logger = LoggerFactory.getLogger(getClass()) ;

    @RequestMapping(value = "/helloWorld", method = RequestMethod.GET,name = "canvas 第一个例子")
    public ModelAndView helloWorld() {
        ModelAndView mv = new ModelAndView();
        logger.info(String.format("method:%s","helloWorld"));
        mv.setViewName(String.format("%s%s", Views.canvas.getKey(),"helloWorld"));
        return mv;
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET,name = "canvas 第二个例子")
    public ModelAndView test2() {
        ModelAndView mv = new ModelAndView();
        logger.info(String.format("method:%s","test2"));
        mv.setViewName(String.format("%s%s", Views.canvas.getKey(),"test2"));
        return mv;
    }

    @RequestMapping(value = "/test3", method = RequestMethod.GET,name = "canvas 第三个例子")
    public ModelAndView test3() {
        ModelAndView mv = new ModelAndView(String.format("%s%s", Views.canvas.getKey(),"test3"));
        return mv;
    }

    @RequestMapping(value = "/test4", method = RequestMethod.GET,name = "canvas 第四个例子")
    public ModelAndView test4() {
        ModelAndView mv = new ModelAndView(String.format("%s%s", Views.canvas.getKey(),"test4"));
        return mv;
    }

}
