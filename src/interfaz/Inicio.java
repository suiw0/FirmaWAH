package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Controlador;

/**
 * Ventana inicial del programa
 */
@SuppressWarnings("serial")
public class Inicio extends JFrame {

    private Controlador controlador;

    public Inicio() {
        controlador = new Controlador();

        setTitle("FIRMA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 250, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.black);
        setContentPane(contentPane);
        setLayout(null);

        VentanaPDF PDFsito = new VentanaPDF();

        VentanaGeneradorClaves generadorClaves = new VentanaGeneradorClaves(this);
        VentanaFirmador firmador = new VentanaFirmador(this);
        VentanaVerificador comprobador = new VentanaVerificador(this);

        JLabel labIngreseContrasena2 = new JLabel("FIRMA DIGITAL");
        labIngreseContrasena2.setForeground(Color.white);
        labIngreseContrasena2.setFont(new Font("tahoma", Font.BOLD, 14));
        labIngreseContrasena2.setBounds(65, 10, 150, 30);
        contentPane.add(labIngreseContrasena2);

        JButton butGeneradorPDF = new JButton("CREAR Y FIRMAR PDF");
        butGeneradorPDF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PDFsito.setVisible(true);
                dispose();
            }
        });
        butGeneradorPDF.setBackground(Color.pink);
        butGeneradorPDF.setBounds(40, 51, 160, 23);
        contentPane.add(butGeneradorPDF);

        JButton butGeneradorClaves = new JButton("GENERAR CLAVES");
        butGeneradorClaves.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generadorClaves.setVisible(true);
                dispose();
            }
        });
        butGeneradorClaves.setBackground(Color.pink);
        butGeneradorClaves.setBounds(40, 91, 160, 23);
        contentPane.add(butGeneradorClaves);

        JButton butFirmador = new JButton("EXPORTAR FIRMA");
        butFirmador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firmador.setVisible(true);
                dispose();
            }
        });
        butFirmador.setBackground(Color.pink);
        butFirmador.setBounds(40, 131, 160, 23);
        contentPane.add(butFirmador);

        JButton butComprobador = new JButton("COMPROBAR");
        butComprobador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comprobador.setVisible(true);
                dispose();
            }
        });
        butComprobador.setBackground(Color.pink);
        butComprobador.setBounds(40, 171, 160, 23);
        contentPane.add(butComprobador);
        
        JLabel labIngreseContrasena = new JLabel("Angeles Lopez");
        labIngreseContrasena.setForeground(Color.white);
        labIngreseContrasena.setBounds(75, 200, 150, 30);
        contentPane.add(labIngreseContrasena);
        
        JLabel labIngreseContrasena1 = new JLabel("Erick Jesse");
        labIngreseContrasena1.setForeground(Color.white);
        labIngreseContrasena1.setBounds(85, 215, 150, 30);
        contentPane.add(labIngreseContrasena1);
        
        JLabel labIngreseContrasena12 = new JLabel("5IV6");
        labIngreseContrasena12.setForeground(Color.white);
        labIngreseContrasena12.setBounds(105, 235, 150, 30);
        contentPane.add(labIngreseContrasena12);
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public static void main(String[] args) {
        Inicio window = new Inicio();
        window.setVisible(true);

    }

}
