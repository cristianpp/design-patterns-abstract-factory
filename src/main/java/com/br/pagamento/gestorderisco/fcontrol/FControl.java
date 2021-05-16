package com.br.pagamento.gestorderisco.fcontrol;

import com.br.pagamento.gestorderisco.GestorDeRisco;
import com.br.pagamento.gestorderisco.exceptions.AlertaDeRiscoException;

import java.math.BigDecimal;

public class FControl implements GestorDeRisco {

    @Override
    public void avaliarRisco(String cartao, BigDecimal valor) throws AlertaDeRiscoException {
        if (cartao.startsWith("7777")){
            throw new AlertaDeRiscoException("Cartão suspeito");
        }
    }
}
