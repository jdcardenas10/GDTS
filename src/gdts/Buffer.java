/**
 * Seccion 2
 * @author Jose Daniel Cardenas Rincon 	201313488
 * @author David Alejandro Cortes Vesga      
 */
package gdts;

import sun.misc.Queue;

public class Buffer 
{
	//Atributos
	
	//Numero de Clientes
	private int numeroClientes;
	
	//tamanio de la cola
	private int tamanioCola;
	
	//capacidad del buffer
	private int capacidadBuffer;
	
	//Cola con tamanio fijo
	private Queue<Mensaje> colaDEspera;
	
	public Buffer(int pCapacidad, int pNumeroClientes) 
	{
		this.capacidadBuffer=pCapacidad;
		this.tamanioCola= 0;
		numeroClientes=pNumeroClientes;
		colaDEspera= new Queue<>();
	}
	
	//Metodos
	
	//dar el numero de clientes
	//public synchronized int darNumeroClientes()
	//{
		//return numeroClientes;
	//}
	//El mensaje se ha entregado o no 
	
	public synchronized boolean entregado(Mensaje men) throws InterruptedException
	{	
		if(tamanioCola<capacidadBuffer)
		{
			colaDEspera.enqueue(men);
			tamanioCola++;
			return true;
		}
		return false;
	}
	
	//se concume el mensaje
	
	public synchronized Mensaje consumirMensaje() throws InterruptedException
	{
		while(tamanioCola==0)
		{
			wait();
			if(tamanioCola==0)
			{
				notifyAll();
				return null;
			}
		}
		tamanioCola--;
		
		notifyAll();
		return colaDEspera.dequeue();
	}
	
	public synchronized void disminuirCliente()
	{
		numeroClientes--;
	}
	
	public synchronized boolean hayClientes()
	{
		return(numeroClientes!=0);
	}
	
}
