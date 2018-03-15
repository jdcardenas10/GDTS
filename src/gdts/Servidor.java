/**
 * Seccion 2
 * @author Jose Daniel Cardenas Rincon 	201313488
 * @author David Alejandro Cortes Vesga 201423363     
 */
package gdts;

public class Servidor extends Thread{
	
	/////////////Atributos///////////////////

	//El identificador del servidor
	private int idT;
	
	//Referencia al buffer de donde extrae mensajes
	public static Buffer buffer;
	
	///////////////Constructor///////////////////
	
	//Metodo constructor del Buffer
	public Servidor(int idT){
		this.setIdT(idT);
	}
	
	/////////////////Metodos//////////////////////
	
	//Metodo Run del hilo servidor
	public void run(){
		try {
			while(buffer.hayClientes()){
				Mensaje mensaje=buffer.consumirMensaje();
				if (mensaje!=null)
				{
					mensaje.setInfoMensaje(mensaje.getInfoMensaje()+1);
					mensaje.notificar();
				}
			}
			buffer.notificarTodos();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//modifica el id del servidor
	public void setIdT(int id) {
		this.idT = id;
	}
	
	//Devuelve el identificador del servidor
	public int getIdT() {
		return idT;
	}
}
