package servicios;

import clases.EstadoDeProducto;
import clases.OrdenDePedido;
import clases.Pedidos;
import clases.ProductoProveedor;
import clases.Proveedor;
import clases.TipoDeProducto;
import controlador.controladorAdministrador;
import controlador.controladorProveedor;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "WebServiceProveedor")
public class WebServiceProveedor {

   @WebMethod(operationName = "GetTipoDeProducto")
    public TipoDeProducto[] GetTipoDeProducto() {
        return controladorProveedor.GetTipoDeProducto(conexion.conexion.getConnection());
    }
    
    @WebMethod(operationName = "GetProductosProveedor")
    public ProductoProveedor[] GetProductosProveedor(@WebParam(name = "idTipoDeProducto") int idTipoDeProducto,@WebParam(name = "rutProveedor") String rutProveedor) {
        return controladorProveedor.GetProductosProveedor(conexion.conexion.getConnection(), idTipoDeProducto, rutProveedor);
    }
    
    @WebMethod(operationName = "ObtenerInfoProductoProveedor")
    public ProductoProveedor ObtenerInfoProductoProveedor(@WebParam(name = "idTipoDeProducto") int idProductoProveedor,@WebParam(name = "rutProveedor") String rutProveedor){
        return controladorProveedor.GetInfoProductoProveedor(conexion.conexion.getConnection(), idProductoProveedor, rutProveedor);
    }
    
    @WebMethod(operationName = "ActualizarEstadoProductoProveedor")
    public boolean ActualizarEstadoProductoProveedor(@WebParam(name = "idProductoProveedor") int idProductoProveedor,@WebParam(name = "idEstado") int idEstado){
        return controladorProveedor.ActualizarEstadoProductoProveedor(conexion.conexion.getConnection(), idProductoProveedor, idEstado);
    }
    
    @WebMethod(operationName = "ActualizarProductoProveedor")
    public String[] ActualizarProductoProveedor(@WebParam(name = "idProductoProveedor") int idProductoProveedor,@WebParam(name = "fechaDeVencimiento") String fechaDeVencimiento,@WebParam(name = "stock") int stock,@WebParam(name = "precioDeCompra") int precioDeCompra ){
        return controladorProveedor.ActualizarProductoProveedor(conexion.conexion.getConnection(), idProductoProveedor, fechaDeVencimiento,stock,precioDeCompra);
    }
    
    @WebMethod(operationName = "AgregarNuevoTipoDeProducto")
    public String[] AgregarNuevoTipoDeProducto(@WebParam(name = "tipoDeProducto") String tipoDeProducto){
        return controladorProveedor.AgregarNuevoTipoDeProducto(conexion.conexion.getConnection(),tipoDeProducto);
    }
    
    @WebMethod(operationName = "RegistrarNuevoProductoProveedor")
    public String[] RegistrarNuevoProductoProveedor(@WebParam(name = "descripcion") String descripcion,@WebParam(name = "marca") String marca,@WebParam(name = "fechaDeVencimiento") String fechaDeVencimiento,@WebParam(name = "precioDeCompra") int precioDeCompra,@WebParam(name = "stock") int stock,@WebParam(name = "idTipoDeProducto") int idTipoDeProducto,@WebParam(name = "rutProveedor") String rutProveedor,@WebParam(name = "idEstadoDeProducto") int idEstadoDeProducto){
        ProductoProveedor productoProveedor = new ProductoProveedor();        
        productoProveedor.setDescripcion(descripcion);
        productoProveedor.setMarca(marca);
        productoProveedor.setFechaDeVencimiento(fechaDeVencimiento);
        productoProveedor.setPrecioDeCompra(precioDeCompra);
        productoProveedor.setStock(stock);
        productoProveedor.setIdTipoDeProducto(idTipoDeProducto);
        productoProveedor.setRutProveedor(rutProveedor);
            EstadoDeProducto estadoDeProducto = new EstadoDeProducto();
            estadoDeProducto.setIdEstadoDeProducto(idEstadoDeProducto);
        productoProveedor.setEstadoDeProducto(estadoDeProducto);
        return controladorProveedor.RegistrarNuevoProductoProveedor(conexion.conexion.getConnection(),productoProveedor);
    }
    @WebMethod(operationName = "GetOrdenesDePedidoProveedor")
    public OrdenDePedido[]  GetOrdenesDePedidoProveedor(@WebParam(name = "filtroSeleccionarTodosLosPedidos") boolean filtroSeleccionarTodosLosPedidos,
                                                        @WebParam(name = "filtroBuscar") boolean filtroBuscar,
                                                        @WebParam(name = "filtroEstado") boolean filtroEstado,
                                                        @WebParam(name = "tipoDeBusqueda") String tipoDeBusqueda,
                                                        @WebParam(name = "valorFiltro") String valorFiltro,
                                                        @WebParam(name = "rutProveedor") String rutProveedor) {
        return controladorProveedor.GetOrdenesDePedidoProveedor(conexion.conexion.getConnection(),filtroSeleccionarTodosLosPedidos,filtroBuscar,filtroEstado,tipoDeBusqueda,valorFiltro,rutProveedor);
    }
    
    @WebMethod(operationName = "GetOrdenDePedidoProveedor")
    public OrdenDePedido  GetOrdenDePedidoProveedor(@WebParam(name = "idOrdenDePedido") int idOrdenDePedido) {
       
        return controladorProveedor.GetOrdenDePedidoProveedor(conexion.conexion.getConnection(),idOrdenDePedido);
    }
    
    @WebMethod(operationName = "GetPedidosProveedor")
    public Pedidos[] GetPedidosProveedor(@WebParam(name = "idOrdenDePedido") int idOrdenDePedido) {
        
        return controladorProveedor.GetPedidosProveedor(conexion.conexion.getConnection(),idOrdenDePedido);
    }
    
    @WebMethod(operationName = "ActualizarEstadoPedido")
    public boolean ActualizarEstadoPedido(@WebParam(name = "idOrdenDePedido") int idOrdenDePedido,@WebParam(name = "idEstado") int idEstado) {
        
        return controladorProveedor.ActualizarEstadoPedido(conexion.conexion.getConnection(),idOrdenDePedido, idEstado);
    }
    
    @WebMethod(operationName = "ActualizarProductosAprobarPedido")
    public String[] ActualizarProductosAprobarPedido(@WebParam(name = "idProductoProveedor") int idProductoProveedor,@WebParam(name = "cantidad") int cantidad) {
        
        return controladorProveedor.ActualizarProductosAprobarPedido(conexion.conexion.getConnection(),idProductoProveedor, cantidad);
    }
    
    @WebMethod(operationName = "GetInfoUsuarioProveedor")
    public Proveedor GetInfoUsuarioProveedor(@WebParam(name = "rutProveedor") String rutProveedor) {        
        return controladorProveedor.GetInfoUsuarioProveedor(conexion.conexion.getConnection(),rutProveedor);
    }
    
    @WebMethod(operationName = "ActualizarUsuarioProveedor")
    public String[] ActualizarUsuarioProveedor(@WebParam(name = "actualizarUsuarioProveedor") Proveedor actualizarUsuarioProveedor,@WebParam(name = "rutProveedor") String rutProveedor,@WebParam(name = "nombreDeUsuario") String nombreDeUsuario) {        
        return controladorProveedor.ActualizarUsuarioProveedor(conexion.conexion.getConnection(),actualizarUsuarioProveedor,rutProveedor,nombreDeUsuario);
    }
}
