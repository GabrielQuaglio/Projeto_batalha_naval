package br.com.GabrielQuaglio.bt.modelo;


import java.util.Arrays;

public class Tabuleiro {

    private int linha;
    private int coluna;

    final Campo[][] tabuleiro = new Campo[10][10];


    public Tabuleiro(int linha, int coluna) {
    this.linha = linha;
    this.coluna=coluna;


    }

    void atirar(int linha, int coluna){
      tabuleiro[linha][coluna].atirar();
//terminar

    }







}
