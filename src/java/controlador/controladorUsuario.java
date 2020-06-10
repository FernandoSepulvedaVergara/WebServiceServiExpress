package controlador;

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
                                                         +"VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        
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
            pst.setInt(11, nuevoUsuario.getIdtipoUsuario());
            pst.setInt(12, nuevoUsuario.getComuna());
        
            pst.execute();       
            return true;
    }   
    
    catch (SQLException ex)        
        {
            System.out.println("Error insert \n"+ex.getMessage());
        return false;
        }
    }
}

