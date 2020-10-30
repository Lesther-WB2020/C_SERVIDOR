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
public class Producto {
    
    private int       id;
    private String    nombre;
    private String    categoria;
    private double    precio;
    private int       cantidad;
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
            * @return the categoria
            */
           public String getCategoria() {
               return categoria;
           }

           /**
            * @param categoria the categoria to set
            */
           public void setCategoria(String categoria) {
               this.categoria = categoria;
           }

           /**
            * @return the precio
            */
           public double getPrecio() {
               return precio;
           }

           /**
            * @param precio the precio to set
            */
           public void setPrecio(double precio) {
               this.precio = precio;
           }
           
           
            /**
             * @return the cantidad
             */
              public int getCantidad() {
                 return cantidad;
              }

             /**
              * @param cantidad the cantidad to set
              */
               public void setCantidad(int cantidad) {
                   this.cantidad = cantidad;
               }

}
