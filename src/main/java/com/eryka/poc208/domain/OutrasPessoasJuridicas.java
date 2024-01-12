package com.eryka.poc208.domain;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "outrasPessoasJuridicas")
@XmlAccessorType(XmlAccessType.FIELD)
public class OutrasPessoasJuridicas {

    @XmlElement(name = "valorTotalResgatadoDia")
    private ValorTotalResgatadoDia valorTotalResgatadoDia;

    @XmlElement(name = "valorTotalCaptadoDia")
    private ValorTotalCaptadoDia valorTotalCaptadoDia;

    @XmlElement(name = "saldoFinalDia")
    private SaldoFinalDia saldoFinalDia;

    @XmlElement(name = "taxaMediaEmissaoDia")
    private TaxaMediaEmissaoDia taxaMediaEmissaoDia;

    @XmlElement(name = "rendimentosIncorporados")
    private RendimentosIncorporados rendimentosIncorporados;

    public ValorTotalResgatadoDia getValorTotalResgatadoDia() {
        return valorTotalResgatadoDia;
    }

    public void setValorTotalResgatadoDia(ValorTotalResgatadoDia valorTotalResgatadoDia) {
        this.valorTotalResgatadoDia = valorTotalResgatadoDia;
    }

    public ValorTotalCaptadoDia getValorTotalCaptadoDia() {
        return valorTotalCaptadoDia;
    }

    public void setValorTotalCaptadoDia(ValorTotalCaptadoDia valorTotalCaptadoDia) {
        this.valorTotalCaptadoDia = valorTotalCaptadoDia;
    }

    public SaldoFinalDia getSaldoFinalDia() {
        return saldoFinalDia;
    }

    public void setSaldoFinalDia(SaldoFinalDia saldoFinalDia) {
        this.saldoFinalDia = saldoFinalDia;
    }

    public TaxaMediaEmissaoDia getTaxaMediaEmissaoDia() {
        return taxaMediaEmissaoDia;
    }

    public void setTaxaMediaEmissaoDia(TaxaMediaEmissaoDia taxaMediaEmissaoDia) {
        this.taxaMediaEmissaoDia = taxaMediaEmissaoDia;
    }

    public RendimentosIncorporados getRendimentosIncorporados() {
        return rendimentosIncorporados;
    }

    public void setRendimentosIncorporados(RendimentosIncorporados rendimentosIncorporados) {
        this.rendimentosIncorporados = rendimentosIncorporados;
    }
}