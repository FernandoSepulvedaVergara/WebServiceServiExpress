package controlador;

import clases.EstadoDePedido;
import clases.OrdenDePedido;
import clases.Pedido;
import clases.Pedidos;
import clases.Producto;
import clases.ProductoProveedor;
import clases.Proveedor;
import clases.TipoDeProducto;
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
       String sql = "select * from PRODUCTOS_PROVEEDOR where TIPO_DE_PRODUCTO_ID_TIPO_DE_PRODUCTO="+idTipoDeProducto+" and  PROVEEDOR_RUT_PROVEEDOR = '"+rutProveedor+"'"; 
        String sqlCount = "select count(*) from PRODUCTOS_PROVEEDOR where TIPO_DE_PRODUCTO_ID_TIPO_DE_PRODUCTO="+idTipoDeProducto+" and  PROVEEDOR_RUT_PROVEEDOR = '"+rutProveedor+"'";
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
    
    public static Producto GetInfoProducto(Connection cnx, int IdProducto){
    String sql = "select * from producto where ID_PRODUCTO = "+IdProducto; 
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
    
     public static ProductoProveedor GetInfoProductoProveedor(Connection cnx, int IdProductoProveedor){
        String sql = "select * from PRODUCTOS_PROVEEDOR where ID_PRODUCTO = "+IdProductoProveedor; 
        Statement st = null;
        ResultSet rs = null;
        ProductoProveedor resultado = null;
        
    try {
            st = cnx.createStatement();
            rs = st.executeQuery(sql);       
            
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
                resultado = productoProveedor;              
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
        String sql = "select o.ID_ORDEN_PEDIDO,e.ID_ESTADO,e.ESTADO,o.\"Fecha de pedido\",o.TOTAL, o.USUARIO_RUT from ORDEN_DE_PEDIDO o join ESTADO_DE_PEDIDO e on (o.ESTADO_DE_PEDIDO_ID_ESTADO = e.ID_ESTADO)"; 
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
            CallableStatement cst = cnx.prepareCall("{call RegistrarOrdenDePedido(?,?,?,?,?)}");        
            cst.setInt(1, ordenDePedido.getTotal());
            cst.setString(2, ordenDePedido.getFechaDePedido());
            cst.setString(3, ordenDePedido.getUsuarioRut());
            cst.setInt(4, ordenDePedido.getEstadoDePedido().getIdEstadoPedido());   
            cst.registerOutParameter(5, java.sql.Types.INTEGER);
            
            cst.execute();
            String id_orden_de_pedido = Integer.toString(cst.getInt(5));
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
    
    public static OrdenDePedido GetOrdenDePedido(Connection cnx, int idOrdenDePedido){
        String sql = "select o.ID_ORDEN_PEDIDO,o.\"Fecha de pedido\", o.TOTAL, o.USUARIO_RUT, e.ID_ESTADO, e.ESTADO from ORDEN_DE_PEDIDO o join ESTADO_DE_PEDIDO e on (o.ESTADO_DE_PEDIDO_ID_ESTADO = e.ID_ESTADO) WHERE ID_ORDEN_PEDIDO = "+idOrdenDePedido; 
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
}
