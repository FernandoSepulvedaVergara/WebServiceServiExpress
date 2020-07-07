package clases;

public class EstadoDeProducto {
   private int idEstadoDeProducto;
   private String estado;

    public EstadoDeProducto(int idEstadoDeProducto, String estado) {
        this.idEstadoDeProducto = idEstadoDeProducto;
        this.estado = estado;
    }

    public EstadoDeProducto() {
        this.idEstadoDeProducto = 0;
        this.estado = null;
    }

    public int getIdEstadoDeProducto() {
        return idEstadoDeProducto;
    }

    public void setIdEstadoDeProducto(int idEstadoDeProducto) {
        this.idEstadoDeProducto = idEstadoDeProducto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
   
}
