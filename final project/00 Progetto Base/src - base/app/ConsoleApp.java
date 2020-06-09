package app;

import java.util.Scanner;

/**
 * Questa classe fornisce un oggetto per creare una console app, fornendo le funzionalit� base:
 * 
 * Lettura di valori da tastiera
 * Messaggi di stampa e richiesta
 * 
 * @author lucaf
 *
 */
// Questa classe serve come punto di partenza per tutte le Applicazioni Console
// Evitando di ripetere istruzioni sempre uguali in un nuovo "psvm". Perch� tutte le funzioni principali di input da tastiera
// e output su console le rendo disponibili direttamente all'oggetto della classe che estende ConsoleApp
public abstract class ConsoleApp {
	
	private Scanner kbd;
	
	public ConsoleApp() {
		kbd = new Scanner(System.in);
	}
	
	/**
	 * Shortcut per System.out.println(Object obj)
	 * @param obj
	 */
	public void print(Object obj) {
		System.out.println(obj.toString());
	}
	
	/**
	 * 
	 * @param msg il messaggio da stampare su console per prendere poi l'input
	 * @return il valore inserito da tastiera che viene restituito
	 */
	public String nextLine(String msg) {
		print(msg); // stampa il messaggio
		String value = kbd.nextLine();
		return value;
	}
	
	/**
	 * Stampa il <strong>msg</strong>
	 * Se il valore inserito non � un <strong>int</strong>
	 * Stampa l'errore e richiede di nuovo l'input usando <strong>msg</strong>
	 * @param msg
	 * @param errorMsg
	 * @return
	 */
	public int nextInt(String msg, String errorMsg) {
		// Devo far reinserire il valore SE NON � un numero
		boolean valid = false;
		int ris = 0;
		
		do {
			// Sfrutto il metodo precedente per fare output del messaggio e leggere il valore da kbd
			String value = nextLine(msg);
			
			try {
				ris = Integer.parseInt(value);
				// se sono riuscito a parsarlo, valid viene impostato a true
				// se non sono sono riuscito valid NON viene impostato a true perch� parte subito catch
				valid = true;
			} catch (NumberFormatException e) {
				// Stampa il messaggio di errore
				print(errorMsg);
			}
			
		} while (!valid); // finch� valid � false, ripeti
		
		return ris;
	}
	
	public double nextDouble(String msg, String errorMsg) {
		boolean valid = false;
		double ris = 0;
		
		do {
			String value = nextLine(msg);
			
			try {
				ris = Double.parseDouble(value);
				valid = true;
			} catch (NumberFormatException e) {
				print(errorMsg);
			}
			
		} while (!valid);
		
		return ris;
	}
	
	/**
	 * Chiedere l'input finch� il valore non � un intero compreso tra il valore minimo e massimo
	 * @param msg
	 * @param errorMsg
	 * @param minValue
	 * @param maxValue
	 * @return
	 */
	public int nextInt(String msg, String errorMsg, int minValue, int maxValue) {
		boolean valid = false;
		int ris = 0;
		do {
			ris = nextInt(msg, errorMsg);
			if (ris >= minValue && ris <= maxValue) {
				valid = true;
			} else {
				print("Inserire un valore compreso tra " + minValue + " e " + maxValue);
			}
		} while (!valid);
		
		return ris;
	}
	
	/**
	 * L'utente inserir� un valore in stringa. A seconda di cosa inserisce verr� restituito true/false
	 * True se la stringa corrisponde a trueValue, false se corrisponde a falseValue
	 * Se inserisce qualsiasi altro valore, richiedere l'input
	 * @param msg
	 * @param errorMsg
	 * @param trueValue
	 * @param falseValue
	 * @return
	 */
	public boolean nextBoolean(String msg, String errorMsg, String trueValue, String falseValue) {
		// while(true) => loop infinito perch� la condizione di iterazione � sempre vera
		// for(;;) { infinito }
		while (true) {
			String value = nextLine(msg);
			
			if (value.equalsIgnoreCase(trueValue)) {
				return true;
			} else if (value.equalsIgnoreCase(falseValue)) {
				return false;
			}
			
			print(errorMsg);
		}
	}
	
	/**
	 * Tutta la logica del programma in questo metodo
	 * Tutte le console app saranno obbligate a fornire l'implementazione dal metodo abstract
	 */
	public abstract void run();
	
}
