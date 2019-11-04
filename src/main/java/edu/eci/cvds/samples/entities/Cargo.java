package edu.eci.cvds.samples.entities;

import java.util.Date;

public class Cargo {
	
	private long id;
	private String nombre;
	private String descripcion;

	public Cargo() {
		
	}
	
	public Cargo(long id, String nombre, String descripcion) {
		this.id=id;
		this.nombre=nombre;
		this.descripcion=descripcion;
		
	}

	
	public long getId(){
		return this.id;
	}
	
	public void setId(long id){
		this.id=id;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}

	public String getDescripcion(){
		return this.descripcion;
	}
	
	public void setDescripcion(String descripcion){
		this.descripcion=descripcion;
	}
}

