/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectofinal.clases;

/**
 *
 * @author Manuel
 */
public class mesa {
    
    private int id;
    private String nombreMesa;
    private int disponibilidad;
        
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
                * @return the noDeMesa
                */
               public String getNombreMesa() {
                   return nombreMesa;
               }

               /**
                * @param noDeMesa the noDeMesa to set
                */
               public void setNoDeMesa(String nombreMesa) {
                   this.nombreMesa = nombreMesa;
               }

               /**
                * @return the disponibilidad
                */
               public int getDisponibilidad() {
                   return disponibilidad;
               }

               /**
                * @param disponibilidad the disponibilidad to set
                */
               public void setDisponibilidad(int disponibilidad) {
                   this.disponibilidad = disponibilidad;
               }
    
}
