/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectarbd2.Principal;

import java.util.Scanner;

/**
 *
 * @author Casa
 */
public class ConectarBD20 {

    /**
     * @param args the command line arguments
     */
    static int opcionBrow;
    public static void main(String[] args) throws Exception {
        Scanner tecladoIN = new Scanner(System.in);     
        claseDML manejoSQL = new claseDML();
        
        System.out.println("Bienvenido a la prueba de manejo DML");
        
        System.out.println("Por favor seleccione la opcion deseada");
        

        while (opcionBrow != 99){
        if (claseDML.isConectado() == false){
            System.out.println("0-Conectar - 'No hay conexion activa'");
        }else {
            System.out.println("1-Desconectar \n2-Seleccion \n3-Insertar\n4-Actualizar\n5-Borrar");
        }
        opcionBrow = tecladoIN.nextInt();
        
                switch(opcionBrow){

                    case 0:
                        manejoSQL.Conectar();
                        break;
                    case 1:
                        manejoSQL.Select();
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                       break;
                    case 5:

                        break;
                    default:
                        System.out.println("Opcion ingresada Incorrecta");
                        System.out.println("Debe elegir una opcion entre 0 y 5");    
                        break;
                } 
            System.out.println("¿Desea continuar cargando? s/n");
            String continua;
            continua = tecladoIN.next();
                if (continua.toUpperCase().equals("N")){
                opcionBrow = 99;
                }
        
            }
        }    

        
    }
    

