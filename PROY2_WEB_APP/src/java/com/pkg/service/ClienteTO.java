/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pkg.service;

/**
 *
 * @author User1
 */
public class ClienteTO {
    private int id;
    private String correo;
    private String contra;

    public ClienteTO() {
    }
    
    

    public ClienteTO(String correo, String contra, int id) {
        this.correo = correo;
        this.contra = contra;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
    
    
}
