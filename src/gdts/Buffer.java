/**
 * Seccion 2
 * @author Jose Daniel Cardenas Rincon 	201313488
 * @author David Alejandro Cortes Vesga 201423363  
 */
package gdts;

import java.util.LinkedList;


public class Buffer 
{
	/////////////Atributos///////////////////
	
	//Numero de Clientes
	private int numeroClientes;
	
	//tamanio de la cola
	private int tamanioCola;
	
	//capacidad del buffer
	private int capacidadBuffer;
	
	//Cola con tamanio fijo
	private LinkedList<Mensaje> colaDeEspera;
	
	///////////////Constructor///////////////////
	
	//Constructor del Buffer
	public Buffer(int pCapacidad, int pNumeroClientes) 
	{
		this.capacidadBuffer=pCapacidad;
		this.tamanioCola= 0;
		numeroClientes=pNumeroClientes;
		//colaDeEspera=new ArrayList<Mensaje>();
		colaDeEspera= new LinkedList<Mensaje>();
	}
	
	/////////////////Metodos//////////////////////
	
	//Prueba entrgar el mensajo. Devuelve false si no lo logra, tru de lo contrario
	public synchronized boolean entregado(Mensaje men) throws InterruptedException
	{	
		if(tamanioCola<capacidadBuffer)
		{
			if(tamanioCola==0){notifyAll();}
			colaDeEspera.add(men);
			tamanioCola++;
			return true;
		}
		return false;
	}
	
	//Se consume el mensaje y se extrae del buffer 
	public synchronized Mensaje consumirMensaje() throws InterruptedException
	{
		while(tamanioCola==0&&numeroClientes>0)
		{
			wait();				
		}		
		if(tamanioCola==0){return null;}
		tamanioCola--;
		
		return colaDeEspera.removeFirst();
	}
	
	//Disminuye la cantidad de clientes en uno
	public synchronized void disminuirCliente()
	{
		numeroClientes--;
	}
	
	//Indica si aun hay algun cliente en el sistema
	public synchronized boolean hayClientes()
	{
		return(numeroClientes>0);
	}

	//Despierta a todos los objetos dormidos en el buffer
	public synchronized void notificarTodos() {
		notifyAll();
	}	
}
