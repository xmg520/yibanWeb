/*
Navicat MySQL Data Transfer

Source Server         : aliyun5.7
Source Server Version : 50728
Source Host           : 118.31.22.202:9527
Source Database       : yiban

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2020-05-05 17:11:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(11) NOT NULL,
  `account` varchar(255) DEFAULT '',
  `passwd` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `isupload` int(11) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('2', '201765110002', '123456', '刘文星', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('3', '201765110005', '123456', '王雨臣', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('4', '201765110012', '123456', '荣浩华', '湖南省', '00000000001');
INSERT INTO `member` VALUES ('5', '201765110029', '123456', '王斯异', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('6', '201765110033', '123456', '陈思', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('8', '201765110043', '123456', '荆扬', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('9', '201765110052', '123456', '王艳', '湖南省', '00000000001');
INSERT INTO `member` VALUES ('10', '201765110055', '123456', '张丙林', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('11', '201765110066', '123456', '何梦', '湖南省', '00000000001');
INSERT INTO `member` VALUES ('12', '201765110075', '123456', '李新', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('13', '201765110081', '123456', '钱凯婷', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('14', '201765110093', '123456', '万亚欣', '湖南省', '00000000001');
INSERT INTO `member` VALUES ('15', '201765110095', '123456', '孙慧博', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('16', '201765110096', '123456', '谭志豪', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('17', '201765110097', '123456', '刘奕宏', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('19', '201765110099', '123456', '罗艺', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('20', '201765110100', '123456', '刘志勇', '湖南省', '00000000001');
INSERT INTO `member` VALUES ('21', '201765110101', '123456', '彭嘉洛', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('22', '201765110102', '123456', '刘树鑫', '广东省', '00000000000');
INSERT INTO `member` VALUES ('23', '201765110103', '123456', '刘安杰', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('24', '201765110104', '123456', '谢俊', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('25', '201765110105', '123456', '刘斌', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('26', '201765110106', '123456', '廖卓', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('27', '201765110107', '123456', '周小艳', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('28', '201765110108', '123456', '周康', '湖南省', '00000000001');
INSERT INTO `member` VALUES ('29', '201765110109', '123456', '蔡雨轩', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('30', '201765110110', '123456', '黄旭芳', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('31', '201765110111', '123456', '李东波', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('32', '201765110113', '123456', '陈琳', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('33', '201765110114', '123456', '李谟利', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('34', '201765110115', '123456', '刘彪', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('35', '201765110116', '123456', '许少明', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('36', '201765110117', '123456', '马章轩', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('37', '201765110118', '123456', '丁士钧', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('38', '201765110119', '123456', '舒洁', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('39', '201765550188', '123456', '金广然', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('40', '201765110397', '123456', '刘志豪', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('41', '201765110186', '123456', '陈鹏', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('42', '201765110098', '123456', '冯志', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('43', '201765110039', '123456', '汤蓉', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('44', '201665110153', '123456', '周虎成', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('45', '201575550026', '123456', '伍威霖', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('46', '201765110137', '123456', '申庆华', '湖南省', '00000000000');
INSERT INTO `member` VALUES ('47', '201765110445', '123456', '罗昊阳', '湖南省', '00000000000');

-- ----------------------------
-- Table structure for noupload
-- ----------------------------
DROP TABLE IF EXISTS `noupload`;
CREATE TABLE `noupload` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time` varchar(50) DEFAULT NULL,
  `names` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of noupload
-- ----------------------------
INSERT INTO `noupload` VALUES ('1', '04-21', '刘德华,张学友,黎明,郭富城');
INSERT INTO `noupload` VALUES ('2', '04-22', '刘文星,张丙林,李新,谭志豪,彭嘉洛,刘树鑫,谢俊,刘斌,李谟利,刘彪,丁士钧,舒洁,陈鹏,周虎成,伍威霖');
INSERT INTO `noupload` VALUES ('3', '04-23', '王斯异,谭志豪,彭嘉洛,刘斌,李谟利,舒洁,陈鹏');
INSERT INTO `noupload` VALUES ('4', '04-24', '张丙林,孙慧博,谭志豪,刘斌,廖卓,李谟利,舒洁,陈鹏');
INSERT INTO `noupload` VALUES ('5', '04-25', '刘文星,张丙林,谭志豪,刘树鑫,刘斌,廖卓,李谟利,舒洁,陈鹏');
INSERT INTO `noupload` VALUES ('6', '04-26', '刘文星,荣浩华,张丙林,万亚欣,谭志豪,刘斌,李谟利,舒洁,陈鹏');
INSERT INTO `noupload` VALUES ('7', '04-27', '刘文星,谭志豪,刘树鑫,刘斌,李谟利,舒洁,陈鹏,伍威霖');
INSERT INTO `noupload` VALUES ('8', '04-28', '刘文星,荣浩华,钱凯婷,孙慧博,谭志豪,罗艺,刘树鑫,刘斌,李谟利,舒洁,陈鹏,伍威霖');
INSERT INTO `noupload` VALUES ('9', '04-29', '刘文星,王艳,谭志豪,刘斌,周康,李谟利,舒洁,陈鹏');
INSERT INTO `noupload` VALUES ('10', '04-30', '刘文星,荣浩华,陈思,谭志豪,罗艺,刘志勇,刘斌,蔡雨轩,李东波,李谟利,丁士钧,舒洁,伍威霖');
INSERT INTO `noupload` VALUES ('11', '05-01', '刘文星,王雨臣,荣浩华,王斯异,陈思,荆扬,王艳,何梦,李新,钱凯婷,孙慧博,谭志豪,刘奕宏,罗艺,刘志勇,刘树鑫,刘安杰,谢俊,刘斌,廖卓,周小艳,周康,蔡雨轩,黄旭芳,李东波,陈琳,李谟利,许少明,丁士钧,舒洁,刘志豪,陈鹏,伍威霖');
INSERT INTO `noupload` VALUES ('12', '05-02', '刘文星,荣浩华,荆扬,王艳,何梦,李新,孙慧博,谭志豪,刘志勇,谢俊,刘斌,廖卓,周康,李谟利,舒洁,刘志豪,伍威霖');
INSERT INTO `noupload` VALUES ('13', '05-03', '刘文星,王斯异,王艳,何梦,谭志豪,刘奕宏,刘志勇,刘树鑫,刘斌,廖卓,李东波,李谟利,舒洁,陈鹏,伍威霖');
INSERT INTO `noupload` VALUES ('14', '05-04', '刘文星,荣浩华,王斯异,王艳,何梦,谭志豪,刘志勇,刘树鑫,刘斌,廖卓,周康,蔡雨轩,李谟利,舒洁,刘志豪,伍威霖,申庆华');
INSERT INTO `noupload` VALUES ('15', '05-05', '刘文星,李新,万亚欣,孙慧博,谭志豪,刘志勇,彭嘉洛,刘树鑫,刘斌,廖卓,周康,李谟利,舒洁,刘志豪,陈鹏,冯志,汤蓉,伍威霖,申庆华');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `perms` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'root', 'root123', 'user:root;user:member');
INSERT INTO `user` VALUES ('2', 'ma', 'ma', 'user:member');
