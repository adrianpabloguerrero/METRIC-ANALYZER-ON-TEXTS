package Filtros;

import editor.Elemento_Abstracto;

public class FiltroMayorPalabras extends Filtro{

    private int cantidad;
    
    public FiltroMayorPalabras(int cant){
        cantidad = cant;
    }

    public int getCantidad () {
           return cantidad;
    }

    public void setCantidad (int cantidad) {
           this.cantidad = cantidad;
    }
    
    public boolean cumple(Elemento_Abstracto e) {
        return e.getCantPalabras()>cantidad;
    }
        
}	

