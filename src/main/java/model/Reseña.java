package model;

public class Reseña {

    private String opinion;
    private int calificacion;

    //constructor
    public Reseña(String opinion, int calificacion) {
        this.opinion = opinion;
        this.calificacion = calificacion;
    }

    //getters y setters

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    //metodo toString
    @Override
    public String toString() {
        return "Reseña{" + "opinion=" + opinion + ", calificacion=" + calificacion + '}';
    }



}
