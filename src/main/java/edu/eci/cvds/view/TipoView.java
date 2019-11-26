package edu.eci.cvds.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import edu.eci.cvds.exceptions.ServiciosReservaException;
import edu.eci.cvds.samples.entities.Tipo;
import edu.eci.cvds.samples.services.ServiciosReserva;

@ManagedBean(name = "TiposBean")
@SessionScoped
public class TipoView {
	
	private ServiciosReserva serviciosReserva;

	@ManagedProperty(value = "#{ReservaBean}")
	private BasePageBean baseBean;
	
	private List<Tipo> listaTipos;
	
	public TipoView() {
	}

	@PostConstruct
	public void init() {
		serviciosReserva=baseBean.getServiciosReserva();
		actionSetListaTipos();
	}
	
	
	private void actionSetListaTipos() {
		try {
			this.listaTipos=serviciosReserva.consultarTipos();
		} 
		catch (ServiciosReservaException e) {
			baseBean.mensajeApp(e);
		}
	}
	
	public List<Tipo> getListaTipos(){
		return this.listaTipos;
	}
	
	public BasePageBean getUsuario() {
		return this.baseBean;
	}
	
	public void setBaseBean(BasePageBean bs){
	    this.baseBean = bs;
	}
}
