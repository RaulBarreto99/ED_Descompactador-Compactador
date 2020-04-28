/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoestruturadados;

import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class ListaEncadeada {
    
    private No ini;

    //Cria lista vazia
    public ListaEncadeada() {
        this.ini = null;
    }

    //Verifica se a lista está vazia
    public boolean vazia() {
        return ini == null;
    }

    //Inserir no início da lista
    public void insereInicio(String elemento) {
        No novo = new No(elemento, ini);
        ini = novo;
    }

    @Override
    public String toString() {
        String strLista = "";
        No temp = ini;

        while (temp != null) {
            strLista = strLista + temp.getElemento() + " ";
            temp = temp.getProx(); //ir para o próximo nó da lista
        }
        return strLista;
    }

    public No getIni() {
        return ini;
    }

    public void insereFinal(String elemento) {
        No novo = new No(elemento, null);
        No temp = ini;

        if (temp == null) { //Lista vazia
            ini = novo;
        } else {
            while (temp.getProx() != null) {
                temp = temp.getProx();
            }
            temp.setProx(novo);
        }
    }

    public void insereFinalR(String elemento) {
        insereFinalR(ini, elemento);
    }

    public void insereFinalR(No temp, String elemento) {
        //Lista vazia
        if (temp == null) {
            No novo = new No(elemento, ini);
            ini = novo;
        } else {
            if (temp.getProx() == null) { //Último No
                No novo = new No(elemento, null);
                temp.setProx(novo);
            } else {
                insereFinalR(temp.getProx(), elemento);
            }
        }
    }

    public boolean buscaLinearIt(String x) {
        No temp = ini;

        while (temp != null) {
            if (temp.getElemento() == x) {//Achou
                return true;
            }
            temp = temp.getProx();
        }
        return false;//Não achou
    }

    public No buscaLinearIt2(String x) {
        No temp = ini;

        while (temp != null) {
            if (temp.getElemento() == x) {//Achou
                return temp;
            }
            temp = temp.getProx();
        }
        return null;//Não achou
    }

    public void inverterLista() {
        No temp = ini;
        No anterior = null;
        No posterior = null;
        while (temp.getProx() != null) {
            posterior = anterior;
            anterior = temp;
            temp = temp.getProx();
            anterior.setProx(posterior);
        }
        ini = temp;
        temp.setProx(anterior);
    }
}

