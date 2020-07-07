package controlador;

import clases.EstadoDeProducto;
import clases.ProductoProveedor;
import clases.TipoDeProducto;
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
}
