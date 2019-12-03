package edu.eci.cvds.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

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
    private BarChartModel moreUsed, lessUsed, menosHorario, masHorario;

    public ReporteView() {

    }

    public BarChartModel getMasHorario() {
        return masHorario;
    }

    public void setMasHorario(BarChartModel masHorario) {
        this.masHorario = masHorario;
    }

    public BarChartModel getMenosHorario() {
        return menosHorario;
    }

    public void setMenosHorario(BarChartModel menosHorario) {
        this.menosHorario = menosHorario;
    }

    @PostConstruct
    public void init() {
        serviciosReserva = basePageBean.getServiciosReserva();
        moreUsed = new BarChartModel();
        lessUsed = new BarChartModel();
        menosHorario = new BarChartModel();
        masHorario = new BarChartModel();
        graficarMasUsados();
        graficarMenosUsados();
        graficarHorariosMayor();
        graficarHorariosMenor();
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

    private List<Reserva> graficoMasUsados(){
        List<Reserva> graficoMasUsados=null;
        try {
            graficoMasUsados = serviciosReserva.graficoMasUsados();
        } catch (ServiciosReservaException e) {
            e.printStackTrace();
        }
        return graficoMasUsados;
    } 

    private void graficarMasUsados(){
        moreUsed.clear();
        ChartSeries chart = new ChartSeries();

        List<Reserva> reservas = graficoMasUsados();

        for(Reserva r:reservas){
            chart.set(r.getRecurso().getNombre(), r.getCount());
        }
        this.moreUsed.addSeries(chart);
        this.moreUsed.setTitle("Recursos mas usados en total");
        this.moreUsed.setLegendPosition("ne");
        Axis xAxis = this.moreUsed.getAxis(AxisType.X);
        xAxis.setLabel("Recursos");
        Axis yAxis = this.moreUsed.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad reservada");
        yAxis.setMin(0);
        yAxis.setMax(40);
    }

    private void graficarMenosUsados() {
        lessUsed.clear();
        ChartSeries chart = new ChartSeries();

        List<Reserva> graficarMenosUsados = null;

        try {
            graficarMenosUsados = serviciosReserva.graficarMenosUsados();
        } catch (ServiciosReservaException e) {
            e.printStackTrace();
        }

        for(Reserva r:graficarMenosUsados){
            chart.set(r.getRecurso().getNombre(), r.getCount());
        }
        this.lessUsed.addSeries(chart);
        this.lessUsed.setTitle("Recursos menos usados en total");
        this.lessUsed.setLegendPosition("ne");
        Axis xAxis = this.lessUsed.getAxis(AxisType.X);
        xAxis.setLabel("Recursos");
        Axis yAxis = this.lessUsed.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad reservada");
        yAxis.setMin(0);
        yAxis.setMax(40);
    }

    private void graficarHorariosMayor(){
        masHorario.clear();
        ChartSeries chart = new ChartSeries();

        List<Reserva> reservas =  getHorarioMasFrecuente();

        for(Reserva r:reservas){
            chart.set(r.getHora(), r.getCount());
        }
        this.masHorario.addSeries(chart);
        this.masHorario.setTitle("Recursos totales usados por horario");
        this.masHorario.setLegendPosition("ne");
        Axis xAxis = this.masHorario.getAxis(AxisType.X);
        xAxis.setLabel("Horario");
        Axis yAxis = this.masHorario.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad reservada");
        yAxis.setMin(0);
        yAxis.setMax(40);
    }

    private void graficarHorariosMenor(){
        menosHorario.clear();
        ChartSeries chart = new ChartSeries();

        List<Reserva> reservas =  getHorarioMenosFrecuente();

        for(Reserva r:reservas){
            chart.set(r.getHora(), r.getCount());
        }
        this.menosHorario.addSeries(chart);
        this.menosHorario.setTitle("Recursos totales usados por horario");
        this.menosHorario.setLegendPosition("ne");
        Axis xAxis = this.menosHorario.getAxis(AxisType.X);
        xAxis.setLabel("Horario");
        Axis yAxis = this.menosHorario.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad reservada");
        yAxis.setMin(0);
        yAxis.setMax(40);
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

    public BarChartModel getLessUsed() {
        return lessUsed;
    }

    public void setLessUsed(BarChartModel lessUsed) {
        this.lessUsed = lessUsed;
    }

    public BarChartModel getMoreUsed() {
        return moreUsed;
    }

    public void setMoreUsed(BarChartModel moreUsed) {
        this.moreUsed = moreUsed;
    }

}