package edu.eci.cvds.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import edu.eci.cvds.exceptions.ServiciosReservaException;
import edu.eci.cvds.samples.entities.Reserva;
import edu.eci.cvds.samples.services.ServiciosReserva;

@Deprecated
@ManagedBean(name = "ReportBean")
@SessionScoped
public class ReporteView {

    private ServiciosReserva serviciosReserva;

    @ManagedProperty(value = "#{ReservaBean}")
    private BasePageBean basePageBean;

    private String show;
    private boolean masUsados, menosUsados, horariosMas, horariosMenos, recurrentes;

    public ReporteView() {

    }


    @PostConstruct
    public void init() {
        serviciosReserva = basePageBean.getServiciosReserva();
        reboot();
    }

    public List<Reserva> getRecursosFrecuentes() {
        List<Reserva> recursosFrecuentes = null;
        try {
            recursosFrecuentes = serviciosReserva.recursosFrecuentes();
        } catch (ServiciosReservaException e) {
            e.printStackTrace();
        }
        return recursosFrecuentes;
    }

    public List<Reserva> getRecursosFrecuentesXHorario(){
        List<Reserva> recursosFrecuentesXHorario = null;
        try {
            recursosFrecuentesXHorario = serviciosReserva.recursosFrecuentesXHorario();
        } catch (ServiciosReservaException e) {
            e.printStackTrace();
        }
        return recursosFrecuentesXHorario;
    }

    public List<Reserva> getFrecuenteXHorario(){
        List<Reserva> frecuenteXHorario = null;
        try {
            frecuenteXHorario = serviciosReserva.frecuenteXHorario();
        } catch (ServiciosReservaException e) {
            e.printStackTrace();
        }
        return frecuenteXHorario;
    }

    public List<Reserva> getFrecuenteXTipo(){
        List<Reserva> frecuenteXTipo = null;

        try {
            frecuenteXTipo = serviciosReserva.frecuenteXTipo();
        } catch (ServiciosReservaException e) {
            e.printStackTrace();
        }
        return frecuenteXTipo;
    }

    public List<Reserva> getMasFrecuenteXHorario(){
        List<Reserva> masFrecuenteXHorario = null;
        try {
            masFrecuenteXHorario = serviciosReserva.masFrecuenteXHorario();
        } catch (ServiciosReservaException e) {
            e.printStackTrace();
        }
        return masFrecuenteXHorario;
    }

    public List<Reserva> getRecursosMasFrecuentes(){
        List<Reserva> recursosMasFrecuentes =null;
        try {
            recursosMasFrecuentes = serviciosReserva.recursosMasFrecuentes();
        } catch (ServiciosReservaException e) {
            e.printStackTrace();
        }
        return recursosMasFrecuentes;
    }

    public List<Reserva> getMenosFrecuentesXFecha(){
        List<Reserva> menosFrecuentesXFecha =null;
        try {
            menosFrecuentesXFecha = serviciosReserva.menosFrecuentesXFecha();
        } catch (ServiciosReservaException e) {
            e.printStackTrace();
        }
        return menosFrecuentesXFecha;
    }

    public List<Reserva> getRecursosMenosFrecuentesXHorario(){
        List<Reserva> recursosMenosFrecuentesXHorario =null;
        try {
            recursosMenosFrecuentesXHorario = serviciosReserva.recursosMenosFrecuentesXHorario();
        } catch (ServiciosReservaException e) {
            e.printStackTrace();
        }
        return recursosMenosFrecuentesXHorario;
    }

    public List<Reserva> getMenosFrecuenteXTipo(){
        List<Reserva> menosFrecuenteXTipo =null;
        try {
            menosFrecuenteXTipo = serviciosReserva.menosFrecuenteXTipo();
        } catch (ServiciosReservaException e) {
            e.printStackTrace();
        }
        return menosFrecuenteXTipo;
    }

    public List<Reserva> getHorariosMasXFecha(){
        List<Reserva> horariosMasXFecha =null;
        try {
            horariosMasXFecha = serviciosReserva.horariosMasXFecha();
        } catch (ServiciosReservaException e) {
            e.printStackTrace();
        }
        return horariosMasXFecha;
    }

    public List<Reserva> getHorarioMasFrecuente(){
        List<Reserva> horarioMasFrecuente =null;
        try {
            horarioMasFrecuente = serviciosReserva.horarioMasFrecuente();
        } catch (ServiciosReservaException e) {
            e.printStackTrace();
        }
        return horarioMasFrecuente;
    }

    public List<Reserva> getHorariosMasXTipo(){
        List<Reserva> horariosMasXTipo =null;
        try {
            horariosMasXTipo = serviciosReserva.horariosMasXTipo();
        } catch (ServiciosReservaException e) {
            e.printStackTrace();
        }
        return horariosMasXTipo;
    }

    public List<Reserva> getHorarioMenosFrecuente(){
        List<Reserva> horarioMenosFrecuente =null;
        try {
            horarioMenosFrecuente = serviciosReserva.horarioMenosFrecuente();
        } catch (ServiciosReservaException e) {
            e.printStackTrace();
        }
        return horarioMenosFrecuente;
    }

    public List<Reserva> getHorariosMenosXFecha(){
        List<Reserva> horariosMenosXFecha =null;
        try {
            horariosMenosXFecha = serviciosReserva.horariosMenosXFecha();
        } catch (ServiciosReservaException e) {
            e.printStackTrace();
        }
        return horariosMenosXFecha;
    }

    public List<Reserva> getHorariosMenosXTipo(){
        List<Reserva> horariosMenosXTipo =null;
        try {
            horariosMenosXTipo = serviciosReserva.horariosMenosXTipo();
        } catch (ServiciosReservaException e) {
            e.printStackTrace();
        }
        return horariosMenosXTipo;
    }

    public void showTable(){

        reboot();

        switch(show){
            case "masUsados":
                this.masUsados=true;
                break;
            case "menosUsados":
                this.menosUsados=true;
                break;
            case "horariosMas":
                this.horariosMas=true;
                break;
            case "horariosMenos":
                this.horariosMenos=true;
                break;
            case "recurrentes":
                this.recurrentes=true;
                break;
        }
    }

    private void reboot() {
        this.masUsados=false;
        this.menosUsados=false;
        this.horariosMas=false;
        this.horariosMenos=false;
        this.recurrentes=false;
    }

    //Gets and Sets

    public ServiciosReserva getServiciosReserva() {
        return serviciosReserva;
    }

    public BasePageBean getBasePageBean() {
        return basePageBean;
    }

    public void setBasePageBean(BasePageBean basePageBean) {
        this.basePageBean = basePageBean;
    }

    public void setServiciosReserva(ServiciosReserva serviciosReserva) {
        this.serviciosReserva = serviciosReserva;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public boolean isRecurrentes() {
        return recurrentes;
    }

    public void setRecurrentes(boolean recurrentes) {
        this.recurrentes = recurrentes;
    }

    public boolean isHorariosMenos() {
        return horariosMenos;
    }

    public void setHorariosMenos(boolean horariosMenos) {
        this.horariosMenos = horariosMenos;
    }

    public boolean isHorariosMas() {
        return horariosMas;
    }

    public void setHorariosMas(boolean horariosMas) {
        this.horariosMas = horariosMas;
    }

    public boolean isMenosUsados() {
        return menosUsados;
    }

    public void setMenosUsados(boolean menosUsados) {
        this.menosUsados = menosUsados;
    }

    public boolean isMasUsados() {
        return masUsados;
    }

    public void setMasUsados(boolean masUsados) {
        this.masUsados = masUsados;
    }

}