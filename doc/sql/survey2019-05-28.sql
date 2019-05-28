/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50528
 Source Host           : localhost:3306
 Source Schema         : survey

 Target Server Type    : MySQL
 Target Server Version : 50528
 File Encoding         : 65001

 Date: 28/05/2019 22:42:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `headmaster` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `teacher` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for image_resource
-- ----------------------------
DROP TABLE IF EXISTS `image_resource`;
CREATE TABLE `image_resource`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '资源ID',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '资源地址',
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '资源类型，fileType',
  `size` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '资源大小，字节长度',
  `width` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '图片宽度',
  `height` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '图片高度',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '图片表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of image_resource
-- ----------------------------
INSERT INTO `image_resource` VALUES (1, 'sysuser\\IMAGE\\2019\\5\\21\\4CCEDBECCF0CBF55ED6E9A3D50F14F75.png', 'image/png', 104664, 1024, 768);
INSERT INTO `image_resource` VALUES (2, 'sysuser\\IMAGE\\2019\\5\\22\\3CE8E8F6ACE5565DEEA9346729DDB7B6.jpg', 'image/jpeg', 124098, 1242, 900);
INSERT INTO `image_resource` VALUES (3, 'sysuser\\IMAGE\\2019\\5\\22\\EAD7CFC64AB9467D146ACA4B036EB9F9.png', 'image/png', 32191, 900, 608);
INSERT INTO `image_resource` VALUES (4, 'sysuser\\IMAGE\\2019\\5\\22\\BCDE5E34509376FC3C748BB99EEBACF9.png', 'image/png', 32191, 900, 608);
INSERT INTO `image_resource` VALUES (5, 'sysuser\\IMAGE\\2019\\5\\22\\27BE082D73DE09E9E02BC351B1993DE0.png', 'image/png', 33362, 638, 342);
INSERT INTO `image_resource` VALUES (6, 'sysuser\\IMAGE\\2019\\5\\22\\D44CC6B598CC25BFC18BCA162B6356D7.png', 'image/png', 32191, 900, 608);
INSERT INTO `image_resource` VALUES (7, 'sysuser\\IMAGE\\2019\\5\\22\\3D2245AA4ABAEFC3FCFD9A4AAEAEC0A1.jpg', 'image/jpeg', 36959, 1014, 668);
INSERT INTO `image_resource` VALUES (8, 'sysuser\\IMAGE\\2019\\5\\22\\E2833E5CF88C4948BFD95B0F51E095DC.jpg', 'image/jpeg', 124098, 1242, 900);
INSERT INTO `image_resource` VALUES (9, 'sysuser\\IMAGE\\2019\\5\\22\\8A7839500B178809617B2BEC216C09D2.png', 'image/png', 32191, 900, 608);
INSERT INTO `image_resource` VALUES (10, 'sysuser\\IMAGE\\2019\\5\\22\\693C3C55BB1FB289CCF4F1C2709F75F2.png', 'image/png', 33362, 638, 342);
INSERT INTO `image_resource` VALUES (11, 'sysuser\\IMAGE\\2019\\5\\22\\64CDD05E9CB4F696BE23AF2EBC61DC6D.jpg', 'image/jpeg', 57739, 501, 892);
INSERT INTO `image_resource` VALUES (12, 'sysuser\\IMAGE\\2019\\5\\22\\6CE68A0CDC32227155A65F8DCE20583F.png', 'image/png', 33362, 638, 342);
INSERT INTO `image_resource` VALUES (13, 'sysuser\\IMAGE\\2019\\5\\22\\B7313CB25584EE90087FDBDB82942E0B.jpg', 'image/jpeg', 57739, 501, 892);
INSERT INTO `image_resource` VALUES (14, 'sysuser\\IMAGE\\2019\\5\\22\\709157F14BC5A695CD24A4BE6D28C9DB.png', 'image/png', 33362, 638, 342);
INSERT INTO `image_resource` VALUES (15, 'sysuser\\IMAGE\\2019\\5\\22\\44F5A2F32ABA2A9D33CFF6B59E4B7301.jpg', 'image/jpeg', 124098, 1242, 900);
INSERT INTO `image_resource` VALUES (16, 'sysuser\\IMAGE\\2019\\5\\22\\1C627F21BEE6B0F9BD9081FD52752397.jpg', 'image/jpeg', 36959, 1014, 668);
INSERT INTO `image_resource` VALUES (17, 'sysuser\\IMAGE\\2019\\5\\22\\6C5161F26C6C5C49CC595E49B3C87036.jpg', 'image/jpeg', 36959, 1014, 668);
INSERT INTO `image_resource` VALUES (18, 'sysuser\\IMAGE\\2019\\5\\22\\9D8A4B0C6C9734B695D8D08DDB5CDCA7.jpg', 'image/jpeg', 124098, 1242, 900);
INSERT INTO `image_resource` VALUES (19, 'sysuser\\IMAGE\\2019\\5\\22\\702465FC07BA08D5F19B701AA40D433E.jpg', 'image/jpeg', 124098, 1242, 900);
INSERT INTO `image_resource` VALUES (20, 'sysuser\\IMAGE\\2019\\5\\22\\B39D4EBBC43894A64BE1E83BBBB8FE8B.jpg', 'image/jpeg', 124098, 1242, 900);
INSERT INTO `image_resource` VALUES (21, 'sysuser\\IMAGE\\2019\\5\\22\\5E459DE3B700919704C5AA09B4B2A8A6.jpg', 'image/jpeg', 124098, 1242, 900);
INSERT INTO `image_resource` VALUES (22, 'sysuser\\IMAGE\\2019\\5\\22\\2EAD2BD7B0188496512C918434B367D1.png', 'image/png', 5822, 1155, 242);
INSERT INTO `image_resource` VALUES (23, 'sysuser\\IMAGE\\2019\\5\\22\\3BA75A8188B860AEDF57BAF1D1F80401.jpg', 'image/jpeg', 57739, 501, 892);
INSERT INTO `image_resource` VALUES (24, 'sysuser\\IMAGE\\2019\\5\\22\\774FEEE2A3B5675794194F686E63E3A4.jpg', 'image/jpeg', 124098, 1242, 900);
INSERT INTO `image_resource` VALUES (25, 'sysuser\\IMAGE\\2019\\5\\22\\6EE26D1DEA1E41AC10D34D8EE45A93EF.jpg', 'image/jpeg', 57739, 501, 892);
INSERT INTO `image_resource` VALUES (26, 'sysuser\\IMAGE\\2019\\5\\22\\28E4EFAE7D8E74972DA1A7B04E9E99BF.png', 'image/png', 32191, 900, 608);
INSERT INTO `image_resource` VALUES (27, 'sysuser\\IMAGE\\2019\\5\\22\\C96D945275C452117CE82149AA4325E8.jpg', 'image/jpeg', 124098, 1242, 900);
INSERT INTO `image_resource` VALUES (28, 'sysuser\\IMAGE\\2019\\5\\22\\16A3502F60AFEA04A99389AA83FA7086.png', 'image/png', 6427, 904, 472);
INSERT INTO `image_resource` VALUES (29, 'sysuser\\image\\2019\\5\\22\\81477AEBADD87BD217CC76BAFB855808.jpg', 'image/jpeg', 124098, 1242, 900);
INSERT INTO `image_resource` VALUES (30, 'sysuser\\image\\2019\\5\\22\\BE8633A13538DF7386D6E7AAE97B35AD.png', 'image/png', 32191, 900, 608);
INSERT INTO `image_resource` VALUES (31, 'sysuser\\image\\2019\\5\\22\\B39EAFF51921B61F5356B45090FD7D93.jpg', 'image/jpeg', 57739, 501, 892);
INSERT INTO `image_resource` VALUES (32, 'sysuser\\image\\2019\\5\\22\\28FA01D2FD904667A94B6DA62614A5D8.jpg', 'image/jpeg', 57739, 501, 892);
INSERT INTO `image_resource` VALUES (33, 'sysuser\\image\\2019\\5\\22\\BA51718F425475146CCDF6F286EC00C9.jpg', 'image/jpeg', 57739, 501, 892);
INSERT INTO `image_resource` VALUES (34, 'sysuser\\image\\2019\\5\\22\\03A8B2304C1E68559A45574551D30799.png', 'image/png', 32191, 900, 608);
INSERT INTO `image_resource` VALUES (35, 'sysuser\\image\\2019\\5\\22\\30EBFBBBF37F73406A4DA9EF1EC3ECE9.jpg', 'image/jpeg', 124098, 1242, 900);
INSERT INTO `image_resource` VALUES (36, 'sysuser\\IMAGE\\2019\\5\\25\\0C5E936C9A2AB992E5F189F81CCBB7C8.png', 'image/png', 98195, 1024, 768);

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `classname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `examDate` datetime NULL DEFAULT NULL,
  `paper_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `paper_id`(`paper_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for log_answer
-- ----------------------------
DROP TABLE IF EXISTS `log_answer`;
CREATE TABLE `log_answer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `log_id` int(11) NULL DEFAULT NULL,
  `question_id` int(11) NULL DEFAULT NULL,
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `log_id`(`log_id`) USING BTREE,
  INDEX `question_id`(`question_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for options
-- ----------------------------
DROP TABLE IF EXISTS `options`;
CREATE TABLE `options`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `optName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `question_id` int(11) NULL DEFAULT NULL,
  `disorder` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `question_id`(`question_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createDate` datetime NULL DEFAULT NULL,
  `time` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for paper_question
-- ----------------------------
DROP TABLE IF EXISTS `paper_question`;
CREATE TABLE `paper_question`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `paper_id` int(11) NULL DEFAULT NULL,
  `question_id` int(11) NULL DEFAULT NULL,
  `disorder` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `paper_id`(`paper_id`) USING BTREE,
  INDEX `question_id`(`question_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quesName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `type_id`(`type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for questiontype
-- ----------------------------
DROP TABLE IF EXISTS `questiontype`;
CREATE TABLE `questiontype`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for strategy
-- ----------------------------
DROP TABLE IF EXISTS `strategy`;
CREATE TABLE `strategy`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `strName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `isopen` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for strategy_info
-- ----------------------------
DROP TABLE IF EXISTS `strategy_info`;
CREATE TABLE `strategy_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `str_id` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `str_id`(`str_id`) USING BTREE,
  INDEX `type_id`(`type_id`) USING BTREE,
  CONSTRAINT `strategy_info_ibfk_1` FOREIGN KEY (`str_id`) REFERENCES `strategy` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `strategy_info_ibfk_2` FOREIGN KEY (`type_id`) REFERENCES `questiontype` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT 0 COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '菜单名称',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '菜单URL',
  `perms` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) NULL DEFAULT 0 COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '菜单图标',
  `order_num` int(11) NULL DEFAULT 0 COMMENT '排序',
  `create_by` bigint(20) NULL DEFAULT 0,
  `update_by` bigint(20) NULL DEFAULT 0,
  `create_time` datetime NULL DEFAULT '0000-00-00 00:00:00',
  `update_time` datetime NULL DEFAULT '0000-00-00 00:00:00',
  `del_flag` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1116961835054452738 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单管理' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (2, 0, '系统首页', 'dashboard', 'sys:dashboard:info', 1, 'el-icon-lx-home', 0, 1, 1, '2018-12-06 14:54:07', '2018-12-06 14:54:09', 0);
INSERT INTO `sys_menu` VALUES (15, 0, '系统管理', 'sys', 'sys:user:delete', 0, 'el-icon-lx-settings', 15, 1, 1, '2018-12-10 17:52:34', '2018-12-10 17:52:37', 0);
INSERT INTO `sys_menu` VALUES (16, 15, '用户管理', 'sysuser', 'sys:user:list', 1, NULL, 16, 1, 1, '2018-12-10 18:28:59', '2019-01-02 10:38:09', 0);
INSERT INTO `sys_menu` VALUES (17, 15, '角色管理', 'sysrole', 'sys:role:list', 1, NULL, 17, 1, 1, '2018-12-10 18:35:34', '2019-01-03 01:33:09', 0);
INSERT INTO `sys_menu` VALUES (18, 15, '菜单管理', 'sysmenu', 'sys:menu:tree', 1, NULL, 18, 1, 1, '2018-12-10 18:36:16', '2019-01-03 01:39:01', 0);
INSERT INTO `sys_menu` VALUES (19, 15, '部门管理', 'sysdept', 'sys:dept:tree', 1, NULL, 19, 1, 1, '2018-12-10 18:37:20', '2019-01-03 01:41:49', 0);
INSERT INTO `sys_menu` VALUES (21, 15, '定时任务', 'schedulejob', 'sys:schedule:list', 1, NULL, 21, 1, 1, '2018-12-10 18:39:14', '2019-01-03 01:42:33', 0);
INSERT INTO `sys_menu` VALUES (1080412372541181953, 16, '新增/编辑', 'sysuser/save', 'sys:user:save', 2, NULL, 1, NULL, NULL, '2019-01-02 10:35:57', '2019-01-02 10:37:26', 0);
INSERT INTO `sys_menu` VALUES (1080413095496585218, 16, '删除', 'sysuser/del', 'sys:user:del', 2, NULL, 2, NULL, NULL, '2019-01-02 10:38:50', '2019-01-02 10:38:50', 0);
INSERT INTO `sys_menu` VALUES (1080636440926232577, 16, '重置密码', 'sysuser/reset/password', 'sys:user:resetPassword', 2, NULL, 3, NULL, NULL, '2019-01-03 01:26:19', '2019-01-03 01:29:49', 0);
INSERT INTO `sys_menu` VALUES (1080636634896015362, 16, '修改密码', 'sysuser/change/password', 'sys:user:changePassword', 2, NULL, 4, NULL, NULL, '2019-01-03 01:27:06', '2019-01-03 01:30:05', 0);
INSERT INTO `sys_menu` VALUES (1080637598663188481, 17, '新增/编辑', 'sysrole/save', 'sys:role:save', 2, NULL, 1, NULL, NULL, '2019-01-03 01:30:55', '2019-01-03 01:30:55', 0);
INSERT INTO `sys_menu` VALUES (1080637823859564545, 17, '删除', 'sysrole/del', 'sys:role:del', 2, NULL, 2, NULL, NULL, '2019-01-03 01:31:49', '2019-01-03 01:31:49', 0);
INSERT INTO `sys_menu` VALUES (1080638043456544769, 17, '权限配置', 'sysrole/save/menu/perm', 'sys:role:saveMenuPerm', 2, NULL, 3, NULL, NULL, '2019-01-03 01:32:42', '2019-01-03 01:32:42', 0);
INSERT INTO `sys_menu` VALUES (1080639293405274114, 18, '保存', 'sysmenu/save', 'sys:menu:save', 2, NULL, 1, NULL, NULL, '2019-01-03 01:37:40', '2019-01-03 01:37:40', 0);
INSERT INTO `sys_menu` VALUES (1080639432148656130, 18, '删除', 'sysmenu/del', 'sys:menu:delete', 2, NULL, 2, NULL, NULL, '2019-01-03 01:38:13', '2019-01-03 01:38:13', 0);
INSERT INTO `sys_menu` VALUES (1080639575438663681, 18, '详情', 'sysmenu/info', 'sys:menu:info', 2, NULL, 3, NULL, NULL, '2019-01-03 01:38:47', '2019-01-03 01:38:47', 0);
INSERT INTO `sys_menu` VALUES (1080639863587348482, 19, '保存', 'sysdept/save', 'sys:dept:save', 2, NULL, 1, NULL, NULL, '2019-01-03 01:39:55', '2019-01-03 01:39:55', 0);
INSERT INTO `sys_menu` VALUES (1080640119691550722, 19, '删除', 'sysdept/del', 'sys:dept:del', 2, NULL, 2, NULL, NULL, '2019-01-03 01:40:57', '2019-01-03 01:40:57', 0);
INSERT INTO `sys_menu` VALUES (1080640228772814849, 19, '详情', 'sysdept/info', 'sys:dept:info', 2, NULL, 3, NULL, NULL, '2019-01-03 01:41:23', '2019-01-03 01:41:23', 0);
INSERT INTO `sys_menu` VALUES (1080640763785650177, 21, '新增', 'schedule/save', 'sys:schedule:save', 2, NULL, 1, NULL, NULL, '2019-01-03 01:43:30', '2019-01-03 01:43:30', 0);
INSERT INTO `sys_menu` VALUES (1080640900176027650, 21, '修改', 'schedule/update', 'sys:schedule:update', 2, NULL, 2, NULL, NULL, '2019-01-03 01:44:03', '2019-01-03 01:44:03', 0);
INSERT INTO `sys_menu` VALUES (1080641066287243266, 21, '删除', 'schedule/del', 'sys:schedule:del', 2, NULL, 3, NULL, NULL, '2019-01-03 01:44:42', '2019-01-03 01:44:42', 0);
INSERT INTO `sys_menu` VALUES (1116603445676101634, 15, '登陆日志', 'loginlog', 'sys:user:update', 1, NULL, 22, NULL, NULL, '2019-04-12 07:26:22', '2019-04-12 07:26:33', 0);
INSERT INTO `sys_menu` VALUES (1116613754159702018, 15, '业务日志', 'operationlog', 'sys:user:save', 1, NULL, 23, NULL, NULL, '2019-04-12 08:07:19', '2019-04-12 08:07:19', 0);
INSERT INTO `sys_menu` VALUES (1116961835054452737, 15, '字典管理', 'sysdict', NULL, 1, NULL, 24, NULL, NULL, '2019-04-13 07:10:28', '2019-04-13 07:10:28', 0);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '角色名称',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注',
  `create_time` datetime NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1076685137679704066 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', '超级管理员', '2018-10-10 22:39:38', '2018-12-23 11:45:49');
INSERT INTO `sys_role` VALUES (1076685137679704065, '游客', '游客', '2018-12-23 03:45:15', '2019-04-12 07:12:41');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT 0 COMMENT '角色ID',
  `menu_id` bigint(20) NULL DEFAULT 0 COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 362 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色与菜单对应关系' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (168, 1076685137679704065, 1);
INSERT INTO `sys_role_menu` VALUES (169, 1076685137679704065, 15);
INSERT INTO `sys_role_menu` VALUES (170, 1076685137679704065, 16);
INSERT INTO `sys_role_menu` VALUES (171, 1076685137679704065, 17);
INSERT INTO `sys_role_menu` VALUES (172, 1076685137679704065, 18);
INSERT INTO `sys_role_menu` VALUES (173, 1076685137679704065, 19);
INSERT INTO `sys_role_menu` VALUES (174, 1076685137679704065, 21);
INSERT INTO `sys_role_menu` VALUES (251, 1076685137679704066, 16);
INSERT INTO `sys_role_menu` VALUES (252, 1076685137679704066, 1080412372541181953);
INSERT INTO `sys_role_menu` VALUES (253, 1076685137679704066, 1080413095496585218);
INSERT INTO `sys_role_menu` VALUES (254, 1076685137679704066, 1080636440926232577);
INSERT INTO `sys_role_menu` VALUES (255, 1076685137679704066, 1080636634896015362);
INSERT INTO `sys_role_menu` VALUES (256, 1076685137679704066, 17);
INSERT INTO `sys_role_menu` VALUES (257, 1076685137679704066, 1080637598663188481);
INSERT INTO `sys_role_menu` VALUES (258, 1076685137679704066, 1080637823859564545);
INSERT INTO `sys_role_menu` VALUES (259, 1076685137679704066, 1080638043456544769);
INSERT INTO `sys_role_menu` VALUES (274, 1076685137679704068, 2);
INSERT INTO `sys_role_menu` VALUES (275, 1076685137679704068, 16);
INSERT INTO `sys_role_menu` VALUES (276, 1076685137679704068, 1080412372541181953);
INSERT INTO `sys_role_menu` VALUES (277, 1076685137679704068, 1080413095496585218);
INSERT INTO `sys_role_menu` VALUES (278, 1076685137679704068, 1080636440926232577);
INSERT INTO `sys_role_menu` VALUES (279, 1076685137679704068, 1080636634896015362);
INSERT INTO `sys_role_menu` VALUES (280, 1076685137679704068, 17);
INSERT INTO `sys_role_menu` VALUES (281, 1076685137679704068, 1080637598663188481);
INSERT INTO `sys_role_menu` VALUES (282, 1076685137679704068, 1080637823859564545);
INSERT INTO `sys_role_menu` VALUES (283, 1076685137679704068, 1080638043456544769);
INSERT INTO `sys_role_menu` VALUES (284, 1076685137679704068, 18);
INSERT INTO `sys_role_menu` VALUES (285, 1076685137679704068, 1080639293405274114);
INSERT INTO `sys_role_menu` VALUES (286, 1076685137679704068, 1080639432148656130);
INSERT INTO `sys_role_menu` VALUES (287, 1076685137679704068, 1080639575438663681);
INSERT INTO `sys_role_menu` VALUES (336, 1, 2);
INSERT INTO `sys_role_menu` VALUES (337, 1, 15);
INSERT INTO `sys_role_menu` VALUES (338, 1, 16);
INSERT INTO `sys_role_menu` VALUES (339, 1, 1080412372541181953);
INSERT INTO `sys_role_menu` VALUES (340, 1, 1080413095496585218);
INSERT INTO `sys_role_menu` VALUES (341, 1, 1080636440926232577);
INSERT INTO `sys_role_menu` VALUES (342, 1, 1080636634896015362);
INSERT INTO `sys_role_menu` VALUES (343, 1, 17);
INSERT INTO `sys_role_menu` VALUES (344, 1, 1080637598663188481);
INSERT INTO `sys_role_menu` VALUES (345, 1, 1080637823859564545);
INSERT INTO `sys_role_menu` VALUES (346, 1, 1080638043456544769);
INSERT INTO `sys_role_menu` VALUES (347, 1, 18);
INSERT INTO `sys_role_menu` VALUES (348, 1, 1080639293405274114);
INSERT INTO `sys_role_menu` VALUES (349, 1, 1080639432148656130);
INSERT INTO `sys_role_menu` VALUES (350, 1, 1080639575438663681);
INSERT INTO `sys_role_menu` VALUES (351, 1, 19);
INSERT INTO `sys_role_menu` VALUES (352, 1, 1080639863587348482);
INSERT INTO `sys_role_menu` VALUES (353, 1, 1080640119691550722);
INSERT INTO `sys_role_menu` VALUES (354, 1, 1080640228772814849);
INSERT INTO `sys_role_menu` VALUES (355, 1, 21);
INSERT INTO `sys_role_menu` VALUES (356, 1, 1080640763785650177);
INSERT INTO `sys_role_menu` VALUES (357, 1, 1080640900176027650);
INSERT INTO `sys_role_menu` VALUES (358, 1, 1080641066287243266);
INSERT INTO `sys_role_menu` VALUES (359, 1, 1116603445676101634);
INSERT INTO `sys_role_menu` VALUES (360, 1, 1116613754159702018);
INSERT INTO `sys_role_menu` VALUES (361, 1, 1116961835054452737);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '头像',
  `account` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '账号',
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '密码',
  `salt` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT 'md5密码盐',
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '名字',
  `dept_id` bigint(20) NULL DEFAULT 0,
  `birthday` datetime NULL DEFAULT '0000-00-00 00:00:00' COMMENT '生日',
  `sex` int(11) NULL DEFAULT 0 COMMENT '性别（1：男 2：女）',
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '电子邮件',
  `phone` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '电话',
  `status` int(11) NULL DEFAULT 0 COMMENT '状态(1：启用  2：冻结  3：删除）',
  `version` int(11) NULL DEFAULT 0 COMMENT '保留字段',
  `create_by` bigint(20) NULL DEFAULT 0,
  `update_by` bigint(20) NULL DEFAULT 0,
  `create_time` datetime NULL DEFAULT '0000-00-00 00:00:00',
  `update_time` datetime NULL DEFAULT '0000-00-00 00:00:00',
  `del_flag` tinyint(1) NULL DEFAULT 0,
  `head_image_id` int(10) UNSIGNED NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `account`(`account`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1072429679148908501 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'https://wx.qlogo.cn/mmopen/vi_32/WgSOjJRaQq8FbBHGAr5gLHdaVia7SrnOwRZ9TL8lcDicXuMgqSR8rVgebFa9uIRiaLzYrPdtIia3jqjzkHVVOS38sw/132', 'admin', '123456', 'BFDze8hBJwwhOw3BDvhg', 'admin', 4, '2018-10-08 16:05:42', 1, '457030599@qq.com', '1111', 1, NULL, NULL, NULL, '2018-10-31 17:48:40', '2019-01-06 05:57:02', 0, 21);
INSERT INTO `sys_user` VALUES (1072429679148908500, 'sysuser\\IMAGE\\2019\\5\\21\\4CCEDBECCF0CBF55ED6E9A3D50F14F75.png', 'test', '123456', 'ZCCRZ4gOfa8WzorCBFii', 'test', 3, '2019-05-25 00:00:00', NULL, '123456', '123456', 1, NULL, NULL, NULL, '2018-12-11 09:55:35', '2019-03-22 10:10:57', 0, 36);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NULL DEFAULT 0 COMMENT '用户ID',
  `role_id` bigint(20) NULL DEFAULT 0 COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户与角色对应关系' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (2, 1058283224922398721, 1);
INSERT INTO `sys_user_role` VALUES (20, 1, 1);
INSERT INTO `sys_user_role` VALUES (21, 1072429679148908500, 1076685137679704065);

SET FOREIGN_KEY_CHECKS = 1;
