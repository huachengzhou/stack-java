package com.blue.spring.controller.example;

import com.blue.enums.Views;
import com.blue.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: zch
 * @Date: 2018/7/29 17:01
 * @Description:
 */
@Controller
@RequestMapping("/example")
public class HelloController {
    private final Logger logger = LoggerFactory.getLogger(getClass()) ;
    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
    public ModelAndView helloWorld(ModelMap model) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(String.format("%s%s", Views.Example.getKey(),"hello"));
        return mv;
    }

    @RequestMapping(value = "/tempA", method = RequestMethod.GET)
    public ModelAndView tempA(ModelMap model) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("messageList",messageService.messageList());
        mv.setViewName(String.format("%s%s", Views.Example.getKey(),"tempA"));
        return mv;
    }
}
