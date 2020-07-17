package controlador;

import clases.Comuna;
import clases.Region;
import clases.TipoDeUsuario;
import clases.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class controladorUsuario {
    
    public static boolean ValidarRut(Connection cnx,String rut)
    {
        String sql = "select rut from usuario "
                    +"where rut='"+rut+"'";     
        Statement st = null;
        ResultSet rs = null;
        boolean resultado = false;
        
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
    
     public static boolean ValidarEmail(Connection cnx,String email)
    {
        String sql = "select email from usuario "
                    +"where email='"+email+"'";     
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
     
     public static boolean ValidarNombreUsuario(Connection cnx,String nombreUsuario)
    {
        String sql = "select nombre_de_usuario from usuario "
                    +"where nombre_de_usuario='"+nombreUsuario+"'";     
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
    
    public static boolean IngresarUsuario(Connection cnx,Usuario nuevoUsuario)
    {
        try {        
            PreparedStatement pst = cnx.prepareStatement("INSERT INTO USUARIO "
                                                         +"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        
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
            return true;
    }   
    
    catch (SQLException ex)        
        {
            System.out.println("Error insert \n"+ex.getMessage());
        return false;
        }
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
}

