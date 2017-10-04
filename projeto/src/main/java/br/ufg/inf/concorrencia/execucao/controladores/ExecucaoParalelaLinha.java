package br.ufg.inf.concorrencia.execucao.controladores;

import br.ufg.inf.concorrencia.execucao.threads.ThreadMultiplicaLinha;

/**
 * Execução paralela do produto por linha.
 *
 * <p>Realiza o produto das matrizes A e B linha a linha.
 */
public class ExecucaoParalelaLinha {

    /**
     * Execução paralela do produto por linha.
     *
     * @param matrizA a ser multiplicada.
     * @param matrizB a ser multiplicada.
     * @throws InterruptedException caso ocorra interrupção de alguma thread.
     */
    public static void produtoMatrizesParaleloLinha(double[][] matrizA,
                                                    double matrizB[][])
            throws InterruptedException {

        int numeroLinhasMatrizProduto = matrizA.length;

        ThreadMultiplicaLinha[] threads =
                new ThreadMultiplicaLinha[numeroLinhasMatrizProduto];

        for (int i = 0; i < numeroLinhasMatrizProduto; i++) {
            threads[i] = new ThreadMultiplicaLinha(i,matrizA,matrizB);
            threads[i].start();
        }

        for (int i = 0; i < numeroLinhasMatrizProduto; i++) {
            threads[i].join(Integer.MAX_VALUE);
        }
    }
}
