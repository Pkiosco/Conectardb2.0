/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectarbd2.Principal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.sql.Connection;
import java.sql.DriverManager;
public abstract class ClaseConexion {
    
    


    public static Connection GetConexion() throws Exception {
        int numLineas=9;
        int contador=1;    
        
        

        
        String dato []=new String [numLineas];
        File archivo = new File ("C:\\archivo.txt");
        BufferedReader reader = new BufferedReader(new FileReader(archivo));
        String linea = reader.readLine();

        

        while (linea != null && contador<numLineas){
                if(contador % 2 == 0){

                linea = reader.readLine();
                dato[contador]=linea;
                }
                
        contador++;
        }

        
        
        String dbConnString = "jdbc:mysql://"+dato[2]+"/"+dato[4]+""; //3306 puesto default 
        // Tipo de Bda Conectar - Puerto del puerto - Nombre BD
        
        // Establece el usuario de la base de datos
        String dbUser = dato[6];
        
        // Establece la contraseña de la base de datos
        String dbPassword = dato[8];
        
        // Establece el driver de conexion
        //Class.forName(dbDriver).newInstance();
        
        // Retorna la conexion
        return DriverManager.getConnection(dbConnString, dbUser, dbPassword);
    
    }   
}
    
