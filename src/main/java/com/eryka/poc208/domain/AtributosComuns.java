package com.eryka.poc208.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class AtributosComuns {

    @XmlAttribute(name = "pre")
    private String pre;

    @XmlAttribute(name = "pos")
    private String pos;

    @XmlAttribute(name = "cdi")
    private String cdi;

    @XmlAttribute(name = "outros")
    private String outros;

    public AtributosComuns somar(AtributosComuns outrosAtributos) {
        var atributosSomados = new AtributosComuns();

        this.pre = somarValores(this.pre, outrosAtributos.pre);
        this.pos = somarValores(this.pos, outrosAtributos.pos);
        this.cdi = somarValores(this.cdi, outrosAtributos.cdi);
        this.outros = somarValores(this.outros, outrosAtributos.outros);

        atributosSomados.setCdi(this.cdi);
        atributosSomados.setPos(this.pos);
        atributosSomados.setPre(this.pre);
        atributosSomados.setOutros(this.outros);

        return atributosSomados;
    }

    private String somarValores(String valor1, String valor2) {
        Double doubleValor1 = valor1 != null && !valor1.isEmpty() ? Double.parseDouble(valor1) : 0.0;
        Double doubleValor2 = valor2 != null && !valor2.isEmpty() ? Double.parseDouble(valor2) : 0.0;
        Double resultado = doubleValor1 + doubleValor2;
        return resultado.toString();
    }

    public String getPre() {
        return pre;
    }

    public void setPre(String pre) {
        this.pre = pre;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getCdi() {
        return cdi;
    }

    public void setCdi(String cdi) {
        this.cdi = cdi;
    }

    public String getOutros() {
        return outros;
    }

    public void setOutros(String outros) {
        this.outros = outros;
    }
}

