
package editor;

public abstract class Cadena extends Elemento_Abstracto{
    protected String cadena;
    protected int start;
    protected int end;
    protected String text;
    
    public Cadena (int start, int end, String text) {
        this.start = start;
        this.end = end;
        cadena = text;
        formato = null;
        padre = null;
    }
    
    public Cadena(String c) {
        cadena = c;
        formato = null;
        padre = null;
    }
    
    public Cadena() {
        cadena = null;
        formato = null;
        padre = null;
    }
    
    public abstract int getCantLetras();
    public abstract double getCantPalabras();
    public abstract double getCantPolisilabas();
    public abstract double getCantSilabas();
    public abstract Elemento_Abstracto copia();
    
    public String getCadena(){
        return cadena;
    }
    
      public int getPos(Elemento_Abstracto e) {
        return -1;
    }
    
    public void setCadena(String c){
        cadena = c;
    }
    
    public boolean equals(Object p) {
        if (p == null)
            return false;
        else
            return (cadena.equals(((Cadena)p).getCadena()));
    }
    
    public void imprimir() {
        System.out.print(cadena);
    }
    
    public String listar() {
        if (formato == null)
            return cadena;
        else 
            return formato.formatear(cadena);
    }
	
}
