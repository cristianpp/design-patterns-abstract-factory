package com.br.pagamento.operadora.exceptions;

public class CapturaNaoAutorizadaException extends RuntimeException{
    public CapturaNaoAutorizadaException(String messages) {
        super(messages);
    }
}
