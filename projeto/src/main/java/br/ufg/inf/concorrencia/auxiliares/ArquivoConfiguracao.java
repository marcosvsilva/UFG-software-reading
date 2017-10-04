package br.ufg.inf.concorrencia.auxiliares;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Classe que lê o arquivo de configuração.
 */
public class ArquivoConfiguracao {

    /**
     * Variável que contem as linhas e colunas do arquivo de configuração.
     */
    private static int[] linhasColunas;

    /**
     * Tamanho máximo dos elementos que compõe as matrizes A e B.
     */
    private static double tamanhoMaximoElemento;

    /**
     * Verifica se a impressão da matriz A ocorrerá.
     */
    private static boolean imprimirMatrizA;

    /**
     * Verifica se a impressão da matriz B ocorrerá.
     */
    private static boolean imprimirMatrizB;

    /**
     * Verifica se a impressão da matriz produto de A e B ocorrerá.
     */
    private static boolean imprimirMatrizProduto;


    /**
     * Carrega o arquivo de configuração.
     *
     * @throws IOException caso ocorra erro na leitura do arquivo.
     */
    public ArquivoConfiguracao() throws IOException {
        Properties properties = new Properties();

        FileInputStream file = new
                FileInputStream(Strings.enderecoArquivoConfiguracao);

        properties.load(file);

        linhasColunas = new int[Strings.tamanhoLista];
        linhasColunas[Strings.posicaoLinhaA] = (Integer.parseInt(properties.
                getProperty(Strings.tagLinhaMatrizA)));

        linhasColunas[Strings.posicaoColunaA] = (Integer.parseInt(properties.
                getProperty(Strings.tagColunasMatrizA)));

        linhasColunas[Strings.posicaoLinhaB] = (Integer.parseInt(properties.
                getProperty(Strings.tagLinhaMatrizB)));

        linhasColunas[Strings.posicaoColunaB] = (Integer.parseInt(properties.
                getProperty(Strings.tagColunasMatrizB)));

        String valor = properties.getProperty(Strings.tagTamanhoMaximoElemento);
        valor = valor.replace(",",".");
        tamanhoMaximoElemento = Double.parseDouble(valor);

        imprimirMatrizA = (properties.getProperty(Strings.
                tagImprimiMatrizA).equals(Strings.stringTrue));

        imprimirMatrizB = (properties.getProperty(Strings.
                tagImprimiMatrizB).equals(Strings.stringTrue));

        imprimirMatrizProduto = (properties.getProperty(Strings.
                tagImprimiMatrizProduto).equals(Strings.stringTrue));
    }

    /**
     * Número de linhas da matriz A.
     * @return número de linhas.
     */
    public Integer getLinhaMatrizA(){
        return linhasColunas[Strings.posicaoLinhaA];
    }

    /**
     * Número de colunas da matriz A.
     * @return número de colunas.
     */
    public Integer getColunaMatrizA(){
        return linhasColunas[Strings.posicaoColunaA];
    }

    /**
     * Número de linhas da matriz B.
     * @return número de linhas.
     */
    public Integer getLinhaMatrizB(){
        return linhasColunas[Strings.posicaoLinhaB];
    }

    /**
     * Número de colunas da matriz B.
     * @return número de colunas.
     */
    public Integer getColunaMatrizB(){
        return linhasColunas[Strings.posicaoColunaB];
    }

    /**
     * Deve ou não imprimir matriz A.
     * @return true = sim; false = não.
     */
    public boolean isImprimirMatrizA() {
        return imprimirMatrizA;
    }

    /**
     * Deve ou não imprimir matriz B.
     * @return true = sim; false = não.
     */
    public boolean isImprimirMatrizB() {
        return imprimirMatrizB;
    }

    /**
     * Deve ou não imprimir matriz produto de A e B.
     * @return true = sim; false = não.
     */
    public boolean isImprimirMatrizProduto() {
        return imprimirMatrizProduto;
    }

    /**
     * Tamanho máximo dos elementos que compõe as matrizes A e B.
     * @return tamanho máximo dos elementos.
     */
    public double getTamanhoMaximoElemento(){
        return tamanhoMaximoElemento;
    }
}