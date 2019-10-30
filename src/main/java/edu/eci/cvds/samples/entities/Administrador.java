package edu.eci.cvds.samples.entities;

public class Administrador {
	private String carnet;
	
	public Administrador(){
		
	}
	
	public Administrador(String carnet){
		this.carnet=carnet;
	}

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}
}