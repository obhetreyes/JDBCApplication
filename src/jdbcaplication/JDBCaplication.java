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
            String url = "jdbc:postgresql://localhost:5432/isma_4?user=skillet&password=1163138b";
            Connection conn = DriverManager.getConnection(url);
            System.out.println("Conexion realizada");
            Statement st = conn.createStatement();
            st.execute(" insert into " + 
                    " ismas2 (nombre,apellido,edad)" +
                    " values ('laura', 'Reyes', 16)");
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
