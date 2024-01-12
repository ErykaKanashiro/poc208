//package com.eryka.poc208.item.writer;
//
//import com.eryka.poc208.domain.Documento;
//import com.eryka.poc208.util.DocumentoUtil;
//import com.eryka.poc208.validator.DocumentoValidator;
//import org.springframework.batch.core.JobExecution;
//import org.springframework.batch.core.configuration.annotation.JobScope;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.Marshaller;
//import java.io.FileWriter;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@JobScope
//@Configuration
//public class DocumentoXMLWriter implements ItemWriter<Documento> {
//
//    @Value("#{jobExecution}")
//    private JobExecution jobExecution;
//
//    @Override
//    public void write(List<? extends Documento> documentos) throws Exception {
//
////        if (!DocumentoValidator.documentoValido((List<Documento>) documentos))
////            throw new RuntimeException("Informações de cabeçalho diferentes! Revise os documentos");
//
//        String outputFile = "src/main/resources/saida/" + DocumentoUtil.gerarNome(documentos.get(0).getDataBase());
//
//        Documento documentoComb = new Documento();
//
//        List<Conta> contasAgrupadas = agruparContas((List<Documento>) documentos);
//
//        documentoComb.setCodigoDocumento("4111");
//        documentoComb.setCnpj(documentos.get(0).getCnpj());
//        documentoComb.setDataBase(documentos.get(0).getDataBase());
//        documentoComb.setTipoRemessa(documentos.get(0).getTipoRemessa());
//        documentoComb.setContas(contasAgrupadas);
//
//        FileWriter fileWriter = new FileWriter(outputFile);
//        fileWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
//
//
//        JAXBContext context = JAXBContext.newInstance(Documento.class, Conta.class);
//        Marshaller marshaller = context.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//        // Customização para garantir a geração de tags auto-fechadas
//        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
//
//        marshaller.marshal(documentoComb, fileWriter);
//
//        jobExecution.getExecutionContext().put("generatedXmlContent",fileWriter.toString());
//        jobExecution.getExecutionContext().put("xmlFilePath",outputFile);
//
//        fileWriter.close();
//    }
//
//    private List<Conta> agruparContas(List<Documento> documentos) {
//        Map<String, BigDecimal> mapaContas = new HashMap<>();
//
//        for (Documento documento : documentos) {
//            for (Conta conta : documento.getContas()) {
//                String codigoConta = conta.getCodigoConta();
//                BigDecimal saldoDia = conta.getSaldoDia();
//
//                mapaContas.put(codigoConta, mapaContas.getOrDefault(codigoConta, BigDecimal.ZERO).add(saldoDia));
//            }
//        }
//
//        List<Conta> contasAgrupadas = new ArrayList<>();
//
//        for (Map.Entry<String, BigDecimal> entry : mapaContas.entrySet()) {
//            Conta contaAgrupada = new Conta();
//            contaAgrupada.setCodigoConta(entry.getKey());
//            contaAgrupada.setSaldoDia(entry.getValue());
//            contasAgrupadas.add(contaAgrupada);
//        }
//        return contasAgrupadas;
//    }
//}
