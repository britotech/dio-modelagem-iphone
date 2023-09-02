package tech.brito.core.exceptions;

public class ReprodutoMusicalSemMusicalException extends OperacaoNaoPermitdaException {

    public ReprodutoMusicalSemMusicalException() {
        super("O reprodutor musical não possui nenhum música selecionada no momento.");
    }
}