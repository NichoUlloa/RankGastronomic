package model;

import java.util.List;

public class RankGastronomic {

    private List<Restorante> listaRestaurantes;
    private List<Comida> listaComidas;
    private List<Usuario> listaUsuarios;
    private List<Reseña> listaReseñas;

    public RankGastronomic(List<Restorante> listaRestaurantes, List<Comida> listaComidas, List<Usuario> listaUsuarios, List<Reseña> listaReseñas) {
        this.listaRestaurantes = listaRestaurantes;
        this.listaComidas = listaComidas;
        this.listaUsuarios = listaUsuarios;
        this.listaReseñas = listaReseñas;
    }

    public List<Restorante> getListaRestaurantes() {
        return listaRestaurantes;
    }

    public void setListaRestaurantes(List<Restorante> listaRestaurantes) {
        this.listaRestaurantes = listaRestaurantes;
    }


    public List<Comida> getListaComidas() {
        return listaComidas;
    }

    public void setListaComidas(List<Comida> listaComidas) {
        this.listaComidas = listaComidas;
    }


    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }


    public List<Reseña> getListaReseñas() {
        return listaReseñas;
    }

    public void setListaReseñas(List<Reseña> listaReseñas) {
        this.listaReseñas = listaReseñas;
    }

    //methods

}
