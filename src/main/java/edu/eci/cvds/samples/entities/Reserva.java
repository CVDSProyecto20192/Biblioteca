package edu.eci.cvds.samples.entities;

import java.util.Date;

public class Reserva {

	private long codigo;
	private Date fechaReserva;
	private Date horaReserva;
	private Date fechaEntrega;
	private Date horaEntrega;
	private String carnetUsuario;
	
	public Reserva() {
		
	}
	
	public Reserva(long codigo, Date fechaReserva, Date horaReserva, Date fechaEntrega, 
			Date horaEntrega, String carnetUsuario){
		
		 this.codigo=codigo;
		 this.fechaReserva=fechaReserva;
		 this.horaReserva=horaReserva;
		 this.fechaEntrega=fechaEntrega;
		 this.horaEntrega=horaEntrega;
		 this.carnetUsuario=carnetUsuario;
	}
	
	public long getCodigo(){
		return this.codigo;
	}
	
	public void setCodigo(long codigo){
		this.codigo=codigo;
	}
	
	
	public Date getFechaReserva(){
		return this.fechaReserva;
	}
	
	public void setFechaReserva(Date fechaReserva){
		this.fechaReserva=fechaReserva;
	}
	
	public Date getHoraReserva(){
		return this.horaReserva;
	}
	
	public void setHoraReserva(Date horaReserva){
		this.horaReserva=horaReserva;
	}
	
	public Date getFechaEntrega(){
		return this.fechaEntrega;
	}
	
	public void setFechaEntrega(Date fechaEntrega){
		this.fechaEntrega=fechaEntrega;
	}
	
	public Date getHoraEntrega(){
		return this.horaEntrega;
	}
	
	public void setHoraEntrega(Date horaEntrega){
		this.horaEntrega=horaEntrega;
	}
	
	
	public String getCarnetUsuario(){
		return this.carnetUsuario;
	}
	
	public void setCarnetUsuario(String carnet){
		this.carnetUsuario=carnet;
	}

	
}
