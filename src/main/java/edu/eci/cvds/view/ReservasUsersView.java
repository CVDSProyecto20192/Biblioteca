package edu.eci.cvds.view;

import java.util.Date;
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
	
	private Reserva selected;
	
	private String siguiente;
	
	private String ultima;
	
	public ReservasUsersView() {
	}
	
	@PostConstruct
	public void init() {
		serviciosReserva=baseBean.getServiciosReserva();
		try {
			reservas= serviciosReserva.consultarReservas();
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
		calcularUltima();
		return this.ultima;
	}

	
	public String getSiguiente() {
		calcularSiguiente();
		return this.siguiente;
	}
	
	private void calcularSiguiente(){
		Reserva resSig=null;
		try {
			List<Reserva> grupito= serviciosReserva.consultarReservasGrupo(selected.getGrupo());
			boolean flag = false;
			Reserva r = null;
			for(int i=0;i<grupito.size();i++){
				r=grupito.get(i);
				if(flag==true){
					flag=false;
					resSig=r;
				}
				if(r.getCodigo()==selected.getCodigo()){
					flag=true;
				}	
			}
			if(resSig!=null){
				Date fecha1 = resSig.getFechaI();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				siguiente = sdf.format(fecha1);
			}else{
				siguiente = "Esta es la última.";
			}
			
		}catch (ServiciosReservaException e) {
			baseBean.mensajeApp(e);
		}
	}
	
	private void calcularUltima(){
		try {
			List<Reserva> grupito = serviciosReserva.consultarReservasGrupo(selected.getGrupo());
			Reserva ult=grupito.get(grupito.size()-1);
			if(ult.getCodigo()!=selected.getCodigo()){
				Date fecha1 = ult.getFechaI();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				ultima = sdf.format(fecha1);
			}else{
				ultima = "Esta es la última";
			}
		}catch (ServiciosReservaException e) {
			baseBean.mensajeApp(e);
		}
	}
	
	
}
	
	