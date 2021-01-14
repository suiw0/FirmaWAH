package interfaz;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Rivera
 */
public class VentanaPDF extends javax.swing.JFrame {

    /**
     * Creates new form PDf
     */
    public VentanaPDF() {
        initComponents();
        this.getContentPane().setBackground(Color.black);
        this.jLabel1.setForeground(Color.white);
        this.jLabel2.setForeground(Color.white);
        this.jLabel3.setForeground(Color.white);
        this.jLabel4.setForeground(Color.white);
        this.jLabel5.setForeground(Color.white);
        this.Generar.setBackground(Color.pink);
        this.Firmar.setBackground(Color.pink);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Nombre = new javax.swing.JTextField();
        Apellidos = new javax.swing.JTextField();
        Boleta = new javax.swing.JTextField();
        Firmar = new javax.swing.JButton();
        Generar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Mensaje = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setBounds(new java.awt.Rectangle(100, 100, 0, 0));

        Firmar.setText("REGRESAR");
        Firmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirmarActionPerformed(evt);
            }
        });

        Generar.setText("GENERAR");
        Generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        jLabel2.setText("Apellidos");

        jLabel3.setText("Boleta");

        jLabel4.setText("Carta de reyes:");

        Mensaje.setColumns(20);
        Mensaje.setRows(5);
        jScrollPane1.setViewportView(Mensaje);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("CREAR Y FIRMAR EL PDF");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Generar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Firmar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Boleta, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Boleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Generar)
                    .addComponent(Firmar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirmarActionPerformed
        // TODO add your handling code here:
        Inicio Firmita = new Inicio();
        Firmita.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_FirmarActionPerformed

    private void GenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarActionPerformed
        try {
            // TODO add your handling code here:
            generar(Nombre.getText());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VentanaPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(VentanaPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_GenerarActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Apellidos;
    private javax.swing.JTextField Boleta;
    private javax.swing.JButton Firmar;
    private javax.swing.JButton Generar;
    private javax.swing.JTextArea Mensaje;
    private javax.swing.JTextField Nombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void generar(String nombre) throws FileNotFoundException, DocumentException {
        if (!(Nombre.getText().isEmpty() || (Apellidos.getText().isEmpty()) || (Boleta.getText().isEmpty()) || (Mensaje.getText().isEmpty()))) {
            
             FileOutputStream archivo = new FileOutputStream( nombre + ".pdf");
            Document documento = new Document();
            PdfWriter.getInstance(documento, archivo);
            
            documento.open();
            Paragraph parrafo = new Paragraph("Datos personales");
            parrafo.setAlignment(1);
            
           
            documento.add(parrafo);
            documento.add(new Paragraph("Nombre: " + Nombre.getText()));
            documento.add(new Paragraph("Apellidos: " + Apellidos.getText()));
            documento.add(new Paragraph("Boleta: " + Boleta.getText()));
            documento.add(new Paragraph("Carta de reyes: " + Mensaje.getText()));
         
            documento.close();
            
            FileOutputStream archivo2 = new FileOutputStream(nombre + "Firmado" + ".pdf");
            Document documento2 = new Document();
            PdfWriter.getInstance(documento2, archivo2);
            
            documento2.open();
            Paragraph parrafo3= new Paragraph("Datos personales");
            parrafo.setAlignment(1);
            
            Paragraph parrafo2 = new Paragraph("");
            parrafo2.setAlignment(1);
            documento2.add(parrafo3);
            documento2.add(new Paragraph("Nombre: " + Nombre.getText()));
            documento2.add(new Paragraph("Apellidos: " + Apellidos.getText()));
            documento2.add(new Paragraph("Boleta: " + Boleta.getText()));
            documento2.add(new Paragraph("Carta de reyes: " + Mensaje.getText()));
            documento2.add(parrafo2);
            documento2.close();
            
            
            JOptionPane.showMessageDialog(null, "PDF creado correctamente");
        }
        else{
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        }

    }
}
