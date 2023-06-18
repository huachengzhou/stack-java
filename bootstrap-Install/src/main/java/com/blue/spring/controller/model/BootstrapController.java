package com.blue.spring.controller.model;

import com.blue.common.enums_common.Views;
import com.blue.service.ModelAndViewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RequestMapping(value = "/bootstrap")
@RestController
public class BootstrapController {

    private final Logger logger = LoggerFactory.getLogger(getClass()) ;

    @Autowired
    private ModelAndViewService modelAndViewService;

    @RequestMapping(value = "/helloWorld", method = {RequestMethod.GET}, name = "table 基本")
    public ModelAndView helloWorld() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s", Views.BOOTSTRAP.getVar(), "helloWorld"));
        return mv;
    }

    @GetMapping(value = "/grid", name = "栅格")
    public ModelAndView grid() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s", Views.BOOTSTRAP.getVar(), "grid"));
        return mv;
    }

    @GetMapping(value = "/grid2", name = "栅格")
    public ModelAndView grid2() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s", Views.BOOTSTRAP.getVar(), "grid2"));
        return mv;
    }

    @GetMapping(value = "/title", name = "标题")
    public ModelAndView title() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s", Views.BOOTSTRAP.getVar(), "title"));
        return mv;
    }

    @GetMapping(value = "/trad", name = "排版")
    public ModelAndView trad() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s", Views.BOOTSTRAP.getVar(), "trad"));
        return mv;
    }

    @GetMapping(value = "/form", name = "表单")
    public ModelAndView form() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s", Views.BOOTSTRAP.getVar(), "form"));
        return mv;
    }

    @GetMapping(value = "/auxiliaryClass", name = "辅助类")
    public ModelAndView auxiliaryClass() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s", Views.BOOTSTRAP.getVar(), "auxiliaryClass"));
        return mv;
    }

    @GetMapping(value = "/icon", name = "图标")
    public ModelAndView icon() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s", Views.BOOTSTRAP.getVar(), "icon"));
        return mv;
    }

    @GetMapping(value = "/dropDownmenu", name = "下拉菜单")
    public ModelAndView dropDownmenu() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s", Views.BOOTSTRAP.getVar(), "dropDownmenu"));
        return mv;
    }

    @GetMapping(value = "/buttonGroup", name = "按钮组")
    public ModelAndView buttonGroup() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s", Views.BOOTSTRAP.getVar(), "buttonGroup"));
        return mv;
    }

    @GetMapping(value = "/inputGroup", name = "输入组")
    public ModelAndView inputGroup() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s", Views.BOOTSTRAP.getVar(), "inputGroup"));
        return mv;
    }

    @GetMapping(value = "/nav", name = "导航")
    public ModelAndView nav() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s", Views.BOOTSTRAP.getVar(), "nav"));
        return mv;
    }

    @GetMapping(value = "/navBar", name = "导航条")
    public ModelAndView navBar() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s", Views.BOOTSTRAP.getVar(), "navBar"));
        return mv;
    }

    @GetMapping(value = "/jumbotron", name = "巨幕")
    public ModelAndView jumbotron() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s", Views.BOOTSTRAP.getVar(), "jumbotron"));
        return mv;
    }

    @GetMapping(value = "/pageHeader", name = "页头")
    public ModelAndView pageHeader() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s", Views.BOOTSTRAP.getVar(), "pageHeader"));
        return mv;
    }

    @GetMapping(value = "/thumbnail", name = "缩略图")
    public ModelAndView thumbnail() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s", Views.BOOTSTRAP.getVar(), "thumbnail"));
        return mv;
    }

    @GetMapping(value = "/progress", name = "进度条")
    public ModelAndView progress() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s", Views.BOOTSTRAP.getVar(), "progress"));
        return mv;
    }

    @GetMapping(value = "/warning", name = "警告框")
    public ModelAndView warning() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s", Views.BOOTSTRAP.getVar(), "warning"));
        return mv;
    }

    @GetMapping(value = "/media", name = "媒体对象")
    public ModelAndView media() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s", Views.BOOTSTRAP.getVar(), "media"));
        return mv;
    }

    @GetMapping(value = "/panel", name = "面版")
    public ModelAndView panel() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s", Views.BOOTSTRAP.getVar(), "panel"));
        return mv;
    }

    @GetMapping(value = "/iframe", name = "具有响应式特性的嵌入内容")
    public ModelAndView iframe() {
        ModelAndView mv = modelAndViewService.changeModelAndView();
        mv.setViewName(String.format("%s%s", Views.BOOTSTRAP.getVar(), "iframe"));
        return mv;
    }

}
