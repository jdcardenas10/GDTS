/**
 * Seccion 2
 * @author Jose Daniel Cardenas Rincon 	201313488
 * @author David Alejandro Cortes Vesga 201423363     
 */
package gdts;

public class Cliente extends Thread
{
	/////////////Atributos///////////////////
	
    //identificador cliente
	private int idT;
	
	//Numero de mensajes enviados
	private int numSMS;
	
	public static Buffer buffer;
	
	///////////////Constructor///////////////////
	
    //Constructor del cliente
	public Cliente(int pIdT, int pMensajes)
	{
		setIdT(pIdT);
		numSMS=pMensajes;
	}
	
	/////////////////Metodos//////////////////////
	
	//El metodo Run del hilo cliente
	public void run()
	{
		for (int i = 0; i < numSMS; i++)
		{
			Mensaje sms= new Mensaje(i,i);
			System.out.println("Id Cliente: "+idT+" Id mensaje: "+sms.getId()+" Mensaje inicial: "+sms.getInfoMensaje());
			try {
				while(!buffer.entregado(sms)){yield();}
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			sms.esperar();
			System.out.println("Id Cliente: "+idT+" Id mensaje: "+sms.getId()+" Mensaje respuesta: "+sms.getInfoMensaje());
			//if(i+1==numSMS){buffer.disminuirCliente();}
		}
		buffer.disminuirCliente();
	}

	//Devuelve el id del cliente
	public int getIdT() {
		return idT;
	}

	//Modifica el id del cliente 
	public void setIdT(int idT) {
		this.idT = idT;
	}
}
