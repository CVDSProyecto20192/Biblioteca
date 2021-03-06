package edu.eci.cvds.samples.entities;

import java.io.Serializable;

public class Tipo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6004907024922753785L;
	private int id;
	private String tipo;
	private String descripcion;
	
	public Tipo() {
		
	}

	public Tipo(int id, String tipo, String descripcion){
		this.id=id;
		this.tipo=tipo;
		this.descripcion=descripcion;
	}
	
	public Tipo(String tipo, String descripcion){
		this.tipo=tipo;
		this.descripcion=descripcion;
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id=id;
	}
	
	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
    public String toString() {
        return "Tipo{" + "id=" + id + ", tipo=" + tipo + ", descripcion=" + descripcion + '}';
    }
}