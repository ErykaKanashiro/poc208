package com.eryka.poc208.validator;

import com.eryka.poc208.domain.Documento;

import java.util.List;

public class DocumentoValidator {


    public static boolean documentoValido(List<Documento> documentos) {

        if (!(documentos.get(0).getDataBase().equals(documentos.get(1).getDataBase()))
                || !(documentos.get(0).getCnpj().equals(documentos.get(1).getCnpj()))
                || !(documentos.get(0).getTipoRemessa().equals(documentos.get(1).getTipoRemessa()))) {
            return false;
        }
        return true;
    }

}
