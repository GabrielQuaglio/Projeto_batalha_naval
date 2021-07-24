package br.com.GabrielQuaglio.bt.modelo;

import java.util.ArrayList;
import java.util.List;

public class Campo {


    private boolean aberto;
    private boolean marcado;
   private boolean temBarco;
    private boolean atingido;
   private int acertos = 0;
    private int linha;
   private int coluna;





    public Campo(int linha,int coluna) {
        this.linha = getLinha();
        this.coluna = getColuna();
    }


    public boolean verificarProximidade(Campo vizinho){//rever

       boolean linhaDiferente = linha != vizinho.linha;
       boolean colunaDiferente = coluna != vizinho.coluna;
       boolean diagonal = linhaDiferente && colunaDiferente;

       int deltaLinha = Math.abs(linha - vizinho.linha);
       int deltaColuna = Math.abs(coluna - vizinho.coluna);
       int deltaGeral = deltaColuna + deltaLinha;

       if (deltaGeral == 1 && !diagonal) {

           return true;
       } else if(deltaGeral == 2 && diagonal) {

           return true;
       } else return false;


   }

   public void atirar(){
       if(!aberto && !marcado && !temBarco && !atingido){
            aberto = true;
       }else if(!aberto && !marcado && !atingido && temBarco){
           atingido = true;
           acertos++;
           atirar();
       }
   }

   void alternarMarcaçao(){
       marcado = !marcado;
   }


public boolean verificarVitoria(){
    return acertos == 10;
}



    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }



    public boolean isMarcado() {
        return marcado;
    }

    public void setMarcado(boolean marcado) {
        this.marcado = marcado;
    }

    public boolean isAtingido() {
        return atingido;
    }

    public void setAtingido(boolean atingido) {
        this.atingido = atingido;
    }

    public boolean isTemBarco() {
        return temBarco;
    }

    public void setTemBarco(boolean temBarco) {
        this.temBarco = temBarco;
    }
    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }
    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }


    @Override
    public String toString() {
        if(atingido){
            return "*";
        }else if (marcado){
            return "X";
        }else if(aberto){
            return "";
        }else return "?";
    }
}

