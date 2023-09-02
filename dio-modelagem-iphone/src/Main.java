import tech.brito.aparelhos.IPhone;
import tech.brito.core.Executores.ExecutorAcoesIPhone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String MENU = """            
            ###########   APARELHO   ############
             1 - Ligar / desligar
             2 - Atender ligação
             3 - Iniciar correio de voz
            ########### MEDIA PLAYER ############
             4 - Selecionar música
             5 - Tocar música
             6 - Pausar música
            ###########   INTERNET   ############
             7 - Adicionar nova aba
             8 - Exibir página
             9 - Atualizar página
            ###########   HISTORICO  ############
            10 - Exibir histórico do aparelho
            11 - Exibir histórico do media player
            12 - Exibir histórico de navegação
            13 - Exibir histórico geral
            ########### 0 - Finalizar ###########
            """;

    private static final int CODIGO_ACAO_FINALIZACAO = 0;
    private static final int CODIGO_ACAO_INVALIDO = 99;

    public static void main(String[] args) throws IOException {

        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var executor = new ExecutorAcoesIPhone(new IPhone());
            System.out.println(MENU);

            while (true) {
                System.out.println("*****************************************");
                System.out.println("Informe o código da ação:");
                var valorInformado = reader.readLine();
                var codigoAcao = obterCodigoAcao(valorInformado);
                if (codigoAcao == CODIGO_ACAO_FINALIZACAO) {
                    System.out.println("Execução finalizada.");
                    break;
                }

                if (codigoAcao == CODIGO_ACAO_INVALIDO) {
                    System.out.println("Valor informado deve ser um número.");
                    continue;
                }

                executor.executarAcao(codigoAcao);
            }
        }
    }

    private static int obterCodigoAcao(String codigoAcao) {
        if (isNumerico(codigoAcao)) {
            return Integer.parseInt(codigoAcao);
        }

        return CODIGO_ACAO_INVALIDO;
    }

    private static boolean isNumerico(String valor) {
        return valor.matches("[0-9]+");
    }
}