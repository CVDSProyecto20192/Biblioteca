package edu.eci.cvds.view;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import edu.eci.cvds.exceptions.ServiciosReservaException;
import edu.eci.cvds.samples.entities.Hora;
import edu.eci.cvds.samples.entities.Horario;
import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.entities.Tipo;
import edu.eci.cvds.samples.services.ServiciosReserva;

@SuppressWarnings("deprecation")
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
	private ArrayList<Horario> tiempo;
	private Tipo tipo;
	private int idTipo;
	private List<Recurso> listaRecursos;
	
	private Recurso selectedRecurso;
	
	public RecursosView() {
	}

	
	@PostConstruct
	public void init() {
		serviciosReserva=baseBean.getServiciosReserva();
		actionReiniciar();
		actionSetListaRecursos();
	}
	
	public void actionRegistrarRecurso(){
		
		try {
			this.tipo=serviciosReserva.consultarTipo(this.idTipo);
			actionDisponible();
		
			Recurso r=new Recurso(this.id,this.nombre,this.ubicacion,this.capacidad,this.disponible,this.tiempo,this.tipo);
			serviciosReserva.agregarRecurso(r);
			actionBuscarId();
			r.setId(this.id);
			actionHorarios(r);
			
		} 
		catch (ServiciosReservaException e) {
			baseBean.mensajeApp(e);
		}
		catch (Exception e) {
			baseBean.mensajeApp(e);
		}
	}
	
	private void actionHorarios(Recurso r) {
		long id_r=r.getId();
		this.tiempo=new ArrayList<Horario>();
		
		DateFormatSymbols dfs = new DateFormatSymbols(new Locale("es"));
        String[] weekdays = dfs.getWeekdays();
        
        for (String weekday : weekdays) {
        	if(weekday!="" && weekday!="domingo"){
        		Horario h=new Horario(id_r,weekday);
        		Hora hs=new Hora();
        		long id_hora;
				try {
					this.serviciosReserva.agregarHorario(h, id_r);
					this.serviciosReserva.agregarHora(h, hs);
					id_hora = this.serviciosReserva.consultarIdHora(h, hs);
					hs.setId(id_hora);		
				} 
				catch (ServiciosReservaException e) {
					baseBean.mensajeApp(e);
				}
        	}
        }
        
        try {
			this.tiempo=(ArrayList<Horario>) this.serviciosReserva.consultarHorarioDias(id_r);
		} 
        catch (ServiciosReservaException e) {
			baseBean.mensajeApp(e);
		}
        r.setTiempo(this.tiempo);
	}
	
	
	private void actionBuscarId() {
		try {
			this.id=serviciosReserva.consultarIdRecurso(this.nombre,this.tipo,this.ubicacion);
		} 
		catch (ServiciosReservaException e) {
			baseBean.mensajeApp(e);
		}
	}
	
	private void actionSetListaRecursos() {
		try {
			this.listaRecursos=serviciosReserva.consultarRecursos();
		} 
		catch (ServiciosReservaException e) {
			baseBean.mensajeApp(e);
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
			baseBean.mensajeApp(e);
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
		this.tiempo=null;
		this.tipo=null;
		this.idTipo=0;
		
	}
	
	public void actionSetIdRen(long id) {
		this.baseBean.setIdRec(id);
	}
	
	
	public void actionHorarios(long idRecurso) {
		this.baseBean.setIdRec(idRecurso);
	}
	
	
	public List<Recurso> getActivos(){
		List<Recurso> activos = null;
		try{
			activos= serviciosReserva.consultarRecursosActivos();
		}
		catch (ServiciosReservaException e) {
			baseBean.mensajeApp(e);
		}
		return activos;
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

	public List<Horario> getTiempo() {
		return this.tiempo;
	}
	
	public void setTiempo(ArrayList<Horario> time) {
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
	
	public Recurso getSelectedRecurso() {
        return selectedRecurso;
    }
	
	public void setSelectedRecurso(Recurso selectedRecurso) {
        this.selectedRecurso = selectedRecurso;
    }
	
	public String disponibilidad(){
		return "Disponibilidad?faces-redirect=true&recurso=" + selectedRecurso.getId();
	}
}