//package com.eryka.poc208.item.processor;
//
//import com.eryka.poc208.domain.*;
//import org.springframework.batch.core.configuration.annotation.JobScope;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.context.annotation.Configuration;
//
//import java.lang.reflect.Method;
//import java.lang.reflect.Modifier;
//import java.math.BigDecimal;
//
//@JobScope
//@Configuration
//public class DocumentoProcessor implements ItemProcessor<Documento, Documento> {
//
//    @Override
//    public Documento process(Documento documento) throws Exception {
//
//        consolidateInstituicoesFinanceiras(documento.getInstituicoesFinanceiras());
//        consolidateInvestidoresInstitucionais(documento.getInvestidoresInstitucionais());
//        consolidateOutrasPessoasJuridicas(documento.getOutrasPessoasJuridicas());
//        consolidateOutrasPessoasFisicas(documento.getPessoasFisicas());
//
//        return documento;
//    }
//
//    private <T> void consolidateAtributos(T obj) {
//        if (obj == null) {
//            return;
//        }
//
//        // Obter todos os métodos da classe, incluindo os herdados
//        Method[] methods = obj.getClass().getMethods();
//
//        for (Method method : methods) {
//            // Verificar se o método é um getter (começa com "get") e não é estático
//            if (isGetter(method)) {
//                try {
//                    // Obter o valor atual
//                    Object existingValue = method.invoke(obj);
//
//                    // Se o valor atual não for nulo, consolidar o atributo
//                    if (existingValue != null) {
//                        // Construir o nome do método setter correspondente
//                        String attributeName = method.getName().substring(3);
//                        String setterName = "set" + attributeName;
//
//                        // Obter o método setter correspondente
//                        Method setterMethod = findSetterMethod(obj.getClass(), setterName, method.getReturnType());
//
//                        // Consolidar o atributo
//                        Object consolidatedValue = sum(existingValue, existingValue);
//
//                        // Chamar o método setter para definir o valor consolidado
//                        setterMethod.invoke(obj, consolidatedValue);
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    private boolean isGetter(Method method) {
//        return method.getName().startsWith("get") &&
//                method.getParameterCount() == 0 &&
//                !void.class.equals(method.getReturnType()) &&
//                !Modifier.isStatic(method.getModifiers());
//    }
//
//    private Method findSetterMethod(Class<?> clazz, String setterName, Class<?> parameterType) {
//        try {
//            return clazz.getMethod(setterName, parameterType);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//            throw new IllegalArgumentException("Setter method not found: " + setterName);
//        }
//    }
//
//    private <T> T sum(T value1, T value2) {
//        // Lógica de consolidação, por exemplo, somar valores numéricos
//        // Adapte isso conforme necessário para os tipos específicos
//        return value1;  // Por padrão, retorne o primeiro valor
//    }
//
//    private void consolidateInstituicoesFinanceiras(InstituicoesFinanceiras instituicoesFinanceiras) {
//        consolidateAtributos(instituicoesFinanceiras);
//    }
//
//    private void consolidateInvestidoresInstitucionais(InvestidoresInstitucionais investidoresInstitucionais) {
//        consolidateAtributos(investidoresInstitucionais);
//    }
//
//    private void consolidateOutrasPessoasJuridicas(OutrasPessoasJuridicas outrasPessoasJuridicas) {
//        consolidateAtributos(outrasPessoasJuridicas);
//    }
//
//    private void consolidateOutrasPessoasFisicas(PessoasFisicas pessoasFisicas) {
//        consolidateAtributos(pessoasFisicas);
//    }
//}
