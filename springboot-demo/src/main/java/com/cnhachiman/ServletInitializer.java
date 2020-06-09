package com.cnhachiman;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {
//    不使用内嵌tomcat容器，打war包使用外部tomcat容器时需要释放此代码
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(DemoApplication.class);
//    }
}
