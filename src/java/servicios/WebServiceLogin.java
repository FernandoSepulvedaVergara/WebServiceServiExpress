package servicios;

import conexion.conexion;
import controlador.controladorLogin;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "WebServiceLogin")
public class WebServiceLogin {

     @WebMethod(operationName = "ValidarLogin")
    public String[] ValidarLogin(@WebParam(name = "usuario") String usuario,@WebParam(name = "contraseña") String contraseña) {
    
    return controladorLogin.ValidarUsuario(conexion.getConnection(), usuario, contraseña);
    }
    
    @WebMethod(operationName = "ValidarLoginProveedor")
    public String[] ValidarLoginProveedor(@WebParam(name = "usuario") String usuario,@WebParam(name = "contraseña") String contraseña) {
    
    return controladorLogin.ValidarUsuarioProveedor(conexion.getConnection(), usuario, contraseña);
    }
}
