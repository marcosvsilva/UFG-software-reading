package br.ufg.inf.concorrencia.execucao.threads;

import br.ufg.inf.concorrencia.principal.ClassMain;

public class ThreadMultiplicaLinha extends Thread{

    /**
     * Linha da matriz a ser multiplicado.
     */
    private int linhaAMultiplicar;

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
     * @param linhaAMultiplicar linha da matriz a ser multiplicado.
     * @param matrizA matriz a ser multiplicada.
     * @param matrizB matriz a ser multiplicada.
     */
    public ThreadMultiplicaLinha(int linhaAMultiplicar,
                                 double[][] matrizA,
                                 double[][] matrizB) {
        this.linhaAMultiplicar = linhaAMultiplicar;
        this.matrizA = matrizA;
        this.matrizB = matrizB;
    }

    /**
     * Realiza o calculo.
     *
     * <p>Chama a função main para informar o valor da operação de
     * multiplicação da linha e coluna passada nos parâmetros.
     */
    @Override
    public void run() {
        double soma = 0;
        for (int i = 0; i < matrizB[0].length; i++) {
            for (int j = 0; j < matrizB.length; j++) {
                soma += matrizA[linhaAMultiplicar][j] * matrizB[j][i];
            }
            ClassMain.respostaMultiplicacaoLinha(linhaAMultiplicar,i,soma);
            soma = 0;
        }
    }
}