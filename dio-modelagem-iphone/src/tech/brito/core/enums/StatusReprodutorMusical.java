package tech.brito.core.enums;

public enum StatusReprodutorMusical {

    SEM_MUSICA("Sem música selecionada"),
    EXECUCAO("Tocando"),
    PAUSA("Pausado"),
    SELECIONAR_MUSICA("Selecionando música");

    private final String descricao;

    StatusReprodutorMusical(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}