package dato;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import model.*;

public class GestorDatos {
    private static final String datosRankGastronomic = "datosRankGastronomic.txt";

    public static RankGastronomic cargarDatosDesdeArchivo() {
        RankGastronomic rankGastronomic = new RankGastronomic(null,null,null);

        cargarComidasEnRankGastronomic(rankGastronomic);
        cargarUsuarioDesdeDatos(rankGastronomic);
        cargarRestoranteDesdeDatos(rankGastronomic);
        return rankGastronomic;
    }

    private static void cargarUsuarioDesdeDatos(RankGastronomic rankGastronomic) {
        try (BufferedReader br = new BufferedReader(new FileReader("datosUsuarios.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
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
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo de datos de usuarios . No se cargarán usuarios en RankGastronomic.");
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al leer el archivo de datos de usuarios: " + e.getMessage());
        }
        }

    private static void cargarRestoranteDesdeDatos(RankGastronomic rankGastronomic){
        try (BufferedReader br = new BufferedReader(new FileReader("datosRestorantes.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombreRestorante = datos[1];
                double latitudRestorante = Double.parseDouble(datos[2]);
                double longitudRestorante = Double.parseDouble(datos[3]);
                String direccionRestorante = datos[4];
                List<Comida> listaComidas = cargarComidasDelRestaurante(nombreRestorante);
                List<Reseña> reseñas = cargarReseñasDelRestorante(nombreRestorante);

                Restorante restorante = new Restorante(nombreRestorante, listaComidas, direccionRestorante, latitudRestorante, longitudRestorante, reseñas);
                rankGastronomic.agregarRestorante(restorante);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo de datos de restorante . No se cargarán restorantes en RankGastronomic.");
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al leer el archivo de datos de restorante: " + e.getMessage());
        }
    }
    private static List<Comida> cargarComidasDelRestaurante(String nombreRestorante) {
        List<Comida> listaComidas = new ArrayList<>();

        String datosComidas = "comidasRestorante.txt";

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
    private static List<Reseña> cargarReseñasDelRestorante(String nombreRestorante) {
        List<Reseña> reseñas = new ArrayList<>();

        String datosReseñas = "reseñas.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(datosReseñas))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String opinionReseña = datos[0];
                int calificacionReseña = Integer.parseInt(datos[1]);

                if (nombreRestorante != null){
                    Reseña reseña = new Reseña(opinionReseña,calificacionReseña);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo de datos de reseñas. No se cargarán reseñas para el restaurante.");
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al leer el archivo de datos de reseñas: " + e.getMessage());
        }
        return reseñas;
    }
    private static void cargarComidasEnRankGastronomic(RankGastronomic rankGastronomic) {
        try (BufferedReader br = new BufferedReader(new FileReader("comidas.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombreComida = datos[0];
                double precioComida = Double.parseDouble(datos[1]);
                String descripcionComida = datos[2];

                Comida comida = new Comida(nombreComida, precioComida, descripcionComida);
                rankGastronomic.agregarComida(comida);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo de datos de comidas. No se cargarán comidas en RankGastronomic.");
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al leer el archivo de datos de comidas: " + e.getMessage());
        }
    }


    public static void guardarRegistrosEnArchivo(List<Object> registros) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(datosRankGastronomic))) {
            for (Object registro : registros) {
                if (registro instanceof Usuario) {
                    guardarUsuarioEnArchivo((Usuario) registro, bw);
                } else if (registro instanceof Restorante) {
                    guardarRestoranteEnArchivo((Restorante) registro, bw);
                } else if (registro instanceof  Comida){
                    guardarComidaEnArchivo((Comida) registro, bw);
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
    private static void guardarComidaEnArchivo(Comida comida, BufferedWriter bw) throws IOException {
        String linea = "Comida," + comida.getNombreComida() + "," + comida.getPrecio() + "," +
                comida.getDescripcion();
        bw.write(linea);
        bw.newLine();
    }
}
