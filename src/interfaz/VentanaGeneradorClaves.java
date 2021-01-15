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
import javax.swing.border.EmptyBorder;

import modelo.Controlador;

/**
 * Interfaz con las funciones de generar un par de claves RSA y exportar una
 * clave publica
 *
 */
@SuppressWarnings("serial")
public class VentanaGeneradorClaves extends JFrame implements ActionListener {

    public static final String GENERAR_CLAVES = "Generar clave RSA";
    public static final String EXPORTAR_CLAVE_PUBLICA = "Exportar clave";

    private JPasswordField passFieldContrasena;
    private JPasswordField passFieldIngreseNuevamenteContrasena;

    private Inicio inicio;

    public VentanaGeneradorClaves(Inicio inicio) {
        this.inicio = inicio;

        this.setTitle("CLAVES");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 250, 290, 200);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.white);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel labContrasena = new JLabel("Password");
        labContrasena.setForeground(Color.black);
        labContrasena.setBounds(10, 11, 150, 20);
        contentPane.add(labContrasena);

        JLabel labConfirmarContrasena = new JLabel("Confirmación");
        labConfirmarContrasena.setForeground(Color.black);
        labConfirmarContrasena.setBounds(150, 11, 150, 14);
        contentPane.add(labConfirmarContrasena);

        //----------------------------------------------------------------
        JButton butGenerarClaves = new JButton("Crear clave privada");
        butGenerarClaves.setBackground(Color.black);
        butGenerarClaves.setFont(new Font("Agency FB", Font.ITALIC, 20));
        butGenerarClaves.setForeground(Color.white);
        butGenerarClaves.setBounds(60, 65, 150, 23);
        contentPane.add(butGenerarClaves);
        butGenerarClaves.setActionCommand(GENERAR_CLAVES);
        butGenerarClaves.addActionListener((ActionListener) this);
        //----------------------------------------------------------------

        passFieldContrasena = new JPasswordField();
        passFieldContrasena.setBounds(10, 35, 115, 20);
        contentPane.add(passFieldContrasena);

        passFieldIngreseNuevamenteContrasena = new JPasswordField();
        passFieldIngreseNuevamenteContrasena.setBounds(150, 35, 115, 20);
        contentPane.add(passFieldIngreseNuevamenteContrasena);

        //----------------------------------------------------------------
        JButton butExportarClavePublica = new JButton("Exportar");
        butExportarClavePublica.setBackground(Color.black);
        butExportarClavePublica.setFont(new Font("Agency FB", Font.ITALIC, 20));
        butExportarClavePublica.setForeground(Color.white);
        butExportarClavePublica.setBounds(60, 95, 150, 23);
        contentPane.add(butExportarClavePublica);
        butExportarClavePublica.setActionCommand(EXPORTAR_CLAVE_PUBLICA);
        butExportarClavePublica.addActionListener((ActionListener) this);
        //----------------------------------------------------------------

        JButton butIrAFirma = new JButton("Menu principal");
        butIrAFirma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                inicio.setVisible(true);
                dispose();

            }
        });
        butIrAFirma.setBackground(Color.black);
        butIrAFirma.setFont(new Font("Agency FB", Font.ITALIC, 20));
        butIrAFirma.setForeground(Color.white);
        butIrAFirma.setBounds(60, 125, 150, 23);
        contentPane.add(butIrAFirma);
    }

    public void generarClaves() {
        Controlador controlador = inicio.getControlador();

        String pass1 = String.valueOf(passFieldContrasena.getPassword());
        String pass2 = String.valueOf(passFieldIngreseNuevamenteContrasena.getPassword());

        if (pass1.equals("") || pass2.equals("")) {
            JOptionPane.showMessageDialog(this, "INGRESE CONTRASEÑA", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (pass1.equals(pass2) == false) {
                JOptionPane.showMessageDialog(this, "NO SON LAS MISMAS CONTRASEÑAS", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                controlador.generarClave(pass1);
                JOptionPane.showMessageDialog(this, "CLAVES GENERADAS CORRECTAMENTE", "Respuesta", JOptionPane.INFORMATION_MESSAGE);

                passFieldContrasena.setText("");
                passFieldIngreseNuevamenteContrasena.setText("");
            }
        }
    }

    public void exportarClavePublica() {
        Controlador controlador = inicio.getControlador();

        //paso 1: obtener identificador (password) de la clave
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Contraseña:");
        JPasswordField pass = new JPasswordField(10);
        panel.add(label);
        panel.add(pass);
        String[] options = new String[]{"CONTINUAR", "REGRESAR"};
        int option = JOptionPane.showOptionDialog(null, panel, "Clave", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
        if (option == 0) {
            String password = new String(pass.getPassword());

            //paso 2: seleccionar nombre de archivo para guardar
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("Guardar archivo");

            int seleccion = fc.showSaveDialog(this);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File fichero = fc.getSelectedFile();
                String rutaClavePublica = fichero.getAbsolutePath();

                try {
                    controlador.exportarClavePublica(rutaClavePublica, password);
                    JOptionPane.showMessageDialog(this, "Clave exportada exitosamente", "Respuesta", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {

                    JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.equals(GENERAR_CLAVES)) {
            generarClaves();
        } else if (comando.equals(EXPORTAR_CLAVE_PUBLICA)) {
            exportarClavePublica();
        }

    }
}
