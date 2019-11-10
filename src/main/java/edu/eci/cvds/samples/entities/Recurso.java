package edu.eci.cvds.samples.entities;

import java.io.Serializable;

public class Recurso implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String nombre;
	private String ubicacion;
	private int capacidad;
	private boolean disponible;
	private int tiempo;
	private Tipo tipo;
	
	public Recurso(){
		
	}
	
	public Recurso(long id, String nombre, String ubicacion, int capacidad, boolean disponible, int tiempo, 
			Tipo tipo){
		
		this.id=id;
		this.nombre=nombre;
		this.ubicacion=ubicacion;
		this.capacidad=capacidad;
		this.disponible=disponible;
		this.tiempo=tiempo;
		this.tipo=tipo;
	}
	
	public Recurso(long id, String nombre, String ubicacion, int capacidad, boolean disponible, int tiempo){
		
		this.id=id;
		this.nombre=nombre;
		this.ubicacion=ubicacion;
		this.capacidad=capacidad;
		this.disponible=disponible;
		this.tiempo=tiempo;
	}
	
	
	public long getId(){
		return id;
	}
	public void setId(long id){
		this.id=id;
	}
	
	public String getNombre(){
		return nombre;
	}
	public void setNombre(String nombre){
		this.nombre=nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	public int getTiempo() {
		return this.tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo=tiempo;
	}
	
	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
    public String toString() {
        return "Recurso{" + "id=" + this.id + ", nombre=" + this.nombre + ", ubicacion=" + this.ubicacion + ", capacidad=" + this.capacidad + ", tiempo=" + this.tiempo + ", tipo=" + this.tipo +  '}';                                
    }
	
}

