package com.globant.demoService.config;

import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@SpringBootApplication
@ComponentScan(
    basePackages = {
       "com.globant.demoService.controller",
      "com.globant.demoService.services",
      "com.globant.demoService.repository"
    })
public class GlobalConfiguration implements WebMvcConfigurer {

  @Autowired private Environment environment;

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("redirect:/swagger-ui.html");
    registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
  }

  @Bean
  public ReloadableResourceBundleMessageSource messageSource() {
    ReloadableResourceBundleMessageSource bundle = new ReloadableResourceBundleMessageSource();
    bundle.setDefaultEncoding("UTF-8");
    Properties fileEncodings = new Properties();
    fileEncodings.setProperty("application-messages", "UTF-8");
    bundle.setFileEncodings(fileEncodings);
    bundle.setFallbackToSystemLocale(true);
    bundle.setBasename("classpath:application-messages");
    return bundle;
  }
}
