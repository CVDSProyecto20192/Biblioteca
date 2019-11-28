package edu.eci.cvds.view;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.ScheduleEvent;

import edu.eci.cvds.exceptions.ServiciosReservaException;
import edu.eci.cvds.samples.entities.Reserva;
import edu.eci.cvds.samples.services.ServiciosReserva;
import java.text.DateFormat; 
import java.text.SimpleDateFormat;  

@Deprecated
@ManagedBean(name = "DispoBean")
@SessionScoped

public class DisponibilidadView implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private ServiciosReserva serviciosReserva;

    @ManagedProperty(value = "#{ReservaBean}")
    private BasePageBean baseBean;

    private ScheduleModel eventModel;
    private ScheduleEvent event = new DefaultScheduleEvent();
    private long recurso;
    private List<Reserva> reservas;
	private String fecha;
	private int hora;
	private int minutos;
	private int duracionHora;
	private int duracionMinutos;
	private int repetir;
	private Date fechaFin;
	private int eventoHora;
    public DisponibilidadView() {
    }
	
	public Date getFechaFin(){
		return fechaFin;
	}
	
	public int getHora(){
		return hora;
	}
	public int getEventoHora(){
		return eventoHora;
	}
	
	public int getMinutos(){
		return minutos;
	}
	
	public void setFechaFin (Date fechaFin){
		this.fechaFin = fechaFin;
	}
	
	public int getRepetir(){
		return repetir;
	}
	
	public void setRepetir(int repetir){
		this.repetir = repetir;
	}
	
    public long getRecurso() {
        return recurso;
    }

    public void setRecurso(long recurso) {
        this.recurso = recurso;
    }
	
	public int getDuracionHora(){
		return duracionHora;
	}
	
	public int getDuracionMinutos(){
		return duracionMinutos;
	}
	
	public void setDuracionHora(int duracionHora){
		this.duracionHora = duracionHora;
	}
	
	public void setDuracionMinutos(int duracionMinutos){
		this.duracionMinutos = duracionMinutos;
	}

	public void setHora(int hora){
		this.hora = hora;
		System.out.println("set");
		System.out.println(hora);
	}
	
	public void setMinutos(int minutos){
		this.minutos = minutos;
	}

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @PostConstruct
    public void init() {
        serviciosReserva = baseBean.getServiciosReserva();

        eventModel = new DefaultScheduleModel();
    }

    public void actionVerDisponibilidad() {
		this.eventModel.clear();
		if (reservas != null){
			this.reservas.clear();
		}
        try {
            reservas = serviciosReserva.consultarReservasRecurso(this.recurso);
        } catch (ServiciosReservaException e) {
            // TODO Auto-generated catch block
            baseBean.mensajeApp(e);
        }

        DefaultScheduleEvent event;

        for (Reserva r:reservas){ 

            Date t = (Date) r.getFecha().clone();
            t.setHours((int)r.getHora()/100);
            t.setMinutes(r.getHora()%100);

            Date y = (Date) r.getFecha().clone();
            y.setHours((int)(r.getHora()+r.getDuracion())/100);
            y.setMinutes((r.getHora()+r.getDuracion())%100);

            event = new DefaultScheduleEvent("Resevado",t,y);

            this.eventModel.addEvent(event);

        }
    }
	
	public void actionReservar(){
		int dur = (duracionHora * 100) + duracionMinutos;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try{
			if (fechaFin != null){
				String fechaFinReservas = dateFormat.format(fechaFin);
				serviciosReserva.insertarReservaDias(fecha, hora, dur, "0000001" , recurso, fechaFinReservas , repetir);
			}
			else{
				System.out.println(fecha);
				System.out.println(hora);
				System.out.println(recurso);
				serviciosReserva.insertarReserva(fecha, hora, dur, "0000001", recurso);
			}
		}catch (ServiciosReservaException e) {
            // TODO Auto-generated catch block
            baseBean.mensajeApp(e);
        } 
	}

    public void reset(){
        this.eventModel.clear();
		this.reservas.clear();
    }
        
    public BasePageBean getBaseBean() {
        return baseBean;
    }

    public ScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

    public ServiciosReserva getServiciosReserva() {
        return serviciosReserva;
    }

    public void setServiciosReserva(ServiciosReserva serviciosReserva) {
        this.serviciosReserva = serviciosReserva;
    }

    public void setBaseBean(BasePageBean baseBean) {
        this.baseBean = baseBean;
    }
	
	public void onEventSelected(SelectEvent selectEvent){
		event = (ScheduleEvent) selectEvent.getObject();
	}
	
	public void onDateSelected(SelectEvent selectEvent){
		event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		fecha = dateFormat.format(event.getStartDate());
		this.hora = (event.getStartDate().getHours() * 100) + (event.getStartDate().getMinutes());
	}
}