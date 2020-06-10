
package servicios;

import clases.Usuario;
import conexion.conexion;
import controlador.controladorUsuario;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "WebServiceNuevoUsuario")
public class WebServiceUsuario {

    @WebMethod(operationName = "NuevoUsuario")
    public String[] NuevoUsuario(
            @WebParam(name = "rut") String rut,
            @WebParam(name = "primerNombre") String primerNombre,
            @WebParam(name = "segundoNombre") String segundoNombre,
            @WebParam(name = "apellidoPaterno") String apellidoPaterno,
            @WebParam(name = "apellidoMaterno") String apellidoMaterno,
            @WebParam(name = "telefono") int telefono,
            @WebParam(name = "email") String email,
            @WebParam(name = "direccion") String direccion,
            @WebParam(name = "comuna") int comuna,
            @WebParam(name = "nombreUsuario") String nombreUsuario,
            @WebParam(name = "tipoUsuario") int tipoUsuario,
            @WebParam(name = "contraseña") String contraseña
    ) {
        String[] resultado = new String[2];

        if (controladorUsuario.ValidarRut(conexion.getConnection(), rut) != true) {
            if (controladorUsuario.ValidarEmail(conexion.getConnection(), email) != true) {
                if (controladorUsuario.ValidarNombreUsuario(conexion.getConnection(), nombreUsuario) != true) {
                    Usuario nuevoUsuario = new Usuario(rut, primerNombre, segundoNombre, apellidoPaterno, apellidoMaterno, telefono,
                        email, direccion, nombreUsuario, contraseña, tipoUsuario, comuna);

                    if (controladorUsuario.IngresarUsuario(conexion.getConnection(), nuevoUsuario)) 
                    {
                        resultado[0] = "true";
                        resultado[1] = "Usuario agregado correctamente";
                        return resultado;
                    } 
                        else 
                        {
                            resultado[0] = "false";
                            resultado[1] = "Usuario no se pudo agregar correctamente";
                            return resultado;
                        }
                    }
                    else 
                    {
                    resultado[0] = "false";
                    resultado[1] = "Nombre de usuario ya está registrado";
                    return resultado;
                    }
                
            } else {
                resultado[0] = "false";
                resultado[1] = "Email ya está registrado";
                return resultado;
            }
        } else {
            resultado[0] = "false";
            resultado[1] = "Rut ya está registrado";
            return resultado;
        }
    }
}
