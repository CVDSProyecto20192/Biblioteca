package edu.eci.cvds.samples.entities;

import java.util.Date;

public class Reserva {

	private long codigo;
	private Date fecha;
	private int hora;
	private int duracion;
	private Usuario usuario;
	private Recurso recurso;
	
	public Reserva() {
		
	}
	
	public Reserva(long codigo, Date fecha, int hora, int duracion, Usuario usuario, Recurso recurso){
		
		 this.codigo=codigo;
		 this.fecha=fecha;
		 this.hora=hora;
		 this.duracion=duracion;
		 this.usuario=usuario;
	}
	
	public long getCodigo(){
		return this.codigo;
	}
	
	public void setCodigo(long codigo){
		this.codigo=codigo;
	}
	
	
	public Date getFecha(){
		return this.fecha;
	}
	
	public void setFecha(Date fecha){
		this.fecha=fecha;
	}
	
	public int getHora(){
		return this.hora;
	}
	
	public void setHora(int hora){
		this.hora=hora;
	}
	
	public int getDuracion(){
		return this.duracion;
	}
	
	public void setDuracion(int duracion){
		this.duracion=duracion;
	}
	
	public Usuario getUsuario(){
		return this.usuario;
	}
	
	public void setUsuario(Usuario usuario){
		this.usuario=usuario;
	}
	
	public Recurso getRecurso(){
		return this.recurso;
	}
	
	public void setUsuario(Recurso recurso){
		this.recurso=recurso;
	}
	
	@Override
    public String toString() {
        return "Reserva{" + "codigo=" + this.codigo + ", fecha=" + this.fecha + ", hora=" +
        this.hora + ", duracion=" + this.duracion + ", usuario=" + this.usuario + ", recurso=" + this.recurso +  '}';                                
    }
	
}
