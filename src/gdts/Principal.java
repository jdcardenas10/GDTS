package gdts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Principal {

	//Main
		public static void main()
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
					Cliente cliente=new Cliente(i,Integer.parseInt(properties.getProperty("nCliente"+i)));
					cliente.start();
				}
				
				for( int i=0;i<numServidores;i++){
					Servidor servidor=new Servidor(i);
					servidor.start();
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			//Buffer buffer=new Buffer();
		}
}
