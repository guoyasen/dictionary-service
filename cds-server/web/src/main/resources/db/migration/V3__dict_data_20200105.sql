-- Create table
drop table if exists sys_dict_data;
create table sys_dict_data
(
  id          varchar(32) not null,
  dict_key    VARCHAR(64) not null,
  remark      VARCHAR(128),
  dict_name   VARCHAR(128),
  creator_id  varchar(32),
  create_time DATE,
  modifier_id varchar(32),
  modify_time DATE,
  dict_value_type  INT(2),
  app_id      VARCHAR(32),
  PRIMARY KEY ( `id` )
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

drop table if exists sys_dict_data_def;
create table sys_dict_data_def
(
  id            varchar(32) not null,
  sys_dict_data_id      varchar(32) not null,
  value         VARCHAR(64) not null,
  name          VARCHAR(128),
  en_name       VARCHAR(64),
  PRIMARY KEY ( `id` )
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into sys_dict_data (id, dict_key, remark, dict_name, dict_value_type, app_id) values(1, 'dict_value_type', '字典值类型', '字典值类型', 1, 'cds');

insert into sys_dict_data_def (id, sys_dict_data_id, value, name, en_name) values(1, 1, 1, '数值型', 'number');

insert into sys_dict_data_def (id, sys_dict_data_id, value, name, en_name) values(2, 1, 2, '字符型', 'string');

insert into sys_dict_data (id, dict_key, remark, dict_name, dict_value_type, app_id) values(2, 'app_id', '所属应用分类', '所属应用分类', 2, 'cds');

insert into sys_dict_data_def (id, sys_dict_data_id, value, name, en_name) values(3, 2, 'cds', '全局', 'cds');

insert into sys_dict_data_def (id, sys_dict_data_id, value, name, en_name) values(4, 2, 'portal', 'portal', 'portal');

insert into sys_dict_data_def (id, sys_dict_data_id, value, name, en_name) values(5, 2, 'boi', 'boi', 'boi');

insert into sys_dict_data_def (id, sys_dict_data_id, value, name, en_name) values(6, 2, 'cms', 'cms', 'cms');

insert into sys_dict_data_def (id, sys_dict_data_id, value, name, en_name) values(7, 2, 'rme', 'rme', 'rme');

insert into sys_dict_data_def (id, sys_dict_data_id, value, name, en_name) values(8, 2, 'sor', 'sor', 'sor');