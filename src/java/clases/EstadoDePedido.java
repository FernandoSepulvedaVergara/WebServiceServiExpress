package clases;

public class EstadoDePedido {
  
    private int idEstadoPedido;
    private String estado;

    public EstadoDePedido(int idEstadoPedido, String estado) {
        this.idEstadoPedido = idEstadoPedido;
        this.estado = estado;
    }

    public EstadoDePedido() {
        this.idEstadoPedido = 0;
        this.estado = null;
    }

    public int getIdEstadoPedido() {
        return idEstadoPedido;
    }

    public void setIdEstadoPedido(int idEstadoPedido) {
        this.idEstadoPedido = idEstadoPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
