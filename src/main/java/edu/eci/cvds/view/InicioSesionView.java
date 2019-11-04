package edu.eci.cvds.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import edu.eci.cvds.samples.services.ServiciosReserva;

@ManagedBean(name = "InicioSesionBean")
@RequestScoped
public class InicioSesionView {
	
	private ServiciosReserva serviciosReserva;

	@ManagedProperty(value = "#{ReservaBean}")
	private BasePageBean baseBean;
	
	private String correo;
	private String password;
	
	public InicioSesionView() {
	}

	@PostConstruct
	public void init() {
		serviciosReserva=baseBean.getServiciosReserva();

	}
	
	public String getCorreo() {
		return this.correo;
	}
	
	public void setCorreo(String correo) {
		this.correo=correo;
		
	}
	
	public String getPassword() {
		return this.password;
		
	}
	
	public void setPassword(String pass) {
		this.password=pass;
	}

	public BasePageBean getUsuario() {
		return this.baseBean;
	}
	
	public void setBaseBean(BasePageBean bs){
	    this.baseBean = bs;
	}
}
