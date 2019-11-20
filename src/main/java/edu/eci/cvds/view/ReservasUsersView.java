package edu.eci.cvds.view;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

@ManagedBean(name = "ReservasUsersBean")
@SessionScoped
public class ReservasUsersView {
	
	private ServiciosReserva serviciosReserva;

	@ManagedProperty(value = "#{ReservaBean}")
	private BasePageBean baseBean;
	
	
	private List<Reserva> reservas;
	
	public ReservasUsersView() {
	}

	
	@PostConstruct
	public void init() {
		serviciosReserva=baseBean.getServiciosReserva();
		try {
			reservas= serviciosReserva.consultarReservas();
		}catch (ServiciosReservaException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Reserva> getReservas(){
		return this.reservas;
	}
	
	public BasePageBean getUsuario() {
		return this.baseBean;
	}
	
	public void setBaseBean(BasePageBean bs){
	    this.baseBean = bs;
	}
}
	
	
	
	