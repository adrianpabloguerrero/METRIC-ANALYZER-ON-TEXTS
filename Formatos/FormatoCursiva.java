/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formatos;

import editor.Elemento_Abstracto;


public class FormatoCursiva extends Formato {

    public FormatoCursiva(){
        
    }
    
    public String formatear (String s) {
   return ("<i>"+s+"</i>");   
    }
    
}
