package com.br.pagamento.pagamento.paypal;

import com.br.pagamento.gestorderisco.GestorDeRisco;
import com.br.pagamento.gestorderisco.clearsale.ClearSale;
import com.br.pagamento.operadora.Operadora;
import com.br.pagamento.operadora.redecard.RedeCard;
import com.br.pagamento.pagamento.ModuloPagamentoFactory;

public class PayPalModuloPagamentoFactory implements ModuloPagamentoFactory {


    @Override
    public Operadora criarOperadora() {
        return new RedeCard();
    }

    @Override
    public GestorDeRisco criarGestorDeRisco() {
        return new ClearSale();
    }
}
