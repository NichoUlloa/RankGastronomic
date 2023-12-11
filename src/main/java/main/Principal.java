package main;

import dato.GestorDatos;
import gui.VentanaLogin;
import model.*;

import java.util.List;

import static dato.GestorDatos.*;


public class Principal {
    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("prueba", "Perez", "afa", "123456","prueba","temuco",5,8);
        Reseña reseña1 = new Reseña("Muy buena comida", 5);
        Comida comida1 = new Comida("Milanesa", 250, "Milanesa con papas fritas");
        Restorante restorante1 = new Restorante("La Picada", "Av. 18 de Julio 1234", 5.0, 9.0, List.of(reseña1), List.of(comida1));
        GestorDatos gestorDatos = new GestorDatos();
        gestorDatos.guardarUsuario(usuario1);
        gestorDatos.guardarComida(comida1);
        gestorDatos.guardarRestaurante(restorante1);
        VentanaLogin ventanaLogin = new VentanaLogin();
    }
}