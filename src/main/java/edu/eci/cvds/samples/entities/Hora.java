package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

public class Hora implements Serializable{
	
	private long id;
	private LocalDateTime hora;
	private boolean disponible;

	public Hora(long id, LocalDateTime hora, boolean disponible) {
		this.id=id;
		this.hora=hora;
		this.disponible=disponible;
	}
	
	public Hora(long id, LocalDateTime hora) {
		this.id=id;
		this.hora=hora;
		this.disponible=false;
	}

	public Hora() {}
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id=id;
	}
	
	
	public LocalDateTime getHora() {
		return this.hora;
	}
	
	public void setHora(LocalDateTime hora) {
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










