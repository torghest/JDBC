/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 *
 * @author alumno
 */
public class JDBCResultSetMetaData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection conn = DriverManager.getConnection
                    ("jdbc:oracle:thin:@localhost:1521:XE","system","javaoracle");
            
            PreparedStatement sentencia = conn.prepareStatement("select * from emp");
            ResultSet rs = sentencia.executeQuery();
            ResultSetMetaData columnas = sentencia.getMetaData();
            int campos = columnas.getColumnCount();

            System.out.println("NOMBRE DE LAS COLUMNAS");
            //Imprimir nombre de columnas
            for(int j=0; j <campos;j++){
                System.out.print(columnas.getColumnName(j+1).toUpperCase()+"-");
            }
            System.out.println("\nREGISTROS");

            //Imprimir datos gracias a las columnas

            while (rs.next()){
                for(int j=0; j < campos; j++){
                    System.out.print(rs.getString(j+1)+"//");
                }
                System.out.println("");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
