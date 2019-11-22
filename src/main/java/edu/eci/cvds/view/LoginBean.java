package edu.eci.cvds.view;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;

import java.io.IOException;
import java.io.Serializable;

@ManagedBean(name = "LoginBean")
@SessionScoped

public class LoginBean implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String userName;
    private String password;
    private boolean rememberMe;

    public void login(){
        try {
        	Subject currentUser = SecurityUtils.getSubject();
        	UsernamePasswordToken token= new UsernamePasswordToken(userName, new Sha256Hash(password).toHex());

            currentUser.login(token);
            currentUser.getSession().setAttribute("Correo", userName);
            
            token.setRememberMe(true);
            
            redirectToMenu(); 
            
        } catch (UnknownAccountException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario no encontrado", "Este usuario no se encuentra en nuestra base de datos"));
        } 
        catch (IncorrectCredentialsException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contraseña incorrecta", "La contraseña ingresada no es correcta"));
        }
    }
    
    private Subject getUser() {
    	return SecurityUtils.getSubject();
    }
    
   public void logout() {
	   try {
		   if(getUser().isAuthenticated()) {
			   getUser().logout();
			   
			   redirectTo("iniciosesion.xhtml");
	           
		   }
	   }
	   catch(Exception e) {
		   e.printStackTrace();
		   
	   }
		   
   }

    public void redirectToMenu(){
    	if(getUser()!=null) {
	        if (getUser().hasRole("administrador")){
	                try {
	                    FacesContext.getCurrentInstance().getExternalContext().redirect("menuAdmin.xhtml");
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	        }else{
	            try {
	                FacesContext.getCurrentInstance().getExternalContext().redirect("menuCom.xhtml");
	            
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
    	}
    }


	public void isLogged(){
		Subject subject = SecurityUtils.getSubject();
		if (subject.getSession().getAttribute("Correo") != null){
            redirectToMenu();
		}
    }
    
    public void redirectTo(String path){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}