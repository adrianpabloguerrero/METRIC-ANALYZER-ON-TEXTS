package Filtros;

import editor.Elemento_Abstracto;
import editor.Palabra;

public class FiltroPalabraLarga extends Filtro{

    private int cantidad;
    
    public FiltroPalabraLarga(int cant){
        cantidad = cant;
    }

     public FiltroPalabraLarga(){
        cantidad = 0;
    }
     
    public int getCantidad () {
           return cantidad;
    }

    public void setCantidad (int cantidad) {
           this.cantidad = cantidad;
    }
    
    public boolean cumple(Elemento_Abstracto e) {
        return ((Palabra) e).getCantLetras()>cantidad;
    }
}	

