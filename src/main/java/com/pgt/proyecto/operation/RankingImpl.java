package com.pgt.proyecto.operation;

import java.util.Map;
import java.util.Map.Entry;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RankingImpl implements Ranking{
	
	@Value("${pgt.directory.path}")
	private String path;

	@Override
	public void escribefichero(Map<String, Integer> m, String prueba) {
		FileWriter archivo = null;
		PrintWriter escritor = null;		
		try {
			archivo = new FileWriter(path + "ranking.txt");
			escritor = new PrintWriter(archivo);			
			escritor.println("La clasificación de clubs asociada a la prueba " + prueba + " es:");
			for (Entry<String, Integer> res : m.entrySet()){
				escritor.println("El club "+ res.getKey() + " ha conseguido "+res.getValue()+" puntos");
			}			
			archivo.close();
		} catch(Exception e) {
			System.out.println("Error: "+ e.getMessage());
		} 
	}	
}
