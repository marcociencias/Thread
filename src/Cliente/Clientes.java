/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Gonçalves
 */
public class Clientes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        
//        Socket socket = new Socket("localhost",12345);       
 
        System.out.println("Para iniciar o jogo digite o seu nome :");
        Scanner jogador = new Scanner(System.in);
        
        String nomeDoJogador = jogador.nextLine();
        
        Jogador jogo = new Jogador(nomeDoJogador);
        jogo.setNome(nomeDoJogador);
          
        ClienteInput recebeDados = new ClienteInput(jogo);
        ClientOut enviaDados = new ClientOut(jogo);
  
        Thread clienteRecebe = new Thread(recebeDados,"RecebeDados");
        Thread clienteEnvia = new Thread(enviaDados,"EnviaDados");
        
        clienteRecebe.start();
        clienteEnvia.start();
        
    }
    
}
