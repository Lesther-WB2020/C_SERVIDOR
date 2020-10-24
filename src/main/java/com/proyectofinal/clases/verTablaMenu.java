/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectofinal.clases;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Manuel
 */
public class verTablaMenu {
    
    public void verTablaMenu_(JTable tabla) throws IOException{
        try {
            conection myCon = new conection();
                Connection con = myCon.getConection();
                    ResultSet rs = myCon.verMenu();
                        tabla.setDefaultRenderer(Object.class, new TablaImagen());
                            DefaultTableModel dtm = new DefaultTableModel();
                                dtm.addColumn("PIZZA");
                                dtm.addColumn("FOTO");
                                dtm.addColumn("PRECIO (Q)");
                                    while(rs.next()){
                                        Object[] fila = new Object[3];
                                            fila[0] = rs.getObject(2);
                                                Blob blob = rs.getBlob(3);
                                                    byte[] data = blob.getBytes(1, (int) blob.length());
                                                        BufferedImage img = ImageIO.read(new ByteArrayInputStream(data));
                                                            ImageIcon icono = new ImageIcon(img);
                                                                fila[1] = new javax.swing.JLabel(icono);
                                                                    fila[2] = rs.getObject(4);
                                                                        dtm.addRow(fila); 
                                    }

                                    tabla.setModel(dtm); 
                                        tabla.setRowHeight(69); 
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }
    
}
