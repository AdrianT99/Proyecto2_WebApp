package com.pkg.controller;


import com.pkg.service.ClienteTO;
import com.pkg.service.ServicioCliente;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;


@ManagedBean(name = "LoginController")
@SessionScoped
public class LoginController implements Serializable {
    
    private String correo;
    private String pass;
    private ClienteTO clienteTO;

    public LoginController() {
    }

     public void ingresar() {
         ServicioCliente servicioCliente = new ServicioCliente();
         
         this.clienteTO = servicioCliente.Demeclientes(correo, this.pass);
     
        if (this.clienteTO != null) {
            
            FacesContext.getCurrentInstance().addMessage("sticky-key", new FacesMessage(FacesMessage.SEVERITY_INFO, "Exitoso", "Bienvenida Usuario"));
            //Cambiar la pagina de redirecion
//            this.redireccionar("/faces/bienvenida.xhtml");

        } else {
            FacesContext.getCurrentInstance().addMessage("sticky-key", new FacesMessage(FacesMessage.SEVERITY_WARN, "Campos inválidos", "El usuario o contraseña no son correctos"));

        }
    }
    
    public void redireccionar(String ruta) {
        HttpServletRequest request;
        try {
            request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            FacesContext.getCurrentInstance().getExternalContext().redirect(request.getContextPath() + ruta);
        } catch (Exception e) {

        }
    }

    public String getUser() {
        return correo;
    }

    public void setUser(String user) {
        this.correo = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

   
   
//dsdsdsdds
    
    

}