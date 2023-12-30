package com.eryka.poc208.config;

import com.eryka.poc208.domain.Documento;
import com.eryka.poc208.item.tasklet.XMLValidationTasklet;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private ItemReader<Documento> reader;

    @Autowired
    private ItemWriter<Documento> writer;

    @Bean
    public Step consolidateAccountsStep() {
        return stepBuilderFactory.get("consolidateAccountsStep")
                .<Documento, Documento>chunk(2000)
                .reader(reader)
                .writer(writer)
                .build();
    }
    @Bean
    public Step xmlValidationStep() {
        return stepBuilderFactory.get("xmlValidationStep")
                .tasklet(xmlValidationTasklet())
                .build();
    }
    @Bean
    public XMLValidationTasklet xmlValidationTasklet() {
        return new XMLValidationTasklet();
    }
}
