package servicios;

import clases.Atencion;
import clases.Atenciones;
import clases.EstadoDeAtencion;
import clases.EstadoDeVenta;
import clases.Producto;
import clases.ProductoVendido;
import clases.TipoDeDocumento;
import clases.TipoDeProducto;
import clases.TipoDeServicio;
import clases.Ventas;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import controlador.controladorEmpleado;

@WebService(serviceName = "WebServiceEmpleado")
public class WebServiceEmpleado {

    @WebMethod(operationName = "GetAtenciones")
    public Atenciones[] GetAtenciones(@WebParam(name = "id_sucursal") String id_sucursal, 
                                      @WebParam(name = "filtro") String filtro,
                                      @WebParam(name = "valorFiltro") String valorFiltro) {
        
        return controladorEmpleado.GetAtenciones(id_sucursal, filtro, valorFiltro);
    }
    
    @WebMethod(operationName = "GetTipoDeServicios")
    public TipoDeServicio[] GetTipoDeServicios() {
        
        return controladorEmpleado.GetTipoDeServicios(conexion.conexion.getConnection());
    }
    
    @WebMethod(operationName = "GetAtencion")
    public Atencion GetAtencion(@WebParam(name = "idReserva") int idReserva) {
        return controladorEmpleado.GetAtencion(conexion.conexion.getConnection(),idReserva);
    }
    
    @WebMethod(operationName = "RegistrarAtencion")
    public String[] RegistrarAtencion(@WebParam(name = "fechaAtencion") String fechaAtencion, 
                                      @WebParam(name = "horaAtencion") String horaAtencion,
                                      @WebParam(name = "idTipoDeServicio") int idTipoDeServicio,
                                      @WebParam(name = "idReserva") int idReserva,
                                      @WebParam(name = "idEstadoDeAtencion") int idEstadoDeAtencion) {
     
        TipoDeServicio tipoDeServicio = new TipoDeServicio();
        tipoDeServicio.setId_servicio(idTipoDeServicio);
        EstadoDeAtencion estadoDeAtencion = new EstadoDeAtencion();
        estadoDeAtencion.setIdEstadoDeAtencion(idEstadoDeAtencion);
        Atencion atencion = new Atencion();  
        atencion.setId_atencion(0);
        atencion.setFecha_atencion(fechaAtencion);
        atencion.setHora_atencion(horaAtencion);
        atencion.setTipo_de_servicio(tipoDeServicio);
        atencion.setId_reserva(idReserva);
        atencion.setEstado_de_atencion(estadoDeAtencion);
        return controladorEmpleado.RegistrarAtencion(conexion.conexion.getConnection(), atencion);
    }
    
    @WebMethod(operationName = "RegistrarVenta")
    public String[] RegistrarVenta(@WebParam(name = "idAtencion") int idAtencion,
                                   @WebParam(name = "idVenta") int idVenta,
                                   @WebParam(name = "montoAPagar") int montoAPagar,
                                   @WebParam(name = "montoPagado") int montoPagado,
                                   @WebParam(name = "fechaVenta") String fechaVenta,
                                   @WebParam(name = "idEstadoVenta") int idEstadoVenta, 
                                   @WebParam(name = "usuarioRut") String usuarioRut,
                                   @WebParam(name = "idDocumento") int idDocumento) {
     
        EstadoDeVenta estadoDeVenta = new EstadoDeVenta();
        estadoDeVenta.setIdEstadoDeVenta(idEstadoVenta);
        Ventas venta = new Ventas(idVenta,montoAPagar,montoPagado,fechaVenta,estadoDeVenta,usuarioRut,idAtencion,idDocumento);
        
        return controladorEmpleado.RegistrarVenta(conexion.conexion.getConnection(), venta);
    }
    
    @WebMethod(operationName = "ActualizarProductos")
    public String[] ActualizarProductos(@WebParam(name = "VentasIdVenta") int VentasIdVenta,
                                        @WebParam(name = "idProductoVendido") int idProductoVendido,
                                        @WebParam(name = "cantidad") int cantidad,
                                        @WebParam(name = "totalAPagar") int totalAPagar,
                                        @WebParam(name = "idProducto") int idProducto) {
     
        ProductoVendido productoVendido = new ProductoVendido(idProductoVendido,cantidad,totalAPagar,idProducto,VentasIdVenta);
        return controladorEmpleado.ActualizarProductos(conexion.conexion.getConnection(), productoVendido);
    }
    
     @WebMethod(operationName = "GetTipoDeProducto")
    public TipoDeProducto[] GetTipoDeProducto() {
        
        return controladorEmpleado.GetTipoDeProducto(conexion.conexion.getConnection());
    }
    
    @WebMethod(operationName = "GetProductos")
    public Producto[] GetProductos(@WebParam(name = "idTipoDeProducto") int idTipoDeProducto) {
        
        return controladorEmpleado.GetProductos(conexion.conexion.getConnection(),idTipoDeProducto);
    }
    
    @WebMethod(operationName = "GetTipoDeDocumento")
    public TipoDeDocumento[] GetTipoDeDocumento() {        
        return controladorEmpleado.GetTipoDeDocumento(conexion.conexion.getConnection());
    }
    
    @WebMethod (operationName = "GetVentasEmpleado")
    public Ventas[] GetVentasEmpleado(@WebParam(name = "filtro") String filtro,@WebParam(name = "valorFiltro") String valorFiltro)
    {
        return controladorEmpleado.GetVentasEmpleado(filtro, valorFiltro);
    }
    
    @WebMethod (operationName = "Pagar")
    public String[] Pagar(@WebParam(name = "id_venta")int id_venta, @WebParam(name = "montoPagado") int montoPagado)
    {
        return controladorEmpleado.Pagar(conexion.conexion.getConnection(),id_venta,montoPagado);
    }
}
