/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcaplication;

import java.sql.*;

/**
 *
 * @author obhet
 */
public class JDBCaplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //carga del controlador (Driver) JDBC
        try {
            Class.forName("org.postgresql.Driver");
            //com.mysql.jdbc.Driver
            System.out.println("Carga exitosa");
            //String url = "jdbc:Mysql//localhost/itse";   
            String url = "jdbc:postgresql://localhost/isma_4?user=skillet&password=1163138b";
            Connection conn = DriverManager.getConnection(url);
            System.out.println("Conexion realizada");
            Statement st = conn.createStatement();
            
        st.execute("INSERT INTO " + "ismas2 (nombre,apellido,edad)" + "VALUES ('obhet','Reyes', 16)");
        st.execute("INSERT INTO " + "ismas2 (nombre,apellido,edad)" + "VALUES ('bithia','ballina', 17)");
        st.execute("INSERT INTO " + "ismas2 (nombre,apellido,edad)" + "VALUES ('laura','lizbeth', 18)");
        
            
        String sql = "DELETE FROM ismas2 WHERE id=34";
        st.executeUpdate(sql);
            
        
        ResultSet rs = st.executeQuery("SELECT * FROM ismas2");
         while ( rs.next() ) {
            int id = rs.getInt("id");
            String  nombre = rs.getString("nombre");
            String  apellido = rs.getString("apellido");
            int edad  = rs.getInt("edad");
            System.out.println( "ID = " + id );
            System.out.println( "Nombre = " + nombre);
            System.out.println( "Apellido = " + apellido);
            System.out.println( "Edad = " + edad);
            System.out.println();     
         
         
        }
            conn.close();
        
        } catch (ClassNotFoundException ex) {
            System.out.println("error: contolador!");
            System.exit(1);
        } catch (SQLException ex) {
            System.out.println("Error: conexion!");
            ex.printStackTrace();
        }
    }

}
