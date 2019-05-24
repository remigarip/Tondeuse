package main.java.drivers;

import main.java.service.TondeuseService;

public class TondeuseDriver {
	
	public static void main(String[] args) {
		final TondeuseService service = new TondeuseService();
		service.executionProgramme("D:/Profiles/regarip/Desktop/Temp/Tondeuse/src/main/resources/input.txt");
	}
	

}
