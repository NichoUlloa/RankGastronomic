package model;

public class Comida {

    private String nombreComida;
    private double precio;
    private String descripcion;

    //constructor
    public Comida(String nombreComida, double precio, String descripcion) {
        this.nombreComida = nombreComida;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    //getters y setters

    public String getNombreComida() {
        return nombreComida;
    }

    public void setNombreComida(String nombreComida) {
        this.nombreComida = nombreComida;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //metodo toString
    @Override
    public String toString() {
        return "Comida{" + "nombreComida=" + nombreComida + ", precio=" + precio + ", descripcion=" + descripcion + '}';
    }


}
