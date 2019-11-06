package edu.eci.cvds.view;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import com.google.inject.Injector;

import edu.eci.cvds.sampleprj.dao.*;
import edu.eci.cvds.samples.services.ServiciosReserva;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;



@ManagedBean(name="ReservaBean")
@SessionScoped
public class BasePageBean implements Serializable {

 	private static final long serialVersionUID = 1L;
 	
	private Injector injector;
	//protected long docAlq;
	
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
    
    public String page1(){
		return "iniciosesion?faces-redirect=true";
	}
	
	public String page2(){
		return "reservas?faces-redirect=true";
	}
    
	public String bloquear(){
		return "bloquear?faces-redirect=true";
	}
	
	public String registrar(){
		return "registrar?faces-redirect=true";
	}
    /*public long getDocAlq() {
		return this.docAlq;
	}
    
    public void setDocAlq(long a) {
		this.docAlq=a;
	}*/
}