package br.ufg.inf.concorrencia.principal;

import br.ufg.inf.concorrencia.execucao.controladores.ExecucaoParalelaElement;
import br.ufg.inf.concorrencia.execucao.controladores.ExecucaoParalelaLinha;
import br.ufg.inf.concorrencia.execucao.controladores.ExecucaoSequencial;
import br.ufg.inf.concorrencia.auxiliares.SomaElementos;
import br.ufg.inf.concorrencia.auxiliares.ArquivoConfiguracao;
import br.ufg.inf.concorrencia.auxiliares.CriaMatriz;
import br.ufg.inf.concorrencia.auxiliares.Strings;

import java.io.IOException;
import java.text.DecimalFormat;

public class ClassMain {

    /**
     * Classe que faz a criação das matrizes populadas.
     */
    private static CriaMatriz criaMatriz = new CriaMatriz();

    /**
     * Matriz produto das A e B por elemento.
     */
    private static double[][] matrizProdutoParalelaElement;

    /**
     * Matriz produto das A e B por linha.
     */
    private static double[][] matrizProdutoParalelaLinha;

    /**
     * Arquivo leitura das configuraçãoes da aplicação.
     */
    private static ArquivoConfiguracao arquivoConfiguracao;

    /**
     * Responsável pelo produto de A e B paralelamente por elemento.
     */
    private static ExecucaoParalelaElement execucaoParalelaElement =
            new ExecucaoParalelaElement();

    /**
     * Responsável pelo produto de A e B paralelamente por linha.
     */
    private static ExecucaoParalelaLinha execucaoParalelaLinha =
            new ExecucaoParalelaLinha();

    /**
     * * Responsável pelo produto de A e B sequencialmente.
     */
    private static ExecucaoSequencial execucaoSequencial =
            new ExecucaoSequencial();

    /**
     * Execução da aplicação
     *
     * @param args null
     * @throws InterruptedException caso ocorra erro de interrupão de execução.
     * @throws IOException caso ocorra erro de leitura de arquivo.
     */
    public static void main(String[] args) throws InterruptedException,
            IOException {

        arquivoConfiguracao = new ArquivoConfiguracao();

        double matrizA[][] = criaMatriz.criaMatrizA();
        double matrizB [][] = criaMatriz.criaMatrizB();

        matrizProdutoParalelaElement =
                criaMatriz.criaMatrizProduto(matrizA,matrizB);

        matrizProdutoParalelaLinha =
                criaMatriz.criaMatrizProduto(matrizA,matrizB);

        if(matrizProdutoParalelaElement == null) {
            System.out.println("Dimensoes inválidas para multiplicacao");
            System.exit(0);
        } else if(matrizProdutoParalelaLinha == null) {
            System.out.println("Dimensoes inválidas para multiplicacao");
            System.exit(0);
        }

        long horaInicialParaleloElement, horaFinalParaleloElement;
        horaInicialParaleloElement = System.currentTimeMillis();
        execucaoParalelaElement.produtoMatrizesParaleloElement(matrizA,matrizB);
        horaFinalParaleloElement = System.currentTimeMillis();
        long tempoExecucaoParaleloElement =
                horaFinalParaleloElement - horaInicialParaleloElement;

        long horaInicialParaleloLinha, horaFinalParaleloLinha;
        horaInicialParaleloLinha = System.currentTimeMillis();
        execucaoParalelaLinha.produtoMatrizesParaleloLinha(matrizA,matrizB);
        horaFinalParaleloLinha = System.currentTimeMillis();
        long tempoExecucaoParaleloLinha =
                horaFinalParaleloLinha - horaInicialParaleloLinha;

        long horaInicialSequencial, horaFinalSequencial;
        horaInicialSequencial = System.currentTimeMillis();
        double[][] matriProdutoSequencial =
                execucaoSequencial.produtoMatrizesSequencial(matrizA,matrizB);
        horaFinalSequencial = System.currentTimeMillis();
        long tempoExecucaoSequencial =
                horaFinalSequencial - horaInicialSequencial;

        DecimalFormat decimalFormat = new
                DecimalFormat(Strings.mascaraDecimais);

        if (arquivoConfiguracao.isImprimirMatrizA()) {
            System.out.println('\n' + "Matriz A:");
            for (int i = 0; i < matrizA.length; i++) {
                for (int j = 0; j < matrizA[0].length; j++) {
                    System.out.print(decimalFormat.
                            format(matrizA[i][j]) + " ");
                }
                System.out.println();
            }
        }

        if(arquivoConfiguracao.isImprimirMatrizB()){
            System.out.println('\n' + "Matriz B:");
            for (int i = 0; i < matrizB.length; i++) {
                for (int j = 0; j < matrizB[0].length; j++) {
                    System.out.print(decimalFormat.
                            format(matrizB[i][j]) + " ");
                }
                System.out.println();
            }
        }

        if (arquivoConfiguracao.isImprimirMatrizProduto()) {
            System.out.println('\n' + "Produto de A e B paralelamente " +
                    "produzida elemento a elemento:");

            for (int i = 0; i < matrizProdutoParalelaElement.length; i++) {
                for (int j = 0; j < matrizProdutoParalelaElement[0].length; j++) {
                    System.out.print(decimalFormat.
                            format(matrizProdutoParalelaElement[i][j]) + " ");
                }
                System.out.println();
            }

            System.out.println('\n' + "Produto de A e B paralelamente " +
                    "produzida linha a linha:");

            for (int i = 0; i < matrizProdutoParalelaLinha.length; i++) {
                for (int j = 0; j < matrizProdutoParalelaLinha[0].length; j++) {
                    System.out.print(decimalFormat.
                            format(matrizProdutoParalelaLinha[i][j]) + " ");
                }
                System.out.println();
            }

            System.out.println('\n' + "Produto de A e B sequencialmente " +
                    "produzida:");

            for (int i = 0; i < matriProdutoSequencial.length; i++) {
                for (int j = 0; j < matriProdutoSequencial[0].length; j++) {
                    System.out.print(decimalFormat.
                            format(matriProdutoSequencial[i][j]) + " ");
                }
                System.out.println();
            }
        }

        SomaElementos somaElementos = new SomaElementos();

        System.out.println('\n' + "Soma da matriz produto de A e B " +
                "paralelamente elemento a elemento e " + decimalFormat.format(
                somaElementos.somaElementos(matrizProdutoParalelaElement)) +
                " executado todo o processo em " + decimalFormat.format(
                tempoExecucaoParaleloElement/1000) + " segundos");

        System.out.println('\n' + "Soma da matriz produto de A e B " +
                "paralelamente linha  a linha e " + decimalFormat.format(
                somaElementos.somaElementos(matrizProdutoParalelaLinha)) +
                " executado todo o processo em " + decimalFormat.format(
                tempoExecucaoParaleloLinha/1000) + " segundos");

        System.out.println('\n' + "Soma da matriz produto de A e B " +
                "sequencialmente e " + decimalFormat.format(
                somaElementos.somaElementos(matriProdutoSequencial)) +
                " executado todo o processo em " + (
                tempoExecucaoSequencial/1000) + " segundos");
    }

    /**
     * Implementa o resultado das operações concorrentes por elemento.
     *
     * <p> Método implementado pelas threads para informar os valores
     * resultantes obtidos por cada uma.
     *
     * @param numeroLinha linha da operação.
     * @param numeroColuna coluna da operação.
     * @param resultado resultado obtido pela thread.
     */
    public static void respostaMultiplicacaoElement(
            int numeroLinha, int numeroColuna, double resultado) {
        matrizProdutoParalelaElement[numeroLinha][numeroColuna] = resultado;
    }

    /**
     * Implementa o resultado das operações concorrentes por linha.
     *
     * <p> Método implementado pelas threads para informar os valores
     * resultantes obtidos por cada uma.
     *
     * @param numeroLinha linha da operação.
     * @param numeroColuna coluna da operação.
     * @param resultado resultado obtido pela thread.
     */
    public static void respostaMultiplicacaoLinha(
            int numeroLinha, int numeroColuna, double resultado) {
        matrizProdutoParalelaLinha[numeroLinha][numeroColuna] = resultado;
    }
}