/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formatos;

import editor.Elemento_Abstracto;

/**
 *
 * @author Juani Rimoldi
 */
public class FormatoSubrayado extends Formato {

    public FormatoSubrayado(){
        
    }
    
    public String formatear (String s) {
           return ("<u>"+s+"</u>");   
        
    }
    
}
