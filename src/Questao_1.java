public class Questao_1 {

    public void gerarImagensInterpoladas() {

        String lena_gray = "src/Semana 09 (PDI) Operacoes Basicas/imagens/lena_gray_512.png";
        String mandril_gray = "src/Semana 09 (PDI) Operacoes Basicas/imagens/mandril_gray.png";

        // NA ATIVIDADE:
        // "Seja f(x, y) e g(x, y) as imagens de entrada"
        int[][] f = ImagemDigital.carregarImagem(lena_gray);
        int[][] g = ImagemDigital.carregarImagem(mandril_gray);
        ImagemDigital.plotarImagem(f, "lena");
        ImagemDigital.plotarImagem(g, "mandril");

        // NA ATIVIDADE:
        // "Gere as imagens para os seguintes
        // valores de α: 0,25; 0,50; e 0,75.":
        double alpha1 = 0.25;
        double alpha2 = 0.50;
        double alpha3 = 0.75;

        // NA ATIVIDADE:
        // "a nova imagem é h(x, y)":
        int[][] h =  ImagemDigital.carregarImagem(lena_gray);  // "lena_gray" é argumento genérico para o carregamento


        // COM VALOR 0.25 (alpha1):
        for(int x=0; x<f.length; x++){
            for(int y=0; y< g.length; y++){
                // NA ATIVIDADE:
                // h(x, y) =         α   * f(x, y)  +    (1−α)    *   g(x, y)
                h[x][y] = (int) ((alpha1 * f[x][y]) + ((1-alpha1) * (g[x][y])));
            }
        }
        ImagemDigital.plotarImagem(h, "peso:0.25");


        // COM VALOR 0.50 (alpha2):
        for(int x=0; x<f.length; x++){
            for(int y=0; y< g.length; y++){
                // NA ATIVIDADE:
                // h(x, y) =         α   * f(x, y)  +    (1−α)    *   g(x, y)
                h[x][y] = (int) ((alpha2 * f[x][y]) + ((1-alpha2) * (g[x][y])));
            }
        }
        ImagemDigital.plotarImagem(h, "peso:0.50");


        // COM VALOR 0.75 (alpha3):
        for(int x=0; x<f.length; x++){
            for(int y=0; y< g.length; y++){
                // NA ATIVIDADE:
                // h(x, y) =         α   * f(x, y)  +    (1−α)    *   g(x, y)
                h[x][y] = (int) ((alpha3 * f[x][y]) + ((1-alpha3) * (g[x][y])));
            }
        }
        ImagemDigital.plotarImagem(h, "peso:0.75");

    }
}