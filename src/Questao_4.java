public class Questao_4 {

    public void realizarProdutoImagens() {


        String Fig0230_a = "src/Semana 09 (PDI) Operacoes Basicas/imagens/Fig0230(a)(dental_xray).png";
        String Fig0230_b = "src/Semana 09 (PDI) Operacoes Basicas/imagens/Fig0230(b)(dental_xray_mask).png";

        // NA ATIVIDADE:
        // "imagens Fig0230(a)(dental xray)
        // e Fig0230(b) (dental xray mask)"
        int[][] fig_a = ImagemDigital.carregarImagem(Fig0230_a);
        int[][] fig_b = ImagemDigital.carregarImagem(Fig0230_b);
        ImagemDigital.plotarImagem(fig_a, "Fig0229(b)");
        ImagemDigital.plotarImagem(fig_b, "Fig0230_(b)");


        for (int x = 0; x < fig_b.length; x++) {
            for (int y = 0; y < fig_b[0].length; y++) {
                // Substitui a cor branca(255) pelo divisor 1:
                if(fig_b[x][y] == 255){
                    fig_b[x][y] = 1;
                }
                // NA ATIVIDADE:
                // "Qual o resultado do produto das imagens":
                fig_a[x][y] = Math.min(255, Math.max(0, fig_a[x][y]) * fig_b[x][y]);
            }
        }
        ImagemDigital.plotarImagem(fig_a, "SAIDA");



    }
}
