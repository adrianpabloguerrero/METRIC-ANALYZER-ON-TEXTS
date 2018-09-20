package editor;

import java.util.ArrayList;

public class Parrafo extends Elemento_texto {

    private ArrayList<Sentencia> sentencias;

    public Parrafo() {
        sentencias = new ArrayList<Sentencia>();
        formato = null;
        padre=null;
    }

    public ArrayList<Sentencia> getSentencias() {
        return sentencias;
    }

    @Override
    public double getCantPalabras() {
        double count = 0;
        for (int i = 0; i < sentencias.size(); i++) {
                count = count + sentencias.get(i).getCantPalabras();
        }
        return count;
    }
    
    @Override
    public double getCantSentencias() {
            return sentencias.size();
    }

    @Override
    public double getCantSilabas() {
        double aux = 0;
        for (int i = 0; i < sentencias.size(); i++) {
            aux = aux + sentencias.get(i).getCantSilabas();
        }
        return aux;		
    }
    
    @Override
    public double getCantPolisilabas() {
        double aux = 0;
        for (int i = 0; i < sentencias.size(); i++) {
            aux = aux + sentencias.get(i).getCantPolisilabas();
        }
        return aux;		
    }

    @Override
    public int getCantParrafos() {
        return 1;
    }

    @Override
    public Elemento_Abstracto getElemento(int pos) {
        if((sentencias!=null) && (pos < sentencias.size()))
            return sentencias.get(pos);
        else
            return null;
    }
    
    public int getPos(Elemento_Abstracto e) {
        for (int i=0; i<sentencias.size(); i++){
            if (sentencias.get(i).equals(e))
                return i;
        }
        return -1;
    }
    
    public void addSentencia(Sentencia s){
        sentencias.add(s);
    }

    @Override
    public void imprimir(){
        System.out.print("Nuevo Parrafo: ");
        if(formato!=null)
            System.out.print("<negrita>");
        for (int i = 0; i < sentencias.size(); i++) {
                sentencias.get(i).imprimir();
        }
        System.out.println();
    }

    public boolean equals (Object p){
        if ((p != null) && (((Parrafo)p).getPadre().equals(padre))){
            for (int i=0; i<sentencias.size(); i++)
                if (!sentencias.get(i).equals(((Parrafo)p).getElemento(i)))
                    return false;
            return true;
        }
        return false;
    }
    
    @Override
    public Elemento_Abstracto copia() {
        Parrafo p = new Parrafo();
        p.setFormato(formato);
        for(int i=0; i<sentencias.size();i++){
            Sentencia hijo = (Sentencia) sentencias.get(i).copia();
            p.addSentencia(hijo);
            hijo.setPadre(p);
        }
        return p;
    }
    
    @Override
    public void aceptar (Visitor v) {
        v.visit(this);
        for (int i=0; i<sentencias.size(); i++)
            sentencias.get(i).aceptar(v);
    }


    @Override
    public String listar() {
        String texto = "";
        for (int i = 0; i < sentencias.size(); i++)
            texto = texto + sentencias.get(i).listar() + ". "; 
        if (formato!= null)
            texto = formato.formatear(texto);
        return texto;
    }
}