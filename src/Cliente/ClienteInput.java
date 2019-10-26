package Cliente;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteInput implements Runnable{

    private Jogador socket;
    
    public ClienteInput(Jogador socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(socket.getInputStream());
            while(scanner.hasNextLine())
            {
                String mensagem = scanner.nextLine();
                System.out.println(mensagem); 
            }
             scanner.close();
        } catch (IOException ex) {
            Logger.getLogger(ClienteInput.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
