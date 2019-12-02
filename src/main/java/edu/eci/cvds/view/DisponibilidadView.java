package edu.eci.cvds.view;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import edu.eci.cvds.exceptions.ServiciosReservaException;
import edu.eci.cvds.samples.entities.Reserva;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.ServiciosReserva;

@Deprecated
@ManagedBean(name = "DispoBean")
@ViewScoped

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
	private Reserva selected;
	private boolean horaManual;

	public DisponibilidadView() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String r = request.getParameter("recurso");
		this.recurso = Long.parseLong(r);
	}

	@PostConstruct
	public void init() {
		serviciosReserva = baseBean.getServiciosReserva();

		eventModel = new DefaultScheduleModel();
		
		actionVerDisponibilidad();
	}

	public void actionVerDisponibilidad() {
		this.eventModel.clear();
		if (reservas != null) {
			this.reservas.clear();
		}
		try {
			reservas = serviciosReserva.consultarReservasRecurso(this.recurso);
		} catch (ServiciosReservaException e) {
			// TODO Auto-generated catch block
			baseBean.mensajeApp(e);
		}

		DefaultScheduleEvent event;

		for (Reserva r : reservas) {
			
			if (r.getActiva()){

				Date t = (Date) r.getFecha().clone();
				t.setHours((int) r.getHora() / 100);
				t.setMinutes(r.getHora() % 100);

				Date y = (Date) r.getFecha().clone();
				y.setHours((int) (r.getHora() + r.getDuracion()) / 100);
				y.setMinutes((r.getHora() + r.getDuracion()) % 100);

				event = new DefaultScheduleEvent("Resevado", t, y);
				String code = Long.toString(r.getCodigo());
				event.setDescription(code);
				this.eventModel.addEvent(event);
			}

		}
	}

	public void actionReservar() {
		int dur = (duracionHora * 100) + duracionMinutos;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (horaManual){
			hora = (hora * 100) + minutos;
		}
		try {
			if (fechaFin != null) {
				String fechaFinReservas = dateFormat.format(fechaFin);
				serviciosReserva.insertarReservaDias(fecha, hora, dur, "0000001", recurso, fechaFinReservas, repetir);
			} else {
				System.out.println(hora);
				serviciosReserva.insertarReserva(fecha, hora, dur, "0000001", recurso);
			}
			actionVerDisponibilidad();
		} catch (ServiciosReservaException e) {
			// TODO Auto-generated catch block
			baseBean.mensajeApp(e);
		}
	}

	public void reset() {
		this.eventModel.clear();
		this.reservas.clear();
	}

	public void onEventSelected(SelectEvent selectEvent) {
		event = (ScheduleEvent) selectEvent.getObject();
		Long codigo = Long.parseLong(event.getDescription());
		try {
			setSelected(serviciosReserva.consultarReserva(codigo));
		} catch (ServiciosReservaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onDateSelected(SelectEvent selectEvent){
		fechaFin = null;
		minutos = 0;
		repetir = 0;
		duracionHora = 0;
		duracionMinutos = 0;
		horaManual = false;
		event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		fecha = dateFormat.format(event.getStartDate());
		this.hora = (event.getStartDate().getHours() * 100) + (event.getStartDate().getMinutes());
		if (hora == 0){
			horaManual = true;
		}
	}

	public Reserva getSelected() {
		return selected;
	}

	public void setSelected(Reserva selected) {
		this.selected = selected;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public int getHora() {
		return hora;
	}

	public int getEventoHora() {
		return eventoHora;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getRepetir() {
		return repetir;
	}

	public void setRepetir(int repetir) {
		this.repetir = repetir;
	}
	
	public int getDuracionHora() {
		return duracionHora;
	}

	public int getDuracionMinutos() {
		return duracionMinutos;
	}

	public void setDuracionHora(int duracionHora) {
		this.duracionHora = duracionHora;
	}

	public void setDuracionMinutos(int duracionMinutos) {
		this.duracionMinutos = duracionMinutos;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
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

	public void setRecurso(long recurso){
		this.recurso = recurso;
	}

	public long getRecurso(){
		return this.recurso;
	}
	
	public String getCommunity(){
		String s = null;
		try{
			Usuario u = serviciosReserva.consultarUsuarioCorreo(baseBean.getUsuario());
			s = u.getCarnet();
		} catch (ServiciosReservaException e) {
			// TODO Auto-generated catch block
			baseBean.mensajeApp(e);
		}
		return s;
	}
	
	
	
}