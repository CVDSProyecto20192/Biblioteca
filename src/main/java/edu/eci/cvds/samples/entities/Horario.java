package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Horario implements Serializable{
	private long id;
	private String dia;
	private List<Date> horas;


	public Horario(long id, String dia, List<Date> horas) {
		this.id=id;
		this.dia=dia;
		this.horas=horas;
	}
	
	public Horario(long id, String dia) {
		this.id=id;
		this.dia=dia;
	}

	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id=id;
	}
	
	public String getDia() {
		return this.dia;
	}
	
	public void setId(String dia) {
		this.dia=dia;;
	}
	
	public List<Date> getHoras() {
		return this.horas;
	}
	
	public void setId(List<Date> horas) {
		this.horas=horas;
	}
	
	@Override
    public String toString() {
        return "Horario{" + "id=" + this.id + ", dia=" + this.dia + ", horas=\n\t" + this.horas + '}';                                                  
    }
}
	
	