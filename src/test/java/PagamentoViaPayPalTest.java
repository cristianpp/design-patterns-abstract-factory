import com.br.pagamento.gestorderisco.exceptions.AlertaDeRiscoException;
import com.br.pagamento.operadora.exceptions.CapturaNaoAutorizadaException;
import com.br.pagamento.pagamento.ModuloPagamentoFactory;
import com.br.pagamento.pagamento.Pagamento;
import com.br.pagamento.pagamento.paypal.PayPalModuloPagamentoFactory;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertNotNull;

public class PagamentoViaPayPalTest {

    private Pagamento pagamento;

    @Before
    public void init() {
        ModuloPagamentoFactory moduloPagamentoFactory = new PayPalModuloPagamentoFactory();
        pagamento = new Pagamento(moduloPagamentoFactory);
    }

    @Test
    public void deveAutorizarVenda() throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
        Long codigoAutorizacao = pagamento.autorizar("2222.2222", new BigDecimal("200"));
        assertNotNull(codigoAutorizacao);
    }

    @Test(expected = CapturaNaoAutorizadaException.class)
    public void deveNegarCaptura_valorAcimaDoLimiteParaCartao() throws CapturaNaoAutorizadaException,
            AlertaDeRiscoException {
        pagamento.autorizar("2222.2222", new BigDecimal("2000"));
    }

    @Test
    public void deveAutorizarVenda_valorAltoComCartaoValido() throws CapturaNaoAutorizadaException,
            AlertaDeRiscoException {
        Long codigoAutorizacao = pagamento.autorizar("3333.2222", new BigDecimal("2000"));
        assertNotNull(codigoAutorizacao);
    }

    @Test(expected = AlertaDeRiscoException.class)
    public void deveGerarAlertaDeRisco() throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
        pagamento.autorizar("1111.2222", new BigDecimal("5500"));
    }

}
