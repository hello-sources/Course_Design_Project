/*
MySQL Data Transfer
Source Host: localhost
Source Database: db_heu
Target Host: localhost
Target Database: db_heu
Date: 2019/7/29 8:32:56
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for chistory
-- ----------------------------
CREATE TABLE `chistory` (
  `u_id` int(2) NOT NULL,
  `u_Cgrade` int(3) NOT NULL,
  `u_Cno` int(2) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`u_Cno`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for cpphistory
-- ----------------------------
CREATE TABLE `cpphistory` (
  `u_id` int(2) NOT NULL,
  `u_Cppgrade` int(3) NOT NULL,
  `u_Cppno` int(2) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`u_Cppno`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for javahistory
-- ----------------------------
CREATE TABLE `javahistory` (
  `u_id` int(2) NOT NULL,
  `u_Javagrade` int(3) NOT NULL,
  `u_Javano` int(2) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`u_Javano`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for nethistory
-- ----------------------------
CREATE TABLE `nethistory` (
  `u_id` int(2) NOT NULL,
  `u_Netgrade` int(3) NOT NULL,
  `u_Netno` int(2) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`u_Netno`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for pythonhistory
-- ----------------------------
CREATE TABLE `pythonhistory` (
  `u_id` int(2) NOT NULL,
  `u_Pythongrade` int(3) NOT NULL,
  `u_Pythonno` int(2) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`u_Pythonno`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for t_question
-- ----------------------------
CREATE TABLE `t_question` (
  `q_id` int(4) NOT NULL AUTO_INCREMENT,
  `q_title` varchar(600) NOT NULL,
  `q_level` int(1) NOT NULL,
  `q_options` varchar(600) DEFAULT NULL,
  `q_answer` varchar(600) DEFAULT NULL,
  `q_score` float NOT NULL,
  `t_id` int(1) NOT NULL,
  `s_id` int(2) NOT NULL,
  PRIMARY KEY (`q_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10554 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for t_subject
-- ----------------------------
CREATE TABLE `t_subject` (
  `s_id` int(2) NOT NULL AUTO_INCREMENT,
  `s_name` varchar(20) NOT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=MyISAM AUTO_INCREMENT=106 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for t_type
-- ----------------------------
CREATE TABLE `t_type` (
  `t_id` int(1) NOT NULL AUTO_INCREMENT,
  `t_name` varchar(20) NOT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
CREATE TABLE `t_user` (
  `u_id` int(2) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(8) NOT NULL,
  `u_pwd` varchar(50) NOT NULL,
  `u_realname` varchar(20) NOT NULL,
  `u_phone` varchar(11) NOT NULL,
  `u_role` int(1) NOT NULL DEFAULT '1',
  `u_regdt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `u_mark` varchar(50) DEFAULT NULL,
  `u_Cgrade` int(3) DEFAULT NULL,
  `u_Cppgrade` int(3) DEFAULT NULL,
  `u_Javagrade` int(3) DEFAULT NULL,
  `u_Pythongrade` int(3) DEFAULT NULL,
  `u_Netgrade` int(3) DEFAULT NULL,
  PRIMARY KEY (`u_id`),
  UNIQUE KEY `u_name` (`u_name`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `t_question` VALUES ('10001', '以下叙述中错误的是（）', '2', 'A.使用三种基本结构构成的程序只能解决简单问题；B.结构化程序由顺序、分支、循环三种基本结构组成；C.C语言是一种结构化程序设计语言；D.结构化程序设计提倡模块化的设计方法', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10002', '流程图是描述算法的很好的工具，一般的流程图中由几种基本图形组成。其中输入输出框的图形是（）', '2', 'A.平行四边形；B.长方形；C.椭圆型；D.菱形', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10003', '以下叙述错误的是（）', '2', 'A.同一程序各模块可由一组人员同时进行编写调试，可提高编写程序的效率；B.在进行模块化程序设计的时候，应首先完成每个模块的编写调试，再集中考虑主程序中的算法；C.模块化的程序设计是采用自顶向下、逐步细化的原则；D.程序的每个模块都可通过三种基本结构实现', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10004', '以下选项中叙述正确的是（）', '2', 'A.C程序中的注释可以嵌套；B.C程序中的注释必须在一行完成；C.函数体必须由 { 开始；D.C程序必须由main语句开始', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10005', '以下选项中叙述正确的是（）', '2', 'A.C语言源程序不编译也能直接运行；B.使用N－S流程图不能描述复杂算法；C.计算机能够直接运行C语言源程序，不必进行任何转换；D.结构化程序的三种基本结构是循环结构、选择结构、顺序结构', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10006', '以下选项中叙述正确的是（）', '2', 'A.使用三种基本结构就可以实现任何复杂算法；B.只要程序包含了三种基本结构中的任意一种，就是结构化程序；C.程序语法错误要在运行时才能发现；D.C语言程序不需要包含main()函数', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10007', '以下选项中叙述正确的是（）', '2', 'A.简单算法的操作步骤不能超过20步；B.C程序中的语句要经过编译才能转换成二进制机器指令；C.算法需要包含所有三种基本结构；D.有些算法不能用三种基本结构来表达', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10008', '以下选项中叙述正确的是（）', '2', 'A.全部三种基本结构都包含的才是结构化程序；B.C语言程序可以定义多个不同内容的main函数；C.复杂任务可以分解成简单子任务；D.C语言程序中的所有函数必须保存在同一个源文件中', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10009', '以下叙述中错误的是（）', '2', 'A.书写风格良好的程序易读性好；B.C程序可以在一行上写多条语句；C.C程序允许将一条语句分写在多行上；D.书写风格良好的程序执行效率高', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10010', '结构化程序由顺序、选择、循环三种基本结构组成，以下相关叙述错误的是（）', '2', 'A.三种基本结构不可以嵌套使用；B.顺序结构是按语句在程序中的先后顺序逐条执行，没有分支，没有转移；C.选择结构是根据不同的条件执行不同分支中的语句；D.循环结构是根据条件决定是否重复、重复执行多少次循环体语句', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10011', '以下可以将任意一个两位整数n的个位数与十位数对换的表达式为', '2', 'A.(n-n/10)*10+(n/10)；B.(n-n/10*10)*10+n/10；C.n-n/10*10+n/10；D.n/10+(n-n/10)', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10012', '以下叙述正确的是（）', '2', 'A.计算机可直接接收并运行C源程序；B.计算机可直接接收并运行任意高级语言编写的源程序；C.计算机只接收由0和1代码组成的二进制指令或数据；D.计算机只接收由0和1代码组成的十进制指令或数据', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10013', '以下叙述正确的是（）', '2', 'A.C编译程序把文件后缀为.c的源程序文件编译成文件后缀为.exe的可执行文件；B.C编译程序把文件后缀为.obj的二进制文件编译成文件后缀为.exe的可执行文件；C. 链接程序把文件后缀为.c的源程序文件链接成文件后缀为.exe的可执行文件；D.C编译程序把文件后缀为.c的源程序文件编译成文件后缀为.obj的二进制文件', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10014', '以下叙述正确的是（）', '2', 'A.循环结构、选择结构、顺序结构都是结构化程序的基本结构；B.计算机可以直接执行C语言程序，不需要做任何转换；C.过于复杂的算法不能使用N－S流程图描述；D.只有不超过20步操作步骤的算法才是简单算法', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10015', '以下叙述正确的是（）', '2', 'A.C语言程序可以定义多个不同内容的main函数；B.任何复杂任务都可以分解成简单子任务；C.C语言程序的所有函数只能处于同一个源文件中WEr；D.包含全部三种基本结构的程序才是结构化程序', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10016', '算法应当具有的特性不包括（）', '2', 'A.有穷性；B.确定性；C.美观性；D.可行性', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10017', '下面叙述正确的是（）', '2', 'A.任何算法需要包含三种基本结构中的两种以上；B.复杂算法是不能用三种基本结构来表达的；C.只要是简单算法，它的操作步骤都不会超过20步；D.C语言程序的语句经过编译和链接转换成二进制机器指令后才能执行', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10018', '以下叙述正确的是（）', '2', 'A. 只使用三种基本结构即可解决任何复杂问题；B.C语言程序并不是必须要定义main()函数；C.只要程序包含了任意一种基本结构，就肯定是结构化程序；D.程序中的语法错误只能在运行时才能显现', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10019', '关于程序设计基本概念，以下叙述错误的是（）', '2', 'A.结构化算法可以解决任何复杂的问题；B.计算机可以直接执行由任意高级语言编写的程序；C.高级语言都有与之对应的编译程序或解释程序；D.用于任何一种计算机高级语言都可以把算法转换为程序', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10020', '在源程序的开始处加上#include', '2', 'A.将stdio.h中标准输入输出函数的源程序插入到引用处，以便进行编译链接；B.将stdio.h中标准输入输出函数的源程序插入到引用处，以便进行编译链接；C. stdio.h文件中包含标准输入输出函数的函数说明，通过引用此文件以便能正确使用printf、scanf等函数；D.将stdio.h中标准输入输出函数链接到编译生成的可执行文件中，以便能正确运行', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10021', '以下叙述正确的是（）', '2', 'A. 如果C语言程序实现的算法很简单，则计算机不进行任何代码转换就能执行程序；B.有些算法不能用三种基本结构来表达；C.C语言程序不编译也能直接运行；D.结构化程序的三种基本结构是循环结构、选择结构、顺序结构', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10022', '以下叙述正确的是（）', '2', 'A.通过分解成简单子任务，可以完成任何复杂任务；B.每个结构化程序都要包含全部三种基本结构；C.C语言程序的所有自定义函数只能写在同一个源文件中；D.C语言程序允许使用多个main函数，只要它们的函数体各不相同即可', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10023', '以下叙述正确的是（）', '2', 'A.每个C程序文件都应当包含一个main函数；B.每个C程序都只能有一个main函数；C.C程序由函数组成，可以不包含main函数；D.每个C程序文件中的main函数都应当放在最前面', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10024', '以下叙述错误的是（）', '2', 'A.\"程序\"是人与计算机\"对话\"的语言；B.计算机可以直接识别由0和1组成的机器语言代码；C.计算机可以直接识别由十六进制代码构成的程序；D.可以连续执行的指令的集合称为\"程序\"', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10025', '关于程序模块化，以下叙述错误的是（）', '2', 'A.程序模块化可以提高程序编制的效率；B.程序模块化可以提高程序代码复用率；C.程序模块化可以提高调试程序的效率；D.程序模块化可以提高程序运行的效率', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10026', '以下叙述错误的是（）', '2', 'A.任何能通过编译和运行的算法都一定能得到所期望的结果；B.一个算法所包含的操作步骤应该是有限的；C.算法中每一条指令必须有确切的含义；D.算法可以用各种描述方法来进行描述', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10027', '以下叙述错误的是（）', '2', 'A.采用模块化结构，可以提高程序编制的效率；B.在一个任务中，单独编写的每个模块均可以独立运行；C.程序\"模块化\"有利于任务的分解简；D.允许对函数单独进行编译，是C语言实现\"模块化\"的基础', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10028', '计算机能直接执行的程序是（）', '2', 'A.目标程序；B.汇编程序；C.可执行程序；D.源程序', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10029', '以下选项中关于程序模块化的叙述错误的是（）', '2', 'A.把程序分成若干相对独立、功能单一的模块，可便于重复使用这些模块；B.把程序分成若干相对独立的模块，可便于编码和调试；C.；D.可采用自底向上、逐步细化的设计方法把若干独立模块组装成所要求的程序', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10030', '关于算法，以下叙述中错误的是（）', '2', 'A.任何算法都能转换成计算机高级语言的程序，并在有限时间内运行完毕；B.某个算法可能会没有输入；C.同一个算法对于相同的输入必须得出相同的结果；D.一个算法对于某个输入的循环次数是可以事先估计出来的', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10031', 'C语言程序的模块化通过以下哪个选项来实现（）', '2', 'A.变量；B.函数；C.程序行；D.语句', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10032', '以下不能用于描述算法的是（）', '2', 'A.程序语句；B.伪代码和流程图；C.E-R图；D.文字叙述', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10033', '以下叙述中正确的是（）', '2', 'A.如果算法非常复杂，则需要使用三种基本结构之外的语句结构，才能准确表达；B.只有简单算法才能在有限的操作步骤之后结束；C.程序必须包含所有三种基本结构才能成为一种算法；D.我们所写的每条C语句，经过编译最终都将转换成二进制的机器指令', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10034', '以下叙述中正确的是（）', '2', 'A.在算法设计时，可以把复杂任务分解成一些简单的子任务；B.在C语言程序设计中，所有函数必须保存在一个源文件中；C.只要包含了三种基本结构的算法就是结构化程序；D.结构化程序必须包含所有的三种基本结构，缺一不可', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10035', 'C语言主要是借助以下哪种手段来实现程序模块化（）', '2', 'A.使用三种基本结构语句；B.定义函数；C.定义常量和外部变量；D.使用丰富的数据类型', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10036', '关于程序模块化，以下叙述错误的是（）', '2', 'A.程序模块化可以提高程序代码复用率；B.程序模块化可以提高调试程序的效率；C.程序模块化可以提高程序运行的效率；D.程序模块化可以提高程序编制的效率', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10037', '以下叙述中错误的是（）', '2', 'A.C程序经过编译、连接步骤之后才能形成一个真正可执行的二进制机器指令文件；B.用C语言编写的程序称为源程序，它以ASCII代码形式存放在一个文本文件中；C.C语言源程序经编译后生成后缀为.obj的目标程序；D.C语言中的每条可执行语句和非执行语句最终都将被转换成二进制的机器指令', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10038', '以下叙述中错误的是（）', '2', 'A.一个C语言程序只能实现一种算法；B.C程序可以由一个或多个函数组成；C.一个C函数可以单独作为一个C程序文件存在；D.C程序可以由多个程序文件组成', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10039', '以下四个程序中，完全正确的是（）', '2', 'A.#include main()；{/*/ programming /*/ printf(\"programming！\n\")；}；B.#include main() {/* programming */ printf(\"programming！\n\")； }；C.#include main() {/*/* programming */*/ printf(\"programming！\n\")； }；D.include main() {/* programming */ printf(\"programming！\n\")； }', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10040', '以下叙述中错误的是（）', '2', 'A.有穷性；B.确定性；C.stdio；D.可行性', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10041', '以下叙述中错误的是（）', '2', 'A.算法正确的程序可以有零个输入；B.算法正确的程序最终一定会结束；C.算法正确的程序可以有零个输出；D.算法正确的程序对于相同的输入一定有相同的结果', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10042', '一个C程序的执行是从( )', '2', 'A.本程序文件的第一个函数开始,到本程序main函数结束；B.本程序文件的第一个函数开始,到本程序文件的最后一个函数结束；C.本程序的main函数开始,到本程序文件的最后一个函数结束；D.本程序的main函数开始,到main函数结束', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10043', '若有定义:int a = 7; float x = 2.5 , y = 4.7 ;则表达式 x + a % 3 * (int) (x + y) % 2/4 的值是( )', '2', 'A.2.500000；B.2.750000；C.0.00000；D.3.500000', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10044', '有如下的变量定义语句:\"int x=10, *p;\",如果想使*p的值是10,应当执行的语句是( )', '2', 'A.p=x；B.p=&x；C.p=10；D.p=*x', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10045', '已知x为int类型变量,则语句\"if (0<=x<=1) printf(\"Y\"); else printf(\"N\");\"执行后的输出结果是( )', '2', 'A.语法错误；B.不确定；C.Y；D.N', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10046', '设x , y和z是int型变量,且x = 3, y = 4 , z = 5 则下面表达式中值为0的是 ( )', '2', 'A.‘x‘ && ‘y’；B.x || y+z && y - z；C.x <= y；D.!((x < y )&&!z || 1)', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10047', '以下程序段 :x = -1; do {x = x*x ; } while (! x);', '2', 'A.循环执行一次；B.循环执行二次；C.有语法错误；D.是死循环', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10048', '已知x为int类型变量,则语句\"for(x=1;x>=10;x--);\"执行后,变量x的值是( )', '2', 'A.0；B.1；C.10；D.11', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10049', '下列程序段的输出结果是( )。\nchar c,k;\nc=‘b’;\nk=4;\nswitch(c)\n{case‘a’: k=1;\ncase’b‘: k=2;\ncase’c‘: k=3;\n}', '2', 'A.1；B.2；C.3；D.4', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10050', '定义语句为\"char a[10];\",执行下列语句后的输出结果为( )', '2', 'A.7,8；B.7,7；C.10,8；D.10,7', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10051', '以下程序运行后的输出结果是( )。\n#include <stdio.h>\nmain()\n{\nint i, j, x = 0;\nfor (i=0; i<2; i++)\n{\nx++;\nfor (j=0; j<3; j++)\n{\nif (j % 2) break;\nx++;\n}\nx++;\n}\nprintf(\"x=%d\n\",x);', '2', 'A.x=6；B.x=8；C.x=10；D.x=4', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10052', '有如下数组定义语句\"int a[2][3]={1,2,3,4,5,6};\",则*(*(a+1)+2)的值是( )', '2', 'A.2；B.6；C.元素2的地址；D.元素6的地址', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10053', '执行下面程序后的输出结果为( )。 \n#define M(x,y) x/y \nprintf(\"%d \", M(10, 2+3) );', '2', 'A.2；B.2.0；C.8；D.5', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10054', '设有以下程序段,则对字符串\"ZheJiang\"的引用方式错误的是( )。\nstruct site\n{\nchar name[20];\nint no;\nfloat grade;', '2', 'A.(*ps).name；B.ps->name；C.s1.name；D.ps.name', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10055', '下列程序段的输出结果是( )。\nint k, s;\nfor(k=0,s=0;k<10;k++,s--)\nif(s>k) break;\nelse s+=k;', '2', 'A.(6.9)；B.(4,6)；C.(4,5)；D.不是A.B.C', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10056', '下面程序的输出结果为( )。\nvoid main()\n{ char *p;\nchar s[]= \"ABCD\";\nfor(p=s;p<s+4;p++) printf(\"%s\n\",p);', '2', 'A.ABCD;ABC;AB;A；B.ABCD;BCD;CD;D；C.A;B;C;D；D.D;C;B;A', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10057', '已知int x=10,y=20,z=30;语句if(x>y) z=x; x=y; y=z;执行之后x,y,z的值是( )', '2', 'A.x=20,y=30,z=10；B.x=20,y=30,z=20；C.x=20,y=30,z=30；D.x=10,y=20,z=30', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10058', '根据以下程序,输出的结果是( )。\nvoid main()\n{ int x=4;\ndo{\nprintf(\"%d\n\",x-=3);\n}while(!(--x));', '2', 'A.死循环；B.1；C.1和0；D.1和-3', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10059', '函数f的原型说明为\"void f(int x[], int n);\",有如下定义语句:\"int a[10], m;\",则下列函数调用正确的是( )', '2', 'A.f(a,m)；B.m=f(a)；C.f(int a[10], int m)；D.m=f(a[10],m)', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10060', '有以下程序执行后的输出结果是( )。\n#include <stdio.h>\nvoid main( )\n{  int x=0,y=5,z=3;\nwhile(z-->0&&++x<5)    y=y-1;\nprintf(\"%d,%d,%d\n\",x,y,z);', '2', 'A.3,2,0；B.3,2,-1；C.4,3,-1；D.5,-2,-5', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10061', '判断变量a和b都不等于0的表达式是( )', '2', 'A.(a!=0)||(b!=0)；B.!(a=0)&&(b!=0)；C.a && b；D.a||b', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10062', '在C语言中,不正确的int类型的常数是()', '2', 'A.0；B.037；C.0xAF；D.32768', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10063', '在以下一组运算符中,优先级最高的运算符是()', '2', 'A.<=；B.=；C.%；D.&&', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10064', '表示关系x<=y<=z的c语言表达式为()', '2', 'A.(X<=Y)AND(Y<=Z)；B.(X<=Y)&&(Y<=Z)；C.(X<=Y<=Z)；D.(X<=Y)&(Y<=Z)', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10065', '设x和y均为int型变量,则以下语句:x+=y;y=x-y;x-=y;的功能是()', '2', 'A.把x和y按从大到小排列；B.把x和y按从小到大排列；C.交换x和y中的值；D.无确定结果', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10066', '在下列选项中,不正确的赋值表达式是()', '2', 'A.++t；B.k=i==j；C.n1=(n2=(n3=0))；D.a=b+c=1', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10067', '以下选项中合法的用户标识符是()', '2', 'A._2Test；B.3Dmax；C.long；D.A.dat', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10068', '以下选项中属于C语言的数据类型是()', '2', 'A.复数型；B.双精度型；C.逻辑型；D.集合型', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10069', '以下程序的输出结果是() main( )\n{\nint k=17;\nprintf(\"%d,%o,%x \n\",k,k,k); \n}', '2', 'A.17,17,17；B.17,021,0x11；C.17,21,11；D.17,0x11,021', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10070', '已有定义:int x=3,y=4,z=5;,则表达式!(x+y)+z-1&&y+z/2的值是()', '2', 'A.6；B.0；C.2；D.1', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10071', '设有定义:long x=-123456L;,则以下能够正确输出变量x值的语句是()', '2', 'A.printf(\"x=%ld\n\",x)；B.printf(\"x=%d\n\",x)；C.printf(\"x=%8dL\n\",x)；D.printf(\"x=%LD\n\",x)', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10072', '设x、y、z和k都是int型变量,则执行表达式x=(y=4,z=16,k=32)后,x的值为()', '2', 'A.16；B.32；C.64；D.4', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10073', '设a和b均为double型常量,且a=5.5、b=2.5,则表达式(int)a+b/b的值是()', '2', 'A.6；B.5.500000；C.6.000000；D.6.500000', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10074', '若有以下定义和语句\nchar c1=‘b’,c2=‘e’;\nprintf(\"%d,%c\n\",c2-c1,c2-’a‘+’A‘);则输出结果是()', '2', 'A.输出项与对应的格式控制不一致,输出结果不确定；B.2,M；C.2,E；D.3,E', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10075', '有以下程序\n#include \nmain()\n{ int a,b,c=246;\na=c/100%9;\nb=(-1)&&(-1);\nprintf(\"%d,%d\n\",a,b);}\n输出结果是（）', '2', 'A.2,1；B.3,2；C.4,3；D.2,-1', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10076', '下列说法中正确的是()', '2', 'A.C语言程序中，要调用的函数必须在main()函数中定义；B.C语言程序总是从main()函数开始执行；C.C语言程序中的main()函数必须放在程序的开始部分；D.C语言程序总是从第一个定义的函数开始执行', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10077', '以下叙述中错误的是（）', '2', 'A.C 语句必须以分号结束；B.复合语句在语法上被看作一条语句；C.空语句出现在任何位置都不会影响程序运行；D.赋值表达式末尾加分号就构成赋值语句', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10078', '有如下程序,该程序的执行结果是()\nmain()\n{ int i,sum;\nfor(i=1;i<=3;sum++) sum+=i;\nprintf(\"%d\n\",sum);}', '2', 'A.死循环；B.0；C.3；D.6', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10079', '有以下程序, 程序运行后的输出结果是()\nmain()\n{ int i,sum;\nfor(i=1;i<=3;sum++) sum+=i;\nprintf(\"%d\n\",sum);}', '2', 'A.3,3；B.2,2；C.1,1；D.4,4', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10080', '有以下程序,程序执行后的输出结果是()\nmain( )\n{ int i,s=0;\nfor(i=1;i<10;i+=2) s+=i+1;\nprintf(\"%d\n\",s);}', '2', 'A.自然数1~9中的奇数之和；B.自然数1~10中的偶数之和；C.自然数1~9的累加和；D.自然数1~10的累加和', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10081', '运行以下程序后,如果从键盘上输入65 14<回车>,则输出结果为()\nmain( )\n{int m，n;\nscanf(\"%d%d\"，&m，&n);\nwhile(m!=n)\n{ while(m>n) m-=n;\nwhile(n>m) n-=m;}\nprintf(\"m=%d\n\"，m);}', '2', 'A.m=0；B.m=1；C.m=2；D.m=3', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10082', '一个C语言程序的执行是从 ( )', '2', 'A.本程序文件的第一个函数开始，到本程序文件的最后一个函数结束；B.本程序文件的第一个函数开始，到本程序的main函数结束；C.本程序的main函数开始，到本程序的main函数结束；D.本程序的main函数开始，到本程序文件的最后一个函数结束', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10083', '以下叙述中错误的是（）', '2', 'A.C程序书写格式比较自由，一个语句可以分别写在多行上；B.函数是C程序的基本单位；C.在C语言程序中，规定每条语句以分号（；）结束；D.在C程序中，注释说明只能位于一条语句的后面', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10084', '在C语言中，源程序的扩展名是 ( )', '2', 'A..c；B..obj；C..exe；D..dsp', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10085', 'C语言中的标识符只能由字母、数字和下划线3种字符组成，且第一个字符 ( )', '2', 'A.可以是是3种中的任一种字符；B.必须是字母或下划线；C.必须是数字；D.必须是字母', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10086', '下列几组选项中，均为不合法的用户自定义标识符是 ( )', '2', 'A.Pi do _001；B.For C1 _456；C.1ab m-n char；D.include s*T Cbook', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10087', '下列几组选项中，均为合法的关键字是 ( )', '2', 'A.dafault short main；B.break float swtich；C.Case while printf；D.return int for', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10088', '下列语句中，正确的是 ( )', '2', 'A.char ch1；B.#define PI3.14；C.int a=3；b=4；D.float a', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10089', '在C语言中，int、char和short三种类型数据所占用的内存是 ( )', '2', 'A.由用户自己定义；B.由所用机器的机器字长决定；C.是任意的；D.分别为4、1和2个字节', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10090', '以下选项中，属于C语言的基本数据类型是 ( )', '2', 'A.复合型；B.逻辑型；C.双精度型；D.集合型', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10091', '在C语言中，整型数据和字符型数据在内存中的存储形式分别是 ( )', '2', 'A.原码 原码；B.补码 反码；C.ASCII码 原码；D.补码 ASCII码', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10092', '在C语言中，合法的长整型常量是 ( )', '2', 'A.0L；B.4962710；C.0.054157892；D.2.1578e5', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10093', '下列选项中，均是合法的整型常量是 ( )', '2', 'A.0Xaff -100 018；B.870 0x123 -017；C.12,430 0X 10b；D.0xcdg 199 012459', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10094', '下列选项中，均是合法的实型常量是 ( )', '2', 'A.70 .02 5e；B.1.2e-5.2 07E2 E-3；C.300. -8E9 8.0e-2；D.07e5 +2E+3 0.0', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10095', '下列选项中，不是合法的字符常量是 ( )', '2', 'A.‘/‘’’；B.‘=’；C.’？‘；D.\"a\"', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10096', '已知大写字母A的ASCII码为65，小写字母a的ASCII码为97，则字符常量’101’是( )', '2', 'A.A；B.a；C.B；D.无此常量', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10097', '以下选项中，合法的一组C语言数值常量是 ()', '2', 'A.0x8A　 10,000　 3.e5；B.12.　 0Xa23　 4.5e0；C.177　 4e1.5　 0abc；D.028　 .5e－3　 －0xf', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10098', '在下列的C语言常量中，错误的是 ( )', '2', 'A.0XFE；B.9L；C.5.2e0.9；D.‘x75’', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10099', '在C语言中符号常量是由宏定义\"#define\"来定义的常量，以下叙述中正确的是 ( )', '2', 'A.符号常量的符号名是标识符，但必须大写；B.符号常量的符号名必须是常量；C.符号常量在整个程序中其值都不能再被重新定义；D.符号常量是指在程序中通过宏定义用一个符号名来代表一个常量', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10100', '关于C语言的变量名，以下叙述正确的是 ( )', '2', 'A.变量名不可以与关键字同名；B.变量名不可以与预定义标识符同名；C.变量名必须以字母开头；D.变量存储是没有限制的', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10101', '在下列选项中，正确的变量定义是 ( )', '2', 'A.float a=b=10.2；B.int a=10；C.char case；D.double x=0.123,x=12.3', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10102', '以下叙述中错误的是（）', '2', 'A.使用三种基本结构构成的程序只能解决简单问题；B.结构化程序由顺序、分支、循环三种基本结构组成；C.C语言是一种结构化程序设计语言；D.结构化程序设计提倡模块化的设计方法', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10103', '流程图是描述算法的很好的工具，一般的流程图中由几种基本图形组成。其中输入输出框的图形是（）', '2', 'A.平行四边形；B.长方形；C.椭圆型；D.菱形', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10104', '以下叙述错误的是（）', '2', 'A.同一程序各模块可由一组人员同时进行编写调试，可提高编写程序的效率；B.在进行模块化程序设计的时候，应首先完成每个模块的编写调试，再集中考虑主程序中的算法；C.模块化的程序设计是采用自顶向下、逐步细化的原则；D.程序的每个模块都可通过三种基本结构实现', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10105', '以下选项中叙述正确的是（）', '2', 'A.C程序中的注释可以嵌套；B.C程序中的注释必须在一行完成；C.函数体必须由 { 开始；D.C程序必须由main语句开始', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10106', '以下选项中叙述正确的是（）', '2', 'A.C语言源程序不编译也能直接运行；B.使用N－S流程图不能描述复杂算法；C.计算机能够直接运行C语言源程序，不必进行任何转换；D.结构化程序的三种基本结构是循环结构、选择结构、顺序结构', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10107', '以下选项中叙述正确的是（）', '2', 'A.使用三种基本结构就可以实现任何复杂算法；B.只要程序包含了三种基本结构中的任意一种，就是结构化程序；C.程序语法错误要在运行时才能发现；D.C语言程序不需要包含main()函数', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10108', '以下选项中叙述正确的是（）', '2', 'A.简单算法的操作步骤不能超过20步；B.C程序中的语句要经过编译才能转换成二进制机器指令；C.算法需要包含所有三种基本结构；D.有些算法不能用三种基本结构来表达', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10109', '以下选项中叙述正确的是（）', '2', 'A.全部三种基本结构都包含的才是结构化程序；B.C语言程序可以定义多个不同内容的main函数；C.复杂任务可以分解成简单子任务；D.C语言程序中的所有函数必须保存在同一个源文件中', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10110', '以下叙述中错误的是（）', '2', 'A.书写风格良好的程序易读性好；B.C程序可以在一行上写多条语句；C.C程序允许将一条语句分写在多行上；D.书写风格良好的程序执行效率高', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10111', '结构化程序由顺序、选择、循环三种基本结构组成，以下相关叙述错误的是（）', '2', 'A.三种基本结构不可以嵌套使用；B.顺序结构是按语句在程序中的先后顺序逐条执行，没有分支，没有转移；C.选择结构是根据不同的条件执行不同分支中的语句；D.循环结构是根据条件决定是否重复、重复执行多少次循环体语句', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10112', '以下可以将任意一个两位整数n的个位数与十位数对换的表达式为', '2', 'A.(n-n/10)*10+(n/10)；B.(n-n/10*10)*10+n/10；C.n-n/10*10+n/10；D.n/10+(n-n/10)', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10113', '以下叙述正确的是（）', '2', 'A.计算机可直接接收并运行C源程序；B.计算机可直接接收并运行任意高级语言编写的源程序；C.计算机只接收由0和1代码组成的二进制指令或数据；D.计算机只接收由0和1代码组成的十进制指令或数据', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10114', '以下叙述正确的是（）', '2', 'A.C编译程序把文件后缀为.c的源程序文件编译成文件后缀为.exe的可执行文件；B.C编译程序把文件后缀为.obj的二进制文件编译成文件后缀为.exe的可执行文件；C. 链接程序把文件后缀为.c的源程序文件链接成文件后缀为.exe的可执行文件；D.C编译程序把文件后缀为.c的源程序文件编译成文件后缀为.obj的二进制文件', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10115', '以下叙述正确的是（）', '2', 'A.循环结构、选择结构、顺序结构都是结构化程序的基本结构；B.计算机可以直接执行C语言程序，不需要做任何转换；C.过于复杂的算法不能使用N－S流程图描述；D.只有不超过20步操作步骤的算法才是简单算法', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10116', '以下叙述正确的是（）', '2', 'A.C语言程序可以定义多个不同内容的main函数；B.任何复杂任务都可以分解成简单子任务；C.C语言程序的所有函数只能处于同一个源文件中WEr；D.包含全部三种基本结构的程序才是结构化程序', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10117', '算法应当具有的特性不包括（）', '2', 'A.有穷性；B.确定性；C.美观性；D.可行性', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10118', '下面叙述正确的是（）', '2', 'A.任何算法需要包含三种基本结构中的两种以上；B.复杂算法是不能用三种基本结构来表达的；C.只要是简单算法，它的操作步骤都不会超过20步；D.C语言程序的语句经过编译和链接转换成二进制机器指令后才能执行', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10119', '以下叙述正确的是（）', '2', 'A. 只使用三种基本结构即可解决任何复杂问题；B.C语言程序并不是必须要定义main()函数；C.只要程序包含了任意一种基本结构，就肯定是结构化程序；D.程序中的语法错误只能在运行时才能显现', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10120', '关于程序设计基本概念，以下叙述错误的是（）', '2', 'A.结构化算法可以解决任何复杂的问题；B.计算机可以直接执行由任意高级语言编写的程序；C.高级语言都有与之对应的编译程序或解释程序；D.用于任何一种计算机高级语言都可以把算法转换为程序', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10121', '在源程序的开始处加上#include', '2', 'A.将stdio.h中标准输入输出函数的源程序插入到引用处，以便进行编译链接；B.将stdio.h中标准输入输出函数的源程序插入到引用处，以便进行编译链接；C. stdio.h文件中包含标准输入输出函数的函数说明，通过引用此文件以便能正确使用printf、scanf等函数；D.将stdio.h中标准输入输出函数链接到编译生成的可执行文件中，以便能正确运行', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10122', '以下叙述正确的是（）', '2', 'A. 如果C语言程序实现的算法很简单，则计算机不进行任何代码转换就能执行程序；B.有些算法不能用三种基本结构来表达；C.C语言程序不编译也能直接运行；D.结构化程序的三种基本结构是循环结构、选择结构、顺序结构', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10123', '以下叙述正确的是（）', '2', 'A.通过分解成简单子任务，可以完成任何复杂任务；B.每个结构化程序都要包含全部三种基本结构；C.C语言程序的所有自定义函数只能写在同一个源文件中；D.C语言程序允许使用多个main函数，只要它们的函数体各不相同即可', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10124', '以下叙述正确的是（）', '2', 'A.每个C程序文件都应当包含一个main函数；B.每个C程序都只能有一个main函数；C.C程序由函数组成，可以不包含main函数；D.每个C程序文件中的main函数都应当放在最前面', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10125', '以下叙述错误的是（）', '2', 'A.\"程序\"是人与计算机\"对话\"的语言；B.计算机可以直接识别由0和1组成的机器语言代码；C.计算机可以直接识别由十六进制代码构成的程序；D.可以连续执行的指令的集合称为\"程序\"', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10126', '关于程序模块化，以下叙述错误的是（）', '2', 'A.程序模块化可以提高程序编制的效率；B.程序模块化可以提高程序代码复用率；C.程序模块化可以提高调试程序的效率；D.程序模块化可以提高程序运行的效率', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10127', '以下叙述错误的是（）', '2', 'A.任何能通过编译和运行的算法都一定能得到所期望的结果；B.一个算法所包含的操作步骤应该是有限的；C.算法中每一条指令必须有确切的含义；D.算法可以用各种描述方法来进行描述', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10128', '以下叙述错误的是（）', '2', 'A.采用模块化结构，可以提高程序编制的效率；B.在一个任务中，单独编写的每个模块均可以独立运行；C.程序\"模块化\"有利于任务的分解简；D.允许对函数单独进行编译，是C语言实现\"模块化\"的基础', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10129', '计算机能直接执行的程序是（）', '2', 'A.目标程序；B.汇编程序；C.可执行程序；D.源程序', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10130', '以下选项中关于程序模块化的叙述错误的是（）', '2', 'A.把程序分成若干相对独立、功能单一的模块，可便于重复使用这些模块；B.把程序分成若干相对独立的模块，可便于编码和调试；C.；D.可采用自底向上、逐步细化的设计方法把若干独立模块组装成所要求的程序', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10131', '关于算法，以下叙述中错误的是（）', '2', 'A.任何算法都能转换成计算机高级语言的程序，并在有限时间内运行完毕；B.某个算法可能会没有输入；C.同一个算法对于相同的输入必须得出相同的结果；D.一个算法对于某个输入的循环次数是可以事先估计出来的', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10132', 'C语言程序的模块化通过以下哪个选项来实现（）', '2', 'A.变量；B.函数；C.程序行；D.语句', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10133', '以下不能用于描述算法的是（）', '2', 'A.程序语句；B.伪代码和流程图；C.E-R图；D.文字叙述', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10134', '以下叙述中正确的是（）', '2', 'A.如果算法非常复杂，则需要使用三种基本结构之外的语句结构，才能准确表达；B.只有简单算法才能在有限的操作步骤之后结束；C.程序必须包含所有三种基本结构才能成为一种算法；D.我们所写的每条C语句，经过编译最终都将转换成二进制的机器指令', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10135', '以下叙述中正确的是（）', '2', 'A.在算法设计时，可以把复杂任务分解成一些简单的子任务；B.在C语言程序设计中，所有函数必须保存在一个源文件中；C.只要包含了三种基本结构的算法就是结构化程序；D.结构化程序必须包含所有的三种基本结构，缺一不可', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10136', 'C语言主要是借助以下哪种手段来实现程序模块化（）', '2', 'A.使用三种基本结构语句；B.定义函数；C.定义常量和外部变量；D.使用丰富的数据类型', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10137', '关于程序模块化，以下叙述错误的是（）', '2', 'A.程序模块化可以提高程序代码复用率；B.程序模块化可以提高调试程序的效率；C.程序模块化可以提高程序运行的效率；D.程序模块化可以提高程序编制的效率', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10138', '以下叙述中错误的是（）', '2', 'A.C程序经过编译、连接步骤之后才能形成一个真正可执行的二进制机器指令文件；B.用C语言编写的程序称为源程序，它以ASCII代码形式存放在一个文本文件中；C.C语言源程序经编译后生成后缀为.obj的目标程序；D.C语言中的每条可执行语句和非执行语句最终都将被转换成二进制的机器指令', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10139', '以下叙述中错误的是（）', '2', 'A.一个C语言程序只能实现一种算法；B.C程序可以由一个或多个函数组成；C.一个C函数可以单独作为一个C程序文件存在；D.C程序可以由多个程序文件组成', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10140', '以下四个程序中，完全正确的是（）', '2', 'A.#include main()；{/*/ programming /*/ printf(\"programming！\n\")；}；B.#include main() {/* programming */ printf(\"programming！\n\")； }；C.#include main() {/*/* programming */*/ printf(\"programming！\n\")； }；D.include main() {/* programming */ printf(\"programming！\n\")； }', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10141', '以下叙述中错误的是（）', '2', 'A.有穷性；B.确定性；C.stdio；D.可行性', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10142', '以下叙述中错误的是（）', '2', 'A.算法正确的程序可以有零个输入；B.算法正确的程序最终一定会结束；C.算法正确的程序可以有零个输出；D.算法正确的程序对于相同的输入一定有相同的结果', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10143', '一个C程序的执行是从( )', '2', 'A.本程序文件的第一个函数开始,到本程序main函数结束；B.本程序文件的第一个函数开始,到本程序文件的最后一个函数结束；C.本程序的main函数开始,到本程序文件的最后一个函数结束；D.本程序的main函数开始,到main函数结束', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10144', '若有定义:int a = 7; float x = 2.5 , y = 4.7 ;则表达式 x + a % 3 * (int) (x + y) % 2/4 的值是( )', '2', 'A.2.500000；B.2.750000；C.0.00000；D.3.500000', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10145', '有如下的变量定义语句:\"int x=10, *p;\",如果想使*p的值是10,应当执行的语句是( )', '2', 'A.p=x；B.p=&x；C.p=10；D.p=*x', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10146', '已知x为int类型变量,则语句\"if (0<=x<=1) printf(\"Y\"); else printf(\"N\");\"执行后的输出结果是( )', '2', 'A.语法错误；B.不确定；C.Y；D.N', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10147', '设x , y和z是int型变量,且x = 3, y = 4 , z = 5 则下面表达式中值为0的是 ( )', '2', 'A.‘x‘ && ‘y’；B.x || y+z && y - z；C.x <= y；D.!((x < y )&&!z || 1)', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10148', '以下程序段 :x = -1; do {x = x*x ; } while (! x);', '2', 'A.循环执行一次；B.循环执行二次；C.有语法错误；D.是死循环', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10149', '已知x为int类型变量,则语句\"for(x=1;x>=10;x--);\"执行后,变量x的值是( )', '2', 'A.0；B.1；C.10；D.11', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10150', '下列程序段的输出结果是( )。\nchar c,k;\nc=‘b’;\nk=4;\nswitch(c)\n{case‘a’: k=1;\ncase’b‘: k=2;\ncase’c‘: k=3;\n}', '2', 'A.1；B.2；C.3；D.4', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10151', '定义语句为\"char a[10];\",执行下列语句后的输出结果为( )', '2', 'A.7,8；B.7,7；C.10,8；D.10,7', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10152', '以下程序运行后的输出结果是( )。\n#include <stdio.h>\nmain()\n{\nint i, j, x = 0;\nfor (i=0; i<2; i++)\n{\nx++;\nfor (j=0; j<3; j++)\n{\nif (j % 2) break;\nx++;\n}\nx++;\n}\nprintf(\"x=%d\n\",x);', '2', 'A.x=6；B.x=8；C.x=10；D.x=4', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10153', '有如下数组定义语句\"int a[2][3]={1,2,3,4,5,6};\",则*(*(a+1)+2)的值是( )', '2', 'A.2；B.6；C.元素2的地址；D.元素6的地址', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10154', '执行下面程序后的输出结果为( )。 \n#define M(x,y) x/y \nprintf(\"%d \", M(10, 2+3) );', '2', 'A.2；B.2.0；C.8；D.5', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10155', '设有以下程序段,则对字符串\"ZheJiang\"的引用方式错误的是( )。\nstruct site\n{\nchar name[20];\nint no;\nfloat grade;', '2', 'A.(*ps).name；B.ps->name；C.s1.name；D.ps.name', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10156', '下列程序段的输出结果是( )。\nint k, s;\nfor(k=0,s=0;k<10;k++,s--)\nif(s>k) break;\nelse s+=k;', '2', 'A.(6.9)；B.(4,6)；C.(4,5)；D.不是A.B.C', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10157', '下面程序的输出结果为( )。\nvoid main()\n{ char *p;\nchar s[]= \"ABCD\";\nfor(p=s;p<s+4;p++) printf(\"%s\n\",p);', '2', 'A.ABCD;ABC;AB;A；B.ABCD;BCD;CD;D；C.A;B;C;D；D.D;C;B;A', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10158', '已知int x=10,y=20,z=30;语句if(x>y) z=x; x=y; y=z;执行之后x,y,z的值是( )', '2', 'A.x=20,y=30,z=10；B.x=20,y=30,z=20；C.x=20,y=30,z=30；D.x=10,y=20,z=30', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10159', '根据以下程序,输出的结果是( )。\nvoid main()\n{ int x=4;\ndo{\nprintf(\"%d\n\",x-=3);\n}while(!(--x));', '2', 'A.死循环；B.1；C.1和0；D.1和-3', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10160', '函数f的原型说明为\"void f(int x[], int n);\",有如下定义语句:\"int a[10], m;\",则下列函数调用正确的是( )', '2', 'A.f(a,m)；B.m=f(a)；C.f(int a[10], int m)；D.m=f(a[10],m)', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10161', '有以下程序执行后的输出结果是( )。\n#include <stdio.h>\nvoid main( )\n{  int x=0,y=5,z=3;\nwhile(z-->0&&++x<5)    y=y-1;\nprintf(\"%d,%d,%d\n\",x,y,z);', '2', 'A.3,2,0；B.3,2,-1；C.4,3,-1；D.5,-2,-5', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10162', '判断变量a和b都不等于0的表达式是( )', '2', 'A.(a!=0)||(b!=0)；B.!(a=0)&&(b!=0)；C.a && b；D.a||b', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10163', '在C语言中,不正确的int类型的常数是()', '2', 'A.0；B.037；C.0xAF；D.32768', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10164', '在以下一组运算符中,优先级最高的运算符是()', '2', 'A.<=；B.=；C.%；D.&&', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10165', '表示关系x<=y<=z的c语言表达式为()', '2', 'A.(X<=Y)AND(Y<=Z)；B.(X<=Y)&&(Y<=Z)；C.(X<=Y<=Z)；D.(X<=Y)&(Y<=Z)', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10166', '设x和y均为int型变量,则以下语句:x+=y;y=x-y;x-=y;的功能是()', '2', 'A.把x和y按从大到小排列；B.把x和y按从小到大排列；C.交换x和y中的值；D.无确定结果', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10167', '在下列选项中,不正确的赋值表达式是()', '2', 'A.++t；B.k=i==j；C.n1=(n2=(n3=0))；D.a=b+c=1', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10168', '以下选项中合法的用户标识符是()', '2', 'A._2Test；B.3Dmax；C.long；D.A.dat', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10169', '以下选项中属于C语言的数据类型是()', '2', 'A.复数型；B.双精度型；C.逻辑型；D.集合型', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10170', '以下程序的输出结果是() main( )\n{\nint k=17;\nprintf(\"%d,%o,%x \n\",k,k,k); \n}', '2', 'A.17,17,17；B.17,021,0x11；C.17,21,11；D.17,0x11,021', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10171', '已有定义:int x=3,y=4,z=5;,则表达式!(x+y)+z-1&&y+z/2的值是()', '2', 'A.6；B.0；C.2；D.1', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10172', '设有定义:long x=-123456L;,则以下能够正确输出变量x值的语句是()', '2', 'A.printf(\"x=%ld\n\",x)；B.printf(\"x=%d\n\",x)；C.printf(\"x=%8dL\n\",x)；D.printf(\"x=%LD\n\",x)', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10173', '设x、y、z和k都是int型变量,则执行表达式x=(y=4,z=16,k=32)后,x的值为()', '2', 'A.16；B.32；C.64；D.4', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10174', '设a和b均为double型常量,且a=5.5、b=2.5,则表达式(int)a+b/b的值是()', '2', 'A.6；B.5.500000；C.6.000000；D.6.500000', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10175', '若有以下定义和语句\nchar c1=‘b’,c2=‘e’;\nprintf(\"%d,%c\n\",c2-c1,c2-’a‘+’A‘);则输出结果是()', '2', 'A.输出项与对应的格式控制不一致,输出结果不确定；B.2,M；C.2,E；D.3,E', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10176', '有以下程序\n#include \nmain()\n{ int a,b,c=246;\na=c/100%9;\nb=(-1)&&(-1);\nprintf(\"%d,%d\n\",a,b);}\n输出结果是（）', '2', 'A.2,1；B.3,2；C.4,3；D.2,-1', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10177', '下列说法中正确的是()', '2', 'A.C语言程序中，要调用的函数必须在main()函数中定义；B.C语言程序总是从main()函数开始执行；C.C语言程序中的main()函数必须放在程序的开始部分；D.C语言程序总是从第一个定义的函数开始执行', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10178', '以下叙述中错误的是（）', '2', 'A.C 语句必须以分号结束；B.复合语句在语法上被看作一条语句；C.空语句出现在任何位置都不会影响程序运行；D.赋值表达式末尾加分号就构成赋值语句', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10179', '有如下程序,该程序的执行结果是()\nmain()\n{ int i,sum;\nfor(i=1;i<=3;sum++) sum+=i;\nprintf(\"%d\n\",sum);}', '2', 'A.死循环；B.0；C.3；D.6', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10180', '有以下程序, 程序运行后的输出结果是()\nmain()\n{ int i,sum;\nfor(i=1;i<=3;sum++) sum+=i;\nprintf(\"%d\n\",sum);}', '2', 'A.3,3；B.2,2；C.1,1；D.4,4', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10181', '有以下程序,程序执行后的输出结果是()\nmain( )\n{ int i,s=0;\nfor(i=1;i<10;i+=2) s+=i+1;\nprintf(\"%d\n\",s);}', '2', 'A.自然数1~9中的奇数之和；B.自然数1~10中的偶数之和；C.自然数1~9的累加和；D.自然数1~10的累加和', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10182', '运行以下程序后,如果从键盘上输入65 14<回车>,则输出结果为()\nmain( )\n{int m，n;\nscanf(\"%d%d\"，&m，&n);\nwhile(m!=n)\n{ while(m>n) m-=n;\nwhile(n>m) n-=m;}\nprintf(\"m=%d\n\"，m);}', '2', 'A.m=0；B.m=1；C.m=2；D.m=3', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10183', '一个C语言程序的执行是从 ( )', '2', 'A.本程序文件的第一个函数开始，到本程序文件的最后一个函数结束；B.本程序文件的第一个函数开始，到本程序的main函数结束；C.本程序的main函数开始，到本程序的main函数结束；D.本程序的main函数开始，到本程序文件的最后一个函数结束', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10184', '以下叙述中错误的是（）', '2', 'A.C程序书写格式比较自由，一个语句可以分别写在多行上；B.函数是C程序的基本单位；C.在C语言程序中，规定每条语句以分号（；）结束；D.在C程序中，注释说明只能位于一条语句的后面', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10185', '在C语言中，源程序的扩展名是 ( )', '2', 'A..c；B..obj；C..exe；D..dsp', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10186', 'C语言中的标识符只能由字母、数字和下划线3种字符组成，且第一个字符 ( )', '2', 'A.可以是是3种中的任一种字符；B.必须是字母或下划线；C.必须是数字；D.必须是字母', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10187', '下列几组选项中，均为不合法的用户自定义标识符是 ( )', '2', 'A.Pi do _001；B.For C1 _456；C.1ab m-n char；D.include s*T Cbook', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10188', '下列几组选项中，均为合法的关键字是 ( )', '2', 'A.dafault short main；B.break float swtich；C.Case while printf；D.return int for', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10189', '下列语句中，正确的是 ( )', '2', 'A.char ch1；B.#define PI3.14；C.int a=3；b=4；D.float a', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10190', '在C语言中，int、char和short三种类型数据所占用的内存是 ( )', '2', 'A.由用户自己定义；B.由所用机器的机器字长决定；C.是任意的；D.分别为4、1和2个字节', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10191', '以下选项中，属于C语言的基本数据类型是 ( )', '2', 'A.复合型；B.逻辑型；C.双精度型；D.集合型', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10192', '在C语言中，整型数据和字符型数据在内存中的存储形式分别是 ( )', '2', 'A.原码 原码；B.补码 反码；C.ASCII码 原码；D.补码 ASCII码', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10193', '在C语言中，合法的长整型常量是 ( )', '2', 'A.0L；B.4962710；C.0.054157892；D.2.1578e5', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10194', '下列选项中，均是合法的整型常量是 ( )', '2', 'A.0Xaff -100 018；B.870 0x123 -017；C.12,430 0X 10b；D.0xcdg 199 012459', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10195', '下列选项中，均是合法的实型常量是 ( )', '2', 'A.70 .02 5e；B.1.2e-5.2 07E2 E-3；C.300. -8E9 8.0e-2；D.07e5 +2E+3 0.0', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10196', '下列选项中，不是合法的字符常量是 ( )', '2', 'A.‘/‘’’；B.‘=’；C.’？‘；D.\"a\"', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10197', '已知大写字母A的ASCII码为65，小写字母a的ASCII码为97，则字符常量’101’是( )', '2', 'A.A；B.a；C.B；D.无此常量', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10198', '以下选项中，合法的一组C语言数值常量是 ()', '2', 'A.0x8A　 10,000　 3.e5；B.12.　 0Xa23　 4.5e0；C.177　 4e1.5　 0abc；D.028　 .5e－3　 －0xf', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10199', '在下列的C语言常量中，错误的是 ( )', '2', 'A.0XFE；B.9L；C.5.2e0.9；D.‘x75’', 'C', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10200', '在C语言中符号常量是由宏定义\"#define\"来定义的常量，以下叙述中正确的是 ( )', '2', 'A.符号常量的符号名是标识符，但必须大写；B.符号常量的符号名必须是常量；C.符号常量在整个程序中其值都不能再被重新定义；D.符号常量是指在程序中通过宏定义用一个符号名来代表一个常量', 'D', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10201', '关于C语言的变量名，以下叙述正确的是 ( )', '2', 'A.变量名不可以与关键字同名；B.变量名不可以与预定义标识符同名；C.变量名必须以字母开头；D.变量存储是没有限制的', 'A', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10202', '在下列选项中，正确的变量定义是 ( )', '2', 'A.float a=b=10.2；B.int a=10；C.char case；D.double x=0.123,x=12.3', 'B', '2', '1', '101');
INSERT INTO `t_question` VALUES ('10203', 'Java的前身是()', '2', 'A.Oak；B.C++；C.C；D.Basic', 'A', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10204', '以下代码输出从19到1之间的所有奇数，for语句的条件判断是( )\nfor ( i=19;　　　; i-=2)\n    System.out.print(i);', '2', 'A.i>1；B.i>=1；C.i<1；D.i<=1', 'B', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10205', '在Java语言中，不能注释多行内容的符号是( )', '2', 'A.以/**开始，*/结束的注释；B.以/*开始，*/结束的注释；C.以//开始的注释；D.以上都不能', 'C', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10206', '表达式46+7.8f的类型是( )', '2', 'A.int；B.long；C.float；D.double', 'D', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10207', '下列说法中正确的是( )', '2', 'A.一个Java源程序文件中最多只能有一个public类；B.引用一个类的属性或调用其方法必须以这个类的对象名为前缀；C.抽象类默认是public类；D.final类中的属性和方法都必须被final修饰符修饰', 'A', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10208', '有关Java中的标准输入/输出，下列说法中错误的是( )', '2', 'A.Java中没有专门的输入输出语句，所有输入输出是通过输入输出流来实现的；B.System类和java.lang.Math类不同，它的方法不全是静态的；C.标准输入输出流全部由java.lang.System管理；D.标准输入操作是由System.in.read实现，标准输出操作由System.out.print实现', 'B', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10209', '下列说法中正确的是( )', '2', 'A.抽象类默认是public类；B.引用一个类的属性或调用其方法必须以这个类的对象名为前缀；C.一个Java源程序文件中最多只能有一个public类；D.final类中的属性和方法都必须被final修饰符修饰', 'C', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10210', '在Java程序中，已定义变量int x，给x赋值为1的语句是( )', '2', 'A.mov x,1；B.int x=1；C.x:=1；D.x=1', 'D', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10211', '运行下列程序片段后，关于数组a,b,c的描述，正确的是( )\nint a[] = {2,4,6,8};\nint b[];\nint []c = {1,3,5,7};\nb = a;\nc = a;', '2', 'A.数组a，b，c具有相同的元素，元素值依次为 2，4，6，8；B.数组a，b，c均为空NULL；C.数组a，b为空NULL，c为2，4，6，8；D.以上说法均错误', 'A', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10212', '把窗口分成东、南、西、北、中五个明显区域的布局管理器是( )', '2', 'A.FlowLayout；B.BorderLayout；C.CardLayout；D.GridLayout', 'B', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10213', '不能再派生子类的类，修饰其，应该使用的修饰符是( )', '2', 'A.private；B.abstract；C.final；D.public', 'C', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10214', '以下不属于Java类库中的基础包的是( )', '2', 'A.java.lang；B.java.io；C.java.util；D.java.applets', 'D', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10215', '下列标准File类构造方法的使用示例中，不正确的是( )', '2', 'A.File file = new File(\"c:myjavademo.java \")；B.File file = new File(\"c:\\myjava\",\" demo.java \")；C.File file = new File(\"c:\\myjava\\demo.java \")；D.File dir = new File(\"c:\\myjava\"); File file = new File(dir, \"demo.java\")', 'A', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10216', '在标准String类的方法中，能去除某字符串中的首、尾空格的方法是( )', '2', 'A.replace()；B.trim()；C.regionMatches()；D.replaceAll()', 'B', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10217', '在Java语言中，属于单目运算符的是( )', '2', 'A.=；B.||；C.++；D.<<', 'C', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10218', ' 要定义int型public成员变量MAXLEN，并保持其值为常数100，则定义这个变量的语句是( )', '2', 'A.public int MAXLEN=100；B.final int MAXLEN=100；C.public const int MAXLEN=100；D.public final int MAXLEN=100', 'D', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10219', 'Java源程序文件的后缀名是( )', '2', 'A..java；B..class；C..cpp；D..exe', 'A', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10220', '以下关于Java中类的构造方法的说法中，错误的是( )', '2', 'A.构造方法必须与其所属类同名；B.一个类只能有一个构造方法；C.构造方法可以用new运算符调用（系统自动调用）；D.构造方法只能有入口参数，而没有返回值', 'B', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10221', '下列关于Java对象释放的说法中不正确的是( )', '2', 'A.Java中，程序员只需要创建对象，而释放对象的工作则由虚拟机自动完成；B.Java中垃圾收集是比较费时的，因此其优先级较低，一般在系统空闲时才执行；C.Java中对象释放是由程序员编写析构函数来完成的；D.Java中，垃圾收集可通过程序调用System.gc()方法在任意时刻进行', 'C', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10222', 'Java的整型数据类型中，需要内存空间最少的是( )', '2', 'A.long；B.short；C.int；D.byte', 'D', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10223', '在控制台运行Java字节代码的命令是( )', '2', 'A.java；B.run；C.link；D.javac', 'A', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10224', '在Java语言中，有一些英文单词已有特殊含义和用途，在程序中不得将它们另作它用，这些英文单词称为保留字或( )', '2', 'A.变量；B.关键字；C.注释；D.常量', 'B', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10225', '以下程序片段的输出结果是( )\n    int i=0;\n    while(i==1) {\n        System.out.print(\"***\");\n    }', '2', 'A.***；B.**；C.没有输出结果；D.*', 'C', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10226', '以下不属于面向对象技术范畴的概念是( )', '2', 'A.封装；B.多态性；C.继承性；D.结构', 'D', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10227', '下列说法中正确的是( )', '2', 'A.重载是指一个类中有多个同名而形参数量或类型不同的方法；B.子类只能重载父类的方法而不能覆盖父类的方法；C.子类不能声明与父类中方法同名且参数相同的方法；D.可以将方法返回值类型作为判断重载的标准之一', 'A', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10228', '下列答案中不是类的成员方法与外界进行信息交换的方式的是( )', '2', 'A.通过方法的返回值；B.在类外部定义全局变量；C.利用类的成员变量；D.通过方法中的参数传递', 'B', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10229', '在Java语言中，一个int型数据占用的内存空间是( )', '2', 'A.1字节；B.2字节；C.4字节；D.8字节', 'C', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10230', '以下关于Java语言表达式的描述中，错误的是( )', '2', 'A.表达式的操作数可以是方法调用；B.表达式求值时，表达式中的每个变量必须有一个确定的值；C.表达式可以单独构成Java语句；D.表达式的操作数不可以是常量', 'D', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10231', '以下程序片段用于求1-50的和，请问，while循环的条件应该是( )\n    int i=1,sum=0;\n    do {\n        sum +=i;\n        i++;\n    } while 　　　　;', '2', 'A.i<=50；B.i==50；C.i<50；D.i=50', 'A', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10232', '下列类声明语句中，正确的是( )', '2', 'A.public abstract final class newClass；B.public class newClass extends superClass；C.public final abstract class newClass extends superClass；D.abstract public newClass class', 'B', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10233', '在标准String类的方法中，能实现测试两个字符串的某对应区域是否相等，且返回一个boolean类型值的方法是( )', '2', 'A.equals()；B.equalsIgnoreCase()；C.regionMatches()；D.compareTo()', 'C', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10234', 'M类中有一个没有形式参数，且没有返回值的方法method，若要使得用M.method()就可以调用该方法，则method方法的方法头的正确形式应该是( )', '2', 'A.static method()；B.public method()；C.final void method()；D.static void method()', 'D', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10235', '下列有关数组的说法中，正确的是( )', '2', 'A.Java中的数组用new运算符创建，new运算符还将为数组分配相应的内存空间；B.数组的类型可以是基本型，也可以是类，但不能是接口；C.对于数组空间的回收，Java和C/C++相同，都是由程序控制的；D.以上说法均错误', 'A', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10236', 'Swing组件中的复选框组件类是( )', '2', 'A.JLabel；B.JCheckBox；C.JButton；D.JRadioButton', 'B', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10237', 'Java虚拟机被称为( )', '2', 'A.JSP；B.JDK；C.JVM；D.JNI', 'C', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10238', '1995年5月23日，正式发布Java语言的公司是( )', '2', 'A.Microsoft；B.Intel；C.IBM；D.Sun', 'D', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10239', '下面关于Java语言的for语句的描述中，正确的是( )', '2', 'A.初始化部分、条件判断部分和迭代因子都可以是空语句；B.初始化部分不能是空语句；C.条件判断部分不能是空语句；D.迭代因子不能是空语句', 'A', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10240', '下列用于输入的标准字符流是( )', '2', 'A.InputStream类；B.Reader类；C.File类；D.Writer类', 'B', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10241', '下列程序片段的运行结果为( )\nint a[] = {2,4,6,8};\nint b[] = {1,3,5,7,9};\nSystem.arraycopy(a,1,b,0,3);\nfor(int i = 0; i < b.length(); i++) System.out.print(b[i] + \" \");', '2', 'A.2 4 6 7 9；B.4 3 5 7 9；C.4 6 8 7 9；D.以上均不正确', 'C', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10242', '下列程序的运行结果是( )\npublic class Example{ \n    String str=new String(\"good\"); \n    char[]ch={’a‘,‘b’,‘c’}; \n    public static void main(String args[]){ \n        Example ex=new Example(); \n        ex.change(ex.str,ex.ch); \n        System.out.print(ex.str+\" and \"); \n        Sytem.out.print(ex.ch); \n    }    \n    public void change(String str,char ch[]){ \n        str=\"test ok\"; \n        ch[0]=‘g’; 　　\n    } \n}', '2', 'A.good and abc；B.test ok and；C.test ok and abc；D.good and gbc', 'D', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10243', '以下不可作为Java语言用户自定义标识符的是( )', '2', 'A.11；B.$1；C._1；D.a1', 'A', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10244', '以下程序片段用于求1～100的和，请问，while循环的条件应该是( )\n    int i=1,sum=0;\n    while 　　　　 \n    {\n        sum +=i;\n        i++;\n    }', '2', 'A.i<100；B.i<=100；C.i==100；D.i=100', 'B', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10245', '以下代码输出从2到20之间的所有偶数，for语句的初始化部分是( )\n    for ( 　　 ; i<=20; i+=2 )\n        System.out.print(i);', '2', 'A.i=0；B.i=19；C.i=2；D.i=20', 'C', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10246', '以下关于Java中类声明和方法声明的叙述中，不正确的是( )', '2', 'A.在类的内部可以再声明类，即Java中允许嵌套进行类声明；B.方法的局部变量的所属类型可以是Java中的任意合法类型；C.类的成员变量的所属类型可以是Java中的任意合法类型；D.在方法的内部可以再声明方法', 'D', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10247', '下列方法中，与方法public void add(int a){}为合理重载的方法是( )', '2', 'A.public void add(int a,int b)；B.public void add(long a)；C.public void add(int a)；D.public int add(int a)', 'A', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10248', '在Java语言中，一个字符型（char）数据占用的内存空间是( )', '2', 'A.1位；B.2个字节；C.1个字节；D.4个字节', 'B', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10249', '含有支持底层的Internet编程的类和WWW/HTML支持组成的java应用包是( )', '2', 'A.java.lang；B.java.awt；C.java.net；D.java.applet', 'C', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10250', '容器Panel和它的子类Applet默认的布局管理器是( )', '2', 'A.GridLayout；B.BorderLayout；C.CardLayout；D.FlowLayout', 'D', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10251', '下列关于Swing组件和AWT组件的描述中，错误的是( )', '2', 'A.Java中Swing组件包含在java.awt.swing包中；B.理想情况是AWT组件开发的图形界面可以应用于所有系统平台；C.Java中Swing组件是由NetScape和Sun公司联合开发的；D.AWT是Abstract Window Toolkit的缩写', 'A', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10252', 'Java语言中创建一个对象使用的关键字为( )', '2', 'A.class；B.new；C.interface；D.create', 'B', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10253', 'Java语言具有许多优点和特点，以下反映Java程序并行机制的特点是( )', '2', 'A.安全性；B.跨平台；C.多线程；D.可移植', 'C', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10254', '下列有关final修饰符的描述中，错误的是( )', '2', 'A.用final修饰的变量，一旦赋值，就不能改变，也称final修饰的变量为常量；B.由final修饰的方法不能被子类中的相同方法覆盖；C.由final修饰的类不能派生子类；D.由final修饰的类不能实例化生成相应的对象', 'D', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10255', '创建一个二维数组a，其中较高一维含两个元素，每个元素又由3个整型量构成，下列Java语句中能实现上述要求的是( )', '2', 'A.int a[][]=new int[2][3]；B.int a=new int[2][3]；C.int a[][]；D.int a[][]=int [2][3]', 'A', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10256', '设有String s ＝ new String(\"abc\"); 要使得运行结果为s=abc10可运行下列选项中的( )', '2', 'A.s += 10; System.out.print(\"s=\" + s)；B.String s2 = new String(\"10\")；s = s + s2；System.out.print(\"s=\" + s)；C.String s2 = new String(\"10\")； System.out.print(\"s=\" + s.concat(s2))；D.B', 'D', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10257', 'Java的前身是()', '2', 'A.无论grade的值是多少，打印Passed；B.如果grade的值大于等于60，打印Passed；否则打印Failed；C.无论grade的值是多少，打印Failed；D.如果grade的值大于等于60，打印Failed；否则打印Passed', 'B', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10258', '要使类的某个成员方法成为属于整个类的\"类方法\"，该方法应使用修饰符( )', '2', 'A.final；B.public；C.static；D.class', 'C', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10259', '在java中，用package语句说明一个包时，该包的层次结构必须是( )', '2', 'A.与文件的结构相同；B.与文件大小相同；C.与文件类型相同；D.与文件目录的层次相同', 'D', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10260', '在Java中，能够实现多重继承效果的方式是( )', '2', 'A.接口；B.内部类；C.适配器；D.同步', 'A', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10261', '在标准String类的方法中，能实现两个字符串按词典顺序比较大小，且返回一个int类型值的方法是( )', '2', 'A.equals()；B.compareTo()；C.regionMatches()；D.equalsIgnoreCase()', 'B', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10262', '关于标准输入流in，下列说法中错误的是( )', '2', 'A.标准输入流用于从标准输入设备输入数据；B.标准设备指计算机启动后默认的设备；C.in是输入流类Reader的对象；D.in是System类的成员变量', 'C', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10263', '为台式机设计，主要用于开发桌面应用软件的Java 2的版本是( )', '2', 'A.J2SE；B.J2EE；C.J2ME；D.B', 'A', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10264', '下列关于Java应用程序的main方法的描述中，错误的是( )', '2', 'A.每个应用程序都必须有main方法；B.应用程序的执行从main方法开始；C.每个应用程序只能有一个main方法；D.main方法必须放在整个程序的最前面', 'D', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10265', '下面关于Java语句的描述中，错误的是( )', '2', 'A.Java语句以分号（;）结束；B.单独一个分号（;）不能构成语句；C.可以用{}把一些语句括起来构成复合语句；D.一个表达式后加上分号（;）便构成一个语句', 'B', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10266', '下列给出的创建String对象s的方法中，错误的是( )', '2', 'A.String s ＝ new String()；B.byte abc[] = new {65,66,67}; String s = new String(abc,0)；C.String s = ‘abcde‘；D.byte ch[] = new {‘a’, ‘b’, ‘c’}; String s = new String(ch)', 'C', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10267', '运行Java语句System.out.println(Math.sin(Math.PI/2))；得到的结果为( )', '2', 'A.0.0；B.0.5；C.1.0；D.以上答案均错误', 'C', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10268', 'Java中含有大量标准类，其中提供了创建图形用户界面元素的类的java应用包是( )', '2', 'A.java.lang；B.java.net；C.java.applet；D.java.awt', 'D', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10269', '当类的成员未使用权限修饰符修饰时，Java认为该成员的访问权限是( )', '2', 'A.friendly；B.public；C.protected；D.private', 'A', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10270', '以下不属于Java关键字的是( )', '2', 'A.new；B.delete；C.package；D.super', 'B', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10271', ' 以下不属于Java语言基本数据类型的是( )', '2', 'A.long；B.boolean；C.char；D.String', 'D', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10272', '下面关于Java语言switch语句的描述中，错误的是( )', '2', 'A.case后面的常量可以相同；B.switch语句中，default子句是可选的；C.switch语句的表达式不能是字符串；D.switch语句体必须是带花括号{}的语句块', 'A', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10273', '下列关于抽象类的描述中，错误的是( )', '2', 'A.在类定义中，如果类被关键字abstract修饰，该类就是一个抽象类；B.abstract和final可以同时修饰同一个类；C.抽象类中可以没有抽象方法，而包含抽象方法的类必须是抽象类；D.抽象类本身不能被实例化，它只能作为其他类的父类。子类继承抽象类并实现父类的抽象方法后，就能实例化子类的对象', 'B', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10274', '在Java中，一个类可同时定义许多同名的方法，这些方法的形式参数的个数、类型或顺序各不相同，传回的值可以不相同。这种面向对象程序设计的特性称为( )', '2', 'A.隐藏；B.覆盖；C.重载；D.Java不支持此特性', 'C', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10275', '以下关于Java语言变量的描述中，错误的是( )', '2', 'A.变量名必须用标识符来标识；B.变量必须先定义，后使用；C.变量的定义可以出现在程序的任何位置；D.变量的类型必须是基本数据类型', 'D', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10276', '在程序设计领域，简称OOP的中文全称为( )', '2', 'A.面向对象程序设计；B.基于对象程序设计；C.结构化程序设计；D.基于过程程序设计', 'A', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10277', '创建一个由5个整型元素构成的一维数组a，可使用的Java语句为( )', '2', 'A.int a[]=int [5]；B.int a[]=new int[5]；C.int a[]=new [5]；D.int a=new int[5]', 'B', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10278', 'Java中，既具有组件功能，又能包含其他组件，并能通过布局管理器来控制这些组件的大小和功能的GUI单元是( )', '2', 'A.GUI用户自定义成分；B.基本组件；C.容器；D.面板', 'C', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10279', '沿水平线和垂直线安放组件的布局管理器是( )', '2', 'A.GridLayout；B.BorderLayout；C.BoxLayout；D.FlowLayout', 'D', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10280', 'Java中所有类的父类是( )', '2', 'A.Object；B.Java；C.System；D.Root', 'A', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10281', '可以被J2SDK中的javadoc.exe识别，并自动从程序中提出注释内容形成程序文档的注释形式是( )', '2', 'A.以//开始的注释；B.以/**开始，*/结束的注释；C.以/*开始，*/结束的注释；D.以上都不是', 'B', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10282', 'Java采用的字符集是( )', '2', 'A.ASCII；B.ISO8859；C.Unicode；D.GB2312', 'C', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10283', '在 Java 语言中 , 下面 （） 转义序列表示换行', '2', 'A.a；B.f；C.\r；D.\n', 'D', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10284', '在 JAVA编程中，Java编译器会将Java源代码程序转换为', '2', 'A.字节码；B.可执行代码；C.机器代码；D.以上所有选项都不正确', 'A', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10285', '在 Java语言中，下列代码片段的输出结果是\nfloat a = 50;\nint b = 4;\nfloat c = a/b;\nSystem.out.println(c);', '2', 'A.0；B.12.5；C.12.0；D.12', 'B', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10286', '在Java 语言中，下列代码的输出结果是\npublic static void main(String[] args) {\n    int i=5, j=10;\n    do {\n        if(i>j) {\n            break;\n        }\n    j--;\n    i++;\n}while(j!=i);\nSystem.out.println( i + \",\" + j);\n}', '2', 'A.7,6；B.9,6；C.8,7；D.7,8', 'C', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10287', '在Java 语言中定义了如下变量：\ndouble x=10.0; \ny=3.0;\nint z=2;\n下面强制转换符都发生了作用，除了', '2', 'A.(int)(x+y/z)；B.(double)(x/y)；C.(int)x；D.(int)(y+z)', 'D', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10288', '在JAVA编程中，源代码文件的扩展名为', '2', 'A..java；B..class；C..com；D.以上所有选项都不正确', 'A', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10289', '在JAVA语言中描述\nA：‘8’与8是相同的描述\nB：‘￥’的数据类型是char\n下面的选项（）是正确的', '2', 'A.两个描述都是正确的；B.只有描述B是正确的；C.两个描述都是错误的；D.只有描述A是正确的', 'B', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10290', '在JAVA语言中，（）语句可以结束本次循环而不会结束整个循环', '2', 'A.next；B.switch；C.continue；D.break', 'C', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10291', '在JAVA语言中，3/5的值是', '2', 'A.1；B.0.6；C.2；D.0', 'D', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10292', '在Java语言中，假设以下所有变量均为整型，则下列代码执行后c的值是\na=2;\nb=5;\nb++;\nc=a+b;', '2', 'A.8；B.7；C.6；D.5', 'A', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10293', '在Java语言中，经过如下运算后，num的值为\nint num = 0;\nnum = 2>3?0:1;', '2', 'A.0；B.1；C.2；D.3', 'B', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10294', '在Java语言中，能正确表示a和b同时为正或同时为负的表达式是', '2', 'A.(a >=0 || b >= 0) && (a < 0 || b < 0)；B.(a + b > 0) && (a + b <= 0)；C.a * b > 0；D.(a >= 0 && b >= 0) && (a < 0 && b < 0)', 'C', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10295', '在JAVA语言中,下列JAVA语言代码的循环体执行的次数是\nint n=2;\nwhile(n == 0){\nSystem.out.println(n); \nn--;\n}', '2', 'A.3；B.2；C.1；D.0', 'D', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10296', '在Java语言中，下列变量定义和赋值错误的是', '2', 'A.char c = \"c\"; int j=c；B.short i=5;int j=i；C.float f = ’c‘+1；D.float i=5; double d=i', 'A', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10297', '在Java语言中，下列表达式的运算的结果是\n10/2 +5%10；', '2', 'A.12；B.10；C.7；D.5', 'B', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10298', '在JAVA语言中,下列代码的输出结果是(选一项)（）\npublic static void main(String args[]){\nint i,j=0; \nfor(i=1;i<10;i++){\nif(i%4==0) continue; \nj =i; \n} \nSystem.out.println(i + \",\" + j);\n}', '2', 'A.10,8；B.3,6；C.10,9；D.4,10', 'C', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10299', '在Java语言中，下列代码的运行结果是\nint a = 1, sum = 0;\nwhile (a< 3){ \nsum = sum + a; \na++;\n}\nSystem.out.println(sum);', '2', 'A.2；B.3；C.4；D.以上都不对', 'B', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10300', '在JAVA语言中,下列代码的运行结果是(选一项)（）\npublic static void main(String args[]) { \nint stuAge[] = {18,22,26};\nint i, avgAge = 0; \nfor(i = 0; i < 3; i++){ \n    avgAge += stuAge[i] / 3; \n    }\nSystem.out.println( avgAge );\n}', '2', 'A.0；B.9；C.21；D.11', 'C', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10301', '在JAVA语言中，下列代码运行的结果是\nint a=1,b=3,c=5;\nif(a>b)\n    if(b>c) \n        c=a+b;\n    else \n        c=a*b;\nSystem.out.println( a + \"	\" + b + \"	\" + c);', '2', 'A.1 3 3；B.1 3 4；C.1 3 6；D.1 3 5', 'D', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10302', '在Java语言中，下列关于方法的优点，说法错误的是', '2', 'A.通过使用方法，使得程序的维护变得复杂；B.通过使用方法，可以提高代码的重用性；C.通过使用方法，可以提供程序开发的效率；D.通过使用方法，使得程序的变得简短和清晰', 'A', '2', '1', '103');
INSERT INTO `t_question` VALUES ('10303', '\"一张白纸展现在我们面前与同一张白纸被折成纸盒展现在我们面前，所反映出的信息有所差别\"这侧重反映了下列哪一种关于信息的说法', '2', 'A.信息是事物运动的状态和方式，也就是事物内部结构和外部联系的状态和方式；B.信息就是信息，不是物质也不是能量；C.信息是用来消除不确定性的东西；D.信息是人类的各种感官所接收到的东西', 'A', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10304', '将一份15页以文字为主的材料录入计算机中需要修订文本，最合适的方法是：', '2', 'A.把文章一字一句地重新输入到电脑里面再作修改；B.用扫描仪把文章扫描到电脑，再用汉字识别软件识别成可编辑的文档；C.用数码相机把文章拍摄成图片保存到电脑，再用photoshop作文字处理；D.利用IBM语音输入法把该文章读入到电脑，再作修改', 'B', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10305', '因特网使用的基础网络通信协议是（）', '2', 'A.IPX；B.SPX；C.TCP/IP；D.FTP', 'C', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10306', '以下不属于物联网应用的有（）', '2', 'A.用手机远程控制空调启动；B.在淘宝购物后，能在快递公司的网站上追踪快件的地理位置；C.手机控制摄像头；D.用遥控器打开电视', 'D', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10307', '下列信息中可信度最高的是（）', '2', 'A.教育部网站公布的高校招生计划；B.论坛上某用户发布的股票走势预测；C.某网站发布的下期彩票中奖号码预测；D.某人博客上发布的旅途见闻', 'A', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10308', '在\"我的电脑\"或\"资源管理器\"中按住（）键，使用鼠标可同时选中多个不连续的文件', '2', 'A.Shift；B.Ctrl；C.Alt；D.Tab', 'B', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10309', '智能手环是一种穿戴式智能设备，可以记录用户日常生活中的锻炼、睡眠等数据。这些数据与手机、平板等通信时，最佳的通信手段是（）', '2', 'A.红外；B.VHF；C.蓝牙；D.3G技术', 'C', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10310', '以下说法正确的是（）', '2', 'A.国标码是目前国际通用的信息交换字符代码；B.二进制代码是目前国际通用的信息交换字符代码；C.区位码是目前国际通用的信息交换字符代码；D.ASCII码是目前国际通用的信息交换字符代码', 'D', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10311', '以下数据，哪个是数值型数据', '2', 'A.圆周率3.14；B.电话号码：01062836511；C.日期：2018/2/9；D.一张数字图片', 'A', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10312', '数字化学习改变了学习的时空观念，下列哪个不是数字化学习的要素', '2', 'A.数字化学习环境；B.数字化学习理论；C.数字化学习方式；D.数字化学习资源', 'B', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10313', '学校将组织去国家博物馆参观秦汉文明展，同学们想提前了解展览内容，最便捷可行的方式是', '2', 'A.找专家介绍；B.查找相关书籍；C.去国家博物馆网站查找相关资料；D.找宣传材料', 'C', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10314', '数据处理的基本过程主要包括（）、数据整理、数据分析、数据呈现和分析报告撰写五个环节组成，环节之间有着层层递进的关系。', '2', 'A.数据加密；B.数据索引；C.数据统计；D.数据收集', 'D', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10315', '学校开设了12门选修课程，并通过调查问卷向同学征集了选择意愿，下面哪种图表类型比较适于反映课程选择的整体分布情况？', '2', 'A.饼图；B.散点图；C.柱形图；D.折线图', 'A', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10316', '大型开放式网络课程，即MOOC，在网上提供免费课程，给更多学生提供了系统学习的可能，完成课程学习对学习者的基本要求是（）', '2', 'A.有大量的学习时间；B.较高的学习自主性；C.有一定及经济条件；D.有一定的知识储备', 'B', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10317', '数据分析报告的撰写应该是能对整个数据分析过程做一个总结，并以报告的形式呈现出来，为决策者提供参考。你认为下面哪种情况，不应该出现在数据分析报告中？', '2', 'A.报告中的数据分析要基于可靠的数据源；B.分析报告要有解决方案和建议方案；C.数据分析报告有猜测性的结论，结论没有肯定的把握；D.报告中的数据分析要有很强的可读性，数据可视化显示，形象直观', 'C', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10318', '数据加密技术是最基本的安全技术，最初主要用于保证数据在存储和传输过程中的保密性，现已被应用在日常生活，其对（）等都可实施加、解密变换', '2', 'A.仅文本；B.仅文本和语音；C.仅文本、语音、图像；D.文本、语音、图像、视频数据', 'D', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10319', '（）是计算机科学的一个分支，它企图了解智能的实质，并生产出一种新的能以人类智能相似的方式做出反应的智能机器，该领域的研究包括机器人、语言识别、图像识别、自然语言处理和专家系统等', '2', 'A.人工智能；B.云计算；C.自动控制；D.大数据', 'A', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10320', '一位同学在编辑视频短片时遇到了技术困难，想通过网络与专业人员实时交流，以尽快解决问题，下列沟通方式中最快捷方便的是', '2', 'A.Email；B.即时通讯软件；C.网上社区；D.Ftp', 'B', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10321', '超级计算机是计算机中功能最强、运算速度最快、存储容量最大的一类计算机。目前超级计算机的峰值计算速度达到每秒（）次的级别', '2', 'A.千万；B.亿；C.亿亿；D.百万亿', 'C', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10322', '智能手机通过家用无线路由器上网需要打开的设置是（）', '2', 'A.GPS；B.4G；C.蓝牙；D.WLAN', 'D', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10323', '下列描述不属于数据的是（）', '2', 'A.天气温暖；B.54；C.风速；D.电表度数', 'A', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10324', '下列描述中属于知识的是（）', '2', 'A.某三角形的面积为38平方米；B.三角形的面积计算公式为：S=1/2*a(底)*h(高)；C.38平方米；D.S=1/2*a*h', 'B', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10325', '下列关于数据处理的说法正确的是（）', '2', 'A.数据处理是将信息转换成数据的过程；B.数据处理是对数据进行算术运算；C.数据处理是将数据转换成信息的过程；D.数据处理是数据的简单收集', 'C', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10326', '学校团委号召全校师生为贫困地区捐书，现将全校40个班级1500余人所捐赠书籍按文学、工具、杂志三类录入电子表格软件中做统计管理，需要按类别统计分析各年级班级捐赠数目，可以通过电子表格的（）处理功能，得出各年级班级文学类书籍捐赠的数目？', '2', 'A.排序；B.查找；C.筛选；D.分类汇总', 'D', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10327', '读下面程序段，运行结果为（）\nfor i in range(10,0,2):\nprint( i , end=’,‘)', '2', 'A.没有任何输出；B.程序报错；C.10,8,6,4,2；D.10', 'A', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10328', '下列哪个函数可用于四舍五入取整（）', '2', 'A.int( )；B.round( )；C.float( )；D.str( )', 'B', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10329', '下列变量名中不合法的是：（）', '2', 'A.a5_；B.a_5；C.5_a；D._a5', 'C', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10330', '以下选项中正确的赋值语句是（）', '2', 'A.1+2=x1；B.x1+2=3；C.x1: 3*2；D.x1+=3-2', 'D', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10331', '若s = \"123456789\"，则s[1:5]的输出结果是：（）', '2', 'A.2345；B.12345；C.123456；D.23456', 'A', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10332', '能正确表示逻辑关系\"a≥10或a≤0\"的python表达式是（）', '2', 'A.a>=10 and a<=0；B.a>=10 or a<=0；C.a>=10 && a<=0；D.a>=10 || a<=0', 'B', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10333', '关于数据的表现形式，错误的描述是', '2', 'A.可以是数字和文字；B.可以是符号和图像；C.可以是数字、文字、符号、图形和图像，但音视频不是；D.可以是音视频', 'C', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10334', '（ ）是间接获取数据的渠道', '2', 'A.耳闻目睹；B.自己做实验；C.做调查问卷；D.查找文献资料', 'D', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10335', '（）具有普遍性、共享性、依附于载体、传递性、时效性、可处理性、真伪性、不完全性、价值相对性等特征。', '2', 'A.信息；B.信息素养；C.信息技术；D.信号', 'A', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10336', '（）是指根据需求获取相关的数据', '2', 'A.数据整理；B.数据收集；C.数据分析报告撰写；D.数据的分析', 'B', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10337', '课上老师提出了一个研究课题，有的同学负责对整个数据分析过程作一个总结，最后以报告的形式完整地呈现出来，他们完成的任务属于数据处理过程中的（）', '2', 'A.数据呈现；B.数据收集；C.数据分析报告撰写；D.数据的分析', 'C', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10338', '以下选项不属于数据清洗的内容是（）。', '2', 'A.删除重复信息；B.纠正存在的错误；C.提供数据一致性；D.数据的价值', 'D', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10339', '下列活动中，不宜用问卷调查的方式收集数据的是（）', '2', 'A.近五年清华大学招生数量；B.学生对学科教师的满意程度；C.学校乐团队员的年龄和身高；D.学校开设选修课的内容', 'A', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10340', ' 数据分析的方法有很多，在研究北方某地气候特点时，将其气温、水量、气压与南方某城市的相应数据进行对比，分析它们的差异。这是数据分析方法中的（）', '2', 'A.交叉分析法；B.对比分析法；C.平均分析法；D.综合评价分析法', 'B', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10341', '一家网上书店，对于自己的销售量骤减，进行数据研究，他们研究销售量变化的原因，这样的数据分析属于（）', '2', 'A.现状分析；B.预测分析；C.归因分析；D.结果分析', 'C', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10342', '（ ）用某种特定的几何图形按一定规律在平面（二维方向上）分布的黑白相间的图形记录数据符号信息', '2', 'A.条形码；B.PCM编码；C.ASCII代码；D.二维码', 'D', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10343', '下列选项中正确的是：', '2', 'A.如果A1_ = 1，可以print(A1_)；B.如果1A_ = 1，可以print(1A_)；C.Python 中的标识符是不区分大小写的；D.Python 中，所有标识符可以包括英文、数字以及下划线_，能以数字开头', 'A', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10344', 'stockname= ’GOOG’是什么数据类型？', '2', 'A.float；B.string；C.int；D.以上都不正确', 'B', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10345', '返回 str 在 string 里面出现的次数，是调用下列哪个选项？', '2', 'A.string.format()；B.string.split(str=\"\", num=string.count(str))；C.string.count(str, beg=0, end=len(string))；D.string.find(str, beg=0, end=len(string))', 'C', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10346', 'Java的前身是()', '2', 'A.l = [666,‘Quant’,‘Trader‘,2.333]；B.l = [666, ’Quant‘, ’Trader‘]；C.l = [’Trader‘,2.333,’learn’]；D.l = [666, ‘Quant’, ‘Trader’,’learn’]', 'D', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10347', '字典读取是下列哪个选项？', '2', 'A.dict.get；B.dict.setdefault；C.dict.update；D.d.pop', 'A', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10348', 'x = set(‘GOOG’) x输出下列哪个选项？', '2', 'A.GOOG；B.{‘G’,’O’}；C.{‘GOOG’}；D.G,O', 'B', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10349', 'Java的前身是()', '2', 'A.l =dict(t)；B.l =set(t)；C.l = list(t)；D.以上都不正确', 'C', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10350', ' a=9，b=4。如果要取a取整除以b，下列哪个选项正确？', '2', 'A.a**b；B.a*b；C.a/b；D.a//b', 'D', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10351', '跳过当前循环的剩余语句，然后继续进行下一轮循环。题目描述为下列哪个选项？', '2', 'A.continue；B.break；C.pass；D.以上都不正确', 'A', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10352', '生成以10开始，到49，间隔为5。代码为下列选项中哪一个？', '2', 'A.range(10,50,5)；B.list(range(10,50,5))；C.list(range(10,49,5))；D.以上都不正确', 'B', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10353', '如果输入\nPrices = list(range(10))\nEMA = pd.Series(ta.EMA(np.array(Prices, dtype=np.float64),4))\n这是计算下列哪个选项？', '2', 'A.EMA(Prices,10)；B.EMA(Prices,6)；C.EMA(Prices,4)；D.EMA(Prices,64)', 'C', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10354', ' L1 = list(range(15)) ，输入下列哪个选项，得到[0, 3, 6, 9, 12] ?', '2', 'A.L1[:12:3]；B.L1[::2]；C.L1[1:15:3]；D.L1[::3]', 'D', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10355', '关于面向对象的继承，以下选项中描述正确的是', '2', 'A.继承是指类之间共享属性和操作的机制；B.继承是指一组对象所具有的相似性质；C.继承是指各对象之间的共同性质；D.继承是指一个对象具有另一个对象的性质', 'A', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10356', '在Python中，运行下列程序，输出结果是( )。\na=37\nb=a%5\nprint(b)', '2', 'A.1；B.2；C.3；D.4', 'B', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10357', '下列程序，运行程序的结果是( )\na=2\nb=4\nc=(a+b)/2\nprint(c)', '2', 'A.4.0；B.4；C.3.0；D.3', 'C', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10358', '读下面的 Python程序，请在划线处将程序补充完整，使程序的输出结果是True。\na=5\nb=8\nif______:\n     print(’true‘)\nelse:\n     print(‘false’)', '2', 'A.a=b；B.a==b；C.a>b；D.a<b', 'D', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10359', '运行以下程序，显示的运行结果是( )\na=3\nb=4\nif(a+b>8):\n    print(a)\nif(a+b<=8):\n    print(b)', '2', 'A.4；B.5；C.6；D.7', 'A', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10360', '运行以下程序，显示的运行结果是( )\na=\"你好\"\nb=\"hello\"\nprint(b)', '2', 'A.你好；B.hello；C.\"你好\"；D.\"hello\"', 'B', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10361', '在Python中，运行下列程序，输出结果是_______。\nfor i in range(1,6):\n    print(\"*\")', '2', 'A.*****；B.*******；C.******；D.以上都不正确', 'D', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10362', '程序运行结果如下图所示，应在以下横线处填写()\n*\n*\n*\n*\n*\nfor i in range(1,___,1):\n    print(‘*’)', '2', 'A.3；B.4；C.5；D.6', 'D', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10363', '运行以下程序，从键盘上输入6显示的运行结果是()\na=int(input())\nif(a>0):\n    print(\"正数\")\nelse:\n    print(\"不是正数\")', '2', 'A.正数；B.不是正数；C.a；D.6', 'A', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10364', '运行以下程序，显示的运行结果是()\na=5\nb=4\nif(a>b):\n    print(a)\nelse:\n    print(b)', '2', 'A.4；B.5；C.a；D.b', 'B', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10365', '下列程序，输入数值100,显示的运行程序结果是( )\na=int(input())\nif(a<=100):\n    print(\"yes\")', '2', 'A.100；B.无结果；C.yes；D.a', 'C', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10366', '以下程序中，输出变量sum的值，横线位置正确的语句是()\na=1\nb=2\nsum=8+b\n__________', '2', 'A.print(\"sum\")；B.printf(\"sum\")；C.printf(sum)；D.print(sum)', 'D', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10367', '以下程序的运行结果是() for i in range(1,4,1): print(i，end=\"\")', '2', 'A.123；B.12；C.1；D.1234', 'A', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10368', '以下程序共循环几次()\nfor i in range(1,4,1):\n     print(i)', '2', 'A.2；B.3；C.4；D.1', 'B', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10369', '荷兰人吉多?范罗苏姆于1989年发明的程序设计语言是', '2', 'A.Pathon；B.pation；C.python；D.pytion', 'C', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10370', 'python程序设计语言输出语句是', '2', 'A.input()；B.if()；C.iut()；D.print()', 'D', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10371', 'python程序设计语言输入语句是', '2', 'A.input()；B.print()；C.iut()；D.if()', 'A', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10372', 'print(1/2)语句运行后的结果是', '2', 'A.1/2；B.0.5；C.1；D.以上都不正确', 'B', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10373', 'print(\"1/2\")语句运行后的结果是', '2', 'A.1；B.0.5；C.1/2；D.以上都不正确', 'C', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10374', 'print(\"1+2\",\"=\",3)语句运行后的结果是', '2', 'A.\"1+2\"=\"3；B.3= 3；C.1+2,=,3；D.1+2 = 3', 'D', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10375', 'print(1+2,\"=\",3)语句运行后的结果是', '2', 'A.3 = 3；B.\"1+2=\" 3；C.1+2 = 3；D.1+2,=,3', 'A', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10376', '从键盘获取数据保存到整数变量a中，以下正确的代码是', '2', 'A.a=int()；B.a=int(input())；C.a=int()input()；D.input(a)', 'B', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10377', '下面可以做为python变量名的是', '2', 'A.1a；B.print；C.a1；D.if', 'C', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10378', '下面哪条语句是将数据强行转化为字符串类型', '2', 'A.int()；B.float()；C.input()；D.str()', 'D', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10379', '下面哪条语句是将数据强行转化为浮点型[小数]', '2', 'A.float()；B.int()；C.str()；D.input()', 'A', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10380', '下面哪条语句是将数据强行转化为整型', '2', 'A.float()；B.int()；C.str()；D.input()', 'B', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10381', '在python中______运算符是相除运算？', '2', 'A.%；B.+；C. /；D.//', 'C', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10382', '在python中______运算符是取模[取余]运算？', '2', 'A.**；B.//；C./；D.%', 'D', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10383', '在python中______运算符是相除取整运算？', '2', 'A.//；B./；C.%；D.**', 'A', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10384', '在python中______运算符是幂运算？', '2', 'A.%；B.**；C./；D.//', 'B', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10385', '（）是事物运动的状态和方式，它的基本功能是消除对客观事物认识上的不确定性', '2', 'A.信号；B.物质；C.信息；D.消息', 'C', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10386', '（）是信息的载体，是对客观事物的特征的抽象化的、符号化的表示。例如：用于表示数据量的数值，用于表示事物名称的字符等', '2', 'A.消息；B.物质；C.信号；D.数据', 'D', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10387', '关于信息，下列说法错误的是 （）', '2', 'A.信息的价值不会改变；B.信息是可以共享的；C.信息是可以处理的；D.信息必须依附于载体而存在', 'A', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10388', '计算机内部采用（）编码进行工作', '2', 'A.十六进制；B.二进制；C.八进制；D.十进制', 'B', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10389', '计算机无法直接理解人们日常接触到的信息，所以需要对信息进行（）才能在计算机中存储、加工、传送', '2', 'A.信息化；B.固化；C.数字化；D.模拟化', 'C', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10390', '计算机编码是指对输入到计算机中的各种数据用（）数进行编码的方式', '2', 'A.十进制；B.十六进制；C.八进制；D.二进制', 'D', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10391', '信息的 （）过程是指利用必要的仪器设备把文本、图像、声音、视频等信息采集为声、光、电等物理信号(也称为模拟信号)，再经过采样、量化和数字编码，转化成用二进制数字表示的数字信息，最后进入计算机保存', '2', 'A.数字化；B.电子化；C.集成化；D.简化', 'A', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10392', '数值型数据在计算机中都采用（）编码方式', '2', 'A.十进制；B.二进制；C.八进制；D.十六进制', 'B', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10393', '下列文件格式中，哪个不是图形图像文件的存储格式', '2', 'A.. gif；B.. jpg；C.. pdf；D.. bmp', 'C', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10394', '（）格式文件是纯文本文件，不携带任何文字修饰控制格式，一般字处理软件都能打开', '2', 'A.. doc；B.. pdf；C.. html；D.. txt', 'D', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10395', '下列文件类型中，能够包含视频信息的是（）', '2', 'A..avi；B..wav；C..mid；D.以上都不正确', 'A', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10396', '（）是指无法在一定时间范围内用常规软件工具对其内容进行捕捉、管理和处理的数据集合', '2', 'A.数据；B.大数据；C.知识；D.信息', 'B', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10397', '（）是一种基于互联网的计算方式，通过这种方式，共享的软硬件资源和信息可以按需求提供给计算机和其他设备', '2', 'A.大数据；B.人工智能；C.云计算；D.自动控制', 'C', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10398', '（）是第四代移动通信技术，其最明显的优势在于数据通信速度，最大数据传输速率达到100Mbit/s', '2', 'A.5G；B.Wi-Fi；C.3G；D.4G', 'D', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10399', '如果用Excel软件管理全班同学的姓名、性别、通讯地址等信息，那么当需要快速列出全班女生的信息时，要使用该软件的（）功能', '2', 'A.数据→筛选；B.编辑→查找；C.编辑→填充；D.工具→信息检索', 'A', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10400', '（）是接近于自然语言或数学语言，不依赖于计算机硬件，编写的程序能在通用计算机上运行的语言', '2', 'A.机器语言；B.高级语言；C.低级语言；D.汇编语言', 'B', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10401', '（）的指令代码是由二进制数0、1构成', '2', 'A.低级语言；B.高级语言；C.机器语言；D. 汇编语言', 'C', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10402', '微型计算机硬件系统中最核心的部件是()', '2', 'A.CPU；B.UPS；C.存储器；D.输入输出设备', 'C', '2', '1', '104');
INSERT INTO `t_question` VALUES ('10403', '下列关于Lambda表达式语法错误的是( )。\npublic delegate string Add(string a,string b);', '2', 'A.Add delegate=(string x,string y)=> return x+y；B.Add delegate=(string x,string y)=>{ return x+y; }；C.Add delegate=(string x,string y)=> x+y；D.Add delegate=(x,y)=> x+y', 'A', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10404', '下列选项中，生成结果为\"1 3 5 7 9\"的是( )', '2', 'A.Enumerable.Range(1,10).SkipWhile(a=>a%2==0)；B.Enumerable.Range(1,10).Except(new List<int>{ 2,4,6,8,10 })；C.Enumerable.Range(1,10).Where(a=>a%2==0)；D.Enumerable.Range(1,5).Select(a=>2a-1)', 'B', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10405', '创建一个对象obj，该对象包含一个名为\"name\"的属性，且值为\"value\"，以下选项的JavaScript代码中，无法得到上述结果的是( )', '2', 'A.var obj = new Object(); obj[\"name\"] = \"value\"；B.var obj = {name : \"value\"}；C.var obj = new Object(); obj.prototype.name = \"value\"；D.var obj = new function() {this.name = \"value\"; ｝', 'C', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10406', '下列对于应用程序缓存的说法错误的是( )', '2', 'A.应用程序缓存可以通过键/值对的方式来添加；B.应用程序缓存对比整页缓存更灵活、方便，可以用于保存常使用且不会频繁更新的数据；C. 应用程序缓存具有易丢失的特点，所以在访问应用程序缓存中的数据时，最好先判断缓存对象是否存在；D.应用程序缓存的缺点是不能指定过期时间，数据的实时性得不到保障', 'D', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10407', 'Ajax并不是一种全新的技术，而是整合了几种现有的技术，这其中不包括( )', '2', 'A. WebService；B. XML；C.CSS；D.JavaScript', 'A', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10408', '在ASP.NET MVC中，控制器View方法的参数不包括( )', '2', 'A.viewName；B.routeValues；C.model；D.masterName', 'B', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10409', '分析下面的代码，下列LINQ查询不会被即时执行的是( )。\nint[] numbers = new int[]{6,4,3,2,9,1,8,7,5};', '2', 'A.numbers.Count()；B.numbers.Max()；C.numbers.Where(a=>a>5)；D.numbers.ToList()', 'C', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10410', '在ASP.NET中，下列关于HttpHandler程序的说法，错误的是( )', '2', 'A.扩展名为.ashx；B.需要实现IHttpHandler接口；C.在该程序中不能直接使用Session；D.它是请求处理的起点', 'D', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10411', '下列关于[WebMethod]的描述，错误的是( )', '2', 'A.下面的方法，其参数和返回值类型都是固定的；B.表示其下面的方法是Web方法；C.它是一个特性；D.一个Web Service文件可以有多个[WebMethod]', 'A', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10412', '下列关于扩展方法特性的说法，正确的是', '2', 'A.扩展方法所在的命名空间必须与被扩展的类一致；B.扩展方法必须是静态方法；C.扩展方法所在的类名必须与被扩展的类一致；D.扩展方法接收的参数类型为被扩展的类，并使用this关键字修饰', 'B', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10413', '在 ASP.NET MVC 中，过滤器不能应用到( )上', '2', 'A.单个动作方法；B.单个控制器；C.视图；D.所有控制器', 'C', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10414', '在ASP.NET中的整页缓存@OutputCache指令中，( )是必需属性', '2', 'A.VaryByParam；B.VaryByControl；C.Location；D.Duration', 'D', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10415', '在ASP.NET MVC中，对Action方法的要求的说法中，不正确的是( )', '2', 'A.方法必须是static(静态)方法；B.方法必须使用public修饰符修饰；C.方法参数不能是泛型参数；D.方法的返回类型为ActionResult', 'A', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10416', '下列关于ASP.NET页面缓存的OutputCache指令的声明，正确的是( )', '2', 'A.<%@ OutputCache Duration=\"5\"%>；B.<%@ OutputCache Duration=\"5\"VaryByControl=\"none\"%>；C.<%@ OutputCache Duration=\"5000\"VaryByParam=\"id,isbn\"%>；D.<%@ OutputCache VaryByParam=\"name\"%>', 'B', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10417', 'Web Service的扩展名是( )', '2', 'A..ascx；B. .asax；C..asmx；D..ashx', 'C', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10418', 'JSON 对象包含于哪种符号之间( )', '2', 'A.双括号；B.单括号；C.圆括号；D.花括号', 'D', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10419', '下列关于 ASP.NET 和三层架构的描述，说法正确的是', '2', 'A.ASP.NET MVC 相当于三层中的表现层；B.ASP.NET MVC 和三层不能结合使用；C. ASP.NET MVC 相当于三层中的数据访问层；D.ASP.NET MVC 相当于三层中的业务逻辑层', 'A', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10420', '关于 console 对象的分析及应用，下列描述错误的是( )。', '2', 'A.一般信息 console.info()；B.过滤正确信息 console.debug()；C.警告提示 console.warn()；D.错误提示 console.error()', 'B', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10421', '下列不属于创建 ASP.NET MVC 应用程序步骤的是( )', '2', 'A. 创建模型类；B.创建控制器类；C.创建 Web 控件；D.创建视图文件', 'C', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10422', '在 ASP.NET MVC 中，下列( )选项中两个对象数据是直接相通的。\n', '2', 'A.TempData 和 Model；B.ViewData 和 TempData；C.ViewBag 和 TempData；D. ViewData 和 ViewBag', 'D', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10423', '下列选项中，规范的控制器命名是( )', '2', 'A.ProductController；B.Product；C.ProductControl；D.ProductController.cs', 'A', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10424', 'JSON 语法声明了一个对象，是一种用于传输和生成数据的协定，下列说法错误的是', '2', 'A.属性：采用 Key-Value 对表示，属性之间使用逗号隔开；B.对象：对象不包含于{}之间；C.对象数组：数组存放于[]之间，如：[elements]；D.元素：元素之间用逗号隔开', 'B', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10425', '下列不属于 MVC 模式的组成部分的是( )', '2', 'A.Model；B.Controller；C.Event；D.View', 'C', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10426', '下列关于 ASP.NET MVC 框架的功能的描述，说法错误的是', '2', 'A.实现了应用程序任务的分离(输入逻辑、业务逻辑和用户界面逻辑)；B.它是一个可扩展、可插入的框架；C.支持强度的 URL 映射组件；D.支持类似 window form 的事件机制', 'D', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10427', 'datagrid 组件中哪个属性是设置列标题对齐的', '2', 'A.align；B.colspan；C.halign；D.formatter', 'A', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10428', '下述代码中，设置 4 秒后执行的 js 脚本，正确的是( )', '2', 'A.console.info(\"执行代码\",4000)；B.setTimeout(\"执行代码\",4000)；C.alert(\"执行代码\",4000)；D.call(\"执行代码\",4000)', 'B', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10429', 'panel组件的tools属性，是自定义工具菜单，其可用值包括，描述错误的是( )', '2', 'A.数组，每个元素均包含\"iconCls\"和\"handler\"属性；B.功能按钮指向工具菜单的选择器，显示在工具菜单区域；C.handler属性，没有实际作用；D.iconCls是选择图标样式，iconCls的样式名称请参考\"UI/themes/icon.css\"文件', 'C', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10430', '渲染并实例化EasyUI组件的方法是( )', '2', 'A.在html代码的某些特定的标签元素中，通过添加class=\"组件名\"来实现；B.在html代码的某些特定的标签元素中，通过添加data=\"组件名\"来实现；C.在html代码的某些特定的标签元素中，通过添加class=\" easyui-组件名\"来实现；D.在html代码的某些特定的标签元素中，通过添加data=\" easyui-组件名\"来实现', 'C', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10431', 'EasyUI form组件的submit方法的参数是一个对象，其属性包括( )', '2', 'A.data:要求为Object或String类型的参数，发送到服务器的数据；B.onSubmit：提交之前的回调函数；C. url：请求的URL地址；D.success：提交成功后的回调函数', 'A', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10432', '下列关于 Web Service 描述，说法正确的是( )', '2', 'A.只能用.NET 平台开发；B.Web Service 独立于语言、平台；C.只能在 Windows 上使用；D.不能在 Win Forms 程序中调用', 'B', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10433', '下列关于 ASP.NET MVC 框架优势描述，说法错误的是', '2', 'A.有效降低了管理的复杂性；B.为测试驱动开发(TDD)提供更好的支持；C.大量使用 ViewState 和服务器控件，加快应用程序开发的速度；D.允许用户设计出一种可以支持丰富路由结构的应用程序', 'C', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10434', '在 ASP.NET 中，能够实现页面部分缓存的控件是', '2', 'A.ScriptManager；B.UpdatePanel；C.Cache；D.Substitution', 'D', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10435', '下列关于AJAX的描述，正确的是', '2', 'A.AJAX是异步式JavaScript和XML的英文缩写；B.AJAX是一系列技术的集合，主要使用到Java技术；C.AJAX是一种未确定的技术，主要用于进行科学计算；D.AJAX是一种新兴的技术，专用于制作银行网页', 'A', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10436', '以下关于自定义HtmlHelper的说法正确的是', '2', 'A. TagBuilder的RenderBeginTag方法用于呈现开始标签；B.可以通过扩展方法创建自定义的HtmlHelper；C.HtmlTextWriter的GenerateId方法用于为标签产生一个ID；D.TagBuilder的Attributes表示HTML标签样式表的属性', 'B', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10437', '在ASP.NET MVC中，在视图加载用户控件List.ascx的方法是', '2', 'A.<%=List.ascx%>；B.<%=RenderPartial(\"List\")%>；C.<%Html.RenderPartial(\"List\");%>；D. <%=Html(\"List\")%>', 'C', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10438', '在ASP.NET中，显式移除应用程序数据缓存对象的方法是', '2', 'A.Truncate；B.Delete；C.Drop；D.Remove', 'D', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10439', '在使用 AJAX 时，需要接收服务器返回的信息，下列哪种格式的数据 JS 无法识别？', '2', 'A.DataTable；B.XML；C.JSON；D.字符串', 'A', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10440', '在 ASP.NET 中，下列( )不是添加应用程序缓存的方法', '2', 'A.Cache[″data″]=60；B.Append()方法；C.Add()方法；D.Insert()方法', 'B', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10441', '在 ASP.NET 中，关于 Web Service，下列说法正确的是', '2', 'A.Web Service 中的方法都具有[WebMethod]特性；B.WinForms 程序不能调用 Web Service；C.Web Service 的基本通讯协议 SOAP 是基于 XML 的；D.Web Service 技术组成要素中，UDDI 通过 XML 文档来描述 Web 服务的', 'C', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10442', '常用的int类型实际是', '2', 'A.System.Int16；B. System.Int32；C.System.Int64；D.以上都不正确', 'A', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10443', '下列是引用类型的有', '2', 'A.class 类型；B.enum 类型；C.struct 类型；D.string 类型', 'D', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10444', '下列描述错误的是', '2', 'A.抽象类和接口都不能被实例化；B.类不可以多重继承而接口可以；C.抽象类自身可以定义成员而接口不可以；D.一个类可以有多个基类和多个基接口', 'B', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10445', '在ASP.NET中的整页缓存@OutputCache指令中，( )是必需属性', '2', 'A.VaryByParam；B.VaryByControl；C.Duration；D.Location', 'C', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10446', '\"分析以下C#片段中的属性，该属性是（）属性.Privatestringname;PublicstringName{Get{.returnname;}}\"', '2', 'A.可读可写；B.静态；C.只写；D.只读', 'D', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10447', '在.NET中,Hashtable类所在的命名空间', '2', 'A.System.Collections；B.System.IO；C.System.Threading；D.System', 'A', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10448', 'CLR为.NET提供以下方面的功能或服务，除了', '2', 'A.垃圾回收；B.自动取消应用程序中的语法错误；C.代码访问安全；D.代码验证和类型安全', 'B', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10449', '下列( )方式无法正常浏览ASPX文件的运行结果', '2', 'A.http://IP地址/login.aspx；B.http://127.0.0.1/ login.aspx；C.在浏览器中直接输入login.aspx；D.http://localhost/login.aspx', 'C', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10450', '下列input表单标记中，(   )是按钮', '2', 'A.type=\"password\"；B.type=\"text\"；C.type=\"radio\"；D.type=\"submit\"', 'D', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10451', '引用外部样式表的元素应该放在', '2', 'A.head元素中；B.HTML文档的开始位置；C.HTML文档的结束位置；D.body元素中', 'A', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10452', '下列关于Asp.Net验证控件的说法正确的是', '2', 'A.当输入为空时，所有的验证控件都不能验证通过；B.服务器验证控件在执行验证时必须在服务器端执行；C.只有TextBox控件才能使用验证控件；D.ValidationSummary控件对网页的输入控件进行总结性验证', 'B', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10453', ' 在.NET中，可以使用基于连接的对象来访问数据库，下列选项中( )不是\"基于连接的对象\"', '2', 'A.Connection对象；B. Command对象；C.DataSet对象；D.DataReader对象', 'C', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10454', '在ASP.NET 中', '2', 'A.O；B.C；C.W；D.以上都不正确', 'D', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10455', '在ASP.NET 中', '2', 'A.O；B.C；C.W；D.以上都不正确', 'D', '2', '1', '105');
INSERT INTO `t_question` VALUES ('10456', '在面向对象方法中，不属于\"对象\"基本特点的是？', '1', 'A.一致性；B.分类性；C.多态性；D.标识唯一性 ', 'A', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10457', 'C++系统预定义了4个用于标准数据流的对象，下列选项中不属于此类对象的是？', '1', 'A.cout；B.cin；C.cerr；D.cset', 'D', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10458', '一个可运行的C＋＋源程序( )', '1', 'A.由一个或多个主函数构成；B.由一个且仅由一个主函数和零个以上（含零个）的子函数构成；C.仅由一个主函数构成；D.由一个且只有一个主函数和多个子函数构成 ', 'B', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10459', 'C＋＋程序的三种基本结构是( )', '1', 'A.顺序结构、选择结构、循环结构；B.递归结构、循环结构、转移结构；C.嵌套结构、递归结构、顺序结构；D.循环结构、转移结构、顺序结构 ', 'A', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10460', '以下不属于字符型常量的是（ ）', '1', 'A.‘$’；B.‘+’；C.‘x2A’；D.\"B\" ', 'D', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10461', '已知：char a，float b ， double c ， 则执行语句：c = a + b + c后变量c的类型为( )', '2', 'A.int；B.char；C.double；D.float ', 'C', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10462', '设已有说明语句\"in a=5;\"，则执行语句\"a+=a*=a%=3;\"后，a的值为 ( )', '2', 'A.18；B.8；C.2；D.0 ', 'B', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10463', '给出下面定义：char a[]=\"abcd\";char b[]={‘a’,’b’,’c’,’d’};则下列说法正确的是（ ）', '2', 'A.数组a与数组b等价；B.数组a和数组b的长度相同；C.数组a的长度大于数组b的长度；D.数组a的长度小于数组b的长度 ', 'C', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10464', '设已定义i和k为int类型变量，则以下for循环语句( )。for ( i =0; i!=0; i++ )cout<< \" * * * * n \";', '2', 'A.判断循环结束的条件不合法；B.循环一次也不执行；C.循环只执行一次；D.是无限循环', 'B', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10465', '执行以下程序段后, 输出的结果为（）。int a=4,b=5,t=0；if(a>b) t=a；a=b；b=t；cout<<\"a=\"<<a<<\",b=\"<<b<<endl；', '2', 'A.a=5,b=0；B.a=5,b=4；C.a=4,b=5；D.语法错误', 'A', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10466', '执行以下程序段后，m的值为 ( )。int a[2][3]={{1,2,3},{4,5,6}}；int m,*p=&a[0][0]；m=(*p)*(*(p+2))*(*(p+4))；', '3', 'A.15；B.14；C.13；D.12 ', 'A', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10467', '在C++中使用流进行输入输出，其中用于屏幕输出的对象是( )', '2', 'A.cerr；B.cout；C.cfile；D.cin ', 'B', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10468', '在参数传递过程中，对形参和实参的要求是（ ）', '2', 'A.函数定义时，形参一直占用存储空间；B.形参可以是常量、变量或表达式；C.实参可以是常量、变量或表达式；D.形参和实参类型和个数都可以不同', 'C', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10469', '假定AA为一个类，a为该类公有的数据成员，x为该类的一个对象，则访问x对象中数据成员a的格式为（ ）', '3', 'A.x(a)；B.x[a]；C.x->a；D.x.a ', 'D', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10470', '一个类的友元函数可以访问类的( )成员', '2', 'A.私有；B.保护；C.公有；D.以上都正确', 'D', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10471', '下列对基类和派生类关系的描述中，错误的是（ ）', '2', 'A.派生类是基类的子集；B.派生类是基类的组合；C.派生类是基类的具体化；D.派生类是基类定义的延续', 'A', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10472', '下列对派生类的描述中，错误的是（ ）', '2', 'A.一个派生类可以作为另一个派生类的基类；B.派生类至少有一个基类；C.派生类的缺省继承方式是private；D.派生类只继承了基类的公有成员和保护成员', 'B', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10473', '设置虚基类的声明中，正确的是（ ）', '2', 'A.减少目标代码；B.提高运行效率；C.消除二义性；D.简化程序', 'C', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10474', '下列描述中，（ ）是抽象类的特征', '2', 'A.不能说明其对象；B.可以进行构造函数重载；C.可以定义友元函数；D.可以说明虚函数', 'D', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10475', '关于运算符重载，下列说法正确的是（ ）', '2', 'A.重载时，运算符的功能可以改变；B.重载时，运算符的操作数个数可以改变；C. 重载时，运算符的优先级可以改变；D.重载时，运算符的结合性可以改变', 'A', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10476', '编写C++程序一般需经过的几个步骤依次是（ ）', '2', 'A.编辑、调试、编译、连接；B.编辑、编译、连接、运行；C. 编译、调试、编辑、连接；D.编译、编辑、连接、运行', 'B', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10477', '决定C++语言中函数的返回值类型的是（ ）', '2', 'A. 调用该函数时系统随机产生的类型；B.调用该函数时的主调用函数类型；C.在定义该函数时所指定的数据类型；D. return语句中的表达式类型', 'C', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10478', '假定AB为一个类，则执行\"AB a(2), b［3］,*p［4］;\"语句时调用该类构造函数的次数 为（ ）', '2', 'A.3；B.9；C.5；D.4', 'D', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10479', '所谓数据封装就是将一组数据和与这组数据有关操作组装在一起，形成一个实体，这实体也就是（ ）', '2', 'A.类；B.对象；C.函数体；D.数据块', 'A', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10480', '所谓多态性是指 （ ）', '2', 'A. 不同的对象调用不同名称的函数；B.不同的对象调用相同名称的函数；C.一个对象调用不同名称的函数；D.一个对象调用不同名称的对象', 'B', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10481', '假定一个类的构造函数为\"A(int i=4, int j=0) {a=i;b=j;}\", 则执行\"A x (1);\"语 句后，x.a和x.b的值分别为（ ）', '2', 'A.4和1；B.1和4；C.1和0；D.4和0', 'C', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10482', '下列程序的输出结果是（ ） 。\n#include <iostream.h>\nvoid main() {int n[][3]={10,20,30,40,50,60};\nint *p=&n[0][0];\ncout<<*p<<\",\"<<*(p+1)<<endl;}', '2', 'A.40,20；B.40,21；C.10,21；D.10,20', 'D', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10483', '在C++中，使用流进行输入输出，其中用于屏幕输入（ )', '2', 'A.cin；B.cout；C.cett；D.clog', 'A', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10484', '假定AA为一个类，a( )为该类公有的函数成员，x为该类的一个对象，则访问x对象中函数成员a( )的格式为（ ）', '2', 'A.x.a；B.x.a()；C.x->a；D.(*x).a()', 'B', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10485', '关于对象概念的描述中，说法错误的是（ )', '2', 'A.对象是类的一个变量；B.对象之间的信息传递是通过消息进行的；C.对象就是C语言中的结构变量；D.对象代表着正在创建的系统中的一个实体', 'C', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10486', '类MyA的复制构造函数是 （ ）', '2', 'A.MyA(MyA)；B.MyA()；C.MyA(MyA*)；D.MyA(MyA&)', 'D', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10487', '在C++中，函数原型不能标识（ ）', '2', 'A.函数的功能；B.函数的返回类型；C.函数参数的个数；D.函数参数类型', 'A', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10488', '使用地址作为实参传给形参，下列说法正确的是（ ）', '2', 'A.形参是实参的备份；B. 实参与形参是同一对象；C.实参是形参的备份；D.实参与形参无联系', 'B', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10489', '下列不是描述类的成员函数的是（ ）', '2', 'A.构造函数；B.析构函数；C.友元函数；D.拷贝构造函数', 'C', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10490', '下面有关类说法不正确的是（ ）', '2', 'A.在一个类中可以说明具有类类型的数据成员；B.一个类可以有多个构造函数；C.一个类只有一个析构函数；D.析构函数需要指定参数', 'D', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10491', '一个类的友元函数可以访问类的( )成员', '2', 'A. 局部变量；B.静态变量；C.寄存器变量；D.全局变量', 'A', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10492', '下列有关重载函数的说法中正确的是（ ）', '2', 'A.重载函数参数个数必须相同；B.重载函数必须有不同的形参列表；C.重载函数名可以不同；D.重载函数必须具有不同的返回值类型', 'B', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10493', 'this指针存在的目的是（ ）', '2', 'A.保证基类私有成员在子类中可以被访问；B. 保证基类保护成员在子类中可以被访问；C.保证每个对象拥有自己的数据成员，但共享处理这些数据成员的代码；D. 保证基类公有成员在子类中可以被访问', 'C', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10494', '以下基类中的成员函数表示纯虚函数的是（ ）', '2', 'A.void tt(int)=0；B.virtual void tt(int)；C.virtual void tt(int){}；D.virtual void tt()=0', 'D', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10495', '为了提高程序的运行速度，可将不太复杂的功能用函数实现，此函数应选择（ ）', '2', 'A.内联函数；B.重载函数；C.递归函数；D.函数模板', 'A', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10496', '下列不属于C++关键字的是', '2', 'A.extern；B.goto；C.free；D.default', 'C', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10497', 'C++中定义标准输入输出的库为', '2', 'A.stdio；B.math；C.iostream；D.stdlib', 'C', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10498', 'My是一个类，则执行语句My a[3]，*p[2]之后，自动调用构造函数次数为', '2', 'A.2；B.3；C.4；D.5', 'B', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10499', '下列语句错误的是', '2', 'A.int val(20)；B.extern int val(20)；C.const int val；D.extern const int val', 'C', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10500', '下列说法中，有关构造函数是正确的是', '2', 'A.任何一类必定有构造函数；B.可定义没有构造函数的类；C.构造函数不能重载；D.任何一类必定有缺省的构造函数', 'A', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10501', '下面关于类和对象说法不正确是', '2', 'A.类由数据与函数组成；B.一个对象必属于某个类；C.对象是类的实例；D.一个类的对象只有一个', 'D', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10502', '下面选项中不是类成员函数的是', '2', 'A.构造函数；B.析构函数；C.友元函数；D.静态函数', 'C', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10503', '在C++中类之间的继承关系具有', '2', 'A.自反性；B.对称性；C.传递性；D.反对称性', 'C', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10504', 'C++中类的成员默认为', '2', 'A.public；B.private；C.protected；D.static', 'B', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10505', 'C++中要实现动态联编，调用虚函数时必须使用', '2', 'A.基类指针；B.类名；C.派生类指针；D.对象名', 'C', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10506', '下面对析构函数的正确描述是', '2', 'A.系统不能提供默认的析构函数；B.析构函数必须由用户定义；C.析构函数没有参数；D.析构函数可以设置默认参数', 'C', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10507', '在下面的二维数定义正确的是', '2', 'A.int ary[5][];B.int ary[][5]={{0,1,2}};C.int ary[][5];D.int ary[5,5]', 'B', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10508', '以下说法中正确的是', '2', 'A.C++程序总是从第一个定义的函数开始执行；B.C++程序总是从main函数开始执行；C.C++中函数必须有返回值；D.C++中函数名必须唯一', 'B', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10509', '下面声明纯虚函数语句正确的是', '2', 'A.void fun( ) =0；B.virtual void fun( )=0；C.virtual void fun( )；D.virtual void fun( ){ }', 'B', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10510', '对于拷贝初始化构造函数和赋值操作的关系，正确的描述是', '2', '拷贝初始化构造函数和赋值操作是完全一样的操作；B.进行赋值操作时，会调用类的构造函数；C.当调用拷贝初始化构造函数时，类的对象正在被建立并被初始化；D.拷贝初始化构造函数和赋值操作不能在同一个类中被同时定义', 'C', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10511', '使用重载函数的目的是', '2', 'A.共享函数数据；B.减少代码量；C.优化运行效率；D.提高可读性', 'D', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10512', 'C++语言对C语言做了很多改进，C++语言相对于C语言的最根本的变化是', '2', 'A.增加了一些新的运算符；B.允许函数重载，并允许设置缺省参数；C.规定函数说明符必须用原型；D.引进了类和对象的概念', 'D', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10513', '对类成员访问权限的控制，是通过设置成员的访问控制属性实现的，下列不是访问控制属性的是', '2', 'A.公有类型；B.私有类型；C.保护类型；D.友元类型', 'D', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10514', '下列关于类的权限描述错误的是', '2', 'A.类本身的成员函数可以访问自身的任何成员；B.类的对象只能访问公有成员；C.普通函数可以不通过对象直接访问类的公有成员；D.普通函数可以不通过对象直接访问类的公有成员', 'C', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10515', '只能在自身类和子类成员函数中被访问，无法通过对象在类外访问的成员属于', '2', 'A.private；B.protected；C.public；D.publish', 'B', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10516', '面向对象中的\"对象\"是指', '2', 'A.行为抽象；B.数据抽象；C.行为抽象和数据抽象的统一；D.行为抽象和数据抽象的对立', 'C', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10517', '在类外定义成员函数时，：：运算符两侧分别连接', '2', 'A.返回值类型 函数名；B.返回值类型 类名；C.函数名 类名；D.类名 函数名', 'D', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10518', '设函数int& index(int * a，int i)返回数组a中下标为i的元素，如存在整型数组int Array[]={1，2，3}，在执行index(Array，2)+ +后，Array中各元素值为', '2', 'A.{0,1,2}；B.{1,1,2}；C.{1,2,4}；D.{0,2,3}', 'C', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10519', '类构造函数定义的位置是', '2', 'A.类体内或体外；B.只是在类体内；C.只在类体外；D.在类的成员函数中', 'A', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10520', '设存在数组a，其长度为Len，则下列哪项泛型算法用于在a中寻找值Value的位置', '2', 'A.reverse(a，a+Len，Value)；B.sort(a，a+Len，Value)；C.find(a，a+Len，Value)；D.copy(a，a+Len，Value)', 'C', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10521', '关于对象的性质，下列描述错误的是：', '2', 'A.同一类对象间可相互赋值；B.可以使用对象数组；C.对象不可以用作函数参数；D.一个对象可以用作另一个类的成员', 'C', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10522', '声明一个没有初始化参数的对象，需调用', '2', 'A.指定参数构造函数；B.拷贝构造函数；C.初始化函数；D.默认构造函数', 'D', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10523', '下列运算符不能重载的是', '2', 'A.!；B.sizeof；C.new；D.delete', 'B', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10524', '如P是一指针类型表达式，则下列表达式中不是左值表达式的是', '2', 'A.P；B.*P；C.&P；D.P+1', 'D', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10525', '使用下列流格式控制符能输出一个换行符的是', '2', 'A.dec；B.oct；C.hex；D.endl', 'D', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10526', '下列表达式，能将P声明为常量指针的是', '2', 'A.const int * P；B.int*const P；C.const int * const P；D.int * P', 'A', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10527', 'C++程序文件扩展名为', '2', 'A..cpp；B..h；C..lib；D..obj', 'A', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10528', '对C++中主函数描述正确的是', '2', 'A.名称为main，可为多个；B.名称不限，可为多个；C.名称为main，必须有且只能有一个；D.名称不限，必须有且只能有一个', 'C', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10529', '假定有char * P=\"Hello\"；，要输出这个字符串的地址值的正确写法是', '2', 'A.cout<< *P；B.cout<<P；C.cout<<&P；D.cout<<(void *)P', 'C', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10530', '下列描述错误的是', '2', 'A.在没创建对象前，静态成员不存在；B.静态成员是类的成员，不是对象成员；C.静态成员不能是虚函数；D.静态成员函数不能直接访问非静态成员', 'A', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10531', '对于友元描述正确的是', '2', 'A.友元是本类的成员函数；B.友元不是本类的成员函数；C.友元不是函数；D.以上皆不正确', 'B', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10532', '一个函数功能不太复杂，但要求频繁使用，则该函数适合作为', '2', 'A.内联函数；B.重载函数；C.递归函数；D.嵌套函数', 'A', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10533', '下列默认参数的声明不正确的是', '2', 'A.int max(int a，int b，int c，int d=0)；B.int max(int a，int b，int c=0，int d=0)；C.int max(int a=0，int b，int c=0，int d=0)；D.int max(int a，int b=0，int c=0，int d=0)', 'C', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10534', '在编译指令中，宏定义使用的指令是', '2', 'A.#include；B.#define；C.#if；D.#else', 'B', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10535', '基类中的protected成员，通过哪种派生，其在派生类中的可见性为protected', '2', 'A.public和private；B.public和protected；C.protected和private；D.仅protected', 'B', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10536', '基类中的public成员，通过public派生，基在派生类中的可见性为', '2', 'A.不可访问；B.private；C.protected；D.public', 'D', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10537', '不同对象调用同名函数，但导致完全不同行为的现象称为', '2', 'A.抽象；B.封装；C.继承；D.多态性', 'D', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10538', '头文件扩展名为', '2', 'A.cpp；B.h；C.ub；D.ob', 'B', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10539', '声明函数为内联使用的关键字为', '2', 'A.const；B.inline；C.short；D.singned', 'B', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10540', '设类A中有静态数据成员x，两个A类对象a和b，若a．x10，则b．x的值为', '2', 'A.9；B.10；C.11；D.不能确定', 'B', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10541', 'C ++允许在结构中定义函数，这些函数称为', '2', 'A.静态函数；B.构造函数；C.析构函数；D.成员函数', 'D', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10542', '下列哪种类型的函数适合声明为内联函数', '2', 'A.函数体语句较多；B.函数体逻辑较复杂；C.函数执行时间较长；D.函数语句较少，执行速度要求高', 'D', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10543', '析构函数的返回值类型为', '2', 'A.void；B.bool；C.int；D.无类型', 'D', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10544', '函数重载必须满足的条件是', '2', 'A.函数名相同；B.参数个数不同；C.参数类型不同；D.函数名不相同', 'A', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10545', '下列表达式，哪个是声明P为指向常量的常量指针', '2', 'A.const int*P；B.int*const P；C.const int*const P；D.int*P', 'C', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10546', 'C++中函数中的return指令可以', '2', 'A.只能有一条；B.0或多条；C.至少有一条；D.只能主函数调用', 'B', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10547', '类声明的内容用花括号括起来，在花括号后跟哪个符号表示类声明结束', '2', 'A.：；B.；；C.，；D. .', 'B', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10548', '使用new Point(5，7)创建对象，调用的是下列哪个构造函数', '2', 'A.Point：：Point()；B.Point：：Point(int，int)；C.Point：：Creat()；D.Point：：Creat(int，int)', 'B', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10549', '类中的protected成员在何处访问', '2', 'A.只类自身成员函数中；B.只子类成员函数中；C.类和子类的成员函数中；D.通过对象类外访问', 'C', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10550', '在类中使用static关键字修饰的成员函数称为', '2', 'A.全局成员函数；B.公有成员函数；C.静态成员函数；D.非静态成员函数', 'C', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10551', '用于标识十六进制常量的前缀或后缀是', '2', 'A.无；B.后缀L或l；C.前缀零；D.前缀Ox', 'D', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10552', '在定义结构时，为产生封装性，则需使用哪个关键字数据成员', '2', 'A.public；B.publish；C.protected；D.private', 'D', '2', '1', '102');
INSERT INTO `t_question` VALUES ('10553', '函数模板template<typename T>void Func(T，T)不能具有哪种实例化形式', '2', 'A.void Func(int．Int)；B.void Func(bool，b001)；C.void Func(double．int)；D.void Func(char，char)', 'C', '2', '1', '102');
INSERT INTO `t_subject` VALUES ('101', 'c语言');
INSERT INTO `t_subject` VALUES ('102', 'c++');
INSERT INTO `t_subject` VALUES ('103', 'Java');
INSERT INTO `t_subject` VALUES ('104', 'Python');
INSERT INTO `t_subject` VALUES ('105', '.net');
INSERT INTO `t_type` VALUES ('1', '单选');
INSERT INTO `t_type` VALUES ('2', '多选');
INSERT INTO `t_type` VALUES ('3', '填空');
INSERT INTO `t_type` VALUES ('4', '判断');
INSERT INTO `t_type` VALUES ('5', '应用');
INSERT INTO `t_type` VALUES ('6', '简答');
INSERT INTO `t_user` VALUES ('10', 'admin', '888', '张磊', '13011111111', '0', '2019-07-27 20:40:00', 'super', null, null, null, null, null);
INSERT INTO `t_user` VALUES ('7', 'zz', '777', 'zzz', '130777', '0', '2019-07-27 20:42:07', 'super', null, null, null, null, null);
