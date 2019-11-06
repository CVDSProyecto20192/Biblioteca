package edu.eci.cvds.samples.entities;
import java.util.Date;

public class Usuario {
	private String carnet;
	private String documento;
	private String correo;
	private String nombres;
	private String apellidos;
	private String password;
	private Date ultimoIngreso;
	private boolean bloqueado;
	private Cargo cargo;
	
	public Usuario(){	
	}
	
	public Usuario(String carnet, String documento, String correo, String nombres, String apellidos, String password, 
			boolean bloqueado, Cargo cargo ) {   
		this.carnet=carnet;
		this.documento=documento;
		this.correo=correo;
		this.nombres=nombres;
		this.apellidos=apellidos;
		this.password=password;
		this.bloqueado=bloqueado;
		this.cargo=cargo;
    }
	
	public String getCarnet(){
		return this.carnet;
	}
	public void setCarnet(String carnet){
		this.carnet=carnet;
	}
	
	public String getDocumento(){
		return this.documento;
	}
	public void setDocumento(String documento){
		this.documento=documento;
	}
	
	public String getCorreo(){
		return this.correo;
	}
	public void setCorreo(String correo){
		this.correo=correo;
	}
	
	public String getNombres(){
		return this.nombres;
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
	
	public String getPassword(){
		return this.password;
	}
	public void setPassword(String password){
		this.password=password;
	}
	
	public Date getUltimoIngreso(){
		return this.ultimoIngreso;
	}
	public void setUltimoIngreso(Date ultimoIngreso){
		this.ultimoIngreso=ultimoIngreso;
	}
	
	public boolean getBloqueado(){
		return this.bloqueado;
	}
	public void setBloqueado(boolean bloqueado){
		this.bloqueado=bloqueado;
	}
	
	public Cargo getCargo(){
		return this.cargo;
	}
	public void setCargo(Cargo cargo){
		this.cargo=cargo;
	}
	
}