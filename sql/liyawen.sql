/*
 Navicat Premium Data Transfer

 Source Server         : houtaiguanli
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : liyawen

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 05/11/2022 20:41:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_menu
-- ----------------------------
DROP TABLE IF EXISTS `admin_menu`;
CREATE TABLE `admin_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `menu_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '菜单路径',
  `menu_icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `menu_describe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '菜单描述',
  `pid` int(11) NULL DEFAULT NULL COMMENT '子级id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 258002947 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_menu
-- ----------------------------
INSERT INTO `admin_menu` VALUES (1, '首页', '/home', 'el-icon-s-home', NULL, NULL);
INSERT INTO `admin_menu` VALUES (2, '权限管理', '', 'el-icon-user', '', NULL);
INSERT INTO `admin_menu` VALUES (3, '用户管理', '/user', 'el-icon-user', NULL, 2);
INSERT INTO `admin_menu` VALUES (4, '角色管理', '/role', 'el-icon-user-solid', NULL, 2);
INSERT INTO `admin_menu` VALUES (5, '菜单管理', '/menu', 'el-icon-menu', '菜单', 2);
INSERT INTO `admin_menu` VALUES (7, '商品管理', NULL, 'el-icon-s-goods', NULL, NULL);
INSERT INTO `admin_menu` VALUES (8, '商品列表', '/goods', 'el-icon-goods', NULL, 7);

-- ----------------------------
-- Table structure for admin_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '名称',
  `role_describe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '描述',
  `role_key` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '唯一标识',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_role
-- ----------------------------
INSERT INTO `admin_role` VALUES (1, '超级管理员', '超级管理员', 'LYW_ADMIN');
INSERT INTO `admin_role` VALUES (2, '用户', '普通用户', 'ROLE_USER');

-- ----------------------------
-- Table structure for admin_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `admin_role_menu`;
CREATE TABLE `admin_role_menu`  (
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `menu_id` int(11) NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色菜单关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_role_menu
-- ----------------------------
INSERT INTO `admin_role_menu` VALUES (1, 1);
INSERT INTO `admin_role_menu` VALUES (1, 2);
INSERT INTO `admin_role_menu` VALUES (1, 3);
INSERT INTO `admin_role_menu` VALUES (1, 4);
INSERT INTO `admin_role_menu` VALUES (1, 5);
INSERT INTO `admin_role_menu` VALUES (1, 7);
INSERT INTO `admin_role_menu` VALUES (1, 8);
INSERT INTO `admin_role_menu` VALUES (2, 1);
INSERT INTO `admin_role_menu` VALUES (2, 7);
INSERT INTO `admin_role_menu` VALUES (2, 8);

-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '昵称',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '手机号',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '地址',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `head_portrait` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '头像',
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`id`, `username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admin_user
-- ----------------------------
INSERT INTO `admin_user` VALUES (1, 'lyw', 'lyw', '亚文', 'lyw@qq.com', '18702654568', '江西', '2022-10-25 15:06:20', '	https://foruda.gitee.com/avatar/1667183897541794799/10047731_lyw2786034803_1667183897.png!avatar30', 'LYW_ADMIN');
INSERT INTO `admin_user` VALUES (2, '2786034803', '2786034803', '小哇塞', '2786034803@qq.com', '15486235789', '福建省福州市', '2022-10-26 00:18:30', NULL, 'ROLE_USER');
INSERT INTO `admin_user` VALUES (3, '2664221', '123154', '小太阳', '2664221', '15486235789', '北京海淀区', '2022-10-26 11:17:20', NULL, 'ROLE_USER');
INSERT INTO `admin_user` VALUES (5, '26645221', '12315314', '小会话', '26645221@qq.com', '15542235789', '湖南长沙', '2022-10-26 11:35:59', NULL, 'ROLE_USER');
INSERT INTO `admin_user` VALUES (6, '54351545', '12314', '无憾', '54351545@qq.com', '15541255789', '湖北武汉', '2022-10-26 11:36:38', NULL, 'ROLE_USER');
INSERT INTO `admin_user` VALUES (7, '234545', '1231da4', '佼佼者', '234545@qq.com', '12546955789', '安徽合肥', '2022-10-26 11:37:34', NULL, 'ROLE_USER');
INSERT INTO `admin_user` VALUES (8, '12343251', '123546', '小度啊', '1234325@qq.com', '15648536578', '百度公司总部', '2022-10-26 17:05:09', NULL, 'ROLE_USER');
INSERT INTO `admin_user` VALUES (9, '666666', '123546', '小马啊', '123456@qq.com', '15648666666', '腾讯公司总部', '2022-10-26 17:05:09', '', '');
INSERT INTO `admin_user` VALUES (12, '212121', '123546', '马老板啊', '123456@qq.com', '15648666666', '阿里公司总部', '2022-10-28 14:56:15', '', NULL);
INSERT INTO `admin_user` VALUES (13, '8974521', '12341564546', '曹老板', '4564123456@qq.com', '15465215412', '三国时期魏国', '2022-10-28 15:00:07', '', NULL);
INSERT INTO `admin_user` VALUES (14, '464511', '4654564546', '刘备', '46543456@qq.com', '15465485412', '三国时期蜀国', '2022-10-28 15:43:20', '', NULL);
INSERT INTO `admin_user` VALUES (21, 'qwe', 'qwe', '轻微', '13245612@qq.com', '15462358795', '新疆', '2022-11-01 00:09:27', NULL, NULL);
INSERT INTO `admin_user` VALUES (22, 'lzy', 'lzy', '志勇', 'lzy@qq.com', '18754632548', '江西', '2022-11-01 15:41:31', NULL, 'ROLE_USER');
INSERT INTO `admin_user` VALUES (23, 'wtl', 'wtl', '畑林', 'wtl@qq.com', '15647854325', '江西', '2022-11-01 15:43:59', 'https://foruda.gitee.com/avatar/1667289403110177575/11830636_wang-tianlin001_1667289402.png', 'ROLE_USER');
INSERT INTO `admin_user` VALUES (24, 'rzg', 'rzg', '志刚', 'rzg@qq.com', '17854695563', '江西抚州', '2022-11-01 15:45:03', '', 'ROLE_USER');
INSERT INTO `admin_user` VALUES (25, 'xzj', 'xzj', '志军', 'xzj@qq.com', '15466326687', '江西广丰', '2022-11-01 15:46:01', NULL, 'ROLE_USER');
INSERT INTO `admin_user` VALUES (26, 'hjl', 'hjl', '老黄', 'hjl@qq.com', '15423656587', '江西樟树', '2022-11-01 15:55:42', 'https://foruda.gitee.com/avatar/1667289166601259538/11830788_lizy101_1667289165.png', 'ROLE_USER');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `goods_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '商品图片',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '商品名称',
  `goods_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品价格',
  `goods_order` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '货号',
  `goods_sale` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '销量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '	https://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg', '华为 HUAWEI P30', 3731.00, '6946632', '10023');
INSERT INTO `goods` VALUES (2, '	https://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', '小米8 全面屏游戏智能手机', 2699.00, '7437788', '7654');
INSERT INTO `goods` VALUES (3, '	https://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', '小米 红米5A 全网通版 3GB+32GB 香槟金', 649.00, '7437789', '4132');
INSERT INTO `goods` VALUES (4, '	https://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5acc5248N6a5f81cd.jpg', 'Apple iPhone 8 Plus ', 5499.00, '4243453', '2313');
INSERT INTO `goods` VALUES (5, '	https://tse2-mm.cn.bing.net/th/id/OIP-C.Xi-xTKcG1-vhY2nH3enoUQHaKX?w=195&h=273&c=7&r=0&o=5&pid=1.7', 'iPhone14 Pro Max', 10000.00, '664234', '66666');
INSERT INTO `goods` VALUES (8, '	https://tse1-mm.cn.bing.net/th/id/OIP-C.W3i8MDGhXELQDs-6oWFuCgHaEt?w=286&h=182&c=7&r=0&o=5&pid=1.7', '玩家国度', 12000.00, '121321', '123');

-- ----------------------------
-- Table structure for icons
-- ----------------------------
DROP TABLE IF EXISTS `icons`;
CREATE TABLE `icons`  (
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '图标名称',
  `icon_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '图标值',
  `icon_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '图标类型'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of icons
-- ----------------------------
INSERT INTO `icons` VALUES ('user', 'el-icon-user', 'icon');
INSERT INTO `icons` VALUES ('menu', 'el-icon-menu', 'icon');
INSERT INTO `icons` VALUES ('user_solid', 'el-icon-user-solid', 'icon');
INSERT INTO `icons` VALUES ('goods_s', 'el-icon-s-goods', 'icon');
INSERT INTO `icons` VALUES ('goods', 'el-icon-goods', 'icon');
INSERT INTO `icons` VALUES ('home_s', 'el-icon-s-home', 'icon');

SET FOREIGN_KEY_CHECKS = 1;
