package unionFind;

import java.util.Arrays;
import java.util.Scanner;

public class operations {
	
	static Object[] oneTwo = {"kiuru", "lokki", "rastas", "sorsa", "varis"};
	static Object[] abc = {"kalle", "1", "jorma", "12", "on"};

	
	
	private static void union(Object[] array, Object[] array2) {
		
	int diff = 0;
		
	if (array.equals(abc) || array.equals(oneTwo) && array2.equals(abc) || array2.equals(abc)) {
		
		for (int i = 0; i < array.length; i++) { //TODO: LENGTH better yes
			
			if (array[i] != array2[i]) {
				diff++;
			}
		}
		
	}
	
	Object[] newArray = new Object[diff + array.length];
	
	for ( int i = 0; i < array.length; i++) {
		newArray[i] = array[i];	
	}
	
	
	
	System.out.println("Joukko union- operaation j‰lkeen: " + "newArray" + Arrays.toString(newArray) + "\n");

	}
	
	

	/**
	 * Metodi <b> find </b> toteuttaa find operaation.
	 * 
	 * <p> Find- operaatiolla etsit‰‰n solmua ja joukkoa, miss‰ se sijaitsee. </p>
	 * <break>
	 * <p> Metodissa k‰yd‰‰n taulukot l‰vitse ja verrataan niiden alkioita annettuun alkioon.
	 * 	   Jos annettu alkio vastaa taulukon indeksiss‰ olevaa alkiota, niin tulostetaan taulukon nimi ja taulukko,
	 *     muuten tulostetaan ett‰ solmu ei sijaitse tietokannassa. </p> 
	 * 
	 * @param array taulukko, jota k‰sitell‰‰n.
	 * @param value taulukon alkio, jota etsit‰‰n.
	 */
	private static void find(Object[] array, Object value) {
		
		
		
		for (int i = 0; i < array.length;i++) {
			
			if ( array.equals(abc) && array[i].equals(value) ) {
				
				System.out.println("Solmu " + value + " kuuluu joukkoon: " + "abc" + Arrays.toString(array));
			}
			else if(array.equals(oneTwo) && array[i].equals(value) ) {
				
				System.out.println("Solmu " + value + " kuuluu joukkoon: " + "oneTwo" + Arrays.toString(array));
			}
			else {
				System.err.println("Solmu "+ value + " ei sijaitse tietokannassa.");
				break;
			}
		}	
	}


	
	
	
	
	public static void main(String[] args) {
		
		int size;
		
		System.out.println("Tietokannassa on joukot: "+ "\n" + "oneTwo"+ Arrays.toString(oneTwo)
		+ "  abc" + Arrays.toString(abc) + "\n");
		
		
		Scanner sc = new Scanner(System.in); 
		
			
		while(true) {
		
		System.out.println("Valitse ja kirjoita toiminto, jonka haluat suorittaa: [find], [union] tai [exit]");	
		String process = sc.next();
		
	
			if (process.equals("find")) {
					
				Object value = null;
					
				System.out.println("Syˆt‰ etsitt‰v‰n solmun arvo: ");
	
					if (sc.hasNextInt()) {
							value = sc.nextInt();
					}
					else if (sc.hasNext()) {
							value = sc.next();
					}
					
				find(abc, value);
				find(oneTwo, value);
			}
			
			
			
			
			
			
			else if (process.equals("union")) {
				
				System.out.println("Tietokannassa olevat joukot: oneTwo, abc");
				
				
				System.out.println("Syˆt‰ ensimm‰inen joukko: ");
				String name = sc.next();
				
				System.out.println("Syˆt‰ toinen joukko: ");
				String name2 = sc.next();
				
				System.out.println("Joukkosi: ("+ name +" , "+ name2 +")." + "\n");
				
				if (name.equals(abc)) {
					union(abc,oneTwo);
				}
					union(oneTwo,abc);
			}
		
			else if (process.equals("exit")) {
				System.out.println("Suljetaan..: ");
				sc.close();
			}
			
			}
			
			} //TODO: Tests
	}