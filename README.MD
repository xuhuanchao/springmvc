##Basic function of spring mvc.
Most of the content comes from <Srping MVC 学习指南>.

##package show
###com.xhc.test.springmvc.decoupcontroller
自定义Servlet，模拟spring的servlet控制器，根据访问路径不同调用不同的controller，controller为特定接口

###com.xhc.test.springmvc.embedtomcat
嵌入式启动tomcat，使用src/main/webapp/做为web工程根目录，默认端口8080

###com.xhc.test.springmvc.initspring
spring依赖注入的测试用例bean的代码

###com.xhc.test.springmvc.ws
webService的代码，使用cxf和spring集成