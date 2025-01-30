public class Questao_6 {

    public void analisarDiferencasImagensRGB() {

        String fig28_a = "src/Semana 09 (PDI) Operacoes Basicas/imagens/Fig0228(a)(angiography_mask_image).png";
        String fig28_b = "src/Semana 09 (PDI) Operacoes Basicas/imagens/Fig0228(b)(angiography_live_image).png";

        int[][][] imagem_1 = ImagemDigital.carregarImagemRGB(fig28_a);
        int[][][] imagem_2 = ImagemDigital.carregarImagemRGB(fig28_b);
        int[][][] imagem_1_subtraida = ImagemDigital.carregarImagemRGB(fig28_a);
        int[][][] imagem_2_subtraida = ImagemDigital.carregarImagemRGB(fig28_b);

        ImagemDigital.plotarImagemRGB(imagem_1, "Fig28_a");
        ImagemDigital.plotarImagemRGB(imagem_2, "Fig28_b");

        // Variáveis para armazenar os máximos e mínimos para normalização
        int[] max_imagem_1 = {0, 0, 0};
        int[] min_imagem_1 = {255, 255, 255};
        int[] max_imagem_2 = {0, 0, 0};
        int[] min_imagem_2 = {255, 255, 255};

        // Encontrar máximos e mínimos para cada canal (R, G, B)
        for (int c = 0; c < 3; c++) {
            for (int i = 0; i < imagem_1.length; i++) {
                for (int j = 0; j < imagem_1[0].length; j++) {
                    max_imagem_1[c] = Math.max(max_imagem_1[c], imagem_1[i][j][c]);
                    min_imagem_1[c] = Math.min(min_imagem_1[c], imagem_1[i][j][c]);

                    max_imagem_2[c] = Math.max(max_imagem_2[c], imagem_2[i][j][c]);
                    min_imagem_2[c] = Math.min(min_imagem_2[c], imagem_2[i][j][c]);
                }
            }
        }

        // Subtração das imagens para cada canal (R, G, B)
        for (int i = 0; i < imagem_1.length; i++) {
            for (int j = 0; j < imagem_1[0].length; j++) {
                for (int c = 0; c < 3; c++) { // Loop para R, G e B
                    int subtracao_1 = imagem_1[i][j][c] - imagem_2[i][j][c];
                    int subtracao_2 = imagem_2[i][j][c] - imagem_1[i][j][c];

                    // Normalização para evitar valores negativos
                    imagem_1_subtraida[i][j][c] = (subtracao_1 <= 0)
                        ? 255 * (imagem_1[i][j][c] - min_imagem_1[c]) / (max_imagem_1[c] - min_imagem_1[c])
                        : subtracao_1;

                    imagem_2_subtraida[i][j][c] = (subtracao_2 <= 0)
                        ? 255 * (imagem_2[i][j][c] - min_imagem_2[c]) / (max_imagem_2[c] - min_imagem_2[c])
                        : subtracao_2;
                }
            }
        }

        // Exibir as imagens resultantes
        ImagemDigital.plotarImagemRGB(imagem_1_subtraida, "Fig28_a subtraída de Fig28_b");
        ImagemDigital.plotarImagemRGB(imagem_2_subtraida, "Fig28_b subtraída de Fig28_a");

        System.out.println("Q2 - Processamento concluído\n");
    }
}
