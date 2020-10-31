/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectofinal.frames;

import com.proyectofinal.clases.Consulta;
import com.proyectofinal.clases.conection;
import com.proyectofinal.clases.empleado;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Iosef14
 */
public class Fm_Facturacion extends javax.swing.JFrame {
    
                   empleado emp = null;
                   private final String SQL_Agre = " call ACTUALIZAR_pedido (?,?,?,?,?,?,?,?,?)";
                   private CallableStatement PS;
                   private  final conection con;
    /**
     * Creates new form Fm_Facturacion
     */
    public Fm_Facturacion() {
               this.setIconImage(new ImageIcon(getClass().getResource("/00_jf_principal/idm.png")).getImage());
            initComponents();
                tabla();
                    PS = null;
                        con = new conection();
    }
    
    public Fm_Facturacion(empleado emp) {
        this.emp = emp;
        System.out.println(emp.getId());
               this.setIconImage(new ImageIcon(getClass().getResource("/00_jf_principal/idm.png")).getImage());
                 initComponents();
                    tabla();
                        PS = null;
                            con = new conection();
                                cerrar();
    }
    
    public void cerrar(){
    
        try {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e){ //WindowEvent: import java.awt.event.WindowEvent;
                      confirmarCerrarVentana();
                }
            });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    public void confirmarCerrarVentana(){
        Icon question;
        question = new ImageIcon(getClass().getResource("/00_jf_principal/question.png"));
        
        int valor = JOptionPane.showConfirmDialog(null, "¿REALMENTE QUIERES CERRAR LA VENTANA?", "ATENCIÓN", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,question);
        if(valor == JOptionPane.YES_OPTION){
            this.dispose();
                jfprincipal principalframe = new jfprincipal(emp);
                    principalframe.setVisible(true);
        }else{
            this.setVisible(true);
        }  
    }
   
    public void tabla() {
    
    
               try{
               
                DefaultTableModel modelo= new DefaultTableModel();
                jTable1.setModel(modelo);
                
                PreparedStatement ps =null;
                ResultSet res=null;
                
                conection conectar = new conection();
                
                String sql= "SELECT ID_Pedido, Producto_Detalles, Precio_Unitario, Cantidad, Precio_Total, ID_Empleado, Estado_Pedido, Correo_Cliente, Numero_Mesa FROM pedidos"
                        ;
                ps = conectar.getConection().prepareStatement(sql);
                res= ps.executeQuery();
                
                
                
                
                ResultSetMetaData MD = res.getMetaData();
                int cantidadColumnas= MD.getColumnCount();
                
                
                 modelo.addColumn("ID_Pedido");
                 modelo.addColumn("Producto_Detalles");
                 modelo.addColumn("Precio_Unitario");
                 modelo.addColumn("Cantidad");
                 modelo.addColumn("Precio_Total");
                 modelo.addColumn("ID_Empleado");
                 modelo.addColumn("Estado_Pedido");
                 modelo.addColumn("Correo_Cliente");
                 modelo.addColumn("Numero_Mesa");

                while(res.next()){
                
                Object[] filas = new  Object[cantidadColumnas];
                
                
                 int i=0;
                for( i=0; i<cantidadColumnas; i++){
                
                  filas[i] = res.getObject(i+1);
                }
                                 modelo.addRow(filas);

                
               }
    
    } catch(SQLException ex){
    
          System.err.println(ex.toString());
    }                  catch (ClassNotFoundException ex) {
                           Logger.getLogger(Fm_Facturacion.class.getName()).log(Level.SEVERE, null, ex);
                       }
        
        
    }    
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpEncabezado = new javax.swing.JPanel();
        jlblCajeroData = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jpanelDatosATraer = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtID_PEDIDO = new javax.swing.JTextField();
        txtPedido_Correo = new javax.swing.JTextField();
        Combo_estado_pedido = new javax.swing.JComboBox<>();
        Facturar_Enviar = new javax.swing.JButton();
        Actualizar_datos = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jpEncabezado.setBackground(new java.awt.Color(0, 100, 145));

        jlblCajeroData.setBackground(new java.awt.Color(0, 100, 145));
        jlblCajeroData.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jlblCajeroData.setForeground(new java.awt.Color(255, 255, 255));
        jlblCajeroData.setText("CAJERO: ");

        javax.swing.GroupLayout jpEncabezadoLayout = new javax.swing.GroupLayout(jpEncabezado);
        jpEncabezado.setLayout(jpEncabezadoLayout);
        jpEncabezadoLayout.setHorizontalGroup(
            jpEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEncabezadoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jlblCajeroData)
                .addContainerGap(632, Short.MAX_VALUE))
        );
        jpEncabezadoLayout.setVerticalGroup(
            jpEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEncabezadoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jlblCajeroData)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jpanelDatosATraer.setBackground(new java.awt.Color(0, 100, 145));

        jLabel5.setBackground(new java.awt.Color(0, 100, 145));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID PEDIDO");

        jLabel7.setBackground(new java.awt.Color(0, 100, 145));
        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ESTADO DEL PEDIDO");

        jButton1.setText("BUSCAR PEDIDO POR CORREO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpanelDatosATraerLayout = new javax.swing.GroupLayout(jpanelDatosATraer);
        jpanelDatosATraer.setLayout(jpanelDatosATraerLayout);
        jpanelDatosATraerLayout.setHorizontalGroup(
            jpanelDatosATraerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelDatosATraerLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelDatosATraerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpanelDatosATraerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jpanelDatosATraerLayout.setVerticalGroup(
            jpanelDatosATraerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelDatosATraerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabel5)
                .addGap(32, 32, 32)
                .addComponent(jLabel7)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        txtID_PEDIDO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtID_PEDIDOActionPerformed(evt);
            }
        });

        txtPedido_Correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPedido_CorreoActionPerformed(evt);
            }
        });

        Combo_estado_pedido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Procesando", "Entregado", "Cancelado" }));
        Combo_estado_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo_estado_pedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtID_PEDIDO, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPedido_Correo)
                    .addComponent(Combo_estado_pedido, 0, 238, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPedido_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(txtID_PEDIDO, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(Combo_estado_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        Facturar_Enviar.setText("Enviar factura");
        Facturar_Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Facturar_EnviarActionPerformed(evt);
            }
        });

        Actualizar_datos.setText("Actualizar Pedido");
        Actualizar_datos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Actualizar_datosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanelDatosATraer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(243, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Actualizar_datos, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(Facturar_Enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(228, 228, 228))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpanelDatosATraer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Facturar_Enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Actualizar_datos, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(441, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(225, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID_Pedido", "Producto_Detalles", "Precio_Unitario", "Cantidad", "Precio_Total", "ID_Empleado", "Estado_Pedido", "Correo_Cliente", "Numero_Mesa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(166, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 385, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 271, Short.MAX_VALUE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 948, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(329, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtID_PEDIDOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtID_PEDIDOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtID_PEDIDOActionPerformed

    private void txtPedido_CorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPedido_CorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPedido_CorreoActionPerformed

    private void Facturar_EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Facturar_EnviarActionPerformed
        // TODO add your handling code here:
        Consulta mysql = new Consulta();
         if((!txtPedido_Correo.getText().equals(""))&&((mysql.validarEmail(txtPedido_Correo.getText())==true))){
             
             int desicion= JOptionPane.showConfirmDialog(null, "¿Deseas realizar tu orden?");

                if(desicion==JOptionPane.YES_OPTION){
         try {
             int i=0;
              for(  i=0; i<jTable1.getRowCount();i++){
       
               
                        String id_pedido=jTable1.getValueAt(i,0).toString();
                        String producto_detalles= jTable1.getValueAt(i,1).toString();
                        String precio_unit=jTable1.getValueAt(i,2).toString();
                        
                        
                        String cantidad_unit_string=jTable1.getValueAt(i,3).toString();
                        
                        String precio_total=jTable1.getValueAt(i,4).toString();
                        String id_empleado=jTable1.getValueAt(i,5).toString();
                         String estado_pedido=jTable1.getValueAt(i,6).toString();

                    String correo_cliente=jTable1.getValueAt(i,7).toString();
                    String numero_mesa=jTable1.getValueAt(i,8).toString();

            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

            String correoRemitente = "dominos2020programacionII@gmail.com";
            String passwordRemitente = "123452020";
            String correoReceptor = txtPedido_Correo.getText();
            
            String asunto = "Factura por consumo en Domino's Pizza";
            String mensaje = "Hola, te enviamos los siguientes datos de la "
                    + "facturacion<br><br><br><b>ID Pedido:</b>"+"  "+id_pedido +
                    "<br><b>Detalles del producto:</b>"+"  "+producto_detalles+
                    "<br><b>Precio unitario del producto</b>"+"  "+precio_unit+
                    "<br><b>Cantidad de unidades compradas</b>"+"  "+cantidad_unit_string+
                    "<br><b>Precio Total del pedido</b>"+"  "+precio_total+
                    "<br><b>ID del empleado</b>"+"  "+id_empleado+
                    "<br><b>Estado Del pedido</b>"+"  "+estado_pedido+
                    "<br><b>Numero de mesa</b>"+"  "+numero_mesa+
                    "<br><b>Muchas gracias por su compra.</b>";

            MimeMessage message = new MimeMessage( session);
            message.setFrom(new InternetAddress(correoRemitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setText(mensaje, "ISO-8859-1", "html");

            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();

            JOptionPane.showMessageDialog(null, "Correo Electronico Enviado");

         } } catch (AddressException ex) {
        } catch (MessagingException ex) {
            Logger.getLogger(Fm_Facturacion.class.getName()).log(Level.SEVERE, null, ex);
        }
                } else if(desicion==JOptionPane.NO_OPTION)
                {

                    JOptionPane.showMessageDialog(null, "No se efectuara la facturacion");

                }
                
                
         }  else{
         
                     JOptionPane.showMessageDialog(null, "INGRESE UN CORREO VÁLIDO PARA CONSULTAR Y/O ENVIAR FACTURA");

         
         }
                   
    }//GEN-LAST:event_Facturar_EnviarActionPerformed

    private void Combo_estado_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo_estado_pedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Combo_estado_pedidoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
                 Consulta mysql = new Consulta();                 
        String campo = txtPedido_Correo.getText();
        String where ="";

        if((!"".equals(campo))&&(mysql.validarEmail(txtPedido_Correo.getText())==true))

        {
            where=" WHERE Correo_Cliente ='"+campo+"'";
        
        try{

            DefaultTableModel modelo= new DefaultTableModel();
            jTable1.setModel(modelo);

            PreparedStatement ps =null;
            ResultSet res=null;

            conection conectar = new conection();

            String sql= "SELECT ID_Pedido, Producto_Detalles, Precio_Unitario, Cantidad, Precio_Total, ID_Empleado, Estado_Pedido, Correo_Cliente, Numero_Mesa FROM pedidos"
            +where;
            ps = conectar.getConection().prepareStatement(sql);
            res= ps.executeQuery();

            ResultSetMetaData MD = res.getMetaData();
            int cantidadColumnas= MD.getColumnCount();

            modelo.addColumn("ID_Pedido");
            modelo.addColumn("Producto_Detalles");
            modelo.addColumn("Precio_Unitario");
            modelo.addColumn("Cantidad");
            modelo.addColumn("Precio_Total");
            modelo.addColumn("ID_Empleado");
            modelo.addColumn("Estado_Pedido");
            modelo.addColumn("Correo_Cliente");
            modelo.addColumn("Numero_Mesa");

            while(res.next()){

                Object[] filas = new  Object[cantidadColumnas];

                int i=0;
                for( i=0; i<cantidadColumnas; i++){

                    filas[i] = res.getObject(i+1);
                }
                modelo.addRow(filas);

            }

        } catch(SQLException ex){

            System.err.println(ex.toString());
        }              catch (ClassNotFoundException ex) {
                           Logger.getLogger(Fm_Facturacion.class.getName()).log(Level.SEVERE, null, ex);
                       }
        }else{
                JOptionPane.showMessageDialog(null, "INGRESE UN CORREO VÁLIDO Y QUE APAREZCA EN LA TABLA");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Actualizar_datosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Actualizar_datosActionPerformed
        // TODO add your handling code here:
                                         
        
        
        if(!txtID_PEDIDO.getText().equals("")){
        
             if(Combo_estado_pedido.getSelectedIndex()==1){

             
                 int codigo= Integer.valueOf(txtID_PEDIDO.getText());
                 if(Proceso(codigo)==0){}
                     
                     
             }
             
             else  if(Combo_estado_pedido.getSelectedIndex()==2){
                    
                 int codigo= Integer.valueOf(txtID_PEDIDO.getText());
                 if(Entregado(codigo)==0){}
                 
        } else  if(Combo_estado_pedido.getSelectedIndex()==3){
                    
                 int codigo= Integer.valueOf(txtID_PEDIDO.getText());
                 if(Pagado(codigo)==0){}
        
        
        }
        
        
        
        
        
        }else{
        
        
        
        
                             JOptionPane.showMessageDialog(null, "Ingrese el ID Del pedido.");

        
        }
        
        
        
        
        
        
    }//GEN-LAST:event_Actualizar_datosActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Fm_Facturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fm_Facturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fm_Facturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fm_Facturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fm_Facturacion().setVisible(true);
            }
        });
    }
    
                 public int Proceso(int pedido){
   
                     ResultSet RES=null;

              PreparedStatement NS=null;
             
             conection coneccion = new conection();
             
             String sql=" SELECT ID_Pedido, Producto_Detalles, Precio_Unitario, Cantidad, Precio_Total, ID_Empleado, Estado_Pedido, Correo_Cliente, Numero_Mesa FROM pedidos WHERE ID_Pedido = ?";
            
             
             try{
                 NS=    coneccion.getConection().prepareStatement(sql);
                 NS.setInt(1,  pedido);
                 RES=NS.executeQuery();

                if(RES.next())    {              
                    
                   
                    
                    
                      int id_pedido =RES.getInt(1);
                    

                String producto_detalles =RES.getString(2);
                int precio_unitario = Integer.valueOf (RES.getString(3));
                int cantidad = Integer.valueOf (RES.getString(4));
                int precio_total = Integer.valueOf (RES.getString(5));
                int id_empleado = emp.getId();
                String estado = "En Proceso";
                String correo=RES.getString(8);
                String no_mesa =RES.getString(9);

                   int res = 0;
     try{
     PS = con.getConection().prepareCall(SQL_Agre);
     PS.setInt(1,  id_pedido);
     PS.setString(2, producto_detalles);
     PS.setInt(3, precio_unitario);
     PS.setInt(4, cantidad);
     PS.setInt(5, precio_total);
         PS.setInt(6, id_empleado);
     
     PS.setInt(6, id_empleado);
     PS.setString(7, estado);
     PS.setString(8, correo);
     PS.setString(9, no_mesa);

     res = PS.executeUpdate();
     if (res > 0) {
                   JOptionPane.showMessageDialog(null, "SE actualizo");
         

     }
     PS = null;
     con.CloseConnection();
     
     
     
     }   catch (SQLException e) {
                  JOptionPane.showMessageDialog(null, "Error, ingrese todos los campos requeridos");

            System.err.println(  e.getMessage());
        }finally {
            PS = null;
            con.CloseConnection();
            
            
            Fm_Facturacion ne = new Fm_Facturacion();
             this.dispose();
                                          ne.setVisible(true);

        }

        return res;
                    
                    }
                   
                    
                  }
                

                catch(SQLException ex){
                        System.out.println(" No se econtro nada de nada de nada");

                }      catch (ClassNotFoundException ex) {
                           Logger.getLogger(Fm_Facturacion.class.getName()).log(Level.SEVERE, null, ex);
                       }
               return 0;

      
      
             }

    
                     public int Entregado(int pedido){
   
                     ResultSet RES=null;

              PreparedStatement NS=null;
             
             conection coneccion = new conection();
             
             String sql=" SELECT ID_Pedido, Producto_Detalles, Precio_Unitario, Cantidad, Precio_Total, ID_Empleado, Estado_Pedido, Correo_Cliente, Numero_Mesa FROM pedidos WHERE ID_Pedido = ?";
            
             
             try{
                 NS=    coneccion.getConection().prepareStatement(sql);
                 NS.setInt(1,  pedido);
                 RES=NS.executeQuery();

                if(RES.next())    {              
                    
                   
                    
                    
                      int id_pedido =RES.getInt(1);
                    

                String producto_detalles =RES.getString(2);
                int precio_unitario = Integer.valueOf (RES.getString(3));
                int cantidad = Integer.valueOf (RES.getString(4));
                int precio_total = Integer.valueOf (RES.getString(5));
                int id_empleado = emp.getId();
                String estado = "Entregado En Mesa";
                String correo=RES.getString(8);
                String no_mesa =RES.getString(9);

                   int res = 0;
     try{
     PS = con.getConection().prepareCall(SQL_Agre);
     PS.setInt(1,  id_pedido);
     PS.setString(2, producto_detalles);
     PS.setInt(3, precio_unitario);
     PS.setInt(4, cantidad);
     PS.setInt(5, precio_total);
     PS.setInt(6, id_empleado);
     PS.setString(7, estado);
     PS.setString(8, correo);
     PS.setString(9, no_mesa);

     res = PS.executeUpdate();
     if (res > 0) {
                   JOptionPane.showMessageDialog(null, "SE actualizo");
         

           
         
         
     }
     PS = null;
     con.CloseConnection();
     
     
     
     }   catch (SQLException e) {
                  JOptionPane.showMessageDialog(null, "Error, ingrese todos los campos requeridos");

            System.err.println(  e.getMessage());
        }finally {
            PS = null;
            con.CloseConnection();
            
            
            Fm_Facturacion ne = new Fm_Facturacion();
             this.dispose();
                                          ne.setVisible(true);

        }

        return res;
                    
                    }
                   
                    
                  }
                

                catch(SQLException ex){
                        System.out.println(" No se econtro nada de nada de nada");

                }      catch (ClassNotFoundException ex) {
                           Logger.getLogger(Fm_Facturacion.class.getName()).log(Level.SEVERE, null, ex);
                       }
               return 0;

      
      
             }

                         public int Pagado(int pedido){
   
                     ResultSet RES=null;

              PreparedStatement NS=null;
             
             conection coneccion = new conection();
             
             String sql=" SELECT ID_Pedido, Producto_Detalles, Precio_Unitario, Cantidad, Precio_Total, ID_Empleado, Estado_Pedido, Correo_Cliente, Numero_Mesa FROM pedidos WHERE ID_Pedido = ?";
            
             
             try{
                 NS=    coneccion.getConection().prepareStatement(sql);
                 NS.setInt(1,  pedido);
                 RES=NS.executeQuery();

                if(RES.next())    {              
                    
                   
                    
                    
                      int id_pedido =RES.getInt(1);
                    

                String producto_detalles =RES.getString(2);
                int precio_unitario = Integer.valueOf (RES.getString(3));
                int cantidad = Integer.valueOf (RES.getString(4));
                int precio_total = Integer.valueOf (RES.getString(5));
                int id_empleado = emp.getId();
                String estado = "Cancelado/Pagado";
                String correo=RES.getString(8);
                String no_mesa =RES.getString(9);

                   int res = 0;
     try{
     PS = con.getConection().prepareCall(SQL_Agre);
     PS.setInt(1,  id_pedido);
     PS.setString(2, producto_detalles);
     PS.setInt(3, precio_unitario);
     PS.setInt(4, cantidad);
     PS.setInt(5, precio_total);
     PS.setInt(6, id_empleado);
     PS.setString(7, estado);
     PS.setString(8, correo);
     PS.setString(9, no_mesa);

     res = PS.executeUpdate();
     if (res > 0) {
                   JOptionPane.showMessageDialog(null, "SE actualizo");
        
     }
     PS = null;
     con.CloseConnection();
     
     
     
     }   catch (SQLException e) {
                  JOptionPane.showMessageDialog(null, "Error, ingrese todos los campos requeridos");

            System.err.println(  e.getMessage());
        }finally {
            PS = null;
            con.CloseConnection();
            
            
            Fm_Facturacion ne = new Fm_Facturacion();
             this.dispose();
                                          ne.setVisible(true);

        }

        return res;
                    
                    }
                   
                    
                  }
                

                catch(SQLException ex){
                        System.out.println(" No se econtro nada de nada de nada");

                }      catch (ClassNotFoundException ex) {
                           Logger.getLogger(Fm_Facturacion.class.getName()).log(Level.SEVERE, null, ex);
                       }
               return 0;

      
      
             }

    
    
    
    
    
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar_datos;
    private javax.swing.JComboBox<String> Combo_estado_pedido;
    private javax.swing.JButton Facturar_Enviar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jlblCajeroData;
    private javax.swing.JPanel jpEncabezado;
    private javax.swing.JPanel jpanelDatosATraer;
    private javax.swing.JTextField txtID_PEDIDO;
    private javax.swing.JTextField txtPedido_Correo;
    // End of variables declaration//GEN-END:variables
}
