package gdts;

public class Servidor extends Thread{

	
	private int idT;
	
	public static Buffer buffer;
	
	public Servidor(int idT){
		this.setIdT(idT);
	}
	
	public void run(){
		try {
			while(buffer.numeroClientes!=0){
				Mensaje mensaje=buffer.consumirMensaje();
				mensaje.setInfoMensaje(mensaje.getInfoMensaje()+1);
				mensaje.notificar();
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
