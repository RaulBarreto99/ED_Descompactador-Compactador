/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoestruturadados;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class Projeto {

    static ArrayList<String> lista = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String arquivo = "Dale.txt";
        String linha = "";
        int cont = 0;
        try {

            FileReader fileReader = new FileReader(arquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((linha = bufferedReader.readLine()) != null) {
                lista.add(linha);
            }

        } catch (IOException ex) {
            System.out.println("Erro de escrita em '" + "'");
        }
        
        ArrayList<String> listaPalavra = new ArrayList<>();
        
        for (int i = 0; i < lista.size(); i++) {
            //System.out.println(lista.get(i));
            String[] array = lista.get(i).split(" ");
            
            for (int j = 0; j < array.length; j++) {
                listaPalavra.add(array[j]);
            }
        }
        ArrayList<String> fim = new ArrayList<>();
        ListaEncadeada listaEncadeada = new ListaEncadeada();
        
        for (int i = 0; i < listaPalavra.size(); i++) {
            
            if(listaEncadeada.buscaLinearIt(listaPalavra.get(i))){
                
            }
            
        }

        String arquivoDeSaida = "saida.txt";

        try {

            FileWriter fileWriter = new FileWriter(arquivoDeSaida);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("pib da regiao X = $$$$");
            bufferedWriter.newLine();
            bufferedWriter.write("pib da regiao Y = $$$$");

            // feche o arquivo
            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println("Erro de escrita em '" + arquivoDeSaida + "'");
        }

    }

}
