package editor;

import java.util.ArrayList;

public class Sentencia extends Elemento_Abstracto{

    private ArrayList<Cadena> cadenas;
 
    public Sentencia() {
        cadenas = new ArrayList<Cadena>();
        formato = null;
        padre = null;
    }

    public Sentencia(ArrayList<Cadena> c) {
        cadenas = c;
        formato = null;
        padre = null;
    }

    public ArrayList<Cadena> getCadenas() {
        return cadenas;
    }

    @Override
    public double getCantPalabras() {
        int count = 0;
        for(int i = 0; i < cadenas.size(); i++)
            count += this.getElemento(i).getCantPalabras();
        return count;
    }
    
    @Override
    public double getCantSilabas() {
        double aux = 0;
        for (int i = 0; i < cadenas.size(); i++) {
            aux = aux + cadenas.get(i).getCantSilabas();
        }
        return aux;
    }
    @Override
    public double getCantPolisilabas() {
        double aux = 0;
        for (int i = 0; i < cadenas.size(); i++) {
           aux = aux + cadenas.get(i).getCantPolisilabas();
                }
        return aux;
    }
        
    @Override
    public Elemento_Abstracto getElemento(int pos) {
        if((cadenas!=null) && (pos < cadenas.size()))
            return cadenas.get(pos);
        else
            return null;
    }

    @Override
    public int getPos(Elemento_Abstracto e) {
        for (int i=0; i<cadenas.size(); i++){
            if (cadenas.get(i).equals(e))
                return i;
        }
        return -1;
    }

    public void addCadena(Cadena c){
        cadenas.add(c);
    }

    @Override
    public Elemento_Abstracto copia() {
        Sentencia s = new Sentencia();
        s.setFormato(formato);
        for(int i=0; i<cadenas.size();i++){
            Cadena hijo = (Cadena) cadenas.get(i).copia();
            s.addCadena(hijo);
            hijo.setPadre(s);
        }
        return s;
    }

    @Override
    public boolean equals(Object s){
        if ((s != null) && (((Sentencia)s).getPadre().equals(padre))){
            for (int i=0; i<cadenas.size(); i++)
                if (!cadenas.get(i).equals(((Sentencia)s).getElemento(i)))
                    return false;
            return true;
        }
        return false;
    }
    
    @Override
    public void imprimir() {
            
        System.out.print("Nueva sentencia: ");
      
        for (int i = 0; i < cadenas.size(); i++) {
                System.out.print(" ");
                cadenas.get(i).imprimir();
        }
        System.out.print(". ");
    }

    @Override
    public void aceptar (Visitor v) {
        v.visit(this);
        for (int i=0; i<cadenas.size(); i++)
            cadenas.get(i).aceptar(v);
    }

    @Override
    public String listar() {
        String texto = " ";
        for (int i = 0; i < cadenas.size(); i++) {
            texto = texto + cadenas.get(i).listar() + " ";
            }
        if (formato!= null)
            texto = formato.formatear(texto);
     return texto;       
    }
}