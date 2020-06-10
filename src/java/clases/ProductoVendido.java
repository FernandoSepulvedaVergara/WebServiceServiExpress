package clases;

public class ProductoVendido {
    
    private int id_producto_vendido;
    private int cantidad;
    private int total_a_pagar;
    private int producto_Id_producto;
    private int ventas_Id_venta;

    public ProductoVendido(int Id_producto_vendido, int Cantidad, int Total_a_pagar, int Producto_Id_producto, int Ventas_Id_venta) {
        this.id_producto_vendido = Id_producto_vendido;
        this.cantidad = Cantidad;
        this.total_a_pagar = Total_a_pagar;
        this.producto_Id_producto = Producto_Id_producto;
        this.ventas_Id_venta = Ventas_Id_venta;
    }

    public ProductoVendido() {
        this.id_producto_vendido = 0;
        this.cantidad = 0;
        this.total_a_pagar = 0;
        this.producto_Id_producto = 0;
        this.ventas_Id_venta = 0;
    }

    public int getId_producto_vendido() {
        return id_producto_vendido;
    }

    public void setId_producto_vendido(int id_producto_vendido) {
        this.id_producto_vendido = id_producto_vendido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTotal_a_pagar() {
        return total_a_pagar;
    }

    public void setTotal_a_pagar(int total_a_pagar) {
        this.total_a_pagar = total_a_pagar;
    }

    public int getProducto_Id_producto() {
        return producto_Id_producto;
    }

    public void setProducto_Id_producto(int producto_Id_producto) {
        this.producto_Id_producto = producto_Id_producto;
    }

    public int getVentas_Id_venta() {
        return ventas_Id_venta;
    }

    public void setVentas_Id_venta(int ventas_Id_venta) {
        this.ventas_Id_venta = ventas_Id_venta;
    }

}
