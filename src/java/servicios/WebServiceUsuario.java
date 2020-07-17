package servicios;

import clases.Comuna;
import clases.EstadoDeUsuario;
import clases.Region;
import clases.TipoDeUsuario;
import clases.Usuario;
import conexion.conexion;
import controlador.controladorEmpleado;
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
            @WebParam(name = "comuna") int idComuna,
            @WebParam(name = "nombreUsuario") String nombreUsuario,
            @WebParam(name = "tipoUsuario") int idTipoUsuario,
            @WebParam(name = "contraseña") String contraseña,
            @WebParam(name = "idEstadoUsuario") int idEstadoUsuario
    ) {
        String[] resultado = new String[2];

        if (controladorUsuario.ValidarRut(conexion.getConnection(), rut) != true) {
            if (controladorUsuario.ValidarEmail(conexion.getConnection(), email) != true) {
                if (controladorUsuario.ValidarNombreUsuario(conexion.getConnection(), nombreUsuario) != true) {
                    
                    Usuario nuevoUsuario = new Usuario();
                    nuevoUsuario.setRut(rut);
                    nuevoUsuario.setPrimerNombre(primerNombre);
                    nuevoUsuario.setSegundoNombre(segundoNombre);
                    nuevoUsuario.setApellidoPaterno(apellidoPaterno);
                    nuevoUsuario.setApellidoMaterno(apellidoMaterno);
                    nuevoUsuario.setTelefono(telefono);
                    nuevoUsuario.setEmail(email);
                    nuevoUsuario.setDireccion(direccion);
                        Comuna comuna = new Comuna();
                        comuna.setIdComuna(idComuna);
                    nuevoUsuario.setComuna(comuna);
                    nuevoUsuario.setNombreUsuario(nombreUsuario);
                        TipoDeUsuario tipoDeUsuario = new TipoDeUsuario();
                        tipoDeUsuario.setIdTipoDeUsuario(idTipoUsuario);
                    nuevoUsuario.setTipoUsuario(tipoDeUsuario);
                    nuevoUsuario.setContraseña(contraseña);
                    EstadoDeUsuario estadoDeUsuario = new EstadoDeUsuario();
                        estadoDeUsuario.setIdEstadoDeUsuario(idEstadoUsuario);
                    nuevoUsuario.setEstadoDeUsuario(estadoDeUsuario);
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
    
    @WebMethod(operationName = "GetRegiones")
    public Region[] GetRegiones(){        
        return controladorUsuario.GetRegiones(conexion.getConnection());
    }
    
    @WebMethod(operationName = "GetComunas")
    public Comuna[] GetComunas(@WebParam(name = "idRegion") int idRegion){        
        return controladorUsuario.GetComunas(conexion.getConnection(), idRegion);
    }
}
