package edu.eci.cvds.view;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import edu.eci.cvds.exceptions.ServiciosUsuarioException;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.ServiciosUsuario;

@SuppressWarnings("deprecation")
@ManagedBean(name = "UsuariosBean")
@SessionScoped
public class UsuariosView {
	
	private ServiciosUsuario serviciosUsuario;

	@ManagedProperty(value = "#{ReservaBean}")
	private BasePageBean baseBean;
	
	private String carnet;
	private String documento;
	private String correo;
	private String nombres;
	private String apellidos;
	private String password;
	private Date ultimoIngreso;
	private boolean bloqueado;
	private int idCargo;

	private List<Usuario> usuarios;
	
	public UsuariosView() {
	}

	
	@PostConstruct
	public void init() {
		serviciosUsuario=baseBean.getServiciosUsuario();
		actionReiniciar();
		actionSetListaUsuarios();
	}
	


	private void actionSetListaUsuarios() {
		try {
			this.usuarios=this.serviciosUsuario.consultarUsuarios();
		} catch (ServiciosUsuarioException e) {
			e.printStackTrace();
		}
	}
	
	public void actionBloquear(String carnet) {
		boolean b;
		try {
			b = serviciosUsuario.consultadoEstadoBloqUser(carnet);
			serviciosUsuario.actualizarUsuarioBloqueado(carnet,!b);
			actionSetListaUsuarios();
		} catch (ServiciosUsuarioException e) {
			e.printStackTrace();
			baseBean.mensajeApp(e);
		}
		
	}
	
	public String actionMostrarBloq(boolean bloqueado) {
		if(bloqueado) {
			return "Desbloquear";
		}
		else {
			return "Bloquear";
		}
		
	}
	
	
	public void actionReiniciar() {
		this.carnet=null;
		this.documento=null;
		this.correo=null;
		this.nombres=null;
		this.apellidos=null;
		this.password=null;
		this.ultimoIngreso=null;
		this.bloqueado=false;
		this.idCargo=-1;
		
	}
	

	
	
	public String getCarnet(){
		return this.carnet;
	}
	public void setCarnet(String carnet){
		this.carnet=carnet;
	}
	
	public String getDocumento(){
		return this.documento;
	}
	public void setDocumento(String documento){
		this.documento=documento;
	}
	
	public String getCorreo(){
		return this.correo;
	}
	public void setCorreo(String correo){
		this.correo=correo;
	}
	
	public String getNombres(){
		return this.nombres;
	}
	public void setNombres(String nombres){
		this.nombres=nombres;
	}
	
	public String getApellidos(){
		return apellidos;
	}
	public void setApellidos(String apellidos){
		this.apellidos=apellidos;
	}
	
	public String getPassword(){
		return this.password;
	}
	public void setPassword(String password){
		this.password=password;
	}
	
	public Date getUltimoIngreso(){
		return this.ultimoIngreso;
	}
	public void setUltimoIngreso(Date ultimoIngreso){
		this.ultimoIngreso=ultimoIngreso;
	}
	
	public boolean getBloqueado(){
		return this.bloqueado;
	}
	
	public void setBloqueado(boolean bloqueado){
		this.bloqueado=bloqueado;
	}
	
	public int getIdCargo(){
		return this.idCargo;
	}
	public void setIdCargo(int cargo){
		this.idCargo=cargo;
	}
	
	public List<Usuario> getUsuarios(){
		return this.usuarios;
	}
	
	public void setUsuarios(List<Usuario> users){
		this.usuarios=users;
	}
	
	public BasePageBean getUsuario() {
		return this.baseBean;
	}
	
	public void setBaseBean(BasePageBean bs){
	    this.baseBean = bs;
	}
	
	public ServiciosUsuario getServU() {
		return this.serviciosUsuario;
	}
	
	/*public static void main(String args[]) {
		
		try {
			UsuariosView  u=new UsuariosView();
			Cargo c = u.getServU().consultarCargo(2);
			System.out.println(c);
		} catch (ServiciosUsuarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/

}






