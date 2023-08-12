CREATE TABLE `tb_ms_school_info` (
  `id` bigint(25) NOT NULL,
  `uuid` varchar(200) DEFAULT NULL COMMENT '*实体唯一uuid',
  `title` varchar(200) DEFAULT NULL COMMENT '*标题',
  `name` varchar(200) DEFAULT NULL COMMENT '*名称',
  `base_date` date DEFAULT NULL COMMENT '立校时间*',
  `number` int(11) DEFAULT NULL COMMENT '人数',
  `address` varchar(200) DEFAULT NULL COMMENT '*地址',
  `creator` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间，记录变化后会自动更新时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uuid` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学校信息';


CREATE TABLE `tb_ms_school_info_1` (
  `id` bigint(25) NOT NULL,
  `uuid` varchar(200) DEFAULT NULL COMMENT '*实体唯一uuid',
  `title` varchar(200) DEFAULT NULL COMMENT '*标题',
  `name` varchar(200) DEFAULT NULL COMMENT '*名称',
  `base_date` date DEFAULT NULL COMMENT '立校时间*',
  `number` int(11) DEFAULT NULL COMMENT '人数',
  `address` varchar(200) DEFAULT NULL COMMENT '*地址',
  `creator` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间，记录变化后会自动更新时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uuid` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学校信息';


CREATE TABLE `tb_ms_school_info_2` (
  `id` bigint(25) NOT NULL,
  `uuid` varchar(200) DEFAULT NULL COMMENT '*实体唯一uuid',
  `title` varchar(200) DEFAULT NULL COMMENT '*标题',
  `name` varchar(200) DEFAULT NULL COMMENT '*名称',
  `base_date` date DEFAULT NULL COMMENT '立校时间*',
  `number` int(11) DEFAULT NULL COMMENT '人数',
  `address` varchar(200) DEFAULT NULL COMMENT '*地址',
  `creator` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
  `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间，记录变化后会自动更新时间戳',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uuid` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学校信息';


CREATE TABLE `tb_ms_school_info_3` (
                                     `id` bigint(25) NOT NULL,
                                     `uuid` varchar(200) DEFAULT NULL COMMENT '*实体唯一uuid',
                                     `title` varchar(200) DEFAULT NULL COMMENT '*标题',
                                     `name` varchar(200) DEFAULT NULL COMMENT '*名称',
                                     `base_date` date DEFAULT NULL COMMENT '立校时间*',
                                     `number` int(11) DEFAULT NULL COMMENT '人数',
                                     `address` varchar(200) DEFAULT NULL COMMENT '*地址',
                                     `creator` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
                                     `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                     `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间，记录变化后会自动更新时间戳',
                                     PRIMARY KEY (`id`),
                                     UNIQUE KEY `uuid` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学校信息';


CREATE TABLE `tb_ms_school_info_4` (
                                     `id` bigint(25) NOT NULL,
                                     `uuid` varchar(200) DEFAULT NULL COMMENT '*实体唯一uuid',
                                     `title` varchar(200) DEFAULT NULL COMMENT '*标题',
                                     `name` varchar(200) DEFAULT NULL COMMENT '*名称',
                                     `base_date` date DEFAULT NULL COMMENT '立校时间*',
                                     `number` int(11) DEFAULT NULL COMMENT '人数',
                                     `address` varchar(200) DEFAULT NULL COMMENT '*地址',
                                     `creator` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
                                     `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                     `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间，记录变化后会自动更新时间戳',
                                     PRIMARY KEY (`id`),
                                     UNIQUE KEY `uuid` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学校信息';
