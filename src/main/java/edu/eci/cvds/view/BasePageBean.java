package edu.eci.cvds.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import com.google.inject.Injector;

import edu.eci.cvds.sampleprj.dao.CargoDAO;
import edu.eci.cvds.sampleprj.dao.RecursoDAO;
import edu.eci.cvds.sampleprj.dao.ReservaDAO;
import edu.eci.cvds.sampleprj.dao.TipoDAO;
import edu.eci.cvds.sampleprj.dao.UsuarioDAO;
import edu.eci.cvds.samples.services.ServiciosReserva;
import edu.eci.cvds.samples.services.ServiciosUsuario;


@SuppressWarnings("deprecation")
@ManagedBean(name="ReservaBean")
@SessionScoped
public class BasePageBean implements Serializable {

 	private static final long serialVersionUID = 1L;
 	
	private Injector injector;
	private long idRec;
	private String usuario;

	
    private Injector getInjector() {
        if (injector == null) {
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
                    .getContext();
            injector = (Injector) servletContext.getAttribute(Injector.class.getName());
        }
        return injector; 
    }

    protected UsuarioDAO getClientDao() {
    	return getInjector().getInstance(UsuarioDAO.class);
    }
    
    protected CargoDAO getCargoDAO() {
    	return getInjector().getInstance(CargoDAO.class);
    }

    protected TipoDAO getTipoDAO() {
    	return getInjector().getInstance(TipoDAO.class);
    }

    protected RecursoDAO RecursoDAO() {
    	return getInjector().getInstance(RecursoDAO.class);
    }
    
    protected ReservaDAO getReservaDAO() {
    	return getInjector().getInstance(ReservaDAO.class);
    }
    
    protected ServiciosReserva getServiciosReserva() {
    	return getInjector().getInstance(ServiciosReserva.class);
    }
    
    protected ServiciosUsuario getServiciosUsuario() {
    	return getInjector().getInstance(ServiciosUsuario.class);
    }
    
    protected void mensajeApp(Exception e) {
		Messages.lanzarMensajeAplicacion(e.getMessage());
	}
    
    
    
    public String page01(){
		return "menuAdmin?faces-redirect=true";
	}
    
    public String page02(){
		return "menuCom?faces-redirect=true";
	}
    
    public String page1(){
		return "iniciosesion?faces-redirect=true";
	}
    
	public String page2(){
		return "registroRecursos?faces-redirect=true";
	}
    
	public String page3(){
		return "recursosAdmin?faces-redirect=true";
	}
	
	
	public String page4(){
		return "reservas?faces-redirect=true";
	}
    
	public String page5(){
		return "registroUsuarios?faces-redirect=true";
	}
	
	public String page6(){
		return "cerrarsesion?faces-redirect=true";
	}
	
	public String page7(){
		return "horario?faces-redirect=true";
	}
	
	public String page8(){
		return "recursosComunidad?faces-redirect=true";
	}
	
	public String page9(){
		return "usuarios?faces-redirect=true";
	}
	
	public String page10(){
		return "registroUsuarios?faces-redirect=true";
	}
	
	public String page11(){
		return "tipos?faces-redirect=true";
	}
	
	public String page12(){
		return "cargos?faces-redirect=true";
	}
	
	public long getIdRec() {
		return this.idRec;
	}
    
    public void setIdRec(long a) {
		this.idRec=a;
	}
    
    public String getUsuario(){
		return this.usuario;
	}

	public void setUsuario (String usuario){
		this.usuario = usuario;
	}
}