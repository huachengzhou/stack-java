package com.blue.spring.controller.easyTree;

import com.blue.common.ViewEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@RequestMapping(value = "/easy")
@Controller
public class EasyTree {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/hello", method = {RequestMethod.GET}, name = "第一个例子")
    public ModelAndView hello() {
        String str = "hello-广东韶关";
        logger.info(str);
        try {
            String strGBK = URLEncoder.encode(str, "GB2312");
            System.out.println(strGBK);
            String strUTF8 = URLDecoder.decode(str, "GBK");
            System.out.println(strUTF8);
        } catch (UnsupportedEncodingException e) {

        }
        return new ModelAndView(String.format("%s%s%s", ViewEnum.EASY.getKey(), ViewEnum.TREE.getKey(), "hello"));
    }

    @RequestMapping(value = "/staticTree", method = {RequestMethod.GET}, name = "静态方式生成tree")
    public ModelAndView staticTree() {
        return new ModelAndView(String.format("%s%s%s", ViewEnum.EASY.getKey(), ViewEnum.TREE.getKey(), "staticTree"));
    }

    @RequestMapping(value = "/dynamicTree", method = {RequestMethod.GET}, name = "动态方式生成tree")
    public ModelAndView dynamicTree() {
        logger.debug("dynamicTree");
        return new ModelAndView(String.format("%s%s%s", ViewEnum.EASY.getKey(), ViewEnum.TREE.getKey(), "dynamicTree"));
    }

    @RequestMapping(value = "/lineTree", method = {RequestMethod.GET}, name = "树线")
    public ModelAndView lineTree() {
        logger.debug("lineTree");
        return new ModelAndView(String.format("%s%s%s", ViewEnum.EASY.getKey(), ViewEnum.TREE.getKey(), "lineTree"));
    }

    @RequestMapping(value = "/beginEdit", method = {RequestMethod.GET}, name = "开启编辑")
    public ModelAndView beginEdit() {
        logger.debug("beginEdit");
        return new ModelAndView(String.format("%s%s%s", ViewEnum.EASY.getKey(), ViewEnum.TREE.getKey(), "beginEdit"));
    }

    @RequestMapping(value = "/contextMenu", method = {RequestMethod.GET}, name = "树的上下文菜单")
    public ModelAndView contextMenu() {
        logger.debug("contextMenu");
        return new ModelAndView(String.format("%s%s%s", ViewEnum.EASY.getKey(), ViewEnum.TREE.getKey(), "contextMenu"));
    }

    @RequestMapping(value = "/checkBox", method = {RequestMethod.GET}, name = "复选框节点")
    public ModelAndView checkBox() {
        logger.debug("checkBox");
        return new ModelAndView(String.format("%s%s%s", ViewEnum.EASY.getKey(), ViewEnum.TREE.getKey(), "checkBox"));
    }

    @RequestMapping(value = "/dragDropTree", method = {RequestMethod.GET}, name = "可拖拉树节点")
    public ModelAndView dragDropTree() {
        logger.debug("dragDropTree");
        return new ModelAndView(String.format("%s%s%s", ViewEnum.EASY.getKey(), ViewEnum.TREE.getKey(), "dragDropTree"));
    }

    @RequestMapping(value = "/formattingTree", method = {RequestMethod.GET}, name = "格式化树节点")
    public ModelAndView formattingTree() {
        logger.debug("formattingTree");
        return new ModelAndView(String.format("%s%s%s", ViewEnum.EASY.getKey(), ViewEnum.TREE.getKey(), "formattingTree"));
    }

}
