INSERT INTO sys_dict_data (id,dict_key,remark,dict_name,creator_id,create_time,modifier_id,modify_time,dict_value_type,app_id) VALUES
('boi_page_data_type_inst','page_data_type_inst','数据查询类型','数据查询类型',NULL,NULL,NULL,NULL,1,'boi')
,('boi_biz_type','biz_type','委外指令业务类型','委外指令业务类型',NULL,NULL,NULL,NULL,1,'boi')
,('boi_fund_type','fund_type','委外产品类型','委外产品类型',NULL,NULL,NULL,NULL,1,'boi')
,('boi_secu_type','secu_type','委外资产类型','委外资产类型',NULL,NULL,NULL,NULL,1,'boi')
,('boi_down_stream','down_stream','下游系统','下游系统',NULL,NULL,NULL,NULL,2,'boi')
,('boi_fund_privilege_operation','fund_privilege_operation','产品权限操作类型','产品权限操作类型',NULL,NULL,NULL,NULL,2,'boi')
,('boi_fund_source','fund_source','产品来源','产品来源',NULL,NULL,NULL,NULL,1,'boi')
,('boi_inst_status','inst_status','指令状态','指令状态',NULL,NULL,NULL,NULL,1,'boi')
;

INSERT INTO sys_dict_data (id,dict_key,remark,dict_name,creator_id,create_time,modifier_id,modify_time,dict_value_type,app_id) VALUES
('boi_operational_mode','operational_mode','运作模式','运作模式',NULL,NULL,NULL,NULL,1,'boi')
,('boi_organizational_form','organizational_form','组织形式','组织形式',NULL,NULL,NULL,NULL,1,'boi')
,('boi_prd_status_cfg','prd_status_cfg','产品状态','产品状态',NULL,NULL,NULL,NULL,1,'boi')
,('boi_raising_type','raising_type','募集方式','募集方式',NULL,NULL,NULL,NULL,1,'boi')
,('boi_review_status','review_status','复核状态','复核状态',NULL,NULL,NULL,NULL,1,'boi')
,('boi_trade_type','trade_type','委外交易方向','委外交易方向',NULL,NULL,NULL,NULL,2,'boi')
,('boi_user_status','user_status','用户状态','用户状态',NULL,NULL,NULL,NULL,1,'boi')
,('boi_yes_no','yes_no','是否','是否',NULL,NULL,NULL,NULL,2,'boi')
;

INSERT INTO sys_dict_data_def (id,dict_id,value,name,en_name) VALUES
('boi_page_data_type_inst_1','boi_page_data_type_inst','1','指令总览','overview_query')
,('boi_page_data_type_inst_2','boi_page_data_type_inst','2','指令审批查询','approval_query')
,('boi_page_data_type_inst_3','boi_page_data_type_inst','3','资产单元','exec_query')
,('boi_page_data_type_inst_4','boi_page_data_type_inst','4','指令查询','inst_query')
,('boi_page_data_type_inst_5','boi_page_data_type_inst','5','交易查询','trade_query')
,('boi_page_data_type_inst_6','boi_page_data_type_inst','6','交易重发','trade_retry')
,('boi_biz_type_0','boi_biz_type','0','母层','mother')
,('boi_biz_type_1','boi_biz_type','1','子层','child')
,('boi_biz_type_2','boi_biz_type','2','货币基金','currency')
,('boi_biz_type_3','boi_biz_type','3','通用业务','common')
;

INSERT INTO sys_dict_data_def (id,dict_id,value,name,en_name) VALUES
('boi_fund_type_1','boi_fund_type','1','大M','big_m')
,('boi_fund_type_2','boi_fund_type','2','大F','big_f')
,('boi_fund_type','boi_fund_type','3','小F','little_f')
,('boi_secu_type_2','boi_secu_type','2','大F资产','big_f')
,('boi_secu_type_3','boi_secu_type','3','小F资产','little_f')
,('boi_secu_type_4','boi_secu_type','4','其他资产','other')
,('boi_down_stream_JGT','boi_down_stream','JGT','基构通','jgt')
,('boi_down_stream_NONE','boi_down_stream','NONE','无','none')
,('boi_down_stream_TA','boi_down_stream','TA','华润自建TA','ta')
,('boi_down_stream_TOS','boi_down_stream','TOS','华润TOS','tos')
;

INSERT INTO sys_dict_data_def (id,dict_id,value,name,en_name) VALUES
('boi_fund_privilege_operation_a','boi_fund_privilege_operation','a','增加','add')
,('boi_fund_privilege_operation_m','boi_fund_privilege_operation','m','编辑','modify')
,('boi_fund_source_1','boi_fund_source','1','招银理财','cmb')
,('boi_fund_source_2','boi_fund_source','2','私行','pb')
,('boi_inst_status_0','boi_inst_status','0','已过期','expired')
,('boi_inst_status_1','boi_inst_status','1','待审批','pending')
,('boi_inst_status_2','boi_inst_status','2','已拒绝','reject')
,('boi_inst_status_3','boi_inst_status','3','待执行','ready')
,('boi_inst_status_5','boi_inst_status','5','执行中','running')
,('boi_inst_status_7','boi_inst_status','7','已执行','executed')
;

INSERT INTO sys_dict_data_def (id,dict_id,value,name,en_name) VALUES
('boi_inst_status_9','boi_inst_status','9','已完成','finished')
,('boi_inst_status_10','boi_inst_status','10','已撤销','undone')
,('boi_inst_status_98','boi_inst_status','98','接收中','receiving')
,('boi_inst_status_99','boi_inst_status','99','放失败','failed')
,('boi_operational_mode_1','boi_operational_mode','1','封闭式','closed')
,('boi_operational_mode_2','boi_operational_mode','2','开放式','open')
,('boi_operational_mode_3','boi_operational_mode','3','定期开放式','regular_open')
,('boi_organizational_form_1','boi_organizational_form','1','契约型','contractual')
,('boi_organizational_form_2','boi_organizational_form','2','公司型','corporate')
,('boi_organizational_form_3','boi_organizational_form','3','合伙型','partnership')
;

INSERT INTO sys_dict_data_def (id,dict_id,value,name,en_name) VALUES
('boi_organizational_form_4','boi_organizational_form','4','其他','other')
,('boi_prd_status_cfg_0','boi_prd_status_cfg','0','未上线','inactive')
,('boi_prd_status_cfg_1','boi_prd_status_cfg','1','已上线','active')
,('boi_prd_status_cfg_2','boi_prd_status_cfg','2','并行中','parallel')
,('boi_prd_status_cfg_3','boi_prd_status_cfg','3','就绪','ready')
,('boi_raising_type_1','boi_raising_type','1','公募','public')
,('boi_raising_type_2','boi_raising_type','2','私募','private')
,('boi_raising_type_3','boi_raising_type','3','其他','others')
,('boi_review_status_0','boi_review_status','0','未审核','unreviewed')
,('boi_review_status_1','boi_review_status','1','已审核','reviewed')
;

INSERT INTO sys_dict_data_def (id,dict_id,value,name,en_name) VALUES
('boi_review_status_2','boi_review_status','2','已复核','approved')
,('boi_review_status_3','boi_review_status','3','拒绝','reject')
,('boi_review_status_4','boi_review_status','4','失败','failed')
,('boi_review_status_5','boi_review_status','5','发送运营平台成功','sent')
,('boi_review_status_6','boi_review_status','6','发送运营平台失败','sentfalied')
,('boi_review_status_7','boi_review_status','7','已撤销','revoked')
,('boi_review_status_8','boi_review_status','8','未到账','notArrived')
,('boi_review_status_9','boi_review_status','9','等待运营平台确认接收回执中','waitingAck')
,('boi_trade_type_first','boi_trade_type','first','一级申购（网下）','first')
,('boi_trade_type_ipo','boi_trade_type','ipo','认购','ipo')
;

INSERT INTO sys_dict_data_def (id,dict_id,value,name,en_name) VALUES
('boi_trade_type_purchase','boi_trade_type','purchase','申购','purchase')
,('boi_trade_type_redeem','boi_trade_type','redeem','赎回','redeem')
,('boi_user_status_0','boi_user_status','0','禁用','disable')
,('boi_user_status_1','boi_user_status','1','正常','normal')
,('boi_user_status_2','boi_user_status','2','删除','deleted')
,('boi_user_status_99','boi_user_status','99','审查','other')
,('boi_yes_no_N','boi_yes_no','N','否','n')
,('boi_yes_no_Y','boi_yes_no','Y','是','y')
;