package gdts;

public class Cliente extends Thread
{
    //identificador cliente
	private int idT;
	
	//N�mero de mensajes enviados
	private int numSMS;
	
	public static Buffer buffer;
	
    //Constructor
	public Cliente(int pIdT, int pMensajes)
	{
		setIdT(pIdT);
		numSMS=pMensajes;
	}
	
	//Run -falta completar
	public void run()
	{
		for (int i = 0; i < numSMS; i++)
		{
			//boolean enviado=false;
			Mensaje sms= new Mensaje(i);
			try {
				while(!buffer.entregado(sms)){
							//if(!enviado){
								yield();
								//}
					}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sms.esperar();
		}
		buffer.numeroClientes--;
	}

	public int getIdT() {
		return idT;
	}

	public void setIdT(int idT) {
		this.idT = idT;
	}
}
