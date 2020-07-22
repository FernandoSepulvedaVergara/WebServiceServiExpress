package controlador;

import clases.Atencion;
import clases.Atenciones;
import clases.Comuna;
import clases.EstadoDeAtencion;
import clases.EstadoDeUsuario;
import clases.EstadoDeVenta;
import clases.Producto;
import clases.ProductoVendido;
import clases.Region;
import clases.ReservaDeHora;
import clases.TipoDeDocumento;
import clases.TipoDeProducto;
import clases.TipoDeServicio;
import clases.TipoDeUsuario;
import clases.Usuario;
import clases.Ventas;
import conexion.conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class controladorEmpleado {

    public static Atenciones[] GetAtenciones( String filtro, String valorFiltro)
    {   
        String sql;
        String sqlCount;
        Atenciones[] atenciones = null;
        
        if(filtro.equals("Fecha"))
        {
            sql = "select a.ID_ATENCION,r.HORA_RESERVA, r.FECHA_RESERVA,r.USUARIO_RUT,r.PATENTE, r.ID_RESERVA,s.SUCURSAL,a.ESTADO_DE_ATENCIÓN_ID_ESTADO_DE_ATENCIÓN from atenciones a right join reserva_de_hora r on (a.RESERVA_DE_HORA_ID_RESERVA = r.ID_RESERVA) join sucursal s on (r.SUCURSAL_ID_SUCURSAL = s.ID_SUCURSAL) "
                + "where r.FECHA_RESERVA='"+valorFiltro+"'";
            
            sqlCount = "select count(*) from atenciones a right join reserva_de_hora r on (a.RESERVA_DE_HORA_ID_RESERVA = r.ID_RESERVA) join sucursal s on (r.SUCURSAL_ID_SUCURSAL = s.ID_SUCURSAL) "
                     + "where r.FECHA_RESERVA='"+valorFiltro+"'";
            
            atenciones = GetAtenciones(conexion.getConnection(),atenciones, sql, sqlCount);
        }
        else if(filtro.equals("Rut"))
        {
            sql = "select a.ID_ATENCION,r.HORA_RESERVA, r.FECHA_RESERVA,r.USUARIO_RUT,r.PATENTE, r.ID_RESERVA,s.SUCURSAL,a.ESTADO_DE_ATENCIÓN_ID_ESTADO_DE_ATENCIÓN from atenciones a right join reserva_de_hora r on (a.RESERVA_DE_HORA_ID_RESERVA = r.ID_RESERVA) join sucursal s on (r.SUCURSAL_ID_SUCURSAL = s.ID_SUCURSAL) "
                + "where r.USUARIO_RUT='"+valorFiltro+"'";
            
            sqlCount = "select count(*) from atenciones a right join reserva_de_hora r on (a.RESERVA_DE_HORA_ID_RESERVA = r.ID_RESERVA) join sucursal s on (r.SUCURSAL_ID_SUCURSAL = s.ID_SUCURSAL) "
                     + "where r.USUARIO_RUT='"+valorFiltro+"'";
            
            atenciones = GetAtenciones(conexion.getConnection(),atenciones, sql, sqlCount);
        }
        else if(filtro.equals("Patente"))
        {
            sql = "select a.ID_ATENCION,r.HORA_RESERVA, r.FECHA_RESERVA,r.USUARIO_RUT,r.PATENTE, r.ID_RESERVA,s.SUCURSAL,a.ESTADO_DE_ATENCIÓN_ID_ESTADO_DE_ATENCIÓN from atenciones a right join reserva_de_hora r on (a.RESERVA_DE_HORA_ID_RESERVA = r.ID_RESERVA) join sucursal s on (r.SUCURSAL_ID_SUCURSAL = s.ID_SUCURSAL) "
                + "where r.PATENTE='"+valorFiltro+"'";
            
            sqlCount = "select count(*) from atenciones a right join reserva_de_hora r on (a.RESERVA_DE_HORA_ID_RESERVA = r.ID_RESERVA) join sucursal s on (r.SUCURSAL_ID_SUCURSAL = s.ID_SUCURSAL) "
                     + "where r.PATENTE='"+valorFiltro+"'";
            
            atenciones = GetAtenciones(conexion.getConnection(),atenciones, sql, sqlCount);
        }
        else if(filtro.equals("Id reservación"))
        {
            sql = "select a.ID_ATENCION,r.HORA_RESERVA, r.FECHA_RESERVA,r.USUARIO_RUT,r.PATENTE, r.ID_RESERVA,s.SUCURSAL,a.ESTADO_DE_ATENCIÓN_ID_ESTADO_DE_ATENCIÓN from atenciones a right join reserva_de_hora r on (a.RESERVA_DE_HORA_ID_RESERVA = r.ID_RESERVA) join sucursal s on (r.SUCURSAL_ID_SUCURSAL = s.ID_SUCURSAL) "
                + "where r.ID_RESERVA="+valorFiltro+"'";
            
            sqlCount = "select count(*) from atenciones a right join reserva_de_hora r on (a.RESERVA_DE_HORA_ID_RESERVA = r.ID_RESERVA) join sucursal s on (r.SUCURSAL_ID_SUCURSAL = s.ID_SUCURSAL) "
                     + "where r.ID_RESERVA="+valorFiltro+"'";
            
            atenciones = GetAtenciones(conexion.getConnection(),atenciones, sql, sqlCount);
        }
        else if(filtro.equals("Sucursal"))
        {
            sql = "select a.ID_ATENCION,r.HORA_RESERVA, r.FECHA_RESERVA,r.USUARIO_RUT,r.PATENTE, r.ID_RESERVA,s.SUCURSAL,a.ESTADO_DE_ATENCIÓN_ID_ESTADO_DE_ATENCIÓN from atenciones a right join reserva_de_hora r on (a.RESERVA_DE_HORA_ID_RESERVA = r.ID_RESERVA) join sucursal s on (r.SUCURSAL_ID_SUCURSAL = s.ID_SUCURSAL) "
                + "where r.SUCURSAL_ID_SUCURSAL="+valorFiltro+"'";
            
            sqlCount = "select count(*) from atenciones a right join reserva_de_hora r on (a.RESERVA_DE_HORA_ID_RESERVA = r.ID_RESERVA) join sucursal s on (r.SUCURSAL_ID_SUCURSAL = s.ID_SUCURSAL) "
                     + "where r.SUCURSAL_ID_SUCURSAL="+valorFiltro+"'";
            
            atenciones = GetAtenciones(conexion.getConnection(),atenciones, sql, sqlCount);
        }
        else
        {
            return null;
        }        
        return atenciones;
    }
    
    private static Atenciones[] GetAtenciones(Connection cnx,Atenciones[] atenciones, String sql, String sqlCount) 
    {
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
    
    public static Atencion GetAtencion(Connection cnx, int idReserva)
    {        
        String sql = "select a.ID_ATENCION, e.ESTADO, r.ID_RESERVA, a.FECHA_ATENCION, a.HORA_ATENCION ,t.SERVICIO, r.PATENTE from atenciones a join reserva_de_hora r on (a.RESERVA_DE_HORA_ID_RESERVA = r.ID_RESERVA) join ESTADO_DE_ATENCIÓN e on(a.\"ESTADO_DE_ATENCIÓN_ID_ESTADO_DE_ATENCIÓN\" = e.\"ID_ESTADO_DE_ATENCIÓN\") join TIPO_DE_SERVICIO t on (a.TIPO_DE_SERVICIO_ID_TIPO_DE_SERVICIO = t.ID_TIPO_DE_SERVICIO)"
                   + " where r.ID_RESERVA = "+idReserva; 
        Statement st = null;
        ResultSet rs = null;
        Atencion atencion = new Atencion();
        
    try {
            st = cnx.createStatement();
            rs = st.executeQuery(sql);                  
            
            while(rs.next()){              
                
                EstadoDeAtencion estadoDeAtencion = new EstadoDeAtencion();
                atencion.setId_atencion(rs.getInt(1));
                    estadoDeAtencion.setEstado(rs.getString(2));
                atencion.setEstado_de_atencion(estadoDeAtencion);
                atencion.setId_reserva(rs.getInt(3));
                atencion.setFecha_atencion(rs.getString(4));
                atencion.setHora_atencion(rs.getString(5));
                TipoDeServicio tipoDeServicio = new TipoDeServicio();
                    tipoDeServicio.setServicio(rs.getString(6));
                atencion.setTipo_de_servicio(tipoDeServicio);
                atencion.setPatente(rs.getString(7));
            }
            return atencion;
        }  
        catch (SQLException e) 
        {
            System.out.println("Error al obtener datos \n" + e.getMessage());
            return null;
        }
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
    
    public static String[] RegistrarAtencion(Connection cnx, Atencion atencion)
    {  
        String[] resultado = new String[3];
        try {        
            CallableStatement cst = cnx.prepareCall("{call RegistrarAtencion(?,?,?,?,?,?)}");        
            cst.setString(1, atencion.getFecha_atencion());
            cst.setString(2, atencion.getHora_atencion());
            cst.setInt(3, atencion.getTipo_de_servicio().getId_servicio());
            cst.setInt(4, atencion.getId_reserva());     
            cst.setInt(5, atencion.getEstado_de_atencion().getIdEstadoDeAtencion());
            cst.registerOutParameter(6, java.sql.Types.INTEGER);
            
            cst.execute();
            String id_atencion = Integer.toString(cst.getInt(6));
            resultado[0] = "True";
            resultado[1] = "Guardado con éxito";
            resultado[2] = id_atencion;
            return resultado;
        }   
        catch (SQLException ex)        
        {
            resultado[0] = "False";
            resultado[1] = "Error en guardar atención";
            resultado[2] = ex.getMessage();
            return resultado;
        }
    }
    
    public static String[] RegistrarVenta(Connection cnx, Ventas venta)
    {  
        String[] resultado = new String[3];
        try {        
            CallableStatement cst = cnx.prepareCall("{call RegistrarVenta(?,?,?,?,?,?,?,?)}");  
            cst.setInt(1, venta.getIdAtencion());
            cst.setInt(2, venta.getMontoAPagar());
            cst.setInt(3, venta.getMontoPagado());
            cst.setString(4, venta.getFecha());
            cst.setInt(5, venta.getEstadoDeVenta().getIdEstadoDeVenta());
            cst.setString(6, venta.getRut());
            cst.setInt(7, venta.getIdDocumento());
            cst.registerOutParameter(8, java.sql.Types.INTEGER);
            
            cst.execute();
            String id_venta = Integer.toString(cst.getInt(8));
            resultado[0] = "True";
            resultado[1] = "Guardado con éxito";
            resultado[2] = id_venta;
            return resultado;
        }   
        catch (SQLException ex)        
        {
            resultado[0] = "False";
            resultado[1] = "Error en guardar venta";
            resultado[2] = ex.getMessage();
            return resultado;
        }
    }
    
    public static String[] ActualizarProductos(Connection cnx, ProductoVendido productoVendido)
    {  
        String[] resultado = new String[2];
        try {        
            CallableStatement cst = cnx.prepareCall("{call ActualizarProductos(?,?,?,?)}");  
            cst.setInt(1, productoVendido.getVentas_Id_venta());
            cst.setInt(2, productoVendido.getCantidad());
            cst.setInt(3, productoVendido.getTotal_a_pagar());
            cst.setInt(4, productoVendido.getProducto_Id_producto());
            
            cst.execute();
            resultado[0] = "True";
            resultado[1] = "Guardado con éxito";
            return resultado;
        }   
        catch (SQLException ex)        
        {
            resultado[0] = "False";
            resultado[1] = "Error en guardar producto vendido";
            return resultado;
        }
    }
    
    public static TipoDeProducto[] GetTipoDeProducto(Connection cnx){
    String sql = "select id_tipo_de_producto, tipo_de_producto from tipo_de_producto"; 
        String sqlCount = "select count(*) from tipo_de_producto";
        Statement st = null;
        ResultSet rs = null;
        TipoDeProducto[] resultado = null;
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
            resultado = new TipoDeProducto[indiceArray];
            
            int count = 0;
            while(rs.next()){
                TipoDeProducto tipoDeProducto = new TipoDeProducto();                
                tipoDeProducto.setIdTipoDeProducto(Integer.parseInt(rs.getString(1)));
                tipoDeProducto.setProducto(rs.getString(2)); 
                resultado[count] = tipoDeProducto;
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
    
    public static Producto[] GetProductos(Connection cnx, int idTipoDeProducto){
    String sql = "select * from producto where tipo_de_producto_id_tipo_de_producto = "+idTipoDeProducto+" and ESTADO_DE_PRODUCTO_ID_ESTADO = 1"; 
        String sqlCount = "select count(*) from producto where tipo_de_producto_id_tipo_de_producto = "+idTipoDeProducto+" and ESTADO_DE_PRODUCTO_ID_ESTADO = 1";
        Statement st = null;
        ResultSet rs = null;
        Producto[] resultado = null;
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
            resultado = new Producto[indiceArray];
            
            int count = 0;
            while(rs.next()){
                Producto producto = new Producto();                
                producto.setIdProducto(Integer.parseInt(rs.getString(1)));
                producto.setDescripcion(rs.getString(2));
                producto.setMarca(rs.getString(3)); 
                producto.setFechaVencimiento(rs.getString(4)); 
                producto.setPrecioCompra(rs.getInt(5)); 
                producto.setPrecioVenta(rs.getInt(6)); 
                producto.setStock(rs.getInt(7)); 
                producto.setStockCritico(rs.getInt(8)); 
                producto.setIdTipoDeProducto(rs.getInt(9)); 
                producto.setIdOrdenDePedido(rs.getInt(10)); 
                producto.setRutProveedor(rs.getString(11)); 
                resultado[count] = producto;
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
    
    public static TipoDeDocumento[] GetTipoDeDocumento(Connection cnx){
    String sql = "select id_tipo_de_documento, documento from tipo_de_documento"; 
        String sqlCount = "select count(*) from tipo_de_documento";
        Statement st = null;
        ResultSet rs = null;
        TipoDeDocumento[] resultado = null;
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
            resultado = new TipoDeDocumento[indiceArray];
            
            int count = 0;
            while(rs.next()){
                TipoDeDocumento tipoDedocumento = new TipoDeDocumento();                
                tipoDedocumento.setId_tipo_de_documento(Integer.parseInt(rs.getString(1)));
                tipoDedocumento.setDocumento(rs.getString(2)); 
                resultado[count] = tipoDedocumento;
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
    
    public static Ventas[] GetVentasEmpleado(String filtro, String valorFiltro)
    {
         String sql;
        String sqlCount;
        Ventas[] ventas = null;
        
        if(filtro.equals("Id venta"))
        {
            sql = "select e.ESTADO, v.ID_VENTA,r.PATENTE, v.MONTO_A_PAGAR, v.MONTO_PAGADO, v.FECHA_VENTA,v.USUARIO_RUT, v.ATENCIONES_ID_ATENCION, v.DOCUMENTO_ID_DOCUMENTO from ventas v join usuario u on (u.RUT = v.USUARIO_RUT) join estado_de_venta e on (v.ESTADO_DE_VENTA_ID_ESTADO_DE_VENTA = e.ID_ESTADO_DE_VENTA) join ATENCIONES a on(v.ATENCIONES_ID_ATENCION = a.ID_ATENCION) join RESERVA_DE_HORA r on (a.RESERVA_DE_HORA_ID_RESERVA = r.ID_RESERVA) "
                + "where v.ID_VENTA = "+Integer.parseInt(valorFiltro);
            
            sqlCount = "select count(*) from ventas v join usuario u on (u.RUT = v.USUARIO_RUT) join estado_de_venta e on (v.ESTADO_DE_VENTA_ID_ESTADO_DE_VENTA = e.ID_ESTADO_DE_VENTA) join ATENCIONES a on(v.ATENCIONES_ID_ATENCION = a.ID_ATENCION) join RESERVA_DE_HORA r on (a.RESERVA_DE_HORA_ID_RESERVA = r.ID_RESERVA) "
                     + "where v.ID_VENTA = "+Integer.parseInt(valorFiltro);
            
            ventas = GetVentas(conexion.getConnection(),ventas, sql, sqlCount);
        }
        else if(filtro.equals("Fecha venta"))
        {
            sql = "select e.ESTADO, v.ID_VENTA,r.PATENTE, v.MONTO_A_PAGAR, v.MONTO_PAGADO, v.FECHA_VENTA,v.USUARIO_RUT, v.ATENCIONES_ID_ATENCION, v.DOCUMENTO_ID_DOCUMENTO from ventas v join usuario u on (u.RUT = v.USUARIO_RUT) join estado_de_venta e on (v.ESTADO_DE_VENTA_ID_ESTADO_DE_VENTA = e.ID_ESTADO_DE_VENTA) join ATENCIONES a on(v.ATENCIONES_ID_ATENCION = a.ID_ATENCION) join RESERVA_DE_HORA r on (a.RESERVA_DE_HORA_ID_RESERVA = r.ID_RESERVA) "
                + "where v.FECHA_VENTA = '"+valorFiltro+"'";
            
            sqlCount = "select count(*) from ventas v join usuario u on (u.RUT = v.USUARIO_RUT) join estado_de_venta e on (v.ESTADO_DE_VENTA_ID_ESTADO_DE_VENTA = e.ID_ESTADO_DE_VENTA) join ATENCIONES a on(v.ATENCIONES_ID_ATENCION = a.ID_ATENCION) join RESERVA_DE_HORA r on (a.RESERVA_DE_HORA_ID_RESERVA = r.ID_RESERVA) "
                     + "where v.FECHA_VENTA = '"+valorFiltro+"'";
            
            ventas = GetVentas(conexion.getConnection(),ventas, sql, sqlCount);
        }
        else if(filtro.equals("Rut"))
        {
            sql = "select e.ESTADO, v.ID_VENTA,r.PATENTE, v.MONTO_A_PAGAR, v.MONTO_PAGADO, v.FECHA_VENTA,v.USUARIO_RUT, v.ATENCIONES_ID_ATENCION, v.DOCUMENTO_ID_DOCUMENTO from ventas v join usuario u on (u.RUT = v.USUARIO_RUT) join estado_de_venta e on (v.ESTADO_DE_VENTA_ID_ESTADO_DE_VENTA = e.ID_ESTADO_DE_VENTA) join ATENCIONES a on(v.ATENCIONES_ID_ATENCION = a.ID_ATENCION) join RESERVA_DE_HORA r on (a.RESERVA_DE_HORA_ID_RESERVA = r.ID_RESERVA) "
                + "where v.USUARIO_RUT = '"+valorFiltro+"'";
            
            sqlCount = "select count(*) from ventas v join usuario u on (u.RUT = v.USUARIO_RUT) join estado_de_venta e on (v.ESTADO_DE_VENTA_ID_ESTADO_DE_VENTA = e.ID_ESTADO_DE_VENTA) join ATENCIONES a on(v.ATENCIONES_ID_ATENCION = a.ID_ATENCION) join RESERVA_DE_HORA r on (a.RESERVA_DE_HORA_ID_RESERVA = r.ID_RESERVA) "
                     + "where v.USUARIO_RUT = '"+valorFiltro+"'";
            
            ventas = GetVentas(conexion.getConnection(),ventas, sql, sqlCount);
        }
        else if(filtro.equals("Patente"))
        {
            sql = "select e.ESTADO, v.ID_VENTA,r.PATENTE, v.MONTO_A_PAGAR, v.MONTO_PAGADO, v.FECHA_VENTA,v.USUARIO_RUT, v.ATENCIONES_ID_ATENCION, v.DOCUMENTO_ID_DOCUMENTO from ventas v join usuario u on (u.RUT = v.USUARIO_RUT) join estado_de_venta e on (v.ESTADO_DE_VENTA_ID_ESTADO_DE_VENTA = e.ID_ESTADO_DE_VENTA) join ATENCIONES a on(v.ATENCIONES_ID_ATENCION = a.ID_ATENCION) join RESERVA_DE_HORA r on (a.RESERVA_DE_HORA_ID_RESERVA = r.ID_RESERVA) "
                + "where r.PATENTE = '"+valorFiltro+"'";
            
            sqlCount = "select count(*) from ventas v join usuario u on (u.RUT = v.USUARIO_RUT) join estado_de_venta e on (v.ESTADO_DE_VENTA_ID_ESTADO_DE_VENTA = e.ID_ESTADO_DE_VENTA) join ATENCIONES a on(v.ATENCIONES_ID_ATENCION = a.ID_ATENCION) join RESERVA_DE_HORA r on (a.RESERVA_DE_HORA_ID_RESERVA = r.ID_RESERVA) "
                     + "where r.PATENTE = '"+valorFiltro+"'";
            
            ventas = GetVentas(conexion.getConnection(),ventas, sql, sqlCount);
        }
        else
        {
            return null;
        }        
        return ventas;
    }
    
    private static Ventas[] GetVentas(Connection cnx,Ventas[] ventas, String sql, String sqlCount )
    {
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
            ventas = new Ventas[indiceArray];
            
            int count = 0;
            while(rs.next()){
                Ventas venta = new Ventas();
                    EstadoDeVenta estadoDeVenta = new EstadoDeVenta();
                    estadoDeVenta.setEstado(rs.getString(1));
                venta.setEstadoDeVenta(estadoDeVenta);
                venta.setId_venta(rs.getInt(2));
                venta.setPatente(rs.getString(3));
                venta.setMontoAPagar(rs.getInt(4));
                venta.setMontoPagado(rs.getInt(5));
                venta.setFecha(rs.getString(6));
                venta.setRut(rs.getString(7));
                venta.setIdAtencion(rs.getInt(8));
                venta.setIdDocumento(rs.getInt(9));
                ventas[count] = venta;
                count = count + 1;                
            }
            return ventas;
        }  
        catch (SQLException e) 
        {
            System.out.println("Error al obtener datos \n" + e.getMessage());
        }
    return ventas;
    }
    
    public static String[] Pagar(Connection cnx, int id_venta, int montoPagado)
    {
        String[] resultado = new String[2];
        try {
            PreparedStatement pst = cnx.prepareStatement("update ventas set estado_de_venta_id_estado_de_venta = 2, monto_pagado = " + montoPagado + " where id_venta= " + id_venta);

            pst.execute();
            resultado[0] = "True";
            resultado[1] = "Pagado con éxito";
        } catch (SQLException ex) {
            System.out.println("Error insert \n" + ex.getMessage());
            resultado[0] = "False";
            resultado[1] = "No se pudo actualizar con éxito";
        }
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
