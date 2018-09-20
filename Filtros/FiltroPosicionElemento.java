package Filtros;

import editor.Elemento_Abstracto;
import editor.Palabra;

public class FiltroPosicionElemento extends Filtro{

    private int posicion;
    
    public FiltroPosicionElemento(int pos){
        posicion = pos;
    }

    public int getPosicion () {
           return posicion;
    } 

    public void setPosicion (int pos) {
           this.posicion = pos;
    }
    
    public boolean cumple(Elemento_Abstracto e) {
        return (e.getPadre()!= null) && (e.getPadre().getElemento(posicion).equals(e));
    }
}	
