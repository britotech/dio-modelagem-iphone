package tech.brito.core.repositories;

import java.util.List;
import java.util.Random;

public class MusicaRepository {

    private static final List<String> musicas = List.of("Fanize Rock - Fragmentos",
                                                        "Fernandinho - Uma nova História",
                                                        "Houdine - Lembranças",
                                                        "Legião Urbana - Faroeste Caboclo",
                                                        "Noção de nada - Diploma");

    public static String getMusica(){
        var indice = new Random().nextInt(musicas.size());
        return musicas.get(indice);
    }
}