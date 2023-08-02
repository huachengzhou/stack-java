CREATE TABLE tb_school_fraction_info (
  id int identity(1,1) not null primary key,
  uuid varchar(128)  DEFAULT '0',
  year varchar(255) DEFAULT NULL ,
  fraction varchar(255) DEFAULT NULL ,
  max_score varchar(255) DEFAULT NULL ,
  min_score varchar(255) DEFAULT NULL ,
  enrollment varchar(255) DEFAULT NULL ,
  province varchar(255) DEFAULT NULL ,
  type varchar(255) DEFAULT NULL ,
  primary_classification varchar(255) DEFAULT NULL ,
  method varchar(255) DEFAULT NULL ,
  speciality varchar(255) DEFAULT NULL ,
  source_text text ,
  school varchar(255) DEFAULT NULL ,
  batch varchar(255) DEFAULT NULL ,
  type_enum varchar(100) DEFAULT NULL ,
  remark varchar(255)  DEFAULT NULL ,
  gmt_created datetime DEFAULT NULL ,
  gmt_modified datetime DEFAULT NULL


)  ;