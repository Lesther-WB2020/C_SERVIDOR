/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectofinal.clases;

import javax.swing.ImageIcon;

/**
 *
 * @author Manuel
 */
public class empleado {
    
    private int id;
    private String usuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String password;
    private String ultimaSesion;
    private String tipoEmpleado;
    private String rutaFoto;
    private ImageIcon img;
    
            //SETTERS AND GETTERS
            /**
             * @return the id
             */
            public int getId() {
                return id;
            }

            /**
             * @param id the id to set
             */
            public void setId(int id) {
                this.id = id;
            }

            /**
             * @return the usuario
             */
            public String getUsuario() {
                return usuario;
            }

            /**
             * @param usuario the usuario to set
             */
            public void setUsuario(String usuario) {
                this.usuario = usuario;
            }

            /**
             * @return the nombre
             */
            public String getNombre() {
                return nombre;
            }

            /**
             * @param nombre the nombre to set
             */
            public void setNombre(String nombre) {
                this.nombre = nombre;
            }

            /**
             * @return the apellido
             */
            public String getApellido() {
                return apellido;
            }

            /**
             * @param apellido the apellido to set
             */
            public void setApellido(String apellido) {
                this.apellido = apellido;
            }

            /**
             * @return the correo
             */
            public String getCorreo() {
                return correo;
            }

            /**
             * @param correo the correo to set
             */
            public void setCorreo(String correo) {
                this.correo = correo;
            }

            /**
             * @return the password
             */
            public String getPassword() {
                return password;
            }

            /**
             * @param password the password to set
             */
            public void setPassword(String password) {
                this.password = password;
            }

            /**
             * @return the ultimaSesion
             */
            public String getUltimaSesion() {
                return ultimaSesion;
            }

            /**
             * @param ultimaSesion the ultimaSesion to set
             */
            public void setUltimaSesion(String ultimaSesion) {
                this.ultimaSesion = ultimaSesion;
            }

            /**
             * @return the tipoEmpleado
             */
            public String getTipoEmpleado() {
                return tipoEmpleado;
            }

            /**
             * @param tipoEmpleado the tipoEmpleado to set
             */
            public void setTipoEmpleado(String tipoEmpleado) {
                this.tipoEmpleado = tipoEmpleado;
            }
    
            /**
             * @return the rutaFoto
             */
            public String getRutaFoto() {
                return rutaFoto;
            }

            /**
             * @param rutaFoto the rutaFoto to set
             */
            public void setRutaFoto(String rutaFoto) {
                this.rutaFoto = rutaFoto;
            }
            
            /**
             * @return the img
             */
            public ImageIcon getImg() {
                return img;
            }

            /**
             * @param img the img to set
             */
            public void setImg(ImageIcon img) {
                this.img = img;
            }

}
