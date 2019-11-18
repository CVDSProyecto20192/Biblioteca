package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

public class Hora implements Serializable{
	
	private long id;
	private LocalDateTime hora;

		
	public Hora(long id, LocalDateTime hora) {
		this.id=id;
		this.hora=hora;
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
	
	@Override
    public String toString() {
        return "Hora{" + "id=" + id + ", hora=" + hora + '}';                                                  

	}
}
