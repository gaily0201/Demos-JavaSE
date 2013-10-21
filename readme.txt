2007年那个暑假至2010年那个难忘的10月，我做了三年JavaEE开发。
时常感觉自己是井底之蛙，有时也阿Q自己，然后继续憧憬北京&积蓄力量；
有多个通宵嗑瓜子喝可乐看电视剧的自在，也有多次梦中写代码调bug的惊魂之夜；
有无数加班的烦躁，也时常痛快畅饮。
有浓浓的失落感，也略有一丁点成就感；
有大悲也有窃喜，有小得也有大失；
不想过于感伤，也不必过于缅怀！
向恩师以及那些曾经一起战斗的兄弟们致敬！
此致。

言归正传，本篇代码全部是JavaSE相关的。
为什么？
1)        若不分享，这些代码就是躺在电脑里的一堆0和1，虽日久天长也不会发霉，但确实更像是没价值的数字垃圾。
2)        虽然没啥“高科技”的代码，但总有需要它们的人。 
有什么？
1)自己写的例子：或是为了在项目中应用某项技术而写的demo，或是为了纯粹学习某项技术而写的demo。
2)网上下载的例子：或改过或没改过，或完善过或原封没动。
没什么？
1)公司项目的源代码（这个真没有，虽然可以有，虽然已经离职2年有余）
以后若有时间，可以将项目源代码中的某些技术（并不是什么高深的技术）提炼出
来发帖子或博客，分享之。
`        2)公司业务紧密相关的测试代码。
1、        DataStructure：有3个演示排序算法的类，冒泡排序、插入排序和选择排序。
2、        JavaSortDemo：插入排序、希尔排序例子。
3、        DownLoadDemo：实现网络下载文件功能。
4、        JavaDB：实现JDBC连接Oracle数据库以及演示调用存储过程。
属性文件中配置数据库连接基本参数：
DRIVERS=oracle.jdbc.driver.OracleDriver
URL=jdbc:oracle:thin:@localhost:1521:ctcmc
USER=demo
PASSWORD=demo
5、        JavaDesignPatterns：仅仅一个工厂设计模式的例子。
6、        Javaenhance：传智播客java加强课程的一个工程，有：自动注入、AOP、反射、类加载器等等。
7、        JavaIODemo：Java IO常用类的演示。
8、        JavaMianShi：一些Java面试题目的示例代码。
9、        JavaSocketDemo：Java网络编程，实现Client与Server文件传输功能，有TCP、UPD两个版本。
10、        JavaStaticTest：静态变量、静态成员、静态域的一些测试。
11、        JavaTest：数组、日期类、异常的小测试。
12、        JavaThread：多线程开发相关的例子，比如：生产者、消费者的实现。
13、        javaTTD:一本敏捷开发书籍的例子（如果不看书，代码本身参考价值不大，太久远了，书名我忘记了）。
14、        JavaZip：实现将目录压缩成zip包及将zip解压缩的例子（当时项目中需要这样的功能，这个例子应该是从网上下载后做过修改）。
15、        jpaDemo：Java Persistence API的一些演示代码（存放jar包的某些目录已删除了，所以工程中的jar包有缺失，如有需要自己网上找全jar包吧）。
16、        JunitDemo：Junit使用方法的一些演示代码。
17、        luceneDemo：全文检索引擎工具包lucene演示代码。
zygLucene工程也是lucene相关的一个例子。
18、        RegexTest：演示正则表达式的一些代码，有实现统计代码量以及字符串处理相关方法。
19、        zygJavaDBPool：演示数据库连接池使用方法的例子。在MS SQL Server、Oracle上测试过。
20、        ZygParseXML：演示XML解析的例子，也有构造XML文件相关的代码。
