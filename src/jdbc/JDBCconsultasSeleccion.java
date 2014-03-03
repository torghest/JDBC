/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alumno
 */
public class JDBCconsultasSeleccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            Connection conn = DriverManager.getConnection
            ("jdbc:oracle:thin:@localhost:1521:XE","system","javaoracle");
            
            String[] campos = {"emp_no","apellido","oficio"};
            Statement stmt = conn.createStatement();

            ResultSet res = stmt.executeQuery("Select "+campos[0]+","+campos[1]+","+campos[2]+" from emp");

            while (res.next()){
                System.out.print("//");
                for (int i = 0; i < 3; i++)
                    System.out.print(res.getString(campos[i])+"//");
                System.out.println("");
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
