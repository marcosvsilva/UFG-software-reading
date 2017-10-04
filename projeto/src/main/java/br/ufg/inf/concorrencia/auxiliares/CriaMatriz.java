package br.ufg.inf.concorrencia.auxiliares;

import java.io.IOException;

/**
 * Cria as matrizes a serem multiplicadas.
 */
public class CriaMatriz {

    /**
     * Arquivo de configuração que lê o arquivo de configuração.
     */
    private static ArquivoConfiguracao arqConfiguracao;

    /**
     * Tamanho máximo dos elementos das matrizes.
     */
    private static double tamanhoMaximoElemento;

    /**
     * Cria a classe que lê o arquivo de configuração.
     */
    public CriaMatriz() {
        try {
            arqConfiguracao = new ArquivoConfiguracao();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tamanhoMaximoElemento = arqConfiguracao.getTamanhoMaximoElemento();
    }

    /**
     * Cria uma matriz A populada, pelas dimensões dos parametros.
     * @return matriz A.
     */
    public double[][] criaMatrizA() {

        int numeroLinhasMatrizA = arqConfiguracao.getLinhaMatrizA();
        int numeroColunasMatrizA = arqConfiguracao.getColunaMatrizA();

        double[][] matriz = new double[numeroLinhasMatrizA][numeroColunasMatrizA];

        for (int i = 0; i < numeroLinhasMatrizA; i++) {
            for (int j = 0; j < numeroColunasMatrizA; j++) {
                matriz[i][j] = (Math.random() * tamanhoMaximoElemento);
            }
        }

        return matriz;
    }

    /**
     * Cria uma matriz B populada, pelas dimensões dos parametros.
     * @return matriz B.
     * @return
     */
    public double[][] criaMatrizB() {

        int numeroLinhasMatrizB = arqConfiguracao.getLinhaMatrizB();
        int numeroColunasMatrizB = arqConfiguracao.getColunaMatrizB();

        double[][] matriz = new double[numeroLinhasMatrizB][numeroColunasMatrizB];

        for (int i = 0; i < numeroLinhasMatrizB; i++) {
            for (int j = 0; j < numeroColunasMatrizB; j++) {
                matriz[i][j] = Math.random() * tamanhoMaximoElemento;
            }
        }

        return matriz;
    }

    /**
     * Faz a verificação se as duas matrizes são compatíveis para multiplicação.
     *
     * @param matrizA matriz A que será multiplicada.
     * @param matrizB matriz B que será multiplicada.
     * @return a validação. True = compatível; False = não compatível.
     */
    public boolean validaTamanhoMatriz(double[][] matrizA, double[][]matrizB){
        int numeroColunasA = matrizA[0].length;
        int numeroLinhasB = matrizB.length;

        return (numeroColunasA == numeroLinhasB);
    }

    /**
     * Cria a matriz produto com as dimensões apropriadas vazia;
     * @param matrizA matriz a ser multiplicada.
     * @param matrizB matriz a ser multiplicada.
     * @return
     */
    public double[][] criaMatrizProduto(double[][] matrizA, double[][]matrizB) {
        if (!validaTamanhoMatriz(matrizA,matrizB)) {
            return null;
        }

        int numeroLinhasA = matrizA.length;
        int numeroColunasB = matrizB[0].length;

        return new double[numeroLinhasA][numeroColunasB];
    }

}
