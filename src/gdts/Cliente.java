package gdts;

import java.io.IOException;

public class Cliente extends Thread
{
    //identificador cliente
	private int id;
	
	//Número de mensajes enviados
	private int numSMSEnviados;
	
    //Constructor
	public Cliente(int pMensajesEnviados)
	{
		// TODO Auto-generated constructor stub
		numSMSEnviados=pMensajesEnviados;
	}
	
	//Run -falta completar
	public void run()
	{
		for (int i = 0; i < numSMSEnviados; i++)
		{
			boolean enviado= false;
			
			Mensaje sms= new Mensaje(i);
			
		}
	}
	
	//Main
	public static void main()throws NumberFormatException, IOException
	{
		
	}
}
