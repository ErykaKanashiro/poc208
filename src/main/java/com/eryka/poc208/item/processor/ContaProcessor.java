package com.eryka.poc208.item.processor;

import com.eryka.poc208.domain.Conta;
import com.eryka.poc208.domain.Documento;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Configuration;

import javax.print.Doc;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ContaProcessor implements ItemProcessor<Documento, Documento> {
    private final Map<String, BigDecimal> saldoPorCodigo = new HashMap<>();
    @Override
    public Documento process(Documento documento) {

        documento.getContas().forEach(conta -> {

            String codigoConta = conta.getCodigoConta();
            BigDecimal saldoAtual = conta.getSaldoDia();

            if (saldoPorCodigo.containsKey(codigoConta)) {
                // Se já existir um saldo para a conta, atualize-o
                BigDecimal saldoExistente = saldoPorCodigo.get(codigoConta);
                saldoAtual = saldoAtual.add(saldoExistente);
                saldoPorCodigo.put(codigoConta, saldoAtual);

            } else {
                saldoPorCodigo.put(codigoConta, saldoAtual);
            }
            conta.setSaldoDia(saldoAtual);
        });

        return documento;
    }

    public Map<String, BigDecimal> getSaldoPorCodigo() {
        return saldoPorCodigo;
    }
}