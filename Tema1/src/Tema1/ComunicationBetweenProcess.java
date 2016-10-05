package Tema1;

import java.io.*;
import java.util.*;

public class ComunicationBetweenProcess {
	public static void main (String args[ ]) throws IOException {
		Process process = new ProcessBuilder(args).start() ;
		InputStream is = process.getInputStream() ;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;
		System.out.println("Salida del proceso " + Arrays.toString(args) + " : " ) ;
		while((line=br.readLine()) != null ) {
			System.out.println(line);
		}
	}

}
