package tech.brito.aparelhos;

import tech.brito.core.enums.StatusReprodutorMusical;
import tech.brito.core.enums.TipoHistorico;
import tech.brito.core.exceptions.AparelhoDesligadoException;
import tech.brito.core.exceptions.ReprodutoMusicalSemMusicalException;
import tech.brito.core.historico.HistoricoAcoes;
import tech.brito.core.repositories.MusicaRepository;
import tech.brito.core.repositories.WebPageRepository;
import tech.brito.modulos.NavegadorInternet;
import tech.brito.modulos.ReprodutorMusical;

import java.util.Objects;

public class IPhone implements AparelhoTelefonico, NavegadorInternet, ReprodutorMusical {

    private HistoricoAcoes historico;
    private StatusReprodutorMusical statusReprodutorMusical;
    private boolean aparelhoDesligado;
    private String paginaAtual;
    private String musicaAtual;

    public IPhone() {
        this.aparelhoDesligado = true;
        this.historico = new HistoricoAcoes();
        statusReprodutorMusical = StatusReprodutorMusical.SEM_MUSICA;
    }

    @Override
    public void ligar() {
        if (aparelhoDesligado) {
            aparelhoDesligado = false;
            historico.registrarHistorico(TipoHistorico.APARELHO, "Aparelho ligado com sucesso.");
            return;
        }

        aparelhoDesligado = true;
        historico.registrarHistorico(TipoHistorico.APARELHO, "O aparelho será desligado.");
    }

    @Override
    public void atender() {
        validarAcaoPermitidaParaStatusAparelho();
        historico.registrarHistorico(TipoHistorico.APARELHO, "Atendendo ligação...");
    }

    private void validarAcaoPermitidaParaStatusAparelho() {
        if (aparelhoDesligado) {
            throw new AparelhoDesligadoException();
        }
    }

    @Override
    public void iniciarCorreioVoz() {
        validarAcaoPermitidaParaStatusAparelho();
        historico.registrarHistorico(TipoHistorico.APARELHO, "Iniciando correio de voz...");
    }

    @Override
    public void exibirPagina() {
        validarAcaoPermitidaParaStatusAparelho();
        paginaAtual = WebPageRepository.getWebPage();
        historico.registrarHistorico(TipoHistorico.NAVEGADOR_INTERNET, "Exibindo a página: " + paginaAtual);
    }

    @Override
    public void adicionarNovaAba() {
        validarAcaoPermitidaParaStatusAparelho();
        historico.registrarHistorico(TipoHistorico.NAVEGADOR_INTERNET, "Adicionando nova aba.");
    }

    @Override
    public void atualizarPagina() {
        validarAcaoPermitidaParaStatusAparelho();
        if (Objects.isNull(paginaAtual)) {
            historico.registrarHistorico(TipoHistorico.NAVEGADOR_INTERNET, "Atualizando página.");
            return;
        }

        historico.registrarHistorico(TipoHistorico.NAVEGADOR_INTERNET, "Atualizando página atual: " + paginaAtual);
    }

    @Override
    public void tocar() {
        validarAcaoPermitidaParaStatusReprodutoMusical();
        historico.registrarHistorico(TipoHistorico.REPRODUTOR_MUSICAL, "Tocando música:  " + musicaAtual);
    }

    private void validarAcaoPermitidaParaStatusReprodutoMusical() {
        validarAcaoPermitidaParaStatusAparelho();
        if (Objects.isNull(musicaAtual)) {
            throw new ReprodutoMusicalSemMusicalException();
        }
    }

    @Override
    public void pausar() {
        validarAcaoPermitidaParaStatusReprodutoMusical();
        historico.registrarHistorico(TipoHistorico.REPRODUTOR_MUSICAL, "Pausada música:  " + musicaAtual);
    }

    @Override
    public void selecionarMusica() {
        validarAcaoPermitidaParaStatusAparelho();
        musicaAtual = MusicaRepository.getMusica();
        historico.registrarHistorico(TipoHistorico.REPRODUTOR_MUSICAL, "Selecionado música:  " + musicaAtual);
    }

    public void exibirHistoricoGeral() {
        historico.exibirHistorico();
    }

    public void exibirHistoricoAparelho() {
        historico.exibirHistorico(TipoHistorico.APARELHO);
    }

    public void exibirHistoricoNavegacao() {
        historico.exibirHistorico(TipoHistorico.NAVEGADOR_INTERNET);
    }

    public void exibirHistoricoReproducao() {
        historico.exibirHistorico(TipoHistorico.REPRODUTOR_MUSICAL);
    }
}