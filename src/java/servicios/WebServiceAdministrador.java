package servicios;

import clases.EstadoDePedido;
import clases.OrdenDePedido;
import clases.Pedido;
import clases.Pedidos;
import clases.Producto;
import clases.ProductoProveedor;
import clases.Proveedor;
import clases.TipoDeProducto;
import clases.Usuario;
import clases.Usuarios;
import controlador.controladorAdministrador;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "WebServiceAdministrador")
public class WebServiceAdministrador {

    @WebMethod(operationName = "GetTipoDeProducto")
    public TipoDeProducto[] GetTipoDeProducto() {
        return controladorAdministrador.GetTipoDeProducto(conexion.conexion.getConnection());
    }
    
    @WebMethod(operationName = "GetProductos")
    public Producto[] GetProductos(@WebParam(name = "idTipoDeProducto") int idTipoDeProducto) {
        return  controladorAdministrador.GetProductos(conexion.conexion.getConnection(),idTipoDeProducto);
    }
    
    @WebMethod(operationName = "GetProductosProveedor")
    public ProductoProveedor[] GetProductosProveedor(@WebParam(name = "idTipoDeProducto") int idTipoDeProducto,@WebParam(name = "rutProveedor") String rutProveedor) {
        return controladorAdministrador.GetProductosProveedor(conexion.conexion.getConnection(),idTipoDeProducto, rutProveedor);
    }
    
    @WebMethod(operationName = "GetInfoProducto")
    public Producto GetInfoProducto(@WebParam(name = "idProducto") int idProducto) {
        return controladorAdministrador.GetInfoProducto(conexion.conexion.getConnection(),idProducto);
    }
    
    @WebMethod(operationName = "GetInfoProductoProveedor")
    public ProductoProveedor GetInfoProductoProveedor(@WebParam(name = "idProductoProveedor") int idProductoProveedor, @WebParam(name = "rutProveedor") String rutProveedor) {
        return controladorAdministrador.GetInfoProductoProveedor(conexion.conexion.getConnection(),idProductoProveedor,rutProveedor);
    }
    
    @WebMethod(operationName = "GetProveedores")
    public Proveedor[]  GetProveedores() {
        return controladorAdministrador.GetProveedores(conexion.conexion.getConnection());
    }
   
    @WebMethod(operationName = "GetOrdenesDePedido")
    public OrdenDePedido[]  GetOrdenesDePedido() {
        return controladorAdministrador.GetOrdenesDePedido(conexion.conexion.getConnection());
    }
    
     @WebMethod(operationName = "GetOrdenDePedido")
    public OrdenDePedido  GetOrdenDePedido(@WebParam(name = "idOrdenDePedido") int idOrdenDePedido) {
       
        return controladorAdministrador.GetOrdenDePedido(conexion.conexion.getConnection(),idOrdenDePedido);
    }
    
    @WebMethod(operationName = "RegistrarOrdenDePedido")
    public String[]  RegistrarOrdenDePedido(@WebParam(name = "fechaDePedido") String fechaDePedido, @WebParam(name = "total") int total,@WebParam(name = "usuarioRut") String usuarioRut,@WebParam(name = "idEstadoDePedido") int idEstadoDePedido,@WebParam(name = "rutProveedor") String rutProveedor) {
        
        OrdenDePedido ordenDePedido = new OrdenDePedido();
            EstadoDePedido estadoDePedido = new EstadoDePedido();
            estadoDePedido.setIdEstadoPedido(idEstadoDePedido);
        ordenDePedido.setFechaDePedido(fechaDePedido);
        ordenDePedido.setTotal(total);
        ordenDePedido.setUsuarioRut(usuarioRut);
        ordenDePedido.setEstadoDePedido(estadoDePedido);
        ordenDePedido.setRutProveedor(rutProveedor);
        return controladorAdministrador.RegistrarOrdenDePedido(conexion.conexion.getConnection(),ordenDePedido);
    }

     @WebMethod(operationName = "RegistrarPedido")
    public String[]  RegistrarPedido(@WebParam(name = "cantidad") int cantidad,@WebParam(name = "totalAPagar") int totalAPagar,@WebParam(name = "idOrdenPedido") int idOrdenPedido,@WebParam(name = "idProductoProveedor") int idProductoProveedor) {
       Pedido pedido = new Pedido();
        pedido.setCantidad(cantidad);
        pedido.setTotalAPagar(totalAPagar);
        pedido.setIdOrdenDePedido(idOrdenPedido);
        pedido.setIdProductoProveedor(idProductoProveedor);
        return controladorAdministrador.RegistrarPedido(conexion.conexion.getConnection(),pedido);
    }
    
    @WebMethod(operationName = "GetPedidos")
    public Pedidos[] GetPedidos(@WebParam(name = "idOrdenDePedido") int idOrdenDePedido) {
        
        return controladorAdministrador.GetPedidos(conexion.conexion.getConnection(),idOrdenDePedido);
    }
    
    @WebMethod(operationName = "ActualizarEstadoPedido")
    public boolean ActualizarEstadoPedido(@WebParam(name = "idOrdenDePedido") int idOrdenDePedido,@WebParam(name = "idEstado") int idEstado) {
        
        return controladorAdministrador.ActualizarEstadoPedido(conexion.conexion.getConnection(),idOrdenDePedido, idEstado);
    }
    
    @WebMethod(operationName = "ActualizarProductosCancelarPedido")
    public String[] ActualizarProductosCancelarPedido(@WebParam(name = "idProductoProveedor") int idProductoProveedor,@WebParam(name = "cantidad") int cantidad) {
        
        return controladorAdministrador.ActualizarProductosCancelarPedido(conexion.conexion.getConnection(),idProductoProveedor, cantidad);
    }
    
    @WebMethod(operationName = "ActualizarProductosEntregarPedido")
    public String[] ActualizarProductosEntregarPedido(@WebParam(name = "idOrdenDePedido") int idOrdenDePedido) {
        
        return controladorAdministrador.ActualizarProductosEntregarPedido(conexion.conexion.getConnection(),idOrdenDePedido);
    }
    
    @WebMethod(operationName = "ActualizarEstadoProducto")
    public boolean ActualizarEstadoProducto(@WebParam(name = "idProducto") int idProducto,@WebParam(name = "idEstado") int idEstado) {
        
        return controladorAdministrador.ActualizarEstadoProducto(conexion.conexion.getConnection(),idProducto,idEstado);
    }
    
    @WebMethod(operationName = "SeleccionarTodosLosUsuarios")
    public Usuarios[] SeleccionarTodosLosUsuarios() {        
        return controladorAdministrador.SeleccionarTodosLosUsuarios(conexion.conexion.getConnection());
    }
    
    @WebMethod(operationName = "FiltrarPorUsuario")
    public Usuarios[] FiltrarPorUsuario(@WebParam(name = "filtroAdministrado") boolean filtroAdministrador,@WebParam(name = "filtroCliente") boolean filtroCliente,@WebParam(name = "filtroEmpleado") boolean filtroEmpleado) {        
        return controladorAdministrador.FiltrarPorUsuario(conexion.conexion.getConnection(),filtroAdministrador,filtroCliente,filtroEmpleado);
    }
    
    @WebMethod(operationName = "FiltrarPorRut")
    public Usuarios[] FiltrarPorRut(@WebParam(name = "rut") String rut) {        
        return controladorAdministrador.FiltrarPorRut(conexion.conexion.getConnection(),rut);
    }
    
    @WebMethod(operationName = "GetInfoUsuario")
    public Usuario GetInfoUsuario(@WebParam(name = "rut") String rut) {        
        return controladorAdministrador.GetInfoUsuario(conexion.conexion.getConnection(),rut);
    }
    
    @WebMethod(operationName = "ActualizaEstadoUsuario")
    public Usuario ActualizaEstadoUsuario(@WebParam(name = "nombreUsuario") String nombreUsuario) {        
        return null;
    }
}
