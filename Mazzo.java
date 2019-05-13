/**
 * Creazione dei vari tipi di mazzo da gioco e operazioni base di utilizzo
 * @version 1.0
 * @author Paggiaro Pezzato
*/
import java.util.Random;

public class Mazzo{
	private Carta[] carte;
	private int numCarte;
	private char tipo;
	
/**
 * Creazione mazzo vuoto
*/
	public Mazzo(){
		carte = null;
		numCarte = 0;
		tipo = '0';
	}
	
/**
 *Assegnazione del tipo in base al numero di carte
 * @param int n numero carte
*/
	public Mazzo (int n){
		if (n == 40){
			tipo = 'b';
		}
		else{
			tipo = 's';
			numCarte = n;
		}
	}
	
/**
 * Creazione mazzo in base alle specifiche date
 * @param Carta c array di carte
*/
	public Mazzo(Carta[] c){
		carte =  new Carta [c.length];
		for (int i=0; i<c.length; i++){
			carte[i] = c[i];
		}
		numCarte = c.length;
		if (numCarte == 40){
			tipo = 'b';
		}
		else{
			tipo = 's';
		}
	}
	
/**
 * Assegnazione del numero di cartre del mazzo in base al tipo
 * @param char t tipo di mazzo(s = scala, b = briscola)
*/
	public Mazzo(char t){
		tipo = t;
		if(tipo == 's'){
			numCarte = 52;
		}
		else{
			numCarte = 40;
		}
	}//Fine costruttori
	
/**
 * Stampa delle carte del mazzo
*/
	public void visualizzaMazzo(){
		for(int i=0; i<carte.length; i++){
			System.out.println(carte[i].cartaStringa());
		}
	}//fine visualizzaMazzo	

/**
 * Assegnazione dei vaolri e del seme ad ogni singola carta del mazzo da scala
*/
	public void inizializzaScala(){
		carte = new Carta [52];
		if (tipo == 's' || numCarte == 52){
			for (int i=1; i<=4; i++){
				switch (i){												
					case 1:												
						for (int c=1; c<=13; c++){						
						carte[c - 1] = new Carta ('F', c);		
						}
					case 2:
						for (int c = 1; c<=13; c++){					
						carte[c + 12] = new Carta ('P', c);				
						}
					case 3:
						for (int c = 1; c<=13; c++){					
						carte[c + 25] = new Carta ('Q', c);				
						}
					case 4:
						for (int c = 1; c<=13; c++){					
						carte[c+ 38] = new Carta ('C', c);				
						}
				}
			}
		}
					
	}//fine inizializzaScala
	
/**
 * Assegnazione dei vaolri e del seme ad ogni singola carta del mazzo da briscola
*/
	public void inizializzaBriscola(){
		carte = new Carta [40];
		if (tipo == 'b' || numCarte == 40){
			for (int i=1; i<=4; i++){
				switch (i){												
					case 1:												
						for (int c=1; c<=10; c++){						
						carte[c - 1] = new Carta ('B', c);		
						}
					case 2:
						for (int c = 1; c<=10; c++){
						carte[c + 9] = new Carta ('S', c);
						}
					case 3:
						for (int c = 1; c<=10; c++){
						carte[c + 19] = new Carta ('D', c);
						}
					case 4:
						for (int c = 1; c<=10; c++){
						carte[c+ 29] = new Carta ('C', c);
						}
				}
			}
		}
					
	}//fine inizializzaBriscola
	
/**
 * Mescola carte del mazzo in modo randomico
*/
	public void mescolaMazzo(){
		Random rand = new Random();
		Carta c = new Carta();
		int n;
		for (int i=0; i<carte.length; i++){
			c = carte[i];
			n = rand.nextInt(carte.length);
			carte[i] = carte[n];
			carte[n] = c;
		}
	}//fine mescolaMazzo
	
/**
 * Estrae la prima carta del mazzo
*/
	public Carta estraiPrimaCarta(){
		Carta c = new Carta();
		numCarte = numCarte -1;
		if (numCarte > 0){
			c = carte[0];
		}
		for (int i=0; i<numCarte; i++){
			carte[i] = carte[i+1];
		}
		carte[numCarte] = null;
		return c;
	}//fine estraiCarta
	
/**
 * Estrae una carta a caso dal mazzo
*/
	public Carta estraiRandom(){
		Carta c = new Carta();
		Random rand = new Random();
		numCarte = numCarte-1;
		int n = rand.nextInt(numCarte);
		if (numCarte > 0){
			c = carte[n];
		}
		for (int i=n; i<numCarte; i++){
				carte[i] = carte[i+1];
		}
		carte[numCarte-1] = null;
		return c;
	}//fine pescaCarta
	
/**
 * Mette in fondo al mazzo la carta estratta
 * @param Carta c una carta
*/
	public void mettiInFondo(Carta c){
		if (numCarte != carte.length){
			carte[numCarte] = c;
			numCarte++;
		}
	}//fine mettiInFondo	 

/**
 * Inserisce una carta in una posizione randomica del mazzo
 * @param Carta c una carta
*/
	public void inserisciCarta(Carta c){
		Carta carta = new Carta();
		Random rand = new Random();
		int i = rand.nextInt(numCarte);
		if (numCarte != carte.length){
			carta = carte[i];
			carte[i] = c;
		}
	}//fine inserisciCarta	
	
}	
