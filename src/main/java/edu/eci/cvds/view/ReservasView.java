package edu.eci.cvds.view;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.exceptions.ServiciosReservaException;
import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.services.ServiciosReserva;

@Deprecated
@ManagedBean(name = "VisualBean")
@SessionScoped

public class ReservasView implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private ServiciosReserva serviciosReserva;

    @ManagedProperty(value = "#{ReservaBean}")
    private BasePageBean baseBean;

    private Date fecha;
    private String show;
    private boolean dia, semana, mes;

    public ReservasView() {

    }

    @PostConstruct
    public void init() {
        serviciosReserva=baseBean.getServiciosReserva();
        this.dia = false;
        this.semana = false;
        this.mes = false;
    }

    public void enable(){

        switch(this.show){
            case "Día": this.dia = true;
                break;
            case "Semana" : this.semana = true;
                break;
            case "mes" : this.mes = true;
                break;
        }
    }

    public void setAllFalse(){

        this.dia = false;
        this.semana = false;
        this.mes = false;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public ServiciosReserva getServiciosReserva() {
        return serviciosReserva;
    }

    public void setServiciosReserva(ServiciosReserva serviciosReserva) {
        this.serviciosReserva = serviciosReserva;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(final Date fecha) {
        this.fecha = fecha;
    }

    public BasePageBean getBaseBean() {
        return baseBean;
    }

    public void setBaseBean(final BasePageBean baseBean) {
        this.baseBean = baseBean;
    }

    public boolean isMes() {
        return mes;
    }

    public void setMes(boolean mes) {
        this.mes = mes;
    }

    public boolean isSemana() {
        return semana;
    }

    public void setSemana(boolean semana) {
        this.semana = semana;
    }

    public boolean isDia() {
        return dia;
    }

    public void setDia(boolean dia) {
        this.dia = dia;
    }

}