CREATE TABLE `push_log` (
`id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
`user_id` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户id',
`source` tinyint(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '消息推送来源，0：唐顿管家，1：法象物业',
`title` varchar(255) NOT NULL DEFAULT '' COMMENT '通知栏标题',
`text` varchar(2550) NOT NULL DEFAULT '' COMMENT '通知栏内容',
`terminal` tinyint(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '推送终端类型 0代表单个人 1代表ios 2代表安卓 3代表全部',
`type` tinyint(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '推送消息类型 0未知 1活动通知 2优惠通知 3订单通知',
`target` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '商品/服务/缴费/保修等详情id，用于推送直达详情页',
`push_status` tinyint(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '推送状态：0未完成 1已完成',
`read_status` tinyint(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户已读，0：未读，1：已读',
`del_status` tinyint(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户删除，0：否，1：是',
`creator` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建者id,代表管理员id',
`push_time` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '推送时间',
PRIMARY KEY (`id`)
)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
COMMENT = '系统推送日志表';