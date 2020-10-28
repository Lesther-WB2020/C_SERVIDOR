/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectofinal.clases;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Manuel
 */
public class Consulta extends conection{
    
    public boolean registrarUsuario(empleado emp) throws FileNotFoundException{
        
        try {
            
            CallableStatement cts = null;
            Connection con = getConection();
                String query = "{CALL REGISTRAR_USUARIO(?,?,?,?,?,?,?)}";
                    FileInputStream foto = null;
                    File file = new File(emp.getRutaFoto());
                    foto = new FileInputStream(file);
                        cts = con.prepareCall(query);
                            cts.setString( 1, emp.getUsuario()); 
                            cts.setString( 2, emp.getNombre());
                            cts.setString( 3, emp.getApellido());
                            cts.setString( 4, emp.getCorreo());
                            cts.setString( 5, emp.getPassword());
                            cts.setString( 6, emp.getTipoEmpleado());
                            cts.setBinaryStream(7, foto); 
                                cts.executeUpdate();
                                    return true;
                        
        } catch (ClassNotFoundException | SQLException e) {
            return false;
        }
                     
    }
    
    public int validarExistenciaUsuario(String usuario){
        try {
            
            CallableStatement cts = null;
            Connection con = getConection();
                ResultSet rs;
                String query = "{CALL VALIDAR_USUARIO(?)}";
                    cts = con.prepareCall(query);
                        cts.setString(1, usuario);
                            rs = cts.executeQuery();
                                if(rs.next()){
                                    //RETORNARÁ UN ENTERO CON BASE AL NÚMERO DE REGISTROS ESPECIFICADOS (USUARIO)
                                    //SI HAY UN REGISTRO CON DICHO NOMBRE DE USUARIO REGRESARÁ UNO, DE LO CONTRARIO REGRESARÁ CERO.
                                    return rs.getInt(1);
                                }
                                    return 1;
                        
        } catch (ClassNotFoundException | SQLException e) {
            return 1;
        }
    }
    
    public boolean iniciarSesion(empleado emp) throws IOException{
        try {
            
            CallableStatement cts = null;
            Connection con = getConection();
                ResultSet rs;
                String query = "{CALL INICIAR_SESION(?)}";
                    cts = con.prepareCall(query);
                        cts.setString(1, emp.getUsuario());
                            rs = cts.executeQuery();
                                if(rs.next()){
                                    if(emp.getPassword().equals(rs.getString(3))){
                                        try {
                                            //inicio consulta intermedia
                                            String queryDos ="{CALL SET_ULTIMA_SESION(?,?)}";
                                                cts = con.prepareCall(queryDos);
                                                    cts.setString(1, emp.getUltimaSesion());
                                                    cts.setInt(2, rs.getInt(1)); 
                                                        cts.execute();//fin consulta intermedia
                                                            emp.setId(rs.getInt(1));
                                                            emp.setNombre(rs.getString(4)); 
                                                            emp.setApellido(rs.getString(5));
                                                            emp.setTipoEmpleado(rs.getString(6)); 
                                                                Blob blob = rs.getBlob(7);
                                                                byte[] data = blob.getBytes(1,(int) blob.length());
                                                                BufferedImage img = null;
                                                                img = ImageIO.read(new ByteArrayInputStream(data));
                                                                emp.setImg(new ImageIcon(img)); 
                                                                    return true;
                                        } catch (IOException | SQLException e) {
                                             JOptionPane.showConfirmDialog(null, "HUBO UN ERROR AL INICIAR SESIÓN", "MENSAJE", JOptionPane.OK_OPTION, JOptionPane.ERROR, new ImageIcon(getClass().getResource("/03_mensajes/errorEnRegistro.png")));
                                             return false;
                                        }
                                    }else{
                                        return false;
                                    }
                                }
                                    return false;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, "HUBO UN ERROR AL INICIAR SESIÓN", "MENSAJE", JOptionPane.OK_OPTION, JOptionPane.ERROR, new ImageIcon(getClass().getResource("/03_mensajes/errorEnRegistro.png")));
            return false;
        }
    }
    
    public boolean validarEmail(String email){
            Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher matcher_ = pattern.matcher(email);
            return matcher_.find();
    }        
}
