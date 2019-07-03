package com.github.flowable;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.flowable.spring.boot.app.AppEngineRestConfiguration;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.DefaultBeanNameGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @Description:
 * @Author: Bruce.liu
 * @Since:9:18 2019/1/19
 */
@EnableSwagger2Doc
@SpringBootApplication
@ComponentScan(nameGenerator = DefaultBeanNameGenerator.class)
public class FlowableApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlowableApplication.class, args);
    }

    public static class SpringBeanNameGenerator implements BeanNameGenerator {
        @Override
        public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
            return null;
        }
    }
}
