package unionFind;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;


public class operations {
	
	static Object[] oneTwo = {"kiuru", "lokki", "rastas", "sorsa", "varis"};
	static Object[] abc = {"kalle", "1", "rastas", "12", "on"};
	static Object[] math = {"hash", "number", "12", "divide", "subtract"};
	


	/**
	 * Metoid <b> union </b> toteuttaa union operaation toimivuuden.
	 * 
	 * <p> Kopioidaan kahdesta alkuper‰isest‰ annetusta taulukosta alkiot uuteen taulukkoon,
	 *  jonka j‰lkeen kutsutaan metodia {@link remove}, joka poistaa duplikaatit taulukosta. </p>
	 * 
	 * @param array ensimm‰inen k‰sitelt‰v‰ taulukko.
	 * @param array2 toinen k‰sitelt‰v‰ taulukko.
	 */
	private static void union(Object[] array, Object[] array2) {
		
		int size = array.length + array2.length;
		
        Object[] unionArray = new Object[size];
        
        System.arraycopy(array, 0, unionArray, 0, array.length);
        System.arraycopy(array2, 0, unionArray, array.length, array2.length);
       
        for (int i = 0; i < size; i++) {
        	 for (int j = i + 1; j < size; j++) {
        		 
        		 if ( unionArray[i] == unionArray[j] ) {
        		 }
        	 }
        }
       
        System.out.println("Joukko union- operaation j‰lkeen: " + "unionArray" + Arrays.toString(remove(unionArray)) + "\n");
	}
	
	
	/**
	 * Metodi <b> remove </b> poistaa taulukosta duplikaatit alkiot.
	 *  
	 * <p> Luodaan lista annetusta taulukosta. T‰m‰n j‰lkeen k‰ytet‰‰n HashSetti‰ laittoamsti hyv‰ksemme. </p>
	 * 
	 * @param array muutettava taulukko.
	 * @return taulukon, josta poistettu duplikaatit.
	 */
	private static <Object> Object[] remove(Object[] array) {
	
		  List<Object> list = Arrays.asList(array);

		
		  HashSet<Object> set = new HashSet<Object>();
		  set.addAll(list);

		  return (Object[]) set.toArray();
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
				
				System.out.println("Solmu " + value + " kuuluu joukkoon: " + "abc" + Arrays.toString(array) + "\n");
			}
			else if(array.equals(oneTwo) && array[i].equals(value) ) {
				
				System.out.println("Solmu " + value + " kuuluu joukkoon: " + "oneTwo" + Arrays.toString(array)+ "\n");
			}
			
			else if(array.equals(math) && array[i].equals(value) ) {
				
				System.out.println("Solmu " + value + " kuuluu joukkoon: " + "math" + Arrays.toString(array)+ "\n");
			}
			
			else {
				System.err.println("Solmu " + value + "ei sijaitse joukossa " + Arrays.toString(array)+ "\n");
				break;
			}
		}	
	}


	
	
	/**
	 * //TODO: Tests
	 * //TODO: ei t‰ysin toimi heitt‰‰ poikkeuksen, kenties try catch rakenne kuten aikaisemmissa
	 * 
	 * @param args ei kaytossa.
	 */
	public static void main(String[] args) {
		
		int size;
		
		System.out.println("Tietokannassa on joukot: "+ "\n"+ "\n" + "oneTwo"+ Arrays.toString(oneTwo)
		+ "\n"+"abc" + Arrays.toString(abc) + "\n" + "array"+ Arrays.toString(math)+ "\n");
	
		
		
		Scanner sc = new Scanner(System.in); 
		
			
		while(true) {
		
		System.out.println("Valitse ja kirjoita toiminto, jonka haluat suorittaa: [find], [union] tai [exit] "+ "\n");	
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
				find(math, value);
			
			}
			
			else if (process.equals("union")) {
				
				System.out.println("Tietokannassa on joukot: oneTwo, abc ja math");
				
				
				System.out.println("Syˆt‰ ensimm‰inen joukko: ");
				String name = sc.next();
				
				System.out.println("Syˆt‰ toinen joukko: ");
				String name2 = sc.next();
				
				System.out.println("Joukkosi: ("+ name +" , "+ name2 +")." + "\n");
				
				if (name.equals("abc") && name2.equals("oneTwo") ) {
					union(abc,oneTwo);
				}
				else if (name.equals("oneTwo") && name2.equals("abc") ) {
					union(oneTwo,abc);
				}
				else if (name.equals("abc") && name2.equals("math") ) {
					union(abc,math);
				}
				else if (name.equals("math") && name2.equals("abc") ) {
					union(math,abc);
				}
				else if (name.equals("math") && name2.equals("oneTwo") ) {
					union(math,oneTwo);
				}
				else if (name.equals("oneTwo") && name2.equals("math") ) {
					union(oneTwo,math);
				}
					
			}
		
			else if (process.equals("exit")) { 
				System.out.println("Suljetaan..: ");
				sc.close();
			}
			
			}
			
			} 
	}