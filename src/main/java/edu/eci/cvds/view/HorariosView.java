package edu.eci.cvds.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
		actionSetHorario();
		actionCreateHash();
	}

	
	
	
	
	/**
	 * Relaciona cada horario con su respectivo hashMap
	 */
	private void actionCreateHash() {
		System.out.println("Hash hs");
		System.out.println(this.horario.size());
		for(Horario h:this.horario) {
			HashMap<String, ArrayList<Hora>> array=new HashMap<String, ArrayList<Hora>>();
			actionCreateMaps(array,h);
			this.total.add(array);
		}
	}
	
	/**
	 * Inicializa los HashMaps
	 * @param array
	 * @param h
	 */
	private void actionCreateMaps(HashMap<String, ArrayList<Hora>> array, Horario h) {
		//Aqui es null
		ArrayList<Hora>horas=h.getHoras();
		String dia=h.getDia();
		
		array.put(dia,horas);
	}
	
	
	private void actionSetId() {
		this.id=baseBean.getIdRec();
	}
	
	
	private void actionSetHorario() {
		try {
			this.horario=serviciosReserva.consultarHorarioDias(this.id);

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
	
	private ArrayList<Hora> getArrayFromTotal(int i) {
		ArrayList<Hora> horas=null;
		try {
			HashMap<String, ArrayList<Hora>> array=this.total.get(i);
			Object[] keys=array.keySet().toArray();
			ArrayList<Object> keysA=(ArrayList<Object>) Arrays.asList((Object[])keys);
			
			String k=(String) keysA.get(i);
			
			horas=array.get(k);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return horas;
		
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
}
	










