package com.eryka.poc208.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DocumentoUtil {

    public static String gerarNome(String dataBase){

        LocalDateTime agora = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        String dataFormatada = agora.format(formatter);

        return "xml_208_"+dataBase+"_"+dataFormatada+".xml";

    }
}
