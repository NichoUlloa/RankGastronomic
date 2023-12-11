package gui;

import dato.GestorDatos;
import model.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        volverAtrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaLogin ventanaLogin = new VentanaLogin();
                dispose();
            }
        });
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = campoNombre.getText();
                String apellido = campoApellido.getText();
                String correo = campoCorreo.getText();
                String contraseña = campoContraseña.getText();
                String usuario = campoUsuario.getText();
                String ciudad = campoCiudad.getText();
                if (nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() || contraseña.isEmpty() || usuario.isEmpty() || ciudad.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
                } else {
                    Usuario usuario1= new  Usuario(nombre, apellido, correo, contraseña, usuario, ciudad, 0, 0);
                    GestorDatos.guardarUsuario(usuario1);
                    JOptionPane.showMessageDialog(null, "Usuario registrado");
                    VentanaLogin ventanaLogin = new VentanaLogin();
                    dispose();
                }
            }
        });
    }


}
