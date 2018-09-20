package Metricas;

import editor.Elemento_texto;

public class Smog extends CalculadorMetrica {

	@Override
	public double calcular(Elemento_texto e) {
		return (1.0430 * (Math.sqrt(e.getCantPolisilabas() * (30 / e.getCantSentencias()) + 3.1291)));
	}
	

}
