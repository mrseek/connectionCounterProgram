import java.io.*;
import java.net.*;

public class Servidor {

	public static void main(String[] args) {

		Servidor miServidor = new Servidor();
		miServidor.run();
	}
	
	
	static int clientCounter; 						//Contador n� clientes
	static ServerSocket serverSock;					//Objeto que recibir� peticiones de los clientes
	
	static Socket clientSock;
	static DataOutputStream dataOutputStream; 		//Salida de datos al cliente
	
													//Inicializamos variables servidor
	public Servidor() {
		try {
			serverSock = new ServerSocket(6060); 	//Establecemos el puerto de conexi�n 6060
		}catch(IOException e) {
			e.printStackTrace();
		}
		clientCounter = 0;
		clientSock = null;
	}
	
	public void run() {
		System.out.println("El servidor est� escuchando en el puerto 6060");
		while(true) {
			try {
				clientSock = serverSock.accept();
				System.out.println("Nuevo cliente aceptado");
				
													//Flujo de salida
				dataOutputStream = new DataOutputStream(clientSock.getOutputStream());
				dataOutputStream.writeInt(++clientCounter);
				
				dataOutputStream.close();
				clientSock.close();

			} catch(IOException e) {
				System.out.println("Se ha producido una excepci�n. Intentalo de nuevo.");;
			}
		}
		
	}
	
													// Cerrar Servidor
	public void cerrarServidor() {
		try {
			serverSock.close();
		} catch (IOException e) {
			System.out.println("Se ha producido una excepci�n. Intentalo de nuevo.");;
		}
	}

}
