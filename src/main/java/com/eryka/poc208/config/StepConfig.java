package com.eryka.poc208.config;

import com.eryka.poc208.domain.Conta;
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
    private ItemReader<Conta> reader;
//
//    @Autowired
//    private ItemProcessor<Conta, Conta> processor;


    @Autowired
    private ItemWriter<Conta> writer;

    @Bean
    public Step consolidateAccountsStep() {
        return stepBuilderFactory.get("consolidateAccountsStep")
                .<Conta, Conta>chunk(10)
                .reader(reader)
               // .processor(processor)
                .writer(writer)
                .build();
    }
}
