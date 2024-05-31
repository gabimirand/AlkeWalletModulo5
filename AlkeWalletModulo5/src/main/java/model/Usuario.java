package model;

public class Usuario {
	
	//Atributos
	private int user_id; 
	private String nombre_usuario;
	private String correo;
	private String contrasena; 
	private double saldo;
	
	//Constructor vacío
	public Usuario() {
		super();
	}

	//Constructor con parámetros	
	public Usuario(int user_id, String nombre_usuario, String correo, String contrasena, double saldo) {
		super();
		this.user_id = user_id;
		this.nombre_usuario = nombre_usuario;
		this.correo = correo;
		this.contrasena = contrasena;
		this.saldo = saldo;
	}
	
	//Getter and Setter
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	} 
	
	
	
	
	

}
