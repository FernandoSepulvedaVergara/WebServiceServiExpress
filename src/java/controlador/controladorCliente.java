
package controlador;

import clases.Atenciones;
import clases.EstadoDeVenta;
import clases.ReservaDeHora;
import clases.Sucursal;
import clases.TipoDeServicio;
import clases.TipoDeVehiculo;
import clases.Usuario;
import clases.Vehiculo;
import clases.Ventas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class controladorCliente {
    
    public static String[] GetInfoCliente(Connection cnx,String rut)
    {
        String sql = "select u.rut,u.primer_nombre,u.segundo_nombre,u.apellido_paterno,u.apellido_materno,u.teléfono,u.email,u.dirección,c.comuna,u.nombre_de_usuario " +
                     "from usuario u join comuna c on(u.comuna_id_comuna = c.id_comuna)" +
                     "WHERE rut = '"+rut+"'";     
        Statement st = null;
        ResultSet rs = null;
        String[] resultado=new String[10];
        
    try {
            st = cnx.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) 
            {
                for (int i = 0; i < 10; i++) {
                    if(rs.getString(i+1)!=null)
                    {
                        resultado[i] = rs.getString(i+1); 
                    }
                }
            }                 
        }  
        catch (SQLException e) 
        {
            System.out.println("Error al obtener datos \n" + e.getMessage());
        }
    return resultado;
    }    
    
    public static TipoDeServicio[] GetTipoDeServicios(Connection cnx)
    {
        String sql = "select id_tipo_de_servicio, servicio from tipo_de_servicio"; 
        String sqlCount = "select count(*) from tipo_de_servicio";
        Statement st = null;
        ResultSet rs = null;
        TipoDeServicio[] resultado = null;
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
            resultado = new TipoDeServicio[indiceArray];
            
            int count = 0;
            while(rs.next()){
                TipoDeServicio servicio = new TipoDeServicio();                
                servicio.setId_servicio(Integer.parseInt(rs.getString(1)));
                servicio.setServicio(rs.getString(2)); 
                resultado[count] = servicio;
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
    
    public static TipoDeVehiculo[] GetTipoDeVehiculo(Connection cnx)
    {
        String sql = "select id_tipo_de_vehículo, tipo_de_vehículo from tipo_de_vehículo"; 
        String sqlCount = "select count(*) from tipo_de_vehículo";
        Statement st = null;
        ResultSet rs = null;
        TipoDeVehiculo[] resultado = null;
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
            resultado = new TipoDeVehiculo[indiceArray];
            
            int count = 0;
            while(rs.next()){
                TipoDeVehiculo tipo_de_vehiculo = new TipoDeVehiculo();                
                tipo_de_vehiculo.setId_tipo_de_vehiculo(Integer.parseInt(rs.getString(1)));
                tipo_de_vehiculo.setTipo_de_vehiculo(rs.getString(2)); 
                resultado[count] = tipo_de_vehiculo;
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
    
    public static boolean IngresarVehiculo(Connection cnx,Vehiculo nuevoVehiculo)
    {
        try {        
            PreparedStatement pst = cnx.prepareStatement("INSERT INTO vehículo "
                                                         +"VALUES(?,?,?,?,?)");
        
            pst.setString(1, nuevoVehiculo.getPatente());
            pst.setInt(2, nuevoVehiculo.getNumero_motor());
            pst.setString(3, nuevoVehiculo.getNumero_chasis());
            pst.setInt(4, nuevoVehiculo.getId_tipo_de_vehiculo());
            pst.setString(5, nuevoVehiculo.getRut());           
        
            pst.execute();       
            return true;
    }   
    
    catch (SQLException ex)        
        {
            System.out.println("Error insert \n"+ex.getMessage());
        return false;
        }
    }
    
    public static boolean ValidarPatente(Connection cnx,String patente)
    {
        String sql = "select patente from vehículo "
                    +"where patente='"+patente+"'";     
        Statement st = null;
        ResultSet rs = null;
        boolean resultado = true;
        
    try {
            st = cnx.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) 
            {   
                resultado=true;
                return resultado;                
            }                 
        }  
        catch (SQLException e) 
        {
                System.out.println("Error al obtener datos \n" + e.getMessage());
            }
    resultado=false;
    return resultado;
    }
    
    public static Vehiculo[] GetVehiculos(Connection cnx, String rut)
    {
        String sql = "select v.patente, v.número_de_motor, v.número_de_chasis, v.tipo_de_vehículo_id_tipo_de_vehículo, t.tipo_de_vehículo,v.usuario_rut from vehículo v join tipo_de_vehículo t "
                + "on (v.TIPO_DE_VEHÍCULO_ID_TIPO_DE_VEHÍCULO = t.ID_TIPO_DE_VEHÍCULO) where v.USUARIO_RUT = '"+rut+"'"; 
        String sqlCount = "select count(*) from vehículo where usuario_rut = '"+rut+"'";
        Statement st = null;
        ResultSet rs = null;
        Vehiculo[] resultado = null;
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
            resultado = new Vehiculo[indiceArray];
            
            int count = 0;
            while(rs.next()){
                Vehiculo vehiculos = new Vehiculo();     
                
                vehiculos.setPatente(rs.getString(1));
                vehiculos.setNumero_motor(Integer.parseInt(rs.getString(2)));
                vehiculos.setNumero_chasis(rs.getString(3));                 
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
        }  
        catch (SQLException e) 
        {
            System.out.println("Error al obtener datos \n" + e.getMessage());
        }
    return resultado;
    }    
    
    public static Sucursal[] GetSucursales(Connection cnx)
    {
        String sql = "select id_sucursal, sucursal, dirección from sucursal"; 
        String sqlCount = "select count(*) from sucursal";
        Statement st = null;
        ResultSet rs = null;
        Sucursal[] resultado = null;
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
            resultado = new Sucursal[indiceArray];
            
            int count = 0;
            while(rs.next()){
                Sucursal sucursal = new Sucursal();                
                sucursal.setId_sucursal(Integer.parseInt(rs.getString(1)));
                sucursal.setSucursal(rs.getString(2)); 
                sucursal.setDireccion(rs.getString(3));
                resultado[count] = sucursal;
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
    
    public static boolean AgregarReservaDeHora(Connection cnx,ReservaDeHora nuevoReservaDeHora)
    {
        try {        
            PreparedStatement pst = cnx.prepareStatement("INSERT INTO reserva_de_hora "
                                                         +"VALUES(secuencia_id_reserva_de_hora.nextval,?,?,?,?,?,?)");        
            pst.setString(1, nuevoReservaDeHora.getFecha_reserva());
            pst.setString(2, nuevoReservaDeHora.getHora_reserva());
            pst.setInt(3, nuevoReservaDeHora.getSucursal());
            pst.setString(4, nuevoReservaDeHora.getRut());     
            pst.setInt(5, nuevoReservaDeHora.getId_tipo_de_servicio());
            pst.setString(6, nuevoReservaDeHora.getPatente());
            pst.execute();       
            return true;
        }   
        catch (SQLException ex)        
        {
            return false;
        }
    }
    
     public static Ventas[] GetVentasCliente(Connection cnx,String rut)
    {
        String sql = "select v.ID_VENTA, v.MONTO_A_PAGAR, v.MONTO_PAGADO, v.FECHA_VENTA, v.ESTADO_DE_VENTA_ID_ESTADO_DE_VENTA, e.ESTADO, v.ATENCIONES_ID_ATENCION, v.DOCUMENTO_ID_DOCUMENTO from ventas v join estado_de_venta e "+ 
                     "on(v.ESTADO_DE_VENTA_ID_ESTADO_DE_VENTA = e.ID_ESTADO_DE_VENTA) where usuario_rut = '"+rut+"'"; 
        String sqlCount = "select count(*) from ventas where usuario_rut = '"+rut+"'";
        Statement st = null;
        ResultSet rs = null;
        Ventas[] resultado = null;
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
            resultado = new Ventas[indiceArray];
            
            int count = 0;
            while(rs.next()){
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
        }  
        catch (SQLException e) 
        {
            System.out.println("Error al obtener datos \n" + e.getMessage());
        }
    return resultado;
    }     
     
    public static Atenciones[] GetAtenciones(Connection cnx, String rut, Atenciones[] atenciones)
    {
        String sql = "select a.ID_ATENCION,r.HORA_RESERVA, r.FECHA_RESERVA,r.USUARIO_RUT,r.PATENTE, r.ID_RESERVA,s.SUCURSAL,a.ESTADO_DE_ATENCIÓN_ID_ESTADO_DE_ATENCIÓN from atenciones a right join reserva_de_hora r on (a.RESERVA_DE_HORA_ID_RESERVA = r.ID_RESERVA) join sucursal s on (r.SUCURSAL_ID_SUCURSAL = s.ID_SUCURSAL) "
                   + "where r.USUARIO_RUT='"+rut+"'";
        String sqlCount = "select count(*) from atenciones a right join reserva_de_hora r on (a.RESERVA_DE_HORA_ID_RESERVA = r.ID_RESERVA) join sucursal s on (r.SUCURSAL_ID_SUCURSAL = s.ID_SUCURSAL) "
                     + "where r.USUARIO_RUT='"+rut+"'";
        
        Statement st = null;
        ResultSet rs = null;
        
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
            atenciones = new Atenciones[indiceArray];
            
            int count = 0;
            while(rs.next()){
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
        }  
        catch (SQLException e) 
        {
            System.out.println("Error al obtener datos \n" + e.getMessage());
        }
    return atenciones;
    }
}
