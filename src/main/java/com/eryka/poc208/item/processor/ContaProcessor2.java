//package com.eryka.poc208.item.processor;
//
//import com.eryka.poc208.domain.Conta;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.context.annotation.Configuration;
//
//import java.math.BigDecimal;
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class ContaProcessor2 implements ItemProcessor<Conta, Conta> {
//
//    private final Map<String, BigDecimal> saldoPorCodigo = new HashMap<>();
//
//    @Override
//    public Conta process(Conta conta) {
//        String codigoConta = conta.getCodigoConta();
//        BigDecimal saldoAtual = conta.getSaldoDia();
//
//        if (saldoPorCodigo.containsKey(codigoConta)) {
//            BigDecimal saldoExistente = saldoPorCodigo.get(codigoConta);
//            saldoAtual = saldoAtual.add(saldoExistente);
//        }
//
//        saldoPorCodigo.put(codigoConta, saldoAtual);
//        conta.setSaldoDia(saldoAtual);
//
//        return conta; // Retorna a conta com o saldo atualizado
//    }
//}