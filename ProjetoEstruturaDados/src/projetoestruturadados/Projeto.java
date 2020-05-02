/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoestruturadados;

import java.io.*;
import static java.lang.Character.isLetter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class Projeto {

    static ListaEncadeada listaEncadeada = new ListaEncadeada();

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner ent = new Scanner(System.in);

        int resp = 0;
        while (resp != 3) {
            System.out.println("\n");
            System.out.println("O que deseja fazer?.....");
            System.out.println("1 - Compactar um arquivo");
            System.out.println("2 - Descompactar um arquivo");
            System.out.println("3 - Sair");
            System.out.print("Digite o numero da opção que deseja realizar: ");
            resp = ent.nextInt();
            switch (resp) {
                case 1:
                    String arquivo;
                    //arquivo = "Dale.txt";
                    System.out.println("Digite o nome do 'arquivo.txt': ");
                    arquivo = ent.next();
                    String linha = "";

                    FileReader fileReader = new FileReader(arquivo);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String arquivoDeSaida = "compactado.txt";

                    FileWriter fileWriter = new FileWriter(arquivoDeSaida);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    while ((linha = bufferedReader.readLine()) != null) {
                        ArrayList<String> lista = new ArrayList<>();
                        if (!linha.equals("0")){
                            lista.add(linha);
                        } else {
                            bufferedReader.close();
                        }

                        ArrayList<Character> listaChar = new ArrayList<>();

                        for (int i = 0; i < lista.size(); i++) {
                            char[] array = lista.get(i).toCharArray();

                            for (int j = 0; j < array.length; j++) {
                                listaChar.add(array[j]);
                            }
                        }
                        System.out.println("pika: " + listaChar);
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
                            } else if (listaEncadeada.buscaPosicao(listaPalavra.get(i)) != -1) {
                                int posicao = listaEncadeada.buscaPosicao(listaPalavra.get(i));
                                listaFim.add(String.valueOf(posicao));
                                listaEncadeada.remove(listaPalavra.get(i));
                                listaEncadeada.insereInicio(listaPalavra.get(i));
                            } else {
                                listaFim.add(listaPalavra.get(i));
                                if(!listaPalavra.get(i).equals("0")){
                                listaEncadeada.insereInicio(listaPalavra.get(i));
                                }
                            }
                        }
                        System.out.println("lista compactada: " + listaFim);
                        System.out.println("lista encadeada qua salva as ocorrencias de cada palavra: " + listaEncadeada);

                        //Saida
                        for (int i = 0; i < listaFim.size(); i++) {
                            bufferedWriter.write(listaFim.get(i));
                            if (i < listaFim.size() - 1) {
                                if (!listaFim.get(i + 1).equals(",") && !listaFim.get(i + 1).equals(".") && !listaFim.get(i + 1).equals("-") && !listaFim.get(i + 1).equals("'")) {
                                    bufferedWriter.write(" ");
                                }
                            }
                        }
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.close();
                    System.out.println("arquivo compactado com sucesso!");
                    
                    break;
                    
                    
                case 2:
                    System.out.println("Digite o nome do 'arquivo.txt' que deseja descompactar: ");
                    String arquivoD = ent.next();
                    String linhaD = "";

                    FileReader fileReaderD = new FileReader(arquivoD);
                    BufferedReader bufferedReaderD = new BufferedReader(fileReaderD);
                    String arquivoDeSaidaD = "descompactado.txt";

                    FileWriter fileWriterD = new FileWriter(arquivoDeSaidaD);
                    BufferedWriter bufferedWriterD = new BufferedWriter(fileWriterD);
                    while ((linhaD = bufferedReaderD.readLine()) != null) {
                    ArrayList<String> lista = new ArrayList<>();
                        if (!linhaD.equals("0")) {
                            lista.add(linhaD);
                        } else {
                            bufferedReaderD.close();
                        }

                        ArrayList<Character> listaChar = new ArrayList<>();

                        for (int i = 0; i < lista.size(); i++) {
                            char[] array = lista.get(i).toCharArray();

                            for (int j = 0; j < array.length; j++) {
                                listaChar.add(array[j]);
                            }
                        }
                        System.out.println("pika: " + listaChar);
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
                            
                            if (listaPalavra.get(i).matches("[0-9]")){
                                String a = listaEncadeada.buscaElemento(listaPalavra.get(i));
                                listaFim.add(a);
                                listaEncadeada.remove(listaPalavra.get(i));
                                listaEncadeada.insereInicio(listaPalavra.get(i));
                            }else{
                                listaFim.add(listaPalavra.get(i));
                            }                            
                        }
                        System.out.println("lista compactada: " + listaFim);
                        System.out.println("lista encadeada qua salva as ocorrencias de cada palavra: " + listaEncadeada);

                        //Saida
                        for (int i = 0; i < listaFim.size(); i++) {
                            bufferedWriterD.write(listaFim.get(i));

                            if (i < listaFim.size() - 1) {
                                if (!listaFim.get(i + 1).equals(",") && !listaFim.get(i + 1).equals(".") && !listaFim.get(i + 1).equals("-") && !listaFim.get(i + 1).equals("'")) {
                                    bufferedWriterD.write(" ");
                                }
                            }
                        }
                        bufferedWriterD.newLine();
                    }
                    bufferedWriterD.close();
                    System.out.println("arquivo descompactado com sucesso!");
                    
                    break;
                case 3:
                    System.out.println("Obrigado volte sempre!");
                    break;
                default:
                    System.out.println("Digite uma opção valida");
            }

        }
    }

}
