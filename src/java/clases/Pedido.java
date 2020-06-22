package clases;

public class Pedido {
    private int idPedido;
    private int cantidad;
    private int totalAPagar;
    private int idOrdenDePedido;
    private int idProductoProveedor;

    public Pedido(int idPedido, int cantidad, int totalAPagar, int idOrdenDePedido, int idProductoProveedor) {
        this.idPedido = idPedido;
        this.cantidad = cantidad;
        this.totalAPagar = totalAPagar;
        this.idOrdenDePedido = idOrdenDePedido;
        this.idProductoProveedor = idProductoProveedor;
    }

    public Pedido() {
        this.idPedido = 0;
        this.cantidad = 0;
        this.totalAPagar = 0;
        this.idOrdenDePedido = 0;
        this.idProductoProveedor = 0;    
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTotalAPagar() {
        return totalAPagar;
    }

    public void setTotalAPagar(int totalAPagar) {
        this.totalAPagar = totalAPagar;
    }

    public int getIdOrdenDePedido() {
        return idOrdenDePedido;
    }

    public void setIdOrdenDePedido(int idOrdenDePedido) {
        this.idOrdenDePedido = idOrdenDePedido;
    }

    public int getIdProductoProveedor() {
        return idProductoProveedor;
    }

    public void setIdProductoProveedor(int idProductoProveedor) {
        this.idProductoProveedor = idProductoProveedor;
    }
}
