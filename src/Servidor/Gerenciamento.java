/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Cliente.Jogador;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gonçalves
 */
public class Gerenciamento implements Runnable {
    
    private Jogador socket;
    private ServidorMensagem servicoServidor;
    
    public Gerenciamento(Jogador socket, ServidorMensagem servicoServidor)
    {
        this.socket = socket;
        this.servicoServidor = servicoServidor;
    }

    @Override
    public void run() {
        
        try {
        
            Scanner scanner = new Scanner(this.socket.getInputStream());
           
            while(scanner.hasNextLine())
            {              
                servicoServidor.DistribuidorDeMensagens(this.socket,scanner.nextLine());      
            }
                } 
                catch (Exception ex) {
                    Logger.getLogger(Gerenciamento.class.getName()).log(Level.SEVERE, null, ex);
                }
        
            }
    
}
/*
private vencedor = false;

while(!vencedor)
{

    boolean jogadaAtual = true;

    if(jogador.jogada = true && jogadaAtual = true)
    {
       vencedor = jogo(jogada);
       jogadaAtual=false;
    }
    if(jogador.jogada = false && jogadaAtual = false)
    {
       vencedor = jogo(jogada);
       jogadaAtual=true;
    }

}
*/

