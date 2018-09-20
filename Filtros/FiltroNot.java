package Filtros;

import editor.Elemento_Abstracto;
import editor.Palabra;

public class FiltroNot extends Filtro{
      
    private Filtro f;
    
    public FiltroNot(Filtro f){     
        this.f = f;
    }
    
    public boolean cumple(Elemento_Abstracto e) {
        return (!f.cumple(e));
    }
}	
