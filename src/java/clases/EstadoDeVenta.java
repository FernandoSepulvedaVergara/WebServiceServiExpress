package clases;
public class EstadoDeVenta {

    private int idEstadoDeVenta;
    private String estado;

    public EstadoDeVenta(int idEstadoDeVenta, String estado) {
        this.idEstadoDeVenta = idEstadoDeVenta;
        this.estado = estado;
    }
    
    public EstadoDeVenta() {
        this.idEstadoDeVenta = 0;
        this.estado = null;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdEstadoDeVenta() {
        return idEstadoDeVenta;
    }

    public void setIdEstadoDeVenta(int idEstadoDeVenta) {
        this.idEstadoDeVenta = idEstadoDeVenta;
    }
}
