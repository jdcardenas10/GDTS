/**
 * Seccion 2
 * @author Jose Daniel Cardenas Rincon 	201313488
 * @author David Alejandro Cortes Vesga 201423363     
 */
package gdts;

public class Mensaje 
{
	/////////////Atributos///////////////////
	
	//id del mensaje
	private int id;
	
	//Contenido del mensaje-Consulta
	public int info;
	
	///////////////Constructor///////////////////
	
	//Constructor del mensaje
	public Mensaje(int id,int info) 
	{
		this.id=id;
		this.info=info;
	}
	
	/////////////////Metodos//////////////////////
	
	//dar informacion de los mensaje
	public synchronized int getInfoMensaje()
	{
		return info;
	}
	
	//asignar la informacion del mensaje 
	public synchronized void setInfoMensaje(int info)
	{
		this.info=info;
	}
	
	//Notifica a un hilo de ejecucion que este esprando sobre un objeto mensaje
	public synchronized void notificar(){
		notify();
	}
	
	//pone en espera a un hilo de ejecuión sobre mensaje
	public synchronized void esperar(){
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//devuelve el id del mensaje
	public synchronized int getId() {
		return id;
	}
}
