package gui;

import javax.swing.*;

public class VentanaRegistrar extends JFrame {
    private JPanel registrarPanel;
    private JButton registrarButton;
    private JTextField campoNombre;
    private JTextField campoApellido;
    private JTextField campoCorreo;
    private JTextField campoContraseña;
    private JTextField campoUsuario;
    private JTextField campoCiudad;
    private JButton volverAtrasButton;






    public VentanaRegistrar() {
        setContentPane(registrarPanel);
        setTitle("Registrar");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }


}
