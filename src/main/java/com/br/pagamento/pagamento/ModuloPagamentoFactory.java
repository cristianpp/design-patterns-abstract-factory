package com.br.pagamento.pagamento;

import com.br.pagamento.gestorderisco.GestorDeRisco;
import com.br.pagamento.operadora.Operadora;

public interface ModuloPagamentoFactory {

    public Operadora criarOperadora();
    public GestorDeRisco criarGestorDeRisco();
}

