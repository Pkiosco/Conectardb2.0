/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectarbd2.Principal;

import java.sql.Connection;
import java.sql.DriverManager;
public abstract class ClaseConexion {
    public static Connection GetConexion() throws Exception {

        String dbConnString = "jdbc:mysql://localhost/j2se"; //3306 puesto default 
        // Tipo de Bda Conectar - Puerto del puerto - Nombre BD
        
        // Establece el usuario de la base de datos
        String dbUser = "Kiosco";
        
        // Establece la contraseña de la base de datos
        String dbPassword = "146921";
        
        // Establece el driver de conexion
        //Class.forName(dbDriver).newInstance();
        
        // Retorna la conexion
        return DriverManager.getConnection(dbConnString, dbUser, dbPassword);
    
    }   
}
    
