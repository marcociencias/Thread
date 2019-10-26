/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Jogador {

    private String nome;
    private Socket socket;
    private int porta;
    private OutputStream outPutStream;
    private InputStream inputStream;
    private boolean statusDaJogada;

    public boolean isStatusDaJogada() {
        return statusDaJogada;
    }

    public void setStatusDaJogada(boolean statusDaJogada) {
        this.statusDaJogada = statusDaJogada;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public OutputStream getOutPutStream() throws IOException {
        return socket.getOutputStream();
    }

    public void setOutPutStream(OutputStream outPutStream) throws IOException {
        this.outPutStream = socket.getOutputStream();
    }

    public InputStream getInputStream() throws IOException {
        return socket.getInputStream();
    }

    public void setInputStream(InputStream inputStream) throws IOException {
        this.inputStream = socket.getInputStream();
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
           
    public Jogador(String nome) throws IOException
    {
        this.nome = nome;
        this.socket = new Socket("localhost",12345);
    }
    
    public Jogador(Socket socket)
    {
       this.socket = socket;
    }
    
    public void fecharSocket() throws IOException
    {  
        this.socket.close();
    }
    
}
