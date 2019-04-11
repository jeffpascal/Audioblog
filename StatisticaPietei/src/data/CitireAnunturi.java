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

public class CitireAnunturi {
	private static List<AnuntVanzare> anunturi = new ArrayList<>();
	private static List<AnuntString> anunturiString = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		Path destination = Paths.get("resources");
		System.out.println(destination.toAbsolutePath());

		File folder = new File("resources/imobiliare/");
		File[] listOfFiles = folder.listFiles();

		String site = "imobiliare.ro";
		extract(listOfFiles, site);

//		System.out.println("Size: " + anunturi.size());
//		Collections.sort(anunturi);
//		for (AnuntVanzare a : anunturi) {
//			System.out.println(a);
//		}

		System.out.println("Size: " + anunturi.size());
		Collections.sort(anunturiString);
		for (AnuntString a : anunturiString) {
			System.out.println(a);
		}
	}

	private static void extract(File[] listOfFiles, String site)
			throws UnsupportedEncodingException, FileNotFoundException, IOException {
		if (site.equals("imobiliare.ro")) {
			for (File file : listOfFiles) {
				InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
				extractFromFileImobiliare(inputReader);
				inputReader.close();
				break;
			}
		} else if (site.equals("storia.ro")) {
			for (File file : listOfFiles) {
				InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
				extractFromFileStoria(inputReader);
				inputReader.close();
				break;
			}
		}
	}

	

	private static void extractFromFileStoria(InputStreamReader inputReader)
			throws UnsupportedEncodingException, FileNotFoundException, IOException {

		try (BufferedReader reader = new BufferedReader(inputReader)) {

			System.out.println("1" + reader.readLine());
			System.out.println("2" + reader.readLine());
			String line;
			int i = 0;
			while ((line = reader.readLine()) != null) {
				String[] lineRead = line.split(",");
				String title = lineRead[0];
				double price = Double.valueOf(lineRead[1].replace('€', ' ').replaceAll("\\s", "").replaceAll("~", ""));
				double area = Double.parseDouble(lineRead[2].split(" ")[0]);
				int rooms = Integer.parseInt(lineRead[3].split(" ")[0]);
				double priceByMeter = price / area;
				String url = lineRead[5];
				anunturi.add(new AnuntVanzare(title, price, rooms, area, null, url, null));

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void extractFromFileImobiliare(InputStreamReader inputReader)
			throws UnsupportedEncodingException, FileNotFoundException, IOException {

		try (BufferedReader reader = new BufferedReader(inputReader)) {

			System.out.println("1" + reader.readLine());
			System.out.println("2" + reader.readLine());
			String line;
			int i = 0;
			while ((line = reader.readLine()) != null) {
				String[] lineRead = line.split(",");
				String title = lineRead[0];
				String price = lineRead[1].replace('€', ' ').replaceAll("\\s", "").replaceAll("~", "").split("/")[0];
				String area = lineRead[2].split(" ")[0];
				String rooms = lineRead[3].split(" ")[0];
				String priceByMeter = null;
				String url = lineRead[5].split(" ")[0];
				anunturiString.add(new AnuntString(title, price, rooms, area, null, url, lineRead[6], null, null));

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
