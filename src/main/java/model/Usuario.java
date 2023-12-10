package model;

public class Usuario extends Ubicacion{

    private String NombreUsuario;
    private String apellidoUsuario;
    private String correoUsuario;
    private String contraseñaUsuario;
    private String nickUsuario;
    private String ciudad;

    //constructor
    public Usuario(String NombreUsuario, String apellidoUsuario, String correoUsuario, String contraseñaUsuario, String nickUsuario, String ciudad, double latitud, double longitud) {
        super(latitud, longitud);
        this.NombreUsuario = NombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.correoUsuario = correoUsuario;
        this.contraseñaUsuario = contraseñaUsuario;
        this.nickUsuario = nickUsuario;
        this.ciudad = ciudad;
    }

    //getters y setters

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getContraseñaUsuario() {
        return contraseñaUsuario;
    }

    public void setContraseñaUsuario(String contraseñaUsuario) {
        this.contraseñaUsuario = contraseñaUsuario;
    }

    public String getNickUsuario() {
        return nickUsuario;
    }

    public void setNickUsuario(String nickUsuario) {
        this.nickUsuario = nickUsuario;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    //metodo toString
    @Override
    public String toString() {
        return "Usuario{" + "NombreUsuario=" + NombreUsuario + ", apellidoUsuario=" + apellidoUsuario + ", correoUsuario=" + correoUsuario + ", contraseñaUsuario=" + contraseñaUsuario + ", nickUsuario=" + nickUsuario + ", ciudad=" + ciudad + '}';
    }


}
