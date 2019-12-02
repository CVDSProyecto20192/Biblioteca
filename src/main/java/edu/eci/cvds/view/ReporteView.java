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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return recursosFrecuentes;
    }

    public List<Reserva> getFrecuenteXHorario(){
        List<Reserva> frecuenteXHorario = null;
        try {
            frecuenteXHorario = serviciosReserva.frecuenteXHorario();
        } catch (ServiciosReservaException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return frecuenteXHorario;
    }

    public List<Reserva> getMasFrecuenteXHorario(){
        List<Reserva> masFrecuenteXHorario = null;
        try {
            masFrecuenteXHorario = serviciosReserva.masFrecuenteXHorario();
        } catch (ServiciosReservaException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return masFrecuenteXHorario;
    }

    public List<Reserva> getRecursosMasFrecuentes(){
        List<Reserva> recursosMasFrecuentes =null;
        try {
            recursosMasFrecuentes = serviciosReserva.recursosMasFrecuentes();
        } catch (ServiciosReservaException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return recursosMasFrecuentes;
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