
package editor;

import java.util.ArrayList;

public class Seccion extends Elemento_texto {

    private Sentencia titulo;
    private int nivel;
    private ArrayList<Elemento_texto> elementos;

    public Seccion() {
        elementos = new ArrayList<Elemento_texto>();
        titulo = new Sentencia();
        formato = null;
        padre = null;
    }

    public Seccion(Sentencia t) {
        titulo=t;
        elementos = new ArrayList<Elemento_texto>();
        formato = null;
        padre = null;
    }

    public int getNivel(){
        return nivel;
    }

    public ArrayList <Elemento_texto> getElementos() {
        return elementos;
    }

    public Sentencia getTitulo() {
        return titulo;
    }

    public double getCantPalabras() {
        double count = titulo.getCantPalabras();
        for (int i = 0; i < elementos.size(); i++) {
            count = count + elementos.get(i).getCantPalabras(); 
        }
        return count;
    }

    @Override
    public double getCantSentencias() {
        double count=0;	
        if (titulo.getCantPalabras()!=0)
            count ++;
        for (int i = 0; i < elementos.size(); i++) {
                count = count + elementos.get(i).getCantSentencias(); 
        }
        return count;
    }

    @Override
    public int getCantParrafos(){
        int count = 0;
        for(int i=0; i<elementos.size(); i++){
            count += elementos.get(i).getCantParrafos();
        }
        return count;
    }

    @Override
    public double getCantSilabas() {
        double count = titulo.getCantSilabas();
        for (int i = 0; i < elementos.size(); i++) {
                count = count + elementos.get(i).getCantSilabas(); 
        }
        return count;		
    }

    @Override
    public double getCantPolisilabas() {
        double count = titulo.getCantPolisilabas();
        for (int i = 0; i < elementos.size(); i++) {
                count = count + elementos.get(i).getCantPolisilabas(); 
        }
        return count;		
    }

    @Override
    public Elemento_Abstracto getElemento(int pos) {
        if((elementos!=null) && (pos < elementos.size()))
            return elementos.get(pos);
        else
            return null;
    }

    @Override
    public int getPos(Elemento_Abstracto e) {
        for (int i=0; i<elementos.size(); i++){
            if (elementos.get(i).equals(e))
                return i;
        }
        return -1;
    }

    public void setTitulo(Sentencia t){
        titulo = t;
    }

     public void setNivel (int nivel){
        this.nivel = nivel;
    }

    public void addElemento(Elemento_texto e) {
        elementos.add(e);
    }

    @Override
    public void imprimir(){
        System.out.print("Nueva Seccion: ");
        System.out.print("TITULO: ");
        titulo.imprimir();
        System.out.println();
        for (int i = 0; i < elementos.size(); i++) {
            elementos.get(i).imprimir();
        }
    }

    @Override
    public boolean equals (Object s){
        if ((s != null) && (((Seccion)s).getPadre().equals(padre))){
            for (int i=0; i<elementos.size(); i++)
                if (!elementos.get(i).equals(((Seccion)s).getElemento(i)))
                    return false;
            return true;
        }
        return false;
    }     

    @Override
    public Elemento_Abstracto copia() {

        Seccion s = new Seccion();
        s.setNivel(nivel);
        s.setTitulo((Sentencia)titulo.copia());
        s.setFormato(formato);
        for(int i=0; i<elementos.size();i++){
            Elemento_texto hijo = (Elemento_texto) elementos.get(i).copia();
            s.addElemento(hijo);
            hijo.setPadre(s);
        }
        return s;
    }

    @Override
    public String listar() {
        String texto= "";
        if (!titulo.getCadenas().isEmpty())
            texto= texto + "<h"+ Integer.toString(nivel) + ">"+titulo.listar() + "</h"+ Integer.toString(nivel) + ">" + "\n";
        for (int i = 0; i < elementos.size(); i++)
            texto =  texto + elementos.get(i).listar() + "\n";
        if (formato != null)
            texto = formato.formatear(texto);
        return texto;
    }

    @Override
    public void aceptar (Visitor v) {
        v.visit(this);
        titulo.aceptar(v);
        for (int i=0; i<elementos.size(); i++)
            elementos.get(i).aceptar(v);
    }
}
