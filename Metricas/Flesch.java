package Metricas;

import editor.Elemento_texto;

public class Flesch extends CalculadorMetrica{

        private double a,b,c;
        
        public Flesch(double a, double  b, double c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
	@Override
	public double calcular (Elemento_texto e) {
            return (a + b * (e.getCantPalabras()/e.getCantSentencias()) + c * (e.getCantSilabas()/e.getCantPalabras()));
	}

}
