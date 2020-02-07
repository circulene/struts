package org.superbiz.struts;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FilterRegistrationBean<SiteMeshFilter> siteMeshFilterBean() {
        FilterRegistrationBean<SiteMeshFilter> filterRegistrationBean = new FilterRegistrationBean<>(new SiteMeshFilter());
        filterRegistrationBean.setName("sitemesh");
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<StrutsPrepareAndExecuteFilter> strutsPrepareAndExecuteFilterBean() {
        FilterRegistrationBean<StrutsPrepareAndExecuteFilter> filterRegistrationBean = new FilterRegistrationBean<>(new StrutsPrepareAndExecuteFilter());
        filterRegistrationBean.setName("struts2");
        filterRegistrationBean.addUrlPatterns(
                "/",
                "/addUserForm.action",
                "/addUser.action",
                "/findUserForm.action",
                "/findUser.action",
                "/listAllUsers.action");
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }

}
