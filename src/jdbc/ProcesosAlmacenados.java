/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author alumno
 */
public class ProcesosAlmacenados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection conn = DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:XE","system","javaoracle");
            
            CallableStatement cs = conn.prepareCall("{call BORRA_EMPLEADO(?)}");
            cs.setInt(1, 7900);
            cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
