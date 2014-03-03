package jdbc;

import java.sql.*;

public class JDBCAutoCommit {

    public static void main (String args[]){
        try{
            DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
            Connection conexion = DriverManager.getConnection
                ("jdbc:oracle:thin:@localhost:1521:xe","system", "javaoracle");


            //Activamos el modo setAutoCommit(false) para que almacene todo
            conexion.setAutoCommit(false);


            //Primera Sentencia
            PreparedStatement prepararselect= conexion.prepareStatement("update emp set salario= salario*1.10 where apellido=?"); 
            prepararselect.setString(1,"negro"); //Para el parametro
            prepararselect.executeUpdate();

            //Segunda Sentencia
            PreparedStatement prepararselect2= conexion.prepareStatement("update emp set salario= salario+5000 where apellido=?"); 
            prepararselect2.setString(1,"sala"); //Para el parametro
            prepararselect2.executeUpdate();


            //Validamos la transacción

            //conexion.commit(); 
            conexion.rollback(); 

        }catch(Exception e){
            System.out.println("Error: "+e.toString());
        }
    }
}
