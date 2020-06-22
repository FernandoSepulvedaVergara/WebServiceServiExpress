package clases;

public class Proveedor {

    private String rutProveedor;
    private String razonSocial;
    private int telefono;
    private String email;
    private String nombreUsuario;
    private String contraseña;
    private int tipoDeUsuario;

    public Proveedor(String rutProveedor, String razonSocial, int telefono, String email, String nombreUsuario, String contraseña, int tipoDeUsuario) {
        this.rutProveedor = rutProveedor;
        this.razonSocial = razonSocial;
        this.telefono = telefono;
        this.email = email;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public Proveedor() {
        this.rutProveedor = null;
        this.razonSocial = null;
        this.telefono = 0;
        this.email = null;
        this.nombreUsuario = null;
        this.contraseña = null;
        this.tipoDeUsuario = 2;        
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

    public int getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(int tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }
    
    
}
