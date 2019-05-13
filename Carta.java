/**
 * Creazione della carta da gioco indipendentemente dal tipo di mazzo
 * @version 1.0
 * @author Paggiaro Pezzato
*/
public class Carta{
	private char seme;
	private int valore;
	
/**
 * Creazione della carta vuota
*/
	public Carta(){
	}
	
/**
 * Assegnazione del seme e del valore all'oggetto carta
 * @param char s seme della carta
 * @param int v valore dlla carta
*/
	public Carta(char s, int v){
		seme = s;
		valore = v;
	}//fine costruttori
	
/**
 * Metodo per far ritornare il seme della carta
 * @return il seme della carta
*/
	public char getSeme(){
		return seme;
	}//fine getSeme
	
/**
 * Metodo per far ritornare il valore della carta
 * @return il valore della carta
*/
	public int getValore(){
		return valore;
	}//fine getValore
	
/**
 * Metodo per ricavare dalla carta una stringa che ne dia le informazioni seme e valore
 * @return stringa con seme e valore della carta
*/
	public String cartaStringa(){
		return "" + seme + valore;
	}//fine cartaStringa
	
}//fine class Carta
