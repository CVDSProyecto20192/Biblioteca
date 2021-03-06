package edu.eci.cvds.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import edu.eci.cvds.exceptions.ServiciosReservaException;
import edu.eci.cvds.samples.entities.Hora;
import edu.eci.cvds.samples.entities.Horario;
import edu.eci.cvds.samples.services.ServiciosReserva;

@SuppressWarnings("deprecation")
@ManagedBean(name = "HorarioBean")
@RequestScoped
public class HorariosView {
	
	private ServiciosReserva serviciosReserva;

	@ManagedProperty(value = "#{ReservaBean}")
	private BasePageBean baseBean;
	
	private long id;
	private String dia;
	private String hora;
	
	private List<Horario> horario;
	private HashMap<Integer, ArrayList<Hora>> total;
	private List<Hora> ls1;
	private List<Hora> ls2;
	private List<Hora> ls3;
	private List<Hora> ls4;
	private List<Hora> ls5;
	private List<Hora> ls6;

	private String[] dias;
	
	public HorariosView() {
	}

	
	@PostConstruct
	public void init() {
		serviciosReserva=baseBean.getServiciosReserva();
		actionSetId();
		acionSetDiasDeLaSemana();
		actionInicializarTotal();
		reinicioListas();
		
	}

	/**
	 * Cambia el valor de la hora
	 * @param idHora Id de la hora que se quiere modificar
	 * @param hora Nuevo valor de la hora
	 */
	public void actualizarHora(long idHora, Date hora) {
		try {
			this.serviciosReserva.cambiarTiempoHora(idHora, hora);
			reinicioListas();
		} catch (ServiciosReservaException e) {
			baseBean.mensajeApp(e);
		}
	}
	
	/**
	 * Cambia el estado de la hora dada
	 * @param id Identificdor de la hora
	 */
	public void actionLiberarHora(long idHora) {
		boolean b;
		try {
			b = this.serviciosReserva.consultarDispHora(idHora);
			this.serviciosReserva.cambiarDispHora(idHora, !b);
		} 
		catch (ServiciosReservaException e) {
			baseBean.mensajeApp(e);
		}
		
	}
	
	/**
	 * Da la disponibilidad de la hora en String
	 * @param id Identificador de la hora
	 * @return
	 */
	public String actionDisponibilidad(long idHora) {
		String ans="Ocupado";
		boolean b;
		try {
			b = this.serviciosReserva.consultarDispHora(idHora);
			if(b) ans="Libre";
		} catch (ServiciosReservaException e) {
			baseBean.mensajeApp(e);
		}
		
		return ans;
	}

	/**
	 * Adiciona una fila
	 * @param i Número del día al que se le quiere adicionar unahora
	 */
	public void actionAddRow(int i) {
		String dia=asignarDiaNumero(i);
		try {
			Horario h=this.serviciosReserva.consultarHorario(this.id, dia);
			Hora hs=new Hora(); 
			this.serviciosReserva.agregarHora(h, hs);
			establecerHora(h, hs);
			reinicioListas();
		} catch (ServiciosReservaException e) {
			baseBean.mensajeApp(e);
			e.printStackTrace();
		}
	}
	
	/**
	 * Elimina una fila de hora
	 * @param i Número que indica el día al que se le quiere eliminar una hora
	 * @param idHora Id de la hora que se quiere eliminar
	 */
	public void actionDeleteRow(int i, long idHora){
		String dia=asignarDiaNumero(i);
		try {
			Horario h=this.serviciosReserva.consultarHorario(this.id, dia);
			this.serviciosReserva.eliminarHora(h,idHora);
			actionSetHorario();
			reinicioListas();
		} catch (ServiciosReservaException e) {
			baseBean.mensajeApp(e);
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Establece los días de la semana
	 */
	private void acionSetDiasDeLaSemana(){
		String[] d= {"domingo","lunes","martes","miércoles","jueves","viernes","sábado"};
		this.dias=d;
	}
	
	
	/**
	 * Iniciliza al hash total
	 */
	private void actionInicializarTotal() {
		this.total=new HashMap<Integer, ArrayList<Hora>>();
		for(int i=1;i<7;i++) {
			ArrayList<Hora> array=new ArrayList<Hora>();
			this.total.put(i, array);
		}
	}
	
	
	/**
	 * Reasigna los valores de las listas en total
	 */
	private void reinicioListas() {
		actionSetHorario();
		actionCreateHash();
	}
	
	
	/**
	 * Establece el horario seleccionado por el usuario (objeto)
	 */
	private void actionSetHorario() {
		try {
			this.horario=serviciosReserva.consultarHorarioDias(this.id);

		} catch (ServiciosReservaException e) {
			baseBean.mensajeApp(e);
		}
	}
	
	
	/**
	 * Relaciona cada horario con su numero para el hashMap
	 */
	private void actionCreateHash() {
		for(Horario h:this.horario) {
			ArrayList<Hora>horas=h.getHoras();
			String dia=h.getDia();
			int posicion=asignarNumeroDia(dia);
			this.total.put(posicion, horas);
			
		}
	}
	
	/**
	 * Relaciona el día dado con un número
	 * @param dia Cadena que inica el día
	 * @return Número asociado al día
	 */
	private int asignarNumeroDia(String dia) {
		int ans=0;
		dia=dia.replace(" ","");
		
		for(int i=0; i<7; i++) {
			String d=this.dias[i];
			
			if(d.equals(dia)) {
				ans=i;
			}
		}
		
		return ans;
		
	}
	
	/**
	 * Establece el día según el número dado
	 * @param num Número de asociación con día
	 * @return Cadena que indica el día de la semana
	 */
	private String asignarDiaNumero(int num) {
		
		return this.dias[num];
	}
	
	
	
	/**
	 * Establece el id del horario seleccionado por el usuario
	 */
	private void actionSetId() {
		this.id=baseBean.getIdRec();
	}
	
	
	/**
	 * Establece el id del horario a la hora dada
	 * @param h Horario 
	 * @param hs Hora
	 */
	private void establecerHora(Horario h, Hora hs) {
		long id_hora;
		try {
			id_hora = this.serviciosReserva.consultarIdHora(h, hs);
			hs.setId(id_hora);
		} 
		catch (ServiciosReservaException e) {
			baseBean.mensajeApp(e);
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
	
	
	public List<Hora> getLs1(){
		this.ls1=this.total.get(1);
		return this.ls1;
	}
	
	public List<Hora> getLs2(){
		this.ls2=this.total.get(2);
		return this.ls2;
	}
	
	public List<Hora> getLs3(){
		this.ls3=this.total.get(3);
		return this.ls3;
	}
	
	public List<Hora> getLs4(){
		this.ls4=this.total.get(4);
		return this.ls4;
	}
	
	public List<Hora> getLs5(){
		this.ls5=this.total.get(5);
		return this.ls5;
	}
	
	
	public List<Hora> getLs6(){
		this.ls6=this.total.get(6);
		return this.ls6;
	}
	
	public BasePageBean getBaseBean() {
		return this.baseBean;
	}
	
	public void setBaseBean(BasePageBean bs){
	    this.baseBean = bs;
	}
	
	
	/*public void actionPrint() {
		System.out.println(this.ls1);
	}*/
	
}
	










