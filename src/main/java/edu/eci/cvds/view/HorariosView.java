package edu.eci.cvds.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import edu.eci.cvds.exceptions.ServiciosReservaException;
import edu.eci.cvds.samples.entities.Horario;
import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.entities.Tipo;
import edu.eci.cvds.samples.services.ServiciosReserva;

@ManagedBean(name = "HorarioBean")
@SessionScoped
public class HorariosView {
	
	private ServiciosReserva serviciosReserva;

	@ManagedProperty(value = "#{ReservaBean}")
	private BasePageBean baseBean;
	
	private long id;
	private String dia;
	private String hora;
	private List<Horario> horario;
	

	public HorariosView() {
	}

	
	@PostConstruct
	public void init() {
		serviciosReserva=baseBean.getServiciosRecurso();
		actionSetId();
		actionSetHorario();
		
	}
	
	
	private void actionSetId() {
		this.id=baseBean.getIdRec();
	}
	
	
	private void actionSetHorario() {
		try {
			this.horario=serviciosReserva.consultarHorarioDias(this.id);
			System.out.println("tAMAÑO");

			System.out.println(this.horario.size());
			System.out.println(horario);
		} catch (ServiciosReservaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void actionConvertHoras() {
		SimpleDateFormat format =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    	
        String dateInString=this.dia+" "+this.hora; Date date = null;
    	try {
			date = format.parse(dateInString);
			System.out.println(date); 
			List<Date> horas=new ArrayList<Date>();
	        horas.add(date);
	       // serviciosReserva.actualizarHoras(2, horas);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id=id;
	}
	
	public String getDia() {
		return this.dia;
	}
	
	public void setDia(String dia) {
		this.dia=dia;
	}
	
	public String getHora() {
		return this.hora;
	}
	
	public void setHora(String h) {
		this.hora=h;
	}
	
	
	public List<Horario> gethorario() {
		return this.horario;
	}
	
	public void sethorario(List<Horario> horario) {
		this.horario=horario;
	}
	
	
	public BasePageBean getUsuario() {
		return this.baseBean;
	}
	
	public void setBaseBean(BasePageBean bs){
	    this.baseBean = bs;
	}
}
	