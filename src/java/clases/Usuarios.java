package clases;

public class Usuarios {
    private TipoDeUsuario tipoDeUsuario;
    private String rut;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private EstadoDeUsuario estadoDeUsuario;

    public Usuarios(TipoDeUsuario tipoDeUsuario, String rut, String nombre, String apellidoPaterno, String apellidoMaterno, EstadoDeUsuario estadoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.estadoDeUsuario = estadoDeUsuario;
    }

    public Usuarios() {
        this.tipoDeUsuario = null;
        this.rut = null;
        this.nombre = null;
        this.apellidoPaterno = null;
        this.apellidoMaterno = null;
        this.estadoDeUsuario = null;
    }

    public TipoDeUsuario getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(TipoDeUsuario tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public EstadoDeUsuario getEstadoDeUsuario() {
        return estadoDeUsuario;
    }

    public void setEstadoDeUsuario(EstadoDeUsuario estadoDeUsuario) {
        this.estadoDeUsuario = estadoDeUsuario;
    }    
}
