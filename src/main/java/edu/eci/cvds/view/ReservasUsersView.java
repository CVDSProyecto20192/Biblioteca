package edu.eci.cvds.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import edu.eci.cvds.exceptions.ServiciosReservaException;
import edu.eci.cvds.samples.entities.Reserva;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.ServiciosReserva;

@SuppressWarnings("deprecation")
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
	
	@SuppressWarnings("unused")
	private String carnet;
	
	private String correo;

	private List<Reserva> canceladas;

	private List<Reserva> pasadas;

	private List<Reserva> noActivas;
	
	private List<Reserva> activas;
	
	private Usuario usuario;
	
	public ReservasUsersView() {
	}
	
	@PostConstruct
	public void init() {
		serviciosReserva=baseBean.getServiciosReserva();
		Subject subject = SecurityUtils.getSubject();
		correo = String.valueOf(subject.getSession().getAttribute("Correo"));
		try {
			Usuario u = serviciosReserva.consultarUsuarioCorreo(correo);
			usuario = u;
			if (u.getCargo().getNombre().equals("Comunidad")){
				reservas = serviciosReserva.consultarReservasUsuario(u.getCarnet());
				activas = serviciosReserva.consultarReservasUsuario(u.getCarnet());
				noActivas = serviciosReserva.consultarReservasUsuarioNoActivas(u.getCarnet());
				canceladas= serviciosReserva.consultarReservasCanceladas(noActivas);
				pasadas= serviciosReserva.consultarReservasPasadas(noActivas);
			}
			else{
				reservas= serviciosReserva.consultarReservas();
			}
		}catch (ServiciosReservaException e) {
			baseBean.mensajeApp(e);
		}
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public List<Reserva> getCanceladas() {
		return this.canceladas;
	}

	public List<Reserva> getPasadas() {
		return this.pasadas;
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
	
	public void cambioCanceladas(){
		this.reservas=this.canceladas;
	}
	
	public void cambioPasadas(){
		this.reservas=this.pasadas;
	}
	
	public void cambioActivas(){
		this.reservas=this.activas;
	}
	
	public Usuario getUsuario(){
		return this.usuario;
	}
	
	
}
	
	