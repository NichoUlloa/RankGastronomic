package model;

import java.util.ArrayList;
import java.util.List;

public class Restorante extends Ubicacion {

    private String nombreRestorante;
    private List<Comida> listaComidas;
    private String direccion;
    private List<Reseña> reseñas;

    //constructor
    public Restorante(String nombreRestorante, List<Comida> listaComidas, String direccion, double latitud, double longitud, List<Reseña> reseñas) {
        super(latitud, longitud);
        this.nombreRestorante = nombreRestorante;
        this.listaComidas = new ArrayList<>();
        this.direccion = direccion;
        this.reseñas = new ArrayList<>();
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

    public List<Reseña> getReseñas() {
        return reseñas;
    };

    public void setReseñas(List<Reseña> reseñas) {
        this.reseñas = reseñas;
    };

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

    public void agregarReseña(Reseña reseña) {
        if(reseña == null){
            System.out.println("No se ha podido agregar la reseña");
        } else {
            reseñas.add(reseña);
        }
    }
}
