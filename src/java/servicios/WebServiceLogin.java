
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
    controladorLogin ctrlLogin = new controladorLogin();
    String[] data;
    data = ctrlLogin.ValidarUsuario(conexion.getConnection(), usuario, contraseña);
    return data;
    }
}
