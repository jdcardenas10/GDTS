/**
 * Seccion 2
 * @author Jose Daniel Cardenas Rincon 	201313488
 * @author David Alejandro Cortes Vesga 201423363     
 */
package gdts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Principal {
	
		///////////////////Main///////////////////////////
	
		//Metodo Main del programa
		public static void main(String [] args)
		{
			Properties properties=new Properties();
			try {
				properties.load(new FileInputStream(new File("data/data.properties")));
				
				int numServidores=Integer.parseInt(properties.getProperty("numServidores"));
				int numClientes=Integer.parseInt(properties.getProperty("numClientes"));
				int tamBuffer=Integer.parseInt(properties.getProperty("tamBuffer"));
				
				Buffer buffer=new Buffer(tamBuffer,numClientes);
				Cliente.buffer=buffer;
				Servidor.buffer=buffer;
				
				for( int i=0;i<numClientes;i++){
					(new Cliente(i,Integer.parseInt(properties.getProperty("nCliente"+i)))).start();
				}
				
				for( int i=0;i<numServidores;i++){
					(new Servidor(i)).start();
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
