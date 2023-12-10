package model;

import java.util.List;

public class Restorante extends Ubicacion {

    private String nombreRestorante;
    private List<Comida> listaComidas;
    private String direccion;

    //constructor
    public Restorante(String nombreRestorante, List<Comida> listaComidas, String direccion, double latitud, double longitud) {
        super(latitud, longitud);
        this.nombreRestorante = nombreRestorante;
        this.listaComidas = listaComidas;
        this.direccion = direccion;
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

}
