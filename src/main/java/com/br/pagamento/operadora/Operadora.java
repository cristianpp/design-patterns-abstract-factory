package com.br.pagamento.operadora;

import com.br.pagamento.operadora.exceptions.CapturaNaoAutorizadaException;

import java.math.BigDecimal;

public interface Operadora {

    public void capturar(String cartao, BigDecimal valor) throws CapturaNaoAutorizadaException;
    public Long confirmar();

}
