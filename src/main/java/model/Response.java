package model;

public class Response {

	private int status;
	private String mensaje;
	
	public Response(int unStatus, String unMensaje) {
		status = unStatus;
		mensaje = unMensaje;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
