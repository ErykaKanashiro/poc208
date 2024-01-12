package com.eryka.poc208.item.writer;

import com.eryka.poc208.DocumentoService;
import com.eryka.poc208.domain.Documento;
import com.eryka.poc208.util.DocumentoUtil;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.util.List;

@JobScope
@Configuration
public class WriterCustomXML implements ItemWriter<Documento> {

    private String outputFile;

    @Override
    public void write(List<? extends Documento> documentos) throws Exception {
        outputFile = "src/main/resources/saida/" + DocumentoUtil.gerarNome(System.currentTimeMillis());
        Documento documentoConsolidado = consolidateDocuments((List<Documento>) documentos);

        FileWriter fileWriter = new FileWriter(outputFile);
        fileWriter.write("<?xml version=\"1.0\" encoding=\"iso-8859-1\" ?>\n");

        JAXBContext context = JAXBContext.newInstance(Documento.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Customização para garantir a geração de tags auto-fechadas
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

        marshaller.marshal(documentoConsolidado, fileWriter);

        fileWriter.close();
    }

    private Documento consolidateDocuments(List<Documento> documentos) {
        DocumentoService service = new DocumentoService();
        var consolidado = service.somarDocumentos(documentos.get(0),documentos.get(1));
        return consolidado;
    }
}