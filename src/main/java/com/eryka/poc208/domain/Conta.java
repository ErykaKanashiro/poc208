package com.eryka.poc208.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "conta")
public class Conta {

    private String codigoConta;

    private BigDecimal saldoDia;

    @XmlAttribute(name = "codigoConta")
    public String getCodigoConta() {
        return codigoConta;
    }

    public void setCodigoConta(String codigoConta) {
        this.codigoConta = codigoConta;
    }

    @XmlAttribute(name = "saldoDia")
    public BigDecimal getSaldoDia() {
        return saldoDia;
    }

    public void setSaldoDia(BigDecimal saldoDia) {
        this.saldoDia = saldoDia;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "codigoConta='" + codigoConta + '\'' +
                ", saldoDia=" + saldoDia +
                '}';
    }
}
