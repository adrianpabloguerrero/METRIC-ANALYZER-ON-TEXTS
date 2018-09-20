package Filtros;

import editor.Elemento_Abstracto;
import editor.Palabra;
import java.util.ArrayList;

public class FiltroTipoPalabra extends Filtro{
    
    private ArrayList<String> lista;
    
    public FiltroTipoPalabra(ArrayList<String> lista){
        this.lista = lista;
    }

    @Override
    public boolean cumple(Elemento_Abstracto e) {
        for(int i=0; i<lista.size(); i++)
            if (lista.get(i).toLowerCase().equals(((Palabra) e).getCadena().toLowerCase()))
                return true;
        return false;
    }
}
