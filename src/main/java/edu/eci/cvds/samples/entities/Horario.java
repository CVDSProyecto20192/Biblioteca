package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Horario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -690719691374115753L;
	private long id;
	private String dia;
	private ArrayList<Hora> horas;

	public Horario(long id, String dia, ArrayList<Hora> horas) {
		this.id=id;
		this.dia=dia;
		this.horas=horas;
	}
	
	public Horario(long id, String dia) {
		this.id=id;
		this.dia=dia;
		this.horas = new ArrayList<Hora>();
		
	}

	public Horario() {}
	
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
		this.dia=dia;;
	}
	
	public ArrayList<Hora> getHoras() {
		return this.horas;
	}
	
	public void setHoras(ArrayList<Hora> horas) {
		this.horas=horas;
	}
	
	@Override
    public String toString() {
		return "Horario{" + "id=" + id + ", dia=" + dia + ", horas=\n\t" + horas + '}';                                                  

	}
}
	
	