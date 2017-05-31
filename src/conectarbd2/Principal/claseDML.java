/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectarbd2.Principal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Casa
 */

public  class claseDML {

static String insert;
static String update;
static String delete;
int id;
 static Connection laConexion;
Scanner tecladoIN = new Scanner(System.in); 

    public void Conectar() throws Exception    {

      laConexion =  ClaseConexion.GetConexion();
    }
    public void Desconectar() throws Exception {
        laConexion.close();
    }
    public void Select() throws Exception    {

        Connection laConexion = ClaseConexion.GetConexion();
        // Arma la consulta y la ejecuta
        String laConsulta = "SELECT * FROM alumnos";
        Statement stmtConsulta = laConexion.createStatement();
        ResultSet rs = stmtConsulta.executeQuery(laConsulta);
        
        // Muestra los datos
        while( rs.next() )
            System.out.println( "ID: " + rs.getInt("alu_id") + " -- " + "Nombre: " + rs.getString("alu_nombre") + " -- " + "Apellido: " + rs.getString("alu_apellido") );
        
        // Cierra el Statement y la Connection
        stmtConsulta.close();
    }
     
    public void Eliminar(int id)throws Exception{
        // Define la conexion
        
        claseDML Muestra = new claseDML();
        Muestra.Select();
        System.out.println("Ingrese el valor numerico del Id a Eliminar");
        id = tecladoIN.nextInt();
        delete = "DELETE FROM alumnos WHERE alu_id = "+ id ;
        // Arma la sentencia de eliminación y la ejecuta
        Statement stmtEliminacion = laConexion.createStatement();
        stmtEliminacion.execute(delete);
        
        // Cierra el Statement y la Connection
        stmtEliminacion.close();
        
        // Informa que la eliminación ha sido realizada con éxito
        System.out.println("La eliminación ha sido realizada con éxito...");
    }    
    
    public void Insertar(String nombre, String apellido)throws Exception{
        Statement stmtInsercion = laConexion.createStatement();
        insert = "INSERT INTO alumnos ( alu_nombre, alu_apellido)  VALUES  ( '" + nombre + "'  , '" +apellido +"')";
        stmtInsercion.execute(insert);
        
        // Cierra el Statement y la Connection
        stmtInsercion.close();
        
        // Informa que la inserción ha sido realizada con éxito
        System.out.println("La inserción ha sido realizada con éxito...");
        }
    
    public void upDate(int id,  String nombre, String apellido)throws Exception{
    {
        // Define la conexion
        // Arma la sentencia de actualización y la ejecuta
        String laActualizacion = "UPDATE alumnos SET alu_apellido = ' "+apellido+"', alu_nombre= ' "+nombre+"'  WHERE alu_id = "+id;
        Statement stmtActualizacion = laConexion.createStatement();
        stmtActualizacion.execute(update);
        
        // Cierra el Statement y la Connection
        stmtActualizacion.close();
       
        // Informa que la actualización ha sido realizada con éxito
        System.out.println("La actualización ha sido realizada con éxito...");
    }    
    
}

}