package servicios;

import clases.Comuna;
import clases.EstadoDePedido;
import clases.OrdenDePedido;
import clases.Pedido;
import clases.Pedidos;
import clases.Producto;
import clases.ProductoProveedor;
import clases.Proveedor;
import clases.Region;
import clases.Sucursal;
import clases.TipoDeProducto;
import clases.TipoDeUsuario;
import clases.Usuario;
import clases.Usuarios;
import conexion.conexion;
import controlador.controladorAdministrador;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "WebServiceAdministrador")
public class WebServiceAdministrador {

    @WebMethod(operationName = "GetTipoDeProducto")
    public TipoDeProducto[] GetTipoDeProducto() {
        return controladorAdministrador.GetTipoDeProducto(conexion.getConnection());
    }
    
    @WebMethod(operationName = "GetProductos")
    public Producto[] GetProductos(@WebParam(name = "idTipoDeProducto") int idTipoDeProducto) {
        return  controladorAdministrador.GetProductos(conexion.getConnection(),idTipoDeProducto);
    }
    
    @WebMethod(operationName = "GetProductosProveedor")
    public ProductoProveedor[] GetProductosProveedor(@WebParam(name = "idTipoDeProducto") int idTipoDeProducto,@WebParam(name = "rutProveedor") String rutProveedor) {
        return controladorAdministrador.GetProductosProveedor(conexion.getConnection(),idTipoDeProducto, rutProveedor);
    }
    
    @WebMethod(operationName = "GetInfoProducto")
    public Producto GetInfoProducto(@WebParam(name = "idProducto") int idProducto) {
        return controladorAdministrador.GetInfoProducto(conexion.getConnection(),idProducto);
    }
    
    @WebMethod(operationName = "GetInfoProductoProveedor")
    public ProductoProveedor GetInfoProductoProveedor(@WebParam(name = "idProductoProveedor") int idProductoProveedor, @WebParam(name = "rutProveedor") String rutProveedor) {
        return controladorAdministrador.GetInfoProductoProveedor(conexion.getConnection(),idProductoProveedor,rutProveedor);
    }
    
    @WebMethod(operationName = "GetProveedores")
    public Proveedor[]  GetProveedores() {
        return controladorAdministrador.GetProveedores(conexion.getConnection());
    }
   
    @WebMethod(operationName = "GetOrdenesDePedido")
    public OrdenDePedido[]  GetOrdenesDePedido(@WebParam(name = "filtroSeleccionarTodosLosPedidos") boolean filtroSeleccionarTodosLosPedidos,
                                               @WebParam(name = "filtroBuscar") boolean filtroBuscar,
                                               @WebParam(name = "filtroEstado") boolean filtroEstado,
                                               @WebParam(name = "tipoDeBusqueda") String tipoDeBusqueda,
                                               @WebParam(name = "valorFiltro") String valorFiltro) {
        return controladorAdministrador.GetOrdenesDePedido(conexion.getConnection(),filtroSeleccionarTodosLosPedidos,filtroBuscar,filtroEstado,tipoDeBusqueda,valorFiltro);
    }
    
     @WebMethod(operationName = "GetOrdenDePedido")
    public OrdenDePedido  GetOrdenDePedido(@WebParam(name = "idOrdenDePedido") int idOrdenDePedido) {
       
        return controladorAdministrador.GetOrdenDePedido(conexion.getConnection(),idOrdenDePedido);
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
        return controladorAdministrador.RegistrarOrdenDePedido(conexion.getConnection(),ordenDePedido);
    }

     @WebMethod(operationName = "RegistrarPedido")
    public String[]  RegistrarPedido(@WebParam(name = "cantidad") int cantidad,@WebParam(name = "totalAPagar") int totalAPagar,@WebParam(name = "idOrdenPedido") int idOrdenPedido,@WebParam(name = "idProductoProveedor") int idProductoProveedor) {
       Pedido pedido = new Pedido();
        pedido.setCantidad(cantidad);
        pedido.setTotalAPagar(totalAPagar);
        pedido.setIdOrdenDePedido(idOrdenPedido);
        pedido.setIdProductoProveedor(idProductoProveedor);
        return controladorAdministrador.RegistrarPedido(conexion.getConnection(),pedido);
    }
    
    @WebMethod(operationName = "GetPedidos")
    public Pedidos[] GetPedidos(@WebParam(name = "idOrdenDePedido") int idOrdenDePedido) {
        
        return controladorAdministrador.GetPedidos(conexion.getConnection(),idOrdenDePedido);
    }
    
    @WebMethod(operationName = "ActualizarEstadoPedido")
    public boolean ActualizarEstadoPedido(@WebParam(name = "idOrdenDePedido") int idOrdenDePedido,@WebParam(name = "idEstado") int idEstado) {
        
        return controladorAdministrador.ActualizarEstadoPedido(conexion.getConnection(),idOrdenDePedido, idEstado);
    }
    
    @WebMethod(operationName = "ActualizarProductosCancelarPedido")
    public String[] ActualizarProductosCancelarPedido(@WebParam(name = "idProductoProveedor") int idProductoProveedor,@WebParam(name = "cantidad") int cantidad) {
        
        return controladorAdministrador.ActualizarProductosCancelarPedido(conexion.getConnection(),idProductoProveedor, cantidad);
    }
    
    @WebMethod(operationName = "ActualizarProductosEntregarPedido")
    public String[] ActualizarProductosEntregarPedido(@WebParam(name = "idOrdenDePedido") int idOrdenDePedido) {
        
        return controladorAdministrador.ActualizarProductosEntregarPedido(conexion.getConnection(),idOrdenDePedido);
    }
    
    @WebMethod(operationName = "ActualizarEstadoProducto")
    public boolean ActualizarEstadoProducto(@WebParam(name = "idProducto") int idProducto,@WebParam(name = "idEstado") int idEstado) {
        
        return controladorAdministrador.ActualizarEstadoProducto(conexion.getConnection(),idProducto,idEstado);
    }
    
    @WebMethod(operationName = "SeleccionarTodosLosUsuarios")
    public Usuarios[] SeleccionarTodosLosUsuarios() {        
        return controladorAdministrador.SeleccionarTodosLosUsuarios(conexion.getConnection());
    }
    
    @WebMethod(operationName = "FiltrarPorUsuario")
    public Usuarios[] FiltrarPorUsuario(@WebParam(name = "filtroAdministrado") boolean filtroAdministrador,@WebParam(name = "filtroCliente") boolean filtroCliente,@WebParam(name = "filtroEmpleado") boolean filtroEmpleado) {        
        return controladorAdministrador.FiltrarPorUsuario(conexion.getConnection(),filtroAdministrador,filtroCliente,filtroEmpleado);
    }
    
    @WebMethod(operationName = "FiltrarPorRut")
    public Usuarios[] FiltrarPorRut(@WebParam(name = "rut") String rut) {        
        return controladorAdministrador.FiltrarPorRut(conexion.getConnection(),rut);
    }
    
    @WebMethod(operationName = "GetInfoUsuario")
    public Usuario GetInfoUsuario(@WebParam(name = "rut") String rut) {        
        return controladorAdministrador.GetInfoUsuario(conexion.getConnection(),rut);
    }
    
    @WebMethod(operationName = "ActualizarEstadoUsuario")
    public boolean ActualizaEstadoUsuario(@WebParam(name = "rut") String rut,@WebParam(name = "idEstadoDeUsuario") int idEstadoDeUsuario) {        
        return controladorAdministrador.ActualizarEstadoDeUsuario(conexion.getConnection(),rut,idEstadoDeUsuario);
    }
    
    @WebMethod(operationName = "ActualizarUsuario")
    public String[] ActualizarUsuario(@WebParam(name = "actualizarUsuario") Usuario actualizarUsuario, @WebParam(name = "rut") String rut, @WebParam(name = "nombreUsuario") String nombreUsuario) {        
        return controladorAdministrador.ActualizarUsuario(conexion.getConnection(),actualizarUsuario, rut, nombreUsuario);
    }
    
    @WebMethod(operationName = "GetRegiones")
    public Region[] GetRegiones(){        
        return controladorAdministrador.GetRegiones(conexion.getConnection());
    }
    
    @WebMethod(operationName = "GetComunas")
    public Comuna[] GetComunas(@WebParam(name = "idRegion") int idRegion){        
        return controladorAdministrador.GetComunas(conexion.getConnection(), idRegion);
    }
    
    @WebMethod(operationName = "GetTiposDeUsuario")
    public TipoDeUsuario[] GetTiposDeUsuario(){        
        return controladorAdministrador.GetTiposDeUsuario(conexion.getConnection());
    }
    
    @WebMethod(operationName = "RegistrarNuevoUsuario")
    public String[] RegistrarNuevoUsuario(@WebParam(name = "nuevoUsuario") Usuario nuevoUsuario){        
        return controladorAdministrador.RegistrarNuevoUsuario(conexion.getConnection(),nuevoUsuario);
    }
    
    @WebMethod(operationName = "GetGestionarProveedores")
    public Proveedor[] GetGestionarProveedores(@WebParam(name = "filtroTodosLosProveedores") boolean filtroTodosLosProveedores, @WebParam(name = "filtroRut") boolean filtroRut, @WebParam(name = "valorFiltro") String valorFiltro){        
        return controladorAdministrador.GetGestionarProveedores(conexion.getConnection(),filtroTodosLosProveedores,filtroRut,valorFiltro);
    }
    
    @WebMethod(operationName = "GetProveedor")
    public Proveedor GetProveedor(@WebParam(name = "rut") String rut){        
        return controladorAdministrador.GetProveedor(conexion.getConnection(), rut);
    }
    
    @WebMethod(operationName = "RegistrarNuevoProveedor")
    public String[] RegistrarNuevoProveedor(@WebParam(name = "nuevoProveedor") Proveedor nuevoProveedor){        
        return controladorAdministrador.RegistrarNuevoProveedor(conexion.getConnection(), nuevoProveedor);
    }
    
    @WebMethod(operationName = "ActualizarEstadoProveedor")
    public boolean ActualizarEstadoProveedor(@WebParam(name = "rutProveedor") String rutProveedor,@WebParam(name = "idEstadoDeProveedor") int idEstadoDeProveedor) {        
        return controladorAdministrador.ActualizarEstadoProveedor(conexion.getConnection(),rutProveedor,idEstadoDeProveedor);
    }
    
    @WebMethod(operationName = "GetSucursales")
    public Sucursal[] GetSucursales() {        
        return controladorAdministrador.GetSucursales(conexion.getConnection());
    }
    
    @WebMethod(operationName = "AgregarSucursal")
    public String[] AgregarSucursal(@WebParam(name = "sucursal") Sucursal sucursal) {        
        return controladorAdministrador.AgregarSucursal(conexion.getConnection(), sucursal);
    }
    
    @WebMethod(operationName = "EliminarSucursal")
    public String[] EliminarSucursal(@WebParam(name = "idSucursal") int idSucursal) {        
        return controladorAdministrador.EliminarSucursal(conexion.getConnection(), idSucursal);
    }
}
