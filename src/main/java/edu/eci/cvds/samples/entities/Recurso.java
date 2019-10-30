package edu.eci.cvds.samples.entities;

public class Recurso{
	private long identificador;
	private String nombre;
	private String ubicacion;
	private String tipo;
	private int capacidad;
	private boolean disponible;
	
	public Recurso(){
		
	}
	
	public Recurso(long identificador, String nombre, String ubicacion, String tipo, int capacidad, boolean disponible){
		this.identificador=identificador;
		this.nombre=nombre;
		this.setUbicacion(ubicacion);
		this.setTipo(tipo);
		this.setCapacidad(capacidad);
		this.setDisponible(disponible);
	}
	
	public long getIdentificador(){
		return identificador;
	}
	public void setIdentificador(long identificador){
		this.identificador=identificador;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
}