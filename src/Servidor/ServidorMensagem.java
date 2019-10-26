
package Servidor;

import Cliente.Jogador;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServidorMensagem {
    
    private List<Jogador> clientes;
    private int porta;
    private int contador = 0;
    
    public ServidorMensagem(int porta) {
        this.porta = porta;
        this.clientes = new ArrayList<>();
    }
    
    public void Executa() throws IOException{ 
        try(ServerSocket serverSocket = new ServerSocket(this.porta)) 
        {
        System.out.println("INICIANDO O SERVIDOR");  
        while(true){          
                       
           Socket socketCliente = serverSocket.accept(); // aceitando a conexão do socket , metodo bloqueante
           contador++;
           Jogador jogador = new Jogador(socketCliente);
           jogador.setNome(Integer.toString(contador));
           
           this.iniciando(jogador);
           
           if(contador > 2)
           {
               PrintStream saida = new PrintStream(jogador.getOutPutStream());
               saida.println("Você não será atendido por este jogo e sua conexão será fechada");
              try
              {
              jogador.fecharSocket();
              socketCliente.close();
              }catch(Exception ex)
              {
                  ex.getMessage();
              }
           }
           else
           {
                System.out.println("Quantidade de clientes conectador = " + contador);

                Gerenciamento gereciamento = new Gerenciamento(jogador,this);
                Thread t1 = new Thread(gereciamento , "Thread Servidor ");
                t1.start();
           }
        }           
      }
    }
        public void DistribuidorDeMensagens(Jogador clienteEnviou , String msg) throws IOException
        { 
            
            for(Jogador cliente : this.clientes){
                
                    if(!cliente.equals(clienteEnviou))
                {
                    try
                    {            
                       PrintStream ps = new PrintStream(cliente.getOutPutStream());
                       ps.println(msg);                       
                    }catch(Exception ex)
                    {
                        ex.getMessage();
                    }
                }
            }    
        }
        
        //precisa rodar no metodo run para ser controlado por threads
        
        public void iniciando(Jogador jogador) throws IOException
        {
            boolean vencedor = false;
            
     //       while(!vencedor)
       //     {            
                if(jogador.getNome().equals("1"))
                {
                    PrintStream p1 = new PrintStream(jogador.getOutPutStream());
                    jogador.setStatusDaJogada(true);
                    p1.println("Voce é o jogador 1 ");
                    p1.println("Informar a sua jogada");
                    
                    Scanner scnp1 = new Scanner(jogador.getInputStream());
                    String valores1 = scnp1.nextLine();
                    System.out.println(valores1 + "foi a sua jogada");
                 //   vencedor = JogoDaVelha(jogada);
               }

                if(jogador.getNome().equals("2"))
                {
                    PrintStream p2 = new PrintStream(jogador.getOutPutStream());
                    jogador.setStatusDaJogada(false);
                    p2.println("Você é o jogador 2");
                    p2.println("Informae a sua jogada");
                    Scanner scnp2 = new Scanner(jogador.getInputStream());
                    String valores2 = scnp2.nextLine();
                    System.out.println(valores2 + "foi a sua jogada");
                    
                    // vencedor = JogoDaVelha(jogada);               
                }    
              
         //   }
        }
}
