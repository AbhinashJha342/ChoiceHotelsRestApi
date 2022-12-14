package org.choicehotels.springrest.config;

import org.choicehotels.springrest.exception.GlobalExceptionResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        //after externalizing need to change the context path to the externalized project path.
        marshaller.setContextPath("org.choicehotel.generated");
        return marshaller;
    }

    @Bean
    public GlobalExceptionResolver exceptionResolver() {
        return new GlobalExceptionResolver();
    }

}
