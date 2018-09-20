
package Filtros;

import editor.Elemento_Abstracto;

public class FiltroAnd extends FiltroCompuesto{

    public FiltroAnd(Filtro f1, Filtro f2){
        super(f1,f2);
    }
    
    public boolean cumple(Elemento_Abstracto e) {
        return f1.cumple(e) && f2.cumple(e);
    }
    
}
