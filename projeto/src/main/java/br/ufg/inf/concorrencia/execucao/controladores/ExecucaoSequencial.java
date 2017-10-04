package br.ufg.inf.concorrencia.execucao.controladores;

/**
 * Responsável por realiza o produto das matrizes A e B sequencialmente.
 */
public class ExecucaoSequencial {

    /**
     * Executa o produto das matriz A e B sequencialmente.
     *
     * @param matrizA
     * @param matrizB
     * @return matriz produto de A e B.
     */
    public static double[][] produtoMatrizesSequencial(double[][] matrizA,
                                                       double matrizB[][]) {

        double[][] matrizProduto = new double[matrizA.length]
                [matrizB[0].length];

        for(int linha=0; linha<matrizA.length; linha++) {
            for (int coluna = 0; coluna < matrizB[0].length; coluna++) {
                double soma = 0;
                for (int i = 0; i < matrizA[0].length; i++) {
                    soma += matrizA[linha][i] * matrizB[i][coluna];
                }
                matrizProduto[linha][coluna] = soma;
            }
        }

        return matrizProduto;
    }
}