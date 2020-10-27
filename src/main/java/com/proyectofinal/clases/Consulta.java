/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectofinal.clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Manuel
 */
public class Consulta extends conection{
    
    public boolean registrarUsuario(empleado emp) throws SQLException, ClassNotFoundException{
        
        try {
            
            CallableStatement cts = null;
            Connection con = getConection();
                String query = "{CALL REGISTRAR_USUARIO(?,?,?,?,?,?)}";
                    cts = con.prepareCall(query);
                        cts.setString( 1, emp.getUsuario()); 
                        cts.setString( 2, emp.getNombre());
                        cts.setString( 3, emp.getApellido());
                        cts.setString( 4, emp.getCorreo());
                        cts.setString( 5, emp.getPassword());
                        cts.setString( 6, emp.getTipoEmpleado());
                            cts.executeUpdate();
                                return true;
                        
        } catch (Exception e) {
            return false;
        }
                     
    }
    
}
