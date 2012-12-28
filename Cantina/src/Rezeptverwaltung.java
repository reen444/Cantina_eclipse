import java.io.*; // Aufgrund des Einlesens der Datei
import java.util.ArrayList;
/**
 * Die Rezeptverwaltung erstellt aus der Rezeptdatei die Objektabbildungen der Rezepte und 
 * verwaltet diese. Sie stellt Methoden bereit um Referenzen auf bestimmte Rezept-Objekte 
 * zu �bergeben. Au�erdem kann sie auch die Hitliste einlesen und die Positionen den einzelnen Rezepten zuweisen.
 * 
 * Sie steht in Assoziation zur Verwaltungsklasse Lieferantenverwaltung, der Kantinenplanung sowie dem Kantinenplan.
 * Sie aggregiert die Objekte Rezept und Zutat.
 * 
 * @author Lukas Krotki 
 * @version 
 */
public class Rezeptverwaltung
{
    /** Angabe des Rezeptpfades */
    private String rezeptPfad;
    /**Rezeptname*/
    private String rezeptName;
    private Lieferantenverwaltung lieferenatenverw;
    private ArrayList<Rezept> rezeptListe;

    /** Bereits bei der Konstruktion muss eine Referenz zur Lieferantenverwaltung �bergeben werden, da diese zur Typpr�fung ben�tigt wird.
     * 
     * @param lieferantenverw Die zur Typpr�fung zu verwendende Lieferantenverwaltung
     */ 
    public Rezeptverwaltung(Lieferantenverwaltung lieferantenverw) //parameter entfernt zum testen (Lieferantenverwaltung lieferantenverw)
    {
    	this.lieferenatenverw = lieferantenverw;
     rezeptListe = new ArrayList<Rezept>();
    }

    /**
     * Rezepte in Rezeptliste aufnehmen
     * 
     * @param: rezept Rezept auf Rezeptliste
     */
    public void addRezept (Rezept rezept){
    	rezeptListe.add (rezept);
    }
    
    /**
     * Die Methode liest die Rezeptdatei ein, erstellt Rezeptobjekte und Zutatenobjekte daraus und weist die Zutaten den Rezepten zu. Dann werden die Rezepte in den RezeptArrayList gelegt.
     * 
     * @param   rezeptpfad Den Pfad zur Rezeptdatei.
     * @return  Gibt True zur�ck, wenn die Rezepte vollst�ndig eingelesen wurden. Gibt False zur�ck, falls Fehler aufgetreten sind.   
     */
//    public boolean liesRezepte(String rezeptpfad) 
//    {
//    	//Datei �ffnen
//		Datei inFile = new Datei(rezeptpfad);
//		inFile.openInFile_FS();
//		
//        
//		// Abfrage, ob das Oeffen funktioniert hat
//        if (!inFile.state()){
//            // Ausgabe des Fehlers im Terminalfenster
//            System.out.println("Fehler beim �ffnen der Eingabedatei "+rezeptPfad);
//            // Abbrechen der Methode
//            return false;
//        }
//
//        //Rezept initialisieren
//        Rezept rezept = null;
//        
//        //Datei-Schleife
//        while (!inFile.eof()){
//        	
//            // Zeile einer Datei einlesen
//        	String zeile = inFile.readLine_FS();
//        	//Debug-Print
//        	//System.out.println(zeile);
//        	
//   	
//        	//Wenn aktuelle Zeile einen NullPointer enth�lt, wird gebrochen. 
//        	if (zeile != null){
//        		
//        		//Der CSVService macht aus den Eingabe-String (Zeile aus Datei) eine ArrayList, die die einzelnen Werte getrennt enth�lt
//				ArrayList<String> fields = CSVService.getFields(zeile);
//				
//				//Debug-Print
//				//System.out.println("Zeile: "+zeilennummer+" Wert1: "+fields.get(0)+" Wert2: "+fields.get(1)+" Wert3: "+fields.get(2)+" Wert 4: " +fields.get(3));
//			
//			
//			
//				
//				// pr�fe ob die eingelesene Zeile dem aktuellen Rezept entspricht
//				if ( !fields.get(0).equals(rezeptName)) {
//					
//					//uebergebe den rezeptnamen aus dem Feld 0 
//					rezeptName = fields.get(0).toString();
//					
//					// erzeuge ein neues Objekt Rezept mit dem rezeptnamen
//					rezept = new Rezept(rezeptName);
//					
//										
//					// Setze den Rezeptnamen
//					rezept.setName(fields.get(0).toString());
//					
//					
//					//Rezept in Rezeptliste aufnehmen
//					rezeptListe.add(rezept);
//					
//					//Debug Print
//					System.out.println(rezept.getName());
//					
//					
//				}
//				
//					// Zutatenobjekt erzeugen
//					Zutat zutat = new Zutat(fields.get(3).toString(), Float.valueOf(fields.get(1).toString().replace(",", ".")), fields.get(2).toString());
//					// Zutat einem Rezept hinterlegen
//					rezept.addZutat( zutat );
//					// Debug Print
//					System.out.println(" Zutat: "+fields.get(3).toString());
//					
//				
//			  
//        	}
//        }
//        return true;
//        }
//       
        
        
      
        		
    

       	   
    
    
    /**
     * Die Methode liest die Hitlistendatei ein und weist den im RezeptArrayList enthaltenen Rezeptobjekten ihre Hitlistenposition zu.
     * 
     * @param hitlistenpfad Den Pfad zur Hitlistendatei  
     * @return  True f�r vollst�ndige Zuweisung, False f�r unvollst�ndig    
     */
    public boolean liesHitliste(String hitlistenPfad) 
    {
    	//Datei �ffnen
    			Datei inFile = new Datei(hitlistenPfad);
    			inFile.openInFile_FS();
    			
    	        
    			// Abfrage, ob das Oeffen funktioniert hat
    	        if (!inFile.state()){
    	            // Ausgabe des Fehlers im Terminalfenster
    	            System.out.println("Fehler beim �ffnen der Eingabedatei "+hitlistenPfad);
    	            // Abbrechen der Methode
    	            return false;
    	        }
    	            //int zeilennummer = 0;
    	             
    	            //Datei-Schleife
    	            while (!inFile.eof()){
    	            	//zeilennummer++;
    	                // Zeile einer Datei einlesen
    	            	String zeile = inFile.readLine_FS();
    	            	//Debug-Print
    	            	//System.out.println(zeile);
    	            	
    	       	
    	            	//Wenn aktuelle Zeile einen NullPointer enth�lt, wird gebrochen. 
    	            	if (zeile != null){
    	            		
    	            		//Der CSVService macht aus den Eingabe-String (Zeile aus Datei) eine ArrayList, die die einzelnen Werte getrennt enth�lt
    	    				ArrayList<String> fields = CSVService.getFields(zeile);
    	    				
    	    				//Debug-Print
    	    				//System.out.println("Zeile: "+zeilennummer+" Wert1: "+fields.get(0)+" Wert2: "+fields.get(1));
    	        
    	    				if ((rezeptListe.contains(rezeptName)) && name.equals(fields.get(1))){
    	    					rezept.setHitlistenpos(fields.get(0).toString());
    	    				}
    	            }
    	        }
    	           
    	return true;
    }
    
    /**
     * Die Methode gibt ein zuf�lliges Fischrezept aus dem RezeptArrayList zur�ck.
     * 
     * @return Ein zuf�lliges Fischrezept 
     */
    public Rezept gibFisch() 
    {
        Rezept x = new Rezept("a"); 
        return x;
    }
   
    /**
     * Die Methode gibt ein zuf�lliges Fleischrezept aus dem RezeptArrayList zur�ck.
     * 
     * @return       Ein zuf�lliges Fleischrezept
     */
    public Rezept gibFleisch() 
    {
        Rezept x=new Rezept("a");
        return x;
    }
    
    /**
     * Die Methode gibt ein zuf�lliges vegetarisches Rezept aus dem RezeptArrayList zur�ck.
     * 
     * @return       Ein zuf�lliges vegetetarisches Rezept 
     */
    public Rezept gibVeggie() 
    {
        Rezept x=new Rezept("a");
        return x;
    }
    
    /**
     * Die Methode gibt ein zuf�lliges Rezept aus dem RezeptArrayList zur�ck.
     * 
     * @return        Ein zuf�lliges Rezept 
     */
    public Rezept gibRandom() 
    {
        Rezept x=new Rezept("a");
        return x;
    }
}
