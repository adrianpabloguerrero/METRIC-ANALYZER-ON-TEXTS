/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filtros;

import editor.Elemento_Abstracto;

    
public abstract class FiltroCompuesto extends Filtro{
    protected Filtro f1;
    protected Filtro f2;

    public FiltroCompuesto(Filtro f1, Filtro f2){
        this.f1 = f1;
        this.f2 = f2;
    }
}
