package editor;

import Filtros.Filtro;
import Formatos.Formato;
import Metricas.CalculadorMetrica;
import java.util.ArrayList;

public abstract class Elemento_Abstracto {
    
        protected Formato formato;
        protected Elemento_Abstracto padre;
                
        public abstract void aceptar (Visitor v); 
        public abstract void imprimir();
        public abstract double getCantPalabras();
        public abstract double getCantSilabas();
        public abstract double getCantPolisilabas();
        public abstract Elemento_Abstracto getElemento(int pos);
        public abstract int getPos(Elemento_Abstracto e);
        public abstract String listar ();
        public abstract Elemento_Abstracto copia();
        public abstract boolean equals(Object o);
        
        public Elemento_Abstracto getPadre(){
            return padre;
        }
        
        public Formato getFormato(){
            return formato;
        }
        
        public void setPadre(Elemento_Abstracto p){
            padre = p;
        }
        
        public void setFormato(Formato f){
            formato = f;
        }
      

}
