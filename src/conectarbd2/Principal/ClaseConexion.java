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
    /*
    se usa un archivo txt en ruta c\datos con la estructura
    ----Servidor
    Aca el nombre del servidor
    ----Base
    aca el nombre de la base
    ----usuario
    aca el nombre de usuario
    ----Pswd
    aca el password
    ----Servidor
localhost
----Base
j2se
----Usuario
Kiosco
----pass
146921




      */
    


    public static Connection GetConexion() throws Exception {
        int numLineas=9;
        int contador=0;    
        
        //componentes para leer txt
        String dato []=new String [numLineas];
        File archivo = new File ("C:\\datos.txt");
        BufferedReader reader = new BufferedReader(new FileReader(archivo));
        String linea = reader.readLine();
        //TRAIGO LOS CAMPOS DEL TXT
        while (linea != null && contador<numLineas){
        linea = reader.readLine();
               if(contador % 2 == 0){
               dato[contador]=linea.toString();
                }
        contador++;
        }
            String dbConnString = "jdbc:mysql://"+dato[0]+"/"+dato[2]+""; //3306 puesto default 
        // Tipo de Bda Conectar - Puerto del puerto - Nombre BD
        
        // Establece el usuario de la base de datos
        String dbUser = dato[4];
        
        // Establece la contraseña de la base de datos
        String dbPassword = dato[6];
        
        // Establece el driver de conexion
        //Class.forName(dbDriver).newInstance();
        
        // Retorna la conexion
        return DriverManager.getConnection(dbConnString, dbUser, dbPassword);
    
    }   
}
    
