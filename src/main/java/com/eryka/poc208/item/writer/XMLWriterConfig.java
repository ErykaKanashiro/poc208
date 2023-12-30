package com.eryka.poc208.item.writer;

import com.eryka.poc208.domain.Conta;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import java.util.List;

@Configuration
public class XMLWriterConfig implements ItemWriter<Conta> {

    private String outputFilePath = "src/main/resources/saida/xml_208_3.xml";

    @Override
    public void write(List<? extends Conta> contas) throws Exception {

        StaxEventItemWriter<Conta> writer = new StaxEventItemWriter<>();

        writer.setResource(new FileSystemResource(outputFilePath));
        writer.setRootTagName("documento");

        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Conta.class);

        writer.setMarshaller(marshaller);
        writer.afterPropertiesSet(); // Força a inicialização do writer

        writer.open(null);
        writer.write(contas);
        writer.close();
    }

    private void consolidaContas(List<? extends Conta> contas) {

    }
}
