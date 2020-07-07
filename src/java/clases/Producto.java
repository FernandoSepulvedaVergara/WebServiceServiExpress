package clases;

public class Producto {

private int idProducto;
private String descripcion;
private String marca;
private String fechaVencimiento;
private int precioCompra;
private int precioVenta;
private int stock;
private int stockCritico;
private int idTipoDeProducto;
private int idOrdenDePedido;
private String rutProveedor;
private EstadoDeProducto estadoDeProducto;

    public Producto(int idProducto, String descripcion, String marca, String fechaVencimiento, int precioCompra, int precioVenta, int stock, int stockCritico, int idTipoDeProducto, int idOrdenDePedido, String rutProveedor, EstadoDeProducto estadoDeProducto) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.marca = marca;
        this.fechaVencimiento = fechaVencimiento;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stock = stock;
        this.stockCritico = stockCritico;
        this.idTipoDeProducto = idTipoDeProducto;
        this.idOrdenDePedido = idOrdenDePedido;
        this.rutProveedor = rutProveedor;
        this.estadoDeProducto = estadoDeProducto;
    }

    public Producto() {
    }

    public String getRutProveedor() {
        return rutProveedor;
    }

    public void setRutProveedor(String rutProveedor) {
        this.rutProveedor = rutProveedor;
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

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStockCritico() {
        return stockCritico;
    }

    public void setStockCritico(int stockCritico) {
        this.stockCritico = stockCritico;
    }

    public int getIdTipoDeProducto() {
        return idTipoDeProducto;
    }

    public void setIdTipoDeProducto(int idTipoDeProducto) {
        this.idTipoDeProducto = idTipoDeProducto;
    }

    public int getIdOrdenDePedido() {
        return idOrdenDePedido;
    }

    public void setIdOrdenDePedido(int idOrdenDePedido) {
        this.idOrdenDePedido = idOrdenDePedido;
    }

    public EstadoDeProducto getEstadoDeProducto() {
        return estadoDeProducto;
    }

    public void setEstadoDeProducto(EstadoDeProducto estadoDeProducto) {
        this.estadoDeProducto = estadoDeProducto;
    }
}
