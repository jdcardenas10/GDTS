package gdts;

import sun.misc.Queue;

public class Buffer 
{
	//Atributos
	
	//Numero de Clientes
	int numeroClientes;
	
	//tamanio de la cola
	int tamanioCola;
	
	//capacidad del buffer
	int capacidadBuffer;
	
	//Cola con tamanio fijo
	public Queue<Mensaje> colaDEspera;
	
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
		//boolean mensajeEnviado= false;
		
		if(tamanioCola<capacidadBuffer)
		{
			System.out.println(men.getInfoMensaje());
			tamanioCola++;
			colaDEspera.enqueue(men);
			return true;
			//notifyAll();
		}
		
		//notifyAll();
		return false;
	}
	
	//se concume el mensaje
	
	public synchronized Mensaje consumirMensaje() throws InterruptedException
	{
		while(tamanioCola==0)
		{
			wait();
			if(numeroClientes==0)
			{
				System.out.println("No se consumio");
				return null;
			}
		}
		tamanioCola--;
		
		notifyAll();
		return colaDEspera.dequeue();
	}
	
}
