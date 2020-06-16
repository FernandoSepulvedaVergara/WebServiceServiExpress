package clases;
public class Ventas {
    
    private int id_venta;
    private int montoAPagar;
    private int montoPagado;
    private String fecha;
    private EstadoDeVenta estadoDeVenta;
    private String rut;
    private int idAtencion;
    private int idDocumento;
    private String patente;

    public Ventas(int id_venta, int montoAPagar, int montoPagado, String fecha, EstadoDeVenta estadoDeVenta, String rut, int idAtencion, int idDocumento) {
        this.id_venta = id_venta;
        this.montoAPagar = montoAPagar;
        this.montoPagado = montoPagado;
        this.fecha = fecha;
        this.estadoDeVenta = estadoDeVenta;
        this.rut = rut;
        this.idAtencion = idAtencion;
        this.idDocumento = idDocumento;
    }
    public Ventas() {
        this.id_venta = 0;
        this.montoAPagar = 0;
        this.montoPagado = 0;
        this.fecha = null;
        this.estadoDeVenta = null;
        this.rut = null;
        this.idAtencion = 0;
        this.idDocumento = 0;
        this.patente = null;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getMontoAPagar() {
        return montoAPagar;
    }

    public void setMontoAPagar(int montoAPagar) {
        this.montoAPagar = montoAPagar;
    }

    public int getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(int montoPagado) {
        this.montoPagado = montoPagado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public EstadoDeVenta getEstadoDeVenta() {
        return estadoDeVenta;
    }

    public void setEstadoDeVenta(EstadoDeVenta estadoDeVenta) {
        this.estadoDeVenta = estadoDeVenta;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getIdAtencion() {
        return idAtencion;
    }

    public void setIdAtencion(int idAtencion) {
        this.idAtencion = idAtencion;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }
    
    
}

