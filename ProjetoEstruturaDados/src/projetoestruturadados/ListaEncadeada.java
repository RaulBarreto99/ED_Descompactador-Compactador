/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoestruturadados;


/**
 *
 * @author RaulBarreto
 */
public class ListaEncadeada {

    private No ini;

    public ListaEncadeada() {
        this.ini = null;
    }

    public boolean vazia() {
        return ini == null;
    }

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

    public int buscaLinearIt(String x) {
        No temp = ini;
        int cont = 0;

        while (temp != null) {
            if (temp.getElemento().equals(x)) {
                cont++;
                return cont;
            }
            cont++;
            temp = temp.getProx();
        }
        return -1;
    }
    
     public void remove(String elemento){
        No temp = ini;
        if(ini.getElemento().equals(elemento)){
        ini = temp.getProx();
        }else{
        while(temp.getProx() != null){
            if(temp.getProx().getElemento().equals(elemento)){
                temp.setProx(temp.getProx().getProx());
            }
            temp = temp.getProx();
        }
        }
    }
}