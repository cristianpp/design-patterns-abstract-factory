package com.br.pagamento.gestorderisco.clearsale;

import com.br.pagamento.gestorderisco.GestorDeRisco;
import com.br.pagamento.gestorderisco.exceptions.AlertaDeRiscoException;

import java.math.BigDecimal;

public class ClearSale implements GestorDeRisco {


    @Override
    public void avaliarRisco(String cartao, BigDecimal valor) throws AlertaDeRiscoException {
        if (cartao.startsWith("1111") && valorMuitoAlto(valor)){
            throw new AlertaDeRiscoException("Valor muito alto para esse cartão");
        }
    }

    private boolean valorMuitoAlto(BigDecimal valor) {
        BigDecimal limite = new BigDecimal("5000");
        return limite.compareTo(valor) < 0;
    }
}
