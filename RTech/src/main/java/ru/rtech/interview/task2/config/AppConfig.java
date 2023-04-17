package ru.rtech.interview.task2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import ru.rtech.interview.task2.utils.YamlPropertySourceFactory;

@Configuration
@ComponentScan(basePackages = {"ru.rtech.interview.task2"})
@PropertySource(
        factory = YamlPropertySourceFactory.class,
        value = {"classpath:task2-config.yaml", "file:${catalina.home}/conf/task2/task2-config.yaml"},
        ignoreResourceNotFound = true)
public class AppConfig {

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        ResourceBundleMessageSource commonMessageSource = new ResourceBundleMessageSource();
        commonMessageSource.setBasename("common_messages");
        commonMessageSource.setDefaultEncoding("UTF-8");
        messageSource.setParentMessageSource(commonMessageSource);
        return messageSource;
    }
}
