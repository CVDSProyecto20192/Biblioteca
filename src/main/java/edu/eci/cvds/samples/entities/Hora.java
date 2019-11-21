package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.util.Date;
import java.time.LocalDateTime;

public class Hora implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private Date hora;
	private boolean disponible;

	public Hora(long id, Date hora, boolean disponible) {
		this.id=id;
		this.hora=hora;
		this.disponible=disponible;
	}
	
	public Hora(long id, Date hora) {
		this.id=id;
		this.hora=hora;
		this.disponible=false;
	}

	public Hora() {
		this.hora= new Date(System.currentTimeMillis());
		this.disponible=false;
	}
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id=id;
	}
	
	
	public Date getHora() {
		return this.hora;
	}
	
	public void setHora(Date hora) {
		this.hora=hora;
	}
	
	public boolean getDisponible() {
		return this.disponible;
	}
	
	public void setDisponible(boolean disponible) {
		this.disponible=disponible;
	}
	
	@Override
    public String toString() {
        return "Hora{" + "id=" + id + ", hora=" + hora + ", disponible=" + disponible + '}';                                                  

	}
}




