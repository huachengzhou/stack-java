package com.gold.tree;


import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.LikeTable;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <p>
 * mysql 代码生成器演示例子  已经测试成功了的
 * </p>
 *
 * @author zch
 * @since 2018-09-12
 */
public class MysqlGenerator {

    //这里需要改为自己的目录地址,其余的地方不需要动
    public static String projectPath = "D:/IdeaProjects/stack-java/js-tree";

    // 全局配置
    private final static String OUTPUT_DIR = "/src/main/java";// 生成文件的输出目录
    private final static String AUTHOR = "zch";// 开发人员

    public static void init(List<LikeTable> likeTableList){

        if (CollectionUtils.isEmpty(likeTableList)){
            return;
        }

        Iterator<LikeTable> iterator = likeTableList.iterator();
        while (iterator.hasNext()){
            LikeTable likeTable = iterator.next();
            run(likeTable) ;
        }

    }

    public static void run(LikeTable likeTable){
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath + OUTPUT_DIR);
        gc.setAuthor(AUTHOR);
        gc.setOpen(false);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setFileOverride(true);
        gc.setDateType(DateType.ONLY_DATE); // 设置日期类型为Date
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/tree?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.gold");
        pc.setEntity("dal.entity");
        pc.setMapper("dal.mapper");
        pc.setService("service.base");
        pc.setServiceImpl("service.base.impl");
        pc.setController("controller.data");
        pc.setXml("mybatis") ;
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mybatis/" + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

//        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        //重置 设置xml为null
        templateConfig.setXml(null);
//        templateConfig.setServiceImpl(null) ;
//        templateConfig.setService(null) ;
//        templateConfig.setController(null) ;
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setLikeTable(likeTable);
        strategy.setEntityColumnConstant(true) ;//生成常量字段,
        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);

        strategy.setEntityTableFieldAnnotationEnable(true) ;//生成实体时，生成字段注解
        strategy.setEntityLombokModel(false);//【实体】是否为lombok模型

        strategy.setTablePrefix("tb_");//删除指定前缀
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }


    /**
     * RUN THIS
     */
    public static void main(String[] args) {
        List<LikeTable> likeTableList = new ArrayList<>() ;

//        likeTableList.add(new LikeTable("tb_uc_user")) ;
        likeTableList.add(new LikeTable("tb_uc_gov_info")) ;

        init(likeTableList) ;
    }
}
