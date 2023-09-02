package tech.brito.core.repositories;

import java.util.List;
import java.util.Random;

public class WebPageRepository {

    private static final List<String> webPages = List.of("https://www.baeldung.com/",
                                                         "https://www.dio.me/",
                                                         "https://www.google.com.br/",
                                                         "https://www.oracle.com/br/java/",
                                                         "https://stackoverflow.com/");

    public static String getWebPage(){
        var indice = new Random().nextInt(webPages.size());
        return webPages.get(indice);
    }
}