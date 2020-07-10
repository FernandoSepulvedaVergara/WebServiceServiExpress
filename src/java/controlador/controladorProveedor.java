package controlador;

import clases.EstadoDePedido;
import clases.EstadoDeProducto;
import clases.OrdenDePedido;
import clases.Pedidos;
import clases.ProductoProveedor;
import clases.TipoDeProducto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class controladorProveedor {
    
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
    
   public static ProductoProveedor[] GetProductosProveedor(Connection cnx, int idTipoDeProducto, String rutProveedor){
    String sql = "select * from PRODUCTOS_PROVEEDOR where tipo_de_producto_id_tipo_de_producto = "+idTipoDeProducto+" and PROVEEDOR_RUT_PROVEEDOR = '"+rutProveedor+"'";
        String sqlCount = "select count(*) from PRODUCTOS_PROVEEDOR where tipo_de_producto_id_tipo_de_producto = "+idTipoDeProducto+" and PROVEEDOR_RUT_PROVEEDOR = '"+rutProveedor+"'";
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
   
   public static ProductoProveedor GetInfoProductoProveedor(Connection cnx, int IdProductoProveedor, String rutProveedor){
        String sql = "select p.ID_PRODUCTO, p.DESCRIPCION, p.MARCA, p.FECHA_DE_VENCIMIENTO, p.PRECIO_DE_COMPRA, p.STOCK,p.TIPO_DE_PRODUCTO_ID_TIPO_DE_PRODUCTO,p.PROVEEDOR_RUT_PROVEEDOR, e.ID_ESTADO, e.ESTADO from productos_proveedor p join ESTADO_DE_PRODUCTO e on (p.ESTADO_DE_PRODUCTO_ID_ESTADO = e.ID_ESTADO) where p.ID_PRODUCTO = "+IdProductoProveedor+" and PROVEEDOR_RUT_PROVEEDOR = '"+rutProveedor+"'"; 
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
                    EstadoDeProducto estadoDeProducto = new EstadoDeProducto();
                    estadoDeProducto.setIdEstadoDeProducto(rs.getInt(9));
                    estadoDeProducto.setEstado(rs.getString(10));
                productoProveedor.setEstadoDeProducto(estadoDeProducto);
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
   
   public static boolean ActualizarEstadoProductoProveedor(Connection cnx,int idProductoProveedor, int idEstado)
    {
        boolean resultado = false;
        try {
            PreparedStatement pst = cnx.prepareStatement("update PRODUCTOS_PROVEEDOR set ESTADO_DE_PRODUCTO_ID_ESTADO = "+idEstado+" where ID_PRODUCTO = "+idProductoProveedor);
            pst.execute();
            resultado = true;
        } catch (SQLException ex) {
            resultado = false;
        }        
        return resultado;
    }
   
   public static String[] ActualizarProductoProveedor(Connection cnx,int idProductoProveedor, String fechaDeVencimiento, int stock, int precioCompra)
    {
        String[] resultado = new String[2];
        try {
            PreparedStatement pst = cnx.prepareStatement("update PRODUCTOS_PROVEEDOR set FECHA_DE_VENCIMIENTO = '"+fechaDeVencimiento+"',STOCK = "+stock+", PRECIO_DE_COMPRA = "+precioCompra+" WHERE ID_PRODUCTO = "+idProductoProveedor);
            pst.execute();
            resultado[0] = "true";
            resultado[1] = "Producto actualizado con éxito";
        } catch (SQLException ex) {
            resultado[0] = "false";
            resultado[1] = "No se ha podido actualizar el producto";
        }        
        return resultado;
    }
   
   public static String[] AgregarNuevoTipoDeProducto(Connection cnx,String tipoDeProducto)
    {
        String[] resultado = new String[2];
        try {
            PreparedStatement pst = cnx.prepareStatement("insert into TIPO_DE_PRODUCTO values(secuencia_id_tipo_de_producto.nextval,'"+tipoDeProducto+"')");
            pst.execute();
            resultado[0] = "true";
            resultado[1] = "Tipo de producto guardado con éxito";                    
        } catch (SQLException ex) {
            resultado[0] = "false";
            resultado[1] = "No se pudo guardar";
        }        
        return resultado;
    }
   
   public static String[] RegistrarNuevoProductoProveedor(Connection cnx, ProductoProveedor productoProveedor)
   {
        String[] resultado = new String[3];
        try {
            PreparedStatement pst = cnx.prepareStatement("insert into PRODUCTOS_PROVEEDOR values(secuencia_id_producto_proveedor.nextval,?,?,?,?,?,?,?,?)");
            pst.setString(1, productoProveedor.getDescripcion());
            pst.setString(2, productoProveedor.getMarca());
            pst.setString(3, productoProveedor.getFechaDeVencimiento());
            pst.setInt(4, productoProveedor.getPrecioDeCompra());
            pst.setInt(5, productoProveedor.getStock());
            pst.setInt(6, productoProveedor.getIdTipoDeProducto());
            pst.setString(7, productoProveedor.getRutProveedor());
            pst.setInt(8, productoProveedor.getEstadoDeProducto().getIdEstadoDeProducto());
            
            pst.execute();
            resultado[0] = "true";
            resultado[1] = "Producto guardado con éxito";                    
        } catch (SQLException ex) {
            resultado[0] = "false";
            resultado[1] = "No se pudo guardar el producto";
            resultado[2] = ex.getMessage();
        }        
        return resultado;
    }
   
   public static OrdenDePedido[] GetOrdenesDePedidoProveedor(Connection cnx, String rutProveedor)
    {
        String sql = "select o.ID_ORDEN_PEDIDO,e.ID_ESTADO,e.ESTADO,o.fecha_de_pedido,o.TOTAL, o.USUARIO_RUT, o.PROVEEDOR_RUT_PROVEEDOR from ORDEN_DE_PEDIDO o join ESTADO_DE_PEDIDO e on (o.ESTADO_DE_PEDIDO_ID_ESTADO = e.ID_ESTADO) WHERE PROVEEDOR_RUT_PROVEEDOR = '"+rutProveedor+"'"; 
        String sqlCount = "select count(*) from ORDEN_DE_PEDIDO o join ESTADO_DE_PEDIDO e on (o.ESTADO_DE_PEDIDO_ID_ESTADO = e.ID_ESTADO) WHERE PROVEEDOR_RUT_PROVEEDOR = '"+rutProveedor+"'";
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
   
   public static OrdenDePedido GetOrdenDePedidoProveedor(Connection cnx, int idOrdenDePedido){
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
   
   public static Pedidos[] GetPedidosProveedor(Connection cnx, int idOrdenDePedido){
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
   
   public static String[] ActualizarProductosAprobarPedido(Connection cnx, int idProductoProveedor, int cantidad)
    {
        String[] resultado = new String[3];
        try {        
            CallableStatement cst = cnx.prepareCall("{call ActualizarProductosAprobarPedido(?,?)}");        
            cst.setInt(1, idProductoProveedor);    
            cst.setInt(2, cantidad);  
            cst.execute();
            
            resultado[0] = "True";
            resultado[1] = "Actualizado con éxito";
            return resultado;
        }   
        catch (SQLException ex)        
        {
            resultado[0] = "False";
            resultado[1] = "Error en actualizar aprobación de orden de pedido";
            resultado[2] = ex.getMessage();
            return resultado;
        }
    }
}
