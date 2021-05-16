package com.br.pagamento.operadora.redecard;

import com.br.pagamento.operadora.Operadora;
import com.br.pagamento.operadora.exceptions.CapturaNaoAutorizadaException;

import java.math.BigDecimal;

public class RedeCard implements Operadora {

    private Long codigoConfirmacao;

    @Override
    public void capturar(String cartao, BigDecimal valor) throws CapturaNaoAutorizadaException {
        if (cartao.startsWith("2222") && valorMaiorQueLimite(valor)){
            throw new CapturaNaoAutorizadaException("Valor maior que limite para cartão informado");
        }
        this.codigoConfirmacao = (long) Math.random() * 300;
    }

    private boolean valorMaiorQueLimite(BigDecimal valor) {
        BigDecimal limite = new BigDecimal("1000");
        return valor.compareTo(limite) > 0;
    }

    @Override
    public Long confirmar() {
        return this.codigoConfirmacao;
    }
}
