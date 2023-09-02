package tech.brito.core.exceptions;

public class AparelhoDesligadoException extends OperacaoNaoPermitdaException {

    public AparelhoDesligadoException() {
        super("O aparelho encontra-se desligado. Ligue para que possa efetuar demais ações");
    }
}