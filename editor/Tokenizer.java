package editor;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Vector;

/**
 * This phase tokenizes the publication text.
 * 
 * @author Sebastian
 *
 */
public class Tokenizer {

    private static final String EMPTY_STRING = "";
    private static final String WITHE_SPACE_REGEX = "\\s";
    private static final String NOT_GRAPH = "[^\\p{Lower}\\p{Upper}\\d]";
    private static final String ACCENT_MARK = "\\p{InCombiningDiacriticalMarks}+";

    private String clean(String text) {
            String out = text;
            if (out != null) {
                out = Normalizer.normalize(out, Normalizer.Form.NFD);
                out = out.replaceAll(ACCENT_MARK, EMPTY_STRING);
            }
            return out;
    }

    public boolean esPalabra(String p){
    for(int i=0; i<p.length(); i++)
        if ((p.charAt(i) < 'A')  || ((p.charAt(i) > 'Z') && (p.charAt(i) < 'a'))  || (p.charAt(i) > 'z'))
            return false;
    return true;
    }

    public ArrayList<Cadena> process(String text) {
            String original = text;
            String cleaned_text = this.clean(original);

            ArrayList<Cadena> tokens = new ArrayList<Cadena>();
            String actualtoken = EMPTY_STRING;
            for (int i = 0; i < cleaned_text.length(); i++) {
                    String character = cleaned_text.substring(i, i + 1);
                    String original_character = original.substring(i, i + 1);
                    if (character.matches(WITHE_SPACE_REGEX)) {
                            if (!actualtoken.isEmpty()){
                                if (esPalabra(actualtoken))
                                    tokens.add(new Palabra(i - actualtoken.length(), i, actualtoken));
                                else
                                    tokens.add(new Simbolo (i - actualtoken.length(), i, actualtoken));
                            }
                            actualtoken = EMPTY_STRING;
                    } else {
                            if (character.matches(NOT_GRAPH)) {
                                    if (!actualtoken.isEmpty()){
                                        if (esPalabra(actualtoken))
                                            tokens.add(new Palabra(i - actualtoken.length(), i, actualtoken));
                                        else
                                            tokens.add(new Simbolo (i - actualtoken.length(), i, actualtoken));
                                    }
                                    if (esPalabra(original_character))
                                        tokens.add(new Palabra(i, i + 1, original_character));
                                    else
                                        tokens.add(new Simbolo(i, i + 1, original_character));
                                    actualtoken = EMPTY_STRING;
                            } else
                                    actualtoken += original_character;
                    }
            }

            if (!actualtoken.isEmpty()){
                if (esPalabra(actualtoken))
                    tokens.add(new Palabra(cleaned_text.length() - actualtoken.length(), cleaned_text.length(), actualtoken));
                else
                    tokens.add(new Simbolo(cleaned_text.length() - actualtoken.length(), cleaned_text.length(), actualtoken));
            }
            return tokens;
    }

}
