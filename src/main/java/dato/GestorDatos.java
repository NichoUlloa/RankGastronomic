package dato;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import model.RankGastronomic;
import model.Restorante;
import model.Comida;
import model.Usuario;

public class GestorDatos {
    private static final String datosRankGastronomic = "datosRankGastronomic.txt";

    public static RankGastronomic cargarDatosDesdeArchivo() {
        RankGastronomic rankGastronomic = new RankGastronomic(null,null,null,null);

        try (BufferedReader br = new BufferedReader(new FileReader(datosRankGastronomic))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String tipoRegistro = datos[0];

                if (tipoRegistro.equals("Usuario")) {
                    cargarUsuarioDesdeDatos(rankGastronomic, datos);
                } else if (tipoRegistro.equals("Restorante")) {
                    cargarRestoranteDesdeDatos(rankGastronomic, datos);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo de datos. Se creará uno nuevo al agregar registros.");
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al leer el archivo de datos: " + e.getMessage());
        }

        return rankGastronomic;
    }

    private static void cargarUsuarioDesdeDatos(RankGastronomic rankGastronomic, String[] datos) {
        String nombreUsuario = datos[1];
        String apellidoUsuario = datos[2];
        String correoUsuario = datos[3];
        String contraseñaUsuario = datos[4];
        String nickUsuario = datos[5];
        String ciudad = datos[6];
        double latitudUsuario = Double.parseDouble(datos[7]);
        double longitudUsuario = Double.parseDouble(datos[8]);

        Usuario usuario = new Usuario(nombreUsuario, apellidoUsuario, correoUsuario, contraseñaUsuario, nickUsuario, ciudad, latitudUsuario, longitudUsuario);
        rankGastronomic.agregarUsuario(usuario);
    }

    private static void cargarRestoranteDesdeDatos(RankGastronomic rankGastronomic, String[] datos) {
        String nombreRestorante = datos[1];
        double latitudRestorante = Double.parseDouble(datos[2]);
        double longitudRestorante = Double.parseDouble(datos[3]);
        String direccionRestorante = datos[4];
        List<Comida> listaComidas = cargarComidasDelRestaurante(nombreRestorante);

        Restorante restorante = new Restorante(nombreRestorante, listaComidas, direccionRestorante, latitudRestorante, longitudRestorante);
        rankGastronomic.agregarRestorante(restorante);
    }
    private static List<Comida> cargarComidasDelRestaurante(String nombreRestorante) {
        List<Comida> listaComidas = new ArrayList<>();

        String datosComidas = "comidas.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(datosComidas))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombreComida = datos[0];
                double precioComida = Double.parseDouble(datos[1]);
                String descripcionComida = datos[2];

                if (nombreRestorante != null){
                    Comida comida = new Comida(nombreComida, precioComida, descripcionComida);
                    listaComidas.add(comida);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo de datos de comidas. No se cargarán comidas para el restaurante.");
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al leer el archivo de datos de comidas: " + e.getMessage());
        }
        return listaComidas;
    }

    public static void guardarRegistrosEnArchivo(List<Object> registros) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(datosRankGastronomic))) {
            for (Object registro : registros) {
                if (registro instanceof Usuario) {
                    guardarUsuarioEnArchivo((Usuario) registro, bw);
                } else if (registro instanceof Restorante) {
                    guardarRestoranteEnArchivo((Restorante) registro, bw);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo de datos: " + e.getMessage());
        }
    }

    private static void guardarUsuarioEnArchivo(Usuario usuario, BufferedWriter bw) throws IOException {
        String linea = "Usuario," + usuario.getNombreUsuario() + "," + usuario.getApellidoUsuario() + "," +
                usuario.getCorreoUsuario() + "," + usuario.getContraseñaUsuario() + "," + usuario.getNickUsuario() + "," +
                usuario.getCiudad() + "," + usuario.getLatitud() + "," + usuario.getLongitud();
        bw.write(linea);
        bw.newLine();
    }

    private static void guardarRestoranteEnArchivo(Restorante restorante, BufferedWriter bw) throws IOException {
        String linea = "Restorante," + restorante.getNombreRestorante() + "," + restorante.getLatitud() + "," +
                restorante.getLongitud() + "," + restorante.getDireccion();
        bw.write(linea);
        bw.newLine();
    }
}