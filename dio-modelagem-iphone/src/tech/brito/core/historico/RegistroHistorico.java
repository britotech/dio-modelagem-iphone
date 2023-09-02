package tech.brito.core.historico;

import tech.brito.core.enums.TipoHistorico;
import tech.brito.core.utils.DateUtils;

import java.time.LocalDateTime;

public record RegistroHistorico(TipoHistorico tipo, LocalDateTime dataHoraExecucao, String descricao) {

    @Override
    public String toString() {
        var sb = new StringBuilder(DateUtils.getlocalDateTimeFormatado(dataHoraExecucao));
        sb.append(" - ");
        sb.append(tipo.getDescricao());
        sb.append(" -> ");
        sb.append(descricao);

        return sb.toString();
    }
}