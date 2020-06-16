package controlador;

import clases.Producto;
import clases.TipoDeProducto;
import clases.TipoDeServicio;
import java.sql.Connection;
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
    
    public static Producto GetInfoProducto(Connection cnx, int idTipoDeProducto){
    String sql = "select * from producto where ID_PRODUCTO = "+idTipoDeProducto; 
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
}
