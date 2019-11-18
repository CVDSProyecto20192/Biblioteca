package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

public class Hora implements Serializable{
	
	private long id;
	private String dia;
	private LocalDateTime hora;

		
	public Hora(long id, String dia, LocalDateTime hora) {
		this.id=id;
		this.dia=dia;
		this.hora=hora;
	}

	public Hora() {}
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id=id;
	}
	
	public String getDia() {
		return this.dia;
	}
	
	public void setDia(String dia) {
		this.dia=dia;
	}
	
	public LocalDateTime getHora() {
		return this.hora;
	}
	
	public void setHora(LocalDateTime hora) {
		this.hora=hora;
	}
	
	@Override
    public String toString() {
        return "Hora{" + "id=" + id + ", dia=" + dia + ", hora=" + hora + '}';                                                  

	}
}
