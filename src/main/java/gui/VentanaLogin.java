package gui;

import dato.GestorDatos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static dato.GestorDatos.*;

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
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = campoUsuario.getText();
                String contraseña = campoContraseña.getText();
                if (GestorDatos.verificarUsuario(usuario, contraseña)) {
                    JOptionPane.showMessageDialog(null, "Bienvenido " + usuario);
                    Menu menu = new Menu();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario no encontrado");
                }
            }

            public static void main(String[] args) {
                VentanaLogin ventanaLogin = new VentanaLogin();

            }
        });
        registrateAquiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaRegistrar ventanaRegistro = new VentanaRegistrar();
                dispose();
            }
        });
    }
}
