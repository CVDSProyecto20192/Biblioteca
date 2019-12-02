package edu.eci.cvds.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import edu.eci.cvds.exceptions.ServiciosUsuarioException;
import edu.eci.cvds.samples.entities.Cargo;
import edu.eci.cvds.samples.services.ServiciosReserva;
import edu.eci.cvds.samples.services.ServiciosUsuario;

@ManagedBean(name = "CargosBean")
@SessionScoped
public class CargosView {
	
	private ServiciosUsuario serviciosUsuario;

	@ManagedProperty(value = "#{ReservaBean}")
	private BasePageBean baseBean;
	
	private long id;
	private String nombre;
	private String descripcion;
	
	private Cargo cargo;

	private List<Cargo> cargos;
	
	public CargosView() {
	}

	@PostConstruct
	public void init() {
		serviciosUsuario=baseBean.getServiciosUsuario();
		actionReiniciar();
		actionSetListaCargos();
	}
	
	private void actionMostrarId() {
		try {
			this.id=this.serviciosUsuario.consultarIdCargo(this.cargo);
		} catch (ServiciosUsuarioException e) {
			e.printStackTrace();
		}
	}
	
	public void actionRegistrarCargo() {
		this.cargo=new Cargo(this.nombre, this.descripcion);
		try {
			this.serviciosUsuario.insertarCargo(this.cargo);
			actionMostrarId();
			actionSetListaCargos();
		} catch (ServiciosUsuarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void actionSetListaCargos() {
		try {
			this.cargos=this.serviciosUsuario.consultarCargos();
		} catch (ServiciosUsuarioException e) {
			e.printStackTrace();
		}
		
	}

	public void actionReiniciar() {
		this.id=-1;
		this.nombre=null;
		this.descripcion=null;
		
	}
	
	public long getId(){
		return this.id;
	}
	
	public void setId(long id){
		this.id=id;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}

	public String getDescripcion(){
		return this.descripcion;
	}
	
	public void setDescripcion(String descripcion){
		this.descripcion=descripcion;
	}
	
	public Cargo getCargo(){
		return this.cargo;
	}
	
	public void setCargo(Cargo cargo){
		this.cargo=cargo;
	}
	
	public List<Cargo> getCargos(){
		return this.cargos;
	}
	
	public void setCargos(List<Cargo> cargos){
		this.cargos=cargos;
	}
	
	public BasePageBean getUsuario() {
		return this.baseBean;
	}
	
	public void setBaseBean(BasePageBean bs){
	    this.baseBean = bs;
	}
	
}
