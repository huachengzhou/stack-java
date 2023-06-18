CREATE TABLE `tb_uc_user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `USER_NAME` varchar(100) DEFAULT NULL COMMENT '用户名',
  `USER_PWD` varchar(200) DEFAULT NULL COMMENT '密码',
  `BIRTHDAY` datetime DEFAULT NULL COMMENT '生日',
  `NAME` varchar(200) DEFAULT NULL COMMENT '姓名',
  `USER_ICON` varchar(500) DEFAULT NULL COMMENT '头像图片',
  `SEX` char(1) DEFAULT NULL COMMENT '性别, 1:男，2:女，3：保密',
  `NICKNAME` varchar(200) DEFAULT NULL COMMENT '昵称',
  `STAT` varchar(10) DEFAULT NULL COMMENT '用户状态，01:正常，02:冻结',
  `USER_MALL` bigint(20) DEFAULT NULL COMMENT '当前所属MALL',
  `LAST_LOGIN_DATE` datetime DEFAULT NULL COMMENT '最后登录时间',
  `LAST_LOGIN_IP` varchar(100) DEFAULT NULL COMMENT '最后登录IP',
  `SRC_OPEN_USER_ID` bigint(20) DEFAULT NULL COMMENT '来源的联合登录',
  `EMAIL` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `MOBILE` varchar(50) DEFAULT NULL COMMENT '手机',
  `IS_DEL` char(1) DEFAULT '0' COMMENT '是否删除',
  `IS_EMAIL_CONFIRMED` char(1) DEFAULT '0' COMMENT '是否绑定邮箱',
  `IS_PHONE_CONFIRMED` char(1) DEFAULT '0' COMMENT '是否绑定手机',
  `CREATER` bigint(20) DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `UPDATE_DATE` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改日期',
  `PWD_INTENSITY` char(1) DEFAULT NULL COMMENT '密码强度',
  `MOBILE_TGC` char(64) DEFAULT NULL COMMENT '手机登录标识',
  `MAC` char(64) DEFAULT NULL COMMENT 'mac地址',
  `SOURCE` char(1) DEFAULT '0' COMMENT '1:WEB,2:IOS,3:ANDROID,4:WIFI,5:管理系统, 0:未知',
  `ACTIVATE` char(1) DEFAULT '1' COMMENT '激活，1：激活，0：未激活',
  `ACTIVATE_TYPE` char(1) DEFAULT '0' COMMENT '激活类型，0：自动，1：手动',
  `version` int(20) DEFAULT NULL COMMENT '用作乐观锁',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `USER_NAME` (`USER_NAME`),
  KEY `MOBILE` (`MOBILE`),
  KEY `IDX_MOBILE_TGC` (`MOBILE_TGC`,`ID`),
  KEY `IDX_EMAIL` (`EMAIL`,`ID`),
  KEY `IDX_CREATE_DATE` (`CREATE_DATE`,`ID`),
  KEY `IDX_UPDATE_DATE` (`UPDATE_DATE`)
) ENGINE=InnoDB AUTO_INCREMENT=7122685 DEFAULT CHARSET=utf8 COMMENT='用户表';



CREATE TABLE `tb_uc_gov_info` (
                                `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                `word_number_name` varchar(200) DEFAULT NULL COMMENT '文号',
                                `info_source` varchar(600) DEFAULT NULL COMMENT '来源',
                                `entry_date` datetime DEFAULT NULL COMMENT '录入时间',
                                `info_date` date DEFAULT NULL COMMENT '信息公开时间',
                                `user_name` varchar(255) DEFAULT NULL,
                                `unit` varchar(255) DEFAULT NULL COMMENT '单位',
                                `content` longtext COMMENT '正文',
                                `title` varchar(500) DEFAULT NULL COMMENT '公开信息标题',
                                `CREATE_DATE` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
                                `UPDATE_DATE` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改日期',
                                `version` int(20) DEFAULT NULL COMMENT '用作乐观锁',
                                PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='信息公开';