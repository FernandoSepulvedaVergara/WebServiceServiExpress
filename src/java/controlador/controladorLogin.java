package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class controladorLogin {
    
    public static String[] ValidarUsuario(Connection cnx,String user, String pass)
    {
        String sql = "select u.rut, u.nombre_de_usuario, u.contraseña, u.tipo_de_usuario_id_tipo_de_usuario from usuario u join tipo_de_usuario t on (u.tipo_de_usuario_id_tipo_de_usuario = t.id_tipo_de_usuario)"
                    +"where u.contraseña='"+pass+"' and u.nombre_de_usuario='"+user+"' and u.ESTADO_DE_USUARIO_ID_ESTADO_DE_USUARIO = 1";           
        Statement st = null;
        ResultSet rs = null;
    
        try {
            st = cnx.createStatement();
            rs = st.executeQuery(sql);
            String[] data = new String[4];
            while (rs.next()) {
                
                for (int i = 0; i < 4; i++) {
                    
                    if(rs.getString(i+1)!=null)
                    {
                    data[i] = rs.getString(i+1);
                    }
                    else{return null;}                    
                }
            }                          
        return data;  
        }  
        catch (SQLException e) 
        {
            System.out.println("Error al obtener datos \n" + e.getMessage());
        return null;
        }        
    }    
    
     public static String[] ValidarUsuarioProveedor(Connection cnx,String user, String pass)
    {
        String sql = "select RUT_PROVEEDOR, \"RAZÓN_SOCIAL\", NOMBRE_DE_USUARIO, \"CONSTRASEÑA\" from proveedor "
                    +"where NOMBRE_DE_USUARIO='"+user+"' and \"CONSTRASEÑA\" = '"+pass+"' and ESTADO_DE_USUARIO_ID_ESTADO_DE_USUARIO = 1";           
        Statement st = null;
        ResultSet rs = null;
    
        try {
            st = cnx.createStatement();
            rs = st.executeQuery(sql);
            String[] resultado = new String[4];
            while (rs.next()) {                
                resultado[0] = rs.getString(1);
                resultado[1] = rs.getString(2);
                resultado[2] = rs.getString(3);
                resultado[3] = rs.getString(4);
            }                          
        return resultado;  
        }  
        catch (SQLException e) 
        {
            System.out.println("Error al obtener datos \n" + e.getMessage());
        return null;
        }        
    }
}
