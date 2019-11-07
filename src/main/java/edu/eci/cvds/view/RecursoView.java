package edu.eci.cvds.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import edu.eci.cvds.samples.services.ServiciosReserva;
import org.primefaces.event.SelectEvent;
import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.entities.Tipo;

import java.util.List;

@ManagedBean(name = "RecursoBean")
@ViewScoped
public class RecursoView {
	
	@Inject
	private ServiciosReserva serviciosReserva;
	
	
	private long id;
	private String nombre;
	private String ubicacion;
	private int capacidad;
	private boolean disponible;
	private int tiempo;
	private int tipoId;
	
	public RecursoView() {
	}
	
	public List<Recurso> getRecursosLibres(){
		System.out.println(serviciosReserva);
		return serviciosReserva.consultarRecursosDisponibles();
	}
	
	public List<Recurso> getRecursos(){
		return serviciosReserva.consultarRecursos();
	}
	
	public void onRowSelected (SelectEvent event){
		System.out.println("selecciono");
	}
	
	public Tipo consultarTipo() {
		Tipo tipo= serviciosReserva.consultarTipo(tipoId);
		return tipo;
	}
	
	public void agregarRecurso() {
		Tipo t= consultarTipo();
		Recurso r= new Recurso(id,nombre,ubicacion,capacidad,disponible, tiempo, t);
		serviciosReserva.agregarRecurso(r);
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public int getTipoId() {
		return tipoId;
	}

	public void setTipoId(int tipoId) {
		this.tipoId = tipoId;
	}
}

