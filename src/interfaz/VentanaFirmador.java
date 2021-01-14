package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modelo.Controlador;

/**
 * Interfaz con la funcion de firmar documentos
 *
 */
@SuppressWarnings("serial")
public class VentanaFirmador extends JFrame implements ActionListener {

    public static final String SUBIR_ARCHIVO = "Subir archivo";
    public static final String FIRMAR_ARCHIVO = "Firmar archivo";

    private JPasswordField passFieldContrasena;
    private JTextField txtNombreDocumento;

    private Inicio inicio;
    private String rutaArchivo;

    public VentanaFirmador(Inicio inicio) {

        this.inicio = inicio;
        rutaArchivo = "";

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 320, 210);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.black);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel labIngreseContrasena2 = new JLabel("EXPORTAR FIRMA", SwingConstants.CENTER);
        labIngreseContrasena2.setForeground(Color.white);
        labIngreseContrasena2.setFont(new Font("tahoma", Font.BOLD, 14));
        labIngreseContrasena2.setBounds(80, 10, 150, 30);
        contentPane.add(labIngreseContrasena2);
        
        //--------------------------------------------------------
        JButton butSubirDocumento = new JButton("Subir archivo");
        butSubirDocumento.setActionCommand(SUBIR_ARCHIVO);
        butSubirDocumento.addActionListener((ActionListener) this);
        butSubirDocumento.setBackground(Color.pink);
        butSubirDocumento.setBounds(10, 50, 125, 23);
        contentPane.add(butSubirDocumento);
        //--------------------------------------------------------

        passFieldContrasena = new JPasswordField();
        passFieldContrasena.setBounds(145, 90, 150, 20);
        contentPane.add(passFieldContrasena);

        JLabel labIngreseContrasena = new JLabel("Clave privada", SwingConstants.CENTER);
        labIngreseContrasena.setForeground(Color.white);     
        labIngreseContrasena.setBounds(50, 90, 85, 30);
        contentPane.add(labIngreseContrasena);

        //--------------------------------------------------------
        JButton butFirmarDocumento = new JButton("FIRMAR");
        butFirmarDocumento.setActionCommand(FIRMAR_ARCHIVO);
        butFirmarDocumento.addActionListener((ActionListener) this);
        butFirmarDocumento.setBackground(Color.pink);
        butFirmarDocumento.setBounds(10, 130, 125, 23);
        contentPane.add(butFirmarDocumento);
        //--------------------------------------------------------

        txtNombreDocumento = new JTextField();
        txtNombreDocumento.setEditable(false);
        txtNombreDocumento.setBounds(145, 50, 150, 20);
        contentPane.add(txtNombreDocumento);
        txtNombreDocumento.setColumns(10);

        JButton butMenuPrincipal = new JButton("REGRESAR");
        butMenuPrincipal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inicio.setVisible(true);
                dispose();
            }
        });
        butMenuPrincipal.setBackground(Color.pink);
        butMenuPrincipal.setBounds(170, 130, 125, 23);
        contentPane.add(butMenuPrincipal);
    }

    public void subirArchivo() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Seleccionar archivo");

        int seleccion = fc.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = fc.getSelectedFile();
            rutaArchivo = fichero.getAbsolutePath();
            txtNombreDocumento.setText(fichero.getName());

        }
    }

    public void firmarArchivo() {
        //verificar datos minimos
        String password = new String(passFieldContrasena.getPassword());
        if (rutaArchivo.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(this, "Seleccione un archivo y una contraseña",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Controlador controlador = inicio.getControlador();

            JOptionPane.showMessageDialog(this, "Seleccione el destino del archivo");

            //Seleccionar donde guardar la firma
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("Guardar archivo");

            int seleccion = fc.showSaveDialog(this);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File fichero = fc.getSelectedFile();
                String rutaFirma = fichero.getAbsolutePath();

                //proceder a firmar
                try {
                    controlador.firmarArchivo(rutaArchivo, rutaFirma, password);
                    JOptionPane.showMessageDialog(this, "Se genero la firma", "Respuesta", JOptionPane.INFORMATION_MESSAGE);

                    rutaArchivo = "";
                    txtNombreDocumento.setText("");
                    passFieldContrasena.setText("");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando = e.getActionCommand();

        if (comando.equals(SUBIR_ARCHIVO)) {

            subirArchivo();
        } else if (comando.equals(FIRMAR_ARCHIVO)) {
            firmarArchivo();
        }

    }

}
