package edu.eci.cvds.samples.entities;
import java.util.Date;

public class Usuario {
	private String carnet;
	private String documento;
	private String correo;
	private String nombres;
	private String apellidos;
	private String contraseña;
	private Date ultimoIngreso;
	private boolean bloqueado;
	
	public Usuario(){	
	}
	
	public Usuario(String carnet, String documento, String correo, String nombres, String apellidos, String contraseña, boolean bloqueado ) {   
      this.carnet=carnet;
	  this.documento=documento;
	  this.correo=correo;
	  this.nombres=nombres;
	  this.apellidos=apellidos;
	  this.contraseña=contraseña;
	  this.bloqueado=bloqueado;
    }
	
	public String getCarnet(){
		return carnet;
	}
	public void setCarnet(String carnet){
		this.carnet=carnet;
	}
	
	public String getDocumento(){
		return documento;
	}
	public void setDocumento(String documento){
		this.documento=documento;
	}
	
	public String getCorreo(){
		return correo;
	}
	public void setCorreo(String correo){
		this.correo=correo;
	}
	
	public String getNombres(){
		return nombres;
	}
	public void setNombres(String nombres){
		this.nombres=nombres;
	}
	
	public String getApellidos(){
		return apellidos;
	}
	public void setApellidos(String apellidos){
		this.apellidos=apellidos;
	}
	
	public String getContraseña(){
		return contraseña;
	}
	public void setContraseña(String contraseña){
		this.contraseña=contraseña;
	}
	
	public Date getUltimoIngreso(){
		return ultimoIngreso;
	}
	public void setUltimoIngreso(Date ultimoIngreso){
		this.ultimoIngreso=ultimoIngreso;
	}
	
	public boolean getBloqueado(){
		return bloqueado;
	}
	public void setBloqueado(boolean bloqueado){
		this.bloqueado=bloqueado;
	}
	
}