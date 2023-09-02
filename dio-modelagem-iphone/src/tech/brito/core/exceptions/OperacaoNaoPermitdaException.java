package tech.brito.core.exceptions;

public class OperacaoNaoPermitdaException extends RuntimeException {

    public OperacaoNaoPermitdaException(String message) {
        super(message);
    }
}
