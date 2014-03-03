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

/**
 *
 * @author alumno
 */
public class JDBCpreparedStatement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection conn = DriverManager.getConnection
            ("jdbc:oracle:thin:@localhost:1521:XE","system","javaoracle");
            PreparedStatement stmt = conn.prepareStatement
            ("select apellido from emp where emp_no = ?");
            stmt.setInt(1,7900);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            System.out.println(rs.getString(1));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
