package dato;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import model.*;

public class GestorDatos {
    private static final String NOMBRE_ARCHIVO = "usuarios.txt";
    private static final String NOMBRE_ARCHIVO_C = "comidas.txt";
    private static final String NOMBRE_ARCHIVO_R = "restaurantes.txt";
    public static void guardarComida(Comida comida) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO_C, true))) {
            writer.write(comida.getNombreComida()+ "\n"+ comida.getPrecio()+ "\n"+ comida.getDescripcion()+"\n");
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
    public static void guardarRestaurante(Restorante restaurante) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO_R, true))) {
            writer.write(restaurante.getNombreRestorante() + "\n"+ restaurante.getDireccion() + "\n"+restaurante.getLatitud() + "\n"+ restaurante.getLongitud()+"\n"+restaurante.listaReseñaToString()+"\n"+restaurante.listaComidasToString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Restorante> leerRestaurante() {
        List<Restorante> restorantes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(NOMBRE_ARCHIVO_R))) {
            String linea;
            String linea2;
            String linea3;
            String linea4;
            String linea5;
            String linea6;
            while ((linea = reader.readLine()) != null) {
                restorantes.add(new Restorante(linea, linea2 = reader.readLine(), Double.parseDouble(linea3 = reader.readLine()), Double.parseDouble(linea4 = reader.readLine()), linea5 = reader.readLine(), linea6 = reader.readLine()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return restorantes;
    }
    //
    //metodo para comparar nombre de la comida con el nombre de la comida en la lista de comidas del restorante y que retorne todos los atributos de esos restaurantes
    public static String[][] buscarComida(String nombreComida) {
        List<Restorante> restorantes = leerRestaurante();
        String[][] datosResultado = new String[restorantes.size()][4];
        for (int registro = 0; registro < restorantes.size(); registro++) {
            for (int i = 0; i < restorantes.get(registro).getListaComidas().size(); i++) {
                if (restorantes.get(registro).getListaComidas().get(i).getNombreComida().equals(nombreComida)) {
                    datosResultado[registro][0] = restorantes.get(registro).getNombreRestorante();
                    datosResultado[registro][1] = restorantes.get(registro).getDireccion();
                    datosResultado[registro][2] = String.valueOf(restorantes.get(registro).getLatitud());
                    datosResultado[registro][3] = String.valueOf(restorantes.get(registro).getLongitud());
                }
            }
        }
        return datosResultado;
=======
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
