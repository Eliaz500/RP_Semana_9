public class Questao_3 {

    public void corrigirIluminacao() {


        String Fig0229_a = "src/Semana 09 (PDI) Operacoes Basicas/imagens/Fig0229(a)(tungsten_filament_shaded).png";
        String Fig0229_b = "src/Semana 09 (PDI) Operacoes Basicas/imagens/Fig0229(b)(tungsten_sensor_shading).png";

        // NA ATIVIDADE:
        // "imagem Fig0229(a)(tungsten lament shaded).png".
        // "imagem Fig0229(b)(tungsten sensor shading).png".
        int[][] fig_a = ImagemDigital.carregarImagem(Fig0229_a);
        int[][] fig_b = ImagemDigital.carregarImagem(Fig0229_b);
        ImagemDigital.plotarImagem(fig_a, "Fig0229(a)");
        ImagemDigital.plotarImagem(fig_b, "Fig0229(b)");


        for (int x = 0; x < fig_a.length; x++) {
            for (int y = 0; y < fig_a[0].length; y++) {
                // NA ATIVIDADE:
                // "Realize a correção de iluminação pela divisão":
                if (fig_b[x][y] != 0) {
                    fig_a[x][y] = Math.min(255,Math.max(0,(fig_a[x][y] * 255) / fig_b[x][y]));
                }                                     // "(fig_a[x][y] * 255)" é para garantir a iluminação.
            }
        }
        ImagemDigital.plotarImagem(fig_a, "SAIDA");


    }

}