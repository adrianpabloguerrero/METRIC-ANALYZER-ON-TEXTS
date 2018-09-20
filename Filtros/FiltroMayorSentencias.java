package Filtros;

import editor.Elemento_Abstracto;
import editor.Elemento_texto;

public class FiltroMayorSentencias extends Filtro{

    private int cantidad;
    
    public FiltroMayorSentencias(int cant){
        cantidad = cant;
    }

    public int getCantidad () {
           return cantidad;
    }

    public void setCantidad (int cantidad) {
           this.cantidad = cantidad;
    }
    
    public boolean cumple(Elemento_Abstracto e) {
        return ((Elemento_texto) e).getCantSentencias()>cantidad;
    }
        
}	

