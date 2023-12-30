package com.eryka.poc208.item.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

@StepScope
public class XMLValidationTasklet implements Tasklet {


    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        String xmlFilePath = (String) chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().get("xmlFilePath");
        String xsdFilePath = (String) chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext().get("xsdFilePath");

        assert xmlFilePath != null;
        Source xmlFile = new StreamSource(new File(xmlFilePath));

        assert xsdFilePath != null;
        Source xsdFile = new StreamSource(new File(xsdFilePath));

        SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        Schema schema = schemaFactory.newSchema(xsdFile);

        Validator validator = schema.newValidator();
        validator.validate(xmlFile);

        return RepeatStatus.FINISHED;
    }
}

