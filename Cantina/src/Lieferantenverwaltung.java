import java.util.ArrayList;
import java.io.*;

/**
 * Die Klasse Lieferantenverwaltung erstellt und verwaltet die Objekte der
 * Klassen Lieferant, Artikel und Lebensmittel und aggregiert diese. Sie stellt
 * Methoden zur Verf�gung, um die g�nstigsten Artikel der Lieferanten zu
 * berechnen, zu �berpr�fen, ob ausreichende Mengen an Zutaten beschafft werden
 * k�nnen und ob Tagesgerichte als Fleisch-, Fisch- oder vegetarische Gerichte
 * beschrieben werden k�nnen.
 * 
 * Die Rezeptverwaltung ist mit dieser Klasse assoziiert, da die
 * Rezeptverwaltung Methoden der Lieferantenverwaltung zur Erstellung ihrer
 * eigenen Datenschicht (Rezept, Zutat) verwendet. Die Einkaufsliste verwendet
 * die Lieferantenverwaltung um Artikelobjekte zu erhalten. F�r die
 * Planungsdurchf�hrung steht sie in Assoziation zu der Kantinenplanung, da die
 * Kantinenplanung die Lieferantenverwaltung konstruiert und die Erzeugung der
 * Datenschicht anst��t.
 * 
 * @author Rene Wiederhold
 * @version 0.01
 */
public class Lieferantenverwaltung {
	private ArrayList<Artikel> artikelArrayList;
	private ArrayList<Lieferant> lieferantArrayList;
	private ArrayList<Lebensmittel> lebensmittelArrayList;

	/**
	 * Der Konstruktor der Lieferantenverwaltung
	 */
	public Lieferantenverwaltung() {

	}

	/**
	 * Die Methode pr�ft, von welchem Typ eine Zutat ist (Fleisch, Fisch,
	 * Veggie). Dies wird von der Rezeptverwaltung zur Erstellung der Rezepte
	 * verwendet.
	 * 
	 * @param zutat
	 *            Die zu pr�fende Zutat
	 * @return Einen standardisierten String, der die Typ-Bezeichnung enth�lt.
	 */
	public String holeTyp(Zutat zutat) {
		// tragen Sie hier den Code ein
		String typ = "FLEISCH";
		return typ;
	}

	/**
	 * Die Methode pr�ft, ob die ben�tigten Mengen Lebensmittel am Markt
	 * vorhanden sind, um ein Tagesgericht in der Planungs- periode anbieten zu
	 * k�nnen. Beim Aufruf wird die ben�tigte Menge vom zugeh�rigen
	 * Lebensmittel-Objekt abgezogen, sofern ausreichend. Dies wird vom
	 * Kantinenplan verwendet.
	 * 
	 * @param Tagesgericht
	 *            Das zu �berpr�fende Tagesgericht
	 * @return True, falls ausreichend Lebensmittel beschafft werden k�nnen,
	 *         ansonsten False
	 */

	public boolean lebensmittelVerfuegbar(Tagesgericht tagesgericht) {
		return true;
	}

	/**
	 * Die Methode dient zum Aufbau der Lieferantenverwaltung. Sie erzeugt aus
	 * den Eingabe-Dateien die Bauernhof-, Grosshandel- und Artikelobjekte sowie
	 * die Lebensmittel-Objekte.
	 * 
	 * 
	 * @param String
	 *            Der Pfad zum Ordner, der die Lieferantenpreislisten enth�lt.
	 * @return True, falls die Lieferantendateien eingelesen werden konnten,
	 *         False, falls Probleme aufgetreten sind.
	 */
	public boolean liesLieferantenDateien(String lieferantenOrdner) {
		File folder = new File(lieferantenOrdner);
		// Debug-Print
		System.out.println("Angegebener Lieferantenordner ist ein Ordner: "
				+ folder.isDirectory());

		String[] fileList = folder.list();
		if (folder.isDirectory()) {
			// Debug-Print
			System.out.println("Der Ordner " + lieferantenOrdner
					+ " enth�lt folgende Dateien:");

			// Start der Ordner-Schleife
			for (int i = 0; i < fileList.length; i++) {

				// Debug-Print
				System.out.println(fileList[i]);

				// Datei �ffnen
				readFile(lieferantenOrdner + "//" + fileList[i]);
			}
		}
		return true;
	}

	/**
	 * Liest eine Lieferantendatei und schreibt die Lieferanten und Artikel in
	 * die zugeh�rigen ArrayLists
	 * 
	 * @param in
	 *            Der Pfad zur einzulesenden Lieferantendatei
	 * @return Einen booleschen Wert, ob die Datei erfolgreich eingelesen wurde.
	 */
	private boolean readFile(String in) {

		Datei inFile = new Datei(in);
		inFile.openInFile_FS(); // �ffnet den readbuffer
		// Zeilenz�hler f�r den Import
		int zeilennummer = 0;

		// Abfrage, ob das Oeffen funktioniert hat
		if (!inFile.state()) {
			// Ausgabe des Fehlers im Terminalfenster
			System.out.println("Fehler beim �ffnen der Eingabedatei " + in);
			// Abbrechen der Methode
			return false;
		}

		// Datei-Schleife
		while (!inFile.eof()) {
			zeilennummer = ++zeilennummer;
			String zeile = inFile.readLine_FS();

			//Pr�ft ob zeile keinen NullPointer enth�lt.
			if (!(zeile == null)) {
				ArrayList<String> fields = Kantinenplanung.CSVService.getFields(zeile);
				
				//Debug-Print
				System.out.println("Zeile: "+zeilennummer+" Wert1: "+fields.get(0)+" Wert2: "+fields.get(1)+" Wert3: "+fields.get(2));
				//Erste Zeile enth�lt Lieferanteninformationen
				if (zeilennummer == 1) {
					if ((fields.get(0)).compareTo("Grosshandel")==0){
						//Grosshandel erzeugen
						Grosshandel tmp = new Grosshandel();
						
						tmp.setLieferantName((fields.get(1)).toString());
						
						System.out.println(tmp.getLieferantenName());
					}
					else if ((fields.get(0)).compareTo("Bauer")==0){
						//Grosshandel erzeugen
						Bauernhof tmp = new Bauernhof();
						
						tmp.setLieferantName((fields.get(1)).toString());
						
						System.out.println(tmp.getLieferantenName());
					} 
				} 
				else {
					//Artikel erzeugen und Lieferanten zuweisen
				}
			}

		}
		return true;
	}

	/**
	 * Die Methode gibt eine ArrayList zur�ck, die alle Artikel enth�lt, die den
	 * gleichen Namen haben, wie der �bergebene String-Parameter. Dies wird zur
	 * Erzeugung der BestellPos-Objekte von der Einkaufsliste genutzt.
	 * 
	 * @param name
	 *            Die Bezeichnung einer Zutat
	 * @return Einen ArrayList, der die Referenzen zu allen Artikel-Objekte
	 *         enth�lt, deren Name mit dem Parameter �bereinstimmen
	 */
	public ArrayList<Artikel> gibAlleArtikel(String name) {

		return new ArrayList<Artikel>();
	}

}
