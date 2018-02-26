package gdts;

public class Mensaje 
{
	//Atributos
	
	//Relacion con el buffer
	//public static Buffer buffer;
	
	//Contenido del mensaje-Consulta
	public int info;
	
	//Constructor
	public Mensaje(int pInfo) 
	{
		info=pInfo;
	}
	
	//Metodos
	
	//enviar mensaje
	//public synchronized boolean enviarMensaje() throws InterruptedException
	//{
		//boolean enviado= buffer.entregado(this);
		//return enviado;
	//}
	
	//dar informacion de los mensaje
	public int getInfoMensaje()
	{
		return info;
	}
	
	//asignar la informaci�n del mensaje 
	public synchronized void setInfoMensaje(int pInfo)
	{
		this.info=pInfo;

	}
	
	//public static void darUltimoMensaje()
	//{
		//buffer.numeroClientes--;
	//}
	
	public synchronized void notificar(){
		notify();
	}
	
	public synchronized void esperar(){
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
