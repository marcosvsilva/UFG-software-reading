package br.ufg.inf.concorrencia.execucao.threads;

import br.ufg.inf.concorrencia.principal.ClassMain;

/**
 * Realiza o cálculo de um elemento do produto das matrizes A e B.
 *
 * <p>Classe implementada de Thread que faz o calculo de um elemento da
 * multiplicação das matrizes A e B.
 */
public class ThreadMultiplicaElement extends Thread{

    /**
     * Linha da matriz a ser multiplicado.
     */
    private int linhaAMultiplicar;

    /**
     * Coluna da matriz a ser multiplicado.
     */
    private int colunaAMultiplicar;

    /**
     * Matriz a ser multiplicada.
     */
    private double[][] matrizA;

    /**
     * Matriz a ser multiplicada.
     */
    private double[][] matrizB;

    /**
     * Cria a thread
     *
     * @param matrizA matriz a ser multiplicada.
     * @param matrizB matriz a ser multiplicada.
     * @param linhaAMultiplicar linha da matriz a ser multiplicado.
     * @param colunaAMultiplicar coluna da matriz a ser multiplicado.
     */
    public ThreadMultiplicaElement(double[][] matrizA,
                                   double[][] matrizB,
                                   int linhaAMultiplicar,
                                   int colunaAMultiplicar) {
        this.matrizA = matrizA;
        this.matrizB = matrizB;
        this.linhaAMultiplicar = linhaAMultiplicar;
        this.colunaAMultiplicar = colunaAMultiplicar;
    }

    /**
     * Realiza o calculo.
     *
     * <p>Chama a função main para informar o valor da operação de
     * multiplicação da linha e coluna passada nos parâmetros.
     */
    @Override
    public void run() {
        int numeroElementos = matrizA[0].length;

        double soma = 0;
        for (int i = 0; i < numeroElementos; i++) {
            soma+=matrizA[linhaAMultiplicar][i] * matrizB[i][colunaAMultiplicar];
        }

        ClassMain.respostaMultiplicacaoElement(linhaAMultiplicar,colunaAMultiplicar,soma);
    }
}