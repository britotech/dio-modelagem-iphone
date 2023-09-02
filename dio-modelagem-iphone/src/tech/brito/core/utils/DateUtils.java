package tech.brito.core.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static String getlocalDateTimeFormatado(LocalDateTime dataHora) {
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dataHora.format(formatter);
    }

    public static String getDataHoraAtualFormatada(){
        return getlocalDateTimeFormatado(LocalDateTime.now());
    }
}
