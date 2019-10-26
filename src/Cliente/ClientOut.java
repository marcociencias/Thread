package Cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientOut implements Runnable{
    
    private Jogador jogo;
    
    public ClientOut(Jogador jogo){
        this.jogo = jogo;
    }
    
    @Override
    public void run() {


        try {
                  
            PrintStream outputStream = new PrintStream(jogo.getOutPutStream());
            Scanner scanner = new Scanner(System.in);
            while(scanner.hasNextLine())
            {
                String mensagemParaEnviar = scanner.nextLine();
                outputStream.println(jogo.getNome() + " enviou a mensagem -> " + mensagemParaEnviar);
            }
              outputStream.close();
              scanner.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientOut.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
