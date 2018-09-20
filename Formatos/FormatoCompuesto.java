/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formatos;

import editor.Elemento_Abstracto;


public class FormatoCompuesto extends Formato{
    
    private Formato f1;
    private Formato f2;
    
    public FormatoCompuesto(Formato f1, Formato f2){
        this.f1 = f1;
        this.f2 = f2;
    }
    
    public String formatear(String s) {
        return f2.formatear(f1.formatear(s));
    }
    
}
