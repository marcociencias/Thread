/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientetcpsimples;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author profbrigadeiro
 */
public class ClienteTCPSimples {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        System.out.print("Informe mensagem: ");
        Scanner teclado = new Scanner(System.in);
        Socket socket = new Socket("127.0.0.1", 12345);
        PrintStream saida = 
                new PrintStream(socket.getOutputStream());
        String texto = null;
        boolean sair = false;
        Scanner entrada = new Scanner(socket.getInputStream());
        
        while(!sair && teclado.hasNextLine()) {
            texto = teclado.nextLine();
            if(texto.equalsIgnoreCase("sair")) {
                sair = true;
            }
            saida.println(texto);
            
            String retorno = entrada.nextLine();
            System.out.println("Servidor respondeu: " + retorno);

        }
        System.out.println("Saiu");   
        saida.close();
        teclado.close();
        socket.close();
    }   
    
    
}
