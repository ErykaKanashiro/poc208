package com.eryka.poc208;

import com.eryka.poc208.domain.*;
import org.springframework.stereotype.Service;

@Service
public class DocumentoService {

    private InstituicoesFinanceiras instituicoesFinanceiras = new InstituicoesFinanceiras();
    private InvestidoresInstitucionais investidoresInstitucionais = new InvestidoresInstitucionais();
    private OutrasPessoasJuridicas outrasPessoasJuridicas = new OutrasPessoasJuridicas();
    private PessoasFisicas pessoasFisicas = new PessoasFisicas();


    public Documento somarDocumentos(Documento documentoAnterior, Documento documentoAtual) {

        var documentoConsolidado = new Documento();

        somarSecoes(documentoAnterior.getInstituicoesFinanceiras(), documentoAtual.getInstituicoesFinanceiras());
        somarSecoes(documentoAnterior.getInvestidoresInstitucionais(), documentoAtual.getInvestidoresInstitucionais());
        somarSecoes(documentoAnterior.getOutrasPessoasJuridicas(), documentoAtual.getOutrasPessoasJuridicas());
        somarSecoes(documentoAnterior.getPessoasFisicas(), documentoAtual.getPessoasFisicas());

        documentoConsolidado.setCnpj(documentoAtual.getCnpj());
        documentoConsolidado.setCodigoDocumento(documentoAtual.getCodigoDocumento());
        documentoConsolidado.setDataBase(documentoAtual.getDataBase());
        documentoConsolidado.setTipoEnvio(documentoAtual.getTipoEnvio());

        documentoConsolidado.setPessoasFisicas(pessoasFisicas);
        documentoConsolidado.setOutrasPessoasJuridicas(outrasPessoasJuridicas);
        documentoConsolidado.setInstituicoesFinanceiras(instituicoesFinanceiras);
        documentoConsolidado.setInvestidoresInstitucionais(investidoresInstitucionais);

        return documentoConsolidado;
    }

    public InstituicoesFinanceiras somarSecoes(InstituicoesFinanceiras secao1, InstituicoesFinanceiras secao2) {

        var atributosSomadosRendimentosIncorporados = somarAtributosComuns(secao1.getRendimentosIncorporados(), secao2.getRendimentosIncorporados());
        var atributosSomadosValorTotalResgateDia = somarAtributosComuns(secao1.getValorTotalResgatadoDia(), secao2.getValorTotalResgatadoDia());
        var atributosSomadosValorTotalCaptadoDia = somarAtributosComuns(secao1.getValorTotalCaptadoDia(), secao2.getValorTotalCaptadoDia());
        var atributosSomadosSaldoFinalDia = somarAtributosComuns(secao1.getSaldoFinalDia(), secao2.getSaldoFinalDia());

        var rendimentosIncorporados = rendimentosIncorporados(atributosSomadosRendimentosIncorporados);
        var valorTotalResgatadoDia = valorTotalResgatadoDia(atributosSomadosValorTotalResgateDia);
        var valorTotalCaptadoDia = valorTotalCaptadoDia(atributosSomadosValorTotalCaptadoDia);
        var valorTotalSaldoFinalDia = saldoFinalDia(atributosSomadosSaldoFinalDia);

        instituicoesFinanceiras.setRendimentosIncorporados(rendimentosIncorporados);
        instituicoesFinanceiras.setValorTotalResgatadoDia(valorTotalResgatadoDia);
        instituicoesFinanceiras.setSaldoFinalDia(valorTotalSaldoFinalDia);
        instituicoesFinanceiras.setValorTotalCaptadoDia(valorTotalCaptadoDia);

        return instituicoesFinanceiras;
    }

    public InvestidoresInstitucionais somarSecoes(InvestidoresInstitucionais secao1, InvestidoresInstitucionais secao2) {
        var atributosSomadosRendimentosIncorporados = somarAtributosComuns(secao1.getRendimentosIncorporados(), secao2.getRendimentosIncorporados());
        var atributosSomadosValorTotalResgateDia = somarAtributosComuns(secao1.getValorTotalResgatadoDia(), secao2.getValorTotalResgatadoDia());
        var atributosSomadosValorTotalCaptadoDia = somarAtributosComuns(secao1.getValorTotalCaptadoDia(), secao2.getValorTotalCaptadoDia());
        var atributosSomadosSaldoFinalDia = somarAtributosComuns(secao1.getSaldoFinalDia(), secao2.getSaldoFinalDia());

        var rendimentosIncorporados = rendimentosIncorporados(atributosSomadosRendimentosIncorporados);
        var valorTotalResgatadoDia = valorTotalResgatadoDia(atributosSomadosValorTotalResgateDia);
        var valorTotalCaptadoDia = valorTotalCaptadoDia(atributosSomadosValorTotalCaptadoDia);
        var valorTotalSaldoFinalDia = saldoFinalDia(atributosSomadosSaldoFinalDia);

        investidoresInstitucionais.setRendimentosIncorporados(rendimentosIncorporados);
        investidoresInstitucionais.setValorTotalResgatadoDia(valorTotalResgatadoDia);
        investidoresInstitucionais.setSaldoFinalDia(valorTotalSaldoFinalDia);
        investidoresInstitucionais.setValorTotalCaptadoDia(valorTotalCaptadoDia);

        return investidoresInstitucionais;
    }

    public OutrasPessoasJuridicas somarSecoes(OutrasPessoasJuridicas secao1, OutrasPessoasJuridicas secao2) {
        var atributosSomadosRendimentosIncorporados = somarAtributosComuns(secao1.getRendimentosIncorporados(), secao2.getRendimentosIncorporados());
        var atributosSomadosValorTotalResgateDia = somarAtributosComuns(secao1.getValorTotalResgatadoDia(), secao2.getValorTotalResgatadoDia());
        var atributosSomadosValorTotalCaptadoDia = somarAtributosComuns(secao1.getValorTotalCaptadoDia(), secao2.getValorTotalCaptadoDia());
        var atributosSomadosSaldoFinalDia = somarAtributosComuns(secao1.getSaldoFinalDia(), secao2.getSaldoFinalDia());

        var rendimentosIncorporados = rendimentosIncorporados(atributosSomadosRendimentosIncorporados);
        var valorTotalResgatadoDia = valorTotalResgatadoDia(atributosSomadosValorTotalResgateDia);
        var valorTotalCaptadoDia = valorTotalCaptadoDia(atributosSomadosValorTotalCaptadoDia);
        var valorTotalSaldoFinalDia = saldoFinalDia(atributosSomadosSaldoFinalDia);

        outrasPessoasJuridicas.setRendimentosIncorporados(rendimentosIncorporados);
        outrasPessoasJuridicas.setValorTotalResgatadoDia(valorTotalResgatadoDia);
        outrasPessoasJuridicas.setSaldoFinalDia(valorTotalSaldoFinalDia);
        outrasPessoasJuridicas.setValorTotalCaptadoDia(valorTotalCaptadoDia);

        return outrasPessoasJuridicas;
    }

    public PessoasFisicas somarSecoes(PessoasFisicas secao1, PessoasFisicas secao2) {
        var atributosSomadosRendimentosIncorporados = somarAtributosComuns(secao1.getRendimentosIncorporados(), secao2.getRendimentosIncorporados());
        var atributosSomadosValorTotalResgateDia = somarAtributosComuns(secao1.getValorTotalResgatadoDia(), secao2.getValorTotalResgatadoDia());
        var atributosSomadosValorTotalCaptadoDia = somarAtributosComuns(secao1.getValorTotalCaptadoDia(), secao2.getValorTotalCaptadoDia());
        var atributosSomadosSaldoFinalDia = somarAtributosComuns(secao1.getSaldoFinalDia(), secao2.getSaldoFinalDia());

        var rendimentosIncorporados = rendimentosIncorporados(atributosSomadosRendimentosIncorporados);
        var valorTotalResgatadoDia = valorTotalResgatadoDia(atributosSomadosValorTotalResgateDia);
        var valorTotalCaptadoDia = valorTotalCaptadoDia(atributosSomadosValorTotalCaptadoDia);
        var valorTotalSaldoFinalDia = saldoFinalDia(atributosSomadosSaldoFinalDia);

        pessoasFisicas.setRendimentosIncorporados(rendimentosIncorporados);
        pessoasFisicas.setValorTotalResgatadoDia(valorTotalResgatadoDia);
        pessoasFisicas.setSaldoFinalDia(valorTotalSaldoFinalDia);
        pessoasFisicas.setValorTotalCaptadoDia(valorTotalCaptadoDia);

        return pessoasFisicas;
    }

    public RendimentosIncorporados rendimentosIncorporados(AtributosComuns atributosSomados) {

        var rendimentosIncorporados = new RendimentosIncorporados();
        rendimentosIncorporados.setCdi(atributosSomados.getCdi());
        rendimentosIncorporados.setPre(atributosSomados.getPre());
        rendimentosIncorporados.setPos(atributosSomados.getPos());
        rendimentosIncorporados.setOutros(atributosSomados.getOutros());

        return rendimentosIncorporados;
    }

    public ValorTotalResgatadoDia valorTotalResgatadoDia(AtributosComuns atributosSomados) {

        var valorTotalResgatadoDia = new ValorTotalResgatadoDia();
        valorTotalResgatadoDia.setCdi(atributosSomados.getCdi());
        valorTotalResgatadoDia.setPre(atributosSomados.getPre());
        valorTotalResgatadoDia.setPos(atributosSomados.getPos());
        valorTotalResgatadoDia.setOutros(atributosSomados.getOutros());

        return valorTotalResgatadoDia;
    }

    public ValorTotalCaptadoDia valorTotalCaptadoDia(AtributosComuns atributosSomados) {

        var valorTotalCaptadoDia = new ValorTotalCaptadoDia();
        valorTotalCaptadoDia.setCdi(atributosSomados.getCdi());
        valorTotalCaptadoDia.setPre(atributosSomados.getPre());
        valorTotalCaptadoDia.setPos(atributosSomados.getPos());
        valorTotalCaptadoDia.setOutros(atributosSomados.getOutros());

        return valorTotalCaptadoDia;
    }

    public SaldoFinalDia saldoFinalDia(AtributosComuns atributosSomados) {

        var saldoFinalDia = new SaldoFinalDia();
        saldoFinalDia.setCdi(atributosSomados.getCdi());
        saldoFinalDia.setPre(atributosSomados.getPre());
        saldoFinalDia.setPos(atributosSomados.getPos());
        saldoFinalDia.setOutros(atributosSomados.getOutros());

        return saldoFinalDia;
    }

    private AtributosComuns somarAtributosComuns(AtributosComuns secao1, AtributosComuns secao2) {
        var atributosSomados = secao1.somar(secao2);
        return atributosSomados;
    }

    private void calcularMedia(AtributosComuns... secoes) {
        int quantidade = secoes.length;

        for (AtributosComuns secao : secoes) {
            // Aqui você deve implementar a lógica para calcular a média
            // Lembre-se de lidar com valores nulos ou vazios se necessário
        }
    }
}
