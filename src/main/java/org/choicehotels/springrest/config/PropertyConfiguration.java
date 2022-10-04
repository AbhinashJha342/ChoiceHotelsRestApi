package org.choicehotels.springrest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ConfigurationProperties(prefix="spring.datasource") ; this is a springboot property
@PropertySource("classpath:/application.properties")
public class PropertyConfiguration {

}
