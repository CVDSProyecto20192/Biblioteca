package edu.eci.cvds.view;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;

import java.io.Serializable;


@SuppressWarnings("deprecation")
@ManagedBean(name="LoginBean")
@ViewScoped

public class LoginBean implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private String userName;
    private String password;
    private boolean rememberMe;


    public String login(){   
	    String s = "iniciosesion?faces-redirect=true";
        try{
            Subject currentUser = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(userName, new Sha256Hash(password).toHex());
            currentUser.login(token);
            currentUser.getSession().setAttribute("Correo",userName);
            token.setRememberMe(true);
			System.out.println(currentUser);
			s = "recursos?faces-redirect=true";
        } catch(UnknownAccountException e){
            FacesContext.getCurrentInstance().addMessage("login", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario no encontrado", "Este usuario no se encuentra en nuestra base de datos"));
        } catch (IncorrectCredentialsException e) {
            FacesContext.getCurrentInstance().addMessage("login", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contraseña incorrecta", "La contraseña ingresada no es correcta"));
        }
		return s;
    }

    public String getUserName() {
        return userName;
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

    public void setUserName(String userName) {
        this.userName = userName;
    }
}