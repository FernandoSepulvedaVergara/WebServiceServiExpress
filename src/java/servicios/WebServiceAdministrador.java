
package servicios;

import clases.Producto;
import clases.TipoDeProducto;
import controlador.controladorAdministrador;
import java.util.jar.Attributes;
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
        return controladorAdministrador.GetProductos(conexion.conexion.getConnection(),idTipoDeProducto);
    }
    
    @WebMethod(operationName = "GetInfoProducto")
    public Producto GetInfoProducto(@WebParam(name = "idProducto") int idProducto) {
        return controladorAdministrador.GetInfoProducto(conexion.conexion.getConnection(),idProducto);
    }
}
