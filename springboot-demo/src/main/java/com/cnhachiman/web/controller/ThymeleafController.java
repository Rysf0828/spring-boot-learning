package com.cnhachiman.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/thymeleaf" )
public class ThymeleafController {

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        // 设置跳转的视图 默认映射到 src/main/resources/templates/{viewName}.html
        view.setViewName("index");
        // 设置属性
        view.addObject("title", "thymeleaf模板页面");
        view.addObject("desc", "springboot-demo project");
        Author author = new Author();
        author.setAge(25);
        author.setEmail("17717272109@163.com");
        author.setName("Hyy");
        view.addObject("author", author);
        return view;
    }

    @GetMapping("/index1")
    public String index1(HttpServletRequest request) {
        // TODO 与上面的写法不同，但是结果一致。
        // 设置属性
        request.setAttribute("title", "thymeleaf模板页面");
        request.setAttribute("desc", "springboot-demo project");
        Author author = new Author();
        author.setAge(22);
        author.setEmail("1575689987@qq.com");
        author.setName("Hyy");
        request.setAttribute("author", author);
        return "index";
    }

    class Author {
        private int age;
        private String name;
        private String email;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}