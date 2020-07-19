package clases;

public class Proveedor {

    private String rutProveedor;
    private String razonSocial;
    private int telefono;
    private String email;
    private String nombreUsuario;
    private String contraseña;
    private TipoDeUsuario tipoDeUsuario;
    private EstadoDeUsuario estadoDeUsuario;

    public Proveedor(String rutProveedor, String razonSocial, int telefono, String email, String nombreUsuario, String contraseña, TipoDeUsuario tipoDeUsuario, EstadoDeUsuario estadoDeUsuario) {
        this.rutProveedor = rutProveedor;
        this.razonSocial = razonSocial;
        this.telefono = telefono;
        this.email = email;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.tipoDeUsuario = tipoDeUsuario;
        this.estadoDeUsuario = estadoDeUsuario;
    }

    public Proveedor() {
        this.rutProveedor = null;
        this.razonSocial = null;
        this.telefono = 0;
        this.email = null;
        this.nombreUsuario = null;
        this.contraseña = null;
        this.tipoDeUsuario = null; 
        this.estadoDeUsuario = null;
    }

    public String getRutProveedor() {
        return rutProveedor;
    }

    public void setRutProveedor(String rutProveedor) {
        this.rutProveedor = rutProveedor;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
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

    public TipoDeUsuario getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(TipoDeUsuario tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public EstadoDeUsuario getEstadoDeUsuario() {
        return estadoDeUsuario;
    }

    public void setEstadoDeUsuario(EstadoDeUsuario estadoDeUsuario) {
        this.estadoDeUsuario = estadoDeUsuario;
    }
}
