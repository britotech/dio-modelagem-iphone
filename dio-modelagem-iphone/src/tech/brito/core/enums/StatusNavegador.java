package tech.brito.core.enums;

public enum StatusNavegador {

    EXIBIR_PAGINA("Exibindo página"),
    ADICIONAR_ABA("Adicionando aba"),
    ATUALIZAR_PAGINA("Atualizando página");

    private final String descricao;

    StatusNavegador(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}