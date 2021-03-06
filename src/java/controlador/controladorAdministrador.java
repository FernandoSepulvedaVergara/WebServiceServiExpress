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
import clases.Usuario;
import clases.Usuarios;
import clases.Comuna;
import clases.Region;
import clases.Sucursal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class controladorAdministrador{
    
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
    
    public static OrdenDePedido[] GetOrdenesDePedido(Connection cnx,boolean filtroSeleccionarTodosLosPedidos,boolean filtroBuscar,boolean filtroEstado,String tipoDeBusqueda,String valorFiltro)
    {
        String sql = "select o.ID_ORDEN_PEDIDO,e.ID_ESTADO,e.ESTADO,o.fecha_de_pedido,o.TOTAL, o.USUARIO_RUT, o.PROVEEDOR_RUT_PROVEEDOR from ORDEN_DE_PEDIDO o join ESTADO_DE_PEDIDO e on (o.ESTADO_DE_PEDIDO_ID_ESTADO = e.ID_ESTADO)"; 
        String sqlCount = "select count(*) from ORDEN_DE_PEDIDO o join ESTADO_DE_PEDIDO e on (o.ESTADO_DE_PEDIDO_ID_ESTADO = e.ID_ESTADO)";
        
        if(filtroBuscar){
            String sqlBuscar;
            if(tipoDeBusqueda.equals("Id orden de pedido")){
                sqlBuscar = " where o.ID_ORDEN_PEDIDO = " + valorFiltro;
                sql = sql + sqlBuscar;
                sqlCount = sqlCount + sqlBuscar;
            }
            else if(tipoDeBusqueda.equals("Proveedor")){
                sqlBuscar = " where o.PROVEEDOR_RUT_PROVEEDOR = '"+valorFiltro+"'";
                sql = sql + sqlBuscar;
                sqlCount = sqlCount + sqlBuscar;
            }
            else if(tipoDeBusqueda.equals("Fecha de pedido")){
                sqlBuscar = " where o.FECHA_DE_PEDIDO = '"+valorFiltro+"'";
                sql = sql + sqlBuscar;
                sqlCount = sqlCount + sqlBuscar;
            }
        }
        else if(filtroEstado){            
            String sqlEstado = " where e.ESTADO = '"+valorFiltro+"'";
            sql = sql + sqlEstado;
            sqlCount = sqlCount + sqlEstado;
        }
        
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
    
     public static Usuarios[] SeleccionarTodosLosUsuarios(Connection cnx){
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
    
    public static boolean ActualizarEstadoDeUsuario(Connection cnx,String rut, int idEstadoDeUsuario)
    {
        boolean resultado = false;
        try {
            PreparedStatement pst = cnx.prepareStatement("update USUARIO set ESTADO_DE_USUARIO_ID_ESTADO_DE_USUARIO = "+idEstadoDeUsuario+" where RUT = '"+rut+"'");
            pst.execute();
            resultado = true;
        } catch (SQLException ex) {
            resultado = false;
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
   
   public static TipoDeUsuario[] GetTiposDeUsuario(Connection cnx){
        String sql = "select * from TIPO_DE_USUARIO WHERE ID_TIPO_DE_USUARIO = 3 or ID_TIPO_DE_USUARIO = 4"; 
        String sqlCount = "select count(*) from TIPO_DE_USUARIO WHERE ID_TIPO_DE_USUARIO = 3 or ID_TIPO_DE_USUARIO = 4";
        Statement st = null;
        ResultSet rs = null;
        TipoDeUsuario[] resultado = null;
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
            resultado = new TipoDeUsuario[indiceArray];
            
            int count = 0;
            while(rs.next()){
                TipoDeUsuario tipoDeUsuario = new TipoDeUsuario();                
                tipoDeUsuario.setIdTipoDeUsuario(rs.getInt(1));
                tipoDeUsuario.setTipoDeUsuario(rs.getString(2));
                resultado[count] = tipoDeUsuario;
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
   
  private static String[] ValidacionRut(Connection cnx,String rut){
       String sqlRut = "select rut from USUARIO WHERE rut = '"+rut+"'";
       
        Statement st = null;
        ResultSet rs = null;
        String[] resultado = new String[2]; 
        resultado[0] = "true";
     try {
            st = cnx.createStatement();
            rs = st.executeQuery(sqlRut);
            while (rs.next()) {
                resultado[0] = "false";
                resultado[1] = "Rut ya esta registrado";
            }
            if(resultado[0] !="false"){
                resultado[0] = "true";
            }
            
        } catch (SQLException d) {
            resultado[0] = "false";
            resultado[1] = "Error validación nombre de usuario";
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


public static String[] RegistrarNuevoUsuario(Connection cnx,Usuario nuevoUsuario)
    {
        String[] resultado = new String[3];
        String[] validarNombreUsuarioEmail = ValidarNombreUsuarioEmail(cnx,nuevoUsuario.getNombreUsuario(),nuevoUsuario.getEmail(), nuevoUsuario.getRut());
        String[] validacionRut = ValidacionRut(cnx,nuevoUsuario.getRut());
        if(validarNombreUsuarioEmail[0] == "true"){
            if(validacionRut[0] == "true"){
                try {
                    PreparedStatement pst = cnx.prepareStatement("insert into usuario values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    pst.setString(1, nuevoUsuario.getRut());
                    pst.setString(2, nuevoUsuario.getPrimerNombre());
                    pst.setString(3, nuevoUsuario.getSegundoNombre());
                    pst.setString(4, nuevoUsuario.getApellidoPaterno());
                    pst.setString(5, nuevoUsuario.getApellidoMaterno());
                    pst.setInt(6, nuevoUsuario.getTelefono());
                    pst.setString(7, nuevoUsuario.getEmail());
                    pst.setString(8, nuevoUsuario.getDireccion());
                    pst.setString(9, nuevoUsuario.getNombreUsuario());
                    pst.setString(10, nuevoUsuario.getContraseña());
                    pst.setInt(11, nuevoUsuario.getTipoUsuario().getIdTipoDeUsuario());
                    pst.setInt(12, nuevoUsuario.getComuna().getIdComuna());
                    pst.setInt(13, nuevoUsuario.getEstadoDeUsuario().getIdEstadoDeUsuario());
                    pst.execute();
                    resultado[0] = "true";
                    resultado[1] = "Usuario registrado correctamente";
                } catch (SQLException ex) {
                    resultado[0] = "false";
                    resultado[1] = "No se pudo registrar el usuario";
                    resultado[2] = ex.getMessage();
                }     
            }
            else if(validacionRut[0] != "true"){
                resultado = validacionRut;
            }
        }
        else if(validarNombreUsuarioEmail[0] != "true"){
            resultado = validarNombreUsuarioEmail;
        }
        return resultado;
    }

public static Proveedor[] GetGestionarProveedores(Connection cnx,boolean filtroTodosLosProveedores, boolean filtroRut, String valorFiltro){
        String sql = "select t.TIPO_DE_USUARIO, p.RUT_PROVEEDOR, p.\"RAZÓN_SOCIAL\", p.\"TELÉFONO\", p.EMAIL from proveedor p join TIPO_DE_USUARIO t on (p.TIPO_DE_USUARIO_ID_TIPO_DE_USUARIO = t.ID_TIPO_DE_USUARIO)"; 
        String sqlCount = "select count(*) from proveedor p join TIPO_DE_USUARIO t on (p.TIPO_DE_USUARIO_ID_TIPO_DE_USUARIO = t.ID_TIPO_DE_USUARIO)";
        
        if(filtroRut){
            String sqlFiltroRut = " WHERE p.RUT_PROVEEDOR ='"+valorFiltro+"'";
            sql = sql + sqlFiltroRut;
            sqlCount = sqlCount + sqlFiltroRut;
        }
        
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
                    TipoDeUsuario tipoDeUsuario = new TipoDeUsuario();
                    tipoDeUsuario.setTipoDeUsuario(rs.getString(1));
                proveedor.setTipoDeUsuario(tipoDeUsuario);
                proveedor.setRutProveedor(rs.getString(2));
                proveedor.setRazonSocial(rs.getString(3));
                proveedor.setTelefono(rs.getInt(4));
                proveedor.setEmail(rs.getString(5));
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

public static Proveedor GetProveedor(Connection cnx, String rut){
        String sql = "select p.RUT_PROVEEDOR, p.\"RAZÓN_SOCIAL\", p.\"TELÉFONO\", p.EMAIL, p.NOMBRE_DE_USUARIO, p.\"CONSTRASEÑA\", t.TIPO_DE_USUARIO,e.ID_ESTADO_DE_USUARIO, e.ESTADO from PROVEEDOR p join TIPO_DE_USUARIO t on (p.TIPO_DE_USUARIO_ID_TIPO_DE_USUARIO = t.ID_TIPO_DE_USUARIO) join ESTADO_DE_USUARIO e on (p.ESTADO_DE_USUARIO_ID_ESTADO_DE_USUARIO = e.ID_ESTADO_DE_USUARIO) where p.RUT_PROVEEDOR = '"+rut+"'"; 
       
        Statement st = null;
        ResultSet rs = null;
        Proveedor resultado = new Proveedor();  
    try {
            st = cnx.createStatement();
            rs = st.executeQuery(sql);   
            
            int count = 0;
            while(rs.next()){
                resultado.setRutProveedor(rs.getString(1));
                resultado.setRazonSocial(rs.getString(2));
                resultado.setTelefono(rs.getInt(3));
                resultado.setEmail(rs.getString(4));
                resultado.setNombreUsuario(rs.getString(5));
                resultado.setContraseña(rs.getString(6));
                    TipoDeUsuario tipoDeUsuario = new TipoDeUsuario();
                    tipoDeUsuario.setTipoDeUsuario(rs.getString(7));
                resultado.setTipoDeUsuario(tipoDeUsuario);  
                    EstadoDeUsuario estadoDeUsuario = new EstadoDeUsuario();
                    estadoDeUsuario.setIdEstadoDeUsuario(rs.getInt(8));
                    estadoDeUsuario.setEstadoDeUsuario(rs.getString(9));
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

public static String[] RegistrarNuevoProveedor(Connection cnx,Proveedor nuevoProveedor)
    {
        String[] resultado = new String[3];
        String[] validarNombreUsuarioEmailProveedor = ValidarNombreUsuarioEmailProveedor(cnx,nuevoProveedor.getNombreUsuario(),nuevoProveedor.getEmail(), nuevoProveedor.getRutProveedor());
        String[] validacionRutProveedor = ValidacionRutProveedor(cnx,nuevoProveedor.getRutProveedor());
        if(validarNombreUsuarioEmailProveedor[0] == "true"){
            if(validacionRutProveedor[0] == "true"){
                try {
                    PreparedStatement pst = cnx.prepareStatement("insert into proveedor values(?,?,?,?,?,?,?,?)");
                    pst.setString(1, nuevoProveedor.getRutProveedor());
                    pst.setString(2, nuevoProveedor.getRazonSocial());
                    pst.setInt(3, nuevoProveedor.getTelefono());
                    pst.setString(4, nuevoProveedor.getEmail());
                    pst.setString(5, nuevoProveedor.getNombreUsuario());
                    pst.setString(6, nuevoProveedor.getContraseña());
                    pst.setInt(7, nuevoProveedor.getTipoDeUsuario().getIdTipoDeUsuario());
                    pst.setInt(8, nuevoProveedor.getEstadoDeUsuario().getIdEstadoDeUsuario());
                    
                    pst.execute();
                    resultado[0] = "true";
                    resultado[1] = "Proveedor registrado correctamente";
                } catch (SQLException ex) {
                    resultado[0] = "false";
                    resultado[1] = "No se pudo registrar el proveedor";
                    resultado[2] = ex.getMessage();
                }     
            }
            else if(validacionRutProveedor[0] != "true"){
                resultado = validacionRutProveedor;
            }
        }
        else if(validarNombreUsuarioEmailProveedor[0] != "true"){
            resultado = validarNombreUsuarioEmailProveedor;
        }
        return resultado;
    }

private static String[] ValidarNombreUsuarioEmailProveedor(Connection cnx, String nombreUsuario, String email, String rut){
        String sqlNombreUsuario = "select NOMBRE_DE_USUARIO from proveedor WHERE NOMBRE_DE_USUARIO = '"+nombreUsuario+"'";
        String sqlEmail = "select email from proveedor WHERE email = '"+email+"'";
        
        String sqlValidacionNombreUsuarioRut = "select NOMBRE_DE_USUARIO from proveedor WHERE NOMBRE_DE_USUARIO = '"+nombreUsuario+"' and rut_proveedor = '"+rut+"'";
        String sqlValidacionEmailRut = "select email from proveedor WHERE email = '"+email+"' and rut_proveedor = '"+rut+"'";
        
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
   
  private static String[] ValidacionRutProveedor(Connection cnx,String rut){
       String sqlRut = "select rut_proveedor from proveedor WHERE rut_proveedor = '"+rut+"'";
       
        Statement st = null;
        ResultSet rs = null;
        String[] resultado = new String[2]; 
        resultado[0] = "true";
     try {
            st = cnx.createStatement();
            rs = st.executeQuery(sqlRut);
            while (rs.next()) {
                resultado[0] = "false";
                resultado[1] = "Rut ya esta registrado";
            }
            if(resultado[0] !="false"){
                resultado[0] = "true";
            }
            
        } catch (SQLException d) {
            resultado[0] = "false";
            resultado[1] = "Error validación nombre de usuario";
        }
     return resultado;
   }
  
  public static boolean ActualizarEstadoProveedor(Connection cnx,String rutProveedor, int idEstadoDeProveedor)
    {
        boolean resultado = false;
        try {
            PreparedStatement pst = cnx.prepareStatement("update PROVEEDOR set ESTADO_DE_USUARIO_ID_ESTADO_DE_USUARIO = "+idEstadoDeProveedor+" where rut_proveedor = '"+rutProveedor+"'");
            pst.execute();
            resultado = true;
        } catch (SQLException ex) {
            resultado = false;
        }        
        return resultado;
    }

  public static Sucursal[] GetSucursales(Connection cnx){
    String sql = "select * from SUCURSAL"; 
        String sqlCount = "select count(*) from SUCURSAL";
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
                sucursal.setId_sucursal(rs.getInt(1));
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
  
  public static String[] AgregarSucursal(Connection cnx, Sucursal sucursal){
  
      String[] resultado = new String[2];
      try {
            PreparedStatement pst = cnx.prepareStatement("insert into SUCURSAL VALUES(secuencia_id_sucursales.nextval, ?,?)");
            pst.setString(1, sucursal.getSucursal());
            pst.setString(2, sucursal.getDireccion());

            pst.execute();
            resultado[0] = "true";
            resultado[1] = "Sucursal registrada correctamente";
        } catch (SQLException ex) {
            resultado[0] = "false";
            resultado[1] = "No se pudo registrar la sucursal";
        }
      return resultado;
    }
  
  public static String[] EliminarSucursal(Connection cnx, int idSucursal){
  
      String[] resultado = new String[2];
      try {
            PreparedStatement pst = cnx.prepareStatement("delete from SUCURSAL where ID_SUCURSAL = "+idSucursal);

            pst.execute();
            resultado[0] = "true";
            resultado[1] = "Sucursal se ha eliminado correctamente";
        } catch (SQLException ex) {
            resultado[0] = "false";
            resultado[1] = "No se pudo eliminar la sucursal";
        }
      return resultado;
    }
}
