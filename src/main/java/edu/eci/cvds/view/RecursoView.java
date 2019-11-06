package edu.eci.cvds.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import edu.eci.cvds.samples.services.ServiciosReserva;
import org.primefaces.event.SelectEvent;
import edu.eci.cvds.samples.entities.Recurso;
import java.util.List;

@ManagedBean(name = "RecursoBean")
@ViewScoped
public class RecursoView {
	
	@Inject
	private ServiciosReserva serviciosReserva;

	
	private String id;
	
	public RecursoView() {
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id=id;	
	}
	
	public List<Recurso> getRecursosLibres(){
		System.out.println(serviciosReserva);
		return serviciosReserva.consultarRecursosDisponibles();
	}
	
	public void onRowSelected (SelectEvent event){
		System.out.println("selecciono");
	}
}

