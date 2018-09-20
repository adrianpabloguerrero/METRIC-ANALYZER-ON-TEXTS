
package editor;

import Metricas.CalculadorMetrica;

public abstract class Elemento_texto extends Elemento_Abstracto{

	
    protected CalculadorMetrica calculador;
    
    public abstract double getCantSentencias();
    public abstract int getCantParrafos();
    
    public void setearMetrica(CalculadorMetrica m) {
		calculador = m;
	}
    
    public CalculadorMetrica getMetrica () {
    	return calculador;
    }
	
	public double getMetrica (CalculadorMetrica calculador){
		return calculador.calcular(this);}
		
	}
        
        


