package com.eryka.poc208.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

@Configuration
public class XsdSchemaConfig {

    @Bean
    public Schema schema() throws Exception {
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        return factory.newSchema(new File("src/main/resources/xsd/XSD_4111.xsd"));
    }
}

