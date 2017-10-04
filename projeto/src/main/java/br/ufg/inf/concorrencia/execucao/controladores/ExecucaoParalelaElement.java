package br.ufg.inf.concorrencia.execucao.controladores;

import br.ufg.inf.concorrencia.execucao.threads.ThreadMultiplicaElement;

/**
 * Execução paralela do produto por elemento.
 *
 * <p>Realiza o produto das matrizes A e B elemento a elemento.
 */
public class ExecucaoParalelaElement {

    /**
     * Executa o produto das matriz A e B paralelamente.
     *
     * @param matrizA matriz a ser multiplicada.
     * @param matrizB matriz a ser multplicada.
     * @throws InterruptedException caso ocorra interrupção das threads.
     */
    public static void produtoMatrizesParaleloElement(double[][] matrizA,
                                                      double matrizB[][])
            throws InterruptedException {

        int numeroLinhasMatrizProduto = matrizA.length;
        int numeroColunasMatrizProduto = matrizB[0].length;
        int numeroThreads = numeroLinhasMatrizProduto *
                numeroColunasMatrizProduto;

        ThreadMultiplicaElement[] threads =
                new ThreadMultiplicaElement[numeroThreads];
        int count = 0;
        for (int i = 0; i < numeroLinhasMatrizProduto; i++) {
            for (int j = 0; j < numeroColunasMatrizProduto; j++) {
                threads[count] = new
                        ThreadMultiplicaElement(matrizA,matrizB,i,j);
                threads[count].start();
                count++;
            }
        }

        for (int i = 0; i < numeroThreads; i++) {
            threads[i].join(Integer.MAX_VALUE);
        }
    }
}
