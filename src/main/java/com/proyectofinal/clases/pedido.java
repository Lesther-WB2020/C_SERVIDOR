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
public class pedido {

    private int       idPedido;
    private Producto  producto;
    private empleado  emp;
    private mesa      Mesa;
    private cliente   Cliente;
    private int       cantidad;
    
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
                 * @return the producto
                 */
                public Producto getProducto() {
                    return producto;
                }

                /**
                 * @param producto the producto to set
                 */
                public void setProducto(Producto producto) {
                    this.producto = producto;
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
