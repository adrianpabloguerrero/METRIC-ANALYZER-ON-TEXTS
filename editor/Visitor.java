package editor;

import Filtros.Filtro;
import Formatos.Formato;

public class Visitor {
	

    Filtro filtroPalabra;
    Filtro filtroSentencia;
    Filtro filtroParrafo;
    Filtro filtroSeccion;
    Formato formatoPalabra;
    Formato formatoSentencia;
    Formato formatoParrafo;
    Formato formatoSeccion;

    public Visitor (Filtro filtroPalabra, Filtro filtroSentencia, Filtro filtroParrafo, Filtro filtroSeccion,
            Formato formatoPalabra,Formato formatoSentencia,Formato formatoParrafo,Formato formatoSeccion){
        this.filtroPalabra = filtroPalabra;
        this.filtroSentencia = filtroSentencia;
        this.filtroParrafo = filtroParrafo;
        this.filtroSeccion = filtroSeccion;
        this.formatoPalabra = formatoPalabra;
        this.formatoSentencia = formatoSentencia;
        this.formatoParrafo = formatoParrafo;
        this.formatoSeccion = formatoSeccion;
    }
    
    public void visit(Seccion s){
        if (filtroSeccion != null){
            if (filtroSeccion.cumple(s)){
                s.setFormato(formatoSeccion);
                for (int i=0; i<s.getElementos().size(); i++)
                    s.getElemento(i).aceptar(this);
            }
        }
        else
             for (int i=0; i<s.getElementos().size(); i++)
                s.getElemento(i).aceptar(this);
    }
     
    public void visit(Parrafo p){
        if (filtroParrafo != null){
            if (filtroParrafo.cumple(p)){
                p.setFormato(formatoParrafo);
                for (int i=0; i<p.getSentencias().size(); i++)
                    p.getElemento(i).aceptar(this);
            }
        }
        else
            for (int i=0; i<p.getSentencias().size(); i++)
                p.getElemento(i).aceptar(this);
    }
    
    public void visit(Sentencia s){
        if(filtroSentencia != null){
            if (filtroSentencia.cumple(s)){
                s.setFormato(formatoSentencia);
                for (int i=0; i<s.getCadenas().size(); i++)
                    s.getElemento(i).aceptar(this);
            }
        }
        else{
            for (int i=0; i<s.getCadenas().size(); i++)
                s.getElemento(i).aceptar(this);
        }
    }
   
    public void visit(Palabra p){
        if(filtroPalabra != null)
            if (filtroPalabra.cumple(p))
                p.setFormato(formatoPalabra);
    }
}

