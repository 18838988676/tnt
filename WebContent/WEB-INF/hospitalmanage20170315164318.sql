/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 6.0.10-alpha-community : Database - tnt
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tnt` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `tnt`;

/*Table structure for table `attribute` */

DROP TABLE IF EXISTS `attribute`;

CREATE TABLE `attribute` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `attributename` varchar(32) DEFAULT NULL COMMENT '集合名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='属性';

/*Data for the table `attribute` */

insert  into `attribute`(`id`,`attributename`) values (1,'学历'),(2,'政治面貌'),(3,'婚姻状况'),(4,'职务'),(5,'职称'),(6,'药品类型'),(7,'药品剂型'),(8,'医保类别'),(9,'银行'),(10,'学习专业'),(11,'使用状态'),(12,'费用类别'),(13,'项目类型'),(14,'处方性质'),(15,'处方类型'),(16,'处方分类'),(17,'供应商级别'),(18,'床位级别'),(19,'收费方式'),(20,'化验仪器'),(21,'参保类型'),(22,'结算方式'),(23,'模板类型'),(24,'用药方式'),(25,'用药频率');

/*Table structure for table `attributedetail` */

DROP TABLE IF EXISTS `attributedetail`;

CREATE TABLE `attributedetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `attributeid` int(11) DEFAULT NULL COMMENT '属性id',
  `detailname` varchar(32) DEFAULT NULL COMMENT '明细名称',
  `detailenname` varchar(32) DEFAULT NULL COMMENT '明细英文名称',
  `note` varchar(64) DEFAULT NULL COMMENT '备注',
  `isvalid` int(11) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=486 DEFAULT CHARSET=utf8 COMMENT='属性明细';

/*Data for the table `attributedetail` */

insert  into `attributedetail`(`id`,`attributeid`,`detailname`,`detailenname`,`note`,`isvalid`) values (1,1,'博士',NULL,NULL,1),(2,1,'研究生',NULL,NULL,1),(3,1,'本科',NULL,NULL,1),(4,1,'专科',NULL,NULL,1),(5,1,'高中及以下',NULL,NULL,1),(6,2,'中共党员',NULL,NULL,1),(7,2,'中共预备党员',NULL,NULL,1),(8,2,'共青团员',NULL,NULL,1),(9,2,'民革党员',NULL,NULL,1),(10,2,'民盟盟员',NULL,NULL,1),(11,2,'民建会员',NULL,NULL,1),(12,2,'民进会员',NULL,NULL,1),(13,2,'农工党党员',NULL,NULL,1),(14,2,'致公党党员',NULL,NULL,1),(15,2,'九三学社社员',NULL,NULL,1),(16,2,'台盟盟员',NULL,NULL,1),(17,2,'群众',NULL,NULL,1),(18,3,'未婚',NULL,NULL,1),(19,3,'已婚',NULL,NULL,1),(20,3,'离异',NULL,NULL,1),(21,3,'丧偶',NULL,NULL,1),(22,4,'院长',NULL,NULL,1),(23,4,'常务副院长',NULL,NULL,1),(24,4,'分管业务副院长',NULL,NULL,1),(25,4,'分管行政副院长',NULL,NULL,1),(26,4,'分管财务副院长',NULL,NULL,1),(27,4,'分管药剂副院长',NULL,NULL,1),(28,4,'总会计师',NULL,NULL,1),(29,4,'公会主席',NULL,NULL,1),(30,4,'党委书记',NULL,NULL,1),(31,4,'纪委书记',NULL,NULL,1),(32,4,'党支部书记',NULL,NULL,1),(33,4,'团委书记',NULL,NULL,1),(34,4,'临床科主任',NULL,NULL,1),(35,4,'临床科三级医师',NULL,NULL,1),(36,4,'临床科二级医师',NULL,NULL,1),(37,4,'临床科一级II档医师',NULL,NULL,1),(38,4,'临床科一级I档医师',NULL,NULL,1),(39,4,'临床科进修医师',NULL,NULL,1),(40,4,'临床科见习医师',NULL,NULL,1),(41,4,'临床科总住院医师',NULL,NULL,1),(42,4,'临床科住院医师',NULL,NULL,1),(43,4,'门诊部主任',NULL,NULL,1),(44,4,'专家门诊医师',NULL,NULL,1),(45,4,'专科门诊医师',NULL,NULL,1),(46,4,'普通门诊II档医师',NULL,NULL,1),(47,4,'普通门诊I档医师',NULL,NULL,1),(48,4,'急诊科主任',NULL,NULL,1),(49,4,'急诊科医师',NULL,NULL,1),(50,4,'产科主任',NULL,NULL,1),(51,4,'产科医师',NULL,NULL,1),(52,4,'手术部主任',NULL,NULL,1),(53,4,'手术部三级医师',NULL,NULL,1),(54,4,'手术部二级医师',NULL,NULL,1),(55,4,'手术部一级医师',NULL,NULL,1),(56,4,'手术部总住院医师',NULL,NULL,1),(57,4,'手术部住院医师',NULL,NULL,1),(58,4,'妇幼保健主任',NULL,NULL,1),(59,4,'妇幼保健三级医师',NULL,NULL,1),(60,4,'妇幼保健二级医师',NULL,NULL,1),(61,4,'妇幼保健一级医师',NULL,NULL,1),(62,4,'前台服务中心主任',NULL,NULL,1),(63,4,'前台服务中心职员',NULL,NULL,1),(64,4,'前台导诊护士',NULL,NULL,1),(65,4,'临床护士长',NULL,NULL,1),(66,4,'临床三级护士',NULL,NULL,1),(67,4,'临床二级护士',NULL,NULL,1),(68,4,'临床一级护士',NULL,NULL,1),(69,4,'临床助理护士',NULL,NULL,1),(70,4,'临床见习护士',NULL,NULL,1),(71,4,'手术部护士长',NULL,NULL,1),(72,4,'手术部二级护士',NULL,NULL,1),(73,4,'手术部一级护士',NULL,NULL,1),(74,4,'手术部助理护士',NULL,NULL,1),(75,4,'手术部见习护士',NULL,NULL,1),(76,4,'消毒供应室主任',NULL,NULL,1),(77,4,'消毒供应室护士长',NULL,NULL,1),(78,4,'消毒供应室护士',NULL,NULL,1),(79,4,'产科护士长',NULL,NULL,1),(80,4,'助产士',NULL,NULL,1),(81,4,'门诊护士长',NULL,NULL,1),(82,4,'门诊二级护士',NULL,NULL,1),(83,4,'门诊一级护士',NULL,NULL,1),(84,4,'门诊见习护士',NULL,NULL,1),(85,4,'急诊护士长',NULL,NULL,1),(86,4,'急诊二级护士',NULL,NULL,1),(87,4,'急诊一级护士',NULL,NULL,1),(88,4,'急诊助理护士',NULL,NULL,1),(89,4,'急诊一级护士',NULL,NULL,1),(90,4,'妇幼保健护士长',NULL,NULL,1),(91,4,'妇幼保健二级护士',NULL,NULL,1),(92,4,'妇幼保健一级护士',NULL,NULL,1),(93,4,'功能科主任',NULL,NULL,1),(94,4,'功能科三级医（技）师',NULL,NULL,1),(95,4,'功能科二级医（技）师',NULL,NULL,1),(96,4,'功能科一级医（技）师',NULL,NULL,1),(97,4,'放射科主任',NULL,NULL,1),(98,4,'放射科三级医师',NULL,NULL,1),(99,4,'放射科二级医师',NULL,NULL,1),(100,4,'放射科一级医师',NULL,NULL,1),(101,4,'放射科三级技师',NULL,NULL,1),(102,4,'放射科二级技师',NULL,NULL,1),(103,4,'放射科一级技师',NULL,NULL,1),(104,4,'放射科工程技术人员',NULL,NULL,1),(105,4,'检验科主任',NULL,NULL,1),(106,4,'三级检验技师',NULL,NULL,1),(107,4,'二级检验技师',NULL,NULL,1),(108,4,'一级检验技师',NULL,NULL,1),(109,4,'病理科主任',NULL,NULL,1),(110,4,'病理科三级医（技）师',NULL,NULL,1),(111,4,'病理科二级医（技）师',NULL,NULL,1),(112,4,'病理科一级医（技）师',NULL,NULL,1),(113,4,'高压氧科主任',NULL,NULL,1),(114,4,'高压氧科护士',NULL,NULL,1),(115,4,'高压氧科技术人员',NULL,NULL,1),(116,4,'药剂科主任',NULL,NULL,1),(117,4,'三级药师',NULL,NULL,1),(118,4,'二级药师',NULL,NULL,1),(119,4,'一级药师',NULL,NULL,1),(120,4,'见习药师',NULL,NULL,1),(121,4,'院长办公室主任',NULL,NULL,1),(122,4,'院长办公室职员',NULL,NULL,1),(123,4,'综合档案室主任',NULL,NULL,1),(124,4,'专职档案员',NULL,NULL,1),(125,4,'兼职档案员',NULL,NULL,1),(126,4,'机要打字员',NULL,NULL,1),(127,4,'车队队长',NULL,NULL,1),(128,4,'汽车司机',NULL,NULL,1),(129,4,'党委办公室主任',NULL,NULL,1),(130,4,'党委办公室职员',NULL,NULL,1),(131,4,'人力资源部主任',NULL,NULL,1),(132,4,'人力资源部职员',NULL,NULL,1),(133,4,'保卫科主管',NULL,NULL,1),(134,4,'保卫科职员',NULL,NULL,1),(135,4,'保安员',NULL,NULL,1),(136,4,'财务部主任',NULL,NULL,1),(137,4,'责任会计',NULL,NULL,1),(138,4,'总账报表会计',NULL,NULL,1),(139,4,'成本核算会计',NULL,NULL,1),(140,4,'往来核算会计',NULL,NULL,1),(141,4,'财务成果核算会计',NULL,NULL,1),(142,4,'基建会计',NULL,NULL,1),(143,4,'财产会计',NULL,NULL,1),(144,4,'药品会计',NULL,NULL,1),(145,4,'材料、低值易耗品核算会计',NULL,NULL,1),(146,4,'工资核算会计',NULL,NULL,1),(147,4,'稽核会计',NULL,NULL,1),(148,4,'物业管理会计',NULL,NULL,1),(149,4,'医院出纳',NULL,NULL,1),(150,4,'资金核算会计',NULL,NULL,1),(151,4,'票据管理员',NULL,NULL,1),(152,4,'医疗保险财会管理',NULL,NULL,1),(153,4,'门诊收费员',NULL,NULL,1),(154,4,'门诊挂号员',NULL,NULL,1),(155,4,'住院收费员',NULL,NULL,1),(156,4,'物价管理员',NULL,NULL,1),(157,4,'科室经济管理员',NULL,NULL,1),(158,4,'医教部主任',NULL,NULL,1),(159,4,'医务科科长',NULL,NULL,1),(160,4,'质控科科长',NULL,NULL,1),(161,4,'科教科科长',NULL,NULL,1),(162,4,'院感科科长',NULL,NULL,1),(163,4,'投诉管理科科长',NULL,NULL,1),(164,4,'医保主办',NULL,NULL,1),(165,4,'医务科职员',NULL,NULL,1),(166,4,'质控科职员',NULL,NULL,1),(167,4,'科教科职员',NULL,NULL,1),(168,4,'院感科职员',NULL,NULL,1),(169,4,'质量管理部主任',NULL,NULL,1),(170,4,'质量管理部职员',NULL,NULL,1),(171,4,'护理部主任',NULL,NULL,1),(172,4,'护理部干事',NULL,NULL,1),(173,4,'保健部主任',NULL,NULL,1),(174,4,'计算机网络部主任',NULL,NULL,1),(175,4,'计算机网络部职员',NULL,NULL,1),(176,4,'药学部主任',NULL,NULL,1),(177,4,'药学部职员',NULL,NULL,1),(178,4,'设备科主任',NULL,NULL,1),(179,4,'设备科职员',NULL,NULL,1),(180,4,'医疗设备主管',NULL,NULL,1),(181,4,'医疗设备仓库保管员',NULL,NULL,1),(182,4,'医疗设备采购员',NULL,NULL,1),(183,4,'医疗设备维修人员',NULL,NULL,1),(184,4,'医疗设备管理责任人',NULL,NULL,1),(185,4,'后勤保障部主任',NULL,NULL,1),(186,4,'后勤保障部职员',NULL,NULL,1),(187,4,'基建办主任',NULL,NULL,1),(188,4,'基建办职员',NULL,NULL,1),(189,4,'物资仓库主管',NULL,NULL,1),(190,4,'物资仓库职员',NULL,NULL,1),(191,4,'物资采购员',NULL,NULL,1),(192,4,'食堂主管',NULL,NULL,1),(193,4,'病员食堂职工',NULL,NULL,1),(194,4,'职工食堂职工',NULL,NULL,1),(195,4,'食堂厨师',NULL,NULL,1),(196,4,'配餐员',NULL,NULL,1),(197,4,'营养室主管',NULL,NULL,1),(198,4,'营养室职工',NULL,NULL,1),(199,4,'供开水、热水职工',NULL,NULL,1),(200,4,'水、电、气、木工班主管',NULL,NULL,1),(201,4,'水、电、气、木工人',NULL,NULL,1),(202,4,'被服供应主管',NULL,NULL,1),(203,4,'被服供应职工',NULL,NULL,1),(204,4,'电梯主管',NULL,NULL,1),(205,4,'电梯工人',NULL,NULL,1),(206,4,'锅炉主管',NULL,NULL,1),(207,4,'锅炉工人',NULL,NULL,1),(208,4,'太平间工人',NULL,NULL,1),(209,4,'清洁工',NULL,NULL,1),(210,4,'信息统计科科长',NULL,NULL,1),(211,4,'市级妇幼卫生信息员',NULL,NULL,1),(212,4,'统计员',NULL,NULL,1),(213,4,'图书管理员',NULL,NULL,1),(214,4,'病案室主办',NULL,NULL,1),(215,4,'病案室职员',NULL,NULL,1),(216,4,'健康教育科主任',NULL,NULL,1),(217,4,'健康教育科职员',NULL,NULL,1),(218,5,'主任医师',NULL,NULL,1),(219,5,'主任药师',NULL,NULL,1),(220,5,'主任护师',NULL,NULL,1),(221,5,'主任技师',NULL,NULL,1),(222,5,'副主任医师',NULL,NULL,1),(223,5,'副主任药师',NULL,NULL,1),(224,5,'副主任护师',NULL,NULL,1),(225,5,'副主任技师',NULL,NULL,1),(226,5,'主治医师',NULL,NULL,1),(227,5,'主管药师',NULL,NULL,1),(228,5,'主管护师',NULL,NULL,1),(229,5,'主管技师',NULL,NULL,1),(230,5,'医师',NULL,NULL,1),(231,5,'药师',NULL,NULL,1),(232,5,'护师',NULL,NULL,1),(233,5,'技师',NULL,NULL,1),(234,5,'医士',NULL,NULL,1),(235,5,'药士',NULL,NULL,1),(236,5,'护士',NULL,NULL,1),(237,5,'技士',NULL,NULL,1),(238,6,'中药',NULL,NULL,1),(239,6,'西药',NULL,NULL,1),(240,6,'中成药',NULL,NULL,1),(241,7,'散剂',NULL,NULL,1),(242,7,'片剂',NULL,NULL,1),(243,7,'颗粒剂',NULL,NULL,1),(244,7,'胶囊剂',NULL,NULL,1),(245,7,'丸剂',NULL,NULL,1),(246,7,'溶液剂',NULL,NULL,1),(247,7,'浸出剂',NULL,NULL,1),(248,7,'乳剂',NULL,NULL,1),(249,7,'混悬剂',NULL,NULL,1),(250,7,'注射剂',NULL,NULL,1),(251,7,'喷雾剂',NULL,NULL,1),(252,7,'气雾剂',NULL,NULL,1),(253,7,'粉雾剂',NULL,NULL,1),(254,7,'洗剂',NULL,NULL,1),(255,7,'搽剂',NULL,NULL,1),(256,7,'软膏剂',NULL,NULL,1),(257,7,'硬膏剂',NULL,NULL,1),(258,8,'职工医保',NULL,NULL,1),(259,8,'城居医保',NULL,NULL,1),(260,8,'新农合',NULL,NULL,1),(261,9,'中国银行',NULL,NULL,1),(262,9,'中国工商银行',NULL,NULL,1),(263,9,'中国农业银行',NULL,NULL,1),(264,9,'中国建设银行',NULL,NULL,1),(265,9,'交通银行',NULL,NULL,1),(266,9,'中信银行',NULL,NULL,1),(267,9,'中国光大银行',NULL,NULL,1),(268,9,'华夏银行',NULL,NULL,1),(269,9,'中国民生银行',NULL,NULL,1),(270,9,'广发银行',NULL,NULL,1),(271,9,'深圳发展银行',NULL,NULL,1),(272,9,'招商银行',NULL,NULL,1),(273,9,'兴业银行',NULL,NULL,1),(274,9,'上海浦东发展银行',NULL,NULL,1),(275,9,'恒丰银行',NULL,NULL,1),(276,9,'浙商银行',NULL,NULL,1),(277,9,'渤海银行',NULL,NULL,1),(278,9,'中国邮政储蓄银行',NULL,NULL,1),(279,9,'中国进出口银行',NULL,NULL,1),(280,9,'中国农业发展银行',NULL,NULL,1),(281,9,'农商银行',NULL,NULL,1),(282,9,'中德住房储蓄银行',NULL,NULL,1),(283,9,'厦门国际银行',NULL,NULL,1),(284,9,'华一银行',NULL,NULL,1),(285,9,'华商银行',NULL,NULL,1),(286,9,'中信嘉华银行（中国）',NULL,NULL,1),(287,9,'汇丰银行（中国）',NULL,NULL,1),(288,9,'东亚银行（中国）',NULL,NULL,1),(289,9,'恒生银行 （中国）',NULL,NULL,1),(290,9,'永亨银行（中国）',NULL,NULL,1),(291,9,'南洋商业银行（中国）',NULL,NULL,1),(292,9,'协和银行',NULL,NULL,1),(293,9,'大新银行（中国）',NULL,NULL,1),(294,9,'台湾永丰银行',NULL,NULL,1),(295,9,'台湾土地银行',NULL,NULL,1),(296,9,'国泰世华银行',NULL,NULL,1),(297,9,'彰化商业银行',NULL,NULL,1),(298,9,'台湾第一银行',NULL,NULL,1),(299,9,'合作金库银行',NULL,NULL,1),(300,9,'台湾工业银行',NULL,NULL,1),(301,9,'台北富邦银行',NULL,NULL,1),(302,9,'花旗银行（中国）',NULL,NULL,1),(303,9,'渣打银行（中国）',NULL,NULL,1),(304,9,'瑞穗实业银行（中国）',NULL,NULL,1),(305,9,'三井住友银行（中国）',NULL,NULL,1),(306,9,'星展银行（中国）',NULL,NULL,1),(307,9,'三菱东京日联银行（中国）',NULL,NULL,1),(308,9,'苏格兰皇家银行（中国）',NULL,NULL,1),(309,9,'韩国友利银行（中国）',NULL,NULL,1),(310,9,'大华银行（中国）',NULL,NULL,1),(311,9,'韩亚银行（中国）',NULL,NULL,1),(312,9,'韩国企业银行（中国）',NULL,NULL,1),(313,9,'德意志银行（中国）',NULL,NULL,1),(314,9,'东方汇理银行（中国）',NULL,NULL,1),(315,9,'宁波国际银行',NULL,NULL,1),(316,9,'华美银行（中国）',NULL,NULL,1),(317,9,'法国巴黎银行（中国）',NULL,NULL,1),(318,9,'新韩银行（中国）',NULL,NULL,1),(319,9,'韩国外换银行（中国）',NULL,NULL,1),(320,9,'泰国盘谷银行（中国）',NULL,NULL,1),(321,9,'菲律宾首都银行（中国）',NULL,NULL,1),(322,9,'正信银行',NULL,NULL,1),(323,9,'法国兴业银行（中国）',NULL,NULL,1),(324,9,'澳新银行（中国）',NULL,NULL,1),(325,9,'山口银行',NULL,NULL,1),(326,9,'横滨银行',NULL,NULL,1),(327,9,'名古屋银行',NULL,NULL,1),(328,9,'瑞士宝盛银行',NULL,NULL,1),(329,10,'哲学',NULL,NULL,1),(330,10,'经济学',NULL,NULL,1),(331,10,'财政学',NULL,NULL,1),(332,10,'金融学',NULL,NULL,1),(333,10,'经济与贸易',NULL,NULL,1),(334,10,'法学',NULL,NULL,1),(335,10,'政治学',NULL,NULL,1),(336,10,'社会学',NULL,NULL,1),(337,10,'民族学',NULL,NULL,1),(338,10,'马克思主义理论',NULL,NULL,1),(339,10,'公安学',NULL,NULL,1),(340,10,'教育学',NULL,NULL,1),(341,10,'体育学',NULL,NULL,1),(342,10,'中国语言文学',NULL,NULL,1),(343,10,'外国语言文学',NULL,NULL,1),(344,10,'新闻传播学',NULL,NULL,1),(345,10,'历史学',NULL,NULL,1),(346,10,'数学',NULL,NULL,1),(347,10,'物理学',NULL,NULL,1),(348,10,'化学',NULL,NULL,1),(349,10,'天文学',NULL,NULL,1),(350,10,'地理科学',NULL,NULL,1),(351,10,'大气科学',NULL,NULL,1),(352,10,'海洋科学',NULL,NULL,1),(353,10,'地球物理学',NULL,NULL,1),(354,10,'地质学',NULL,NULL,1),(355,10,'生物科学',NULL,NULL,1),(356,10,'心理学',NULL,NULL,1),(357,10,'统计学',NULL,NULL,1),(358,10,'力学',NULL,NULL,1),(359,10,'机械',NULL,NULL,1),(360,10,'仪器',NULL,NULL,1),(361,10,'材料',NULL,NULL,1),(362,10,'能源动力',NULL,NULL,1),(363,10,'电气',NULL,NULL,1),(364,10,'电子信息',NULL,NULL,1),(365,10,'自动化',NULL,NULL,1),(366,10,'计算机',NULL,NULL,1),(367,10,'土木',NULL,NULL,1),(368,10,'水利',NULL,NULL,1),(369,10,'测绘',NULL,NULL,1),(370,10,'化工与制药',NULL,NULL,1),(371,10,'地质',NULL,NULL,1),(372,10,'矿业',NULL,NULL,1),(373,10,'纺织',NULL,NULL,1),(374,10,'轻工',NULL,NULL,1),(375,10,'交通运输',NULL,NULL,1),(376,10,'海洋工程',NULL,NULL,1),(377,10,'航空航天',NULL,NULL,1),(378,10,'兵器',NULL,NULL,1),(379,10,'核工程',NULL,NULL,1),(380,10,'农业工程',NULL,NULL,1),(381,10,'林业工程',NULL,NULL,1),(382,10,'环境科学与工程',NULL,NULL,1),(383,10,'生物医学工程',NULL,NULL,1),(384,10,'食品科学与工程',NULL,NULL,1),(385,10,'建筑',NULL,NULL,1),(386,10,'安全科学与工程',NULL,NULL,1),(387,10,'生物工程',NULL,NULL,1),(388,10,'公安技术',NULL,NULL,1),(389,10,'植物生产',NULL,NULL,1),(390,10,'自然保护与环境生态',NULL,NULL,1),(391,10,'动物生产',NULL,NULL,1),(392,10,'动物医学',NULL,NULL,1),(393,10,'林学',NULL,NULL,1),(394,10,'水产',NULL,NULL,1),(395,10,'草学',NULL,NULL,1),(396,10,'基础医学',NULL,NULL,1),(397,10,'临床医学',NULL,NULL,1),(398,10,'口腔医学',NULL,NULL,1),(399,10,'公共卫生与预防医学',NULL,NULL,1),(400,10,'中医学',NULL,NULL,1),(401,10,'中西医结合',NULL,NULL,1),(402,10,'药学',NULL,NULL,1),(403,10,'中药学',NULL,NULL,1),(404,10,'法医学',NULL,NULL,1),(405,10,'医学技术',NULL,NULL,1),(406,10,'护理学',NULL,NULL,1),(407,10,'管理科学与工程',NULL,NULL,1),(408,10,'工商管理',NULL,NULL,1),(409,10,'农业经济管理',NULL,NULL,1),(410,10,'公共管理',NULL,NULL,1),(411,10,'图书情报与档案管理',NULL,NULL,1),(412,10,'物流管理与工程',NULL,NULL,1),(413,10,'电子商务',NULL,NULL,1),(414,10,'旅游管理',NULL,NULL,1),(415,10,'艺术学理论',NULL,NULL,1),(416,10,'音乐与舞蹈学',NULL,NULL,1),(417,10,'戏剧与影视学',NULL,NULL,1),(418,10,'美术学',NULL,NULL,1),(419,10,'设计学',NULL,NULL,1),(420,10,'军事思想及军事历史',NULL,NULL,1),(421,10,'战略学',NULL,NULL,1),(422,10,'战役学',NULL,NULL,1),(423,10,'战术学',NULL,NULL,1),(424,10,'军队指挥学',NULL,NULL,1),(425,10,'军制学',NULL,NULL,1),(426,10,'军队政治工作学',NULL,NULL,1),(427,10,'军事后勤学与军事装备学',NULL,NULL,1),(428,20,'医保',NULL,NULL,1),(429,20,'社保',NULL,NULL,1),(430,14,'公有处方',NULL,NULL,1),(431,14,'私有处方',NULL,NULL,1),(432,15,'西药处方',NULL,NULL,1),(433,15,'中药处方',NULL,NULL,1),(434,15,'中西结合处方',NULL,NULL,1),(435,16,'抗炎',NULL,NULL,1),(436,16,'抗体',NULL,NULL,1),(437,7,'糊剂',NULL,NULL,1),(438,7,'贴剂',NULL,NULL,1),(439,7,'滴剂',NULL,NULL,1),(440,7,'含漱剂',NULL,NULL,1),(441,7,'舌下片剂',NULL,NULL,1),(442,7,'膜剂',NULL,NULL,1),(443,7,'栓剂',NULL,NULL,1),(444,7,'长效制剂',NULL,NULL,1),(445,7,'海绵剂',NULL,NULL,1),(446,7,'其它剂型',NULL,NULL,1),(447,24,'口服',NULL,NULL,1),(448,24,'外用',NULL,NULL,1),(449,24,'皮下','H',NULL,1),(450,24,'皮内','ID',NULL,1),(451,24,'肌注','IM',NULL,1),(452,24,'静注','IV',NULL,1),(453,24,'静滴','VD',NULL,1),(454,24,'动注','IA',NULL,1),(455,24,'鞘内','IT',NULL,1),(456,24,'椎管',NULL,NULL,1),(457,24,'椎管内','IS',NULL,1),(458,24,'心内','IC',NULL,1),(459,25,'立刻','st!',NULL,1),(460,25,'每日一次','qd',NULL,1),(461,25,'每日两次','bid',NULL,1),(462,25,'每日三次','tid',NULL,1),(463,25,'每日四次','qid',NULL,1),(464,25,'每小时一次','qh',NULL,1),(465,25,'每两小时一次','q2h',NULL,1),(466,25,'每三小时一次','q3h',NULL,1),(467,25,'每四小时一次','q4h',NULL,1),(468,25,'每六小时一次','q6h',NULL,1),(469,25,'每晚一次','qn',NULL,1),(470,25,'每隔天一次','qod',NULL,1),(471,25,'每周一次','qw',NULL,1),(472,25,'每周两次','biw',NULL,1),(473,25,'临睡前','hs',NULL,1),(474,25,'上午','am',NULL,1),(475,25,'下午','pm',NULL,1),(476,25,'饭前','ac',NULL,1),(477,25,'饭后','pc',NULL,1),(478,25,'中午12点','12n',NULL,1),(479,25,'午夜12点','12mn',NULL,1),(480,25,'必要时（长期）','prn',NULL,1),(481,25,'紧急时（限用一次，12小时有效）','sos',NULL,1),(482,4,'测试',NULL,'测试',2),(483,4,'测试数据',NULL,'测试数据',2),(484,4,'测试数据',NULL,'测试数据',2),(485,4,'测试数据',NULL,'测试数据',2);

/*Table structure for table `charge` */

DROP TABLE IF EXISTS `charge`;

CREATE TABLE `charge` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `prescriptionid` int(11) DEFAULT NULL COMMENT '处方id',
  `receiptcode` varchar(32) DEFAULT NULL COMMENT '收据号',
  `invoicecode` varchar(32) DEFAULT NULL COMMENT '发票号',
  `chargestatus` int(11) DEFAULT NULL COMMENT '收费状态',
  `discount` int(11) DEFAULT NULL COMMENT '折扣',
  `privilege` int(11) DEFAULT NULL COMMENT '优惠',
  `beforereceivable` decimal(8,2) DEFAULT NULL COMMENT '折前应收',
  `afterreceivable` decimal(8,2) DEFAULT NULL COMMENT '折后应收',
  `medicarecanpay` decimal(8,2) DEFAULT NULL COMMENT '医保可付',
  `cost` decimal(8,2) DEFAULT NULL COMMENT '费用',
  `operationpersonid` int(11) DEFAULT NULL COMMENT '操作人员id',
  `chargetime` datetime DEFAULT NULL COMMENT '收费时间',
  `isvalid` int(11) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='收费';

/*Data for the table `charge` */

/*Table structure for table `chargetype` */

DROP TABLE IF EXISTS `chargetype`;

CREATE TABLE `chargetype` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `typecode` varchar(32) DEFAULT NULL COMMENT '类别编号',
  `typename` varchar(32) DEFAULT NULL COMMENT '类别名称',
  `itemmark` varchar(32) DEFAULT NULL COMMENT '项目标志',
  `discount` int(11) DEFAULT NULL COMMENT '类别折扣',
  `note` varchar(128) DEFAULT NULL COMMENT '备注',
  `isvalid` int(11) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='收费类别';

/*Data for the table `chargetype` */

insert  into `chargetype`(`id`,`typecode`,`typename`,`itemmark`,`discount`,`note`,`isvalid`) values (1,'001','西药费','药费',100,'测试',1),(2,'002','中药费','药费',100,'测试',1),(11,'5566','记录','药费',55,'55',1),(12,'33','33','33',33,'33',2),(13,'44','44','44',44,'44',2),(14,'','','',NULL,'',2);

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `departmentcode` varchar(32) DEFAULT NULL COMMENT '编号',
  `departmentname` varchar(32) DEFAULT NULL COMMENT '名称',
  `pinyincode` varchar(16) DEFAULT NULL COMMENT '拼音简码',
  `wubicode` varchar(16) DEFAULT NULL COMMENT '五笔简码',
  `registersum` decimal(8,2) DEFAULT NULL COMMENT '挂号金额',
  `site` varchar(64) DEFAULT NULL COMMENT '科室位置',
  `isregister` int(11) DEFAULT NULL COMMENT '是否允许挂号',
  `isvalid` int(11) DEFAULT NULL COMMENT '是否有效',
  `note` varchar(128) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COMMENT='科室';

/*Data for the table `department` */

insert  into `department`(`id`,`departmentcode`,`departmentname`,`pinyincode`,`wubicode`,`registersum`,`site`,`isregister`,`isvalid`,`note`) values (1,'001','院办','YB',NULL,NULL,'X楼X室',2,1,'测试数据'),(2,'002','党办','DB',NULL,NULL,'X楼X室',2,1,'测试数据'),(3,'003','住院办','ZYB',NULL,NULL,'X楼X室',2,1,'测试数据'),(4,'004','内科','NK',NULL,'3.00','X楼X室',1,1,'测试数据'),(5,'005','外科','WK',NULL,'3.00','X楼X室',1,1,'测试数据'),(6,'006','儿科','EK',NULL,'3.00','X楼X室',1,1,'测试数据'),(7,'007','妇产科','FCK',NULL,'3.00','X楼X室',1,1,'测试数据'),(8,'008','眼科','YK',NULL,'3.00','X楼X室',1,1,'测试数据'),(9,'009','牙科','YK',NULL,'3.00','X楼X室',1,1,'测试数据'),(10,'010','五官科','WGK',NULL,'3.00','X楼X室',1,1,'测试数据'),(11,'011','泌尿科','MNK',NULL,'3.00','X楼X室',1,1,'测试数据'),(12,'012','消化科','XHK',NULL,'3.00','X楼X室',1,1,'测试数据'),(13,'013','检验科','JYK',NULL,'3.00','X楼X室',1,1,'测试数据'),(14,'014','急诊科','JZK',NULL,'3.00','X楼X室',1,1,'测试数据'),(15,'015','保健科','BJK',NULL,'3.00','X楼X室',1,1,'测试数据'),(16,'016','药剂科','YJK',NULL,NULL,'X楼X室',2,1,'测试数据'),(17,'017','放射科','FSK',NULL,NULL,'X楼X室',2,1,'测试数据'),(18,'018','临床科','LCK',NULL,NULL,'X楼X室',2,1,'测试数据'),(19,'019','功能科','GNK',NULL,NULL,'X楼X室',2,1,'测试数据'),(20,'020','病理科','BLK',NULL,NULL,'X楼X室',2,1,'测试数据'),(21,'021','手术室','SSS',NULL,NULL,'X楼X室',2,1,'测试数据'),(22,'022','护理部','HLB',NULL,NULL,'X楼X室',2,1,'测试数据'),(23,'023','营养科','YYK',NULL,NULL,'X楼X室',2,1,'测试数据'),(24,'024','消毒器材供应室','XDQCGYS',NULL,NULL,'X楼X室',2,1,'测试数据'),(25,'025','质控科','ZGK',NULL,NULL,'X楼X室',2,1,'测试数据'),(26,'026','院感科','YGK',NULL,NULL,'X楼X室',2,1,'测试数据'),(27,'027','药学部','YXB',NULL,NULL,'X楼X室',2,1,'测试数据'),(28,'028','医务科','YWK',NULL,NULL,'X楼X室',2,1,'测试数据'),(29,'029','人事科','RSK',NULL,NULL,'X楼X室',2,1,'测试数据'),(30,'030','财务科','CWK',NULL,NULL,'X楼X室',2,1,'测试数据'),(31,'031','科教科','KJK',NULL,NULL,'X楼X室',2,1,'测试数据'),(32,'032','总务科','ZWK',NULL,NULL,'X楼X室',2,1,'测试数据'),(33,'033','保卫科','BWK',NULL,NULL,'X楼X室',2,1,'测试数据'),(34,'034','设备科','SBK',NULL,NULL,'X楼X室',2,1,'测试数据'),(35,'035','供应科','GYK',NULL,NULL,'X楼X室',2,1,'测试数据'),(36,'036','膳食科','SSK',NULL,NULL,'X楼X室',2,1,'测试数据'),(37,'037','后勤部','HQB',NULL,NULL,'X楼X室',2,1,'测试数据'),(38,'038','病案室','BAS',NULL,NULL,'X楼X室',2,1,'测试数据'),(39,'039','统计室','TJS',NULL,NULL,'X楼X室',2,1,'测试数据'),(40,'040','图书室','TSS',NULL,NULL,'X楼X室',2,1,'测试数据'),(41,'041','健康教育科','JKJYK',NULL,NULL,'X楼X室',2,1,'测试数据'),(42,'042','计算机中心','JSJZX',NULL,NULL,'X楼X室',2,1,'测试数据'),(43,'042','fsdfsdsd','FSDFSDSD',NULL,'3.00','sdfdds',1,2,'dsfdsdf'),(44,'043','fsd','FSD',NULL,NULL,'sfs',NULL,2,'dsdfs');

/*Table structure for table `disease` */

DROP TABLE IF EXISTS `disease`;

CREATE TABLE `disease` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `diseasecode` varchar(32) DEFAULT NULL COMMENT '疾病编号',
  `diseasename` varchar(32) DEFAULT NULL COMMENT '疾病名称',
  `diseaseexplain` varchar(256) DEFAULT NULL COMMENT '疾病说明',
  `isvalid` int(11) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='疾病档案';

/*Data for the table `disease` */

insert  into `disease`(`id`,`diseasecode`,`diseasename`,`diseaseexplain`,`isvalid`) values (1,'001','疾病A','疾病A的说明',1),(2,'002','疾病B','疾病B的说明',1),(3,'003','疾病C','疾病C的说明',1);

/*Table structure for table `dispensing` */

DROP TABLE IF EXISTS `dispensing`;

CREATE TABLE `dispensing` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `chargeid` int(11) DEFAULT NULL COMMENT '收费id',
  `dispensingstatus` int(11) DEFAULT NULL COMMENT '发药状态',
  `dispensingtime` datetime DEFAULT NULL COMMENT '发药时间',
  `isvalid` int(11) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='发药';

/*Data for the table `dispensing` */

/*Table structure for table `drug` */

DROP TABLE IF EXISTS `drug`;

CREATE TABLE `drug` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `chargetypeid` int(11) DEFAULT NULL COMMENT '收费类别id',
  `drugname` varchar(32) DEFAULT NULL COMMENT '药品名称',
  `drugcode` varchar(32) DEFAULT NULL COMMENT '药品编码',
  `barcode` varchar(32) DEFAULT NULL COMMENT '条形码',
  `medicalsciencecode` varchar(32) DEFAULT NULL COMMENT '医学编码',
  `enname` varchar(32) DEFAULT NULL COMMENT '英文名称',
  `origin` varchar(16) DEFAULT NULL COMMENT '产地',
  `approvalnumber` varchar(32) DEFAULT NULL COMMENT '批准文号',
  `pinyincode` varchar(16) DEFAULT NULL COMMENT '拼音简码',
  `wubicode` varchar(16) DEFAULT NULL COMMENT '五笔简码',
  `drugtypeid` int(11) DEFAULT NULL COMMENT '药品类型id',
  `agenttypeid` int(11) DEFAULT NULL COMMENT '药品剂型id',
  `dosageunit` varchar(16) DEFAULT NULL COMMENT '剂量单位',
  `unitdosage` varchar(16) DEFAULT NULL COMMENT '单位剂量',
  `norms` varchar(16) DEFAULT NULL COMMENT '规格',
  `inbulkbuyprice` decimal(8,2) DEFAULT NULL COMMENT '散装进价',
  `inbulkvipprice` decimal(8,2) DEFAULT NULL COMMENT '散会员价',
  `inbulksellprice` decimal(8,2) DEFAULT NULL COMMENT '散装售价',
  `packagebuyprice` decimal(8,2) DEFAULT NULL COMMENT '件装进价',
  `packagesellprice` decimal(8,2) DEFAULT NULL COMMENT '件装售价',
  `packagevipprice` decimal(8,2) DEFAULT NULL COMMENT '件会员价',
  `ismedicare` int(11) DEFAULT NULL COMMENT '是否医保',
  `medicaretypeid` int(11) DEFAULT NULL COMMENT '医保类别id',
  `medicarecode` int(11) DEFAULT NULL COMMENT '医保编码',
  `medicareprice` varchar(32) DEFAULT NULL COMMENT '医保价格',
  `isaddwater` int(11) DEFAULT NULL COMMENT '是否加水',
  `isST` int(11) DEFAULT NULL COMMENT '是否皮试',
  `isspecialdrug` int(11) DEFAULT NULL COMMENT '是否特殊药品',
  `shelfcode` varchar(32) DEFAULT NULL COMMENT '货架编号',
  `productiondata` date DEFAULT NULL COMMENT '生产日期',
  `expiration` int(11) DEFAULT NULL COMMENT '保质期',
  `supplierid` int(11) DEFAULT NULL COMMENT '供应商id',
  `usestatus` int(11) DEFAULT NULL COMMENT '使用状态',
  `manufacturer` varchar(64) DEFAULT NULL COMMENT '厂商名称',
  `applysymptom` varchar(32) DEFAULT NULL COMMENT '适用症状',
  `mainefficacy` varchar(64) DEFAULT NULL COMMENT '主要功效',
  `inventoryquantity` int(11) DEFAULT NULL COMMENT '库存数量',
  `inventoryprice` decimal(8,2) DEFAULT NULL COMMENT '库存单价',
  `typeinpersonnelid` int(11) DEFAULT NULL COMMENT '录入人员id',
  `typeindatetime` datetime DEFAULT NULL COMMENT '录入时间',
  `alterpersonnelid` int(11) DEFAULT NULL COMMENT '修改人员id',
  `alterdatetime` datetime DEFAULT NULL COMMENT '修改时间',
  `picture` varchar(128) DEFAULT NULL COMMENT '图片',
  `isvalid` int(11) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='药品';

/*Data for the table `drug` */

insert  into `drug`(`id`,`chargetypeid`,`drugname`,`drugcode`,`barcode`,`medicalsciencecode`,`enname`,`origin`,`approvalnumber`,`pinyincode`,`wubicode`,`drugtypeid`,`agenttypeid`,`dosageunit`,`unitdosage`,`norms`,`inbulkbuyprice`,`inbulkvipprice`,`inbulksellprice`,`packagebuyprice`,`packagesellprice`,`packagevipprice`,`ismedicare`,`medicaretypeid`,`medicarecode`,`medicareprice`,`isaddwater`,`isST`,`isspecialdrug`,`shelfcode`,`productiondata`,`expiration`,`supplierid`,`usestatus`,`manufacturer`,`applysymptom`,`mainefficacy`,`inventoryquantity`,`inventoryprice`,`typeinpersonnelid`,`typeindatetime`,`alterpersonnelid`,`alterdatetime`,`picture`,`isvalid`) values (1,1,'盐酸特比萘芬乳膏','1','1','1','YanSuanTeBiNaiFenRuGao',NULL,'1','YSTBNFRG',NULL,239,256,'1','1','1','1.00','1.00','1.00','1.00','1.00','1.00',2,260,1,'1',2,1,1,'1','2016-12-04',1,1,1,'1','1','1',36,'3.00',5,'2016-12-04 09:59:34',5,'2017-02-20 21:28:06','http://127.0.0.1:8080/tnt/20170220/93575578380129.jpg',1),(2,1,'健胃消食片','2','2','2','JianWeiXiaoShiPian',NULL,'2','JWXSP',NULL,240,242,'2','2','2','2.00','2.00','2.00','2.00','2.00','2.00',1,260,2,'2',2,2,2,'2','2016-12-04',2,1,1,'2','2','2',31,'2.00',5,'2016-12-04 11:06:59',5,'2017-02-20 21:28:15','http://127.0.0.1:8080/tnt/20170220/93585007815857.jpg',1),(4,1,'云南白药喷雾器','3','3','3','3',NULL,'3','YNBYPWQ',NULL,240,253,'3','3','3','3.00','3.00','3.00','3.00','3.00','3.00',1,260,3,'3',2,1,2,'3','2016-12-01',3,1,1,'3','3','3',3,'3.00',5,'2016-12-04 20:22:05',NULL,NULL,'/tnt/image/3363734269060.jpg',2),(5,1,'藿香水','3','3','33','sds',NULL,'2','HXS',NULL,239,246,'2','3','3','2.00','3.00','2.00','2.00','2.00','3.00',1,258,4,'1',2,2,2,'2','2016-12-01',2,1,1,'2','2','2',9,'2.00',5,'2016-12-06 19:33:45',5,'2017-02-23 16:47:47','http://127.0.0.1:8080/tnt/20170220/93601237022397.jpg',1);

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `employeecode` varchar(64) DEFAULT NULL COMMENT '员工编号',
  `employeename` varchar(32) DEFAULT NULL COMMENT '姓名',
  `psw` varchar(32) DEFAULT NULL COMMENT '密码',
  `pinyincode` varchar(16) DEFAULT NULL COMMENT '拼音简码',
  `wubicode` varchar(16) DEFAULT NULL COMMENT '五笔简码',
  `jobtitleid` int(11) DEFAULT NULL COMMENT '职称id',
  `positionid` int(11) DEFAULT NULL COMMENT '职务id',
  `sex` int(11) DEFAULT NULL COMMENT '性别',
  `tel` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `departmentid` int(11) DEFAULT NULL COMMENT '所属科室id',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `idcard` varchar(18) DEFAULT NULL COMMENT '身份证',
  `address` varchar(128) DEFAULT NULL COMMENT '地址',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `inductiontime` datetime DEFAULT NULL COMMENT '入职时间',
  `dimissiontime` datetime DEFAULT NULL COMMENT '离职时间',
  `maxeducationid` int(11) DEFAULT NULL COMMENT '最高学历id',
  `majorid` int(11) DEFAULT NULL COMMENT '专业id',
  `politicsstatusid` int(11) DEFAULT NULL COMMENT '政治面貌id',
  `isoperator` int(11) DEFAULT NULL COMMENT '是否操作员',
  `isdoctor` int(11) DEFAULT NULL COMMENT '是否医生',
  `isnurse` int(11) DEFAULT NULL COMMENT '是否护士',
  `workstatus` int(11) DEFAULT NULL COMMENT '工作状态',
  `picture` varchar(128) DEFAULT NULL COMMENT '图片',
  `note` varchar(128) DEFAULT NULL COMMENT '备注',
  `isvalid` int(11) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='员工';

/*Data for the table `employee` */

insert  into `employee`(`id`,`employeecode`,`employeename`,`psw`,`pinyincode`,`wubicode`,`jobtitleid`,`positionid`,`sex`,`tel`,`departmentid`,`email`,`idcard`,`address`,`birthday`,`inductiontime`,`dimissiontime`,`maxeducationid`,`majorid`,`politicsstatusid`,`isoperator`,`isdoctor`,`isnurse`,`workstatus`,`picture`,`note`,`isvalid`) values (5,'admin','赵一','21232f297a57a5a743894a0e4a801fc3','ZY',NULL,218,22,2,'456',1,'456','456','2','2016-11-02','2016-11-25 00:00:00',NULL,3,396,8,2,2,1,1,'http://127.0.0.1:8080/tnt/20170220/93674530641596.jpg','2',1),(6,'001','钱二','202cb962ac59075b964b07152d234b70','QE',NULL,218,44,1,'44',4,'44','44','123321','2016-11-03','2016-11-10 00:00:00',NULL,2,397,9,1,1,2,1,'http://127.0.0.1:8080/tnt/20170220/93687381134042.jpg','2131212',1),(7,'002','张三','202cb962ac59075b964b07152d234b70','ZS',NULL,219,45,1,'66',5,'66','66','66','2016-11-02','2016-11-19 00:00:00','2016-11-12 00:00:00',3,400,6,1,1,2,2,'http://127.0.0.1:8080/tnt/20170220/93703097234797.jpg','66',1),(8,'003','李四','202cb962ac59075b964b07152d234b70','LS',NULL,218,46,1,'44',6,'44','44','44','2016-11-16','2016-11-10 00:00:00','2016-11-09 00:00:00',3,396,9,1,1,2,1,'http://127.0.0.1:8080/tnt/20170220/93730498107728.png','44',1),(9,'004','王五','202cb962ac59075b964b07152d234b70','WW',NULL,219,46,1,'55',7,'55','55','55','2016-11-02','2016-11-11 00:00:00',NULL,2,405,6,1,1,2,1,'http://127.0.0.1:8080/tnt/20170220/93747116976363.png','55',1),(10,'005','孙六','202cb962ac59075b964b07152d234b70','SL',NULL,219,47,1,'77',8,'77','77','77','2016-11-02','2016-11-10 00:00:00',NULL,3,406,6,1,1,2,1,'http://127.0.0.1:8080/tnt/20170220/93760688369745.jpg','77',1),(11,'006','田七','202cb962ac59075b964b07152d234b70','TQ',NULL,218,47,1,'3',9,'3','3','3','1978-03-02','2017-02-08 00:00:00',NULL,1,400,6,1,1,2,1,'http://127.0.0.1:8080/tnt/20170220/93310090000388.png','2',1),(12,'42032','王八','202cb962ac59075b964b07152d234b70','WB',NULL,236,154,2,'13413311322',30,'865133204@qq.com','440923198005050345','广东省广州市','1980-05-05','2017-03-15 00:00:00',NULL,3,330,8,1,2,1,1,'http://127.0.0.1:8080/tnt/20170315/29835237175954.jpg','',1);

/*Table structure for table `medicalrecord` */

DROP TABLE IF EXISTS `medicalrecord`;

CREATE TABLE `medicalrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `registerid` int(11) DEFAULT NULL COMMENT '挂号id',
  `medicalrecordcode` varchar(32) DEFAULT NULL COMMENT '病历编号',
  `medicalrecordname` varchar(32) DEFAULT NULL COMMENT '病历名称',
  `doctorid` int(11) DEFAULT NULL COMMENT '医生id',
  `diseaseid` int(11) DEFAULT NULL COMMENT '疾病类型id',
  `note` varchar(128) DEFAULT NULL COMMENT '备注',
  `patientappeal` varchar(256) DEFAULT NULL COMMENT '病人主诉',
  `medicalhistory` varchar(256) DEFAULT NULL COMMENT '病人病史',
  `physicalstatus` varchar(256) DEFAULT NULL COMMENT '体检情况',
  `primarydiagnosis` varchar(256) DEFAULT NULL COMMENT '初步诊断',
  `opinion` varchar(256) DEFAULT NULL COMMENT '处理意见',
  `recordtime` datetime DEFAULT NULL COMMENT '记录时间',
  `isvalid` int(11) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='病历';

/*Data for the table `medicalrecord` */

/*Table structure for table `medicalrecordtemplate` */

DROP TABLE IF EXISTS `medicalrecordtemplate`;

CREATE TABLE `medicalrecordtemplate` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `templatecode` varchar(32) DEFAULT NULL COMMENT '编号',
  `templatename` varchar(32) DEFAULT NULL COMMENT '名称',
  `doctorid` int(11) DEFAULT NULL COMMENT '医生id',
  `diseaseid` int(11) DEFAULT NULL COMMENT '疾病类型id',
  `fitstatus` varchar(128) DEFAULT NULL COMMENT '适合情况',
  `note` varchar(128) DEFAULT NULL COMMENT '模板备注',
  `patientappeal` varchar(256) DEFAULT NULL COMMENT '病人主诉',
  `medicalhistory` varchar(256) DEFAULT NULL COMMENT '病人病史',
  `physicalstatus` varchar(256) DEFAULT NULL COMMENT '体检情况',
  `primarydiagnosis` varchar(256) DEFAULT NULL COMMENT '初步诊断',
  `opinion` varchar(256) DEFAULT NULL COMMENT '处理意见',
  `isvalid` int(11) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='病历模板';

/*Data for the table `medicalrecordtemplate` */

insert  into `medicalrecordtemplate`(`id`,`templatecode`,`templatename`,`doctorid`,`diseaseid`,`fitstatus`,`note`,`patientappeal`,`medicalhistory`,`physicalstatus`,`primarydiagnosis`,`opinion`,`isvalid`) values (14,'BLMB25528105','流行性感冒',6,1,'感冒','感冒','头疼、流涕、乏力','流行性感冒','流行性感冒','流行性感冒','点滴、吃药',1),(15,'BLMB29273638','dsd',5,1,'双方的发生','范德萨发生','双方发生的','双方发生大幅度','多少分发的啥都是','发生的所得税','所得税法师法师打发',2);

/*Table structure for table `patient` */

DROP TABLE IF EXISTS `patient`;

CREATE TABLE `patient` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cardcode` varchar(32) DEFAULT NULL COMMENT '病人卡号',
  `patientname` varchar(32) DEFAULT NULL COMMENT '病人名称',
  `sex` int(11) DEFAULT NULL COMMENT '性别',
  `maritalstatusid` int(11) DEFAULT NULL COMMENT '婚姻状况id',
  `job` varchar(16) DEFAULT NULL COMMENT '职业',
  `patienttypeid` int(11) DEFAULT NULL COMMENT '病人类别id',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `insuretypeid` int(11) DEFAULT NULL COMMENT '参保类型id',
  `medicarecode` varchar(32) DEFAULT NULL COMMENT '医保卡号',
  `viptypeid` int(11) DEFAULT NULL COMMENT '会员类型id',
  `tel` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `address` varchar(128) DEFAULT NULL COMMENT '联系地址',
  `taboo` varchar(64) DEFAULT NULL COMMENT '个人忌讳',
  `drugallergyhistory` varchar(64) DEFAULT NULL COMMENT '药物过敏史',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='病人资料';

/*Data for the table `patient` */

/*Table structure for table `patienttype` */

DROP TABLE IF EXISTS `patienttype`;

CREATE TABLE `patienttype` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `typecode` varchar(32) DEFAULT NULL COMMENT '类别编号',
  `typename` varchar(32) DEFAULT NULL COMMENT '类别名称',
  `typediscount` int(11) DEFAULT NULL COMMENT '类别折扣',
  `isvalid` int(11) DEFAULT NULL COMMENT '是否有效',
  `note` varchar(128) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='病人类别';

/*Data for the table `patienttype` */

insert  into `patienttype`(`id`,`typecode`,`typename`,`typediscount`,`isvalid`,`note`) values (1,'01','普通病人',100,1,NULL),(2,'02','港澳台病人',150,1,NULL),(3,'03','外国病人',200,1,''),(4,'456','测试数据',98,2,'测试数据'),(5,'4','5',4,2,'4');

/*Table structure for table `prescription` */

DROP TABLE IF EXISTS `prescription`;

CREATE TABLE `prescription` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `registerid` int(11) DEFAULT NULL COMMENT '挂号id',
  `prescriptioncode` varchar(32) DEFAULT NULL COMMENT '处方单号',
  `prescriptionname` varchar(32) DEFAULT NULL COMMENT '名称',
  `doctorid` int(11) DEFAULT NULL COMMENT '医生id',
  `natureid` int(11) DEFAULT NULL COMMENT '处方性质id',
  `prescriptiontypeid` int(11) DEFAULT NULL COMMENT '处方类型id',
  `classifyid` int(11) DEFAULT NULL COMMENT '处方分类id',
  `note` varchar(128) DEFAULT NULL COMMENT '备注',
  `diagnosis` varchar(128) DEFAULT NULL COMMENT '处方诊断',
  `prescriptiontime` datetime DEFAULT NULL COMMENT '处方时间',
  `isvalid` int(11) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='处方';

/*Data for the table `prescription` */

/*Table structure for table `prescriptiondetail` */

DROP TABLE IF EXISTS `prescriptiondetail`;

CREATE TABLE `prescriptiondetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `prescriptionid` int(11) DEFAULT NULL COMMENT '处方id',
  `drugid` int(11) DEFAULT NULL COMMENT '药品id',
  `eachdosage` int(11) DEFAULT NULL COMMENT '每剂用量',
  `dosagequantity` int(11) DEFAULT NULL COMMENT '剂数',
  `medicineformid` int(11) DEFAULT NULL COMMENT '用药方式id',
  `medicinefrequencyid` int(11) DEFAULT NULL COMMENT '用药频率id',
  `medicineamount` int(11) DEFAULT NULL COMMENT '用药总量',
  `note` varchar(128) DEFAULT NULL COMMENT '备注',
  `isvalid` int(11) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='处方明细';

/*Data for the table `prescriptiondetail` */

/*Table structure for table `prescriptiontemplate` */

DROP TABLE IF EXISTS `prescriptiontemplate`;

CREATE TABLE `prescriptiontemplate` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `templatename` varchar(32) DEFAULT NULL COMMENT '名称',
  `doctorid` int(11) DEFAULT NULL COMMENT '医生id',
  `natureid` int(11) DEFAULT NULL COMMENT '模板性质id',
  `prescriptiontypeid` int(11) DEFAULT NULL COMMENT '处方类型id',
  `classifyid` int(11) DEFAULT NULL COMMENT '模板分类id',
  `note` varchar(128) DEFAULT NULL COMMENT '备注',
  `diagnosis` varchar(128) DEFAULT NULL COMMENT '处方诊断',
  `isvalid` int(11) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='处方模板';

/*Data for the table `prescriptiontemplate` */

insert  into `prescriptiontemplate`(`id`,`templatename`,`doctorid`,`natureid`,`prescriptiontypeid`,`classifyid`,`note`,`diagnosis`,`isvalid`) values (10,'流行性感冒',6,430,434,436,'感冒','感冒',1),(11,'1',5,430,432,435,'1','1',2);

/*Table structure for table `prescriptiontemplatedetail` */

DROP TABLE IF EXISTS `prescriptiontemplatedetail`;

CREATE TABLE `prescriptiontemplatedetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `prescriptiontemplateid` int(11) DEFAULT NULL COMMENT '处方id',
  `drugid` int(11) DEFAULT NULL COMMENT '药品id',
  `eachdosage` int(11) DEFAULT NULL COMMENT '每剂用量',
  `dosagequantity` int(11) DEFAULT NULL COMMENT '剂数',
  `medicineformid` int(11) DEFAULT NULL COMMENT '用药方式id',
  `medicinefrequencyid` int(11) DEFAULT NULL COMMENT '用药频率id',
  `medicineamount` int(11) DEFAULT NULL COMMENT '用药总量',
  `note` varchar(128) DEFAULT NULL COMMENT '备注',
  `isvalid` int(11) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='处方模板明细';

/*Data for the table `prescriptiontemplatedetail` */

insert  into `prescriptiontemplatedetail`(`id`,`prescriptiontemplateid`,`drugid`,`eachdosage`,`dosagequantity`,`medicineformid`,`medicinefrequencyid`,`medicineamount`,`note`,`isvalid`) values (18,10,1,3,3,448,460,9,'',2),(19,10,2,3,3,447,460,9,'',2),(20,10,5,3,3,447,460,9,'',2),(21,10,1,3,3,448,460,6,'外用',2),(22,10,2,3,3,447,460,6,'口服',2),(23,10,5,3,3,447,460,6,'口服',2),(24,11,2,1,1,447,459,1,'1',2),(25,11,2,1,1,447,459,1,'1',2),(26,11,2,1,1,447,459,1,'1',2),(27,10,1,3,3,448,460,6,'外用',1),(28,10,2,3,3,447,460,6,'口服',1),(29,10,5,3,3,447,460,6,'口服',1);

/*Table structure for table `register` */

DROP TABLE IF EXISTS `register`;

CREATE TABLE `register` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `patientid` int(11) DEFAULT NULL COMMENT '病人id',
  `registertypeid` int(11) DEFAULT NULL COMMENT '挂号类别id',
  `registercode` varchar(32) DEFAULT NULL COMMENT '挂号单号',
  `departmentid` int(11) DEFAULT NULL COMMENT '科室id',
  `doctorid` int(11) DEFAULT NULL COMMENT '医生id',
  `registersum` decimal(8,2) DEFAULT NULL COMMENT '挂号金额',
  `registertime` datetime DEFAULT NULL COMMENT '挂号时间',
  `registerstatus` int(11) DEFAULT NULL COMMENT '挂号状态',
  `registerpersonid` int(11) DEFAULT NULL COMMENT '挂号人员id',
  `isvalid` int(11) DEFAULT NULL COMMENT '是否有效',
  `note` varchar(128) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='挂号';

/*Data for the table `register` */

/*Table structure for table `registertype` */

DROP TABLE IF EXISTS `registertype`;

CREATE TABLE `registertype` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `typecode` varchar(32) DEFAULT NULL COMMENT '编号',
  `typename` varchar(32) DEFAULT NULL COMMENT '类别名称',
  `typesum` decimal(8,2) DEFAULT NULL COMMENT '类别金额',
  `note` varchar(128) DEFAULT NULL COMMENT '备注',
  `isvalid` int(11) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='挂号类别';

/*Data for the table `registertype` */

insert  into `registertype`(`id`,`typecode`,`typename`,`typesum`,`note`,`isvalid`) values (1,'001','正常就诊','3.00',NULL,1),(2,'002','续诊','0.00',NULL,1),(3,'003','复诊','1.00',NULL,1),(4,'004','急诊','3.00',NULL,1),(5,'005','专家','5.00','',1),(6,'456','测试数据','5.00','测试数据',2);

/*Table structure for table `resource` */

DROP TABLE IF EXISTS `resource`;

CREATE TABLE `resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `resourcesuperiorid` int(11) DEFAULT NULL COMMENT '所属资源id',
  `resourcename` varchar(32) DEFAULT NULL COMMENT '资源名称',
  `resourceurl` varchar(256) DEFAULT NULL COMMENT '资源链接',
  `resourceicon` varchar(64) DEFAULT NULL COMMENT '资源图标',
  `rank` int(11) DEFAULT NULL COMMENT '排序值',
  `isvalid` int(11) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8;

/*Data for the table `resource` */

insert  into `resource`(`id`,`resourcesuperiorid`,`resourcename`,`resourceurl`,`resourceicon`,`rank`,`isvalid`) values (1,0,'挂号登记','/patientController/list.do','icon-desktop',NULL,1),(2,0,'医生工作站','','icon-edit',NULL,1),(3,0,'收费管理','/chargeController/list.do','icon-dollar',NULL,1),(4,0,'药房管理','','icon-tag',NULL,1),(5,0,'基础信息','','icon-file-alt',NULL,1),(6,0,'人事管理','','icon-user',NULL,1),(7,3,'收费','/chargeController/add.do',NULL,NULL,1),(8,1,'查询','/registerController/registerlist.do',NULL,NULL,1),(9,8,'编辑','',NULL,NULL,2),(10,1,'保存病人','/patientController/add.do',NULL,NULL,1),(11,1,'使用单位1','xxx',NULL,NULL,2),(12,11,'编辑','xxx',NULL,NULL,2),(13,1,'挂号','/registerController/add.do',NULL,NULL,1),(14,13,'编辑','xxx.xxx',NULL,NULL,2),(15,2,'病历模板','/medicalrecordtemplateController/list.do',NULL,NULL,1),(16,3,'查询历史记录','/chargeController/tohistory.do',NULL,NULL,1),(17,3,'病历','medicalrecordController/list.do',NULL,NULL,2),(18,3,'处方','prescriptionController/list.do',NULL,NULL,2),(19,1,'查询历史记录','/registerController/tohistory.do',NULL,NULL,1),(20,4,'药品档案','/drugController/list.do',NULL,NULL,1),(21,2,'处方模板','/prescriptiontemplateController/list.do',NULL,NULL,1),(22,2,'病历','/medicalrecordController/list.do',NULL,NULL,1),(23,2,'处方','/prescriptionController/list.do',NULL,NULL,1),(24,19,'查询','/registerController/historydatalist.do',NULL,NULL,1),(25,19,'作废单据','/registerController/delete.do',NULL,NULL,1),(26,15,'查询','/medicalrecordtemplateController/datalist.do',NULL,NULL,1),(27,15,'新增','/medicalrecordtemplateController/toadd.do,/medicalrecordtemplateController/add.do',NULL,NULL,1),(28,15,'修改','/medicalrecordtemplateController/toedit.do,/medicalrecordtemplateController/edit.do',NULL,NULL,1),(29,15,'删除','/medicalrecordtemplateController/delete.do',NULL,NULL,1),(30,21,'查询','/prescriptiontemplateController/datalist.do',NULL,NULL,1),(31,21,'新增','/prescriptiontemplateController/toadd.do,/prescriptiontemplateController/add.do',NULL,NULL,1),(32,21,'修改','/prescriptiontemplateController/toedit.do,/prescriptiontemplateController/edit.do',NULL,NULL,1),(33,21,'删除','/prescriptiontemplateController/delete.do',NULL,NULL,1),(34,22,'查询','/medicalrecordController/datalist.do',NULL,NULL,1),(35,22,'病历录入','/medicalrecordController/toadd.do,/medicalrecordController/add.do',NULL,NULL,1),(36,22,'修改','/medicalrecordController/toedit.do,/medicalrecordController/edit.do',NULL,NULL,1),(37,22,'删除','/medicalrecordController/delete.do',NULL,NULL,1),(38,23,'查询','/prescriptionController/datalist.do',NULL,NULL,1),(39,23,'开处方','/prescriptionController/toadd.do,/prescriptionController/add.do',NULL,NULL,1),(40,23,'修改','/prescriptionController/toedit.do,/prescriptionController/edit.do',NULL,NULL,1),(41,23,'删除','/prescriptionController/delete.do',NULL,NULL,1),(42,16,'查询','/chargeController/historydatalist.do',NULL,NULL,1),(43,0,'系统设置','','icon-cog',NULL,1),(44,4,'发药管理','/dispensingController/list.do',NULL,NULL,1),(45,5,'挂号类别','/registertypeController/list.do',NULL,NULL,1),(46,5,'收费类别','/chargetypeController/list.do',NULL,NULL,1),(47,5,'病人类别','/patienttypeController/list.do',NULL,NULL,1),(48,6,'科室部门','/departmentController/list.do',NULL,NULL,1),(49,6,'职务管理','/attributedetailController/list.do',NULL,NULL,1),(50,6,'员工档案','/employeeController/list.do',NULL,NULL,1),(51,43,'使用单位','/useunitController/list.do',NULL,NULL,1),(52,43,'资源管理','/resourceController/list.do',NULL,NULL,1),(53,43,'角色管理','/roleController/list.do',NULL,NULL,1),(54,6,'角色职务','/roleController/toroleposition.do',NULL,NULL,2),(55,43,'角色职务','/roleController/toroleposition.do',NULL,NULL,1),(56,43,'权限管理','/roleController/tolimit.do',NULL,NULL,1),(57,52,'查询','/resourceController/findresource.do',NULL,NULL,1),(58,52,'新增','/resourceController/add.do',NULL,NULL,1),(59,52,'修改','/resourceController/edit.do',NULL,NULL,1),(60,52,'删除','/resourceController/delete.do',NULL,NULL,1),(61,52,'删除勾选','/resourceController/deletemore.do',NULL,NULL,1),(62,20,'查询','/drugController/datalist.do',NULL,NULL,1),(63,20,'新增','/drugController/toadd.do,/drugController/add.do',NULL,NULL,1),(64,20,'修改','/drugController/toedit.do,/drugController/edit.do',NULL,NULL,1),(65,20,'添加库存','/drugController/addInventoryquantity.do',NULL,NULL,1),(66,20,'库存报损','/drugController/reduceInventoryquantity.do',NULL,NULL,1),(67,20,'删除','/drugController/delete.do',NULL,NULL,1),(68,44,'查询','/dispensingController/datalist.do',NULL,NULL,1),(69,44,'发药','/dispensingController/dispensing.do',NULL,NULL,1),(70,44,'退药','/dispensingController/dispensingout.do',NULL,NULL,1),(71,45,'查询','/registertypeController/datalist.do',NULL,NULL,1),(72,45,'新增','/registertypeController/toadd.do,/registertypeController/add.do',NULL,NULL,1),(73,45,'修改','/registertypeController/toedit.do,/registertypeController/edit.do',NULL,NULL,1),(74,45,'删除','/registertypeController/delete.do',NULL,NULL,1),(75,46,'查询','/chargetypeController/datalist.do',NULL,NULL,1),(76,46,'新增','/chargetypeController/toadd.do,/chargetypeController/add.do',NULL,NULL,1),(77,46,'修改','/chargetypeController/toedit.do,/chargetypeController/edit.do',NULL,NULL,1),(78,46,'删除','/chargetypeController/delete.do',NULL,NULL,1),(79,47,'查询','/patienttypeController/datalist.do',NULL,NULL,1),(80,47,'新增','/patienttypeController/toadd.do,/patienttypeController/add.do',NULL,NULL,1),(81,47,'修改','/patienttypeController/toedit.do,/patienttypeController/edit.do',NULL,NULL,1),(82,47,'删除','/patienttypeController/delete.do',NULL,NULL,1),(83,48,'查询','/departmentController/datalist.do',NULL,NULL,1),(84,48,'新增','/departmentController/toadd.do,/departmentController/add.do',NULL,NULL,1),(85,48,'修改','/departmentController/toedit.do,/departmentController/edit.do',NULL,NULL,1),(86,48,'删除','/departmentController/delete.do',NULL,NULL,1),(87,49,'查询','/attributedetailController/datalist.do',NULL,NULL,1),(88,49,'新增','/attributedetailController/toadd.do,/attributedetailController/add.do',NULL,NULL,1),(89,49,'修改','/attributedetailController/toedit.do,/attributedetailController/edit.do',NULL,NULL,1),(90,49,'删除','/attributedetailController/delete.do',NULL,NULL,1),(91,50,'查询','/employeeController/datalist.do',NULL,NULL,1),(92,50,'详情','',NULL,NULL,2),(93,50,'新增','/employeeController/toadd.do,/employeeController/add.do',NULL,NULL,1),(94,50,'修改','/employeeController/toedit.do,/employeeController/edit.do',NULL,NULL,1),(95,50,'重置密码','/employeeController/resetpsw.do',NULL,NULL,1),(96,51,'编辑','/useunitController/edit.do',NULL,NULL,1),(97,53,'查询','/roleController/datalist.do',NULL,NULL,1),(98,53,'新增','/roleController/toadd.do,/roleController/add.do',NULL,NULL,1),(99,53,'修改','/roleController/toedit.do,/roleController/edit.do',NULL,NULL,1),(100,53,'删除','/roleController/delete.do',NULL,NULL,1),(101,55,'查询角色','/roleController/findrolepositon.do',NULL,NULL,1),(102,55,'查询职务','/roleController/findposition.do',NULL,NULL,1),(103,55,'保存','/roleController/addChild.do',NULL,NULL,1),(104,56,'查询角色','/roleController/findrole.do',NULL,NULL,1),(105,56,'查询资源','/resourceController/findresource.do',NULL,NULL,1),(106,56,'保存','/roleController/addChild.do',NULL,NULL,1),(107,50,'删除','/employeeController/delete.do',NULL,NULL,1);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rolename` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `positionid` varchar(1024) DEFAULT NULL COMMENT '职务id',
  `resourceid` varchar(1024) DEFAULT NULL COMMENT '资源id',
  `note` varchar(128) DEFAULT NULL COMMENT '备注',
  `isvalid` int(11) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`id`,`rolename`,`positionid`,`resourceid`,`note`,`isvalid`) values (1,'管理员','22,23','0,1,8,10,13,19,24,25,2,15,26,27,28,29,21,30,31,32,33,22,34,35,36,37,23,38,39,40,41,3,7,16,42,4,20,62,63,64,65,66,67,44,68,69,70,5,45,71,72,73,74,46,75,76,77,78,47,79,80,81,82,6,48,83,84,85,86,49,87,88,89,90,50,91,93,94,95,107,43,51,96,52,57,58,59,60,61,53,97,98,99,100,55,101,102,103,56,104,105,106','系统管理员',1),(2,'挂号员','154','0,1,8,10,13,19,24,25','医院挂号人员',1),(3,'门诊医生','43,44,45,46,47','0,2,15,26,27,28,29,21,30,31,32,33,22,34,35,36,37,23,38,39,40,41','门诊医生',1),(4,'收费员','153','0,3,7,16,42','医院收费人员',1),(5,'药剂师','116,117,118,119,120','0,4,20,62,63,64,65,66,67,44,68,69,70','负责抓药',1),(6,'护理人员','64,65,66,67,68,69,70,71,72,73,74,75,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,114',NULL,'护士、护工等',1),(7,'测试数据','214,215,216,217,484',NULL,'测试数据',2),(8,'测试数据','212,213,214,215,216,217,485',NULL,'测试数据',2);

/*Table structure for table `supplier` */

DROP TABLE IF EXISTS `supplier`;

CREATE TABLE `supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `suppliercode` varchar(32) DEFAULT NULL COMMENT '供货编号',
  `suppliername` varchar(32) DEFAULT NULL COMMENT '供货商名称',
  `pinyincode` varchar(16) DEFAULT NULL COMMENT '拼音简码',
  `wubicode` varchar(16) DEFAULT NULL COMMENT '五笔简码',
  `isuse` int(11) DEFAULT NULL COMMENT '是否使用',
  `postcode` int(11) DEFAULT NULL COMMENT '邮政编码',
  `supplieraddress` varchar(128) DEFAULT NULL COMMENT '供货商地址',
  `contacts` varchar(16) DEFAULT NULL COMMENT '联系人',
  `tel` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `fax` varchar(11) DEFAULT NULL COMMENT '传真号码',
  `email` varchar(64) DEFAULT NULL COMMENT '电子邮箱',
  `bankid` int(11) DEFAULT NULL COMMENT '开户银行id',
  `bankaccount` varchar(34) DEFAULT NULL COMMENT '银行账号',
  `clearingformid` int(11) DEFAULT NULL COMMENT '结算方式id',
  `regionid` int(11) DEFAULT NULL COMMENT '所属地区id',
  `url` varchar(128) DEFAULT NULL COMMENT '网址',
  `rankid` int(11) DEFAULT NULL COMMENT '供货商级别id',
  `clearingday` int(11) DEFAULT NULL COMMENT '结算期(天)',
  `note` varchar(128) DEFAULT NULL COMMENT '备注',
  `isvalid` int(11) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='供应商';

/*Data for the table `supplier` */

insert  into `supplier`(`id`,`suppliercode`,`suppliername`,`pinyincode`,`wubicode`,`isuse`,`postcode`,`supplieraddress`,`contacts`,`tel`,`fax`,`email`,`bankid`,`bankaccount`,`clearingformid`,`regionid`,`url`,`rankid`,`clearingday`,`note`,`isvalid`) values (1,'GHS65137592','这货是供应商','ZHSGYS',NULL,1,511458,'广州市南沙区','张小山','02082154200','02082154200','45646788@qq.com',262,'45623325648783202132',NULL,NULL,NULL,NULL,NULL,NULL,1);

/*Table structure for table `useunit` */

DROP TABLE IF EXISTS `useunit`;

CREATE TABLE `useunit` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `unitname` varchar(64) DEFAULT NULL COMMENT '单位名称',
  `tel` varchar(11) DEFAULT NULL COMMENT '电话',
  `postcode` int(11) DEFAULT NULL COMMENT '邮政编码',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机',
  `fax` varchar(11) DEFAULT NULL COMMENT '传真',
  `address` varchar(128) DEFAULT NULL COMMENT '地址',
  `bankid` int(11) DEFAULT NULL COMMENT '开户银行id',
  `bankaccount` varchar(34) DEFAULT NULL COMMENT '银行账号',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='使用单位';

/*Data for the table `useunit` */

insert  into `useunit`(`id`,`unitname`,`tel`,`postcode`,`phone`,`fax`,`address`,`bankid`,`bankaccount`,`email`) values (1,'有间医院','4008208820',510000,'13412321234','4008208820','广东省广州市',262,'6214850205906112','123456@qq.com');

/*Table structure for table `viptype` */

DROP TABLE IF EXISTS `viptype`;

CREATE TABLE `viptype` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `typecode` varchar(32) DEFAULT NULL COMMENT '类别编号',
  `typename` varchar(32) DEFAULT NULL COMMENT '类别名称',
  `typediscount` int(11) DEFAULT NULL COMMENT '类别折扣',
  `note` varchar(128) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `viptype` */

insert  into `viptype`(`id`,`typecode`,`typename`,`typediscount`,`note`) values (1,'01','普通卡',100,NULL),(2,'02','银卡',95,NULL),(3,'03','黄金卡',90,NULL),(4,'04','铂金卡',85,NULL),(5,'05','钻石卡',80,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
