package clases;

public class EstadoDeAtencion {

    private int idEstadoDeAtencion;
    private String estado;

    public EstadoDeAtencion(int idEstadoDeAtencion, String estado) {
        this.idEstadoDeAtencion = idEstadoDeAtencion;
        this.estado = estado;
    }

    public EstadoDeAtencion() {
        this.idEstadoDeAtencion = 0;
        this.estado = null;
    }

    public int getIdEstadoDeAtencion() {
        return idEstadoDeAtencion;
    }

    public void setIdEstadoDeAtencion(int idEstadoDeAtencion) {
        this.idEstadoDeAtencion = idEstadoDeAtencion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
