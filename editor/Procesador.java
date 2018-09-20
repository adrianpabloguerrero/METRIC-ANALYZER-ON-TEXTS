
package editor;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Procesador {
    
    private final Pattern TITULO = Pattern.compile("<h(\\d)>");
    Seccion seccion;
    ArrayList <Seccion> lista; 
    
    
    public Procesador (Seccion seccion){
        lista = new ArrayList <Seccion> ();
        this.seccion = seccion; 
        lista.add(seccion);
    }
    
    public Sentencia procesarTitulo (String texto){
      String cadena = texto.substring(4, texto.length()-6);
      Tokenizer tokenizer = new Tokenizer ();
      ArrayList <Cadena> cadenas = tokenizer.process(cadena);
      cadenas.remove(cadenas.size()-1); // Le saco el punto
      Sentencia nuevaSentencia = new Sentencia ();
      
      for (int i=0; i<cadenas.size() ; i++)
      {
          cadenas.get(i).setPadre(nuevaSentencia);
          nuevaSentencia.addCadena(cadenas.get(i));
      }
      return nuevaSentencia;
    }
    
   
    public Parrafo procesarParrafo (String texto){
        Parrafo nuevoParrafo = new Parrafo ();
        nuevoParrafo.setPadre(lista.get(lista.size()-1));
        Cadena separador = new Simbolo(".");
        Tokenizer tokenizer = new Tokenizer ();
        ArrayList <Cadena> cadenas = tokenizer.process(texto);
        while (!cadenas.isEmpty()){
            Sentencia sentencia = new Sentencia ();
            sentencia.setPadre(nuevoParrafo);
            while (!cadenas.get(0).equals(separador)){
                Cadena nuevaCadena = cadenas.get(0);
                nuevaCadena.setPadre(sentencia);
                sentencia.addCadena(nuevaCadena);
                cadenas.remove(0);
            }
            cadenas.remove(0);            
            nuevoParrafo.addSentencia(sentencia);      
        }  
        
        
        return nuevoParrafo;
    }
    
    public void cargarEstructuras (Seccion seccionPrincipal,String [] texto){
        for (int i=0; i<texto.length;i++){
            Matcher match = TITULO.matcher(texto[i]);
            if (match.find()) {
                int nivel = Integer.parseInt(match.group(1)); //me quedo con el nivel
                Seccion nuevaSeccion = new Seccion (procesarTitulo(texto[i]));
                nuevaSeccion.setNivel(nivel);
                lista= new ArrayList <Seccion> (lista.subList(0, nivel));
                lista.get(lista.size()-1).addElemento(nuevaSeccion);
                nuevaSeccion.setPadre(lista.get(lista.size()-1));
                lista.add(nuevaSeccion);
            }     
            else {
                lista.get(lista.size()-1).addElemento(procesarParrafo(texto[i]));
            }
        }
    }
    
public ArrayList<String> cargarArchivo(String ruta){
        File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
	    ArrayList<String> lista = new ArrayList<String>();
	    	try {
	        // Apertura del fichero y creacion de BufferedReader para poder
	        // hacer una lectura comoda (disponer del metodo readLine()).
	        archivo = new File (ruta);
	        fr = new FileReader (archivo);
	        br = new BufferedReader(fr);

	        // Lectura del fichero
	        String linea;
	        while((linea=br.readLine())!=null){
                    lista.add(linea);
                    }
                
	     }
	     catch(Exception e){
	        e.printStackTrace();
	     }finally{
	        // En el finally cerramos el fichero, para asegurarnos
	        // que se cierra tanto si todo va bien como si salta 
	        // una excepcion.
	        try{                    
	           if( null != fr ){   
	              fr.close();     
	           }                  
	        }catch (Exception e2){ 
	           e2.printStackTrace();
	        }
	     }
		return lista;
    }
}
