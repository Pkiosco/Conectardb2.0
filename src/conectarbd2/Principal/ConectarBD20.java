/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectarbd2.Principal;

/**
 *
 * @author Casa
 */
public class ConectarBD20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        claseDML manejoSQL = new claseDML();
        manejoSQL.Conectar();
        
        manejoSQL.Select();
    }
    
}
