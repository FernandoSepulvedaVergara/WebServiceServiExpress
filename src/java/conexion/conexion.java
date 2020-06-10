package conexion;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conexion {
    
    private static Connection conn = null;
    private static String login = "SYSTEM";
    private static String password = "oracle12345";
    private static String url = "jdbc:oracle:thin:@localhost:1521:sidoraclepor";
    
   public static Connection getConnection()
   {
       try 
       {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           conn = DriverManager.getConnection(url,login,password);
           conn.setAutoCommit(true);
           if(conn !=null)
           {System.out.println("Conexión establecida a oracle 19c");
           }
           else           
           {
               System.out.println("No se ha logrado conectar");
           }
           return conn;
       } 
       catch (ClassNotFoundException | SQLException e) 
       {
           JOptionPane.showMessageDialog(null, "Conexión errónea " + e.getMessage());
       }
       return null;
   }
   
   public void desconectar()
   {
       try {           
           conn.close();
           System.out.println("Desconexión");
       } 
       catch (Exception e) 
       {
           System.out.println("Error en la desconexión a la base de datos " + e.getMessage());
       }
   } 
}
