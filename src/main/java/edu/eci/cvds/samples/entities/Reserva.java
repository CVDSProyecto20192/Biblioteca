package edu.eci.cvds.samples.entities;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Reserva {

	private long codigo;
	private Date fecha;
	private int hora;
	private int duracion;
	private Usuario usuario;
	private Recurso recurso;
	private boolean activa;
	private long grupo;
	
	public Reserva() {
		
	}
	
	public Reserva(long codigo, Date fecha, int hora, int duracion, Usuario usuario, Recurso recurso, long grupo){
		 this.codigo=codigo;
		 this.fecha=fecha;
		 this.hora=hora;
		 this.duracion=duracion;
		 this.usuario=usuario;
		 this.activa = true;
		 this.grupo = grupo;
		 this.recurso=recurso;
	}
	
	public Reserva(long codigo, String fecha, int hora, int duracion, Usuario usuario, Recurso recurso, long grupo){
		 this.recurso=recurso;
		 this.codigo=codigo;
		 this.hora=hora;
		 this.duracion=duracion;
		 this.usuario=usuario;
		 this.activa = true;
		 this.grupo = grupo;
		 try{
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = formatter.parse(fecha);
			this.fecha=date;
		 }
		 catch (ParseException e) {
            e.printStackTrace();
        }
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
	
	public void setRecurso(Recurso recurso){
		this.recurso=recurso;
	}
	
	public boolean getActiva(){
		return this.activa;
	}
	
	public void setActiva(boolean activa){
		this.activa=activa;
	}
	
	public long getGrupo(){
		return this.grupo;
	}
	
	public void setUsuario(long grupo){
		this.grupo=grupo;
	}
	
	@Override
    public String toString() {
        return "Reserva{" + "codigo=" + this.codigo + ", fecha=" + this.fecha + ", hora=" +
        this.hora + ", duracion=" + this.duracion + ", usuario=" + this.usuario + ", recurso=" + this.recurso +   
		", activa=" + this.activa + ", grupo=" + this.grupo + '}';                                
    }
	
}
