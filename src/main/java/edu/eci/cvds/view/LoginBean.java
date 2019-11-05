package edu.eci.cvds.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;


@ManagedBean(name = "LoginBean")
@ViewScoped

public class LoginBean implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private String userName;
    private String password;
    private boolean rememberMe;


    public void login(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("src/main/webapp/WEB-INF/shiro.ini");          
        SecurityManager securityManager = factory.getInstance();      
        SecurityUtils.setSecurityManager(securityManager);    

        try{
            Subject currentUser = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(userName, new Sha256Hash(password).toHex());

            currentUser.login(token);
            currentUser.getSession().setAttribute("Correo",userName);
            token.setRememberMe(true);
        } catch(UnknownAccountException e){
            FacesContext.getCurrentInstance().addMessage("login", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario no encontrado", "Este usuario no se encuentra en nuestra base de datos"));
        } catch (IncorrectCredentialsException e) {
            FacesContext.getCurrentInstance().addMessage("login", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contraseña incorrecta", "La contraseña ingresada no es correcta"));
        }
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
