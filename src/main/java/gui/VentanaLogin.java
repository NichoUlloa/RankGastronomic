package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static dato.GestorDatos.leerArchivoUsuarios;

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
                if (!usuario.isEmpty() && !contraseña.isEmpty()) {
                    if (!leerArchivoUsuarios(usuario, contraseña)) {
                        JOptionPane.showMessageDialog(null, "Bienvenido " + usuario);
                        dispose();
                        Menu menu = new Menu();

                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos o no existe el usuario");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese usuario y contraseña");
                }

            }

            public static void main(String[] args) {
                VentanaLogin ventanaLogin = new VentanaLogin();

            }
        });
    }
}
