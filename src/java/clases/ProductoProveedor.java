package clases;

public class ProductoProveedor {

    private int idProducto;
    private String descripcion;
    private String marca;
    private String fechaDeVencimiento;
    private int precioDeCompra;
    private int stock;
    private int idTipoDeProducto;
    private String rutProveedor;

    public ProductoProveedor(int idProducto, String descripcion, String marca, String fechaDeVencimiento, int precioDeCompra, int stock, int idTipoDeProducto, String rutProveedor) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.marca = marca;
        this.fechaDeVencimiento = fechaDeVencimiento;
        this.precioDeCompra = precioDeCompra;
        this.stock = stock;
        this.idTipoDeProducto = idTipoDeProducto;
        this.rutProveedor = rutProveedor;
    }

    public ProductoProveedor() {
        this.idProducto = 0;
        this.descripcion = null;
        this.marca = null;
        this.fechaDeVencimiento = null;
        this.precioDeCompra = 0;
        this.stock = 0;
        this.idTipoDeProducto = 0;
        this.rutProveedor = null;
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

    public int getPrecioDeCompra() {
        return precioDeCompra;
    }

    public void setPrecioDeCompra(int precioDeCompra) {
        this.precioDeCompra = precioDeCompra;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getIdTipoDeProducto() {
        return idTipoDeProducto;
    }

    public void setIdTipoDeProducto(int tipoDeProducto) {
        this.idTipoDeProducto = tipoDeProducto;
    }

    public String getRutProveedor() {
        return rutProveedor;
    }

    public void setRutProveedor(String rutProveedor) {
        this.rutProveedor = rutProveedor;
    }
}
