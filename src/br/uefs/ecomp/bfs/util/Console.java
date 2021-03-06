package br.uefs.ecomp.bfs.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Classe que auxilia a leitura de dados do usuario. Esta classe nao deve ser
 * modificada. Para utiliza-la, crie um atributo do tipo Console na sua 
 * aplicacao.
 * 
 * Esta classe foi baseada na classe Console desenvolvido por Ives Jose de 
 * Albuquerque Macedo Junior (ijamj@cin.ufpe.br)
 */
public class Console {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Esta linha foi alterada para evitar a sobrecarga

    public static String readString() throws IOException {
        while (!Console.br.ready()) {
        }

        String ret = Console.br.readLine();

        return ret==null ? "" : ret;
    }

    public static char readChar() throws IOException {  // este metodo foi alterado para ficar mais robusto        
        String str = Console.readString();
        return str.length()>0 ? str.charAt(0) : '\n';
    }

    public static char[] readCharArray() throws IOException{        
        return Console.readString().toCharArray();
    }

    public static short readShort() throws IOException, NumberFormatException{        
        return Short.parseShort(Console.readString()); 
    }

    public static int readInt() throws IOException, NumberFormatException{
        return Integer.parseInt(Console.readString());        
    }

    public static long readLong() throws IOException {
       return Long.parseLong(Console.readString());        
    }

    public static float readFloat() throws IOException {
        return Float.parseFloat(Console.readString());        
    }

    public static double readDouble() throws IOException {
        return Double.parseDouble(Console.readString());                
    }

    public Console(InputStream in) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Console() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

