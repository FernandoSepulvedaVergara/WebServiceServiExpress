package servicios;

import clases.Atenciones;
import clases.Comuna;
import clases.Region;
import clases.ReservaDeHora;
import clases.Sucursal;
import clases.TipoDeServicio;
import clases.TipoDeVehiculo;
import clases.Usuario;
import clases.Vehiculo;
import clases.Ventas;
import conexion.conexion;
import controlador.controladorAdministrador;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "WebServiceCliente")
public class WebServiceCliente {

    @WebMethod(operationName = "GetInfoCliente")
    public String[] GetInfoCliente(@WebParam(name = "rut") String rut) {
        String[] resultado = controlador.controladorCliente.GetInfoCliente(conexion.getConnection(), rut);
        if (resultado != null) {
            return resultado;
        } else {
            return null;
        }
    }
    
    @WebMethod(operationName = "GetTipoDeServicios")
    public TipoDeServicio[] GetTipoDeServicios() {
        TipoDeServicio[] resultado = controlador.controladorCliente.GetTipoDeServicios(conexion.getConnection());
        if (resultado != null) {
            return resultado;
        } else {
            return null;
        }
    }
    
    @WebMethod(operationName = "GetTipoDeVehiculo")
    public TipoDeVehiculo[] GetTipoDeVehiculo() {
        TipoDeVehiculo[] resultado = controlador.controladorCliente.GetTipoDeVehiculo(conexion.getConnection());
        if (resultado != null) {
            return resultado;
        } else {
            return null;
        }
    }
    
    @WebMethod(operationName = "IngresarVehiculo")
    public String[] IngresarVehiculo(@WebParam(name = "patente") String patente, @WebParam(name = "marca") String marca,
                                    @WebParam(name = "modelo") String modelo, @WebParam(name = "año") String año,
                                    @WebParam(name = "id_tipo_de_vehiculo") int id_tipo_de_vehiculo, @WebParam(name = "rut") String rut) 
    {
        
        Vehiculo nuevoVehiculo = new Vehiculo(patente, marca, modelo,año, id_tipo_de_vehiculo, rut);        
        String[] resultado = new String[2];        
        if(controlador.controladorCliente.ValidarPatente(conexion.getConnection(), patente) != true)
        {
            if(controlador.controladorCliente.IngresarVehiculo(conexion.getConnection(), nuevoVehiculo))
            {
                resultado[0] = "true";
                resultado[1] = "Vehículo agregado correctamente";
                return resultado;
            }
            else 
            {
                resultado[0] = "false";
                resultado[1] = "Vehículo no se agregó correctamente";
                return resultado;
            }            
        }       
        else
        {
            resultado[0] = "false";
            resultado[1] = "Patente ya está registrado";
            return resultado;   
        }
    }
    
    @WebMethod(operationName = "GetVehiculos")
    public Vehiculo[] GetVehiculos(@WebParam(name = "rut") String rut) 
    {        
        return controlador.controladorCliente.GetVehiculos(conexion.getConnection(), rut);
    }
    
    @WebMethod(operationName = "GetSucursales")
    public Sucursal[] GetSucursales() 
    {        
        return controlador.controladorCliente.GetSucursales(conexion.getConnection());
    }
    
    @WebMethod(operationName = "RegistrarReservaDeAtencion")
    public String[] RegistrarReservaDeAtencion(@WebParam(name = "fecha_reserva") String fecha_reserva,@WebParam(name = "hora_reserva") String hora_reserva,
                                           @WebParam(name = "id_sucursal") int id_sucursal,@WebParam(name = "rut") String rut,@WebParam(name = "id_tipo_de_servicio") int id_tipo_de_servicio,
                                           @WebParam(name = "patente") String patente) 
    {        
        ReservaDeHora nuevoRservaDeHora = new ReservaDeHora(fecha_reserva,hora_reserva,id_sucursal,rut, id_tipo_de_servicio,patente);        
        String[] resultado = new String[2];        
        
         if (controlador.controladorCliente.AgregarReservaDeHora(conexion.getConnection(), nuevoRservaDeHora)) {
            resultado[0] = "true";
            resultado[1] = "Reserva de atención registrado correctamente";
            return resultado;
        } else {
            resultado[0] = "false";
            resultado[1] = "Reserva no se registro correctamente";
            return resultado;
        }          
    }
    
    @WebMethod(operationName = "GetVentasCliente")
    public Ventas[] GetVentasCliente(@WebParam(name = "rut") String rut) 
    {        
        return controlador.controladorCliente.GetVentasCliente(conexion.getConnection(), rut);
    }
    
    @WebMethod(operationName = "GetReservaciones")
    public Atenciones[] GetReservaciones(@WebParam(name = "rut") String rut) 
    {        
        Atenciones[] atenciones = null;
        return controlador.controladorCliente.GetAtenciones(conexion.getConnection(), rut,atenciones);
    }
    
    @WebMethod(operationName = "ValidarDisponibilidad")
    public boolean[] ValidarDisponibilidad(@WebParam(name = "fecha") String fecha,@WebParam(name = "hora") String hora,@WebParam(name = "rut") String rut) 
    {   
        return controlador.controladorCliente.ValidarDisponibilidad(conexion.getConnection(), fecha, hora, rut);
    }
    
    @WebMethod(operationName = "GetInfoUsuario")
    public Usuario GetInfoUsuario(@WebParam(name = "rut") String rut) {        
        return controlador.controladorCliente.GetInfoUsuario(conexion.getConnection(),rut);
    }
    
    @WebMethod(operationName = "GetRegiones")
    public Region[] GetRegiones(){        
        return controlador.controladorCliente.GetRegiones(conexion.getConnection());
    }
    
    @WebMethod(operationName = "GetComunas")
    public Comuna[] GetComunas(@WebParam(name = "idRegion") int idRegion){        
        return controlador.controladorCliente.GetComunas(conexion.getConnection(), idRegion);
    }
    
    @WebMethod(operationName = "ActualizarUsuario")
    public String[] ActualizarUsuario(@WebParam(name = "actualizarUsuario") Usuario actualizarUsuario, @WebParam(name = "rut") String rut, @WebParam(name = "nombreUsuario") String nombreUsuario) {        
        return controlador.controladorCliente.ActualizarUsuario(conexion.getConnection(),actualizarUsuario, rut, nombreUsuario);
    }
    
    @WebMethod(operationName = "EliminarVehiculo")
    public String[] EliminarVehiculo(@WebParam(name = "patente") String patente,@WebParam(name = "rut") String rut) {        
        return controlador.controladorCliente.EliminarVehiculo(conexion.getConnection(),patente,rut);
    }
}
