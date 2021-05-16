package com.br.pagamento.pagamento;

import com.br.pagamento.gestorderisco.GestorDeRisco;
import com.br.pagamento.gestorderisco.exceptions.AlertaDeRiscoException;
import com.br.pagamento.operadora.Operadora;
import com.br.pagamento.operadora.exceptions.CapturaNaoAutorizadaException;

import java.math.BigDecimal;

public class Pagamento {

    private Operadora operadora;
    private GestorDeRisco gestorDeRisco;

    public Pagamento(ModuloPagamentoFactory moduloPagamentoFactory){
        this.operadora = moduloPagamentoFactory.criarOperadora();
        this.gestorDeRisco = moduloPagamentoFactory.criarGestorDeRisco();
    }

    public Long autorizar(String cartao, BigDecimal valor) throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
        this.operadora.capturar(cartao,valor);
        this.gestorDeRisco.avaliarRisco(cartao, valor);
        return this.operadora.confirmar();
    }

}
