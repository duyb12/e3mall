package com.du.config;

import com.du.copy.MyImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.du.*")
@Import(MyImportBeanDefinitionRegistrar.class)
public class AppConfig {
}
