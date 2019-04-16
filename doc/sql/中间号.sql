-- ﻿申请中间号时，平台分配的账号和密码
CREATE TABLE `mid_account` (
`id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
`platform_id` char(16) NOT NULL DEFAULT '' COMMENT '分配给第三方平台的ID',
`secret` varchar(20) NOT NULL DEFAULT '' COMMENT '平台对应的密码',
`area_code` varchar(512) NOT NULL DEFAULT '' COMMENT '可用中间号地市(区号，不以0开头)，如：北京（10），多个可用地市用逗号做分割',
`region_id` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '小区id',
`name` varchar(255) NOT NULL DEFAULT '' COMMENT '小区名称/中间号购买方名称',
`create_time` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uniq_regionId` (`region_id` ASC) USING BTREE
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
COMMENT = '申请中间号时，平台分配的账号和密码';

-- ﻿中间号-二维码信息
CREATE TABLE `mid_qrcode` (
`id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
`region_id` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '小区id',
`name` varchar(255) NOT NULL DEFAULT '' COMMENT '二维码名称，用于直观反映该记录代表的小区-区-门-岗位',
`index` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '小区二维码的序号，按自然数增长',
`qrcode` char(32) NOT NULL DEFAULT '' COMMENT '二维码的唯一标识 md5(region_id +\'tdgj-mid\'+ index)',
`create_time` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建时间',
PRIMARY KEY (`id`) ,
CONSTRAINT `fk_mid_qrcode_mid_account_1` FOREIGN KEY (`region_id`) REFERENCES `mid_account` (`region_id`),
UNIQUE INDEX `uniq_key` (`qrcode` ASC) USING BTREE COMMENT '二维码唯一' ,
UNIQUE INDEX `uniq_regionId_index` (`region_id` ASC, `index` ASC) USING BTREE COMMENT '小区id+二维码序号 唯一'
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
COMMENT = '中间号-二维码信息';




-- 话单
CREATE TABLE `mid_bill` (
`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
`bind_id` varchar(30) NOT NULL DEFAULT '' COMMENT '绑定关系id，唯一确定一组绑定关系',
`call_id` varchar(30) NOT NULL DEFAULT '' COMMENT '通话id，唯一确定一次通话',
`call_no` varchar(20) NOT NULL DEFAULT '' COMMENT '主叫号码',
`peer_no` varchar(20) NOT NULL DEFAULT '' COMMENT '被叫号码',
`x` varchar(20) NOT NULL DEFAULT '' COMMENT '中间号码',
`call_time` char(14) NOT NULL DEFAULT '' COMMENT '通话发生时间，14位YYYYMMDDHHMMSS格式',
`start_time` char(14) NOT NULL DEFAULT '' COMMENT '通话开始时间，14位YYYYMMDDHHMMSS格式',
`finish_time` char(14) NOT NULL DEFAULT '' COMMENT '通话结束时间，14位YYYYMMDDHHMMSS格式',
`call_duration` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '通话时长，单位秒',
`finish_type` varchar(2) NOT NULL DEFAULT '' COMMENT '结束发起方：\r\n0：平台结束；\r\n1：主叫结束；\r\n2：被叫结束；',
`finish_state` varchar(2) NOT NULL DEFAULT '' COMMENT '结束状态（挂断原因）：\r\n1：主叫挂机；\r\n2：被叫挂机；\r\n3：主叫放弃；\r\n4：被叫无应答；\r\n5：被叫忙；\r\n6：被叫不可及；\r\n7：路又失败；\r\n8：中间号状态异常；\r\n9：订单超过有效期；\r\n10：平台系统异常；\r\n1-5 属于正常，6-10可视为异常',
`region_id` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '小区id',
PRIMARY KEY (`id`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
COMMENT = '中间号通话话单';

-- 中间号操作日志
CREATE TABLE `mid_action_log` (
`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
`region_id` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '小区id',
`call_no` varchar(20) NOT NULL DEFAULT '' COMMENT '主叫号码（终端用户）',
`qrcode_name` varchar(255) NOT NULL DEFAULT '' COMMENT '二维码名称',
`action` varchar(255) NOT NULL DEFAULT '' COMMENT '行为描述',
`action_time` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '行为发生时间，以秒为单位的时间戳',
PRIMARY KEY (`id`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
COMMENT = '中间号操作日志';

-- 中间号-用户登陆信息
CREATE TABLE `mid_login_info` (
`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
`qrcode` char(32) NOT NULL DEFAULT '' COMMENT '二维码的唯一标识',
`call_no` varchar(20) NOT NULL DEFAULT '' COMMENT '通过二维码扫描登陆的用户手机号',
`login_time` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户登陆时间',
`login_token` char(16) NOT NULL DEFAULT '' COMMENT '用户登陆令牌 - md5(qrcode+call_no+login_time)',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uniq_key` (`qrcode` ASC) USING BTREE,
UNIQUE INDEX `uniq_token` (`login_token` ASC) USING BTREE
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
COMMENT = '中间号-用户登陆信息';

-- 中间号申请结果表
CREATE TABLE `mid_apply_result` (
`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
`code` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '绑定接口响应码',
`message` varchar(255) NOT NULL DEFAULT '' COMMENT '返回结果描述',
`bind_id` varchar(30) NOT NULL DEFAULT '' COMMENT '绑定关系id，唯一确定一组绑定关系',
`x` varchar(20) NOT NULL DEFAULT '' COMMENT '中间号码',
`region_id` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '小区id',
`call_no` varchar(20) NOT NULL DEFAULT '' COMMENT '主叫号码',
`apply_time` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '申请中间号的时间',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uniq_bindId` (`bind_id` ASC) USING BTREE COMMENT '唯一标识一次通话'
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
COMMENT = '中间号申请结果表';


-- 中间号后台管理员账号
CREATE TABLE `mid_admin` (
`id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
`region_id` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '小区id',
`username` varchar(50) NOT NULL DEFAULT '' COMMENT '账号名称',
`password` char(32) NOT NULL DEFAULT '' COMMENT '密码 - md5(md5(username).toUpperCase()+\"mid-201806\"+md5(‘用户输入的密码’).toUpperCase()).toUpperCase()',
`create_time` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '账号添加时间',
`status` tinyint(2) UNSIGNED NOT NULL DEFAULT 1 COMMENT '账号状态：0-禁用，1-启用',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uniq_username` (`username` ASC) USING BTREE COMMENT '账号唯一'
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
COMMENT = '中间号后台账号密码信息';





-- imei-mobile对应关系
CREATE TABLE `mid_imei_mobile` (
`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
`imei` varchar(30) NOT NULL DEFAULT '' COMMENT '手机IMEI值',
`mobile` char(11) NOT NULL DEFAULT '' COMMENT '手机号',
`cid` varchar(50) NOT NULL DEFAULT '' COMMENT '推送id',
`create_time` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '添加时间',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uniq_imei` (`imei` ASC) USING BTREE COMMENT 'imei唯一'
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
COMMENT = '中间号 - IMEI和手机号对应关系表';


-- 手机号-验证码映射关系
CREATE TABLE `mid_mobile_code` (
`id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
`mobile` char(11) NOT NULL DEFAULT '' COMMENT '手机号',
`code` varchar(10) NOT NULL DEFAULT '' COMMENT '验证码',
`last_time` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '添加时间',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uniq_mobile` (`mobile` ASC) USING BTREE COMMENT '手机号唯一'
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
COMMENT = '中间号 - 手机号/验证码映射关系';



-- 修改household表字段类型
alter table household modify column `gender` tinyint(2) unsigned NOT NULL DEFAULT '0' COMMENT '性别, 0未知 1男 2女';
alter table household modify column `status` tinyint(2) unsigned NOT NULL DEFAULT '1' COMMENT '用户状态  1 正常  2 禁止';
alter table household add column `payment_date` date DEFAULT '0000-00-00' COMMENT '应缴费日期' after status;


-- 版本更新
CREATE TABLE `mid_version_info` (
`id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
`name` varchar(10) NOT NULL DEFAULT '' COMMENT '版本名称，如 v1.1.0',
`version` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '版本号，正整数递增',
`type` tinyint(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新类型，0-非强制更新，1-强制更新',
`download_url` varchar(255) NOT NULL DEFAULT '' COMMENT '更新包地址',
`description` varchar(3000) NOT NULL DEFAULT '' COMMENT '更新说明',
`update_time` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新时间',
PRIMARY KEY (`id`) ,
UNIQUE INDEX `uniq_mobile` (`name` ASC) USING BTREE COMMENT '手机号唯一'
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
COMMENT = '中间号 - 版本更新';