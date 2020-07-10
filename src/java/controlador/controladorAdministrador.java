package controlador;

import clases.EstadoDePedido;
import clases.EstadoDeProducto;
import clases.EstadoDeUsuario;
import clases.OrdenDePedido;
import clases.Pedido;
import clases.Pedidos;
import clases.Producto;
import clases.ProductoProveedor;
import clases.Proveedor;
import clases.TipoDeProducto;
import clases.TipoDeUsuario;
import clases.Usuarios;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class controladorAdministrador {
    
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
    String sql = "select * from producto where tipo_de_producto_id_tipo_de_producto = "+idTipoDeProducto; 
        String sqlCount = "select count(*) from producto where tipo_de_producto_id_tipo_de_producto = "+idTipoDeProducto;
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
    
     public static ProductoProveedor[] GetProductosProveedor(Connection cnx, int idTipoDeProducto, String rutProveedor){
       String sql = "select * from PRODUCTOS_PROVEEDOR where TIPO_DE_PRODUCTO_ID_TIPO_DE_PRODUCTO="+idTipoDeProducto+" and  PROVEEDOR_RUT_PROVEEDOR = '"+rutProveedor+"'" + " and ESTADO_DE_PRODUCTO_ID_ESTADO = 1"; 
        String sqlCount = "select count(*) from PRODUCTOS_PROVEEDOR where TIPO_DE_PRODUCTO_ID_TIPO_DE_PRODUCTO="+idTipoDeProducto+" and  PROVEEDOR_RUT_PROVEEDOR = '"+rutProveedor+"'" + " and ESTADO_DE_PRODUCTO_ID_ESTADO = 1";
        Statement st = null;
        ResultSet rs = null;
        ProductoProveedor[] resultado = null;
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
            resultado = new ProductoProveedor[indiceArray];
            
            int count = 0;
            while(rs.next()){
                ProductoProveedor productoProveedor = new ProductoProveedor();               
                
                productoProveedor.setIdProducto(Integer.parseInt(rs.getString(1)));
                productoProveedor.setDescripcion(rs.getString(2));
                productoProveedor.setMarca(rs.getString(3)); 
                productoProveedor.setFechaDeVencimiento(rs.getString(4)); 
                productoProveedor.setPrecioDeCompra(rs.getInt(5));
                productoProveedor.setStock(rs.getInt(6)); 
                productoProveedor.setIdTipoDeProducto(rs.getInt(7)); 
                productoProveedor.setRutProveedor(rs.getString(8)); 
                    EstadoDeProducto estadoDeProducto = new EstadoDeProducto();
                    estadoDeProducto.setIdEstadoDeProducto(rs.getInt(9));
                productoProveedor.setEstadoDeProducto(estadoDeProducto);
                resultado[count] = productoProveedor;
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
    
    public static Producto GetInfoProducto(Connection cnx, int idProductoProveedor){
    String sql = "select p.ID_PRODUCTO, p.\"DESCRIPCIÓN\", p.MARCA, p.FECHA_DE_VENCIMIENTO, p.PRECIO_DE_COMPRA, p.PRECIO_DE_VENTA, p.STOCK, p.\"STOCK_CRÍTICO\",p.TIPO_DE_PRODUCTO_ID_TIPO_DE_PRODUCTO,p.ORDEN_DE_PEDIDO_ID_ORDEN_PEDIDO,p.PROVEEDOR_RUT_PROVEEDOR, e.ID_ESTADO, e.ESTADO from producto p join ESTADO_DE_PRODUCTO e on (p.ESTADO_DE_PRODUCTO_ID_ESTADO = e.ID_ESTADO) where p.ID_PRODUCTO = "+idProductoProveedor; 
        Statement st = null;
        ResultSet rs = null;
        Producto resultado = null;
        
    try {
            st = cnx.createStatement();
            rs = st.executeQuery(sql);       
            
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
                    EstadoDeProducto estadoDeProducto = new EstadoDeProducto();
                    estadoDeProducto.setIdEstadoDeProducto(rs.getInt(12));
                    estadoDeProducto.setEstado(rs.getString(13));
                producto.setEstadoDeProducto(estadoDeProducto);
                resultado = producto;
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
    
    public static ProductoProveedor GetInfoProductoProveedor(Connection cnx, int idProductoProveedor,String rutProveedor){
    String sql = "select p.ID_PRODUCTO, p.\"DESCRIPCION\", p.MARCA, p.FECHA_DE_VENCIMIENTO, p.PRECIO_DE_COMPRA, p.STOCK,p.TIPO_DE_PRODUCTO_ID_TIPO_DE_PRODUCTO,p.PROVEEDOR_RUT_PROVEEDOR, e.ID_ESTADO, e.ESTADO from productos_proveedor p join ESTADO_DE_PRODUCTO e on (p.ESTADO_DE_PRODUCTO_ID_ESTADO = e.ID_ESTADO) where p.ID_PRODUCTO = "+idProductoProveedor+" and PROVEEDOR_RUT_PROVEEDOR = '"+rutProveedor+"'";
        Statement st = null;
        ResultSet rs = null;
        ProductoProveedor resultado = null;
        
    try {
            st = cnx.createStatement();
            rs = st.executeQuery(sql);       
            
            int count = 0;
            while(rs.next()){
                ProductoProveedor productoProveedor = new ProductoProveedor();                
                productoProveedor.setIdProducto(Integer.parseInt(rs.getString(1)));
                productoProveedor.setDescripcion(rs.getString(2));
                productoProveedor.setMarca(rs.getString(3)); 
                productoProveedor.setFechaDeVencimiento(rs.getString(4)); 
                productoProveedor.setPrecioDeCompra(rs.getInt(5)); 
                productoProveedor.setStock(rs.getInt(6)); 
                productoProveedor.setIdTipoDeProducto(rs.getInt(7)); 
                productoProveedor.setRutProveedor(rs.getString(8)); 
                    EstadoDeProducto estadoDeProducto = new EstadoDeProducto();
                    estadoDeProducto.setIdEstadoDeProducto(rs.getInt(9));
                    estadoDeProducto.setEstado(rs.getString(10));
                productoProveedor.setEstadoDeProducto(estadoDeProducto);
                resultado = productoProveedor;
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
    
    public static Proveedor[] GetProveedores(Connection cnx){
    String sql = "select RUT_PROVEEDOR, \"RAZÓN_SOCIAL\"  from PROVEEDOR"; 
        String sqlCount = "select count(*) from PROVEEDOR";
        Statement st = null;
        ResultSet rs = null;
        Proveedor[] resultado = null;
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
            resultado = new Proveedor[indiceArray];
            
            int count = 0;
            while(rs.next()){
                Proveedor proveedor = new Proveedor();                
                proveedor.setRutProveedor(rs.getString(1));
                proveedor.setRazonSocial(rs.getString(2)); 
                resultado[count] = proveedor;
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
    
    public static OrdenDePedido[] GetOrdenesDePedido(Connection cnx)
    {
        String sql = "select o.ID_ORDEN_PEDIDO,e.ID_ESTADO,e.ESTADO,o.fecha_de_pedido,o.TOTAL, o.USUARIO_RUT, o.PROVEEDOR_RUT_PROVEEDOR from ORDEN_DE_PEDIDO o join ESTADO_DE_PEDIDO e on (o.ESTADO_DE_PEDIDO_ID_ESTADO = e.ID_ESTADO)"; 
        String sqlCount = "select count(*) from ORDEN_DE_PEDIDO o join ESTADO_DE_PEDIDO e on (o.ESTADO_DE_PEDIDO_ID_ESTADO = e.ID_ESTADO)";
        Statement st = null;
        ResultSet rs = null;
        OrdenDePedido[] resultado = null;
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
            resultado = new OrdenDePedido[indiceArray];
            
            int count = 0;
            while(rs.next()){
                OrdenDePedido ordenDePedido = new OrdenDePedido();
                ordenDePedido.setIdOrdenPedido(rs.getInt(1));
                    EstadoDePedido estadoDePedido = new EstadoDePedido();
                    estadoDePedido.setIdEstadoPedido(rs.getInt(2));
                    estadoDePedido.setEstado(rs.getString(3));
                ordenDePedido.setEstadoDePedido(estadoDePedido);
                ordenDePedido.setFechaDePedido(rs.getString(4));
                ordenDePedido.setTotal(rs.getInt(5)); 
                ordenDePedido.setUsuarioRut(rs.getString(6));
                ordenDePedido.setRutProveedor(rs.getString(7));
                resultado[count] = ordenDePedido;
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
    
    private static OrdenDePedido[] GetOrdenesDePedido(Connection cnx, String filtro, String valorFiltro)
    {
        return null;
    }
    
    public static String[] RegistrarOrdenDePedido(Connection cnx, OrdenDePedido ordenDePedido)
    {
        String[] resultado = new String[3];
        try {        
            CallableStatement cst = cnx.prepareCall("{call RegistrarOrdenDePedido(?,?,?,?,?,?)}");        
            cst.setInt(1, ordenDePedido.getTotal());
            cst.setString(2, ordenDePedido.getFechaDePedido());
            cst.setString(3, ordenDePedido.getUsuarioRut());
            cst.setInt(4, ordenDePedido.getEstadoDePedido().getIdEstadoPedido());   
            cst.setString(5, ordenDePedido.getRutProveedor()); 
            cst.registerOutParameter(6, java.sql.Types.INTEGER);
            
            cst.execute();
            String id_orden_de_pedido = Integer.toString(cst.getInt(6));
            resultado[0] = "True";
            resultado[1] = "Guardado con éxito";
            resultado[2] = id_orden_de_pedido;
            return resultado;
        }   
        catch (SQLException ex)        
        {
            resultado[0] = "False";
            resultado[1] = "Error en guardar orden de pedido";
            resultado[2] = ex.getMessage();
            return resultado;
        }
    }
    
    public static String[] RegistrarPedido(Connection cnx,Pedido pedido)
    {
        String[] resultado = new String[2];
        try {
            PreparedStatement pst = cnx.prepareStatement("insert into PEDIDO "
                    + "VALUES(secuencia_id_pedido.nextval,?,?,?,?)");
            pst.setInt(1, pedido.getCantidad());
            pst.setInt(2, pedido.getTotalAPagar());
            pst.setInt(3, pedido.getIdOrdenDePedido());
            pst.setInt(4, pedido.getIdProductoProveedor());
            pst.execute();
            resultado[0] = "True";
            resultado[1] = "Guadado con éxito";
        } catch (SQLException ex) {
            resultado[0] = "False";
            resultado[1] = "Error al guardar pedido";
        }        
        return resultado;
    }
    
    public static boolean ActualizarEstadoPedido(Connection cnx,int idPedido, int idEstado)
    {
        boolean resultado = false;
        try {
            PreparedStatement pst = cnx.prepareStatement("update ORDEN_DE_PEDIDO set ESTADO_DE_PEDIDO_ID_ESTADO = "+idEstado+" where ID_ORDEN_PEDIDO = "+idPedido);
            pst.execute();
            resultado = true;
        } catch (SQLException ex) {
            resultado = false;
        }        
        return resultado;
    }
    
    public static boolean ActualizarEstadoProducto(Connection cnx,int idProducto, int idEstado)
    {
        boolean resultado = false;
        try {
            PreparedStatement pst = cnx.prepareStatement("update PRODUCTO set ESTADO_DE_PRODUCTO_ID_ESTADO = "+idEstado+" where ID_PRODUCTO = "+idProducto);
            pst.execute();
            resultado = true;
        } catch (SQLException ex) {
            resultado = false;
        }        
        return resultado;
    }
    
    public static OrdenDePedido GetOrdenDePedido(Connection cnx, int idOrdenDePedido){
        String sql = "select o.ID_ORDEN_PEDIDO,o.fecha_de_pedido, o.TOTAL, o.USUARIO_RUT, e.ID_ESTADO, e.ESTADO, o.PROVEEDOR_RUT_PROVEEDOR from ORDEN_DE_PEDIDO o join ESTADO_DE_PEDIDO e on (o.ESTADO_DE_PEDIDO_ID_ESTADO = e.ID_ESTADO) WHERE ID_ORDEN_PEDIDO = "+idOrdenDePedido; 
        Statement st = null;
        ResultSet rs = null;
        OrdenDePedido resultado = null;
        
    try {
            st = cnx.createStatement();
            rs = st.executeQuery(sql);       
            
            while(rs.next()){
                OrdenDePedido ordenDePedido = new OrdenDePedido(); 
                ordenDePedido.setIdOrdenPedido(rs.getInt(1));
                ordenDePedido.setFechaDePedido(rs.getString(2));
                ordenDePedido.setTotal(rs.getInt(3));
                ordenDePedido.setUsuarioRut(rs.getString(4));
                    EstadoDePedido estadoDePedido = new EstadoDePedido();
                    estadoDePedido.setIdEstadoPedido(rs.getInt(5));
                    estadoDePedido.setEstado(rs.getString(6));
                ordenDePedido.setEstadoDePedido(estadoDePedido);
                ordenDePedido.setRutProveedor(rs.getString(7));
                resultado = ordenDePedido;              
            }
            return resultado;
        }  
        catch (SQLException e) 
        {
            System.out.println("Error al obtener datos \n" + e.getMessage());
        }
    return resultado;
    }
    
    public static Pedidos[] GetPedidos(Connection cnx, int idOrdenDePedido){
        String sql = "select pe.ID_PEDIDO, pe.CANTIDAD, p.PRECIO_DE_COMPRA,pe.TOTAL_A_PAGAR, p.ID_PRODUCTO,p.DESCRIPCION,p.MARCA,p.FECHA_DE_VENCIMIENTO from PEDIDO pe join PRODUCTOS_PROVEEDOR p on (pe.PRODUCTOS_PROVEEDOR_ID_PRODUCTO = p.ID_PRODUCTO) where pe.ORDEN_DE_PEDIDO_ID_ORDEN_PEDIDO ="+ idOrdenDePedido; 
        String sqlCount = "select count(*) from PEDIDO pe join PRODUCTOS_PROVEEDOR p on (pe.PRODUCTOS_PROVEEDOR_ID_PRODUCTO = p.ID_PRODUCTO) where pe.ORDEN_DE_PEDIDO_ID_ORDEN_PEDIDO = "+ idOrdenDePedido;
        Statement st = null;
        ResultSet rs = null;
        Pedidos[] resultado = null;
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
            resultado = new Pedidos[indiceArray];
            
            int count = 0;
            while(rs.next()){
                Pedidos pedido = new Pedidos();
                pedido.setIdPedido(rs.getInt(1));
                pedido.setCantidad(rs.getInt(2));
                pedido.setPrecioCompra(rs.getInt(3));
                pedido.setTotalAPagar(rs.getInt(4));
                pedido.setIdProducto(rs.getInt(5));
                pedido.setDescripcion(rs.getString(6));
                pedido.setMarca(rs.getString(7));
                pedido.setFechaDeVencimiento(rs.getString(8));
                resultado[count] = pedido;
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
    
    public static String[] ActualizarProductosCancelarPedido(Connection cnx, int idProductoProveedor, int cantidad)
    {
        String[] resultado = new String[3];
        try {        
            CallableStatement cst = cnx.prepareCall("{call ActualizarProductosCancelarPedido(?,?)}");        
            cst.setInt(1, idProductoProveedor);    
            cst.setInt(2, cantidad);  
            cst.execute();
            
            resultado[0] = "True";
            resultado[1] = "Guardado con éxito";
            return resultado;
        }   
        catch (SQLException ex)        
        {
            resultado[0] = "False";
            resultado[1] = "Error en actualizar cancelación de orden de pedido";
            resultado[2] = ex.getMessage();
            return resultado;
        }
    }  
    
    public static String[] ActualizarProductosEntregarPedido(Connection cnx, int idOrdenDePedido)
    {
        String[] resultado = new String[3];
        try {        
            CallableStatement cst = cnx.prepareCall("{call ActualizarProductosEntregarPedido(?)}");        
            cst.setInt(1, idOrdenDePedido);    
            cst.execute();
            
            resultado[0] = "True";
            resultado[1] = "Actualizado con éxito";
            return resultado;
        }   
        catch (SQLException ex)        
        {
            resultado[0] = "False";
            resultado[1] = "Error en actualizar entrega de productos";
            resultado[2] = ex.getMessage();
            return resultado;
        }
    }
    
     public static Usuarios[] GetUsuarios(Connection cnx){
    String sql = "select t.TIPO_DE_USUARIO, u.RUT, u.PRIMER_NOMBRE, u.APELLIDO_PATERNO, u.APELLIDO_MATERNO, e.ESTADO FROM USUARIO u join TIPO_DE_USUARIO t on (u.TIPO_DE_USUARIO_ID_TIPO_DE_USUARIO = t.ID_TIPO_DE_USUARIO) join ESTADO_DE_USUARIO e on (u.ESTADO_DE_USUARIO_ID_ESTADO_DE_USUARIO = e.ID_ESTADO_DE_USUARIO)"; 
        String sqlCount = "select count(*) FROM USUARIO u join TIPO_DE_USUARIO t on (u.TIPO_DE_USUARIO_ID_TIPO_DE_USUARIO = t.ID_TIPO_DE_USUARIO) join ESTADO_DE_USUARIO e on (u.ESTADO_DE_USUARIO_ID_ESTADO_DE_USUARIO = e.ID_ESTADO_DE_USUARIO)";
        Statement st = null;
        ResultSet rs = null;
        Usuarios[] resultado = null;
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
            resultado = new Usuarios[indiceArray];
            
            int count = 0;
            while(rs.next()){
                Usuarios usuarios = new Usuarios();  
                    TipoDeUsuario tipoDeUsuario = new TipoDeUsuario();
                    tipoDeUsuario.setTipoDeUsuario(rs.getString(1));
                usuarios.setTipoDeUsuario(tipoDeUsuario);
                usuarios.setRut(rs.getString(2));
                usuarios.setNombre(rs.getString(3));
                usuarios.setApellidoPaterno(rs.getString(4));
                usuarios.setApellidoMaterno(rs.getString(5));
                    EstadoDeUsuario estadoDeUsuario = new EstadoDeUsuario();
                    estadoDeUsuario.setEstadoDeUsuario(rs.getString(6));
                usuarios.setEstadoDeUsuario(estadoDeUsuario);
                resultado[count] = usuarios;
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
     
     public static Usuarios[] FiltrarPorUsuario(Connection cnx, boolean filtroAdministrador,boolean filtroCliente,boolean filtroEmpleado){
        String sql = "select t.TIPO_DE_USUARIO, u.RUT, u.PRIMER_NOMBRE, u.APELLIDO_PATERNO, u.APELLIDO_MATERNO, e.ESTADO FROM USUARIO u join TIPO_DE_USUARIO t on (u.TIPO_DE_USUARIO_ID_TIPO_DE_USUARIO = t.ID_TIPO_DE_USUARIO) join ESTADO_DE_USUARIO e on (u.ESTADO_DE_USUARIO_ID_ESTADO_DE_USUARIO = e.ID_ESTADO_DE_USUARIO) where"; 
        String sqlCount = "select count(*) FROM USUARIO u join TIPO_DE_USUARIO t on (u.TIPO_DE_USUARIO_ID_TIPO_DE_USUARIO = t.ID_TIPO_DE_USUARIO) join ESTADO_DE_USUARIO e on (u.ESTADO_DE_USUARIO_ID_ESTADO_DE_USUARIO = e.ID_ESTADO_DE_USUARIO) where";
        
        String or = " or ";
        String sqlFiltroAdministrador = " u.TIPO_DE_USUARIO_ID_TIPO_DE_USUARIO = 4";
        String sqlFiltroCliente = " u.TIPO_DE_USUARIO_ID_TIPO_DE_USUARIO = 1";
        String sqlFiltroEmpleado = " u.TIPO_DE_USUARIO_ID_TIPO_DE_USUARIO = 3";
        if(filtroAdministrador == true){ 
            sql = sql + sqlFiltroAdministrador;
            sqlCount = sqlCount+sqlFiltroAdministrador;
            if(filtroCliente==true){sql = sql+or+sqlFiltroCliente; sqlCount = sqlCount+or+sqlFiltroCliente;}
            if(filtroEmpleado==true){sql = sql+or+sqlFiltroEmpleado; sqlCount = sqlCount+or+sqlFiltroEmpleado;}
        }
        else{
            if(filtroCliente == true){
               sql = sql + sqlFiltroCliente;
               sqlCount = sqlCount+sqlFiltroCliente;
                if(filtroAdministrador==true){sql = sql+or+sqlFiltroAdministrador; sqlCount = sqlCount+or+sqlFiltroAdministrador;}
                if(filtroEmpleado==true){sql = sql+or+sqlFiltroEmpleado; sqlCount = sqlCount+or+sqlFiltroEmpleado;} 
            }
            else{
                if(filtroEmpleado == true){
                    sql = sql + sqlFiltroEmpleado;
                    sqlCount = sqlCount+sqlFiltroEmpleado;
                    if(filtroAdministrador==true){sql = sql+or+sqlFiltroAdministrador; sqlCount = sqlCount+or+sqlFiltroAdministrador;}
                    if(filtroCliente==true){sql = sql+or+sqlFiltroCliente; sqlCount = sqlCount+or+sqlFiltroCliente;}
                }
            }
        }
        Statement st = null;
        ResultSet rs = null;
        Usuarios[] resultado = null;
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
            resultado = new Usuarios[indiceArray];
            
            int count = 0;
            while(rs.next()){
                Usuarios usuarios = new Usuarios();  
                    TipoDeUsuario tipoDeUsuario = new TipoDeUsuario();
                    tipoDeUsuario.setTipoDeUsuario(rs.getString(1));
                usuarios.setTipoDeUsuario(tipoDeUsuario);
                usuarios.setRut(rs.getString(2));
                usuarios.setNombre(rs.getString(3));
                usuarios.setApellidoPaterno(rs.getString(4));
                usuarios.setApellidoMaterno(rs.getString(5));
                    EstadoDeUsuario estadoDeUsuario = new EstadoDeUsuario();
                    estadoDeUsuario.setEstadoDeUsuario(rs.getString(6));
                usuarios.setEstadoDeUsuario(estadoDeUsuario);
                resultado[count] = usuarios;
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
     
     public static Usuarios[] FiltrarPorRut(Connection cnx, String rut){
        String sql = "select t.TIPO_DE_USUARIO, u.RUT, u.PRIMER_NOMBRE, u.APELLIDO_PATERNO, u.APELLIDO_MATERNO, e.ESTADO FROM USUARIO u join TIPO_DE_USUARIO t on (u.TIPO_DE_USUARIO_ID_TIPO_DE_USUARIO = t.ID_TIPO_DE_USUARIO) join ESTADO_DE_USUARIO e on (u.ESTADO_DE_USUARIO_ID_ESTADO_DE_USUARIO = e.ID_ESTADO_DE_USUARIO) where u.rut = '"+rut+"'"; 
        String sqlCount = "select count(*) FROM USUARIO u join TIPO_DE_USUARIO t on (u.TIPO_DE_USUARIO_ID_TIPO_DE_USUARIO = t.ID_TIPO_DE_USUARIO) join ESTADO_DE_USUARIO e on (u.ESTADO_DE_USUARIO_ID_ESTADO_DE_USUARIO = e.ID_ESTADO_DE_USUARIO) where u.rut = '"+rut+"'";
        
        Statement st = null;
        ResultSet rs = null;
        Usuarios[] resultado = null;
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
            resultado = new Usuarios[indiceArray];
            
            int count = 0;
            while(rs.next()){
                Usuarios usuarios = new Usuarios();  
                    TipoDeUsuario tipoDeUsuario = new TipoDeUsuario();
                    tipoDeUsuario.setTipoDeUsuario(rs.getString(1));
                usuarios.setTipoDeUsuario(tipoDeUsuario);
                usuarios.setRut(rs.getString(2));
                usuarios.setNombre(rs.getString(3));
                usuarios.setApellidoPaterno(rs.getString(4));
                usuarios.setApellidoMaterno(rs.getString(5));
                    EstadoDeUsuario estadoDeUsuario = new EstadoDeUsuario();
                    estadoDeUsuario.setEstadoDeUsuario(rs.getString(6));
                usuarios.setEstadoDeUsuario(estadoDeUsuario);
                resultado[count] = usuarios;
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
}