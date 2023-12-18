public class Questao_2 {

    public void analisarDiferencasImagens() {

        String fig28_a = "src/Semana 09 (PDI) Operacoes Basicas/imagens/Fig0228(a)(angiography_mask_image).png";
        String fig28_b = "src/Semana 09 (PDI) Operacoes Basicas/imagens/Fig0228(b)(angiography_live_ image).png";

        int[][] imagem_1 = ImagemDigital.carregarImagem(fig28_a);
        int[][] imagem_2 = ImagemDigital.carregarImagem(fig28_b);
        int[][] imagem_1_subtraida = ImagemDigital.carregarImagem(fig28_a);
        int[][] imagem_2_subtraida = ImagemDigital.carregarImagem(fig28_b);

        ImagemDigital.plotarImagem(imagem_1, "Fig28_a");
        ImagemDigital.plotarImagem(imagem_2, "Fig28_b");

        // Calcula o Máximo e Mínimo da Primeira Imagem
        int max_imagem_1 = 0;
        int min_imagem_1 = 255;

        for(int i = 0; i <imagem_1.length; i++){
            for(int j = 0; j < imagem_1[0].length; j++){
                max_imagem_1 = Math.max(max_imagem_1, imagem_1[i][j]);
                min_imagem_1 = Math.min(min_imagem_1, imagem_1[i][j]);
            }
        }

        // Calcula o Máximo e Mínimo da Segunda Imagem
        int max_imagem_2 = 0;
        int min_imagem_2 = 255;

        for(int i = 0; i <imagem_2.length; i++){
            for(int j = 0; j < imagem_2[0].length; j++){
                max_imagem_2 = Math.max(max_imagem_2, imagem_2[i][j]);
                min_imagem_2= Math.min(min_imagem_2, imagem_2[i][j]);
            }
        }

        // Subtração da Primeira imagem da Segunda
        for(int i = 0; i <imagem_1.length; i++){
            for(int j = 0; j < imagem_2[0].length; j++){
                // Verifica se a subtracao tem velor negativo
                // se tem faz o tratamento
                if (imagem_1[i][j] - imagem_2[i][j] <= 0 ){
                    imagem_1_subtraida[i][j] = 255 * (imagem_1[i][j] - min_imagem_1)/(max_imagem_1 - min_imagem_1);
                }else{
                    imagem_1_subtraida[i][j] = imagem_1[i][j] - imagem_2[i][j];
                }

            }
        }

        // Subtração da Segunda imagem da Primeira
        for(int i = 0; i <imagem_2.length; i++){
            for(int j = 0; j < imagem_2[0].length; j++){
                // Verifica se a subtracao tem velor negativo
                // se tem faz o tratamento
                if (imagem_2[i][j] - imagem_1[i][j] <= 0 ){
                    imagem_2_subtraida[i][j] = 255 * (imagem_2[i][j] - min_imagem_2)/(max_imagem_2 - min_imagem_2);
                }else{
                    imagem_2_subtraida[i][j] = imagem_2[i][j] - imagem_1[i][j];
                }

            }
        }

        ImagemDigital.plotarImagem(imagem_1_subtraida, "Fig28_a subtraída a Fig28_b");
        ImagemDigital.plotarImagem(imagem_2_subtraida, "Fig28_b subtraída a Fig28_a");

        System.out.println("Q2\n");

    }
}
