/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectofinal.clases;

import java.util.ArrayList;

/**
 *
 * @author Iosef14
 */
public class pedido {

    private int       idPedido;
    private ArrayList <Producto> listaProductos;
    private empleado  emp;
    private mesa      Mesa;
    private cliente   Cliente;
    private double    totalCompra;
    
                /**
                * @return the listaProductos
                */
               public ArrayList <Producto> getListaProductos() {
                   return listaProductos;
               }

               /**
                * @param listaProductos the listaProductos to set
                */
               public void setListaProductos(ArrayList <Producto> listaProductos) {
                   this.listaProductos = listaProductos;
               }
    
                /**
                 * @return the idPedido
                 */
                public int getIdPedido() {
                    return idPedido;
                }

                /**
                 * @param idPedido the idPedido to set
                 */
                public void setIdPedido(int idPedido) {
                    this.idPedido = idPedido;
                }

                /**
                 * @return the emp
                 */
                public empleado getEmp() {
                    return emp;
                }

                /**
                 * @param emp the emp to set
                 */
                public void setEmp(empleado emp) {
                    this.emp = emp;
                }

                /**
                 * @return the Mesa
                 */
                public mesa getMesa() {
                    return Mesa;
                }

                /**
                 * @param Mesa the Mesa to set
                 */
                public void setMesa(mesa Mesa) {
                    this.Mesa = Mesa;
                }

                /**
                 * @return the Cliente
                 */
                public cliente getCliente() {
                    return Cliente;
                }

                /**
                 * @param Cliente the Cliente to set
                 */
                public void setCliente(cliente Cliente) {
                    this.Cliente = Cliente;
                }

                /**
                 * @return the totalCompra
                 */
                public double getTotalCompra() {
                    return totalCompra;
                }

                /**
                 * @param totalCompra the totalCompra to set
                 */
                public void setTotalCompra(double totalCompra) {
                    this.totalCompra = totalCompra;
                }

}
