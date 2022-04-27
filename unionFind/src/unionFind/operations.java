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
	 * <p> Kopioidaan kahdesta alkuperäisestä annetusta taulukosta alkiot uuteen taulukkoon,
	 *  jonka jälkeen kutsutaan metodia {@link remove}, joka poistaa duplikaatit taulukosta. </p>
	 * 
	 * @param array ensimmäinen käsiteltävä taulukko.
	 * @param array2 toinen käsiteltävä taulukko.
	 */
	public static Object[] union(Object[] array, Object[] array2) {
		
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
       
        System.out.println("Joukko union- operaation jälkeen: " + "unionArray" + Arrays.toString(remove(unionArray)) + "\n");
        
        return unionArray;
	}
	
	
	/**
	 * Metodi <b> remove </b> poistaa taulukosta duplikaatit alkiot.
	 *  
	 * <p> Luodaan lista annetusta taulukosta. Tämän jälkeen käytetään HashSettiä laittoamsti hyväksemme. </p>
	 * 
	 * @param array muutettava taulukko.
	 * @return taulukon, josta poistettu duplikaatit.
	 */
	public static  <Object> Object[] remove(Object[] array) {
	
		  List<Object> list = Arrays.asList(array);

		
		  HashSet<Object> set = new HashSet<Object>();
		  set.addAll(list);

		  return (Object[]) set.toArray();
		}

	
	/**
	 * Metodi <b> find </b> toteuttaa find operaation.
	 * 
	 * <p> Find- operaatiolla etsitään solmua ja joukkoa, missä se sijaitsee. </p>
	 * <break>
	 * <p> Metodissa käydään taulukot lävitse ja verrataan niiden alkioita annettuun alkioon.
	 * 	   Jos annettu alkio vastaa taulukon indeksissä olevaa alkiota, niin tulostetaan taulukon nimi ja taulukko,
	 *     muuten tulostetaan että solmu ei sijaitse tietokannassa. </p> 
	 * 
	 * @param array taulukko, jota käsitellään.
	 * @param value taulukon alkio, jota etsitään.
	 */
	public static Object[] find(Object[] array, Object value) {
				
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
		}
		return array;
	}

	
	/**
	  * <pre name="test">
	 * 
	 * #import java.util.Arrays;
	 * #import java.util.HashSet;
	 * #import java.util.Scanner;
	 * #import java.util.List;
	 * #import unionFind.operations;
	 * 
	 * 
	 * Object[] oneTwo = {"kiuru", "lokki", "rastas", "sorsa", "varis"};
	 * Object[] math = {"hash", "number", "12", "divide", "subtract"};	
	 * Object[] abc = {"kalle", "1", "rastas", "12", "on"};
	 * 
	 * // Testataan metodia union:
	 * 
	 *	Arrays.toString(operations.union(abc,oneTwo)) === "[kalle, 1, rastas, 12, on, kiuru, lokki, rastas, sorsa, varis]";
	 *	Arrays.toString(operations.union(math,abc)) === "[hash, number, 12, divide, subtract, kalle, 1, rastas, 12, on]";
	 *
	 *
	 * // Testataan metodia find:
	 * 
	 * 	Arrays.toString(operations.find(abc, "rastas")) === "[kalle, 1, rastas, 12, on]";
	 * 	Arrays.toString(operations.find(oneTwo, "lokki")) === "[kiuru, lokki, rastas, sorsa, varis]";	
	 * 		
	 * 	
	 * 
	 * </pre>
	 * @param args ei kaytossa.
	 */
	public static void main(String[] args) {
		
		int size;
		
		System.out.println("Tietokannassa on joukot: "+ "\n"+ "\n" + "oneTwo"+ Arrays.toString(oneTwo)
		+ "\n"+"abc" + Arrays.toString(abc) + "\n" + "array"+ Arrays.toString(math)+ "\n");
	
		Scanner sc = new Scanner(System.in); 
		
		try {
		
			
		while(true) {
		
		System.out.println("Valitse ja kirjoita toiminto, jonka haluat suorittaa: [find], [union] tai [exit] "+ "\n");	
		String process = sc.next();
		
			if (process.equals("find")) {
					
				Object value = null;
					
				System.out.println("Syötä etsittävän solmun arvo: ");
	
				    if (sc.hasNext()) {
							value = sc.next();
					}	
					
				find(abc, value);
				find(oneTwo, value);
				find(math, value);
			}
			
			else if (process.equals("union")) {
				
				System.out.println("Tietokannassa on joukot: oneTwo, abc ja math");
				
				
				System.out.println("Syötä ensimmäinen joukko: ");
				String name = sc.next();
				
				System.out.println("Syötä toinen joukko: ");
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
				else {
					System.err.println("Valitse oikea joukko");
				}					
			}
		
			else if (process.equals("exit")) { 
				System.out.println("Suljetaan..: ");
				sc.close();
			}
			
			}
			
			} catch (Exception e) {/*do nothing*/}
			sc.close();
	}
}