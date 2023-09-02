package tech.brito.core.historico;

import tech.brito.core.enums.TipoHistorico;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HistoricoAcoes {

    private final List<RegistroHistorico> historico;

    public HistoricoAcoes() {
        historico = new ArrayList<>();
    }

    public void registrarHistorico(TipoHistorico tipoHistorico, String descricao) {
        var registroHistorico = new RegistroHistorico(tipoHistorico, LocalDateTime.now(), descricao);
        historico.add(registroHistorico);
        System.out.println(descricao);
    }

    public void exibirHistorico() {
        System.out.println("**************************************************");
        historico.forEach(System.out::println);
        System.out.println("**************************************************");
    }

    public void exibirHistorico(TipoHistorico tipoHistorico) {
        System.out.println("************** Histórico do " + tipoHistorico.getDescricao() + " **************");
        var historicosPorTipo = historico.stream().filter(h -> h.tipo().equals(tipoHistorico)).toList();
        historicosPorTipo.forEach(System.out::println);
        System.out.println("**************************************************");
    }
}