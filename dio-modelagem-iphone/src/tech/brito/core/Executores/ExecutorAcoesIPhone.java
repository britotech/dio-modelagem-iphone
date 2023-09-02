package tech.brito.core.Executores;

import tech.brito.aparelhos.IPhone;
import tech.brito.core.exceptions.OperacaoNaoPermitdaException;

import java.util.HashMap;
import java.util.Objects;

public class ExecutorAcoesIPhone {

    private static final int APARELHO_LIGAR_DESLIGAR = 1;
    private static final int APARELHO_ATENDER = 2;
    private static final int APARELHO_CORRERIO_VOZ = 3;
    private static final int MEDIA_PLAYER_SELECIONAR_MUSICA = 4;
    private static final int MEDIA_PLAYER_TOCAR = 5;
    private static final int MEDIA_PLAYER_PAUSAR = 6;
    private static final int NAVEGADOR_ADICIONAR_ABA = 7;
    private static final int NAVEGADOR_EXIBIR_PAGINA = 8;
    private static final int NAVEGADOR_ATUALIZAR_PAGINA = 9;
    private static final int HISTORICO_APARELHO = 10;
    private static final int HISTORICO_REPRODUCAO = 11;
    private static final int HISTORICO_NAVEGACAO = 12;
    private static final int HISTORICO_GERAL = 13;

    private final HashMap<Integer, Runnable> acoes;

    public ExecutorAcoesIPhone(IPhone iPhone) {
        acoes = new HashMap<Integer, Runnable>();
        acoes.put(APARELHO_LIGAR_DESLIGAR, iPhone::ligar);
        acoes.put(APARELHO_ATENDER, iPhone::atender);
        acoes.put(APARELHO_CORRERIO_VOZ, iPhone::iniciarCorreioVoz);
        acoes.put(MEDIA_PLAYER_SELECIONAR_MUSICA, iPhone::selecionarMusica);
        acoes.put(MEDIA_PLAYER_TOCAR, iPhone::tocar);
        acoes.put(MEDIA_PLAYER_PAUSAR, iPhone::pausar);
        acoes.put(NAVEGADOR_ADICIONAR_ABA, iPhone::adicionarNovaAba);
        acoes.put(NAVEGADOR_EXIBIR_PAGINA, iPhone::exibirPagina);
        acoes.put(NAVEGADOR_ATUALIZAR_PAGINA, iPhone::atualizarPagina);
        acoes.put(HISTORICO_APARELHO, iPhone::exibirHistoricoAparelho);
        acoes.put(HISTORICO_REPRODUCAO, iPhone::exibirHistoricoReproducao);
        acoes.put(HISTORICO_NAVEGACAO, iPhone::exibirHistoricoNavegacao);
        acoes.put(HISTORICO_GERAL, iPhone::exibirHistoricoGeral);
    }

    public void executarAcao(int codigoAcao) {
        var acao = acoes.get(codigoAcao);
        if (Objects.isNull(acao)) {
            System.out.println("Ação informada é inválida.");
            return;
        }

        try {
            acao.run();
        } catch (OperacaoNaoPermitdaException ex) {
            System.out.println(ex.getMessage());
        }
    }
}