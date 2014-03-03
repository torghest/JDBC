/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author alumno
 */
public class JDBCconsultasAccion {
    public static void main(String[] args){
        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection conn = DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:XE","system","javaoracle");

            Statement stmt = conn.createStatement();
            int afectados = stmt.executeUpdate("delete from emp where apellido = 'tovar'");
            if (afectados == 0)
                System.out.println("Sin cambios ("+afectados+" registros afectados)");
            else
                System.out.println("Cambios realizados ("+afectados+" registros afectados)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
