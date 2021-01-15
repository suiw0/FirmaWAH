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

        setTitle("MENU");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 250, 450, 170);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.white);
        setContentPane(contentPane);
        setLayout(null);

        VentanaPDF PDFsito = new VentanaPDF();

        VentanaGeneradorClaves generadorClaves = new VentanaGeneradorClaves(this);
        VentanaFirmador firmador = new VentanaFirmador(this);
        VentanaVerificador comprobador = new VentanaVerificador(this);

        JLabel labIngreseContrasena = new JLabel("WAH ORTIZ SUI SOM                          5IV6");
        labIngreseContrasena.setForeground(Color.black);
        labIngreseContrasena.setBounds(105, 10, 400, 30);
        contentPane.add(labIngreseContrasena);

        JButton butGeneradorPDF = new JButton("Generar el PDF y firmarlo");
        butGeneradorPDF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PDFsito.setVisible(true);
                dispose();
            }
        });
        butGeneradorPDF.setForeground(Color.white);
        butGeneradorPDF.setFont(new Font("Agency FB", Font.ITALIC, 20));
        butGeneradorPDF.setBackground(Color.black);
        butGeneradorPDF.setBounds(10, 51, 200, 23);
        contentPane.add(butGeneradorPDF);

        JButton butGeneradorClaves = new JButton("Generar las claves");
        butGeneradorClaves.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generadorClaves.setVisible(true);
                dispose();
            }
        });
        butGeneradorClaves.setBackground(Color.black);
        butGeneradorClaves.setFont(new Font("Agency FB", Font.ITALIC, 20));
        butGeneradorClaves.setForeground(Color.white);
        butGeneradorClaves.setBounds(220, 51, 200, 23);
        contentPane.add(butGeneradorClaves);

        JButton butFirmador = new JButton("Generar y exportar firma");
        butFirmador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firmador.setVisible(true);
                dispose();
            }
        });
        butFirmador.setForeground(Color.white);
        butFirmador.setFont(new Font("Agency FB", Font.ITALIC, 20));
        butFirmador.setBackground(Color.black);
        butFirmador.setBounds(10, 91, 200, 23);
        contentPane.add(butFirmador);

        JButton butComprobador = new JButton("Validación");
        butComprobador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comprobador.setVisible(true);
                dispose();
            }
        });
        butComprobador.setForeground(Color.white);
        butComprobador.setFont(new Font("Agency FB", Font.ITALIC, 20));
        butComprobador.setBackground(Color.black);
        butComprobador.setBounds(220, 91, 200, 23);
        contentPane.add(butComprobador);
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
