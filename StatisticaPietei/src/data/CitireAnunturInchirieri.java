package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CitireAnunturInchirieri {
	private static List<AnuntInchiriere> anunturi = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		Path destination = Paths.get("resources");
		System.out.println(destination.toAbsolutePath());
		
		File folder = new File("resources/StoriaInchirieri/");
		File[] listOfFiles = folder.listFiles();
		
		for(File file : listOfFiles) {
			InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
			extractFromFile(inputReader); 
			inputReader.close();
		}
		
		System.out.println("Size: " + anunturi.size());
		Collections.sort(anunturi);
		for(AnuntInchiriere a : anunturi){
			System.out.println(a);
		}
	}
	
	
	private static void extractFromFile(InputStreamReader inputReader) throws UnsupportedEncodingException, FileNotFoundException, IOException {
		
		try (BufferedReader reader = new BufferedReader(inputReader)){
			
			System.out.println("1" + reader.readLine());
			System.out.println("2" + reader.readLine());
			String line;
			int i = 0;
			while((line = reader.readLine()) != null) {
				
				String[] lineRead = line.split(",");
				System.out.println(lineRead[6]);
				String title = lineRead[0];
				double price = Double.valueOf(lineRead[1].replace('€', ' ').replaceAll("\\s", "").replaceAll("~", "").split("/")[0]);
				double area = Double.parseDouble(lineRead[2].split(" ")[0]);
				int rooms = Integer.parseInt(lineRead[3].split(" ")[0]);
				double priceByMeter = price / area;
				String url = lineRead[5];
				anunturi.add(new AnuntInchiriere(title, price, rooms, area, null, url, lineRead[6]));
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
