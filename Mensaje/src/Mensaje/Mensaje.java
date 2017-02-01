package Mensaje;

import java.io.Serializable;

public class Mensaje implements Serializable{
	
	private int codigo;
	private String usuario;
	private String mensaje;
	
	//Constructor
	public Mensaje(int codigo, String usuario, String mensaje) {
		super();
		this.codigo = codigo;
		this.usuario = usuario;
		this.mensaje = mensaje;
	}
	
	//Getter and Setter
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	

}
