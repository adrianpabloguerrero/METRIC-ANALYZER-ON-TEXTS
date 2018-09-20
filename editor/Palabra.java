package editor;

public class Palabra extends Cadena{

    private Silabeador silabeador;

    public Palabra(int start, int end, String text) {
        super(start,end,text);
        silabeador = new Silabeador();
    }

    public Palabra(String p) {
        super(p);
        silabeador = new Silabeador();
    }

    public Palabra() {
        super();
        silabeador = new Silabeador();
    }

    public int getCantLetras() {
        return cadena.length();
    }

    @Override
    public double getCantPalabras() {
        return 1;
    }

    @Override
    public double getCantPolisilabas() {
        if (silabeador.getCantSilabas(this) > 2)
            return 1;
        else
            return 0;
    }
    
    @Override
    public double getCantSilabas() {
        return silabeador.getCantSilabas(this);
    }

    @Override
    public Elemento_Abstracto getElemento(int pos) {
        return null;
    }
    
    public void setSilabeador(Silabeador s){
        this.silabeador = s;
    }
    
    @Override
    public Elemento_Abstracto copia() {
        Palabra p = new Palabra();
        p.setCadena(cadena);
        p.setSilabeador(silabeador);
        p.setFormato(formato);
        return p;
    }

    @Override
    public void aceptar (Visitor v) {
        v.visit(this);
    }   
}