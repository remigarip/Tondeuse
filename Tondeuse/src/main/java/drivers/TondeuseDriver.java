package main.java.drivers;

import main.java.service.TondeuseService;

public class TondeuseDriver {
	
	public static void main(String[] args) {
		final TondeuseService service = new TondeuseService();
		// Modifier l'URL ici
		service.executionProgramme("D:/monDossier/Tondeuse/src/main/resources/input.txt");
	}
	

}
