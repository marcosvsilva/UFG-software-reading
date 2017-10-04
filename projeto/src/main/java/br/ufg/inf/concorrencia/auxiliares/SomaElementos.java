package br.ufg.inf.concorrencia.auxiliares;

/**
 * Soma elementos de uma matriz.
 */
public class SomaElementos {

    /**
     * Faz a soma de todos elementos da matriz.
     *
     * @param matriz a ser realizada a soma.
     * @return soma dos elementos.
     */
    public static double somaElementos(double[][] matriz){
        double soma = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                soma+=matriz[i][j];
            }
        }

        return soma;
    }
}
