package com.ititon.service_api.config;

import com.ititon.dao.config.PersistenceConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"com.ititon.service_impl"})
//@ContextConfiguration(classes = PersistenceConfig.class) // for test
@Import(value = {PersistenceConfig.class, MailConfig.class})
public class ServiceConfig {
}
