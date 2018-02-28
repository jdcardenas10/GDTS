/**
 * Seccion 2
 * @author Jose Daniel Cardenas Rincon 	201313488
 * @author David Alejandro Cortes Vesga      
 */
package gdts;

public class Servidor extends Thread{

	
	private int idT;
	
	public static Buffer buffer;
	
	public Servidor(int idT){
		this.setIdT(idT);
	}
	
	public void run(){
		try {
			while(buffer.hayClientes()){
				Mensaje mensaje=buffer.consumirMensaje();
				if (mensaje!=null){mensaje.setInfoMensaje(mensaje.getInfoMensaje()+1);
				mensaje.notificar();}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void setIdT(int id) {
		this.idT = id;
	}
	
	public int getIdT() {
		return idT;
	}
}
