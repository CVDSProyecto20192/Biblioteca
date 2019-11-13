package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.util.List;

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
	private List<Horario> tiempo;
	private Tipo tipo;
	
	public Recurso(){
		
	}
	
	public Recurso(long id, String nombre, String ubicacion, int capacidad, boolean disponible, 
			List<Horario>tiempo, Tipo tipo){
		
		this.id=id;
		this.nombre=nombre;
		this.ubicacion=ubicacion;
		this.capacidad=capacidad;
		this.disponible=disponible;
		this.tiempo=tiempo;
		this.tipo=tipo;
	}
	
	public Recurso(long id, String nombre, String ubicacion, int capacidad, boolean disponible,
			List<Horario>tiempo){
		
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
	
	public List<Horario> getTiempo() {
		return this.tiempo;
	}

	public void setTiempo(List<Horario> tiempo) {
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
        return "Recurso{" + "id=" + this.id + ", nombre=" + this.nombre + ", ubicacion=" +
        this.ubicacion + ", capacidad=" + this.capacidad + ", tiempo=\n\t" + this.tiempo + ", tipo=" + this.tipo +  '}';                                
    }
}

