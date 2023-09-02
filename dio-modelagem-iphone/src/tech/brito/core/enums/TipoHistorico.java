package tech.brito.core.enums;

public enum TipoHistorico {
    APARELHO("Aparelho Telefônico"), REPRODUTOR_MUSICAL("Reprodutor Musical "), NAVEGADOR_INTERNET("Navegador Internet ");

    private final String descricao;

    private TipoHistorico(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
