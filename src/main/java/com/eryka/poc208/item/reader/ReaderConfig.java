//package com.eryka.poc208.item.reader;
//
//import com.eryka.poc208.domain.Documento;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.file.MultiResourceItemReader;
//import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
//import org.springframework.batch.item.xml.StaxEventItemReader;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.core.io.Resource;
//import org.springframework.oxm.jaxb.Jaxb2Marshaller;
//
//@Configuration
//public class ReaderConfig {
//
//    @Bean
//    public ItemReader<Documento> xmlItemReader() {
//
//        MultiResourceItemReader<Documento> multiReader = new MultiResourceItemReader<>();
//        multiReader.setResources(getXmlFiles());
//        multiReader.setDelegate(singleXmlItemReader());
//
//        return multiReader;
//    }
//
//    private Resource[] getXmlFiles() {
//        return new Resource[]{
//                new FileSystemResource("src/main/resources/entrada/xml_208_1.xml"),
//                new FileSystemResource("src/main/resources/entrada/xml_208_2.xml")
//        };
//    }
//
//    private ResourceAwareItemReaderItemStream<Documento> singleXmlItemReader() {
//
//        StaxEventItemReader<Documento> reader = new StaxEventItemReader<>();
//        reader.setFragmentRootElementName("documento");
//        reader.setUnmarshaller(contaUnmarshaller());
//        return reader;
//    }
//
//    @Bean
//    public Jaxb2Marshaller contaUnmarshaller() {
//        Jaxb2Marshaller unmarshaller = new Jaxb2Marshaller();
//        unmarshaller.setClassesToBeBound(Documento.class); // Classe Java correspondente ao elemento documento
//        return unmarshaller;
//    }
//}