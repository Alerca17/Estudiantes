package aca.Dominio;

public class Estudiante {

    private int idEstudiante;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;

    public Estudiante(String apellido, String correo, int idEstudiante, String nombre, String telefono) {
        this.apellido = apellido;
        this.correo = correo;
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Estudiante(String apellido, String correo, String nombre, String telefono) {
        this.apellido = apellido;
        this.correo = correo;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Estudiante() {
    }

    public Estudiante(int idEstudiante) {

        this.idEstudiante = idEstudiante;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
               "idEstudiante=" + idEstudiante +
               ", nombre='" + nombre + '\'' +
               ", apellido='" + apellido + '\'' +
               ", correo='" + correo + '\'' +
               ", telefono='" + telefono + '\'' +
               '}';
    }
}
