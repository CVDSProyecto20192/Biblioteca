package edu.eci.cvds.view;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;


import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.exceptions.ServiciosReservaException;
import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.services.ServiciosReserva;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

@ManagedBean(name = "ReservasUsersBean")
@SessionScoped
public class ReservasUsersView {
	
	private ServiciosReserva serviciosReserva;

	@ManagedProperty(value = "#{ReservaBean}")
	private BasePageBean baseBean;
	
	private List<Reserva> reservas;
	
	private Reserva selected;
	
	private String siguiente;
	
	private String ultima;
	
	private String carnet;
	
	private String correo;
	
	public ReservasUsersView() {
	}
	
	@PostConstruct
	public void init() {
		serviciosReserva=baseBean.getServiciosReserva();
		Subject subject = SecurityUtils.getSubject();
		correo = String.valueOf(subject.getSession().getAttribute("Correo"));
		try {
			Usuario u = serviciosReserva.consultarUsuarioCorreo(correo);
			if (u.getCargo().getNombre().equals("Comunidad")){
				reservas = serviciosReserva.consultarReservasUsuario(u.getCarnet());
			}
			else{
				reservas= serviciosReserva.consultarReservas();
			}
		}catch (ServiciosReservaException e) {
			baseBean.mensajeApp(e);
		}
	}
	
	
	public List<Reserva> getReservas(){
		return this.reservas;
	}
	
	public BasePageBean getBaseBean() {
		return this.baseBean;
	}
	
	public void setBaseBean(BasePageBean bs){
	    this.baseBean = bs;
	}
	
	public Reserva getSelected() {
		return this.selected;
	}
	
	public void setSelected(Reserva re) {
		this.selected = re;
	}
	
	//public Reserva getUltima() {
		//listar((int) selected.getGrupo());
	//}
	public String getUltima() {
		try{
			ultima=serviciosReserva.calcularUltima(selected);
		}catch(ServiciosReservaException e){
			baseBean.mensajeApp(e);
		}
		return this.ultima;
	}

	
	public String getSiguiente() {
		try{
			siguiente=serviciosReserva.calcularSiguiente(selected);
		}catch(ServiciosReservaException e){
			baseBean.mensajeApp(e);
		}
		return this.siguiente;
	}
	
}
	
	