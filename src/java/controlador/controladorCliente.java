package controlador;

import clases.Atenciones;
import clases.Comuna;
import clases.EstadoDeUsuario;
import clases.EstadoDeVenta;
import clases.Region;
import clases.ReservaDeHora;
import clases.Sucursal;
import clases.TipoDeServicio;
import clases.TipoDeUsuario;
import clases.TipoDeVehiculo;
import clases.Usuario;
import clases.Vehiculo;
import clases.Ventas;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class controladorCliente {

    public static String[] GetInfoCliente(Connection cnx, String rut) {
        String sql = "select u.rut,u.primer_nombre,u.segundo_nombre,u.apellido_paterno,u.apellido_materno,u.teléfono,u.email,u.dirección,c.comuna,u.nombre_de_usuario "
                + "from usuario u join comuna c on(u.comuna_id_comuna = c.id_comuna)"
                + "WHERE rut = '" + rut + "'";
        Statement st = null;
        ResultSet rs = null;
        String[] resultado = new String[10];

        try {
            st = cnx.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                for (int i = 0; i < 10; i++) {
                    if (rs.getString(i + 1) != null) {
                        resultado[i] = rs.getString(i + 1);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener datos \n" + e.getMessage());
        }
        return resultado;
    }

    public static TipoDeServicio[] GetTipoDeServicios(Connection cnx) {
        String sql = "select id_tipo_de_servicio, servicio from tipo_de_servicio";
        String sqlCount = "select count(*) from tipo_de_servicio";
        Statement st = null;
        ResultSet rs = null;
        TipoDeServicio[] resultado = null;
        int indiceArray = 0;

        try {
            st = cnx.createStatement();
            rs = st.executeQuery(sqlCount);

            while (rs.next()) {
                indiceArray = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener cantidad de filas \n" + e.getMessage());
        }
        try {
            st = cnx.createStatement();
            rs = st.executeQuery(sql);
            resultado = new TipoDeServicio[indiceArray];

            int count = 0;
            while (rs.next()) {
                TipoDeServicio servicio = new TipoDeServicio();
                servicio.setId_servicio(Integer.parseInt(rs.getString(1)));
                servicio.setServicio(rs.getString(2));
                resultado[count] = servicio;
                count = count + 1;
            }
            return resultado;
        } catch (SQLException e) {
            System.out.println("Error al obtener datos \n" + e.getMessage());
        }
        return resultado;
    }

    public static TipoDeVehiculo[] GetTipoDeVehiculo(Connection cnx) {
        String sql = "select id_tipo_de_vehículo, tipo_de_vehículo from tipo_de_vehículo";
        String sqlCount = "select count(*) from tipo_de_vehículo";
        Statement st = null;
        ResultSet rs = null;
        TipoDeVehiculo[] resultado = null;
        int indiceArray = 0;

        try {
            st = cnx.createStatement();
            rs = st.executeQuery(sqlCount);

            while (rs.next()) {
                indiceArray = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener cantidad de filas \n" + e.getMessage());
        }
        try {
            st = cnx.createStatement();
            rs = st.executeQuery(sql);
            resultado = new TipoDeVehiculo[indiceArray];

            int count = 0;
            while (rs.next()) {
                TipoDeVehiculo tipo_de_vehiculo = new TipoDeVehiculo();
                tipo_de_vehiculo.setId_tipo_de_vehiculo(Integer.parseInt(rs.getString(1)));
                tipo_de_vehiculo.setTipo_de_vehiculo(rs.getString(2));
                resultado[count] = tipo_de_vehiculo;
                count = count + 1;
            }
            return resultado;
        } catch (SQLException e) {
            System.out.println("Error al obtener datos \n" + e.getMessage());
        }
        return resultado;
    }

    public static boolean IngresarVehiculo(Connection cnx, Vehiculo nuevoVehiculo) {
        try {
            PreparedStatement pst = cnx.prepareStatement("INSERT INTO vehículo "
                    + "VALUES(?,?,?,?,?,?)");

            pst.setString(1, nuevoVehiculo.getPatente());
            pst.setString(2, nuevoVehiculo.getMarca());
            pst.setString(3, nuevoVehiculo.getModelo());
            pst.setString(4, nuevoVehiculo.getAño());
            pst.setInt(5, nuevoVehiculo.getId_tipo_de_vehiculo());
            pst.setString(6, nuevoVehiculo.getRut());

            pst.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error insert \n" + ex.getMessage());
            return false;
        }
    }

    public static boolean ValidarPatente(Connection cnx, String patente) {
        String sql = "select patente from vehículo "
                + "where patente='" + patente + "'";
        Statement st = null;
        ResultSet rs = null;
        boolean resultado = true;

        try {
            st = cnx.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                resultado = true;
                return resultado;
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener datos \n" + e.getMessage());
        }
        resultado = false;
        return resultado;
    }

    public static Vehiculo[] GetVehiculos(Connection cnx, String rut) {
        String sql = "select v.patente, v.MARCA, v.MODELO,v.\"AÑO\", v.tipo_de_vehículo_id_tipo_de_vehículo, t.tipo_de_vehículo,v.usuario_rut from vehículo v join tipo_de_vehículo t "
                + "on (v.TIPO_DE_VEHÍCULO_ID_TIPO_DE_VEHÍCULO = t.ID_TIPO_DE_VEHÍCULO) where v.USUARIO_RUT = '" + rut + "'";
        String sqlCount = "select count(*) from vehículo where usuario_rut = '" + rut + "'";
        Statement st = null;
        ResultSet rs = null;
        Vehiculo[] resultado = null;
        int indiceArray = 0;

        try {
            st = cnx.createStatement();
            rs = st.executeQuery(sqlCount);

            while (rs.next()) {
                indiceArray = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener cantidad de filas \n" + e.getMessage());
        }
        try {
            st = cnx.createStatement();
            rs = st.executeQuery(sql);
            resultado = new Vehiculo[indiceArray];

            int count = 0;
            while (rs.next()) {
                Vehiculo vehiculos = new Vehiculo();

                vehiculos.setPatente(rs.getString(1));
                vehiculos.setMarca(rs.getString(2));
                vehiculos.setModelo(rs.getString(3));
                vehiculos.setAño(rs.getString(3));
                TipoDeVehiculo tipoDeVehiculo = new TipoDeVehiculo();
                tipoDeVehiculo.setId_tipo_de_vehiculo(Integer.parseInt(rs.getString(4)));
                tipoDeVehiculo.setTipo_de_vehiculo(rs.getString(5));
                vehiculos.setId_tipo_de_vehiculo(tipoDeVehiculo.getId_tipo_de_vehiculo());
                vehiculos.setTipoDeVehiculo(tipoDeVehiculo);
                vehiculos.setRut(rs.getString(6));

                resultado[count] = vehiculos;
                count = count + 1;
            }
            return resultado;
        } catch (SQLException e) {
            System.out.println("Error al obtener datos \n" + e.getMessage());
        }
        return resultado;
    }

    public static Sucursal[] GetSucursales(Connection cnx) {
        String sql = "select id_sucursal, sucursal, dirección from sucursal";
        String sqlCount = "select count(*) from sucursal";
        Statement st = null;
        ResultSet rs = null;
        Sucursal[] resultado = null;
        int indiceArray = 0;

        try {
            st = cnx.createStatement();
            rs = st.executeQuery(sqlCount);

            while (rs.next()) {
                indiceArray = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener cantidad de filas \n" + e.getMessage());
        }
        try {
            st = cnx.createStatement();
            rs = st.executeQuery(sql);
            resultado = new Sucursal[indiceArray];

            int count = 0;
            while (rs.next()) {
                Sucursal sucursal = new Sucursal();
                sucursal.setId_sucursal(Integer.parseInt(rs.getString(1)));
                sucursal.setSucursal(rs.getString(2));
                sucursal.setDireccion(rs.getString(3));
                resultado[count] = sucursal;
                count = count + 1;
            }
            return resultado;
        } catch (SQLException e) {
            System.out.println("Error al obtener datos \n" + e.getMessage());
        }
        return resultado;
    }

    public static boolean AgregarReservaDeHora(Connection cnx, ReservaDeHora nuevoReservaDeHora) {
        try {
            PreparedStatement pst = cnx.prepareStatement("INSERT INTO reserva_de_hora "
                    + "VALUES(secuencia_id_reserva_de_hora.nextval,?,?,?,?,?,?)");
            pst.setString(1, nuevoReservaDeHora.getFecha_reserva());
            pst.setString(2, nuevoReservaDeHora.getHora_reserva());
            pst.setInt(3, nuevoReservaDeHora.getSucursal());
            pst.setString(4, nuevoReservaDeHora.getRut());
            pst.setInt(5, nuevoReservaDeHora.getId_tipo_de_servicio());
            pst.setString(6, nuevoReservaDeHora.getPatente());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public static Ventas[] GetVentasCliente(Connection cnx, String rut) {
        String sql = "select v.ID_VENTA, v.MONTO_A_PAGAR, v.MONTO_PAGADO, v.FECHA_VENTA, v.ESTADO_DE_VENTA_ID_ESTADO_DE_VENTA, e.ESTADO, v.ATENCIONES_ID_ATENCION, v.DOCUMENTO_ID_DOCUMENTO from ventas v join estado_de_venta e "
                + "on(v.ESTADO_DE_VENTA_ID_ESTADO_DE_VENTA = e.ID_ESTADO_DE_VENTA) where usuario_rut = '" + rut + "'";
        String sqlCount = "select count(*) from ventas where usuario_rut = '" + rut + "'";
        Statement st = null;
        ResultSet rs = null;
        Ventas[] resultado = null;
        int indiceArray = 0;

        try {
            st = cnx.createStatement();
            rs = st.executeQuery(sqlCount);

            while (rs.next()) {
                indiceArray = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener cantidad de filas \n" + e.getMessage());
        }
        try {
            st = cnx.createStatement();
            rs = st.executeQuery(sql);
            resultado = new Ventas[indiceArray];

            int count = 0;
            while (rs.next()) {
                Ventas venta = new Ventas();
                venta.setId_venta(rs.getInt(1));
                venta.setMontoAPagar(rs.getInt(2));
                venta.setMontoPagado(rs.getInt(3));
                venta.setFecha(rs.getString(4));

                EstadoDeVenta estadoDeVenta = new EstadoDeVenta();
                estadoDeVenta.setIdEstadoDeVenta(rs.getInt(5));
                estadoDeVenta.setEstado(rs.getString(6));

                venta.setEstadoDeVenta(estadoDeVenta);
                venta.setIdAtencion(rs.getInt(7));
                venta.setIdDocumento(rs.getInt(8));

                resultado[count] = venta;
                count = count + 1;
            }
            return resultado;
        } catch (SQLException e) {
            System.out.println("Error al obtener datos \n" + e.getMessage());
        }
        return resultado;
    }

    public static Atenciones[] GetAtenciones(Connection cnx, String rut, Atenciones[] atenciones) {
        String sql = "select a.ID_ATENCION,r.HORA_RESERVA, r.FECHA_RESERVA,r.USUARIO_RUT,r.PATENTE, r.ID_RESERVA,s.SUCURSAL,a.ESTADO_DE_ATENCIÓN_ID_ESTADO_DE_ATENCIÓN from atenciones a right join reserva_de_hora r on (a.RESERVA_DE_HORA_ID_RESERVA = r.ID_RESERVA) join sucursal s on (r.SUCURSAL_ID_SUCURSAL = s.ID_SUCURSAL) "
                + "where r.USUARIO_RUT='" + rut + "'";
        String sqlCount = "select count(*) from atenciones a right join reserva_de_hora r on (a.RESERVA_DE_HORA_ID_RESERVA = r.ID_RESERVA) join sucursal s on (r.SUCURSAL_ID_SUCURSAL = s.ID_SUCURSAL) "
                + "where r.USUARIO_RUT='" + rut + "'";

        Statement st = null;
        ResultSet rs = null;

        int indiceArray = 0;

        try {
            st = cnx.createStatement();
            rs = st.executeQuery(sqlCount);

            while (rs.next()) {
                indiceArray = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener cantidad de filas \n" + e.getMessage());
        }
        try {
            st = cnx.createStatement();
            rs = st.executeQuery(sql);
            atenciones = new Atenciones[indiceArray];

            int count = 0;
            while (rs.next()) {
                Atenciones atencion = new Atenciones();

                atencion.setId_atencion((rs.getInt(1)));
                atencion.setHora_reserva(rs.getString(2));
                atencion.setFecha_reserva(rs.getString(3));
                atencion.setUsuario_rut(rs.getString(4));
                atencion.setPatente(rs.getString(5));
                atencion.setId_reserva(rs.getInt(6));
                atencion.setSucursal(rs.getString(7));
                atencion.setId_estado(rs.getInt(8));

                atenciones[count] = atencion;
                count = count + 1;
            }
            return atenciones;
        } catch (SQLException e) {
            System.out.println("Error al obtener datos \n" + e.getMessage());
        }
        return atenciones;
    }

    public static boolean[] ValidarDisponibilidad(Connection cnx, String fecha, String hora, String rut) {
        String sqlCantidadEmpleados = "select count(*) from usuario u join tipo_de_usuario t on (u.TIPO_DE_USUARIO_ID_TIPO_DE_USUARIO = t.ID_TIPO_DE_USUARIO) where t.ID_TIPO_DE_USUARIO = 3";
        String sqlCantidadReservas = "select count(*) from RESERVA_DE_HORA where FECHA_RESERVA = '" + fecha + "' and HORA_RESERVA = '" + hora + "'";
        String sqlValidarReservacionUsuario = "select * from RESERVA_DE_HORA where FECHA_RESERVA = '" + fecha + "' and HORA_RESERVA = '" + hora + "' and USUARIO_RUT = '" + rut + "'";

        int cantidadEmpleados = 0;
        int cantidadReservas = 0;
        boolean validacionHora = false;

        boolean[] resultado = new boolean[2];

        Statement st = null;
        ResultSet rs = null;

        try {
            st = cnx.createStatement();
            rs = st.executeQuery(sqlCantidadEmpleados);

            while (rs.next()) {
                cantidadEmpleados = rs.getInt(1);
            }
        } catch (SQLException e) {
            cantidadEmpleados = 0;
        }
        try {
            st = cnx.createStatement();
            rs = st.executeQuery(sqlCantidadReservas);
            while (rs.next()) {
                cantidadReservas = rs.getInt(1);
            }
        } catch (SQLException e) {
            cantidadReservas = 0;
        }

        try {
            st = cnx.createStatement();
            rs = st.executeQuery(sqlValidarReservacionUsuario);
            boolean dato = false;
            while (rs.next()) {
                dato = false;
            }
            if (dato == false) {
                validacionHora = true;
            } else {
                validacionHora = false;
            }

        } catch (SQLException e) {
            validacionHora = true;
        }

        if (cantidadEmpleados != cantidadReservas) {
            resultado[0] = true;
        } else {
            resultado[0] = false;
        }
        resultado[1] = validacionHora;
        return resultado;
    }
    
    public static Usuario GetInfoUsuario(Connection cnx, String rut){
        String sql = "select u.RUT, u.PRIMER_NOMBRE, u.SEGUNDO_NOMBRE, u.APELLIDO_PATERNO, u.APELLIDO_MATERNO, u.\"TELÉFONO\", u.EMAIL, u.\"DIRECCIÓN\", u.NOMBRE_DE_USUARIO, u.\"CONTRASEÑA\", t.TIPO_DE_USUARIO, c.COMUNA , r.\"REGIÓN\",e.ID_ESTADO_DE_USUARIO, e.ESTADO from usuario u join TIPO_DE_USUARIO t on (u.TIPO_DE_USUARIO_ID_TIPO_DE_USUARIO = t.ID_TIPO_DE_USUARIO) join COMUNA c on (u.COMUNA_ID_COMUNA = c.ID_COMUNA) join \"REGIÓN\" r on (c.\"REGIÓN_ID_REGIÓN\" = r.\"ID_REGIÓN\") join ESTADO_DE_USUARIO e on (u.ESTADO_DE_USUARIO_ID_ESTADO_DE_USUARIO = e.ID_ESTADO_DE_USUARIO) where u.RUT = '"+rut+"'"; 
       
        Statement st = null;
        ResultSet rs = null;
         Usuario resultado = new Usuario();  
    try {
            st = cnx.createStatement();
            rs = st.executeQuery(sql);   
            
            int count = 0;
            while(rs.next()){
                resultado.setRut(rs.getString(1));
                resultado.setPrimerNombre(rs.getString(2));
                resultado.setSegundoNombre(rs.getString(3));
                resultado.setApellidoPaterno(rs.getString(4));
                resultado.setApellidoMaterno(rs.getString(5));
                resultado.setTelefono(rs.getInt(6));
                resultado.setEmail(rs.getString(7));
                resultado.setDireccion(rs.getString(8));
                resultado.setNombreUsuario(rs.getString(9));
                resultado.setContraseña(rs.getString(10));
                    TipoDeUsuario tipoDeUsuario = new TipoDeUsuario();
                    tipoDeUsuario.setTipoDeUsuario(rs.getString(11));
                resultado.setTipoUsuario(tipoDeUsuario);
                    Comuna comuna = new Comuna();
                    comuna.setComuna(rs.getString(12));
                resultado.setComuna(comuna);
                    Region region = new Region();
                    region.setRegion(rs.getString(13));
                resultado.setRegion(region);                 
                    EstadoDeUsuario estadoDeUsuario = new EstadoDeUsuario();
                    estadoDeUsuario.setIdEstadoDeUsuario(rs.getInt(14));
                    estadoDeUsuario.setEstadoDeUsuario(rs.getString(15));
                resultado.setEstadoDeUsuario(estadoDeUsuario);
                count = count + 1;                
            }
            return resultado;
        }  
        catch (SQLException e) 
        {
            System.out.println("Error al obtener datos \n" + e.getMessage());
        }
    return resultado;
    }    
    
    public static Region[] GetRegiones(Connection cnx){
        String sql = "select * from región"; 
        String sqlCount = "select count(*) from región";
        Statement st = null;
        ResultSet rs = null;
        Region[] resultado = null;
        int indiceArray=0;        
        
        try{
            st = cnx.createStatement();
            rs = st.executeQuery(sqlCount);
            
            while(rs.next()){
            indiceArray = rs.getInt(1);
                }              
            }
        catch (SQLException e) 
        {
            System.out.println("Error al obtener cantidad de filas \n" + e.getMessage());
        }        
    try {
            st = cnx.createStatement();
            rs = st.executeQuery(sql);                  
            resultado = new Region[indiceArray];
            
            int count = 0;
            while(rs.next()){
                Region region = new Region();                
                region.setIdRegion(rs.getInt(1));
                region.setRegion(rs.getString(2)); 
                resultado[count] = region;
                count = count + 1;                
            }
            return resultado;
        }  
        catch (SQLException e) 
        {
            System.out.println("Error al obtener datos \n" + e.getMessage());
        }
    return resultado;
    }
    
    public static Comuna[] GetComunas(Connection cnx, int idRegion){
        String sql = "select ID_COMUNA, COMUNA from comuna WHERE \"REGIÓN_ID_REGIÓN\" = "+idRegion; 
        String sqlCount = "select count(*) from comuna WHERE \"REGIÓN_ID_REGIÓN\" = "+idRegion;
        Statement st = null;
        ResultSet rs = null;
        Comuna[] resultado = null;
        int indiceArray=0;        
        
        try{
            st = cnx.createStatement();
            rs = st.executeQuery(sqlCount);
            
            while(rs.next()){
            indiceArray = rs.getInt(1);
                }              
            }
        catch (SQLException e) 
        {
            System.out.println("Error al obtener cantidad de filas \n" + e.getMessage());
        }        
    try {
            st = cnx.createStatement();
            rs = st.executeQuery(sql);                  
            resultado = new Comuna[indiceArray];
            
            int count = 0;
            while(rs.next()){
                Comuna comuna = new Comuna();                
                comuna.setIdComuna(rs.getInt(1));
                comuna.setComuna(rs.getString(2)); 
                resultado[count] = comuna;
                count = count + 1;                
            }
            return resultado;
        }  
        catch (SQLException e) 
        {
            System.out.println("Error al obtener datos \n" + e.getMessage());
        }
    return resultado;   
   }
    
    public static String[] ActualizarUsuario(Connection cnx,Usuario actualizarUsuario,String rut,String nombreUsuario)
    {
        String[] resultado = new String[3];
        resultado[0] = "Mensaje";
        String[] validarRutNombreUsuarioEmail = ValidarNombreUsuarioEmail(cnx,actualizarUsuario.getNombreUsuario(),actualizarUsuario.getEmail(), rut);
        if(validarRutNombreUsuarioEmail[0] == "true"){
            try {
                CallableStatement cst = cnx.prepareCall("{call ActualizarUsuario(?,?,?,?,?,?,?,?,?,?,?,?)}");
                cst.setString(1, actualizarUsuario.getPrimerNombre());
                cst.setString(2, actualizarUsuario.getSegundoNombre());
                cst.setString(3, actualizarUsuario.getApellidoPaterno());
                cst.setString(4, actualizarUsuario.getApellidoMaterno());
                cst.setInt(5, actualizarUsuario.getTelefono());
                cst.setString(6, actualizarUsuario.getEmail());
                cst.setString(7, actualizarUsuario.getDireccion());
                cst.setString(8, actualizarUsuario.getNombreUsuario());
                cst.setString(9, actualizarUsuario.getContraseña());
                cst.setInt(10, actualizarUsuario.getComuna().getIdComuna());
                cst.setString(11, rut);
                cst.setString(12, nombreUsuario);
                cst.execute();
                resultado[0] = "true";
                resultado[1] = "Usuario actualizado correctamente";
            } catch (SQLException ex) {
                resultado[0] = "false";
                resultado[1] = "No se pudo actualizar el usuario";
                resultado[2] = ex.getMessage();
            }     
        }else if(validarRutNombreUsuarioEmail[0] != "true"){
            resultado = validarRutNombreUsuarioEmail;
        }
        return resultado;
    }
    
    private static String[] ValidarNombreUsuarioEmail(Connection cnx, String nombreUsuario, String email, String rut){
        String sqlNombreUsuario = "select NOMBRE_DE_USUARIO from USUARIO WHERE NOMBRE_DE_USUARIO = '"+nombreUsuario+"'";
        String sqlEmail = "select email from USUARIO WHERE email = '"+email+"'";
        
        String sqlValidacionNombreUsuarioRut = "select NOMBRE_DE_USUARIO from USUARIO WHERE NOMBRE_DE_USUARIO = '"+nombreUsuario+"' and rut = '"+rut+"'";
        String sqlValidacionEmailRut = "select email from USUARIO WHERE email = '"+email+"' and rut = '"+rut+"'";
        
        Statement st = null;
        ResultSet rs = null;
        String[] resultado = new String[2];   
        resultado[0] = "false";
        try {
            st = cnx.createStatement();
            rs = st.executeQuery(sqlValidacionNombreUsuarioRut);

            while (rs.next()) {
                resultado[0] = "true";    
            }  
            
            if(resultado[0] != "true"){
            resultado[0] = "true";
            st = cnx.createStatement();
            rs = st.executeQuery(sqlNombreUsuario);
                
            while (rs.next()) {
                resultado[0] = "false";
                resultado[1] = "Nombre de usuario ya esta registrado";
            }
            if(resultado[0] != "false"){
                resultado[0] = "true";
            }
        }   
        }         
        catch (SQLException d) {
            resultado[0] = "false";
            resultado[1] = "Error validación nombre de usuario";
        }
        
            if(resultado[0] != "true"){
                return resultado;
            }
            else if(resultado[0] == "true"){
            resultado[0] = "false";
            try {
            st = cnx.createStatement();
            rs = st.executeQuery(sqlValidacionEmailRut);

                while (rs.next()) {
                    resultado[0] = "true";    
                }  
            
            if(resultado[0] != "true"){
            resultado[0] = "true";
            st = cnx.createStatement();
            rs = st.executeQuery(sqlEmail);
                
                while (rs.next()) {
                    resultado[0] = "false";
                    resultado[1] = "Email ya esta registrado";
                }
                if(resultado[0] != "false"){
                    resultado[0] = "true";
                }
            }   
        }         
            catch (SQLException d) {
                resultado[0] = "false";
                resultado[1] = "Error validación email";
            }
        }
        return resultado;    
    }
}
