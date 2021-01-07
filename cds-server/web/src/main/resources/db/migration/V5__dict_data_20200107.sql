-- Create table
drop table if exists sys_dict_data;
create table sys_dict_data
(
  id          varchar(128) not null,
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
  id            varchar(128) not null,
  dict_id       varchar(128) not null,
  value         VARCHAR(64) not null,
  name          VARCHAR(128),
  en_name       VARCHAR(64),
  PRIMARY KEY ( `id` )
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into sys_dict_data (id, dict_key, remark, dict_name, dict_value_type, app_id) values('cds_dict_value_type', 'dict_value_type', '字典值类型', '字典值类型', 1, 'cds');

insert into sys_dict_data_def (id, dict_id, value, name, en_name) values('cds_dict_value_type_1', 'cds_dict_value_type', 1, '数值型', 'number');

insert into sys_dict_data_def (id, dict_id, value, name, en_name) values('cds_dict_value_type_2', 'cds_dict_value_type', 2, '字符型', 'string');

insert into sys_dict_data (id, dict_key, remark, dict_name, dict_value_type, app_id) values('cds_app_id', 'app_id', '所属应用分类', '所属应用分类', 2, 'cds');

insert into sys_dict_data_def (id, dict_id, value, name, en_name) values('cds_app_id_cds', 'cds_app_id', 'cds', '全局', 'cds');

insert into sys_dict_data_def (id, dict_id, value, name, en_name) values('cds_app_id_portal', 'cds_app_id', 'portal', 'portal', 'portal');

insert into sys_dict_data_def (id, dict_id, value, name, en_name) values('cds_app_id_boi', 'cds_app_id', 'boi', 'boi', 'boi');

insert into sys_dict_data_def (id, dict_id, value, name, en_name) values('cds_app_id_cms', 'cds_app_id', 'cms', 'cms', 'cms');

insert into sys_dict_data_def (id, dict_id, value, name, en_name) values('cds_app_id_rme', 'cds_app_id', 'rme', 'rme', 'rme');

insert into sys_dict_data_def (id, dict_id, value, name, en_name) values('cds_app_id_sor', 'cds_app_id', 'sor', 'sor', 'sor');

INSERT INTO sys_dict_data (id,dict_key,remark,dict_name,creator_id,create_time,modifier_id,modify_time,dict_value_type,app_id) VALUES
('cms_cpl_business_type','cpl_business_type','风控业务类型','风控业务类型',NULL,NULL,NULL,NULL,1,'cms')
,('cms_cms_prd_control_level','cms_prd_control_level','产品控制层级','产品控制层级',NULL,NULL,NULL,NULL,2,'cms')
,('cms_rule_unit','rule_unit','风控条款数量单位','风控条款数量单位',NULL,NULL,NULL,NULL,1,'cms')
,('cms_rule_trade_type_code','rule_trade_type_code','风控公式交易方向','风控公式交易方向',NULL,NULL,NULL,NULL,2,'cms')
,('cms_cpl_fml_type','cpl_fml_type','公式分类','公式分类',NULL,NULL,NULL,NULL,2,'cms')
,('cms_cpl_clause_control_trade_stage','cpl_clause_control_trade_stage','风控条款控制交易阶段','风控条款控制交易阶段',NULL,NULL,NULL,NULL,2,'cms')
,('cms_cpl_clause_control_scene','cpl_clause_control_scene','风控条款控制场景','风控条款控制场景',NULL,NULL,NULL,NULL,2,'cms')
,('cms_logical_operator','logical_operator','逻辑运算符','逻辑运算符',NULL,NULL,NULL,NULL,2,'cms')
,('cms_cpl_control_level','cpl_control_level','风控条款控制层级','风控条款控制层级',NULL,NULL,NULL,NULL,2,'cms')
,('cms_cpl_currency','cpl_currency','币种','币种',NULL,NULL,NULL,NULL,1,'cms')
;
INSERT INTO sys_dict_data (id,dict_key,remark,dict_name,creator_id,create_time,modifier_id,modify_time,dict_value_type,app_id) VALUES
('cms_cls_control_style','cls_control_style','条款控制方式','条款控制方式',NULL,NULL,NULL,NULL,2,'cms')
,('cms_cpl_cls_control_op','cpl_cls_control_op','控制方向','控制方向',NULL,NULL,NULL,NULL,2,'cms')
,('cms_cpl_cls_thre_level','cpl_cls_thre_level','触发级别','触发级别',NULL,NULL,NULL,NULL,2,'cms')
,('cms_cal_dms','cal_dms','一级计算维度','一级计算维度',NULL,NULL,NULL,NULL,2,'cms')
,('cms_val_form_type','val_form_type','风控因子表单类型','风控因子表单类型',NULL,NULL,NULL,NULL,2,'cms')
,('cms_cpl_cal_sub_dms','cpl_cal_sub_dms','二级计算维度','二级计算维度',NULL,NULL,NULL,NULL,2,'cms')
,('cms_cpl_cdn','cpl_cdn','条件因子归类','条件因子归类',NULL,NULL,NULL,NULL,2,'cms')
,('cms_cpl_cls_status','cpl_cls_status','条款状态','条款状态',NULL,NULL,NULL,NULL,2,'cms')
,('cms_cpl_cls_belong_class','cpl_cls_belong_class','归属分类','归属分类',NULL,NULL,NULL,NULL,2,'cms')
,('cms_inp_type','inp_type','入参类型','入参类型',NULL,NULL,NULL,NULL,2,'cms')
;
INSERT INTO sys_dict_data (id,dict_key,remark,dict_name,creator_id,create_time,modifier_id,modify_time,dict_value_type,app_id) VALUES
('cms_fat_type','fat_type','因子类型','因子类型',NULL,NULL,NULL,NULL,2,'cms')
,('cms_cpl_cal','cpl_cal','计算因子归类','计算因子归类',NULL,NULL,NULL,NULL,2,'cms')
,('cms_cpl_yes_no','cpl_yes_no','是否','是否',NULL,NULL,NULL,NULL,2,'cms')
,('cms_rela_secu_types','rela_secu_types','关联证券类型','关联证券类型',NULL,NULL,NULL,NULL,2,'cms')
,('cms_cpl_fml_status','cpl_fml_status','公式状态','公式状态',NULL,NULL,NULL,NULL,2,'cms')
,('cms_cpl_approval_status','cpl_approval_status','审批状态','审批状态',NULL,NULL,NULL,NULL,2,'cms')
,('cms_cms_fml_cls','cms_fml_cls','公式归类','公式归类',NULL,NULL,NULL,NULL,2,'cms')
,('cms_cpl_check_status','cpl_check_status','风控检查状态','风控检查状态',NULL,NULL,NULL,NULL,2,'cms')
;

INSERT INTO sys_dict_data_def (id,dict_id,value,name,en_name) VALUES
('rule_trade_type_code_T01.01.000.003','cms_rule_trade_type_code','T01.01.000.003','要约收购_买入','Tender Offer-Buy')
,('rule_trade_type_code_T01.01.000.004','cms_rule_trade_type_code','T01.01.000.004','要约收购_卖出','Tender Offer-Sell')
,('rule_trade_type_code_T01.01.000.005','cms_rule_trade_type_code','T01.01.000.005','预受要约','Pre-acceptance Offer')
,('rule_trade_type_code_T01.01.000.006','cms_rule_trade_type_code','T01.01.000.006','预受要约撤销','Pre-acceptance Offer Withdraw')
,('rule_trade_type_code_T01.01.000.007','cms_rule_trade_type_code','T01.01.000.007','议案投票','Proposal Voting')
,('rule_trade_type_code_T01.01.000.008','cms_rule_trade_type_code','T01.01.000.008','行权认购','Call Option Exercise ')
,('rule_trade_type_code_T01.01.000.009','cms_rule_trade_type_code','T01.01.000.009','行权认沽','Put Option Exercise ')
,('rule_trade_type_code_T01.01.001.001','cms_rule_trade_type_code','T01.01.001.001','新股认购','New Share Subscription')
,('cpl_business_type_0','cms_cpl_business_type','0','银行间现券','ibbond')
,('cpl_business_type_1','cms_cpl_business_type','1','银行间回购','ibrepo')
;
INSERT INTO sys_dict_data_def (id,dict_id,value,name,en_name) VALUES
('rule_trade_type_code_T01.01.001.003','cms_rule_trade_type_code','T01.01.001.003','新股中签','New Share Winning')
,('rule_trade_type_code_T02.04.000.018','cms_rule_trade_type_code','T02.04.000.018','逆回购延期购回','Reverse Repo Deferred Buy-back')
,('rule_trade_type_code_T02.04.000.019','cms_rule_trade_type_code','T02.04.000.019','融资购回','Financing Buyback')
,('rule_trade_type_code_T02.04.000.020','cms_rule_trade_type_code','T02.04.000.020','融券购回','Scurities Buyback')
,('rule_trade_type_code_T02.05.000.001','cms_rule_trade_type_code','T02.05.000.001','存款首期','Deposit Opening')
,('rule_trade_type_code_T02.05.000.002','cms_rule_trade_type_code','T02.05.000.002','存款到期','Deposit Maturity')
,('rule_trade_type_code_T02.05.000.003','cms_rule_trade_type_code','T02.05.000.003','存款提前支取','Deposit Advance Withdraw')
,('rule_trade_type_code_T02.05.000.004','cms_rule_trade_type_code','T02.05.000.004','存款转让','Deposit Transfer')
,('rule_trade_type_code_T02.05.000.005','cms_rule_trade_type_code','T02.05.000.005','同业拆入','Inter-bank Borrowing')
,('rule_trade_type_code_T02.05.000.006','cms_rule_trade_type_code','T02.05.000.006','同业拆出','Inter-bank Lending')
;
INSERT INTO sys_dict_data_def (id,dict_id,value,name,en_name) VALUES
('rule_trade_type_code_T02.05.000.007','cms_rule_trade_type_code','T02.05.000.007','盈亏结转','PNL Carry-over')
,('rule_trade_type_code_T03.01.000.001','cms_rule_trade_type_code','T03.01.000.001','买入开仓','Buy for Opening')
,('rule_trade_type_code_T03.01.000.002','cms_rule_trade_type_code','T03.01.000.002','卖出开仓','Sell for Opening')
,('rule_trade_type_code_T03.01.000.003','cms_rule_trade_type_code','T03.01.000.003','买入平仓','Buy for Closing')
,('rule_trade_type_code_T03.01.000.004','cms_rule_trade_type_code','T03.01.000.004','卖出平仓','Sell for Closing')
,('rule_trade_type_code_T03.01.000.005','cms_rule_trade_type_code','T03.01.000.005','期货交割','Futures Delivery')
,('rule_trade_type_code_T03.03.000.001','cms_rule_trade_type_code','T03.03.000.001','利率互换','Interest Rate Swap')
,('rule_trade_type_code_T00.00.000.001','cms_rule_trade_type_code','T00.00.000.001','资金划入','FUNDS_IN')
,('rule_trade_type_code_T00.00.000.002','cms_rule_trade_type_code','T00.00.000.002','资金划出','FUNDS_OUT')
,('rule_trade_type_code_T02.04.000.021','cms_rule_trade_type_code','T02.04.000.021','质押押出(回购)','BOND_PLEDGE_OUT')
;
INSERT INTO sys_dict_data_def (id,dict_id,value,name,en_name) VALUES
('rule_trade_type_code_T02.04.000.022','cms_rule_trade_type_code','T02.04.000.022','质押押入(回购)','BOND_PLEDGE_IN')
,('cpl_business_type_2','cms_cpl_business_type','2','交易所现券','ssebond')
,('cpl_business_type_3','cms_cpl_business_type','3','交易所回购','sserepo')
,('cpl_business_type_4','cms_cpl_business_type','4','银行存款','deposit')
,('cpl_business_type_5','cms_cpl_business_type','5','同业存单','cd')
,('cpl_business_type_6','cms_cpl_business_type','6','债券网下申购','bondipo')
,('cpl_business_type_7','cms_cpl_business_type','7','股票','ssestock')
,('cms_prd_control_level_AUNITU','cms_cms_prd_control_level','AUNITU','资产单元-联合','AUNITU')
,('cms_prd_control_level_PRD','cms_cms_prd_control_level','PRD','产品','PRD')
,('cms_prd_control_level_INTSTGU','cms_cms_prd_control_level','INTSTGU','投资策略-联合','INTSTGU')
;
INSERT INTO sys_dict_data_def (id,dict_id,value,name,en_name) VALUES
('cms_prd_control_level_INTSTG','cms_cms_prd_control_level','INTSTG','投资策略','INTSTG')
,('cpl_business_type_8','cms_cpl_business_type','8','期货','future')
,('cms_prd_control_level_AUNIT','cms_cms_prd_control_level','AUNIT','资产单元','AUNIT')
,('rule_unit_0','cms_rule_unit','0','无','none')
,('rule_unit_1','cms_rule_unit','1','%(比例)','percent')
,('rule_unit_2','cms_rule_unit','2','股','stock')
,('rule_unit_8','cms_rule_unit','8','元','yuan')
,('rule_unit_5','cms_rule_unit','5','天','day')
,('rule_unit_6','cms_rule_unit','6','月','month')
,('rule_unit_7','cms_rule_unit','7','年','year')
;
INSERT INTO sys_dict_data_def (id,dict_id,value,name,en_name) VALUES
('rule_unit_4','cms_rule_unit','4','张','sheet')
,('rule_trade_type_code_T01.01.001.004','cms_rule_trade_type_code','T01.01.001.004','新股流通','New Share Circulation')
,('rule_trade_type_code_T01.01.001.005','cms_rule_trade_type_code','T01.01.001.005','新股配售','New Share Allocation')
,('rule_trade_type_code_T01.01.001.006','cms_rule_trade_type_code','T01.01.001.006','新股配售中签','New Share Allocation Winning')
,('rule_trade_type_code_T01.01.001.007','cms_rule_trade_type_code','T01.01.001.007','新股增发','New Share Additional Issurance')
,('cpl_fml_type_BEHAVE','cms_cpl_fml_type','BEHAVE','行为','behave')
,('cpl_fml_type_BLEND','cms_cpl_fml_type','BLEND','混合','blend')
,('cpl_fml_type_TERM','cms_cpl_fml_type','TERM','期限','term')
,('cpl_fml_type_RATIO','cms_cpl_fml_type','RATIO','比例','ratio')
,('cpl_fml_type_SCOPE','cms_cpl_fml_type','SCOPE','范围','scope')
;
INSERT INTO sys_dict_data_def (id,dict_id,value,name,en_name) VALUES
('cpl_fml_type_QUOTA','cms_cpl_fml_type','QUOTA','额度','quota')
,('rule_trade_type_code_T01.01.001.008','cms_rule_trade_type_code','T01.01.001.008','新股增发中签','New Share Additional Issurance Winning')
,('rule_trade_type_code_T01.01.001.009','cms_rule_trade_type_code','T01.01.001.009','新股增发流通','Additional New Share Circulation')
,('rule_trade_type_code_T01.01.001.010','cms_rule_trade_type_code','T01.01.001.010','配股认购','Share Allocation Subscription')
,('rule_trade_type_code_T01.01.001.011','cms_rule_trade_type_code','T01.01.001.011','配股缴款','Share Allocation Payment')
,('rule_trade_type_code_T01.01.001.012','cms_rule_trade_type_code','T01.01.001.012','配股流通','Allocated Share Circulation')
,('rule_trade_type_code_T01.01.001.013','cms_rule_trade_type_code','T01.01.001.013','股票抽取','Stock Extraction')
,('rule_trade_type_code_T01.01.001.014','cms_rule_trade_type_code','T01.01.001.014','新股锁定','New Share Lock in')
,('rule_trade_type_code_T01.01.001.015','cms_rule_trade_type_code','T01.01.001.015','配股清算','Share Allocation Clearing')
,('rule_trade_type_code_T01.02.000.001','cms_rule_trade_type_code','T01.02.000.001','基金认购','Fund Subscription')
;
INSERT INTO sys_dict_data_def (id,dict_id,value,name,en_name) VALUES
('rule_trade_type_code_T01.02.000.002','cms_rule_trade_type_code','T01.02.000.002','基金成立','Fund set up')
,('rule_trade_type_code_T01.02.000.003','cms_rule_trade_type_code','T01.02.000.003','基金申购申请','Fund Subscription Application')
,('rule_trade_type_code_T01.02.000.004','cms_rule_trade_type_code','T01.02.000.004','申购确认','Subscription Confirmation')
,('rule_trade_type_code_T01.02.000.005','cms_rule_trade_type_code','T01.02.000.005','基金赎回申请','Fund Redemption Application')
,('rule_trade_type_code_T01.02.000.006','cms_rule_trade_type_code','T01.02.000.006','赎回确认','Redemption confirmation')
,('rule_trade_type_code_T01.02.000.007','cms_rule_trade_type_code','T01.02.000.007','基金赎回到帐','Fund Redemption to the account')
,('rule_trade_type_code_T01.02.000.008','cms_rule_trade_type_code','T01.02.000.008','基金转换','Fund Transfer')
,('rule_trade_type_code_T01.02.000.012','cms_rule_trade_type_code','T01.02.000.012','基金分红到帐','Fund Cash Dividend to the Account')
,('rule_trade_type_code_T01.02.000.013','cms_rule_trade_type_code','T01.02.000.013','基金升降级','Fund upgrading or downgrading')
,('rule_trade_type_code_T01.02.000.014','cms_rule_trade_type_code','T01.02.000.014','基金赎回','Fund Redemption')
;
INSERT INTO sys_dict_data_def (id,dict_id,value,name,en_name) VALUES
('rule_trade_type_code_T01.02.000.015','cms_rule_trade_type_code','T01.02.000.015','基金分红转投资','Fund dividend conversion to investment')
,('rule_trade_type_code_T01.02.000.016','cms_rule_trade_type_code','T01.02.000.016','基金申购','fund purchase')
,('rule_trade_type_code_T02.02.000.001','cms_rule_trade_type_code','T02.02.000.001','债券买入','Bond Buy')
,('rule_trade_type_code_T02.02.000.002','cms_rule_trade_type_code','T02.02.000.002','债券卖出','Bond Sell')
,('rule_trade_type_code_T02.02.000.003','cms_rule_trade_type_code','T02.02.000.003','债转股','Bond to Stock')
,('rule_trade_type_code_T02.02.000.004','cms_rule_trade_type_code','T02.02.000.004','配债','Bond Alloccation')
,('rule_trade_type_code_T02.02.000.005','cms_rule_trade_type_code','T02.02.000.005','配债中签','Bond Allocation Winning')
,('rule_trade_type_code_T02.02.000.006','cms_rule_trade_type_code','T02.02.000.006','配债上市流通','Allocated Bond Circulation')
,('rule_trade_type_code_T01.02.000.009','cms_rule_trade_type_code','T01.02.000.009','基金买入','Fund Buy')
,('rule_trade_type_code_T01.02.000.010','cms_rule_trade_type_code','T01.02.000.010','基金卖出','Fund Sell')
;
INSERT INTO sys_dict_data_def (id,dict_id,value,name,en_name) VALUES
('rule_trade_type_code_T01.02.000.011','cms_rule_trade_type_code','T01.02.000.011','基金现金分红','Fund Cash Dividend')
,('rule_trade_type_code_T02.02.000.007','cms_rule_trade_type_code','T02.02.000.007','债券分销-买入','Bond Distribution-Buy')
,('rule_trade_type_code_T02.02.000.008','cms_rule_trade_type_code','T02.02.000.008','债券分销-卖出','Bond Distribution-Sell')
,('rule_trade_type_code_T02.02.000.009','cms_rule_trade_type_code','T02.02.000.009','债券转托管(跨市场)','Bond Custody Transfer (Cross-Market)')
,('rule_trade_type_code_T02.02.000.010','cms_rule_trade_type_code','T02.02.000.010','转托管(深交所)','Custody Transfer (Shenzhen Stock Exchange)')
,('rule_trade_type_code_T02.02.000.011','cms_rule_trade_type_code','T02.02.000.011','债券承销','Bond Underwriting')
,('rule_trade_type_code_T02.02.000.012','cms_rule_trade_type_code','T02.02.000.012','债券回售','Bond put-back')
,('rule_trade_type_code_T02.02.000.013','cms_rule_trade_type_code','T02.02.000.013','债券投标','Bond tender')
,('rule_trade_type_code_T02.02.000.014','cms_rule_trade_type_code','T02.02.000.014','提交质押','Submit collateral')
,('rule_trade_type_code_T02.02.000.015','cms_rule_trade_type_code','T02.02.000.015','转回质押','Trasfer Back Collateral ')
;
INSERT INTO sys_dict_data_def (id,dict_id,value,name,en_name) VALUES
('rule_trade_type_code_T02.02.000.016','cms_rule_trade_type_code','T02.02.000.016','现券行权','Bond option exercise ')
,('rule_trade_type_code_T02.04.000.001','cms_rule_trade_type_code','T02.04.000.001','逆回购','Reverse Repo execution')
,('rule_trade_type_code_T02.04.000.002','cms_rule_trade_type_code','T02.04.000.002','正回购','Repo execution')
,('rule_trade_type_code_T02.04.000.003','cms_rule_trade_type_code','T02.04.000.003','逆回购(协议回购)','Reverse Repo (Agreement Repo)')
,('rule_trade_type_code_T02.04.000.004','cms_rule_trade_type_code','T02.04.000.004','正回购(协议回购)','Repo (Agreement Repo)')
,('rule_trade_type_code_T02.04.000.005','cms_rule_trade_type_code','T02.04.000.005','正回购到期','Repo Maturity')
,('rule_trade_type_code_T02.02.000.017','cms_rule_trade_type_code','T02.02.000.017','债券远期买入','Bond Forward Buy')
,('rule_trade_type_code_T02.02.000.018','cms_rule_trade_type_code','T02.02.000.018','债券远期卖出','Bond Forward Sell')
,('rule_trade_type_code_T02.02.000.019','cms_rule_trade_type_code','T02.02.000.019','分销卖出','Distribution Sell')
,('rule_trade_type_code_T02.02.000.020','cms_rule_trade_type_code','T02.02.000.020','债券认购','Bond Subscription')
;
INSERT INTO sys_dict_data_def (id,dict_id,value,name,en_name) VALUES
('rule_trade_type_code_T02.02.001.001','cms_rule_trade_type_code','T02.02.001.001','新债申购','New Bond Subscription')
,('rule_trade_type_code_T02.02.001.002','cms_rule_trade_type_code','T02.02.001.002','新债申购确认','New Bond Subscription Confirmation')
,('rule_trade_type_code_T02.02.001.003','cms_rule_trade_type_code','T02.02.001.003','新债中签','New Bond Winning')
,('rule_trade_type_code_T02.02.001.004','cms_rule_trade_type_code','T02.02.001.004','新债未中返还','New Bond Refund')
,('rule_trade_type_code_T02.02.002.001','cms_rule_trade_type_code','T02.02.002.001','债券计息','Bond Interest Accrual')
,('rule_trade_type_code_T02.04.000.006','cms_rule_trade_type_code','T02.04.000.006','逆回购到期','Reverse Repo Maturity')
,('rule_trade_type_code_T02.04.000.007','cms_rule_trade_type_code','T02.04.000.007','正回购换券','Repo collateral bond exchange ')
,('rule_trade_type_code_T02.04.000.008','cms_rule_trade_type_code','T02.04.000.008','逆回购换券','Reverse Repo Collateral Bond Exchange')
,('rule_trade_type_code_T02.04.000.009','cms_rule_trade_type_code','T02.04.000.009','正回购被换券','Repo Collateral Bond be exchanged')
,('rule_trade_type_code_T02.04.000.010','cms_rule_trade_type_code','T02.04.000.010','逆回购被换券','Reverse Repo Collateral Bond be exchanged')
;
INSERT INTO sys_dict_data_def (id,dict_id,value,name,en_name) VALUES
('rule_trade_type_code_T02.04.000.011','cms_rule_trade_type_code','T02.04.000.011','正回购续做','Repo Roll-over')
,('rule_trade_type_code_T02.04.000.012','cms_rule_trade_type_code','T02.04.000.012','逆回购续做','Reverse Repo Roll-over')
,('rule_trade_type_code_T02.04.000.013','cms_rule_trade_type_code','T02.04.000.013','正回购解除质押','Repo Collateral Removing')
,('rule_trade_type_code_T02.04.000.014','cms_rule_trade_type_code','T02.04.000.014','逆回购解除质押','Reverse Repo Collateral Removing')
,('rule_trade_type_code_T02.04.000.015','cms_rule_trade_type_code','T02.04.000.015','正回购提前到期','Repo Advance Maturity')
,('rule_trade_type_code_T02.04.000.016','cms_rule_trade_type_code','T02.04.000.016','逆回购提前到期','Reverse Repo Advance Maturity')
,('rule_trade_type_code_T02.04.000.017','cms_rule_trade_type_code','T02.04.000.017','正回购延期购回','Repo Deferred Buy-back')
,('cpl_clause_control_trade_stage_INS','cms_cpl_clause_control_trade_stage','INS','指令','INS')
,('cpl_clause_control_trade_stage_INQ','cms_cpl_clause_control_trade_stage','INQ','询价','INQ')
,('cpl_clause_control_trade_stage_ORD','cms_cpl_clause_control_trade_stage','ORD','委托','ORD')
;
INSERT INTO sys_dict_data_def (id,dict_id,value,name,en_name) VALUES
('cpl_clause_control_trade_stage_EXE','cms_cpl_clause_control_trade_stage','EXE','成交','EXE')
,('cpl_clause_control_trade_stage_INT','cms_cpl_clause_control_trade_stage','INT','意向','INT')
,('cpl_clause_control_trade_stage_PLL','cms_cpl_clause_control_trade_stage','PLL','巡检','PLL')
,('cpl_clause_control_scene_PRE','cms_cpl_clause_control_scene','PRE','事前','PRE')
,('cpl_clause_control_scene_ITRD','cms_cpl_clause_control_scene','ITRD','事中','ITRD')
,('logical_operator_or','cms_logical_operator','or','或','||')
,('logical_operator_and','cms_logical_operator','and','且','&&')
,('cpl_control_level_G','cms_cpl_control_level','G','产品组','fundgroup')
,('cpl_control_level_F','cms_cpl_control_level','F','产品','fund')
,('cpl_currency_1','cms_cpl_currency','1','人民币','CNY')
;
INSERT INTO sys_dict_data_def (id,dict_id,value,name,en_name) VALUES
('cpl_currency_2','cms_cpl_currency','2','美元','USD')
,('cpl_currency_3','cms_cpl_currency','3','港币','HKD')
,('cls_control_style_S','cms_cls_control_style','S','单一控制','S')
,('cls_control_style_U','cms_cls_control_style','U','联合控制','U')
,('cpl_cls_control_op_GT','cms_cpl_cls_control_op','GT','大于','GT')
,('cpl_cls_control_op_GTE','cms_cpl_cls_control_op','GTE','大于等于','GTE')
,('cpl_cls_control_op_LT','cms_cpl_cls_control_op','LT','小于','LT')
,('cpl_cls_control_op_LTE','cms_cpl_cls_control_op','LTE','小于等于','LTE')
,('cpl_cls_thre_level_W','cms_cpl_cls_thre_level','W','预警','W')
,('cpl_cls_thre_level_A1','cms_cpl_cls_thre_level','A1','一级审批','A1')
;
INSERT INTO sys_dict_data_def (id,dict_id,value,name,en_name) VALUES
('cpl_cls_thre_level_A2','cms_cpl_cls_thre_level','A2','二级审批','A2')
,('cpl_cls_thre_level_A3','cms_cpl_cls_thre_level','A3','三级审批','A3')
,('cpl_cls_thre_level_F','cms_cpl_cls_thre_level','F','禁止','F')
,('cpl_control_level_C','cms_cpl_control_level','C','公司','company')
,('cal_dms_SEC','cms_cal_dms','SEC','单证券','cal_dms_sec')
,('cal_dms_PTY','cms_cal_dms','PTY','单主体','cal_dms_pty')
,('cal_dms_SUM','cms_cal_dms','SUM','汇总','cal_dms_sum')
,('val_form_type_casmulti','cms_val_form_type','casmulti','多级多选列表','casmulti')
,('val_form_type_multi','cms_val_form_type','multi','多选列表','multi')
,('val_form_type_cassingle','cms_val_form_type','cassingle','多级单选列表','cassingle')
;
INSERT INTO sys_dict_data_def (id,dict_id,value,name,en_name) VALUES
('val_form_type_single','cms_val_form_type','single','单选列表','single')
,('val_form_type_text','cms_val_form_type','text','文本框','text')
,('val_form_type_date','cms_val_form_type','date','日期框','date')
,('val_form_type_time','cms_val_form_type','time','时间框','time')
,('cpl_cal_sub_dms_ISSUER','cms_cpl_cal_sub_dms','ISSUER','发行人','ISSUER')
,('cpl_cal_sub_dms_UNDERWRITER','cms_cpl_cal_sub_dms','UNDERWRITER','承销人','UNDERWRITER')
,('cpl_cal_sub_dms_GUARANTEE','cms_cpl_cal_sub_dms','GUARANTEE','担保人','GUARANTEE')
,('cpl_cal_sub_dms_ORIGOWNER','cms_cpl_cal_sub_dms','ORIGOWNER','原始权益人','ORIGOWNER')
,('cpl_cal_sub_dms_IBCOUNTER','cms_cpl_cal_sub_dms','IBCOUNTER','交易对手','IBCOUNTER')
,('cpl_cal_sub_dms_BEBTOR','cms_cpl_cal_sub_dms','BEBTOR','债务主体','BEBTOR')
;
INSERT INTO sys_dict_data_def (id,dict_id,value,name,en_name) VALUES
('cpl_cal_sub_dms_BANKHOF','cms_cpl_cal_sub_dms','BANKHOF','存款银行(总行)','BANKHOF')
,('cpl_cal_sub_dms_BANKBRANCH','cms_cpl_cal_sub_dms','BANKBRANCH','存款银行(分行)','BANKBRANCH')
,('cpl_cal_sub_dms_CURSEC','cms_cpl_cal_sub_dms','CURSEC','当前证券','CURSEC')
,('cpl_cal_sub_dms_RELSEC','cms_cpl_cal_sub_dms','RELSEC','跨市场证券','RELSEC')
,('cpl_cdn_1_1','cms_cpl_cdn','1_1','主体评级类','cd1')
,('cpl_cdn_1_2','cms_cpl_cdn','1_2','债项评级类','cd2')
,('cpl_cls_status_C','cms_cpl_cls_status','C','草稿','C')
,('cpl_cls_status_A','cms_cpl_cls_status','A','启用','A')
,('cpl_cls_status_D','cms_cpl_cls_status','D','下线','D')
,('cpl_cls_status_P','cms_cpl_cls_status','P','停用','P')
;
INSERT INTO sys_dict_data_def (id,dict_id,value,name,en_name) VALUES
('cpl_cls_status_N','cms_cpl_cls_status','N','新建','N')
,('cpl_cls_status_O','cms_cpl_cls_status','O','过期','O')
,('cpl_cls_belong_class_POLICY','cms_cpl_cls_belong_class','POLICY','政策','policy')
,('cpl_cls_belong_class_INTERNAL','cms_cpl_cls_belong_class','INTERNAL','内部','internal')
,('cpl_cls_belong_class_CONTRACT','cms_cpl_cls_belong_class','CONTRACT','契约','contract')
,('inp_type_INTF','cms_inp_type','INTF','接口','interface')
,('cpl_cdn_1_3','cms_cpl_cdn','1_3','产品属性类','cd3')
,('cpl_cdn_1_4','cms_cpl_cdn','1_4','交易类','cd4')
,('cpl_cdn_1_5','cms_cpl_cdn','1_5','主体类','cd5')
,('cpl_cdn_1_6','cms_cpl_cdn','1_6','期限类','cd6')
;
INSERT INTO sys_dict_data_def (id,dict_id,value,name,en_name) VALUES
('fat_type_CAL','cms_fat_type','CAL','计算因子','calFactor')
,('fat_type_CDN','cms_fat_type','CDN','条件因子','cdnFactor')
,('cpl_cal_0_1','cms_cpl_cal','0_1','股票类','ca1')
,('cpl_cal_0_2','cms_cpl_cal','0_2','债券类','ca2')
,('cpl_cal_0_3','cms_cpl_cal','0_3','基金类','ca3')
,('cpl_cal_0_4','cms_cpl_cal','0_4','回购类','ca4')
,('cpl_cal_0_5','cms_cpl_cal','0_5','存款类','ca5')
,('cpl_cal_0_6','cms_cpl_cal','0_6','期货类','ca6')
,('cpl_cal_0_7','cms_cpl_cal','0_7','期限类','ca7')
,('cpl_cal_0_8','cms_cpl_cal','0_8','主体类','ca8')
;
INSERT INTO sys_dict_data_def (id,dict_id,value,name,en_name) VALUES
('cpl_cal_0_9','cms_cpl_cal','0_9','资产估值类','ca9')
,('cpl_cal_0_10','cms_cpl_cal','0_10','条件行为类','ca10')
,('cpl_cdn_1_7','cms_cpl_cdn','1_7','股票类','cd7')
,('cpl_cdn_1_8','cms_cpl_cdn','1_8','债券类','cd8')
,('cpl_yes_no_N','cms_cpl_yes_no','N','否','no')
,('cpl_yes_no_Y','cms_cpl_yes_no','Y','是','yes')
,('cpl_cdn_1_9','cms_cpl_cdn','1_9','基金类','cd9')
,('cpl_cdn_1_10','cms_cpl_cdn','1_10','回购类','cd10')
,('cpl_cdn_1_11','cms_cpl_cdn','1_11','存款类','cd11')
,('inp_type_DICT','cms_inp_type','DICT','字典','dictionary')
;
INSERT INTO sys_dict_data_def (id,dict_id,value,name,en_name) VALUES
('cpl_cdn_1_12','cms_cpl_cdn','1_12','期货类','cd12')
,('cpl_cdn_1_13','cms_cpl_cdn','1_13','证券通用类','cd13')
,('rela_secu_types_*ALL','cms_rela_secu_types','*ALL','全部','all')
,('rela_secu_types_A01.01','cms_rela_secu_types','A01.01','股票','stock')
,('rela_secu_types_A01.02','cms_rela_secu_types','A01.02','基金','fund')
,('rela_secu_types_A02.02','cms_rela_secu_types','A02.02','债券','bond')
,('rela_secu_types_A02.03','cms_rela_secu_types','A02.03','资产支持证券','assetBacked')
,('rela_secu_types_A02.04','cms_rela_secu_types','A02.04','回购','repurchase')
,('rela_secu_types_A02.05.01','cms_rela_secu_types','A02.05.01','定期存款','timeDeposit')
,('rela_secu_types_A03.01','cms_rela_secu_types','A03.01','期货','futures')
;
INSERT INTO sys_dict_data_def (id,dict_id,value,name,en_name) VALUES
('rela_secu_types_N','cms_rela_secu_types','N','无','nix')
,('cpl_fml_status_C','cms_cpl_fml_status','C','草稿','C')
,('cpl_fml_status_A','cms_cpl_fml_status','A','可用','A')
,('cpl_fml_status_D','cms_cpl_fml_status','D','下线','D')
,('cpl_fml_status_N','cms_cpl_fml_status','N','新建','N')
,('cpl_clause_control_scene_EOD','cms_cpl_clause_control_scene','EOD','事后','EOD')
,('cpl_approval_status_CD','cms_cpl_approval_status','CD','待审批(废弃)','approval_status_cd')
,('cpl_approval_status_CN','cms_cpl_approval_status','CN','待审批(新建)','approval_status_cn')
,('cpl_approval_status_R','cms_cpl_approval_status','R','审批拒绝','approval_status_r')
,('cpl_approval_status_N','cms_cpl_approval_status','N','无需审批','approval_status_n')
;
INSERT INTO sys_dict_data_def (id,dict_id,value,name,en_name) VALUES
('cpl_approval_status_P','cms_cpl_approval_status','P','审批通过','approval_status_p')
,('cpl_approval_status_CU','cms_cpl_approval_status','CU','待审批(修改)','approval_status_cu')
,('cpl_approval_status_CA','cms_cpl_approval_status','CA','待审批(启用)','approval_status_ca')
,('cpl_approval_status_CP','cms_cpl_approval_status','CP','待审批(停用)','approval_status_cp')
,('cms_fml_cls_CDN','cms_cms_fml_cls','CDN','前提条件','cdn')
,('cms_fml_cls_BYD','cms_cms_fml_cls','BYD','风控公式','byd')
,('cpl_check_status_A1','cms_cpl_check_status','A1','一级审批','a1')
,('cpl_check_status_A2','cms_cpl_check_status','A2','二级审批','a2')
,('cpl_check_status_A3','cms_cpl_check_status','A3','三级审批','a3')
,('cpl_check_status_W','cms_cpl_check_status','W','预警','w')
;
INSERT INTO sys_dict_data_def (id,dict_id,value,name,en_name) VALUES
('cpl_check_status_E','cms_cpl_check_status','E','异常','e')
,('cpl_check_status_F','cms_cpl_check_status','F','禁止','f')
,('cpl_check_status_N','cms_cpl_check_status','N','检查通过','n')
,('cpl_check_status_D','cms_cpl_check_status','D','无需检查','d')
,('rule_trade_type_code_T01.01.001.002','cms_rule_trade_type_code','T01.01.001.002','新股返款','New Share Refund')
,('rule_trade_type_code_T01.01.000.001','cms_rule_trade_type_code','T01.01.000.001','股票买入','Stock buy')
,('rule_trade_type_code_T01.01.000.002','cms_rule_trade_type_code','T01.01.000.002','股票卖出','Stock Sell')
;