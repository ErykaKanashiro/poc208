package com.eryka.poc208.domain;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlRootElement(name = "documento")
@XmlAccessorType(XmlAccessType.FIELD)
public class Documento {

    @XmlAttribute(name = "codigoDocumento")
    private String codigoDocumento;

    @XmlAttribute(name = "cnpj")
    private String cnpj;

    @XmlAttribute(name = "dataBase")
    private String dataBase;

    @XmlAttribute(name = "tipoRemessa")
    private String tipoRemessa;

    @XmlElementWrapper(name = "contas")
    @XmlElement(name = "conta")
    private List<Conta> contas;

}
