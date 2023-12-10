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

    //metodo buscar restorante por nombre, validando que exista en la lista de restaurantes
    public Restorante buscarRestorante(String nombreRestorante) {
        for (Restorante restorante : listaRestaurantes) {
            if (restorante.getNombreRestorante().equals(nombreRestorante)) {
                return restorante;
            }
        }
        return null;
    }

    //metodo buscar comida por nombre, validando que exista en la lista de comidas
    public Comida buscarComida(String nombreComida) {
        for (Comida comida : listaComidas) {
            if (comida.getNombreComida().equals(nombreComida)) {
                return comida;
            }
        }
        return null;
    }

    //metodo agregar usuario a la lista de usuarios, validando que el usuario no exista en la lista de usuarios
    public void agregarUsuario(Usuario usuario) {
        if (listaUsuarios.contains(usuario)) {
            System.out.println("El usuario ya existe en la lista de usuarios");
        } else {
            listaUsuarios.add(usuario);
        }
    }

    //metodo eliminar usuario de la lista de usuarios, validando que el usuario exista en la lista de usuarios
    public void eliminarUsuario(Usuario usuario) {
        if (listaUsuarios.contains(usuario)) {
            listaUsuarios.remove(usuario);
        } else {
            System.out.println("El usuario no existe en la lista de usuarios");
        }
    }

    //metodo agregar restorante a la lista de restaurantes, validando que el restorante no exista en la lista de restaurantes
    public void agregarRestorante(Restorante restorante) {
        if (listaRestaurantes.contains(restorante)) {
            System.out.println("El restorante ya existe en la lista de restaurantes");
        } else {
            listaRestaurantes.add(restorante);
        }
    }

    //metodo eliminar restorante de la lista de restaurantes, validando que el restorante exista en la lista de restaurantes
    public void eliminarRestorante(Restorante restorante) {
        if (listaRestaurantes.contains(restorante)) {
            listaRestaurantes.remove(restorante);
        } else {
            System.out.println("El restorante no existe en la lista de restaurantes");
        }
    }

    //metodo calcular distancia entre usuario y restorante con latitud y longitud
    public double calcularDistancia(Ubicacion ubicacionUsuario, Ubicacion ubicacionRestorante) {
        double distancia = Math.sqrt(Math.pow(ubicacionUsuario.getLatitud() - ubicacionRestorante.getLatitud(), 2) + Math.pow(ubicacionUsuario.getLongitud() - ubicacionRestorante.getLongitud(), 2));
        return distancia;
    }

    public double calcularDistanciaUsuarioRestaurante(Restorante restorante, Usuario usuario) {

        double radioTierra = 6371;
        double distanciaLat = Math.toRadians(restorante.getLatitud() - usuario.getLatitud());
        double distanciaLng = Math.toRadians(restorante.getLongitud() - usuario.getLongitud());
        double sindLat = Math.sin(distanciaLat / 2);
        double sindLng = Math.sin(distanciaLng / 2);
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(usuario.getLatitud())) * Math.cos(Math.toRadians(restorante.getLatitud()));
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
        return radioTierra * va2;
    }

}
