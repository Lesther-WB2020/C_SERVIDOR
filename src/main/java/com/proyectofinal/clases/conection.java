/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectofinal.clases;

import java.io.File; //manejo de carpetas
import java.io.FileInputStream;
import java.io.InputStream;//para emplear InputStream
import java.io.FileNotFoundException;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.FileSystem; 
import java.nio.file.FileSystems;
import java.sql.CallableStatement;

import java.sql.DriverManager; // para poder manipular la db
import java.sql.Connection; // para establecer la conexión?
import java.sql.ResultSet;
import java.sql.SQLException; //para el manejo de errores
import java.sql.Statement;
//import sun.management.FileSystem;

import java.util.Properties; //para leer archivos .properties

/**
 *
 * @author Manuel
 */
public class conection {
    
    Connection conn = null;
    
    String hostname = null; //nombre de la computadora
    String port = null; // puerto
    String database = null; //nombre de la db
    String username = null; 
    String password = null;
    String jndi = null; //what the fuck is it?
    String driver = null;
    
    static Properties props = new Properties();
    
    public conection(){
        
        InputStream in = null;
        
        try{
            //newImputStream lee una archivo en cierto path y lo cargara en la variable de tipo InputStream
            // in se dirige a la ruta especificada obtiene el path 
            in = Files.newInputStream(FileSystems.getDefault().getPath("C:\\proyectoFinalProgramacionIIProperties\\db_props.properties"));
            props.load(in);
            in.close();
            
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        //INVOCAR UN MÉTODO PARA CARGAR INFO EN MEMORIA
        LoadProperties();
    }
    
    public void LoadProperties(){
    
        this.hostname = props.getProperty("hostname");
        this.port = props.getProperty("port");
        this.database = props.getProperty("database");
        this.username = props.getProperty("username");
        this.password = props.getProperty("password");
        this.driver = props.getProperty("driver");
        this.jndi = props.getProperty("jndi");
        
    }
    
    public Connection getConection() throws SQLException, ClassNotFoundException{
        try{
        
        Class.forName(driver);
            String MyJdbcUrl = "jdbc:mysql://"+hostname+":"+port+"/"+database + "?useTimezone=true&serverTimezone=UTC";
                String jdbcUrl = MyJdbcUrl;
                    conn = DriverManager.getConnection(jdbcUrl, username, password);
                        //sout + tab (atajo para syso)
                        System.out.println("LA CONEXIÓN HA SIDO ESTABLECIDA CON ÉXITO");
        
        }catch(SQLException error){
            System.out.println("ERROR AL OBTENER LA CONEXIÓN: "  + error.getMessage());
        }
            return conn;
    }
   
    public void CloseConnection(){
    
        try{
            conn.close();
                System.out.println("LA SESIÓN SE CERRÓ CON ÉXITO");
        }catch(SQLException error){
            System.out.println("ERROR AL CERRAR LA CONEXIÓN " + error);
        }
        
    }

}
