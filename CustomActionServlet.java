package com.example.config;

import javax.servlet.ServletException;
import org.apache.struts.action.ActionServlet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomActionServlet extends ActionServlet {

    private static ApplicationContext springContext;

    @Override
    public void init() throws ServletException {
        super.init();
        // Khởi tạo Spring Boot Context
        springContext = new AnnotationConfigApplicationContext(SpringBootConfig.class);
    }

    public static ApplicationContext getSpringContext() {
        return springContext;
    }
}
