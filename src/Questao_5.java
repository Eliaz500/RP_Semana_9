public class Questao_5 {

    public void gerarImagemMedia() {
        // LETRA A

        String path_1 = "src/Semana 09 (PDI) Operacoes Basicas/ruido/lena1.png";
        int[][] imagem_1 = ImagemDigital.carregarImagem(path_1);

        for (int k = 2; k <= 100; k++) {
            String path = "src/Semana 09 (PDI) Operacoes Basicas/ruido/lena" + k + ".png";
            int[][] imagem_2 = ImagemDigital.carregarImagem(path);
            for (int i = 0; i < imagem_1.length; i++) {
                for (int j = 0; j < imagem_1[0].length; j++) {
                    // SOMANDO AS 100:
                    imagem_1[i][j] = imagem_1[i][j] + imagem_2[i][j];
                }
            }
        }


        for (int x = 0; x < imagem_1.length; x++) {
            for (int y = 0; y < imagem_1[0].length; y++) {
                // MÉDIA DAS 100:
                imagem_1[x][y] = imagem_1[x][y] / 100;
            }
        }

        ImagemDigital.plotarImagem(imagem_1, "Média das 100");

        correcaoImagem(imagem_1);

        ImagemDigital.plotarImagem(imagem_1, "Imagem Corrigida com média 100");

        System.out.println("Q5A\n");


    }

    public void correcaoImagem(int[][] imagem){
        // Calcula o máximo e o mínimo
        int max = 0;
        int min = 255;
        for (int i = 0; i < imagem.length; i++){
            for (int j = 0; j < imagem[0].length; j++){
                max = Math.max(max, imagem[i][j]);
                min = Math.min(min, imagem[i][j]);
            }
        }

        // Correção de escala
        for (int k = 0; k < imagem.length; k++){
            for (int l = 0; l < imagem.length; l++){
                imagem[k][l] = 255 * (imagem[k][l] - min)/ (max - min);
            }
        }

    }





    public void analisarImagemMedia10() {
        // LETRA B

        String path_1 = "src/Semana 09 (PDI) Operacoes Basicas/ruido/lena1.png";
        int[][] lena_1 = ImagemDigital.carregarImagem(path_1);

        for (int k = 2; k <= 100; k++) {
            String path = "src/Semana 09 (PDI) Operacoes Basicas/ruido/lena" + k + ".png";
            int[][] lena_x = ImagemDigital.carregarImagem(path);
            for (int i = 0; i < lena_1.length; i++) {
                for (int j = 0; j < lena_1[0].length; j++) {
                    // SOMANDO AS 100
                    lena_1[i][j] = lena_1[i][j] + lena_x[i][j];
                }
            }
        }


        for (int i = 0; i < lena_1.length; i++) {
            for (int j = 0; j < lena_1[0].length; j++) {
                // MÉDIA DAS 10
                lena_1[i][j] = lena_1[i][j] / 10;
            }
        }

        correcaoImagem(lena_1);

        ImagemDigital.plotarImagem(lena_1, "Imagem Corrigida com média 10");

        System.out.println("Q5B\n");


    }
}
