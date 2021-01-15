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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Controlador;

/**
 * Interfaz con la funcion de verificar una firma digital de un archivo
 *
 */
@SuppressWarnings("serial")
public class VentanaVerificador extends JFrame implements ActionListener {

    public static final String SUBIR_ARCHIVO = "Subir archivo";
    public static final String SUBIR_FIRMA = "Subir firma";
    public static final String SUBIR_CLAVE_PUBLICA = "Subir clave publica";
    public static final String COMPROBAR = "COMPROBAR";

    private JTextField txtSubirArchivo;
    private JTextField txtSubirFirma;
    private JTextField txtSubirClavePublica;

    private Inicio inicio;
    private String rutaArchivo;
    private String rutaFirma;
    private String rutaClavePublica;

    public VentanaVerificador(Inicio inicio) {
        this.inicio = inicio;
        rutaArchivo = "";
        rutaFirma = "";
        rutaClavePublica = "";

        this.setTitle("VALIDACIÓN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 250, 450, 165);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.white);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton butSubirArchivo = new JButton("Archivo");
        butSubirArchivo.setActionCommand(SUBIR_ARCHIVO);
        butSubirArchivo.addActionListener((ActionListener) this);
        butSubirArchivo.setBackground(Color.black);
        butSubirArchivo.setFont(new Font("Agency FB", Font.ITALIC, 20));
        butSubirArchivo.setForeground(Color.white);
        butSubirArchivo.setBounds(10, 10, 125, 23);
        contentPane.add(butSubirArchivo);

        JButton butSubFirma = new JButton("Firma");
        butSubFirma.setActionCommand(SUBIR_FIRMA);
        butSubFirma.addActionListener((ActionListener) this);
        butSubFirma.setBackground(Color.black);
        butSubFirma.setFont(new Font("Agency FB", Font.ITALIC, 20));
        butSubFirma.setForeground(Color.white);
        butSubFirma.setBounds(150, 10, 125, 23);
        contentPane.add(butSubFirma);

        JButton butSubClavePublica = new JButton("Clave publica");
        butSubClavePublica.setActionCommand(SUBIR_CLAVE_PUBLICA);
        butSubClavePublica.addActionListener((ActionListener) this);
        butSubClavePublica.setBackground(Color.black);
        butSubClavePublica.setFont(new Font("Agency FB", Font.ITALIC, 20));
        butSubClavePublica.setForeground(Color.white);
        butSubClavePublica.setBounds(290, 10, 125, 23);
        contentPane.add(butSubClavePublica);

        //-----------------------------------------------------
        JButton butComprobar = new JButton("Comprobar");
        butComprobar.setActionCommand(COMPROBAR);
        butComprobar.addActionListener((ActionListener) this);
        butComprobar.setBackground(Color.black);
        butComprobar.setFont(new Font("Agency FB", Font.ITALIC, 20));
        butComprobar.setForeground(Color.white);
        butComprobar.setBounds(150, 90, 125, 23);
        contentPane.add(butComprobar);
        //-----------------------------------------------------

        JButton butMenuPrincipal = new JButton("Menu principal");
        butMenuPrincipal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inicio.setVisible(true);
                dispose();
            }
        });
        butMenuPrincipal.setBackground(Color.black);
        butMenuPrincipal.setFont(new Font("Agency FB", Font.ITALIC, 20));
        butMenuPrincipal.setForeground(Color.white);
        butMenuPrincipal.setBounds(290, 90, 125, 23);
        contentPane.add(butMenuPrincipal);

        txtSubirArchivo = new JTextField();
        txtSubirArchivo.setEditable(false);
        txtSubirArchivo.setBounds(10, 50, 125, 23);
        contentPane.add(txtSubirArchivo);
        txtSubirArchivo.setColumns(10);

        txtSubirFirma = new JTextField();
        txtSubirFirma.setEditable(false);
        txtSubirFirma.setColumns(10);
        txtSubirFirma.setBounds(150, 50, 125, 23);
        contentPane.add(txtSubirFirma);

        txtSubirClavePublica = new JTextField();
        txtSubirClavePublica.setEditable(false);
        txtSubirClavePublica.setColumns(10);
        txtSubirClavePublica.setBounds(290, 50, 125, 23);
        contentPane.add(txtSubirClavePublica);
    }

    public void subirArchivo() {
        JFileChooser fc = new JFileChooser();

        int seleccion = fc.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = fc.getSelectedFile();
            rutaArchivo = fichero.getAbsolutePath();
            txtSubirArchivo.setText(fichero.getName());
        }
    }

    public void subirFirma() {
        JFileChooser fc = new JFileChooser();

        int seleccion = fc.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = fc.getSelectedFile();
            rutaFirma = fichero.getAbsolutePath();
            txtSubirFirma.setText(fichero.getName());
        }
    }

    public void subirClavePublica() {
        JFileChooser fc = new JFileChooser();

        int seleccion = fc.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = fc.getSelectedFile();
            rutaClavePublica = fichero.getAbsolutePath();
            txtSubirClavePublica.setText(fichero.getName());
        }
    }

    public void comprobar() {
        if (rutaArchivo.equals("") || rutaFirma.equals("") || rutaClavePublica.equals("")) {
            JOptionPane.showMessageDialog(this, "Llene todos los campos",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Controlador controlador = inicio.getControlador();
            try {
                boolean respuesta = controlador.validarFirma(rutaArchivo, rutaFirma, rutaClavePublica);
                if (respuesta) {

                    JOptionPane.showMessageDialog(this, "CONCIDE", "Respuesta", JOptionPane.INFORMATION_MESSAGE);
                } else {

                    JOptionPane.showMessageDialog(this, "NO COINCIDE", "Respuesta", JOptionPane.INFORMATION_MESSAGE);

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "LA FIRMA ES INCORRECTA",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void limpiar() {
        rutaArchivo = "";
        rutaFirma = "";
        rutaClavePublica = "";

        txtSubirArchivo.setText("");
        txtSubirFirma.setText("");
        txtSubirClavePublica.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando = e.getActionCommand();

        if (comando.equals(SUBIR_ARCHIVO)) {
            subirArchivo();
        } else if (comando.equals(SUBIR_FIRMA)) {
            subirFirma();
        } else if (comando.equals(SUBIR_CLAVE_PUBLICA)) {

            subirClavePublica();
        } else if (comando.equals(COMPROBAR)) {
            comprobar();
        }

    }

}
