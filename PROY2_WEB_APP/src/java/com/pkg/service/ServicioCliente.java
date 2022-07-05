/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pkg.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User1
 */
public class ServicioCliente extends Servicio{
    
    
    public ClienteTO Demeclientes(String Correo, String Contra) {
        Connection conn = getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        ClienteTO clienteTO = null;
 
        try {
//            ps = conn.prepareStatement("SELECT * FROM Cliente WHERE Contrasenna = ? AND Correo = ?");

            
            ps = conn.prepareStatement("SELECT id, Contrasenna, Correo FROM Cliente WHERE Contrasenna = ? AND Correo = ?");
            ps.setString(1, Contra);
            ps.setString(2, Correo);
            rs = ps.executeQuery();


            while (rs.next()) {
                clienteTO = new ClienteTO();
                clienteTO.setId(rs.getInt("id"));
                
                clienteTO.setContra(rs.getString("Contrasenna"));
                clienteTO.setCorreo(rs.getString("Correo"));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            //Paso 5 (Cerrar)  
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            //super.desconectar();

        }
        return clienteTO;

    }

    
    
}
