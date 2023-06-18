package com.gold.controller.data;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = "/sys")
@Slf4j
@Controller
public class HomeController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping(value = "/home")
    public String home(){
        String view = "view/freemarkerHome" ;
        return view;
    }

    @RequestMapping(value = "/toDemo")
    public ModelAndView toDemo(ModelAndView mv) {
        log.info("====>>跳转freemarker页面");
        mv.addObject("name", "jack");
        mv.setViewName("freemarker");
        return mv;
    }

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("name","hello pillar");
        return "index";
    }

}
