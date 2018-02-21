package gdts;

public class Mensaje 
{
	//Atributos
	
	//Relacion con el buffer
	public static Buffer buffer;
	
	//Contenido del mensaje-Consulta
	public int info;
	
	//Constructor
	public Mensaje(int pInfo) 
	{
	// TODO Auto-generated constructor stub
		info=pInfo;
	}
	
	//M�todos
	
	//enviar mensaje
	public boolean enviarMensaje() throws InterruptedException
	{
		boolean enviado= buffer.entregado(this);
		return enviado;
	}
	
	//dar informaci�n de los mensaje
	public int getInfoMensaje()
	{
		return info;
	}
	
	//asignar la informaci�n del mensaje 
	public void setInfoMensaje(int pInfo)
	{
		this.info=pInfo;

	}
	
	public static void darUltimoMensaje()
	{
		buffer.numeroClientes--;
	}
}
