package com.blue.spring.controller.easyTree;

import com.alibaba.fastjson.JSONObject;
import com.blue.common.ViewEnum;
import com.blue.service.EasyTreeDtoAService;
import com.blue.service.EasyTreeDtoBService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @createDate 2018/12/9
 **/
@RequestMapping(value = "/easy/dataGrid")
@RestController
public class DataGridController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EasyTreeDtoAService easyTreeDtoAService;

    @Autowired
    private EasyTreeDtoBService easyTreeDtoBService;

    @RequestMapping(value = "/hello", method = {RequestMethod.GET}, name = "第一个例子")
    public ModelAndView hello() {
        logger.debug("hello广东韶关");
        return new ModelAndView(String.format("%s%s%s", ViewEnum.EASY.getKey(), ViewEnum.DataGrid.getKey(), "hello"));
    }

    @GetMapping(value = "/basic", name = "基础数据表格")
    public ModelAndView basic() {
        return new ModelAndView(String.format("%s%s%s", ViewEnum.EASY.getKey(), ViewEnum.DataGrid.getKey(), "basic"));
    }

    @GetMapping(value = "/transform", name = "数据表格 变换")
    public ModelAndView transform() {
        return new ModelAndView(String.format("%s%s%s", ViewEnum.EASY.getKey(), ViewEnum.DataGrid.getKey(), "transform"));
    }

    @GetMapping(value = "/selection", name = "数据表格 获取选择的数据")
    public ModelAndView selection() {
        ModelAndView mv = new ModelAndView(String.format("%s%s%s", ViewEnum.EASY.getKey(), ViewEnum.DataGrid.getKey(), "selection"));
        mv.addObject("treeDtoA", JSONObject.toJSONString(easyTreeDtoAService.treeDtoAs()));
        return mv;
    }

    @GetMapping(value = "/editing", name = "数据表格 单元格编辑")
    public ModelAndView editing() {
        ModelAndView mv = new ModelAndView(String.format("%s%s%s", ViewEnum.EASY.getKey(), ViewEnum.DataGrid.getKey(), "editing"));
        mv.addObject("treeDtoA", JSONObject.toJSONString(easyTreeDtoAService.treeDtoAs()));
        return mv;
    }

    @GetMapping(value = "/treeEditing", name = "数据表格树 单元格编辑")
    public ModelAndView treeEditing() {
        ModelAndView mv = new ModelAndView(String.format("%s%s%s", ViewEnum.EASY.getKey(), ViewEnum.DataGrid.getKey(), "treeEditing"));
        mv.addObject("treeDtoB", JSONObject.toJSONString(easyTreeDtoBService.getBootstrapTableVo()));
        return mv;
    }


}
