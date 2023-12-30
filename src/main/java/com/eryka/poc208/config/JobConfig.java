package com.eryka.poc208.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class JobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepConfig stepConfig;

    @Bean
    public Job consolidateAccountsJob() {
        return jobBuilderFactory.get("consolidateAccountsJob")
                .start(stepConfig.consolidateAccountsStep())
                .build();
    }
}
