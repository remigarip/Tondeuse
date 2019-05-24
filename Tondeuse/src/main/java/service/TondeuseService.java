package main.java.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TondeuseService {
	
	final String NORTH = "N";
	final String WEST = "W";
	final String SOUTH = "S";
	final String EAST = "E";
	
	public void executionProgramme(String url) {
		try {
			//Récupération du fichier en entrée.
			File file = new File(url);
			BufferedReader reader = new BufferedReader(new FileReader(file)); 
			
			//Génération du terrain où évolueront les tondeuses.
			int[] pelouse =  this.genererPelouse(reader.readLine()); 
			
			String tondeuseSuivante;
			while ((tondeuseSuivante = reader.readLine()) != null) {
				String commandes = reader.readLine();
				// On oriente et déplace les tondeuses.
				this.gererTondeuse(tondeuseSuivante, commandes, pelouse);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("Une erreur est survenue lors de la lecture du fichier.");
		}
	}
	
	private int[] genererPelouse(String pCoordonnees) {
		int coordX = Integer.parseInt(pCoordonnees.split(" ")[0]);
		int coordY = Integer.parseInt(pCoordonnees.split(" ")[1]);
		int [] result = {coordX, coordY};
		return result;
	}
	
	/**
	 * Gère l'orientation et le déplacement des tondeuses.
	 * @param pCoordonnees la ligne du fichier d'entrée correspondant aux coords de départ de la tondeuse
	 * @param pCommandes la ligne du fichier d'entrée correspondant aux commandes à executer.
	 * @param pPelouse les dimensions de la pelouse
	 */
	private void gererTondeuse(String pCoordonnees, String pCommandes, int[] pPelouse) {
		int coordX = Integer.valueOf(pCoordonnees.split(" ")[0]);
		int coordY = Integer.valueOf(pCoordonnees.split(" ")[1]);
		String orientation = pCoordonnees.split(" ")[2];
		int nombreCommandes = pCommandes.length();
		for (int i = 0; i < nombreCommandes; i++) {
			if (pCommandes.charAt(i) == 'A') {
				coordX = deplacerTondeuseAxeX(coordX, orientation, pPelouse[0]);
				coordY = deplacerTondeuseAxeY(coordY, orientation, pPelouse[1]);
			}
			else {
				orientation = orienterTondeuse(pCommandes.charAt(i), orientation);
			}
		}
		System.out.println(coordX + " " + coordY + " " + orientation);
	}
	
	public String orienterTondeuse(char pCommandes, String pOrientationActuelle) {
		String orientationFinale = pOrientationActuelle;
		if (pCommandes == 'G') {
			switch (pOrientationActuelle) {
				case NORTH:
					orientationFinale = WEST;
					break;
				case EAST:
					orientationFinale = NORTH;
					break;
				case SOUTH:
					orientationFinale = EAST;
					break;
				case WEST:
					orientationFinale = SOUTH;
					break;
				default:
					break;
			}
		}
		else {
			switch (pOrientationActuelle) {
				case NORTH:
					orientationFinale = EAST;
					break;
				case EAST:
					orientationFinale = SOUTH;
					break;
				case SOUTH:
					orientationFinale = WEST;
					break;
				case WEST:
					orientationFinale = NORTH;
					break;
				default:
					break;
			}
		}
		return orientationFinale;
	}
	
	public int deplacerTondeuseAxeX(int pCoordX, String pOrientation, int xMaxPelouse) {
		int nouvelleCoordonneeX = pCoordX;
		if ("E".equals(pOrientation) && pCoordX + 1 <= xMaxPelouse) {
			nouvelleCoordonneeX = pCoordX + 1;
		}
		else if ("W".equals(pOrientation) && pCoordX - 1 >= 0) {
			nouvelleCoordonneeX = pCoordX - 1;
		}
		return nouvelleCoordonneeX;
	}
	public int deplacerTondeuseAxeY(int pCoordY, String pOrientation, int yMaxPelouse) {
		int nouvelleCoordonneeY = pCoordY;
		if ("N".equals(pOrientation) && pCoordY + 1 <= yMaxPelouse) {
			nouvelleCoordonneeY = pCoordY + 1;
		}
		else if ("S".equals(pOrientation) && pCoordY - 1 >= 0) {
			nouvelleCoordonneeY = pCoordY - 1;
		}
		return nouvelleCoordonneeY;
	}
}
