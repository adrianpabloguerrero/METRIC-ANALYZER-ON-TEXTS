package Filtros;

import editor.Elemento_Abstracto;
import editor.Palabra;

public class FiltroMayuscula extends Filtro{
      
    public FiltroMayuscula(){     
    }
    
    public boolean cumple(Elemento_Abstracto e) {
        char primera = ((Palabra) e).getCadena().charAt(0);
        return (primera >= 'A') && (primera <= 'Z');
    }
}	
