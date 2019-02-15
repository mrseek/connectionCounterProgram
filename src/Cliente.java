import java.io.*;
import java.net.*;

public class Cliente {

	public static void main(String[] args) {

		Cliente miCliente = new Cliente();
		miCliente.run();

	}
	
	Socket clientSocket;
	DataInputStream inputStream;
	
											// Conexi�n por parte del cliente por el puerto especificado en la clase Servidor
	public Cliente() {
		try {
		clientSocket = new Socket("localhost", 6060);
		
		inputStream = new DataInputStream(clientSocket.getInputStream());
		} catch (IOException e){
			System.out.println("Se ha producido una excepci�n. Intentalo de nuevo.");;
		}
	}
	
											//Flujo de salida que imprime por pantalla el n� de conexi�n
	public void run() {
		
		try {
			System.out.println("Tu cliente es el numero " + inputStream.readInt());
		
			inputStream.close();
			clientSocket.close();
		
		} catch (IOException e) {
			System.out.println("Se ha producido una excepci�n. Intentalo de nuevo.");;
		}
		
	}

}
