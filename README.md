Green
-------------------
Green，一个关于人和自然的社区。  
以花草作为核心主题，汇聚对自然生活有所向往的群体，彼此分享交流。

此项目是作为一名编程新手的练手之作，借此项目熟悉前端技术，了解后端运作的机制。  

——2014.6.11  

Screen Shot
-------------------
![image](http://orangehat.u.qiniudn.com/Green.png)

项目框架简介
-------------------
**[Green DEMO](HTTP://112.124.114.112:8080/Green/)**

`测试帐号：  
用户名: admin  
密码: admin ` 

该项目基于Maven3.0构建。  

后端：以Spring Framework为核心，使用Spring MVC作为模型视图控制器，Hibernate作为数据库持久化。  
前端：以Bootstrap和jQuery为主，多种开源的前端项目为辅。

项目前端所使用的开源项目列表：  
「1」：[Bootstrap](https://github.com/twbs/bootstrap)  
「2」：[jQuery](http://jquery.com/)  
「3」：[Bootstrap3-wysihtml5](https://github.com/schnawel007/bootstrap3-wysihtml5)  
「4」：[Hover](https://github.com/IanLunn/Hover)   
「5」：[html5shiv](https://github.com/aFarkas/html5shiv)

文件结构:
-------------------	
```
Green
├── src/main/resources
│   ├── applicationContext.xml
│   ├── green-dao.xml   
│   ├── green-service.xml  
│   ├── ehcache.xml
│   ├── jdbc.properties
│   └── log4j.properties             
│             
├── src/main/java
│   ├── com.green.cons
│   ├── com.green.dao  
│   ├── com.green.domain  
│   ├── com.green.domain.hbm
│   ├── com.green.exception
│   ├── com.green.service
│   └── com.green.web
│  
├── src/main/webapp
│   ├── css
│   ├── fonts 
│   ├── images
│   ├── js
│   ├── index.jsp...
│   └── WEB-INF
│       ├── tags
│       ├── green-servlet.xml
│       └── web.xml
│
│
├── schema
├── README.md
├── favicon.ico
└── pom.xml
```

运行项目:
-------------------	
使用Maven:

    $ cd Green
    $ mvn tomcat7:run

或

在你所喜好的IDE中，例如 SpringSource Tool Suite (STS) 或 IDEA等等:

* 以 Maven Project 的形式导入 Green
* 部署至Tomcat服务器

从浏览器中访问 http://localhost:8080/Green


License:
-------------------
(The MIT License)

Copyright (c) 2014 阿树 <OrangeHat.rb@gmail.com>

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
'Software'), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED 'AS IS', WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
