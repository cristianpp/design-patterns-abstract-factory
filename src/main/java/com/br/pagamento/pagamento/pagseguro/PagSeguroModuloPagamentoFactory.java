package com.br.pagamento.pagamento.pagseguro;

import com.br.pagamento.gestorderisco.GestorDeRisco;
import com.br.pagamento.gestorderisco.fcontrol.FControl;
import com.br.pagamento.operadora.Operadora;
import com.br.pagamento.operadora.cielo.Cielo;
import com.br.pagamento.pagamento.ModuloPagamentoFactory;

public class PagSeguroModuloPagamentoFactory implements ModuloPagamentoFactory {

    @Override
    public Operadora criarOperadora() {
        return new Cielo();
    }

    @Override
    public GestorDeRisco criarGestorDeRisco() {
        return new FControl();
    }
}
