package tarea32;

import java.util.Scanner;

public class App {

	private static final int NUM_POKEMONS = 5;
	private static final int BATTLEROYALE = 1;
	private static final int BATTLE = 2;
	private static Pokemon[] pokemons = new Pokemon[NUM_POKEMONS];
	private static Pokemon[] pokemonsBattle = new Pokemon[NUM_POKEMONS];
	private static Scanner scanner = new Scanner(System.in);
	

	private static void initPokemons() {
		Pokemon charizard = new Pokemon(100, 50, 50, "charizard");
		pokemons[0] = charizard;
		Pokemon blastoise = new Pokemon(150, 25, 150, "blastoise");
		pokemons[1] = blastoise;
		Pokemon venusaur = new Pokemon(300, 10, 100, "venusaur");
		pokemons[2] = venusaur;
		Pokemon bulbasur = new Pokemon(250, 20, 180, "bulbasur");
		pokemons[3] = bulbasur;
		Pokemon pikachu = new Pokemon(300, 40, 200, "pikachu");
		pokemons[4] = pikachu;
	}

	private static void initPokemonsRandomly() {
			
			scanner.nextLine();
		
		for (int i = 0; i < pokemons.length; i++) {

			StringBuilder sb = new StringBuilder();
			sb.append("Asigna un nombre al ");
			sb.append(numeracion(i));
			sb.append(" pokemon");
			System.out.println(sb.toString());
			pokemons[i] = new Pokemon();
			pokemons[i].setName(scanner.nextLine());

		}

	}
	
	private static void initPokemonsBattle() {
		
		final String[] NOMBRES = {"charizard", "blastoise", "venusaur", "bulbasur", "pikachu", "arceus", "mew", "dialga", "palkia", "giratina", "darkrai", "cresellia", "kyogre", "groudon", "rayquaza"};
		
		
		for(int i = 0;
				i < pokemonsBattle.length;
				i++) {
			
			pokemonsBattle[i] = new Pokemon();
			String nombreAleatorio = NOMBRES[(int)(Math.random() * (NOMBRES.length - 1)) ];
			pokemonsBattle[i].setName(nombreAleatorio);
			
		}
		
	}
	
	private static void showPokemons() {
		
		for(int i = 0;
				i < pokemons.length;
				i++) {
		
			StringBuilder sb = new StringBuilder();
			sb.append((i + 1));
			sb.append(". ");
			sb.append(pokemons[i].getName());
			System.out.println(sb.toString());
			
		}
		
	}
	
	private static void battleRoyaleShowPokemons() {
		
		for(int i = 0;
				i < pokemons.length;
				i++) {
			if(pokemons[i].getHealth() > 0) {
				StringBuilder sb = new StringBuilder();
				sb.append((i + 1));
				sb.append(". ");
				sb.append(pokemons[i].getName());
				System.out.println(sb.toString());
			}
		}
		
		
	}
	
	private static void initCombat() {
		
		int primerPokemon = eligeUnPokemon("primer", BATTLE, 9);
		int daError = primerPokemon;
		int segundoPokemon = eligeUnPokemon("segundo", BATTLE, daError);
		
		
			Battle.initBattle(pokemons[primerPokemon], pokemons[segundoPokemon]);	
				
	}
	
	private static void battleRoyale() {
		initPokemons();
		initPokemonsBattle();
		int contadorVivos = NUM_POKEMONS;
		for(int i = 0;
				i < pokemonsBattle.length;
				i++) {
			
			while(pokemonsBattle[i].getHealth() > 0 && contadorVivos > 0) {
				int pokemonElegido = eligeUnPokemon("" , BATTLEROYALE, 9);
				Battle.initBattle(pokemons[pokemonElegido], pokemonsBattle[i]);
				if(pokemons[pokemonElegido].getHealth() <= 0) {
					contadorVivos--;
				} // FIN DEL IF
				} //FIN DEL WHILE
		} // FIN DEL FOR	
		if(contadorVivos > 0) {
			System.out.println("Ganaste");
		}else {
			System.out.println("Perdiste");
		}
	} //FIN DEL METODO
	
public static void main(String[] args) {
        
        int eleccion = 1;
        
        while(eleccion != 3) {
        	
        	System.out.println("Elija la opción");
            System.out.println("1. Utilizar los pokemon del juego");
            System.out.println("2. Crear los pokemons aleatoriamente");
            System.out.println("3. Salir");
            System.out.println("4. Battle royale");
            
        	while(!scanner.hasNextInt()) {
        		System.out.println("Entrada incorrecta");
        		System.out.println("Elija la opción");
                System.out.println("1. Utilizar los pokemon del juego");
                System.out.println("2. Crear los pokemons aleatoriamente");
                System.out.println("3. Salir");
                System.out.println("4. Battle royale");
        		scanner.next();
        	}
        
            
        
            eleccion = scanner.nextInt();
            
            switch(eleccion) {
            
            case 1: initPokemons();
                    initCombat();
                    break;
            case 2: initPokemonsRandomly();
                    initCombat();
                    break;
            case 3: System.out.println("Hasta luego");
            		break;
            case 4: battleRoyale();
            		break;
            default: System.out.println("Opcion incorrecta");
            		break;
            
                
            
            }
            
            
        }
        
        
    }
	
	
		//METODOS PROPIOS
	private static String numeracion(int numero) {

		String resultado = "";

		switch (numero) {

		case 0:
			resultado = "primer";
			break;
		case 1:
			resultado = "segundo";
			break;
		case 2:
			resultado = "tercer";
			break;
		case 3:
			resultado = "cuarto";
			break;
		case 4:
			resultado = "quinto";
			break;

		}

		return resultado;

	}
	
	private static int eligeUnPokemon(String orden, int tipo, int prohibido) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Elige el ");
		if(tipo == BATTLE) {
			sb.append(orden);
			sb.append(" ");
		}
		sb.append("pokemon");
		
		int pokemonElegido = 5;
		while(pokemonElegido < 0  || pokemonElegido >= NUM_POKEMONS || pokemonElegido == prohibido) {
			if(tipo == BATTLE) {
				showPokemons();	
			} else if (tipo == BATTLEROYALE) {
				battleRoyaleShowPokemons();
			}
			
			System.out.println(sb.toString());
			while(!scanner.hasNextInt()) {
				System.out.println("Entrada no valida");
				System.out.println(sb.toString());
				if(tipo == BATTLE) {
					showPokemons();	
				} else if (tipo == BATTLEROYALE) {
					battleRoyaleShowPokemons();
				}
				scanner.next();
			}
		pokemonElegido = scanner.nextInt() - 1;
		
		if(pokemonElegido < 0  || pokemonElegido >= pokemons.length || pokemonElegido == prohibido ) {
			System.out.println("Entrada no valida");
		}
		
		if(tipo == BATTLEROYALE && pokemons[pokemonElegido].getHealth() <= 0) {
			System.out.println("Entrada no valida");
		}
		
		} // FIN DEL BUCLE
		
		return pokemonElegido;
	}
}
