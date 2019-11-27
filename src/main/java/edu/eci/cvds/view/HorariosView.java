package edu.eci.cvds.view;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import edu.eci.cvds.exceptions.ServiciosReservaException;
import edu.eci.cvds.samples.entities.Hora;
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
	private List<HashMap<String, ArrayList<Hora>>> total;
	private List<Hora> ls1;
	private List<Hora> ls2;
	private List<Hora> ls3;
	private List<Hora> ls4;
	private List<Hora> ls5;
	private List<Hora> ls6;

	
	
	public HorariosView() {
	}

	
	@PostConstruct
	public void init() {
		serviciosReserva=baseBean.getServiciosReserva();
		actionSetId();
		reinicioListas();
		
	}

	
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

	
	public void actionAddRow(int i) {
		ArrayList<String> keys=getKeysTotal(i);
		String dia=asignarDiaNUmero(i);
		System.out.println(dia);
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
	
	
	public void actionDeleteRow(int i, long idHora){
		ArrayList<String> keys=getKeysTotal(i);
		String dia=keys.get(0);
		try {
			Horario h=this.serviciosReserva.consultarHorario(this.id, dia);
			this.serviciosReserva.eliminarHora(h,idHora);
			reinicioListas();
		} catch (ServiciosReservaException e) {
			baseBean.mensajeApp(e);
			e.printStackTrace();
		}
		
	}
	
	
	private void reinicioListas() {
		actionSetHorario();
		actionCreateHash();
	}
	
	private int asignarNumeroDia(String dia) {
		int ans=0;
		String [] dias= {"lunes", "martes", "miércoles", "jueves", "viernes", "sábado"};
		
		String [] otros=this.baseBean.diasDeLaSemana();
		
		for(int i=0; i<6; i++) {
			String d=dias[i];
			if(d==dia) {
				ans=i;
			}
		}
		
		System.out.println("Asignar");
		String l=new String("lunes");
		dia=new String(dia);
		System.out.println(dia.contentEquals(l));
		System.out.println(dia.equals(l));
		System.out.println(dia.equals("lunes"));
		System.out.println(dia);
		System.out.println(Objects.equals(dia, l));
		if(dia.contentEquals("lunes")) {
			System.out.println(true);
		}
		
		for(String i:otros) {
			if(i.equals(dia)) {
				System.out.println("siiii");
			}
		}
		return ans;
		
	}
	
	
	private String asignarDiaNUmero(int num) {
		
		String ans="";
		switch(num) {
		
		case 0:
			ans="lunes";
			break;
			
		case 1:
			ans="martes";
			break;
			
		case 3:
			ans="miércoles";
			break;
			
		case 4:
			ans="jueves";
			break;
			
		case 5:
			ans="viernes";
			break;
			
		case 6:
			ans="sábado";
			break;
		}
		
		return ans;
	}
	
	
	/**
	 * Inicializa los HashMaps
	 * @param array
	 * @param h
	 */
	private int actionCreateMaps(HashMap<String, ArrayList<Hora>> array, Horario h) {
		ArrayList<Hora>horas=h.getHoras();
		String dia=h.getDia();
		System.out.println(dia);
		System.out.println(horas);
		System.out.println(asignarNumeroDia(dia));
		array.put(dia,horas);
		
		return asignarNumeroDia(dia);
	}
	
	/**
	 * Relaciona cada horario con su respectivo hashMap
	 */
	private void actionCreateHash() {
		total=new ArrayList<HashMap<String, ArrayList<Hora>>>();
		for(Horario h:this.horario) {
			HashMap<String, ArrayList<Hora>> array=new HashMap<String, ArrayList<Hora>>();
			int posicion=actionCreateMaps(array,h);
			this.total.add(posicion, array);
			//thi
		}
	}
	
	
	/**
	 * Establece el id del horario seleccionado por el usuario
	 */
	private void actionSetId() {
		this.id=baseBean.getIdRec();
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
	
	
	/**
	 * Separara las listas que se encuentran en el hashmap
	 * @param i
	 * @return
	 */
	private ArrayList<Hora> getArrayFromTotal(int i) {
		ArrayList<Hora> horas=null;
		try {
			HashMap<String, ArrayList<Hora>> array=this.total.get(i);
			Collection<ArrayList<Hora>> horasList=array.values();
			
			Iterator<ArrayList<Hora>> it = horasList.iterator();
			
			while(it.hasNext()) {
				horas=it.next();
			}
		}
		catch(Exception e) {
			baseBean.mensajeApp(e);
		}
		return horas;
		
	}
	
	private ArrayList<String> getKeysTotal(int i){
		ArrayList<String> ans=new ArrayList<String>();
		HashMap<String, ArrayList<Hora>> hash=this.total.get(i);
		Set<String> keys=hash.keySet();
		ans.addAll(keys);
		return ans;
	}
	
	private void establecerHora(Horario h, Hora hs) {
		long id_hora;
		try {
			id_hora = this.serviciosReserva.consultarIdHora(h, hs);
			hs.setId(id_hora);
		} 
		catch (ServiciosReservaException e) {
			// TODO Auto-generated catch block
			baseBean.mensajeApp(e);
		}
		
	}
	
	public List<Hora> getLs1(){
		this.ls1=new ArrayList<Hora>();
		this.ls1=getArrayFromTotal(0);
		return this.ls1;
	}
	
	public List<Hora> getLs2(){
		this.ls2=getArrayFromTotal(1);
		return this.ls2;
	}
	
	public List<Hora> getLs3(){
		this.ls3=getArrayFromTotal(2);
		return this.ls3;
	}
	
	public List<Hora> getLs4(){
		this.ls4=getArrayFromTotal(3);
		return this.ls4;
	}
	
	public List<Hora> getLs5(){
		this.ls5=getArrayFromTotal(4);
		return this.ls5;
	}
	
	
	public List<Hora> getLs6(){
		this.ls6=getArrayFromTotal(5);
		return this.ls6;
	}
	
	public BasePageBean getUsuario() {
		return this.baseBean;
	}
	
	public void setBaseBean(BasePageBean bs){
	    this.baseBean = bs;
	}
	
	
	public void actionPrint() {
		System.out.println(this.ls1);
	}
	
	
}
	










