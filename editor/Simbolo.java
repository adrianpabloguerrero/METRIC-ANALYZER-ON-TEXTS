package editor;

public class Simbolo extends Cadena{

    public Simbolo (int start, int end, String text) {
        super(start,end,text);
    }
    
    public Simbolo(String s) {
        super(s);
    }
    
    public Simbolo() {
        super();
    }

    public int getCantLetras() {
        return 0;
    }

    @Override
    public double getCantPalabras() {
        return 0;
    }

    @Override
    public double getCantPolisilabas() {
        return 0;
    }
    
    @Override
    public double getCantSilabas() {
        return 0;
    }

    @Override
    public Elemento_Abstracto getElemento(int pos) {
        return null;
    }

    @Override
    public int getPos(Elemento_Abstracto e) {
        return -1;
    }
    
    @Override
    public Elemento_Abstracto copia() {
        Simbolo p = new Simbolo();
        p.setCadena(cadena);
        p.setFormato(formato);
        return p;
    }

    @Override
    public void aceptar(Visitor v) {
        
    }

}