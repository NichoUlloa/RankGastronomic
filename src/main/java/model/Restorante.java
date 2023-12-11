package model;

import java.util.ArrayList;
import java.util.List;

public class Restorante extends Ubicacion {

    private String nombreRestorante;
    private List<Comida> listaComidas;
    private String direccion;
    private List<Reseña> listaReseña;
    //constructor
    public Restorante(String nombreRestorante, String direccion, double latitud, double longitud, List<Reseña> listaReseña,List<Comida> listaComidas) {
        super(latitud, longitud);
        this.nombreRestorante = nombreRestorante;
        this.direccion = direccion;
        this.listaComidas = listaComidas;
        this.listaReseña = listaReseña;
    }

    public Restorante(String nombreRestorante, String direccion, double latitud, double longitud, String listaReseñaString, String listaComidasString) {
        super(latitud, longitud);
        this.nombreRestorante = nombreRestorante;
        this.direccion = direccion;
        this.listaComidas = convertirStringAListaComidas(listaComidasString);
        this.listaReseña = convertirStringAListaReseña(listaReseñaString);
    }

    //getters y setters
    public String getNombreRestorante() {
        return nombreRestorante;
    }

    public void setNombreRestorante(String nombreRestorante) {
        this.nombreRestorante = nombreRestorante;
    }

    public List<Comida> getListaComidas() {
        return listaComidas;
    }

    public void setListaComidas(List<Comida> listaComidas) {
        this.listaComidas = listaComidas;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public List<Reseña> getListaReseña() {
        return listaReseña;
    }
    public void setListaReseña(List<Reseña> listaReseña) {
        this.listaReseña = listaReseña;
    }

    //metodo agregar comida a la lista de comidas del restorante, validando que la comida exista en la lista de comidas
    public void agregarComida(Comida comida) {
        if (listaComidas.contains(comida)) {
            System.out.println("La comida ya existe en la lista de comidas del restorante");
        } else {
            listaComidas.add(comida);
        }
    }

    //metodo eliminar comida de la lista de comidas del restorante, validando que la comida exista en la lista de comidas
    public void eliminarComida(Comida comida) {
        if (listaComidas.contains(comida)) {
            listaComidas.remove(comida);
        } else {
            System.out.println("La comida no existe en la lista de comidas del restorante");
        }
    }
    public String listaReseñaToString() {
        String listaReseñaString = "";
        for (Reseña reseña : listaReseña) {
            listaReseñaString += reseña.toString() + "\n";
        }
        return listaReseñaString;
    }
    public String listaComidasToString() {
        String listaComidasString = "";
        for (Comida comida : listaComidas) {
            listaComidasString += comida.toString() + "\n";
        }
        return listaComidasString;
    }
    private List<Reseña> convertirStringAListaReseña(String listaReseñaString) {
        List<Reseña> listaReseña = new ArrayList<>();
        String[] listaReseñaArray = listaReseñaString.split("\n");
        for (String reseñaString : listaReseñaArray) {
            String[] reseñaArray = reseñaString.split(",");
            listaReseña.add(new Reseña(reseñaArray[0], Integer.parseInt(reseñaArray[1])));
        }
        return listaReseña;
    }
    private List<Comida> convertirStringAListaComidas(String listaComidasString) {
        List<Comida> listaComidas = new ArrayList<>();
        String[] comidas = listaComidasString.split("\n");
        for (String comida : comidas) {
            String[] partes = comida.split(",");
            if (partes.length >= 3) {
                String nombre = partes[0];
                double precio = Double.parseDouble(partes[1]);
                String descripcion = partes[2];
                listaComidas.add(new Comida(nombre, precio, descripcion));
            }
        }
        return listaComidas;
    }
}
