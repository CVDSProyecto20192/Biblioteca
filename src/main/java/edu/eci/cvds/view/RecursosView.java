package edu.eci.cvds.view;

import java.sql.Date;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;


import edu.eci.cvds.exceptions.PersistenceException;
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
	private ArrayList<Horario> tiempo;
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
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	private void actionHorarios(Recurso r) {
		long id_r=r.getId();
		DateFormatSymbols dfs = new DateFormatSymbols(new Locale("es"));
		this.tiempo=new ArrayList<Horario>();
        String[] weekdays = dfs.getWeekdays();
        /*LocalDateTime horaPrueba= LocalDateTime.now();
        ArrayList<Hora>prueba=new ArrayList<Hora>();*/
        
        for (String weekday : weekdays) {
        	if(weekday!="" && weekday!="domingo"){
        		Horario h=new Horario(id_r,weekday);
        		//Hora hs=new Hora(id_r,horaPrueba);
        		long id_hora;
				try {
					this.serviciosReserva.agregarHorario(h, id_r);
					/*this.serviciosReserva.agregarHora(h, hs);
					id_hora = this.serviciosReserva.consultarIdHora(h, hs);
					hs.setId(id_hora);
					prueba.add(hs);*/
					
					
				} 
				catch (ServiciosReservaException e1) {
					e1.printStackTrace();
				}
				//h.setHoras(prueba);
        		this.tiempo.add(h);
        	}
        }
        r.setTiempo(this.tiempo);
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
		this.tiempo=null;
		this.tipo=null;
		this.idTipo=0;
		
	}
	
	public void actionSetIdRen(long id) {
		this.baseBean.setIdRec(id);
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
	
	/*public static void main(String[] args) {
		DateFormatSymbols dfs = new DateFormatSymbols(new Locale("es"));
        String[] weekdays = dfs.getWeekdays();
        
        for (String weekday : weekdays) {
        	if(weekday!="" && weekday!="domingo"){
        		System.out.println("weekday = " + weekday);
        	}
        }
	}*/
}
