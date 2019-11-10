package edu.eci.cvds.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import edu.eci.cvds.exceptions.ServiciosReservaException;
import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.services.ServiciosReserva;

@ManagedBean(name = "RecursosBean")
@SessionScoped
public class RecursosView {
	
	private ServiciosReserva serviciosReserva;

	@ManagedProperty(value = "#{ReservaBean}")
	private BasePageBean baseBean;
	
	private long id;
	private String nombre;
	private String ubicacion;
	private int capacidad;
	private boolean disponible;
	private int tiempo;
	private Tipo tipo;
	private int idTipo;
	private List<Recurso> listaRecursos;
	
	public RecursosView() {
	}

	@PostConstruct
	public void init() {
		serviciosReserva=baseBean.getServiciosRecurso();
		actionReiniciar();
		actionSetListaRecursos();
	}
	
	public void actionRegistrarRecurso() {
		
		try {
			this.tipo=serviciosReserva.consultarTipo(this.idTipo);
			actionDisponible();
			Recurso r=new Recurso(this.id,this.nombre,this.ubicacion,this.capacidad,this.disponible,this.tiempo,this.tipo);
			serviciosReserva.agregarRecurso(r);
			actionBuscarId();
		} catch (ServiciosReservaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void actionBuscarId() {
		try {
			this.id=serviciosReserva.consultarIdRecurso(this.nombre,this.tipo,this.ubicacion);
		} 
		catch (ServiciosReservaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void actionSetListaRecursos() {
		try {
			this.listaRecursos=serviciosReserva.consultarRecursos();
		} 
		catch (ServiciosReservaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void actionDisponible() {
		this.disponible=false;
		if(this.capacidad>0) this.disponible=true;
	}
	
	public void actionBloquear(long id) {
		boolean b;
		try {
			b = serviciosReserva.consultarDisponibilidadRecurso(id);
			serviciosReserva.cambiarDisponibilidadRecurso(id,!b);
		} catch (ServiciosReservaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String actionEstado(boolean b, int capacidad) {
		String s="bloqueo";
		if(b==false && capacidad>0) s="desbloqueo";
		return s;
	}
	
	public void actionReiniciar() {
		this.id=-1;
		this.nombre=null;
		this.ubicacion=null;
		this.capacidad=0;
		this.disponible=false;
		this.tiempo=0;
		this.tipo=null;
		this.idTipo=0;
		
	}
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id=id;
		
	}
	
	public String getNombre() {
		return this.nombre;
		
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}

	public String getUbicacion() {
		return this.ubicacion;
		
	}
	
	public void setUbicacion(String ubi) {
		this.ubicacion=ubi;
	}
	
	public int getCapacidad() {
		return this.capacidad;
	}
	
	public void setCapacidad(int cap) {
		this.capacidad=cap;
		
	}
	
	public boolean getDisponible() {
		return this.disponible;
		
	}
	
	public void setDisponible(boolean disp) {
		this.disponible=disp;
	}

	public int getTiempo() {
		return this.tiempo;
	}
	
	public void setTiempo(int time) {
		this.tiempo=time;
		
	}
	
	public Tipo getTipo() {
		return this.tipo;
	}
	
	public void setTipo(Tipo tipo) {
		this.tipo=tipo;
		
	}
	
	public int getIdTipo() {
		return this.idTipo;
	}
	
	public void setIdTipo(int idT) {
		this.idTipo=idT;
		
	}
	
	public List<Recurso> getListaRecursos(){
		actionSetListaRecursos();
		return this.listaRecursos;
	}
	
	public BasePageBean getUsuario() {
		return this.baseBean;
	}
	
	public void setBaseBean(BasePageBean bs){
	    this.baseBean = bs;
	}
}
