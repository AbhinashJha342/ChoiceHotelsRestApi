package org.choicehotels.springrest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class SoapClientConfig {


    @Autowired
    private SoapConfig soapConfig;


    @Bean
    public WebServiceTemplate template(){
        return new WebServiceTemplate(soapConfig.marshaller());
    }

}
