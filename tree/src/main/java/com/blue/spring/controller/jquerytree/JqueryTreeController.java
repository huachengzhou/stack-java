package com.blue.spring.controller.jquerytree;

import com.alibaba.fastjson.JSON;
import com.blue.common.ViewEnum;
import com.blue.service.JqueryTreeDtoAService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @createDate 2018/12/20
 **/
@RequestMapping(value = "/jquery/tree")
@RestController
public class JqueryTreeController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private JqueryTreeDtoAService jqueryTreeDtoAService;

    @RequestMapping(value = "/hello", method = {RequestMethod.GET}, name = "第一个例子")
    public ModelAndView hello() {
        logger.debug("hello");
        return new ModelAndView(String.format("%s%s%s", ViewEnum.JQUERY.getKey(), ViewEnum.TREE.getKey(), "hello"));
    }

    @GetMapping(value = "/jsonShowTree",name = "json方式展示tree")
    public ModelAndView jsonShowTree(){
        ModelAndView mv = new ModelAndView(String.format("%s%s%s", ViewEnum.JQUERY.getKey(), ViewEnum.TREE.getKey(), "jsonShowTree"));
        mv.addObject("trees", JSON.toJSON(jqueryTreeDtoAService.treeDtoAList()));
        return mv;
    }

    @GetMapping(value = "/getSelectTree",name = "获取所选树")
    public ModelAndView getSelectTree(){
        ModelAndView mv = new ModelAndView(String.format("%s%s%s", ViewEnum.JQUERY.getKey(), ViewEnum.TREE.getKey(), "getSelectTree"));
        mv.addObject("trees", JSON.toJSON(jqueryTreeDtoAService.treeDtoAList()));
        return mv;
    }

    @GetMapping(value = "/handleEvent",name = "事件处理")
    public ModelAndView handleEvent(){
        ModelAndView mv = new ModelAndView(String.format("%s%s%s", ViewEnum.JQUERY.getKey(), ViewEnum.TREE.getKey(), "handleEvent"));
        mv.addObject("trees", JSON.toJSON(jqueryTreeDtoAService.treeDtoAList()));
        return mv;
    }

    @GetMapping(value = "/appendNode",name = "事件处理")
    public ModelAndView appendNode(){
        ModelAndView mv = new ModelAndView(String.format("%s%s%s", ViewEnum.JQUERY.getKey(), ViewEnum.TREE.getKey(), "appendNode"));
        mv.addObject("trees", JSON.toJSON(jqueryTreeDtoAService.treeDtoAList()));
        return mv;
    }
}
