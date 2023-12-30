package com.eryka.poc208.item.listener;

import lombok.AllArgsConstructor;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.xml.sax.SAXException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

@AllArgsConstructor
@Configuration
public class XMLValidatorListener implements JobExecutionListener {

    @Autowired
    private final Schema schema;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        jobExecution.getExecutionContext().put("xsdFilePath", "src/main/resources/xsd/XSD_4111.xsd");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {

        String xmlFilePath = (String) jobExecution.getExecutionContext().get("xmlFilePath");
        String xsdFilePath = (String) jobExecution.getExecutionContext().get("xsdFilePath");

        Source xmlFile = new StreamSource(new File(xmlFilePath));
        Source xsdFile = new StreamSource(new File(xsdFilePath));

        try {

            SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            Schema schema = schemaFactory.newSchema(xsdFile);
            Validator validator = schema.newValidator();
            validator.validate(xmlFile);

        } catch (SAXException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}
