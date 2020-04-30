/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoestruturadados;

import java.io.*;
import static java.lang.Character.isLetter;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class Projeto {
    
    static ListaEncadeada listaEncadeada = new ListaEncadeada();

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String arquivo = "Dale.txt";
        String linha = "";
        
        
        FileReader fileReader = new FileReader(arquivo);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
         String arquivoDeSaida = "saida.txt";
            
                FileWriter fileWriter = new FileWriter(arquivoDeSaida);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        while ((linha = bufferedReader.readLine()) != null) {
         ArrayList<String> lista = new ArrayList<>();
            if (!linha.equals("0")) {
                lista.add(linha);
            }else{
                bufferedReader.close();
            }
            

            ArrayList<Character> listaChar = new ArrayList<>();

            for (int i = 0; i < lista.size(); i++) {
                char[] array = lista.get(i).toCharArray();

                for (int j = 0; j < array.length; j++) {
                    listaChar.add(array[j]);
                }
            }
                        System.out.println("pika: "+listaChar);
            ArrayList<String> listaPalavra = new ArrayList<>();
            ArrayList<String> listaFim = new ArrayList<>();
            

            String palavra = "";
            for (int i = 0; i < listaChar.size(); i++) {
                if (listaChar.get(i).equals(' ')) {
                    if (!palavra.equals("")) {
                        listaPalavra.add(palavra);
                    }
                    palavra = "";
                } else if (!isLetter(listaChar.get(i))) {
                    if (!palavra.equals("")) {
                        listaPalavra.add(palavra);
                    }
                    palavra = "";
                    listaPalavra.add(listaChar.get(i).toString());
                } else {
                    palavra += listaChar.get(i);
                }
            }
            System.out.println("lista em palavras: " + listaPalavra);

            for (int i = 0; i < listaPalavra.size(); i++) {
                if (listaPalavra.get(i).matches("[^a-zA-Z0-9]")) {
                    listaFim.add(listaPalavra.get(i));
                } else if (listaEncadeada.buscaLinearIt(listaPalavra.get(i)) != -1) {
                    int posicao = listaEncadeada.buscaLinearIt(listaPalavra.get(i));
                    listaFim.add(String.valueOf(posicao));
                    listaEncadeada.remove(listaPalavra.get(i));
                    listaEncadeada.insereInicio(listaPalavra.get(i));
                } else {
                    listaFim.add(listaPalavra.get(i));
                    listaEncadeada.insereInicio(listaPalavra.get(i));
                }

            }
            System.out.println("lista compactada: " + listaFim);
            System.out.println("lista encadeada qua salva as ocorrencias de cada palavra: " + listaEncadeada);

            //Saida
            

                for (int i = 0; i < listaFim.size(); i++) {
                    bufferedWriter.write(listaFim.get(i));
                    
                    if(i < listaFim.size()-1){
                    if(!listaFim.get(i+1).equals(",") && !listaFim.get(i+1).equals(".") && !listaFim.get(i+1).equals("-") && !listaFim.get(i+1).equals("'")){
                    bufferedWriter.write(" ");
                    }
                }
                }
                bufferedWriter.newLine();
                // feche o arquivo
        }
        bufferedWriter.close();
    }
}
