package gui;

import javax.swing.*;

public class VentanaLogin extends JFrame {
    private JPanel loginPanel;
    private JButton aceptarButton;
    private JTextField campoUsuario;
    private JTextField campoContraseña;
    private JButton registrateAquiButton;

    public VentanaLogin() {
        setContentPane(loginPanel);
        setTitle("Login");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
