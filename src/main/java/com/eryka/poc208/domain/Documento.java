package com.eryka.poc208.domain;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlRootElement(name = "documento")
@XmlAccessorType(XmlAccessType.FIELD)
public class Documento {

    @XmlAttribute(name = "dataBase")
    private String dataBase;

    @XmlAttribute(name = "codigoDocumento")
    private String codigoDocumento;

    @XmlAttribute(name = "cnpj")
    private String cnpj;

    @XmlAttribute(name = "tipoEnvio")
    private String tipoEnvio;

    @XmlElement(name = "instituicoesFinanceiras")
    private InstituicoesFinanceiras instituicoesFinanceiras;

    @XmlElement(name = "investidoresInstitucionais")
    private InvestidoresInstitucionais investidoresInstitucionais;

    @XmlElement(name = "outrasPessoasJuridicas")
    private OutrasPessoasJuridicas outrasPessoasJuridicas;

    @XmlElement(name = "pessoasFisicas")
    private PessoasFisicas pessoasFisicas;

}
