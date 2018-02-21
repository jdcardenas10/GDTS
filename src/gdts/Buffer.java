package gdts;

import sun.misc.Queue;

public class Buffer 
{
	//Atributos
	
	//Número de Clientes
	int numeroClientes;
	
	//Cola
	
	//tamaño de la cola
	int tamanioCola;
	
	//capacidad del buffer
	int capacidadBuffer;
	
	//Cola con tamanio fijo
	public Queue<Mensaje> colaDEspera;
	
	public Buffer(int pCapacidad, int pNumeroClientes) 
	{
		// TODO Auto-generated constructor stub
		this.capacidadBuffer=pCapacidad;
		this.tamanioCola= 0;
		numeroClientes=pNumeroClientes;
		colaDEspera= new Queue<>();
	}
	
	//Metodos
	
	//dar el número de clientes
	public synchronized int darNumeroClientes()
	{
		return numeroClientes;
	}
	//El mensaje se ha entregado o no 
	
	public synchronized boolean entregado(Mensaje men) throws InterruptedException
	{
		boolean mensajeEnviado= false;
		
		if(tamanioCola<capacidadBuffer)
		{
			System.out.println(men.getInfoMensaje());
			tamanioCola++;
			colaDEspera.enqueue(men);
			mensajeEnviado=true;
			notifyAll();
		}
		return mensajeEnviado;
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
		
		return colaDEspera.dequeue();
	}
	
}
