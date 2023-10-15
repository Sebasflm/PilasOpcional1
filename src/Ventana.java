import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel Panel;
    private JLabel codigoLabel;
    private JTextField codigoField;
    private JLabel empresaLabel;
    private JTextField empresaField;
    private JButton btnIngresar;
    private JButton btnBuscar;
    private JButton btnSacar;
    private JButton btnImprimirPilas;
    private JButton btnSalir;
    private JTextArea txtImpresion;
    AlmacenApp a = new AlmacenApp();

    public Ventana() {

        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (a.ingresarCaja(new Caja(codigoField.getText(), empresaField.getText()))) {
                    JOptionPane.showMessageDialog(null, "Caja ingresada con éxito.");
                } else {
                    JOptionPane.showMessageDialog(null, "La pila está llena. No es posible ingresar más cajas.", "Pila llena", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resultadoBusqueda = a.buscarCaja(codigoField.getText());
                JOptionPane.showMessageDialog(null,resultadoBusqueda);
            }
        });
        btnSacar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (a.sacarCaja(codigoField.getText())) {
                    JOptionPane.showMessageDialog(null, "Caja sacada con éxito.");
                } else {
                    JOptionPane.showMessageDialog(null, "La caja no pudo ser sacada.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnImprimirPilas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtImpresion.setText(a.imprimirPilas());
            }
        });
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

