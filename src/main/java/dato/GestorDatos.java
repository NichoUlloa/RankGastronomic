package dato;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import model.*;

public class GestorDatos {
    private static final String NOMBRE_ARCHIVO = "usuarios.txt";
    private static final String NOMBRE_ARCHIVO_C = "comidas.txt";
    public static void guardarComida(Comida comida) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO_C, true))) {
            writer.write(comida.getNombreComida()+ "\n"+ comida.getPrecio()+ "\n"+ comida.getDescripcion());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Comida> leerComidas() {
        List<Comida> comidas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(NOMBRE_ARCHIVO_C))) {
            String linea;
            String linea2;
            String linea3;
            while ((linea = reader.readLine()) != null) {
                comidas.add(new Comida(linea, Double.parseDouble(linea2 = reader.readLine()), linea3 = reader.readLine()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return comidas;
    }
    public static Object[] getNombreComidas() {
        List<Comida> comidas = leerComidas();
        Object[] nombreComidas = new Object[comidas.size()];
        for (int i = 0; i < comidas.size(); i++) {
            nombreComidas[i] = comidas.get(i).getNombreComida();
        }
        return nombreComidas;
    }

    public static void guardarUsuario(Usuario usuario) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))) {
            writer.write(usuario.getNombreUsuario() + "\n"+ usuario.getApellidoUsuario() + "\n"+ usuario.getCorreoUsuario() + "\n"+ usuario.getContraseñaUsuario() + "\n"+ usuario.getNickUsuario() + "\n"+ usuario.getCiudad() + "\n"+ usuario.getLatitud() + "\n"+ usuario.getLongitud() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Usuario> leerUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String linea;
            String linea2;
            String linea3;
            String linea4;
            String linea5;
            String linea6;
            String linea7;
            String linea8;
            while ((linea = reader.readLine()) != null) {
                usuarios.add(new Usuario(linea, linea2 = reader.readLine(), linea3 = reader.readLine(), linea4 = reader.readLine(), linea5 = reader.readLine(), linea6 = reader.readLine(), Double.parseDouble(linea7 = reader.readLine()), Double.parseDouble(linea8 = reader.readLine())));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
    public static boolean verificarUsuario(String nombre, String contraseña) {
        List<Usuario> usuarios = leerUsuarios();
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombre)&& usuario.getContraseñaUsuario().equals(contraseña)) {
                return true; // El usuario existe
            }
        }
        return false;
    }
}
