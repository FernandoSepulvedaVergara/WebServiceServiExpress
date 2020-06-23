package clases;

public class Pedidos {
    private int idPedido;
    private int cantidad;
    private int precioCompra;
    private int totalAPagar;
    private int idProducto;
    private String descripcion;
    private String marca;
    private String fechaDeVencimiento;

    public Pedidos(int idPedido, int cantidad, int precioCompra, int totalAPagar, int idProducto, String descripcion, String marca, String fechaDeVencimiento) {
        this.idPedido = idPedido;
        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
        this.totalAPagar = totalAPagar;
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.marca = marca;
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    public Pedidos() {
        this.idPedido = 0;
        this.cantidad = 0;
        this.precioCompra = 0;
        this.totalAPagar = 0;
        this.idProducto = 0;
        this.descripcion = null;
        this.marca = null;
        this.fechaDeVencimiento = null;
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

    public int getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getTotalAPagar() {
        return totalAPagar;
    }

    public void setTotalAPagar(int totalAPagar) {
        this.totalAPagar = totalAPagar;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }

    public void setFechaDeVencimiento(String fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
    }    
}
