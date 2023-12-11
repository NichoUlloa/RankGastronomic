package gui;

import dato.GestorDatos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Menu extends JFrame {
    private JPanel MenuPanel;
    private JComboBox listaComidas;
    private JButton volverButton;
    private JButton aceptarButton;

    public Menu() {
        setContentPane(MenuPanel);
        setTitle("Menu");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaLogin ventanaLogin = new VentanaLogin();
                dispose();
            }
        });
        listaComidas.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                try {
                    listaComidas.removeAllItems();
                    for (Object comida : GestorDatos.getNombreComidas()) {
                        listaComidas.addItem(comida);
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String comida = listaComidas.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null, "La comida seleccionada es: " + comida+"\n" +" nuevas funciones proximamente");
                dispose();
            }
        });
        }
    }

