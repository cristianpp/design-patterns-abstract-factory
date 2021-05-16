package com.br.pagamento.gestorderisco;

import com.br.pagamento.gestorderisco.exceptions.AlertaDeRiscoException;

import java.math.BigDecimal;

public interface GestorDeRisco {

    public void avaliarRisco(String cartao, BigDecimal valor) throws AlertaDeRiscoException;
}
