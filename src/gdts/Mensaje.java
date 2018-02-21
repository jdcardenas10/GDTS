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
	
	//Métodos
	
	//enviar mensaje
	public boolean enviarMensaje() throws InterruptedException
	{
		boolean enviado= buffer.entregado(this);
		return enviado;
	}
	
	//dar información de los mensaje
	public int getInfoMensaje()
	{
		return info;
	}
	
	//asignar la información del mensaje 
	public void setInfoMensaje(int pInfo)
	{
		this.info=pInfo;

	}
	
	public static void darUltimoMensaje()
	{
		buffer.numeroClientes--;
	}
}
