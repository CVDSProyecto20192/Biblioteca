package edu.eci.cvds.view;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import edu.eci.cvds.samples.services.ServiciosReserva;
import edu.eci.cvds.exceptions.ServiciosReservaException;
import edu.eci.cvds.samples.entities.Reserva;

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

    public DisponibilidadView() {
    }

    public long getRecurso() {
        return recurso;
    }

    public void setRecurso(long recurso) {
        this.recurso = recurso;
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
        System.out.println(this.recurso);
        try {
            reservas = serviciosReserva.consultarReservasRecurso(this.recurso);
        } catch (ServiciosReservaException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(reservas.size());

        DefaultScheduleEvent event;

        for (Reserva r:reservas){ 

            Date inicio = getDate(r.getFecha(), r.getHora());
            Date fin = getDate(r.getFecha(), r.getHora()+r.getDuracion());

            event = new DefaultScheduleEvent("Reservado", inicio, fin);

            this.eventModel.addEvent(event);

        }
    }

    private Date getDate(Date date, int hora) {
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, (int)hora/100);
        calendar.set(Calendar.MINUTE,hora%100);
		
		return calendar.getTime();
    }
    
    private Calendar today() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);

		return calendar;
    }
    
    private Date previousDay11Pm() {
		Calendar t = (Calendar) today().clone();
		t.set(Calendar.AM_PM, Calendar.PM);
		t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
		t.set(Calendar.HOUR, 11);
		
		return t.getTime();
    }
    
    public void onEventSelect(SelectEvent selectEvent){
        event = (ScheduleEvent) selectEvent.getObject();
    }

    public void onDateSelect(SelectEvent selectEvent){
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
    }

    public void onEventMove(ScheduleEntryMoveEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
		
		addMessage(message);
	}

    public void onEventResize(ScheduleEntryResizeEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
		
		addMessage(message);
    }
    
    private void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
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

}