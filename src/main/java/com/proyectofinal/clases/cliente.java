/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectofinal.clases;

/**
 *
 * @author Iosef14
 */
public class cliente{
   
            private int      idCliente;
            private String   NIT;
            private String   Nombre; 
            private String   Apellido;
            private String   Correo_electronico;
      
                    
                    /**
                     * @return the idCliente
                     */
                    public int getIdCliente() {
                        return idCliente;
                    }

                    /**
                     * @param idCliente the idCliente to set
                     */
                    public void setIdCliente(int idCliente) {
                        this.idCliente = idCliente;
                    }
    
                    /**
                     * @return the NIT
                     */
                    public String getNIT() {
                        return NIT;
                    }

                    /**
                     * @param NIT the NIT to set
                     */
                    public void setNIT(String NIT) {
                        this.NIT = NIT;
                    }

                    /**
                     * @return the Correo_electronico
                     */
                    public String getCorreo_electronico() {
                        return Correo_electronico;
                    }

                    /**
                     * @param Correo_electronico the Correo_electronico to set
                     */
                    public void setCorreo_electronico(String Correo_electronico) {
                        this.Correo_electronico = Correo_electronico;
                    }          
                    
                    /**
                    * @return the Nombre
                    */
                   public String getNombre() {
                       return Nombre;
                   }

                   /**
                    * @param Nombre the Nombre to set
                    */
                   public void setNombre(String Nombre) {
                       this.Nombre = Nombre;
                   }

                   /**
                    * @return the Apellido
                    */
                   public String getApellido() {
                       return Apellido;
                   }

                   /**
                    * @param Apellido the Apellido to set
                    */
                   public void setApellido(String Apellido) {
                       this.Apellido = Apellido;
                   }
    
}
