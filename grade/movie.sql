/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : movie

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2019-01-04 19:54:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `grade_account`
-- ----------------------------
DROP TABLE IF EXISTS `grade_account`;
CREATE TABLE `grade_account` (
  `ID` int(16) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `USER_ID` int(16) DEFAULT NULL,
  `GZ_NAME` varchar(16) DEFAULT NULL,
  `APPID` varchar(32) DEFAULT NULL,
  `APP_SECRECT` varchar(256) DEFAULT NULL,
  `MCH_ID` varchar(256) DEFAULT NULL,
  `STATUS` int(16) unsigned zerofill DEFAULT '0000000000000000',
  `IS_DEL` int(4) unsigned zerofill DEFAULT '0000',
  `GMT_CREATE` datetime DEFAULT NULL,
  `GMT_MODIFIED` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='打款商户配置、公众号配置';

-- ----------------------------
-- Records of grade_account
-- ----------------------------
INSERT INTO `grade_account` VALUES ('0000000000000001', '10', '测试公众号名称', '测试appid', '测试secrect', '测试商户号', '0000000000000000', '0000', '2019-01-03 18:58:08', '2019-01-03 18:58:11');
INSERT INTO `grade_account` VALUES ('0000000000000002', '10', '测试公众号名称2', '测试appid2', '测试secrect2', '测试商户号2', '0000000000000000', '0000', '2019-01-03 18:59:09', '2019-01-03 18:59:12');
INSERT INTO `grade_account` VALUES ('0000000000000003', '10', '测试公众号名称3', '测试appid3', '测试secrect3', '测试商户号3', '0000000000000000', '0000', '2019-01-03 18:59:09', '2019-01-03 18:59:09');
INSERT INTO `grade_account` VALUES ('0000000000000004', '10', '1', '2', '3', '4', '0000000000000000', '0001', '2019-01-04 15:45:29', '2019-01-04 11:24:22');
INSERT INTO `grade_account` VALUES ('0000000000000007', null, null, null, null, null, '0000000000000000', '0001', '2019-01-04 15:42:32', null);

-- ----------------------------
-- Table structure for `grade_mch_pay`
-- ----------------------------
DROP TABLE IF EXISTS `grade_mch_pay`;
CREATE TABLE `grade_mch_pay` (
  `ID` int(16) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `ORDER_NUM` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '订单号',
  `USER_ID` int(16) DEFAULT NULL COMMENT '用户id',
  `WX_USER_NAME` varchar(16) DEFAULT NULL COMMENT '微信用户昵称',
  `PARENT_CODE` varchar(32) DEFAULT NULL COMMENT '所属上级用户的邀请码',
  `PAY_PRICE` decimal(8,4) DEFAULT NULL COMMENT '转账金额',
  `PAY_MSG` varchar(128) CHARACTER SET utf8 DEFAULT NULL COMMENT '转账信息',
  `PAY_STATUS` int(4) DEFAULT NULL COMMENT '转账状态',
  `IS_DEL` int(4) DEFAULT NULL,
  `GMT_CREATE` datetime DEFAULT NULL COMMENT '创建时间',
  `GMT_MODIFIED` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of grade_mch_pay
-- ----------------------------

-- ----------------------------
-- Table structure for `grade_run_percent`
-- ----------------------------
DROP TABLE IF EXISTS `grade_run_percent`;
CREATE TABLE `grade_run_percent` (
  `ID` int(16) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `USER_ID` int(16) DEFAULT NULL COMMENT '总代理用户id',
  `EXTENSION_CODE` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '总代理邀请码',
  `RUN_LEVEL` int(4) DEFAULT NULL COMMENT '利润级数',
  `RUN_PERCENT` varchar(64) DEFAULT NULL COMMENT '利润百分比',
  `IS_DEL` int(4) unsigned zerofill DEFAULT '0000' COMMENT '是否删除',
  `GMT_CREATE` datetime DEFAULT NULL COMMENT '创建时间',
  `GMT_MODIFIED` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of grade_run_percent
-- ----------------------------
INSERT INTO `grade_run_percent` VALUES ('0000000000000001', '15', 'ID15PSNDZM', '3', '8', '0001', '2019-01-04 19:48:19', '2019-01-04 19:48:19');

-- ----------------------------
-- Table structure for `grade_wx_public_num`
-- ----------------------------
DROP TABLE IF EXISTS `grade_wx_public_num`;
CREATE TABLE `grade_wx_public_num` (
  `ID` int(16) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `USER_ID` int(16) DEFAULT NULL COMMENT '用户id',
  `OPEN_ID` varchar(64) DEFAULT NULL COMMENT '授权后此用户对应公众号的唯一标识',
  `APPID` varchar(32) DEFAULT NULL COMMENT '公众号appid',
  `WX_USER_NAME` varchar(128) DEFAULT NULL COMMENT '授权成功微信返回的昵称',
  `GA_ID` int(16) DEFAULT NULL COMMENT '商户信息表主键id',
  `IS_DEL` int(4) DEFAULT NULL,
  `GMT_CREATE` datetime DEFAULT NULL,
  `GMT_MODIFIED` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户授权过得公众号表';

-- ----------------------------
-- Records of grade_wx_public_num
-- ----------------------------
INSERT INTO `grade_wx_public_num` VALUES ('0000000000000001', '1', 'openid1', null, '测试昵称', '1', '0', '2019-01-03 18:56:13', '2019-01-03 18:56:16');
INSERT INTO `grade_wx_public_num` VALUES ('0000000000000002', '1', 'openid2', null, '测试昵称2', '2', '0', '2019-01-03 18:57:08', '2019-01-03 18:57:10');

-- ----------------------------
-- Table structure for `mage_admin_user`
-- ----------------------------
DROP TABLE IF EXISTS `mage_admin_user`;
CREATE TABLE `mage_admin_user` (
  `ID` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `AU_ACCOUNT` varchar(16) DEFAULT NULL COMMENT '管理员账户',
  `AU_PSWD` char(32) DEFAULT NULL COMMENT '管理员密码',
  `GMT_CREATE` datetime DEFAULT NULL COMMENT '创建时间',
  `AU_PERMISSION` varchar(30) NOT NULL COMMENT '权限',
  `GMT_MODIFIED` datetime DEFAULT NULL COMMENT '修改时间',
  `IS_DEL` int(4) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='后台管理员表';

-- ----------------------------
-- Records of mage_admin_user
-- ----------------------------
INSERT INTO `mage_admin_user` VALUES ('1', 'admin', '14e1b600b1fd579f47433b88e8d85291', null, 'look,edit,del', null, '0');

-- ----------------------------
-- Table structure for `mage_custom_service`
-- ----------------------------
DROP TABLE IF EXISTS `mage_custom_service`;
CREATE TABLE `mage_custom_service` (
  `ID` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `CS_TYPE` varchar(16) DEFAULT NULL COMMENT '客服方式 微信/QQ/电话',
  `CS_NUMBER` varchar(20) DEFAULT NULL COMMENT '客服号码',
  `GMT_CREATE` datetime DEFAULT NULL COMMENT '创建时间',
  `GMT_MODIFIED` datetime DEFAULT NULL COMMENT '修改时间',
  `IS_DEL` int(4) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='客服信息表';

-- ----------------------------
-- Records of mage_custom_service
-- ----------------------------
INSERT INTO `mage_custom_service` VALUES ('1', '微信', '111', '2018-11-22 17:39:24', null, '0');
INSERT INTO `mage_custom_service` VALUES ('2', 'QQ', '594654554', '2018-11-29 16:28:01', null, '0');
INSERT INTO `mage_custom_service` VALUES ('3', '电话', '1879415414', '2018-11-29 16:28:12', null, '0');

-- ----------------------------
-- Table structure for `mage_hupijiao`
-- ----------------------------
DROP TABLE IF EXISTS `mage_hupijiao`;
CREATE TABLE `mage_hupijiao` (
  `ID` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `HU_APPID` varchar(64) DEFAULT NULL COMMENT '虎皮椒appid',
  `HU_APP_SECRET` varchar(64) DEFAULT NULL COMMENT '虎皮椒appSecret',
  `MAX_MONEY` decimal(10,2) NOT NULL COMMENT '自高限额',
  `NOW_MONEY` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '当前金额',
  `GMT_CREATE` datetime DEFAULT NULL COMMENT '创建时间',
  `GMT_MODIFIED` datetime DEFAULT NULL COMMENT '修改时间',
  `IS_DEL` int(4) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='虎皮椒对应key、value';

-- ----------------------------
-- Records of mage_hupijiao
-- ----------------------------
INSERT INTO `mage_hupijiao` VALUES ('1', '20146123713', '6D7B025B8DD098C485F0805193136FB9', '100000.00', '0.33', '2018-11-28 14:35:10', null, '0');

-- ----------------------------
-- Table structure for `mage_look_url`
-- ----------------------------
DROP TABLE IF EXISTS `mage_look_url`;
CREATE TABLE `mage_look_url` (
  `ID` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `LU_NAME` varchar(16) DEFAULT NULL COMMENT '地址名称',
  `LU_REALM` varchar(128) DEFAULT NULL COMMENT '地址域名',
  `LU_OTHER` varchar(128) NOT NULL COMMENT '地址其他参数',
  `GMT_CREATE` datetime DEFAULT NULL COMMENT '创建时间',
  `GMT_MODIFED` datetime DEFAULT NULL COMMENT '修改时间',
  `IS_DEL` int(4) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='请求地址表';

-- ----------------------------
-- Records of mage_look_url
-- ----------------------------
INSERT INTO `mage_look_url` VALUES ('1', '百度', 'www.baidu.com', '11', '2018-11-21 18:15:05', '2018-11-21 18:19:22', '1');
INSERT INTO `mage_look_url` VALUES ('2', '线路一', 'shipin.yuzhanweb.com', '', '2018-11-30 19:20:18', null, '1');
INSERT INTO `mage_look_url` VALUES ('3', '测试通道', 'www.sohu.com', '111', '2018-12-25 07:11:32', null, '1');
INSERT INTO `mage_look_url` VALUES ('4', '备用通道1', 'shiping001.l.100help.net', '可用', '2018-12-27 15:57:25', '2018-12-27 15:58:54', '0');
INSERT INTO `mage_look_url` VALUES ('5', '备用通道2', 'shiping002.l.100help.net', '可用', '2018-12-27 15:58:13', '2018-12-27 15:58:47', '0');
INSERT INTO `mage_look_url` VALUES ('6', '备用通道3', 'shiping003.l.100help.net', '可用', '2018-12-27 15:58:29', '2018-12-27 15:58:40', '0');
INSERT INTO `mage_look_url` VALUES ('7', '正常', 'shiping.l.100help.net', '可用', '2018-12-27 15:59:35', null, '0');

-- ----------------------------
-- Table structure for `mage_permission_type`
-- ----------------------------
DROP TABLE IF EXISTS `mage_permission_type`;
CREATE TABLE `mage_permission_type` (
  `ID` int(16) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `PT_KEY` varchar(16) DEFAULT NULL COMMENT '权限key:编辑',
  `PT_VALUE` varchar(16) DEFAULT NULL COMMENT '权限value：edit',
  `GMT_CREATE` datetime DEFAULT NULL COMMENT '创建时间',
  `GMT_MODIFIED` datetime DEFAULT NULL COMMENT '修改时间',
  `IS_DEL` int(4) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of mage_permission_type
-- ----------------------------

-- ----------------------------
-- Table structure for `mage_shop`
-- ----------------------------
DROP TABLE IF EXISTS `mage_shop`;
CREATE TABLE `mage_shop` (
  `ID` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `SP_NAME` varchar(16) DEFAULT NULL COMMENT '套餐名称',
  `SP_PRICE` decimal(8,2) DEFAULT NULL COMMENT '套餐价格',
  `SP_END_TIME` int(5) unsigned DEFAULT '0' COMMENT '有效期(日，月)',
  `GMT_CREATE` datetime DEFAULT NULL COMMENT '创建时间',
  `GMT_MODIFED` datetime DEFAULT NULL COMMENT '修改时间',
  `IS_DEL` int(4) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='套餐表';

-- ----------------------------
-- Records of mage_shop
-- ----------------------------
INSERT INTO `mage_shop` VALUES ('1', '6元包日', '0.01', '1', null, '2018-12-13 16:27:33', '0');
INSERT INTO `mage_shop` VALUES ('2', '25元包周', '25.00', '7', '2018-11-21 15:33:44', null, '0');
INSERT INTO `mage_shop` VALUES ('3', '58元包月', '58.00', '1', '2018-11-21 15:37:03', null, '0');
INSERT INTO `mage_shop` VALUES ('4', '148元季度', '148.00', '3', '2018-11-21 15:38:32', null, '0');
INSERT INTO `mage_shop` VALUES ('5', '258元半年', '258.00', '6', '2018-11-21 15:39:07', null, '0');
INSERT INTO `mage_shop` VALUES ('6', '测试套餐', '0.02', '2', '2018-12-25 07:03:23', null, '0');
INSERT INTO `mage_shop` VALUES ('7', '包年套餐', '0.03', '365', '2018-12-25 07:04:40', null, '0');
INSERT INTO `mage_shop` VALUES ('8', '3年套餐', '0.01', '900', '2018-12-27 15:01:30', null, '0');

-- ----------------------------
-- Table structure for `mv_bank_card`
-- ----------------------------
DROP TABLE IF EXISTS `mv_bank_card`;
CREATE TABLE `mv_bank_card` (
  `ID` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `BC_USERID` int(16) DEFAULT NULL COMMENT '用户id',
  `BC_NUMBER` varchar(64) DEFAULT NULL COMMENT '银行卡号',
  `BC_NAME` varchar(32) DEFAULT NULL COMMENT '持卡人姓名',
  `BC_TELNO` varchar(32) DEFAULT NULL COMMENT '持卡人手机号',
  `BC_OPEN_BANK` varchar(32) DEFAULT NULL COMMENT '开户行',
  `BC_OPEN_BANK_ADDRESS` varchar(128) DEFAULT NULL COMMENT '开户行地址',
  `GMT_CREATE` datetime DEFAULT NULL COMMENT '创建时间',
  `GMT_MODIFED` datetime DEFAULT NULL COMMENT '修改时间',
  `IS_DEL` int(4) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='银行卡管理表';

-- ----------------------------
-- Records of mv_bank_card
-- ----------------------------
INSERT INTO `mv_bank_card` VALUES ('1', '14', '123456789', 'dsf', '123123123', 'dsf', '1232', '2018-11-29 14:00:02', null, '1');
INSERT INTO `mv_bank_card` VALUES ('2', '14', '2147483647', '葛福才', '18790922211', '中国邮政', '河南郑州', '2018-11-29 15:05:46', null, '1');
INSERT INTO `mv_bank_card` VALUES ('3', '14', '2147483647', '葛福才', '18790296652', '中国建设银行', '河南郑州', '2018-11-29 15:07:13', null, '1');
INSERT INTO `mv_bank_card` VALUES ('4', '14', '2147483647', '葛福才', '18790296652', '中国建设银行', '河南郑州', '2018-11-29 15:07:14', null, '1');
INSERT INTO `mv_bank_card` VALUES ('5', '14', '2147483647', '葛福才', '18790295454', '中国建设银行', '河南郑州', '2018-11-29 15:19:13', null, '1');
INSERT INTO `mv_bank_card` VALUES ('6', '14', '2147483647', '葛福彩', '18790245454', '邮政储蓄', '河南郑州', '2018-11-29 15:19:46', null, '1');
INSERT INTO `mv_bank_card` VALUES ('7', '14', '2147483647', '葛福彩', '18790254544', '工商银行', '河南郑州', '2018-11-29 15:20:19', null, '1');
INSERT INTO `mv_bank_card` VALUES ('8', '14', '2147483647', '葛福才', '18790296652', '中国建设银行', '河南郑州', '2018-11-29 15:27:01', null, '1');
INSERT INTO `mv_bank_card` VALUES ('9', '14', '2147483647', '葛福才', '18790296652', '工商银行', '河南郑州', '2018-11-29 15:27:32', null, '1');
INSERT INTO `mv_bank_card` VALUES ('10', '14', '324', '345324', '324', 'tr345', '324324', '2018-11-29 15:27:43', null, '1');
INSERT INTO `mv_bank_card` VALUES ('11', '15', '2147483647', '李燕彩', '15324998429', '建设银行', '1234567894111', '2018-11-29 17:32:38', null, '1');
INSERT INTO `mv_bank_card` VALUES ('12', '14', '2147483647', '葛福才', '18790296652', '招商银行', '郑州市', '2018-12-05 14:04:27', null, '1');
INSERT INTO `mv_bank_card` VALUES ('13', '14', '2147483647', '葛福才', '18790296652', '招商银行', '郑州市', '2018-12-05 14:04:31', null, '1');
INSERT INTO `mv_bank_card` VALUES ('14', '14', '2147483647', '葛福才', '18790296652', '招商银行', '郑州市', '2018-12-05 14:04:35', null, '1');
INSERT INTO `mv_bank_card` VALUES ('15', '15', '2147483647', '李燕彩', '15324998429', '工商银行', '111111', '2018-12-05 14:29:30', null, '1');
INSERT INTO `mv_bank_card` VALUES ('16', '15', '11111111111111111', '李燕彩', '15324998429', '工商银行', '111111', '2018-12-05 14:31:47', null, '0');
INSERT INTO `mv_bank_card` VALUES ('17', '15', '11111111111111111', '李燕彩', '15324998429', '工商银行', '111111', '2018-12-05 14:32:11', null, '1');
INSERT INTO `mv_bank_card` VALUES ('18', '14', '622212457841114', '个福彩', '18790296652', '工商银行', '郑州市', '2018-12-05 15:36:34', null, '0');
INSERT INTO `mv_bank_card` VALUES ('19', '14', '1234564545', '3243242', '18792045121', '进啊声音很324', '1234564545', '2018-12-05 15:40:04', null, '1');
INSERT INTO `mv_bank_card` VALUES ('20', '14', '123456', '234234', '18790296652', '士大夫大师傅', '123456', '2018-12-05 15:40:25', null, '1');
INSERT INTO `mv_bank_card` VALUES ('21', '14', '123456', '324', '18790296652', 'ge', '123456', '2018-12-05 15:41:00', null, '1');
INSERT INTO `mv_bank_card` VALUES ('22', '14', '123456789', '123456', '18790296652', 'gesdsd', '123456', '2018-12-05 15:42:03', null, '1');
INSERT INTO `mv_bank_card` VALUES ('23', '14', '32123123', '3324324', '18790296652', 'dsdfds', '123123213231', '2018-12-06 16:09:58', null, '1');
INSERT INTO `mv_bank_card` VALUES ('24', '14', '789456', '123', '18790296652', '123', '456', '2018-12-06 16:10:14', null, '1');
INSERT INTO `mv_bank_card` VALUES ('25', '14', '1661616166161', '哦哦哦红', '18790296652', '李丽敏', '哦民工', '2018-12-06 19:22:43', null, '1');
INSERT INTO `mv_bank_card` VALUES ('26', '14', '1231123', 'going哦哦', '18790296652', '叽叽叽叽', '革命友谊', '2018-12-06 19:23:16', null, '1');
INSERT INTO `mv_bank_card` VALUES ('27', '14', '123456789', '功能', '18790296652', '攻击力', '过敏红', '2018-12-06 20:56:46', null, '1');
INSERT INTO `mv_bank_card` VALUES ('28', '14', '123456', '嘻嘻嘻嘻', '18790296652', '过敏你在', '回一下', '2018-12-06 20:57:13', null, '1');
INSERT INTO `mv_bank_card` VALUES ('29', '14', '123456789', '功能', '18792065523', '哦你姑姑', '公公', '2018-12-06 21:00:08', null, '1');
INSERT INTO `mv_bank_card` VALUES ('30', '45', '1234567891475124578', '来来来', '15845336945', '招商银行', '不知道', '2018-12-29 15:05:21', null, '0');
INSERT INTO `mv_bank_card` VALUES ('31', '45', '1234567891475124578', '来来来', '15845336945', '招商银行', '不知道', '2018-12-29 15:05:36', null, '0');
INSERT INTO `mv_bank_card` VALUES ('32', '45', '8888888888888888888888', '踢踢踢', '14579664385', '爱咯改名', '冥冥中', '2018-12-29 15:06:33', null, '0');
INSERT INTO `mv_bank_card` VALUES ('33', '45', '8888888888888888888888', '踢踢踢', '14579664385', '爱咯改名', '冥冥中', '2018-12-29 15:06:39', null, '0');
INSERT INTO `mv_bank_card` VALUES ('34', '45', '8888888888888888888888', '踢踢踢', '14579664385', '爱咯改名', '冥冥中', '2018-12-29 15:06:47', null, '0');

-- ----------------------------
-- Table structure for `mv_banner`
-- ----------------------------
DROP TABLE IF EXISTS `mv_banner`;
CREATE TABLE `mv_banner` (
  `ID` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `BN_NAME` varchar(16) DEFAULT NULL COMMENT '轮播图名称',
  `BN_URL` text COMMENT '轮播图地址',
  `BN_TYPE` varchar(16) DEFAULT NULL COMMENT '类型 视频/漫画',
  `BN_TYPE_ID` int(16) DEFAULT NULL COMMENT '对应视频表/漫画表id',
  `GMT_CREATE` datetime DEFAULT NULL COMMENT '创建时间',
  `GMT_MODIFED` datetime DEFAULT NULL COMMENT '修改时间',
  `IS_DEL` int(4) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='轮播图表';

-- ----------------------------
-- Records of mv_banner
-- ----------------------------
INSERT INTO `mv_banner` VALUES ('1', '灯光仪表2', 'Public/upload/2018-11-21/2018_11_21_17_22_25_92875.jpg', '2', '1', '2018-11-21 17:22:31', '2018-11-21 17:30:20', '1');
INSERT INTO `mv_banner` VALUES ('2', '111', 'Public/upload/2018-11-23/2018_11_23_10_20_02_98099.jpg', '1', '1111', '2018-11-23 10:20:08', null, '1');
INSERT INTO `mv_banner` VALUES ('3', '首页banner1', 'Public/upload/2018-11-25/2018_11_25_15_32_21_96426.png', '1', '0', '2018-11-25 15:32:27', null, '0');
INSERT INTO `mv_banner` VALUES ('4', '首页banner2', 'Public/upload/2018-11-25/2018_11_25_15_33_34_32697.png', '1', '0', '2018-11-25 15:33:36', null, '0');
INSERT INTO `mv_banner` VALUES ('5', '首页banner3', 'Public/upload/2018-11-25/2018_11_25_16_04_27_41635.png', '1', '0', '2018-11-25 16:04:35', null, '0');
INSERT INTO `mv_banner` VALUES ('6', '影片', 'Public/upload/2018-11-26/2018_11_26_16_55_29_20250.png', '3', '0', '2018-11-26 16:55:36', null, '0');
INSERT INTO `mv_banner` VALUES ('7', '影片2', 'Public/upload/2018-11-26/2018_11_26_16_55_51_81235.png', '3', '0', '2018-11-26 16:55:59', null, '0');
INSERT INTO `mv_banner` VALUES ('8', '影片3', 'Public/upload/2018-11-26/2018_11_26_16_56_15_34864.png', '3', '0', '2018-11-26 16:56:25', '2018-11-26 16:56:37', '1');
INSERT INTO `mv_banner` VALUES ('9', '漫画1', 'Public/upload/2018-11-26/2018_11_26_20_26_58_39218.png', '4', '0', '2018-11-26 20:27:07', null, '0');
INSERT INTO `mv_banner` VALUES ('10', '漫画2', 'Public/upload/2018-11-26/2018_11_26_20_27_26_63830.png', '4', '0', '2018-11-26 20:27:30', '2018-11-26 20:29:56', '0');
INSERT INTO `mv_banner` VALUES ('11', '影片的', 'Public/upload/2018-12-25/2018_12_25_07_00_38_90952.png', '3', '0', '2018-12-25 07:00:52', null, '1');
INSERT INTO `mv_banner` VALUES ('12', '影片轮播', 'Public/upload/2018-12-27/2018_12_27_14_51_32_49794.jpg', '3', '7', '2018-12-27 14:52:48', '2018-12-27 14:56:29', '0');

-- ----------------------------
-- Table structure for `mv_cartoon`
-- ----------------------------
DROP TABLE IF EXISTS `mv_cartoon`;
CREATE TABLE `mv_cartoon` (
  `ID` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `CT_NAME` varchar(16) DEFAULT NULL COMMENT '漫画名称',
  `CT_PHOTO_URL` text COMMENT '漫画封面图',
  `CT_CONTENT` varchar(255) NOT NULL COMMENT '漫画简介',
  `CT_AUTHOR` varchar(16) NOT NULL COMMENT '漫画作者',
  `CT_TYPE` varchar(16) DEFAULT NULL COMMENT '漫画类型 免费/会员',
  `CT_PHYLETIC` int(5) NOT NULL DEFAULT '4' COMMENT '漫画分类',
  `CT_CATEGORY` varchar(16) NOT NULL COMMENT '漫画类别 科幻/动作',
  `CT_COUNT` int(8) DEFAULT NULL COMMENT '漫画章节数量',
  `CT_STATUS` int(4) DEFAULT '1' COMMENT '漫画上架/下架',
  `GMT_CREATE` datetime DEFAULT NULL COMMENT '创建时间',
  `GMT_MODIFED` datetime DEFAULT NULL COMMENT '修改时间',
  `IS_DEL` int(4) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='漫画表';

-- ----------------------------
-- Records of mv_cartoon
-- ----------------------------
INSERT INTO `mv_cartoon` VALUES ('1', '快把我哥带走', '[\"Public\\/upload\\/goods\\/154444084054104201280.png\",\"Public\\/upload\\/goods\\/154444084435349101708.png\"]', 'APICloud是中国领先的“云端一体”的移动应用云服务提供商。 [1]  APICloud推\n行“云端一体”的理念，重新定义了移动应用开发。APICloud为开发者从“云”和“端”两个方向提供API，简化移动应用开发技术，让移动应用的开发周期从一个月缩短到7天。APICloud由“云API”和“端API”两部分组成，可以帮助开发者快速实现移动应用的开发、测试、发布、管理和运营的全生命周期管理。', '11', '1', '4', '喜剧', '200', '1', '2018-11-22 14:22:32', '2018-12-10 19:20:45', '0');
INSERT INTO `mv_cartoon` VALUES ('2', '城市之光', '[\"Public\\/upload\\/goods\\/154444082982802001562.png\"]', 'APICloud是中国领先的“云端一体”的移动应用云服务提供商。 [1]  APICloud推\n行“云端一体”的理念，重新定义了移动应用开发。APICloud为开发者从“云”和“端”两个方向提供API，简化移动应用开发技术，让移动应用的开发周期从一个月缩短到7天。APICloud由“云API”和“端API”两部分组成，可以帮助开发者快速实现移动应用的开发、测试、发布、管理和运营的全生命周期管理。', '11', '2', '4', '科幻', '300', '1', '2018-11-23 11:42:30', '2018-12-10 19:20:30', '0');

-- ----------------------------
-- Table structure for `mv_cartoon_detail`
-- ----------------------------
DROP TABLE IF EXISTS `mv_cartoon_detail`;
CREATE TABLE `mv_cartoon_detail` (
  `ID` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `CT_ID` int(16) DEFAULT NULL COMMENT '漫画表id',
  `CTD_TITLE` varchar(32) DEFAULT NULL COMMENT '单章标题',
  `CTD_PHOTO_URL` text COMMENT '封面图',
  `CTD_TYPE` varchar(16) DEFAULT NULL COMMENT '章节类型 免费/会员',
  `CTD_PHOTO_LIST` text COMMENT '章节图片',
  `GMT_CREATE` datetime DEFAULT NULL COMMENT '创建时间',
  `GMT_MODIFED` datetime DEFAULT NULL COMMENT '修改时间',
  `IS_DEL` int(4) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='漫画详情表';

-- ----------------------------
-- Records of mv_cartoon_detail
-- ----------------------------
INSERT INTO `mv_cartoon_detail` VALUES ('1', '1', '第一章', 'Public/upload/2018-11-22/2018_11_22_14_56_38_73506.jpg', '1', '<p>1111</p>', '2018-11-22 14:56:42', '2018-11-22 15:15:46', '0');
INSERT INTO `mv_cartoon_detail` VALUES ('2', '1', '第二章', 'Public/upload/2018-11-22/2018_11_22_14_57_02_78090.jpg', '2', '<p>11111</p>', '2018-11-22 14:57:05', '2018-11-22 15:15:25', '0');
INSERT INTO `mv_cartoon_detail` VALUES ('3', '1', '第三章', 'Public/upload/2018-11-22/2018_11_22_14_57_43_60603.jpg', '2', '333', '2018-11-22 14:57:46', null, '0');
INSERT INTO `mv_cartoon_detail` VALUES ('4', '2', '第一章：希望之子', null, '1', '<p><img src=\"/ueditor/php/upload/image/20181229/1546074133174190.png\" title=\"1546074133174190.png\" alt=\"2018_11_26_10_36_46_90634.png\"/></p>', '2018-11-28 15:07:57', '2018-12-29 17:02:16', '0');
INSERT INTO `mv_cartoon_detail` VALUES ('5', '2', '第二张：为恶恶', null, '1', '<p>士大夫士大夫</p>', '2018-11-28 15:08:36', null, '0');
INSERT INTO `mv_cartoon_detail` VALUES ('6', '2', '第三章：突然的激动', null, '1', '<p>大师傅似的</p>', '2018-11-28 15:09:44', null, '0');
INSERT INTO `mv_cartoon_detail` VALUES ('7', '2', '11', null, '1', '1111', '2018-11-28 15:10:00', null, '1');
INSERT INTO `mv_cartoon_detail` VALUES ('8', '2', '第四章：只有我可以', null, '2', '<p>士大夫</p>', '2018-11-28 15:10:12', null, '0');
INSERT INTO `mv_cartoon_detail` VALUES ('9', '2', '搞笑', null, '1', '111', '2018-11-28 15:10:54', null, '1');
INSERT INTO `mv_cartoon_detail` VALUES ('10', '2', '第五章：欲望的囚笼', null, '2', '<p>士大夫</p>', '2018-11-28 15:12:02', null, '0');
INSERT INTO `mv_cartoon_detail` VALUES ('11', '2', '第六章：肿胀', 'Public/upload/2018-12-25/2018_12_25_07_32_13_16152.png', '2', '<p>地方电风扇都是第三方都是<img src=\"/ueditor/php/upload/image/20181225/1545694487116740.png\" title=\"1545694487116740.png\" alt=\"视频开发APP需求.png\"/></p>', '2018-12-25 07:32:53', '2018-12-25 07:34:49', '0');

-- ----------------------------
-- Table structure for `mv_class`
-- ----------------------------
DROP TABLE IF EXISTS `mv_class`;
CREATE TABLE `mv_class` (
  `ID` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `CL_NAME` varchar(16) DEFAULT NULL COMMENT '类型名称',
  `CL_TYPE` int(3) NOT NULL DEFAULT '1' COMMENT '类型',
  `CL_PIC` varchar(255) DEFAULT NULL COMMENT '分类图片',
  `GMT_CREATE` datetime DEFAULT NULL COMMENT '创建时间',
  `GMT_MODIFIED` datetime DEFAULT NULL COMMENT '修改时间',
  `IS_DEL` int(4) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='分类表';

-- ----------------------------
-- Records of mv_class
-- ----------------------------
INSERT INTO `mv_class` VALUES ('1', '精选', '1', 'Public/upload/2018-12-25/2018_12_25_14_49_25_74934.png', '2018-11-21 17:41:07', '2018-12-25 14:49:26', '0');
INSERT INTO `mv_class` VALUES ('2', '视频', '1', 'Public/upload/2018-12-25/2018_12_25_14_49_14_46576.png', '2018-11-22 09:58:49', '2018-12-25 14:49:15', '0');
INSERT INTO `mv_class` VALUES ('3', '影片', '1', 'Public/upload/2018-12-25/2018_12_25_14_49_04_57449.png', '2018-11-22 12:24:59', '2018-12-25 14:49:05', '0');
INSERT INTO `mv_class` VALUES ('4', '漫画', '2', 'Public/upload/2018-12-25/2018_12_25_14_48_46_28586.png', null, '2018-12-25 14:48:47', '0');
INSERT INTO `mv_class` VALUES ('5', '科幻的', '1', 'Public/upload/2018-12-27/2018_12_27_15_19_33_21919.jpg', '2018-12-27 15:19:37', null, '0');

-- ----------------------------
-- Table structure for `mv_comment`
-- ----------------------------
DROP TABLE IF EXISTS `mv_comment`;
CREATE TABLE `mv_comment` (
  `ID` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `CM_TYPE` varchar(32) DEFAULT NULL COMMENT '评论类型 漫画/视频',
  `CM_TYPE_ID` int(16) DEFAULT NULL COMMENT '评论内容对应id',
  `CM_USER_ID` int(16) DEFAULT NULL COMMENT '用户id',
  `CM_USERNAME` varchar(32) DEFAULT NULL COMMENT '用户名',
  `CM_HEADIMG` text COMMENT '用户头像',
  `CM_STAR` int(8) DEFAULT NULL COMMENT '评论星',
  `CM_CONTENT` text COMMENT '评论内容',
  `GMT_CREATE` datetime DEFAULT NULL COMMENT '创建时间',
  `GMT_MODIFED` datetime DEFAULT NULL COMMENT '修改时间',
  `IS_DEL` int(4) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='评论表';

-- ----------------------------
-- Records of mv_comment
-- ----------------------------
INSERT INTO `mv_comment` VALUES ('1', '1', '6', '6', '1', 'Public/upload/2018-11-21/2018_11_21_17_22_25_92875.jpg', '1', '2222222', '0000-00-00 00:00:00', null, '0');
INSERT INTO `mv_comment` VALUES ('2', '2', '1', '14', 'ge1', '/Public/admin/images/head/10.png', '1', null, '2018-11-28 14:47:56', null, '0');
INSERT INTO `mv_comment` VALUES ('3', '2', '1', '14', 'ge1', '/Public/admin/images/head/10.png', '4', null, '2018-11-28 14:48:03', null, '0');
INSERT INTO `mv_comment` VALUES ('4', '2', '1', '14', 'ge1', '/Public/admin/images/head/10.png', '5', null, '2018-11-28 14:50:37', null, '0');
INSERT INTO `mv_comment` VALUES ('5', '2', '1', '14', 'ge1', '/Public/admin/images/head/10.png', '4', null, '2018-11-28 14:51:09', null, '0');
INSERT INTO `mv_comment` VALUES ('6', '2', '1', '14', 'ge1', '/Public/admin/images/head/10.png', '4', null, '2018-11-28 14:51:12', null, '0');
INSERT INTO `mv_comment` VALUES ('7', '2', '1', '14', 'ge1', '/Public/admin/images/head/10.png', '1', null, '2018-11-28 14:52:43', null, '0');
INSERT INTO `mv_comment` VALUES ('8', '2', '1', '14', 'ge1', '/Public/admin/images/head/10.png', '1', null, '2018-11-28 14:56:36', null, '0');
INSERT INTO `mv_comment` VALUES ('9', '2', '1', '14', 'ge1', '/Public/admin/images/head/10.png', '4', null, '2018-11-28 14:57:55', null, '0');
INSERT INTO `mv_comment` VALUES ('10', '1', '4', '14', 'ge1', '/Public/admin/images/head/10.png', '4', null, '2018-11-29 21:23:14', null, '0');
INSERT INTO `mv_comment` VALUES ('11', '1', '4', '14', 'ge1', '/Public/admin/images/head/10.png', '4', null, '2018-11-29 21:23:21', null, '0');
INSERT INTO `mv_comment` VALUES ('12', '2', '2', '15', 'liyancai', '/Public/upload/2018-12-01/2018_12_01_11_46_34_86865.png', '1', '1111', '2018-12-01 16:27:22', null, '0');
INSERT INTO `mv_comment` VALUES ('13', '1', '3', '14', 'ge1', '/Public/upload/2018-12-01/2018_12_01_13_19_28_61210.png', '1', 'fdg ', '2018-12-03 13:02:57', null, '0');
INSERT INTO `mv_comment` VALUES ('14', '1', '3', '14', 'ge1', '/Public/upload/2018-12-01/2018_12_01_13_19_28_61210.png', '5', 'tyt ', '2018-12-03 13:03:32', null, '0');
INSERT INTO `mv_comment` VALUES ('15', '2', '2', '14', 'ge1', '/Public/upload/2018-12-06/2018_12_06_20_53_12_88197.png', '4', '啊哈哈，真好看，太棒了！', '2018-12-10 23:35:18', null, '0');
INSERT INTO `mv_comment` VALUES ('16', '1', '6', '40', '123123123', '/Public/admin/images/head/7.png', '4', '123132123132132132132123132123132123123123132123132123132132132132123123123123123123123123', '2018-12-11 15:09:58', null, '0');
INSERT INTO `mv_comment` VALUES ('17', '1', '6', '40', '123123123', '/Public/admin/images/head/7.png', '4', '123132123132132132132123132123132123123123132123132123132132132132123123123123123123123123', '2018-12-11 15:10:00', null, '0');
INSERT INTO `mv_comment` VALUES ('18', '1', '5', '14', 'ge1', '/Public/upload/2018-12-06/2018_12_06_20_53_12_88197.png', '3', '看着不错，感谢分享！', '2018-12-11 17:06:58', null, '0');
INSERT INTO `mv_comment` VALUES ('19', '1', '5', '14', 'ge1', '/Public/upload/2018-12-06/2018_12_06_20_53_12_88197.png', '5', '特别好', '2018-12-11 17:09:26', null, '0');
INSERT INTO `mv_comment` VALUES ('20', '1', '6', '14', 'ge1', '/Public/upload/2018-12-06/2018_12_06_20_53_12_88197.png', '4', '好评', '2018-12-11 17:19:51', null, '0');
INSERT INTO `mv_comment` VALUES ('21', '1', '1', '41', 'sunny', '/Public/admin/images/head/3.png', '4', '你改名您，', '2018-12-25 02:40:31', null, '0');
INSERT INTO `mv_comment` VALUES ('22', '1', '7', '44', 'sunnh', '/Public/admin/images/head/2.png', '5', '中民工，', '2018-12-27 01:19:04', null, '0');
INSERT INTO `mv_comment` VALUES ('23', '1', '7', '44', 'sunnh', '/Public/admin/images/head/2.png', '5', '想你们，', '2018-12-27 01:20:00', null, '0');
INSERT INTO `mv_comment` VALUES ('24', '1', '6', '44', 'sunnh', '/Public/admin/images/head/2.png', '1', '我婆婆婆婆', '2018-12-27 01:32:30', null, '0');

-- ----------------------------
-- Table structure for `mv_look_history`
-- ----------------------------
DROP TABLE IF EXISTS `mv_look_history`;
CREATE TABLE `mv_look_history` (
  `ID` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `LH_USERID` int(16) DEFAULT NULL COMMENT '用户id',
  `LH_TYPE` varchar(16) DEFAULT NULL COMMENT '观看类型 免费/付费',
  `LH_PHYLETIC` varchar(16) DEFAULT NULL COMMENT '观看类别 视频/漫画',
  `LH_LOOKID` int(16) DEFAULT NULL COMMENT '观看id',
  `TYPE` int(3) DEFAULT '0' COMMENT '1:观看，2：收藏',
  `GMT_CREATE` datetime DEFAULT NULL COMMENT '创建时间',
  `GMT_MODIFED` datetime DEFAULT NULL COMMENT '修改时间',
  `IS_DEL` int(4) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=349 DEFAULT CHARSET=utf8 COMMENT='观看记录表';

-- ----------------------------
-- Records of mv_look_history
-- ----------------------------
INSERT INTO `mv_look_history` VALUES ('1', '14', '1', '1', '3', '1', '2018-11-28 14:41:57', null, '1');
INSERT INTO `mv_look_history` VALUES ('2', '14', '1', '1', '3', '1', '2018-11-28 14:42:24', null, '1');
INSERT INTO `mv_look_history` VALUES ('3', '14', '1', '1', '3', '1', '2018-11-28 14:43:14', null, '1');
INSERT INTO `mv_look_history` VALUES ('4', '14', '1', '1', '3', '1', '2018-11-28 14:44:06', null, '1');
INSERT INTO `mv_look_history` VALUES ('5', '14', '1', '1', '2', '1', '2018-11-28 15:44:23', null, '1');
INSERT INTO `mv_look_history` VALUES ('6', '14', '1', '1', '2', '1', '2018-11-28 15:45:01', null, '1');
INSERT INTO `mv_look_history` VALUES ('7', '14', '1', '1', '2', '1', '2018-11-28 15:51:38', null, '1');
INSERT INTO `mv_look_history` VALUES ('8', '14', '1', '1', '2', '1', '2018-11-28 15:54:18', null, '1');
INSERT INTO `mv_look_history` VALUES ('9', '14', '1', '1', '2', '1', '2018-11-28 15:55:56', null, '1');
INSERT INTO `mv_look_history` VALUES ('10', '14', '1', '1', '2', '1', '2018-11-28 15:58:36', null, '1');
INSERT INTO `mv_look_history` VALUES ('11', '14', '1', '1', '2', '1', '2018-11-28 15:59:10', null, '1');
INSERT INTO `mv_look_history` VALUES ('12', '14', '1', '1', '2', '1', '2018-11-28 15:59:42', null, '1');
INSERT INTO `mv_look_history` VALUES ('13', '14', '1', '1', '2', '1', '2018-11-28 16:00:35', null, '1');
INSERT INTO `mv_look_history` VALUES ('14', '14', '1', '1', '2', '1', '2018-11-28 16:01:58', null, '1');
INSERT INTO `mv_look_history` VALUES ('15', '14', '1', '1', '2', '1', '2018-11-28 16:02:07', null, '0');
INSERT INTO `mv_look_history` VALUES ('16', '14', '1', '1', '2', '1', '2018-11-28 16:02:23', null, '0');
INSERT INTO `mv_look_history` VALUES ('17', '14', '1', '1', '2', '1', '2018-11-28 16:05:36', null, '0');
INSERT INTO `mv_look_history` VALUES ('18', '14', '1', '1', '2', '1', '2018-11-28 16:05:41', null, '0');
INSERT INTO `mv_look_history` VALUES ('19', '14', '1', '1', '2', '1', '2018-11-28 16:05:50', null, '0');
INSERT INTO `mv_look_history` VALUES ('20', '14', '1', '1', '2', '1', '2018-11-28 16:14:54', null, '0');
INSERT INTO `mv_look_history` VALUES ('21', '14', '1', '1', '2', '1', '2018-11-28 16:15:52', null, '0');
INSERT INTO `mv_look_history` VALUES ('22', '14', '1', '1', '2', '1', '2018-11-28 16:16:56', null, '0');
INSERT INTO `mv_look_history` VALUES ('23', '14', '1', '1', '2', '1', '2018-11-28 16:17:01', null, '0');
INSERT INTO `mv_look_history` VALUES ('24', '14', '1', '1', '2', '1', '2018-11-28 16:17:05', null, '0');
INSERT INTO `mv_look_history` VALUES ('25', '14', '1', '1', '2', '1', '2018-11-28 16:17:15', null, '0');
INSERT INTO `mv_look_history` VALUES ('26', '14', '1', '1', '2', '1', '2018-11-28 16:18:53', null, '0');
INSERT INTO `mv_look_history` VALUES ('27', '14', '1', '1', '2', '1', '2018-11-28 16:18:56', null, '0');
INSERT INTO `mv_look_history` VALUES ('28', '14', '1', '1', '2', '1', '2018-11-28 16:18:59', null, '0');
INSERT INTO `mv_look_history` VALUES ('29', '14', '2', '1', '2', '1', '2018-11-28 16:19:02', null, '0');
INSERT INTO `mv_look_history` VALUES ('30', '14', '2', '1', '2', '1', '2018-11-28 16:19:03', null, '0');
INSERT INTO `mv_look_history` VALUES ('31', '14', '1', '1', '2', '1', '2018-11-28 16:20:36', null, '0');
INSERT INTO `mv_look_history` VALUES ('32', '14', '1', '1', '2', '1', '2018-11-28 16:20:38', null, '0');
INSERT INTO `mv_look_history` VALUES ('33', '14', '1', '1', '2', '1', '2018-11-28 16:20:40', null, '0');
INSERT INTO `mv_look_history` VALUES ('34', '14', '2', '1', '2', '1', '2018-11-28 16:20:41', null, '0');
INSERT INTO `mv_look_history` VALUES ('35', '14', '2', '1', '2', '1', '2018-11-28 16:20:43', null, '0');
INSERT INTO `mv_look_history` VALUES ('36', '14', '1', '1', '2', '1', '2018-11-28 16:22:06', null, '0');
INSERT INTO `mv_look_history` VALUES ('37', '14', '1', '1', '2', '1', '2018-11-28 16:22:08', null, '0');
INSERT INTO `mv_look_history` VALUES ('38', '14', '1', '1', '2', '1', '2018-11-28 16:22:10', null, '0');
INSERT INTO `mv_look_history` VALUES ('39', '14', '2', '1', '2', '1', '2018-11-28 16:22:12', null, '0');
INSERT INTO `mv_look_history` VALUES ('40', '14', '2', '1', '2', '1', '2018-11-28 16:22:13', null, '0');
INSERT INTO `mv_look_history` VALUES ('41', '14', '1', '1', '2', '1', '2018-11-28 16:22:35', null, '0');
INSERT INTO `mv_look_history` VALUES ('42', '14', '1', '1', '2', '1', '2018-11-28 16:22:42', null, '0');
INSERT INTO `mv_look_history` VALUES ('43', '14', '1', '1', '2', '1', '2018-11-28 16:24:24', null, '0');
INSERT INTO `mv_look_history` VALUES ('44', '14', '1', '1', '2', '1', '2018-11-28 16:24:35', null, '0');
INSERT INTO `mv_look_history` VALUES ('45', '14', '1', '1', '2', '1', '2018-11-28 16:24:37', null, '0');
INSERT INTO `mv_look_history` VALUES ('46', '14', '1', '1', '2', '1', '2018-11-28 16:24:39', null, '0');
INSERT INTO `mv_look_history` VALUES ('47', '14', '1', '1', '2', '1', '2018-11-28 16:25:02', null, '0');
INSERT INTO `mv_look_history` VALUES ('48', '14', '1', '1', '2', '1', '2018-11-28 16:25:04', null, '0');
INSERT INTO `mv_look_history` VALUES ('49', '14', '1', '1', '2', '1', '2018-11-28 16:25:06', null, '0');
INSERT INTO `mv_look_history` VALUES ('50', '14', '2', '1', '2', '1', '2018-11-28 16:25:08', null, '0');
INSERT INTO `mv_look_history` VALUES ('51', '14', '2', '1', '2', '1', '2018-11-28 16:25:09', null, '0');
INSERT INTO `mv_look_history` VALUES ('52', '14', '2', '1', '2', '1', '2018-11-28 16:25:13', null, '0');
INSERT INTO `mv_look_history` VALUES ('53', '14', '1', '1', '2', '1', '2018-11-28 16:25:15', null, '0');
INSERT INTO `mv_look_history` VALUES ('54', '14', '1', '1', '2', '1', '2018-11-28 16:25:17', null, '0');
INSERT INTO `mv_look_history` VALUES ('55', '14', '1', '1', '2', '1', '2018-11-28 16:25:18', null, '0');
INSERT INTO `mv_look_history` VALUES ('56', '14', '1', '1', '2', '1', '2018-11-28 16:25:56', null, '0');
INSERT INTO `mv_look_history` VALUES ('57', '14', '1', '1', '6', '1', '2018-11-28 16:47:29', null, '1');
INSERT INTO `mv_look_history` VALUES ('58', '14', '1', '1', '6', '1', '2018-11-28 16:48:16', null, '1');
INSERT INTO `mv_look_history` VALUES ('59', '14', null, '1', '2', '1', '2018-11-28 16:48:22', null, '0');
INSERT INTO `mv_look_history` VALUES ('60', '14', '1', '1', '6', '1', '2018-11-28 16:51:09', null, '1');
INSERT INTO `mv_look_history` VALUES ('61', '14', '1', '1', '6', '1', '2018-11-28 16:57:40', null, '1');
INSERT INTO `mv_look_history` VALUES ('62', '14', '1', '1', '6', '2', '2018-11-28 16:57:43', null, '1');
INSERT INTO `mv_look_history` VALUES ('63', '14', '1', '1', '6', '2', '2018-11-28 16:57:56', null, '1');
INSERT INTO `mv_look_history` VALUES ('64', '14', '1', '1', '6', '1', '2018-11-28 17:02:53', null, '1');
INSERT INTO `mv_look_history` VALUES ('65', '14', '1', '1', '6', '1', '2018-11-28 17:03:05', null, '1');
INSERT INTO `mv_look_history` VALUES ('66', '14', '1', '1', '6', '1', '2018-11-28 17:04:14', null, '1');
INSERT INTO `mv_look_history` VALUES ('67', '14', '1', '1', '6', '1', '2018-11-28 17:06:38', null, '1');
INSERT INTO `mv_look_history` VALUES ('68', '14', '1', '1', '6', '2', '2018-11-28 17:06:42', null, '1');
INSERT INTO `mv_look_history` VALUES ('69', '14', '1', '1', '6', '2', '2018-11-28 17:06:47', null, '1');
INSERT INTO `mv_look_history` VALUES ('70', '14', '1', '1', '6', '1', '2018-11-28 17:07:08', null, '1');
INSERT INTO `mv_look_history` VALUES ('71', '14', '1', '1', '6', '1', '2018-11-28 17:08:01', null, '1');
INSERT INTO `mv_look_history` VALUES ('72', '14', '1', '1', '3', '1', '2018-11-28 17:08:30', null, '1');
INSERT INTO `mv_look_history` VALUES ('73', '14', '1', '1', '6', '1', '2018-11-28 17:08:35', null, '1');
INSERT INTO `mv_look_history` VALUES ('74', '14', '1', '1', '4', '1', '2018-11-28 17:08:43', null, '1');
INSERT INTO `mv_look_history` VALUES ('75', '14', '1', '1', '4', '1', '2018-11-28 17:09:04', null, '1');
INSERT INTO `mv_look_history` VALUES ('76', '14', null, '2', '1', '2', '2018-11-28 20:31:13', null, '1');
INSERT INTO `mv_look_history` VALUES ('77', '14', '1', '1', '3', '1', '2018-11-28 20:31:45', null, '1');
INSERT INTO `mv_look_history` VALUES ('78', '14', '1', '1', '3', '2', '2018-11-28 20:31:47', null, '1');
INSERT INTO `mv_look_history` VALUES ('79', '14', '1', '1', '3', '1', '2018-11-28 20:31:53', null, '1');
INSERT INTO `mv_look_history` VALUES ('80', '14', '1', '1', '3', '1', '2018-11-28 20:33:24', null, '1');
INSERT INTO `mv_look_history` VALUES ('81', '14', null, '2', '2', '2', '2018-11-28 20:33:35', null, '1');
INSERT INTO `mv_look_history` VALUES ('82', '14', null, '2', '1', '2', '2018-11-28 20:53:24', null, '1');
INSERT INTO `mv_look_history` VALUES ('83', '14', null, '2', '1', '2', '2018-11-28 21:02:49', null, '1');
INSERT INTO `mv_look_history` VALUES ('84', '15', '1', '2', '1', '1', '2018-11-28 21:15:23', '2018-11-28 21:16:22', '1');
INSERT INTO `mv_look_history` VALUES ('87', '15', '1', '2', '1', '1', '2018-11-28 21:20:44', '2018-11-28 21:20:45', '1');
INSERT INTO `mv_look_history` VALUES ('88', '14', '1', '2', '1', '1', '2018-11-28 21:30:55', null, '1');
INSERT INTO `mv_look_history` VALUES ('89', '14', '1', '1', '6', '1', '2018-11-29 21:10:07', '2018-12-11 21:48:56', '1');
INSERT INTO `mv_look_history` VALUES ('90', '14', '1', '1', '4', '1', '2018-11-29 21:21:33', '2018-12-11 17:42:40', '1');
INSERT INTO `mv_look_history` VALUES ('91', '14', '1', '1', '4', '1', '2018-11-29 21:24:37', null, '1');
INSERT INTO `mv_look_history` VALUES ('92', '14', '1', '1', '3', '1', '2018-11-30 10:04:06', null, '1');
INSERT INTO `mv_look_history` VALUES ('93', '14', '2', '2', '1', '1', '2018-11-30 12:14:57', '2018-12-07 14:22:02', '0');
INSERT INTO `mv_look_history` VALUES ('94', '14', '2', '2', '2', '1', '2018-11-30 12:15:10', null, '1');
INSERT INTO `mv_look_history` VALUES ('95', '14', '2', '2', '2', '1', '2018-11-30 12:15:32', null, '1');
INSERT INTO `mv_look_history` VALUES ('96', '15', '2', '2', '2', '1', '2018-11-30 12:16:40', null, '0');
INSERT INTO `mv_look_history` VALUES ('97', '15', '1', '1', '6', '1', '2018-12-01 16:14:28', '2018-12-11 22:00:33', '0');
INSERT INTO `mv_look_history` VALUES ('98', '15', '1', '1', '6', '1', '2018-12-01 16:17:07', null, '0');
INSERT INTO `mv_look_history` VALUES ('99', '15', '1', '1', '3', '1', '2018-12-01 16:17:24', '2018-12-11 21:58:41', '0');
INSERT INTO `mv_look_history` VALUES ('100', '15', '1', '1', '6', '1', '2018-12-01 16:17:45', null, '0');
INSERT INTO `mv_look_history` VALUES ('101', '15', '1', '1', '3', '1', '2018-12-01 16:18:35', null, '0');
INSERT INTO `mv_look_history` VALUES ('102', '15', '1', '1', '6', '1', '2018-12-02 15:55:18', null, '0');
INSERT INTO `mv_look_history` VALUES ('103', '15', '1', '1', '3', '1', '2018-12-02 15:55:30', null, '0');
INSERT INTO `mv_look_history` VALUES ('104', '15', '1', '1', '6', '1', '2018-12-02 15:55:38', null, '1');
INSERT INTO `mv_look_history` VALUES ('105', '15', '1', '1', '5', '1', '2018-12-02 16:11:52', '2018-12-13 13:17:04', '0');
INSERT INTO `mv_look_history` VALUES ('106', '14', '1', '1', '6', '1', '2018-12-02 22:08:04', null, '1');
INSERT INTO `mv_look_history` VALUES ('107', '14', '1', '1', '3', '1', '2018-12-03 12:59:01', null, '1');
INSERT INTO `mv_look_history` VALUES ('108', '14', '1', '1', '3', '1', '2018-12-03 13:00:11', null, '1');
INSERT INTO `mv_look_history` VALUES ('109', '14', '1', '1', '3', '1', '2018-12-03 13:07:34', null, '1');
INSERT INTO `mv_look_history` VALUES ('110', '14', '1', '1', '3', '1', '2018-12-03 13:07:38', null, '1');
INSERT INTO `mv_look_history` VALUES ('111', '14', '1', '1', '3', '1', '2018-12-03 13:09:01', null, '1');
INSERT INTO `mv_look_history` VALUES ('112', '14', '1', '1', '3', '1', '2018-12-03 13:18:53', null, '1');
INSERT INTO `mv_look_history` VALUES ('117', '14', '1', '1', '6', '1', '2018-12-03 14:01:48', null, '1');
INSERT INTO `mv_look_history` VALUES ('127', '14', '1', '2', '2', '1', '2018-12-03 14:21:00', null, '1');
INSERT INTO `mv_look_history` VALUES ('128', '15', '1', '1', '6', '1', '2018-12-03 14:30:57', null, '1');
INSERT INTO `mv_look_history` VALUES ('129', '15', '1', '1', '6', '1', '2018-12-03 14:35:30', null, '1');
INSERT INTO `mv_look_history` VALUES ('130', '15', '1', '1', '6', '1', '2018-12-03 14:38:17', null, '1');
INSERT INTO `mv_look_history` VALUES ('131', '15', '1', '1', '6', '2', '2018-12-03 14:42:17', null, '1');
INSERT INTO `mv_look_history` VALUES ('132', '14', '1', '2', '2', '1', '2018-12-07 14:22:14', null, '0');
INSERT INTO `mv_look_history` VALUES ('133', '40', '1', '1', '6', '1', '2018-12-11 15:05:32', '2018-12-11 16:22:52', '0');
INSERT INTO `mv_look_history` VALUES ('134', '40', '1', '2', '2', '1', '2018-12-11 15:56:53', null, '0');
INSERT INTO `mv_look_history` VALUES ('135', '40', '1', '2', '2', '1', '2018-12-11 15:57:00', null, '0');
INSERT INTO `mv_look_history` VALUES ('136', '40', '1', '2', '2', '1', '2018-12-11 15:57:02', null, '0');
INSERT INTO `mv_look_history` VALUES ('137', '40', '1', '2', '2', '1', '2018-12-11 15:57:16', null, '0');
INSERT INTO `mv_look_history` VALUES ('138', '40', '1', '2', '2', '1', '2018-12-11 15:57:20', null, '0');
INSERT INTO `mv_look_history` VALUES ('139', '40', '1', '2', '2', '1', '2018-12-11 15:57:53', null, '0');
INSERT INTO `mv_look_history` VALUES ('140', '40', '1', '2', '2', '1', '2018-12-11 15:58:02', null, '0');
INSERT INTO `mv_look_history` VALUES ('141', '40', null, '2', '2', '2', '2018-12-11 16:02:50', null, '0');
INSERT INTO `mv_look_history` VALUES ('142', '40', '1', '1', '6', '2', '2018-12-11 16:08:42', null, '0');
INSERT INTO `mv_look_history` VALUES ('143', '14', '1', '1', '5', '1', '2018-12-11 17:06:22', '2018-12-13 17:42:27', '1');
INSERT INTO `mv_look_history` VALUES ('144', '14', '1', '1', '3', '1', '2018-12-11 17:06:29', '2018-12-11 19:17:47', '1');
INSERT INTO `mv_look_history` VALUES ('145', '14', '1', '1', '5', '2', '2018-12-11 17:06:36', null, '1');
INSERT INTO `mv_look_history` VALUES ('146', '14', '1', '1', '5', '2', '2018-12-11 20:12:01', null, '1');
INSERT INTO `mv_look_history` VALUES ('147', '14', null, '2', '2', '2', '2018-12-11 20:22:37', null, '1');
INSERT INTO `mv_look_history` VALUES ('148', '14', '1', '1', '6', '2', '2018-12-11 21:34:44', null, '1');
INSERT INTO `mv_look_history` VALUES ('149', '14', '1', '1', '6', '2', '2018-12-11 21:39:27', null, '1');
INSERT INTO `mv_look_history` VALUES ('150', '14', '1', '1', '6', '2', '2018-12-11 21:40:52', null, '1');
INSERT INTO `mv_look_history` VALUES ('151', '14', '1', '1', '5', '2', '2018-12-11 21:40:55', null, '1');
INSERT INTO `mv_look_history` VALUES ('152', '14', '1', '1', '4', '2', '2018-12-11 21:41:02', null, '1');
INSERT INTO `mv_look_history` VALUES ('153', '14', '1', '1', '6', '2', '2018-12-11 21:43:34', null, '1');
INSERT INTO `mv_look_history` VALUES ('154', '14', '1', '1', '6', '2', '2018-12-11 21:43:41', null, '1');
INSERT INTO `mv_look_history` VALUES ('155', '14', '1', '1', '5', '2', '2018-12-11 21:43:42', null, '1');
INSERT INTO `mv_look_history` VALUES ('156', '14', '1', '1', '5', '2', '2018-12-11 21:45:46', null, '1');
INSERT INTO `mv_look_history` VALUES ('157', '14', '1', '1', '5', '2', '2018-12-11 21:48:52', null, '1');
INSERT INTO `mv_look_history` VALUES ('158', '14', '1', '1', '6', '2', '2018-12-11 21:49:27', null, '1');
INSERT INTO `mv_look_history` VALUES ('168', '14', '1', '1', '3', '1', '2018-12-13 19:59:08', null, '1');
INSERT INTO `mv_look_history` VALUES ('160', '14', '1', '1', '6', '2', '2018-12-11 21:51:35', null, '1');
INSERT INTO `mv_look_history` VALUES ('161', '14', '1', '1', '5', '2', '2018-12-11 22:34:40', null, '1');
INSERT INTO `mv_look_history` VALUES ('162', '14', '1', '1', '3', '2', '2018-12-11 22:34:44', null, '1');
INSERT INTO `mv_look_history` VALUES ('163', '15', '1', '1', '5', '2', '2018-12-13 09:58:21', null, '1');
INSERT INTO `mv_look_history` VALUES ('164', '15', '1', '1', '5', '2', '2018-12-13 09:58:23', null, '1');
INSERT INTO `mv_look_history` VALUES ('165', '15', '1', '1', '5', '2', '2018-12-13 09:58:25', null, '1');
INSERT INTO `mv_look_history` VALUES ('166', '15', '1', '1', '5', '2', '2018-12-13 09:58:27', null, '1');
INSERT INTO `mv_look_history` VALUES ('167', '14', '1', '1', '5', '2', '2018-12-13 12:30:19', null, '1');
INSERT INTO `mv_look_history` VALUES ('169', '14', '2', '1', '6', '1', '2018-12-13 20:00:11', null, '1');
INSERT INTO `mv_look_history` VALUES ('170', '14', '2', '1', '6', '2', '2018-12-13 20:00:26', null, '1');
INSERT INTO `mv_look_history` VALUES ('171', '14', '2', '1', '6', '2', '2018-12-13 20:00:33', null, '1');
INSERT INTO `mv_look_history` VALUES ('172', '14', null, '2', '1', '2', '2018-12-13 20:10:03', null, '1');
INSERT INTO `mv_look_history` VALUES ('173', '14', '1', '1', '3', '1', '2018-12-13 20:10:12', null, '1');
INSERT INTO `mv_look_history` VALUES ('174', '14', '1', '1', '3', '2', '2018-12-13 20:10:21', null, '0');
INSERT INTO `mv_look_history` VALUES ('175', '14', '2', '1', '6', '2', '2018-12-13 20:13:05', null, '1');
INSERT INTO `mv_look_history` VALUES ('176', '15', '2', '1', '6', '1', '2018-12-13 20:37:34', null, '1');
INSERT INTO `mv_look_history` VALUES ('177', '14', '2', '1', '6', '1', '2018-12-14 00:09:50', null, '1');
INSERT INTO `mv_look_history` VALUES ('178', '14', '1', '1', '1', '1', '2018-12-14 11:16:50', null, '1');
INSERT INTO `mv_look_history` VALUES ('179', '14', '1', '1', '1', '1', '2018-12-14 14:30:29', null, '1');
INSERT INTO `mv_look_history` VALUES ('180', '14', '1', '1', '1', '2', '2018-12-14 14:30:36', null, '1');
INSERT INTO `mv_look_history` VALUES ('181', '14', '1', '1', '1', '1', '2018-12-14 14:30:54', null, '1');
INSERT INTO `mv_look_history` VALUES ('182', '14', '1', '1', '1', '1', '2018-12-14 14:31:10', null, '1');
INSERT INTO `mv_look_history` VALUES ('183', '14', '1', '1', '1', '1', '2018-12-14 14:33:01', null, '1');
INSERT INTO `mv_look_history` VALUES ('184', '14', '1', '1', '1', '1', '2018-12-14 14:36:53', null, '1');
INSERT INTO `mv_look_history` VALUES ('185', '14', '1', '1', '3', '1', '2018-12-14 14:36:56', null, '0');
INSERT INTO `mv_look_history` VALUES ('186', '14', '1', '1', '5', '1', '2018-12-14 14:37:01', null, '1');
INSERT INTO `mv_look_history` VALUES ('187', '14', '1', '1', '3', '1', '2018-12-14 14:38:46', null, '1');
INSERT INTO `mv_look_history` VALUES ('188', '14', '1', '1', '1', '1', '2018-12-14 15:05:52', null, '1');
INSERT INTO `mv_look_history` VALUES ('189', '14', '2', '1', '6', '2', '2018-12-14 15:19:33', null, '0');
INSERT INTO `mv_look_history` VALUES ('190', '14', '1', '1', '4', '2', '2018-12-14 15:19:37', null, '1');
INSERT INTO `mv_look_history` VALUES ('191', '14', null, '2', '1', '2', '2018-12-14 15:20:58', null, '0');
INSERT INTO `mv_look_history` VALUES ('192', '14', '1', '2', '2', '1', '2018-12-15 12:11:48', null, '1');
INSERT INTO `mv_look_history` VALUES ('193', '14', '1', '2', '1', '1', '2018-12-15 12:41:16', null, '0');
INSERT INTO `mv_look_history` VALUES ('194', '14', '1', '2', '2', '1', '2018-12-15 12:41:28', null, '1');
INSERT INTO `mv_look_history` VALUES ('195', '14', '1', '2', '2', '1', '2018-12-15 12:41:49', null, '1');
INSERT INTO `mv_look_history` VALUES ('196', '14', '1', '2', '2', '1', '2018-12-15 12:41:51', null, '1');
INSERT INTO `mv_look_history` VALUES ('197', '14', '1', '2', '2', '1', '2018-12-15 12:41:52', null, '1');
INSERT INTO `mv_look_history` VALUES ('198', '14', '1', '1', '1', '1', '2018-12-15 13:43:45', null, '1');
INSERT INTO `mv_look_history` VALUES ('199', '14', '1', '1', '1', '1', '2018-12-15 13:45:43', null, '1');
INSERT INTO `mv_look_history` VALUES ('200', '14', '1', '1', '1', '1', '2018-12-15 13:47:03', null, '1');
INSERT INTO `mv_look_history` VALUES ('201', '14', '1', '1', '1', '1', '2018-12-15 13:47:58', null, '1');
INSERT INTO `mv_look_history` VALUES ('202', '14', '1', '1', '1', '1', '2018-12-15 13:52:23', null, '1');
INSERT INTO `mv_look_history` VALUES ('203', '14', '1', '1', '1', '2', '2018-12-15 13:52:33', null, '1');
INSERT INTO `mv_look_history` VALUES ('204', '14', '1', '1', '1', '1', '2018-12-15 13:52:40', null, '1');
INSERT INTO `mv_look_history` VALUES ('205', '14', '1', '1', '1', '1', '2018-12-15 13:52:44', null, '1');
INSERT INTO `mv_look_history` VALUES ('206', '14', '1', '1', '1', '1', '2018-12-15 13:54:21', null, '1');
INSERT INTO `mv_look_history` VALUES ('207', '14', '1', '1', '1', '1', '2018-12-15 14:01:02', null, '1');
INSERT INTO `mv_look_history` VALUES ('208', '14', '1', '1', '1', '1', '2018-12-15 14:02:53', null, '1');
INSERT INTO `mv_look_history` VALUES ('209', '14', '1', '1', '1', '1', '2018-12-15 14:06:47', null, '1');
INSERT INTO `mv_look_history` VALUES ('210', '14', '1', '1', '1', '1', '2018-12-15 14:06:50', null, '1');
INSERT INTO `mv_look_history` VALUES ('211', '14', '1', '1', '1', '1', '2018-12-15 14:11:19', null, '1');
INSERT INTO `mv_look_history` VALUES ('212', '14', '1', '1', '1', '1', '2018-12-15 14:11:22', null, '1');
INSERT INTO `mv_look_history` VALUES ('213', '14', '1', '1', '1', '1', '2018-12-15 14:12:23', null, '1');
INSERT INTO `mv_look_history` VALUES ('214', '14', '1', '1', '1', '1', '2018-12-15 14:14:53', null, '1');
INSERT INTO `mv_look_history` VALUES ('215', '14', '1', '1', '1', '1', '2018-12-15 14:15:29', null, '1');
INSERT INTO `mv_look_history` VALUES ('216', '14', '1', '1', '1', '1', '2018-12-15 14:15:33', null, '1');
INSERT INTO `mv_look_history` VALUES ('217', '14', '1', '1', '1', '1', '2018-12-15 14:20:11', null, '1');
INSERT INTO `mv_look_history` VALUES ('218', '14', '1', '1', '1', '1', '2018-12-15 14:20:24', null, '1');
INSERT INTO `mv_look_history` VALUES ('219', '40', '1', '1', '3', '1', '2018-12-18 10:32:17', null, '0');
INSERT INTO `mv_look_history` VALUES ('220', '40', '1', '1', '3', '1', '2018-12-18 10:33:17', null, '0');
INSERT INTO `mv_look_history` VALUES ('221', '41', '1', '1', '1', '1', '2018-12-21 21:01:41', null, '0');
INSERT INTO `mv_look_history` VALUES ('222', '41', '1', '1', '1', '1', '2018-12-21 21:01:45', null, '0');
INSERT INTO `mv_look_history` VALUES ('223', '41', '1', '1', '5', '1', '2018-12-21 21:01:50', null, '0');
INSERT INTO `mv_look_history` VALUES ('224', '41', '2', '1', '6', '1', '2018-12-21 21:01:54', null, '0');
INSERT INTO `mv_look_history` VALUES ('225', '15', '1', '1', '1', '1', '2018-12-22 16:58:01', null, '0');
INSERT INTO `mv_look_history` VALUES ('226', '15', '1', '1', '1', '1', '2018-12-22 16:58:16', null, '0');
INSERT INTO `mv_look_history` VALUES ('227', '15', '1', '1', '1', '1', '2018-12-22 17:07:26', null, '0');
INSERT INTO `mv_look_history` VALUES ('228', '41', '1', '1', '1', '1', '2018-12-24 15:29:14', null, '0');
INSERT INTO `mv_look_history` VALUES ('229', '41', '1', '1', '1', '2', '2018-12-24 15:29:26', null, '1');
INSERT INTO `mv_look_history` VALUES ('230', '41', '2', '1', '6', '1', '2018-12-24 15:29:45', null, '0');
INSERT INTO `mv_look_history` VALUES ('231', '41', '1', '1', '1', '1', '2018-12-24 15:30:43', null, '0');
INSERT INTO `mv_look_history` VALUES ('232', '41', '1', '1', '5', '1', '2018-12-24 16:15:20', null, '0');
INSERT INTO `mv_look_history` VALUES ('233', '41', '2', '1', '6', '1', '2018-12-24 16:15:25', null, '0');
INSERT INTO `mv_look_history` VALUES ('234', '41', '1', '1', '4', '1', '2018-12-24 16:15:32', null, '0');
INSERT INTO `mv_look_history` VALUES ('235', '41', '1', '1', '4', '1', '2018-12-24 16:15:41', null, '0');
INSERT INTO `mv_look_history` VALUES ('236', '41', '1', '1', '4', '1', '2018-12-24 16:15:45', null, '0');
INSERT INTO `mv_look_history` VALUES ('237', '41', '1', '1', '1', '1', '2018-12-24 16:15:51', null, '0');
INSERT INTO `mv_look_history` VALUES ('238', '41', '1', '1', '1', '1', '2018-12-24 16:21:00', null, '0');
INSERT INTO `mv_look_history` VALUES ('239', '41', '1', '1', '3', '1', '2018-12-24 16:21:08', null, '0');
INSERT INTO `mv_look_history` VALUES ('240', '41', '1', '1', '5', '1', '2018-12-25 02:38:55', null, '0');
INSERT INTO `mv_look_history` VALUES ('241', '41', '1', '1', '1', '1', '2018-12-25 02:40:01', null, '0');
INSERT INTO `mv_look_history` VALUES ('242', '41', '1', '1', '1', '2', '2018-12-25 02:40:05', null, '1');
INSERT INTO `mv_look_history` VALUES ('243', '41', '1', '1', '5', '1', '2018-12-25 02:40:38', null, '0');
INSERT INTO `mv_look_history` VALUES ('244', '41', '1', '1', '5', '1', '2018-12-25 02:40:45', null, '0');
INSERT INTO `mv_look_history` VALUES ('245', '41', '1', '1', '1', '1', '2018-12-25 02:40:53', null, '0');
INSERT INTO `mv_look_history` VALUES ('246', '41', '1', '1', '3', '1', '2018-12-25 02:41:55', null, '0');
INSERT INTO `mv_look_history` VALUES ('247', '41', '1', '1', '3', '1', '2018-12-25 02:42:04', null, '0');
INSERT INTO `mv_look_history` VALUES ('248', '41', '1', '1', '3', '2', '2018-12-25 02:42:07', null, '0');
INSERT INTO `mv_look_history` VALUES ('249', '41', '1', '1', '3', '1', '2018-12-25 02:45:21', null, '0');
INSERT INTO `mv_look_history` VALUES ('250', '41', '1', '1', '1', '1', '2018-12-25 02:45:25', null, '0');
INSERT INTO `mv_look_history` VALUES ('251', '41', '1', '1', '1', '2', '2018-12-25 02:45:28', null, '0');
INSERT INTO `mv_look_history` VALUES ('252', '41', '2', '1', '6', '1', '2018-12-25 02:45:33', null, '0');
INSERT INTO `mv_look_history` VALUES ('253', '42', '2', '1', '6', '1', '2018-12-25 06:49:33', null, '0');
INSERT INTO `mv_look_history` VALUES ('254', '42', '1', '2', '2', '1', '2018-12-25 06:50:29', null, '0');
INSERT INTO `mv_look_history` VALUES ('255', '42', '1', '2', '2', '1', '2018-12-25 06:50:34', null, '0');
INSERT INTO `mv_look_history` VALUES ('256', '42', '1', '2', '2', '1', '2018-12-25 06:50:38', null, '0');
INSERT INTO `mv_look_history` VALUES ('257', '42', '2', '1', '6', '1', '2018-12-25 07:16:55', null, '0');
INSERT INTO `mv_look_history` VALUES ('258', '42', '2', '1', '7', '1', '2018-12-25 07:23:20', null, '0');
INSERT INTO `mv_look_history` VALUES ('259', '42', '2', '1', '7', '1', '2018-12-25 07:30:49', null, '0');
INSERT INTO `mv_look_history` VALUES ('260', '42', '1', '2', '2', '1', '2018-12-25 07:36:19', null, '0');
INSERT INTO `mv_look_history` VALUES ('261', '42', '1', '2', '2', '1', '2018-12-25 07:36:22', null, '0');
INSERT INTO `mv_look_history` VALUES ('262', '42', '1', '2', '2', '1', '2018-12-25 07:36:24', null, '0');
INSERT INTO `mv_look_history` VALUES ('263', '14', '1', '1', '1', '1', '2018-12-25 15:28:25', null, '0');
INSERT INTO `mv_look_history` VALUES ('264', '14', '2', '1', '7', '1', '2018-12-25 15:54:26', null, '0');
INSERT INTO `mv_look_history` VALUES ('265', '14', '1', '1', '1', '1', '2018-12-25 15:54:34', null, '0');
INSERT INTO `mv_look_history` VALUES ('266', '15', '1', '1', '1', '1', '2018-12-25 21:24:54', null, '0');
INSERT INTO `mv_look_history` VALUES ('267', '42', '1', '1', '1', '1', '2018-12-26 10:44:45', null, '0');
INSERT INTO `mv_look_history` VALUES ('268', '42', '1', '1', '3', '1', '2018-12-26 10:44:51', null, '0');
INSERT INTO `mv_look_history` VALUES ('269', '42', '1', '1', '1', '1', '2018-12-26 10:45:30', null, '0');
INSERT INTO `mv_look_history` VALUES ('270', '42', '2', '1', '7', '1', '2018-12-26 10:45:38', null, '0');
INSERT INTO `mv_look_history` VALUES ('271', '42', '2', '1', '7', '1', '2018-12-26 10:45:51', null, '0');
INSERT INTO `mv_look_history` VALUES ('272', '42', '2', '1', '7', '1', '2018-12-26 10:46:05', null, '0');
INSERT INTO `mv_look_history` VALUES ('273', '42', '1', '1', '4', '1', '2018-12-26 10:46:10', null, '0');
INSERT INTO `mv_look_history` VALUES ('274', '42', '1', '1', '1', '1', '2018-12-26 13:43:31', null, '0');
INSERT INTO `mv_look_history` VALUES ('275', '42', '1', '1', '4', '1', '2018-12-26 13:43:36', null, '0');
INSERT INTO `mv_look_history` VALUES ('276', '42', '1', '1', '1', '1', '2018-12-26 13:44:06', null, '0');
INSERT INTO `mv_look_history` VALUES ('277', '42', '1', '1', '3', '1', '2018-12-26 13:44:10', null, '0');
INSERT INTO `mv_look_history` VALUES ('278', '42', '1', '1', '1', '1', '2018-12-26 16:12:46', null, '0');
INSERT INTO `mv_look_history` VALUES ('279', '42', '1', '1', '3', '1', '2018-12-26 16:12:49', null, '0');
INSERT INTO `mv_look_history` VALUES ('280', '42', '1', '1', '4', '1', '2018-12-26 16:12:53', null, '0');
INSERT INTO `mv_look_history` VALUES ('281', '42', '1', '1', '3', '1', '2018-12-26 16:13:01', null, '0');
INSERT INTO `mv_look_history` VALUES ('282', '44', '1', '1', '1', '1', '2018-12-27 01:06:23', null, '0');
INSERT INTO `mv_look_history` VALUES ('283', '44', '1', '1', '3', '1', '2018-12-27 01:07:14', null, '1');
INSERT INTO `mv_look_history` VALUES ('284', '44', '2', '1', '6', '1', '2018-12-27 01:07:15', null, '0');
INSERT INTO `mv_look_history` VALUES ('285', '44', '1', '1', '3', '1', '2018-12-27 01:09:25', null, '1');
INSERT INTO `mv_look_history` VALUES ('286', '44', '2', '1', '7', '1', '2018-12-27 01:18:53', null, '0');
INSERT INTO `mv_look_history` VALUES ('287', '44', '2', '1', '7', '2', '2018-12-27 01:19:43', null, '1');
INSERT INTO `mv_look_history` VALUES ('288', '44', '2', '1', '7', '2', '2018-12-27 01:19:47', null, '1');
INSERT INTO `mv_look_history` VALUES ('289', '44', '2', '1', '7', '1', '2018-12-27 01:21:05', null, '0');
INSERT INTO `mv_look_history` VALUES ('290', '44', '2', '1', '6', '1', '2018-12-27 01:21:22', null, '0');
INSERT INTO `mv_look_history` VALUES ('291', '44', '2', '1', '7', '1', '2018-12-27 01:21:54', null, '0');
INSERT INTO `mv_look_history` VALUES ('292', '44', '1', '2', '1', '1', '2018-12-27 01:24:44', null, '0');
INSERT INTO `mv_look_history` VALUES ('293', '44', '1', '2', '1', '1', '2018-12-27 01:26:20', null, '0');
INSERT INTO `mv_look_history` VALUES ('294', '44', '1', '2', '1', '1', '2018-12-27 01:27:54', null, '0');
INSERT INTO `mv_look_history` VALUES ('295', '44', '1', '2', '1', '1', '2018-12-27 01:28:07', null, '0');
INSERT INTO `mv_look_history` VALUES ('296', '44', '1', '1', '3', '1', '2018-12-27 01:29:54', null, '0');
INSERT INTO `mv_look_history` VALUES ('297', '44', '2', '1', '6', '1', '2018-12-27 01:32:09', null, '0');
INSERT INTO `mv_look_history` VALUES ('298', '44', '1', '1', '3', '1', '2018-12-27 01:32:36', null, '0');
INSERT INTO `mv_look_history` VALUES ('299', '44', '2', '1', '7', '1', '2018-12-27 11:32:26', null, '0');
INSERT INTO `mv_look_history` VALUES ('300', '44', '2', '1', '7', '1', '2018-12-27 11:32:50', null, '0');
INSERT INTO `mv_look_history` VALUES ('301', '44', '2', '1', '7', '1', '2018-12-27 14:53:17', null, '0');
INSERT INTO `mv_look_history` VALUES ('302', '44', '1', '1', '1', '1', '2018-12-27 15:26:34', null, '0');
INSERT INTO `mv_look_history` VALUES ('303', '44', '1', '1', '1', '2', '2018-12-27 15:26:36', null, '0');
INSERT INTO `mv_look_history` VALUES ('304', '45', '2', '1', '8', '1', '2018-12-29 12:53:32', null, '0');
INSERT INTO `mv_look_history` VALUES ('305', '45', '2', '1', '7', '1', '2018-12-29 12:54:31', null, '0');
INSERT INTO `mv_look_history` VALUES ('306', '45', '2', '1', '7', '1', '2018-12-29 12:54:42', null, '0');
INSERT INTO `mv_look_history` VALUES ('307', '45', '1', '1', '1', '1', '2018-12-29 12:55:00', null, '0');
INSERT INTO `mv_look_history` VALUES ('308', '45', '1', '1', '1', '1', '2018-12-29 12:55:26', null, '1');
INSERT INTO `mv_look_history` VALUES ('309', '45', '1', '1', '1', '2', '2018-12-29 12:55:28', null, '1');
INSERT INTO `mv_look_history` VALUES ('310', '45', '1', '1', '1', '2', '2018-12-29 12:55:32', null, '0');
INSERT INTO `mv_look_history` VALUES ('311', '45', '1', '1', '3', '1', '2018-12-29 14:30:23', null, '1');
INSERT INTO `mv_look_history` VALUES ('312', '45', '1', '2', '2', '1', '2018-12-29 14:31:17', null, '1');
INSERT INTO `mv_look_history` VALUES ('313', '45', '1', '1', '3', '1', '2018-12-29 14:31:23', null, '1');
INSERT INTO `mv_look_history` VALUES ('314', '45', '1', '2', '2', '1', '2018-12-29 14:31:50', null, '1');
INSERT INTO `mv_look_history` VALUES ('315', '45', '1', '2', '2', '1', '2018-12-29 14:31:51', null, '1');
INSERT INTO `mv_look_history` VALUES ('316', '45', '1', '2', '2', '1', '2018-12-29 14:32:17', null, '1');
INSERT INTO `mv_look_history` VALUES ('317', '45', '1', '2', '2', '1', '2018-12-29 14:32:50', null, '1');
INSERT INTO `mv_look_history` VALUES ('318', '45', '1', '2', '2', '1', '2018-12-29 14:32:51', null, '1');
INSERT INTO `mv_look_history` VALUES ('319', '45', '2', '1', '8', '1', '2018-12-29 14:40:36', null, '1');
INSERT INTO `mv_look_history` VALUES ('320', '45', '2', '1', '6', '1', '2018-12-29 14:41:25', null, '1');
INSERT INTO `mv_look_history` VALUES ('321', '45', '2', '1', '6', '1', '2018-12-29 14:42:27', null, '1');
INSERT INTO `mv_look_history` VALUES ('322', '45', '2', '1', '6', '1', '2018-12-29 14:46:25', null, '1');
INSERT INTO `mv_look_history` VALUES ('323', '45', '1', '1', '3', '1', '2018-12-29 14:54:56', null, '1');
INSERT INTO `mv_look_history` VALUES ('324', '15', '1', '2', '2', '1', '2018-12-29 17:00:12', null, '0');
INSERT INTO `mv_look_history` VALUES ('325', '15', '1', '2', '2', '1', '2018-12-29 17:00:42', null, '0');
INSERT INTO `mv_look_history` VALUES ('326', '15', '1', '2', '2', '1', '2018-12-29 17:02:19', null, '0');
INSERT INTO `mv_look_history` VALUES ('327', '15', '1', '2', '2', '1', '2018-12-29 17:02:34', null, '0');
INSERT INTO `mv_look_history` VALUES ('328', '45', '1', '1', '1', '1', '2018-12-30 14:25:37', null, '0');
INSERT INTO `mv_look_history` VALUES ('329', '41', '2', '1', '8', '1', '2019-01-02 18:44:10', null, '0');
INSERT INTO `mv_look_history` VALUES ('330', '41', '2', '1', '8', '1', '2019-01-02 18:47:16', null, '0');
INSERT INTO `mv_look_history` VALUES ('331', '41', '2', '1', '8', '1', '2019-01-02 18:47:49', null, '0');
INSERT INTO `mv_look_history` VALUES ('332', '41', '2', '1', '8', '1', '2019-01-02 18:51:35', null, '0');
INSERT INTO `mv_look_history` VALUES ('333', '41', '2', '1', '8', '1', '2019-01-02 18:51:52', null, '0');
INSERT INTO `mv_look_history` VALUES ('334', '41', '2', '1', '8', '1', '2019-01-02 18:52:20', null, '0');
INSERT INTO `mv_look_history` VALUES ('335', '41', '2', '1', '8', '1', '2019-01-02 18:53:06', null, '0');
INSERT INTO `mv_look_history` VALUES ('336', '41', '2', '1', '8', '1', '2019-01-02 18:53:13', null, '0');
INSERT INTO `mv_look_history` VALUES ('337', '41', '2', '1', '7', '1', '2019-01-02 18:53:20', null, '0');
INSERT INTO `mv_look_history` VALUES ('338', '41', '2', '1', '8', '1', '2019-01-02 18:55:17', null, '0');
INSERT INTO `mv_look_history` VALUES ('339', '41', '2', '1', '8', '1', '2019-01-02 18:56:23', null, '0');
INSERT INTO `mv_look_history` VALUES ('340', '41', '2', '1', '8', '1', '2019-01-02 18:56:33', null, '0');
INSERT INTO `mv_look_history` VALUES ('341', '41', '2', '1', '8', '1', '2019-01-02 18:56:36', null, '0');
INSERT INTO `mv_look_history` VALUES ('342', '41', '2', '1', '8', '1', '2019-01-02 18:58:17', null, '0');
INSERT INTO `mv_look_history` VALUES ('343', '41', '2', '1', '8', '1', '2019-01-02 18:58:19', null, '0');
INSERT INTO `mv_look_history` VALUES ('344', '41', '2', '1', '8', '1', '2019-01-02 18:59:09', null, '0');
INSERT INTO `mv_look_history` VALUES ('345', '41', '2', '1', '8', '1', '2019-01-02 18:59:24', null, '0');
INSERT INTO `mv_look_history` VALUES ('346', '41', '2', '1', '8', '1', '2019-01-02 19:01:12', null, '0');
INSERT INTO `mv_look_history` VALUES ('347', '41', '2', '1', '8', '1', '2019-01-02 19:01:18', null, '0');
INSERT INTO `mv_look_history` VALUES ('348', '41', '2', '1', '8', '1', '2019-01-02 20:22:16', null, '0');

-- ----------------------------
-- Table structure for `mv_movies`
-- ----------------------------
DROP TABLE IF EXISTS `mv_movies`;
CREATE TABLE `mv_movies` (
  `ID` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `MV_NAME` varchar(16) DEFAULT NULL COMMENT '视频名称',
  `MV_PHOTO_URL` text COMMENT '视频封面图',
  `MV_HURL` varchar(255) DEFAULT NULL COMMENT '国内视频地址',
  `MV_WURL` varchar(255) DEFAULT NULL COMMENT '国外视频地址',
  `MV_SHURL` varchar(255) DEFAULT NULL COMMENT '国内视频试看地址',
  `MV_WHURL` varchar(255) DEFAULT NULL COMMENT '国外视频试看地址',
  `MV_TIME` varchar(16) NOT NULL COMMENT '播放时长',
  `MV_PLAY_COUNT` varchar(16) NOT NULL COMMENT '播放次数',
  `MV_TYPE` varchar(16) NOT NULL COMMENT '视频类型 免费/会员',
  `MV_PHYLETIC` varchar(16) DEFAULT NULL COMMENT '视频种类 短视频/电影',
  `MV_CONTENT` varchar(255) DEFAULT NULL COMMENT '视频简介',
  `MV_CATEGORY` varchar(32) NOT NULL COMMENT '视频类别 科幻/动作',
  `MV_STATUS` int(4) DEFAULT '1' COMMENT '视频上架/下架',
  `GMT_CREATE` datetime DEFAULT NULL COMMENT '创建时间',
  `GMT_MODIFED` datetime DEFAULT NULL COMMENT '修改时间',
  `IS_DEL` int(4) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='视频表';

-- ----------------------------
-- Records of mv_movies
-- ----------------------------
INSERT INTO `mv_movies` VALUES ('1', '黄金兄弟', 'Public/upload/2018-11-26/2018_11_26_10_30_44_75552.png', 'http://img.ksbbs.com/asset/Mon_1703/05cacb4e02f9d9e.mp4', 'http://img.ksbbs.com/asset/Mon_1703/05cacb4e02f9d9e.mp4', 'http://resource.apicloud.com/video/apicloud3.mp4', 'http://resource.apicloud.com/video/apicloud3.mp4', '120分钟', '205', '1', '2', '视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介', '科幻', '1', '2018-11-22 10:12:53', '2018-12-13 19:55:59', '0');
INSERT INTO `mv_movies` VALUES ('3', '复仇者联盟', 'Public/upload/2018-11-25/2018_11_25_20_51_03_82419.png', 'http://img.ksbbs.com/asset/Mon_1703/05cacb4e02f9d9e.mp4', 'http://img.ksbbs.com/asset/Mon_1703/05cacb4e02f9d9e.mp4', 'http://resource.apicloud.com/video/apicloud3.mp4', 'http://resource.apicloud.com/video/apicloud3.mp4', '60', '159', '1', '2', '视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介', '科幻', '1', '2018-11-25 20:51:07', '2018-12-13 19:55:50', '0');
INSERT INTO `mv_movies` VALUES ('4', '钢铁侠', 'Public/upload/2018-11-26/2018_11_26_10_33_53_51542.png', 'http://img.ksbbs.com/asset/Mon_1703/05cacb4e02f9d9e.mp4', 'http://img.ksbbs.com/asset/Mon_1703/05cacb4e02f9d9e.mp4', 'http://resource.apicloud.com/video/apicloud3.mp4', 'http://resource.apicloud.com/video/apicloud3.mp4', '60', '2399', '1', '2', '视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介', '科幻', '1', '2018-11-26 10:34:12', '2018-12-13 19:55:40', '0');
INSERT INTO `mv_movies` VALUES ('5', '雷神', 'Public/upload/2018-11-26/2018_11_26_10_35_07_31909.png', 'http://img.ksbbs.com/asset/Mon_1703/05cacb4e02f9d9e.mp4', 'http://img.ksbbs.com/asset/Mon_1703/05cacb4e02f9d9e.mp4', 'http://resource.apicloud.com/video/apicloud3.mp4', 'http://resource.apicloud.com/video/apicloud3.mp4', '100', '621', '1', '2', '视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介', '科幻', '1', '2018-11-26 10:35:26', '2018-12-13 19:55:30', '0');
INSERT INTO `mv_movies` VALUES ('6', '美国队长', 'Public/upload/2018-11-26/2018_11_26_10_36_46_90634.png', 'http://img.ksbbs.com/asset/Mon_1703/05cacb4e02f9d9e.mp4', 'http://img.ksbbs.com/asset/Mon_1703/05cacb4e02f9d9e.mp4', 'http://resource.apicloud.com/video/apicloud3.mp4', 'http://resource.apicloud.com/video/apicloud3.mp4', '120', '32742', '2', '2', '视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简介视频简', '科幻', '1', '2018-11-26 10:38:49', '2018-12-13 19:59:39', '0');
INSERT INTO `mv_movies` VALUES ('7', '天下无双', 'Public/upload/2018-12-25/2018_12_25_07_21_24_87211.png', 'http://sunnyboy6666.oss-cn-beijing.aliyuncs.com/480e87e3b1e2c41957076432d377a5c7.mp4?Expires=1546437373&OSSAccessKeyId=TMP.AQGslujAlIqGWzyxGiOc8q_bg3ndBtoWeIKY0XVlyZmlBt6WSBriyJSmZCqCMC4CFQDAn6kt20Dmsk_2Dgj1KtGe792HgwIVAJoX_AM5dtkQU_HnNDw5P6mRR2kU&Signatu', '', '', '', '', '72', '2', '2', '测试的按时 的的的的', '', '1', '2018-12-25 07:22:25', '2019-01-02 20:56:24', '0');
INSERT INTO `mv_movies` VALUES ('8', '测试视频地址', 'Public/upload/2018-12-27/2018_12_27_15_56_03_44984.jpg', 'http://sunnyboy6666.oss-cn-beijing.aliyuncs.com/1228b268677891a83384bdc2ceae5bff.mp4?Expires=1546429595&OSSAccessKeyId=TMP.AQGslujAlIqGWzyxGiOc8q_bg3ndBtoWeIKY0XVlyZmlBt6WSBriyJSmZCqCMC4CFQDAn6kt20Dmsk_2Dgj1KtGe792HgwIVAJoX_AM5dtkQU_HnNDw5P6mRR2kU&Signatu', '', '', '', '3', '36', '2', '2', '优酷测试视频', '', '1', '2018-12-27 15:56:16', '2019-01-02 18:47:06', '0');

-- ----------------------------
-- Table structure for `mv_my_collection`
-- ----------------------------
DROP TABLE IF EXISTS `mv_my_collection`;
CREATE TABLE `mv_my_collection` (
  `ID` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `MC_USERID` int(16) DEFAULT NULL COMMENT '用户id',
  `MC_TYPE` varchar(16) DEFAULT NULL COMMENT '收藏类型 免费/付费',
  `MC_PHYLETIC` varchar(16) DEFAULT NULL COMMENT '收藏类别 视频/漫画',
  `MC_ID` int(16) DEFAULT NULL COMMENT '收藏id',
  `GMT_CREATE` datetime DEFAULT NULL COMMENT '创建时间',
  `GMT_MODIFED` datetime DEFAULT NULL COMMENT '修改时间',
  `IS_DEL` int(4) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='我的收藏表';

-- ----------------------------
-- Records of mv_my_collection
-- ----------------------------

-- ----------------------------
-- Table structure for `mv_put_forward`
-- ----------------------------
DROP TABLE IF EXISTS `mv_put_forward`;
CREATE TABLE `mv_put_forward` (
  `ID` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `PF_USER_ID` int(16) DEFAULT NULL COMMENT '用户id',
  `PF_PRICE` decimal(8,0) DEFAULT NULL COMMENT '提现金额',
  `PF_BANK_CARD_ID` int(16) DEFAULT NULL COMMENT '提现银行卡表id',
  `PF_STATUS` int(4) DEFAULT '0' COMMENT '审核状态 未审核0/通过1/拒绝2',
  `PF_COMMENT` varchar(255) DEFAULT NULL COMMENT '备注',
  `GMT_CREATE` datetime DEFAULT NULL COMMENT '创建时间',
  `GMT_MODIFED` datetime DEFAULT NULL COMMENT '修改时间',
  `IS_DEL` int(4) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='提现表';

-- ----------------------------
-- Records of mv_put_forward
-- ----------------------------
INSERT INTO `mv_put_forward` VALUES ('1', '8', '2', '1', '2', '111', null, null, '0');
INSERT INTO `mv_put_forward` VALUES ('2', '14', '123', '9', '0', null, '2018-12-01 18:37:43', null, '0');
INSERT INTO `mv_put_forward` VALUES ('3', '14', '123', '9', '0', null, '2018-12-01 18:37:50', null, '0');
INSERT INTO `mv_put_forward` VALUES ('4', '14', '34', '9', '0', null, '2018-12-01 18:41:24', null, '0');
INSERT INTO `mv_put_forward` VALUES ('5', '14', '34', '9', '0', null, '2018-12-01 18:42:11', null, '0');
INSERT INTO `mv_put_forward` VALUES ('6', '14', '720', '9', '0', null, '2018-12-01 18:42:25', null, '0');
INSERT INTO `mv_put_forward` VALUES ('7', '14', '66', '9', '0', null, '2018-12-01 18:44:44', null, '0');
INSERT INTO `mv_put_forward` VALUES ('8', '14', '100', '9', '0', null, '2018-12-01 18:44:52', null, '0');
INSERT INTO `mv_put_forward` VALUES ('9', '14', '100', '9', '0', null, '2018-12-01 18:45:01', null, '0');
INSERT INTO `mv_put_forward` VALUES ('10', '15', '100', '11', '0', null, '2018-12-01 20:44:21', null, '0');
INSERT INTO `mv_put_forward` VALUES ('11', '14', '100', '18', '0', null, '2018-12-06 15:40:34', null, '0');

-- ----------------------------
-- Table structure for `mv_setall`
-- ----------------------------
DROP TABLE IF EXISTS `mv_setall`;
CREATE TABLE `mv_setall` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TYPE` varchar(30) DEFAULT NULL COMMENT '名称',
  `VALUE` varchar(255) DEFAULT NULL COMMENT '值',
  `DESC` varchar(55) DEFAULT NULL COMMENT '中文名称',
  `CONTENT` text COMMENT '内容',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mv_setall
-- ----------------------------
INSERT INTO `mv_setall` VALUES ('1', 'yindao', null, '引导文字', '111111');
INSERT INTO `mv_setall` VALUES ('2', 'about', null, '关于我们', '<p><span style=\"color: rgb(89, 89, 89);\">&nbsp; <span style=\"color: rgb(89, 89, 89); font-size: 14px;\">&nbsp;京东致力于成为一家为社会创造最大价值的公司。经过14年砥砺前行，京东在商业领域一次又一次突破创新，取得了跨越式发展。与此同时，京东不忘初心，积极履行企业社会责任，在促进就业、提升社会效率、反哺实体经济等方面不断为社会做出贡献。\n\n &nbsp; &nbsp;</span></span></p><p><span style=\"font-size: 14px; color: rgb(89, 89, 89);\"><br/></span></p><p><span style=\"font-size: 14px; color: rgb(89, 89, 89);\">&nbsp;&nbsp;&nbsp;&nbsp;截至目前，京东集团拥有超过17万名正式员工，并间接拉动众包配送员、乡村推广员等就业人数上千万。2016年始，京东全面推进落实电商精准扶贫工作，通过品牌打造、自营直采、地方特产、众筹扶贫等模式，在832个国家级贫困县开展扶贫工作，上线贫困地区商品超过300万个，实现扶贫农产品销售额超过300亿元。依托强大的物流基础设施网络和供应链整合能力，京东大幅提升了行业运营效率，降低了社会成本。在品质电商的理念下，京东优化电商模式，精耕细作反哺实体经济，进一步助力供给侧改革。京东以社会和环境为抓手整合内外资源，与政府、媒体和公益组织协同创新，为用户、为合作伙伴、为员工、为环境、为社会创造共享价值</span></p>');
INSERT INTO `mv_setall` VALUES ('3', 'bili_one', '0.1', '一级分销比例', null);
INSERT INTO `mv_setall` VALUES ('4', 'bili_two', '0.2', '二级分销比例', null);
INSERT INTO `mv_setall` VALUES ('5', 'bili_three', '0.3', '三级分销比例', null);
INSERT INTO `mv_setall` VALUES ('6', 'tuiguang', null, '推广说明', '<p>2000年1月，李彦宏创建了百度。经过十多年的发展，百度已经发展成为全球第二大独立搜索引擎和最大的中文搜索引擎。百度的成功，也使中国成为美国、俄罗斯和韩国之外，全球仅有的4个拥有搜索引擎核心技术的国家之一。2005年，百度在美国纳斯达克成功上市，并成为首家进入纳斯达克成分股的中国公司。百度已经成为中国最具价值的品牌之一。</p><p>2013年，当选第十二届全国政协委员，兼任中国民间商会副会长，第十一届中华全国工商业联合会副主席、第八届北京市科协副主席等职务，并获聘“国家特聘专家”。</p><p><img src=\"/ueditor/php/upload/image/20181129/1543491436119223.jpg\" title=\"1543491436119223.jpg\" alt=\"t0125b4bc3b69e5de2f.jpg\"/></p>');

-- ----------------------------
-- Table structure for `mv_shop_history`
-- ----------------------------
DROP TABLE IF EXISTS `mv_shop_history`;
CREATE TABLE `mv_shop_history` (
  `ID` int(16) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `SH_ORDER` varchar(30) NOT NULL COMMENT '订单号',
  `SH_USERID` int(16) DEFAULT NULL COMMENT '用户id',
  `HPID` int(16) NOT NULL COMMENT '虎皮椒账号id',
  `SHID` int(16) DEFAULT NULL COMMENT '套餐id',
  `SH_NAME` varchar(16) DEFAULT NULL COMMENT '套餐名称',
  `SH_PRICE` decimal(8,2) DEFAULT NULL COMMENT '套餐金额',
  `SH_PAY` decimal(8,2) DEFAULT NULL COMMENT '付款金额',
  `IS_PAY` int(3) NOT NULL DEFAULT '0' COMMENT '是否支付',
  `SH_END` datetime DEFAULT NULL COMMENT '套餐到期时间',
  `GMT_CREATE` datetime DEFAULT NULL COMMENT '创建时间',
  `GMT_MODIFED` datetime DEFAULT NULL COMMENT '修改时间',
  `IS_DEL` int(4) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=76 DEFAULT CHARSET=utf8 COMMENT='购买记录表';

-- ----------------------------
-- Records of mv_shop_history
-- ----------------------------
INSERT INTO `mv_shop_history` VALUES ('4', '', '8', '0', '2', '25元包周', '25.00', '0.00', '0', '2018-11-29 12:22:11', '2018-11-22 12:22:11', null, '0');
INSERT INTO `mv_shop_history` VALUES ('3', '', '8', '0', '2', '25元包周', '25.00', '0.00', '0', '2018-11-29 11:56:58', '2018-11-22 11:56:58', null, '0');
INSERT INTO `mv_shop_history` VALUES ('5', '14-5-1543387183', '14', '1', '1', '6元包日', '6.00', '0.01', '0', '2018-11-28 14:39:43', '2018-11-28 14:39:43', null, '0');
INSERT INTO `mv_shop_history` VALUES ('6', '14-6-1543387187', '14', '1', '1', '6元包日', '6.00', '0.01', '0', '2018-11-28 14:39:47', '2018-11-28 14:39:47', null, '0');
INSERT INTO `mv_shop_history` VALUES ('7', '14-7-1543387207', '14', '1', '1', '6元包日', '6.00', '0.01', '0', '2018-11-28 14:40:07', '2018-11-28 14:40:07', null, '0');
INSERT INTO `mv_shop_history` VALUES ('8', '14-8-1543387923', '14', '1', '1', '6元包日', '6.00', '0.01', '0', '2018-11-28 14:52:03', '2018-11-28 14:52:03', null, '0');
INSERT INTO `mv_shop_history` VALUES ('9', '14-9-1543388256', '14', '1', '1', '6元包日', '6.00', '0.01', '0', '2018-11-28 14:57:36', '2018-11-28 14:57:36', null, '0');
INSERT INTO `mv_shop_history` VALUES ('10', '14-10-1543388540', '14', '1', '1', '6元包日', '6.00', '0.01', '0', '2018-11-28 15:02:20', '2018-11-28 15:02:20', null, '0');
INSERT INTO `mv_shop_history` VALUES ('11', '14-11-1543388803', '14', '1', '1', '6元包日', '6.00', '0.01', '1', '2018-11-28 15:06:43', '2018-11-28 15:06:43', null, '0');
INSERT INTO `mv_shop_history` VALUES ('12', '14-12-1543388832', '14', '1', '1', '6元包日', '6.00', '0.01', '0', '2018-11-28 15:07:12', '2018-11-28 15:07:12', null, '0');
INSERT INTO `mv_shop_history` VALUES ('13', '14-13-1543389635', '14', '1', '1', '6元包日', '6.00', '0.01', '1', '2018-11-28 15:20:35', '2018-11-28 15:20:35', null, '0');
INSERT INTO `mv_shop_history` VALUES ('14', '14-14-1543389871', '14', '1', '1', '6元包日', '6.00', '0.01', '1', '2018-11-28 15:24:31', '2018-11-28 15:24:31', null, '0');
INSERT INTO `mv_shop_history` VALUES ('15', '14-15-1543390404', '14', '1', '1', '6元包日', '6.00', '0.01', '1', '2018-11-28 15:33:24', '2018-11-28 15:33:24', null, '0');
INSERT INTO `mv_shop_history` VALUES ('16', '14-16-1543563048', '14', '1', '2', '25元包周', '25.00', '25.00', '0', '2018-11-30 15:30:48', '2018-11-30 15:30:48', null, '0');
INSERT INTO `mv_shop_history` VALUES ('17', '14-17-1543563051', '14', '1', '2', '25元包周', '25.00', '25.00', '0', '2018-11-30 15:30:51', '2018-11-30 15:30:51', null, '0');
INSERT INTO `mv_shop_history` VALUES ('18', '14-18-1543563110', '14', '1', '1', '6元包日', '6.00', '6.00', '0', '2018-11-30 15:31:50', '2018-11-30 15:31:50', null, '0');
INSERT INTO `mv_shop_history` VALUES ('19', '14-19-1543563212', '14', '1', '1', '6元包日', '6.00', '6.00', '0', '2018-11-30 15:33:32', '2018-11-30 15:33:32', null, '0');
INSERT INTO `mv_shop_history` VALUES ('20', '14-20-1543563239', '14', '1', '1', '6元包日', '6.00', '6.00', '0', '2018-11-30 15:33:59', '2018-11-30 15:33:59', null, '0');
INSERT INTO `mv_shop_history` VALUES ('21', '14-21-1543563603', '14', '1', '2', '25元包周', '25.00', '25.00', '0', '2018-11-30 15:40:03', '2018-11-30 15:40:03', null, '0');
INSERT INTO `mv_shop_history` VALUES ('22', '14-22-1543641676', '14', '1', '1', '6元包日', '6.00', '6.00', '0', '2018-12-01 13:21:16', '2018-12-01 13:21:16', null, '0');
INSERT INTO `mv_shop_history` VALUES ('23', '14-23-1543722456', '14', '1', '1', '6元包日', '6.00', '6.00', '0', '2018-12-02 11:47:36', '2018-12-02 11:47:36', null, '0');
INSERT INTO `mv_shop_history` VALUES ('24', '14-24-1544076896', '14', '1', '1', '6元包日', '6.00', '6.00', '0', '2018-12-06 14:14:56', '2018-12-06 14:14:56', null, '0');
INSERT INTO `mv_shop_history` VALUES ('25', '14-25-1544077001', '14', '1', '1', '6元包日', '6.00', '6.00', '0', '2018-12-06 14:16:41', '2018-12-06 14:16:41', null, '0');
INSERT INTO `mv_shop_history` VALUES ('26', '14-26-1544077426', '14', '1', '2', '25元包周', '25.00', '25.00', '0', '2018-12-06 14:23:46', '2018-12-06 14:23:46', null, '0');
INSERT INTO `mv_shop_history` VALUES ('27', '14-27-1544149605', '14', '1', '1', '6元包日', '6.00', '6.00', '0', '2018-12-07 10:26:45', '2018-12-07 10:26:45', null, '0');
INSERT INTO `mv_shop_history` VALUES ('28', '14-28-1544149712', '14', '1', '1', '6元包日', '6.00', '6.00', '0', '2018-12-07 10:28:32', '2018-12-07 10:28:32', null, '0');
INSERT INTO `mv_shop_history` VALUES ('29', '14-29-1544159914', '14', '1', '1', '6元包日', '6.00', '6.00', '0', '2018-12-07 13:18:34', '2018-12-07 13:18:34', null, '0');
INSERT INTO `mv_shop_history` VALUES ('30', '14-30-1544160282', '14', '1', '1', '6元包日', '6.00', '6.00', '0', '2018-12-07 13:24:42', '2018-12-07 13:24:42', null, '0');
INSERT INTO `mv_shop_history` VALUES ('31', '14-31-1544160470', '14', '1', '1', '6元包日', '6.00', '6.00', '0', '2018-12-07 13:27:50', '2018-12-07 13:27:50', null, '0');
INSERT INTO `mv_shop_history` VALUES ('32', '14-32-1544160838', '14', '1', '1', '6元包日', '6.00', '6.00', '0', '2018-12-07 13:33:58', '2018-12-07 13:33:58', null, '0');
INSERT INTO `mv_shop_history` VALUES ('33', '14-33-1544160882', '14', '1', '1', '6元包日', '6.00', '6.00', '0', '2018-12-07 13:34:42', '2018-12-07 13:34:42', null, '0');
INSERT INTO `mv_shop_history` VALUES ('34', '14-34-1544160904', '14', '1', '1', '6元包日', '6.00', '6.00', '0', '2018-12-07 13:35:04', '2018-12-07 13:35:04', null, '0');
INSERT INTO `mv_shop_history` VALUES ('35', '14-35-1544161474', '14', '1', '1', '6元包日', '6.00', '6.00', '0', '2018-12-07 13:44:34', '2018-12-07 13:44:34', null, '0');
INSERT INTO `mv_shop_history` VALUES ('36', '14-36-1544161560', '14', '1', '1', '6元包日', '6.00', '6.00', '0', '2018-12-07 13:46:00', '2018-12-07 13:46:00', null, '0');
INSERT INTO `mv_shop_history` VALUES ('37', '14-37-1544161574', '14', '1', '1', '6元包日', '6.00', '6.00', '0', '2018-12-07 13:46:14', '2018-12-07 13:46:14', null, '0');
INSERT INTO `mv_shop_history` VALUES ('38', '14-38-1544161653', '14', '1', '1', '6元包日', '6.00', '6.00', '0', '2018-12-07 13:47:33', '2018-12-07 13:47:33', null, '0');
INSERT INTO `mv_shop_history` VALUES ('39', '14-39-1544161673', '14', '1', '1', '6元包日', '6.00', '6.00', '0', '2018-12-07 13:47:53', '2018-12-07 13:47:53', null, '0');
INSERT INTO `mv_shop_history` VALUES ('40', '35-40-1544343301', '35', '1', '2', '25元包周', '25.00', '25.00', '0', '2018-12-09 16:15:01', '2018-12-09 16:15:01', null, '0');
INSERT INTO `mv_shop_history` VALUES ('41', '40-41-1544514844', '40', '1', '1', '6元包日', '6.00', '6.00', '0', '2018-12-11 15:54:04', '2018-12-11 15:54:04', null, '0');
INSERT INTO `mv_shop_history` VALUES ('42', '40-42-1544514845', '40', '1', '1', '6元包日', '6.00', '6.00', '0', '2018-12-11 15:54:05', '2018-12-11 15:54:05', null, '0');
INSERT INTO `mv_shop_history` VALUES ('43', '40-43-1544514903', '40', '1', '1', '6元包日', '6.00', '6.00', '0', '2018-12-11 15:55:03', '2018-12-11 15:55:03', null, '0');
INSERT INTO `mv_shop_history` VALUES ('45', '14-45-1544690118', '14', '1', '1', '6元包日', '0.01', '0.01', '0', '2018-12-13 16:35:18', '2018-12-13 16:35:18', null, '0');
INSERT INTO `mv_shop_history` VALUES ('58', '42-58-1545802957', '42', '1', '1', '6元包日', '0.01', '0.01', '0', '2018-12-26 13:42:37', '2018-12-26 13:42:37', null, '0');
INSERT INTO `mv_shop_history` VALUES ('57', '42-57-1545692719', '42', '1', '6', '测试套餐', '0.02', '0.02', '1', '2018-12-25 07:05:19', '2018-12-25 07:05:19', null, '0');
INSERT INTO `mv_shop_history` VALUES ('56', '41-56-1545676664', '41', '1', '1', '6元包日', '0.01', '0.01', '1', '2018-12-25 02:37:44', '2018-12-25 02:37:44', null, '0');
INSERT INTO `mv_shop_history` VALUES ('55', '41-55-1545639784', '41', '1', '1', '6元包日', '0.01', '0.01', '0', '2018-12-24 16:23:04', '2018-12-24 16:23:04', null, '0');
INSERT INTO `mv_shop_history` VALUES ('54', '41-54-1545639777', '41', '1', '1', '6元包日', '0.01', '0.01', '0', '2018-12-24 16:22:57', '2018-12-24 16:22:57', null, '0');
INSERT INTO `mv_shop_history` VALUES ('53', '41-53-1545639691', '41', '1', '1', '6元包日', '0.01', '0.01', '1', '2018-12-24 16:21:31', '2018-12-24 16:21:31', null, '0');
INSERT INTO `mv_shop_history` VALUES ('52', '15-52-1544703879', '15', '1', '1', '6元包日', '0.01', '0.01', '1', '2018-12-13 20:24:39', '2018-12-13 20:24:39', null, '0');
INSERT INTO `mv_shop_history` VALUES ('59', '44-59-1545845090', '44', '1', '1', '6元包日', '0.01', '0.01', '0', '2018-12-27 01:24:50', '2018-12-27 01:24:50', null, '0');
INSERT INTO `mv_shop_history` VALUES ('60', '44-60-1545845096', '44', '1', '1', '6元包日', '0.01', '0.01', '0', '2018-12-27 01:24:56', '2018-12-27 01:24:56', null, '0');
INSERT INTO `mv_shop_history` VALUES ('61', '44-61-1545845096', '44', '1', '1', '6元包日', '0.01', '0.01', '0', '2018-12-27 01:24:56', '2018-12-27 01:24:56', null, '0');
INSERT INTO `mv_shop_history` VALUES ('62', '44-62-1545845097', '44', '1', '1', '6元包日', '0.01', '0.01', '0', '2018-12-27 01:24:57', '2018-12-27 01:24:57', null, '0');
INSERT INTO `mv_shop_history` VALUES ('63', '44-63-1545845108', '44', '1', '1', '6元包日', '0.01', '0.01', '0', '2018-12-27 01:25:08', '2018-12-27 01:25:08', null, '0');
INSERT INTO `mv_shop_history` VALUES ('64', '44-64-1545845108', '44', '1', '1', '6元包日', '0.01', '0.01', '0', '2018-12-27 01:25:08', '2018-12-27 01:25:08', null, '0');
INSERT INTO `mv_shop_history` VALUES ('65', '44-65-1545845109', '44', '1', '1', '6元包日', '0.01', '0.01', '0', '2018-12-27 01:25:09', '2018-12-27 01:25:09', null, '0');
INSERT INTO `mv_shop_history` VALUES ('66', '44-66-1545845109', '44', '1', '1', '6元包日', '0.01', '0.01', '0', '2018-12-27 01:25:09', '2018-12-27 01:25:09', null, '0');
INSERT INTO `mv_shop_history` VALUES ('67', '44-67-1545845110', '44', '1', '1', '6元包日', '0.01', '0.01', '0', '2018-12-27 01:25:10', '2018-12-27 01:25:10', null, '0');
INSERT INTO `mv_shop_history` VALUES ('68', '41-68-1545906190', '41', '1', '8', '3年套餐', '0.01', '0.01', '0', '2018-12-27 18:23:10', '2018-12-27 18:23:10', null, '0');
INSERT INTO `mv_shop_history` VALUES ('69', '41-69-1545906282', '41', '1', '1', '6元包日', '0.01', '0.01', '1', '2018-12-27 18:24:42', '2018-12-27 18:24:42', null, '0');
INSERT INTO `mv_shop_history` VALUES ('70', '14-70-1545906678', '14', '1', '1', '6元包日', '0.01', '0.01', '0', '2018-12-27 18:31:18', '2018-12-27 18:31:18', null, '0');
INSERT INTO `mv_shop_history` VALUES ('71', '45-71-1546059168', '45', '1', '8', '3年套餐', '0.01', '0.01', '0', '2018-12-29 12:52:48', '2018-12-29 12:52:48', null, '0');
INSERT INTO `mv_shop_history` VALUES ('72', '45-72-1546059189', '45', '1', '8', '3年套餐', '0.01', '0.01', '0', '2018-12-29 12:53:09', '2018-12-29 12:53:09', null, '0');
INSERT INTO `mv_shop_history` VALUES ('73', '45-73-1546059195', '45', '1', '7', '包年套餐', '0.03', '0.03', '0', '2018-12-29 12:53:15', '2018-12-29 12:53:15', null, '0');
INSERT INTO `mv_shop_history` VALUES ('74', '45-74-1546059200', '45', '1', '4', '148元季度', '148.00', '148.00', '0', '2018-12-29 12:53:20', '2018-12-29 12:53:20', null, '0');
INSERT INTO `mv_shop_history` VALUES ('75', '41-75-1546426114', '41', '1', '1', '6元包日', '0.01', '0.01', '0', '2019-01-02 18:48:34', '2019-01-02 18:48:34', null, '0');

-- ----------------------------
-- Table structure for `mv_user`
-- ----------------------------
DROP TABLE IF EXISTS `mv_user`;
CREATE TABLE `mv_user` (
  `ID` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `USERNAME` varchar(16) DEFAULT NULL COMMENT '用户名',
  `TELNO` int(16) DEFAULT NULL COMMENT '电话',
  `USERIMG` text COMMENT '用户头像',
  `EXTENSION_CODE` varchar(32) DEFAULT NULL COMMENT '推广码',
  `PARENT_CODE` varchar(32) DEFAULT NULL COMMENT '所属上级推广码',
  `FACTION` varchar(32) DEFAULT NULL COMMENT '下级分销比例',
  `SECURITY_QUESTION` text COMMENT '密保问题',
  `TRUENAME` varchar(16) NOT NULL COMMENT '真实姓名',
  `LOGIN_PSWD` varchar(32) DEFAULT NULL COMMENT '登录密码',
  `PAY_PSWD` varchar(32) DEFAULT NULL COMMENT '交易密码',
  `NO_PRICE` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '未体现金额',
  `IS_PRICE` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '已提现金额',
  `GMT_CREATE` datetime DEFAULT NULL COMMENT '创建时间',
  `GMT_MODIFIED` datetime DEFAULT NULL COMMENT '修改时间',
  `USER_TYPE` int(3) DEFAULT '0' COMMENT '0:自己注册，1：后台添加',
  `USER_STATUS` int(11) unsigned zerofill DEFAULT '00000000000' COMMENT '是不是总代理   0：不是  1：是',
  `TOKEN` varchar(32) DEFAULT NULL COMMENT '登录token',
  `IS_DEL` int(4) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of mv_user
-- ----------------------------
INSERT INTO `mv_user` VALUES ('10', '4', null, null, 'ID10XWLKUQ', '', '0.1,0.2', '{\"1\":{\"question\":\"1\",\"answer\":\"2\"},\"2\":{\"question\":\"2\",\"answer\":\"1\"},\"3\":{\"question\":\"3\",\"answer\":\"1\"}}', '', 'e10adc3949ba59abbe56e057f20f883e', null, '0.00', '0.00', '2018-11-22 18:50:10', '2018-11-28 10:32:49', '1', null, null, '1');
INSERT INTO `mv_user` VALUES ('14', 'ge1', null, '/Public/upload/2018-12-06/2018_12_06_20_53_12_88197.png', 'ID14WLABXC', null, null, '{\"1\":{\"question\":\"\\u4f60\\u7684\\u51fa\\u751f\\u5730\\u662f\\u54ea\\u91cc\\uff1f\",\"answer\":\"\\u6cb3\\u5357\"},\"2\":{\"question\":\"\\u4f60\\u7684\\u5c0f\\u5b66\\u540d\\u5b57\\u662f\\u4ec0\\u4e48\\uff1f\",\"answer\":\"\\u674e\\u5e84\\u5c0f\\u5b66\"},\"3\":{\"question\":\"\\u4f60\\u6700\\u597d\\u7684\\u670b\\u53cb\\u59d3\\u4ec0\\u4e48\",\"answer\":\"\\u845b\"}}', '', 'e10adc3949ba59abbe56e057f20f883e', 'e10adc3949ba59abbe56e057f20f883e', '8600.00', '1400.00', '2018-11-28 10:27:13', null, '0', null, '723ff95c9be05e4c9b7295faa1c27243', '0');
INSERT INTO `mv_user` VALUES ('15', 'admin', null, '/Public/upload/2018-12-01/2018_12_01_11_46_34_86865.png', 'ID15PSNDZM', '', '', '{\"1\":{\"question\":\"1\",\"answer\":\"1\"},\"2\":{\"question\":\"2\",\"answer\":\"2\"},\"3\":{\"question\":\"3\",\"answer\":\"3\"}}', '', 'e10adc3949ba59abbe56e057f20f883e', 'e10adc3949ba59abbe56e057f20f883e', '900.00', '100.00', '2018-11-28 21:13:14', '2018-12-25 14:51:49', '0', '00000000001', '6c661b6a0c717a065427c8a64d5f5ba3', '0');
INSERT INTO `mv_user` VALUES ('16', 'han', null, '/Public/admin/images/head/11.png', 'ID16RCWBKW', 'ID15PSNDZM', null, '{\"1\":{\"question\":\"1\",\"answer\":\"1\"},\"2\":{\"question\":\"2\",\"answer\":\"2\"},\"3\":{\"question\":\"3\",\"answer\":\"3\"}}', '', 'e10adc3949ba59abbe56e057f20f883e', null, '0.00', '0.00', '2018-12-03 16:58:15', null, '0', null, 'a466f11f1c385411eaee56b8003aee6e', '0');
INSERT INTO `mv_user` VALUES ('42', 'sunnyboy8888', null, '/Public/admin/images/head/5.png', 'ID42ROJZDT', 'ID15PSNDZM', '', '{\"1\":{\"question\":\"1\",\"answer\":\"1\"},\"2\":{\"question\":\"1\",\"answer\":\"1\"},\"3\":{\"question\":\"1\",\"answer\":\"1\"}}', '', 'e10adc3949ba59abbe56e057f20f883e', null, '0.00', '0.00', '2018-12-25 06:47:52', null, '1', null, '982c904b81008f7df25d4ba32ee957fb', '0');
INSERT INTO `mv_user` VALUES ('43', 'zzcn77', null, '/Public/admin/images/head/12.png', 'ID43QYYRUS', 'ID15PSNDZM', null, '{\"1\":{\"question\":\"11\",\"answer\":\"111\"},\"2\":{\"question\":\"111\",\"answer\":\"111\"},\"3\":{\"question\":\"111\",\"answer\":\"111\"}}', '', 'e10adc3949ba59abbe56e057f20f883e', null, '0.00', '0.00', '2018-12-26 13:34:59', null, '0', null, '5500a8e2f94dcd80c090ef05b0895594', '0');
INSERT INTO `mv_user` VALUES ('41', 'sunny', null, '/Public/admin/images/head/3.png', 'ID41ZVITTA', 'ID15PSNDZM', null, '{\"1\":{\"question\":\"\\u4f60\\u597d\",\"answer\":\"\\u4f60\\u597d\"},\"2\":{\"question\":\"\\u4f60\\u597d\",\"answer\":\"\\u4f60\\u597d\"},\"3\":{\"question\":\"\\u4f60\\u597d\",\"answer\":\"\\u4f60\\u597d\"}}', '', 'e10adc3949ba59abbe56e057f20f883e', null, '0.00', '0.00', '2018-12-21 21:00:53', null, '0', null, '06092da776c3dfc817e74e6a027b6171', '0');
INSERT INTO `mv_user` VALUES ('40', '123123123', null, '/Public/admin/images/head/7.png', 'ID40JNPNGL', null, null, '{\"1\":{\"question\":null,\"answer\":null},\"2\":{\"question\":null,\"answer\":null},\"3\":{\"question\":null,\"answer\":null}}', '', 'e10adc3949ba59abbe56e057f20f883e', null, '0.00', '0.00', '2018-12-11 15:04:38', null, '0', null, '6928729e67e59cf2c098a16848c05a89', '0');
INSERT INTO `mv_user` VALUES ('38', '255', null, '/Public/admin/images/head/6.png', 'ID38GZPXKB', 'ID15PSNDZM', null, null, '', 'e10adc3949ba59abbe56e057f20f883e', null, '0.00', '0.00', '2018-12-09 16:31:25', null, '0', null, '03fd72431ff77f632fd58114795afb27', '0');
INSERT INTO `mv_user` VALUES ('39', 'ege123', null, '/Public/admin/images/head/12.png', 'ID39SMLEBP', null, null, null, '', 'e10adc3949ba59abbe56e057f20f883e', null, '0.00', '0.00', '2018-12-09 16:56:03', null, '0', null, '863fed7fd43cfabbd06d29f96ed48cfe', '0');
INSERT INTO `mv_user` VALUES ('37', 'gets', null, '/Public/admin/images/head/5.png', 'ID37RFXHFZ', 'ID15PSNDZM', null, '{\"1\":{\"question\":\"1\",\"answer\":\"1\"},\"2\":{\"question\":\"1\",\"answer\":\"1\"},\"3\":{\"question\":\"1\",\"answer\":\"1\"}}', '', 'e10adc3949ba59abbe56e057f20f883e', null, '0.00', '0.00', '2018-12-09 16:29:09', null, '0', null, '64e4d9199c634c337fdc06da32e34302', '0');
INSERT INTO `mv_user` VALUES ('36', 'gee', null, '/Public/admin/images/head/8.png', 'ID36ZLVUHE', 'ID15PSNDZM', null, '{\"1\":{\"question\":\"1\",\"answer\":\"1\"},\"2\":{\"question\":\"1\",\"answer\":\"1\"},\"3\":{\"question\":\"1\",\"answer\":\"1\"}}', '', 'e10adc3949ba59abbe56e057f20f883e', null, '0.00', '0.00', '2018-12-09 16:24:38', null, '0', null, '3037a767918518059bacd4ce8a84dfe4', '0');
INSERT INTO `mv_user` VALUES ('44', 'sunnh', null, '/Public/admin/images/head/2.png', 'ID44RREOFM', 'ID15PSNDZM', null, '{\"1\":{\"question\":\"1\\u53f7\\u95ee\\u9898\",\"answer\":\"1\\u53f7\\u7b54\\u6848\"},\"2\":{\"question\":\"2\\u53f7\\u95ee\\u9898\",\"answer\":\"2\\u53f7\\u7b54\\u6848\"},\"3\":{\"question\":\"3\\u53f7\\u95ee\\u9898\",\"answer\":\"3\\u53f7\\u7b54\\u6848\"}}', '', 'e10adc3949ba59abbe56e057f20f883e', null, '0.00', '0.00', '2018-12-27 01:04:10', null, '0', null, '60cf88b31276bfcf7eda5caf71191588', '0');
INSERT INTO `mv_user` VALUES ('45', 'ts18069791015', null, '/Public/admin/images/head/12.png', 'ID45QFJTRX', 'ID15PSNDZM', null, '{\"1\":{\"question\":\"\\u6211\\u662f\\u4f60\\u7238\\u7238\",\"answer\":\"\\u4e0d\\u662f\"},\"2\":{\"question\":\"\\u6211\\u662f\\u4f60\\u7237\\u7237\",\"answer\":\"\\u4e0d\\u662f\"},\"3\":{\"question\":\"\\u6211\\u662f\\u4f60\\u7956\\u5b97\",\"answer\":\"\\u4f60\\u731c\"}}', '', 'e10adc3949ba59abbe56e057f20f883e', null, '0.00', '0.00', '2018-12-29 12:51:56', null, '0', null, 'fdc7c4d704dbda86fb9a35c7941e73b0', '0');

-- ----------------------------
-- Table structure for `mv_user_profit`
-- ----------------------------
DROP TABLE IF EXISTS `mv_user_profit`;
CREATE TABLE `mv_user_profit` (
  `ID` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `UP_USERID` int(16) DEFAULT NULL COMMENT '充值用户id',
  `UP_RUN_USERID` int(16) DEFAULT NULL COMMENT '获得分润用户id',
  `UP_PRICE` decimal(8,2) DEFAULT NULL COMMENT '分润金额',
  `GMT_CREATE` datetime DEFAULT NULL COMMENT '充值时间',
  `GMT_MODIFED` datetime DEFAULT NULL COMMENT '修改时间',
  `IS_DEL` int(4) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='分润表';

-- ----------------------------
-- Records of mv_user_profit
-- ----------------------------
INSERT INTO `mv_user_profit` VALUES ('1', '15', '14', '1.00', '2018-11-08 00:00:00', null, '0');
INSERT INTO `mv_user_profit` VALUES ('2', '15', '14', '1.00', '2018-11-01 00:00:00', null, '0');
INSERT INTO `mv_user_profit` VALUES ('3', '15', '14', '0.50', '2018-11-01 00:00:00', null, '0');
INSERT INTO `mv_user_profit` VALUES ('4', '15', '14', '1.20', '2018-11-09 00:00:00', null, '0');
