package Servidor;

import java.io.IOException;

public class Servidor {       
    	public static void main(String[] args) 
			throws IOException {
		new ServidorMensagem(12345).Executa();
	}
}