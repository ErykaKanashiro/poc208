package com.eryka.poc208.item.reader;

import com.eryka.poc208.domain.Documento;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import java.io.IOException;

@Configuration
public class ReaderCustomXML implements ItemReader<Documento> {

    private Resource[] inputXmlFiles;
    private int nextFileIndex;
    private MultiResourceItemReader<Documento> delegate;

    // Construtor para especificar o caminho do arquivo de saída
    public ReaderCustomXML(String[] inputFilePaths) {
        this.inputXmlFiles = getResources(inputFilePaths);
        this.nextFileIndex = 0;
        this.delegate = createDelegateReader();
    }

    private MultiResourceItemReader<Documento> createDelegateReader() {
        MultiResourceItemReader<Documento> multiReader = new MultiResourceItemReader<>();
        multiReader.setDelegate(createSingleFileReader());
        multiReader.setResources(inputXmlFiles);
        return multiReader;
    }

    private StaxEventItemReader<Documento> createSingleFileReader() {
        StaxEventItemReader<Documento> reader = new StaxEventItemReader<>();
        reader.setFragmentRootElementName("documento");
        Jaxb2Marshaller unmarshaller = new Jaxb2Marshaller();
        unmarshaller.setClassesToBeBound(Documento.class);
        reader.setUnmarshaller(unmarshaller);
        return reader;
    }

    private Resource[] getResources(String[] inputFilePaths) {
        try {
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            return resolver.getResources("classpath:/entrada/*.xml");
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar arquivos XML", e);
        }
    }

    @Override
    public Documento read() throws Exception {
        if (delegate == null) {
            delegate = createDelegateReader();
            delegate.open(null);
        }
        Documento documento = delegate.read();
        if (documento == null && nextFileIndex < inputXmlFiles.length - 2) {
            // Se chegou ao final do arquivo atual e ainda há mais arquivos, passa para o próximo
            delegate.close();
            nextFileIndex++;
            delegate.setResources(new Resource[]{inputXmlFiles[nextFileIndex]});
            delegate.open(new ExecutionContext());
            documento = delegate.read();
        }
        return documento;
    }
}
