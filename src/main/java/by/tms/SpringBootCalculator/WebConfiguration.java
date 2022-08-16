package by.tms.SpringBootCalculator;

import by.tms.SpringBootCalculator.interceptor.SecurityInterceptor;
import by.tms.SpringBootCalculator.interceptor.SecurityInterceptor2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(new SecurityInterceptor())
                .addPathPatterns("/user/logout", "/calculator/calc", "/calculator/history",
                        "/user/account", "/user/changePassword", "/user/changeName");
        registry
                .addInterceptor(new SecurityInterceptor2())
                .addPathPatterns("/user/reg", "/user/login");
    }
}
