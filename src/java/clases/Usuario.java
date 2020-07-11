package clases;

public class Usuario {
private String rut;
private String primerNombre;
private String segundoNombre;
private String apellidoPaterno;
private String apellidoMaterno;
private int telefono;
private String email;
private String direccion;
private String nombreUsuario;
private String contraseña;
private TipoDeUsuario tipoUsuario;
private Comuna comuna;
private Region region;
private EstadoDeUsuario estadoDeUsuario;

    public Usuario(String rut, String primerNombre, String segundoNombre, String apellidoPaterno, String apellidoMaterno, int telefono, String email, String direccion, String nombreUsuario, String contraseña, TipoDeUsuario tipoUsuario, Comuna comuna, Region region, EstadoDeUsuario estadoDeUsuario) {
        this.rut = rut;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.tipoUsuario = tipoUsuario;
        this.comuna = comuna;
        this.region = region;
        this.estadoDeUsuario = estadoDeUsuario;
    }

    public Usuario() {
        this.rut = null;
        this.primerNombre = null;
        this.segundoNombre = null;
        this.apellidoPaterno = null;
        this.apellidoMaterno = null;
        this.telefono = 0;
        this.email = null;
        this.direccion = null;
        this.nombreUsuario = null;
        this.contraseña = null;
        this.tipoUsuario = null;
        this.comuna = null;
        this.region = null;
        this.estadoDeUsuario = null;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public TipoDeUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoDeUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Comuna getComuna() {
        return comuna;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }

    public EstadoDeUsuario getEstadoDeUsuario() {
        return estadoDeUsuario;
    }

    public void setEstadoDeUsuario(EstadoDeUsuario estadoDeUsuario) {
        this.estadoDeUsuario = estadoDeUsuario;
    }
    
}
