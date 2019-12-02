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
	
	private int id;
	private String nombreTipo;
	private String descripcion;
	private Tipo tipo;
	
	
	
	public TipoView() {
	}

	@PostConstruct
	public void init() {
		serviciosReserva=baseBean.getServiciosReserva();
		actionReiniciar();
		actionSetListaTipos();
	}
	
	
	private void consultarIdTipo() {
		try {
			this.id=this.serviciosReserva.consultarIdTipo(this.tipo);
		} catch (ServiciosReservaException e) {
			e.printStackTrace();
		}
	}
	
	public void actionRegistrarTipo() {
		this.tipo=new Tipo(this.nombreTipo, this.descripcion);
		try {
			this.serviciosReserva.agregarTipo(this.tipo);
			consultarIdTipo();
			actionSetListaTipos();
		} catch (ServiciosReservaException e) {
			e.printStackTrace();
		}
	}
	
	public void actionReiniciar() {
		this.id=-1;
		this.nombreTipo=null;
		this.descripcion=null;
	}
	
	
	private void actionSetListaTipos() {
		try {
			this.listaTipos=serviciosReserva.consultarTipos();
		} 
		catch (ServiciosReservaException e) {
			baseBean.mensajeApp(e);
		}
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public String getNombreTipo() {
		return this.nombreTipo;
	}
	
	public void setNombreTipo(String nombre) {
		this.nombreTipo=nombre;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion=descripcion;
	}
	
	public Tipo getTipo() {
		return this.tipo;
	}
	
	public void setTipo(Tipo t) {
		this.tipo=t;
	}
	
	public List<Tipo> getListaTipos(){
		return this.listaTipos;
	}
	
	public void setListaTipo(List<Tipo> t) {
		this.listaTipos=t;
	}
	
	public BasePageBean getUsuario() {
		return this.baseBean;
	}
	
	public void setBaseBean(BasePageBean bs){
	    this.baseBean = bs;
	}
}
