package tarea32;

import java.util.Scanner;

public class App {

	private static final int NUM_POKEMONS = 5;
	private static final int BATTLEROYALE = 1;
	private static final int BATTLE = 2;
	private static final int PALACIO_SANGRIENTO = 3;
	private static Pokemon[] pokemons = new Pokemon[NUM_POKEMONS];
	private static Pokemon[] pokemonsBattle = new Pokemon[NUM_POKEMONS];
	private static Scanner scanner = new Scanner(System.in);
	private static Pokemon jugador = new Pokemon();
	

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
		
		final String[] NOMBRES = {"charizard", "blastoise", "venusaur","mew", "bulbasur", "pikachu", "arceus", "dialga", "palkia", "giratina", "darkrai", "cresellia", "kyogre", "groudon", "rayquaza"};
		
		
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
            System.out.println("5. Palacio sangriento");
            
        	while(!scanner.hasNextInt()) {
        		System.out.println("Entrada incorrecta");
        		System.out.println("Elija la opción");
                System.out.println("1. Utilizar los pokemon del juego");
                System.out.println("2. Crear los pokemons aleatoriamente");
                System.out.println("3. Salir");
                System.out.println("4. Battle royale");
                System.out.println("5. Palacio sangriento");
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
            case 5: palacioSangriento();
            		break;
            default: System.out.println("Opcion incorrecta");
            		break;
            
                
            
            }
            
            
        }
        
        
    }
	
	
		
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
		
		if(tipo == BATTLE || tipo == BATTLEROYALE) {
			sb.append("Elige el ");
			
			if(tipo == BATTLE) {
				sb.append(orden);
				sb.append(" ");
			}
			
			sb.append("pokemon");	
		}
		
		if (tipo == PALACIO_SANGRIENTO) {
			sb.append("Elige contrincante");
		}
		
		
		int pokemonElegido = 5;
		
		while(pokemonElegido < 0  || pokemonElegido >= NUM_POKEMONS || pokemonElegido == prohibido) {
			
			if(tipo == BATTLE) {
				showPokemons();	
			} else if (tipo == BATTLEROYALE) {
				battleRoyaleShowPokemons();
			}else if(tipo == PALACIO_SANGRIENTO) {
				showPokemonsPalacioSangriento();
			}
			
			System.out.println(sb.toString());
			
			while(!scanner.hasNextInt()) {
				System.out.println("Entrada no valida");
				System.out.println(sb.toString());
				if(tipo == BATTLE) {
					showPokemons();	
				} else if (tipo == BATTLEROYALE) {
					battleRoyaleShowPokemons();
				} else if(tipo == PALACIO_SANGRIENTO) {
					showPokemonsPalacioSangriento();
				}
				
				
				scanner.next();
			}
			
		pokemonElegido = scanner.nextInt() - 1;
		
		if(tipo == BATTLE && (pokemonElegido < 0  || pokemonElegido >= pokemons.length || pokemonElegido == prohibido)) {
			System.out.println("Entrada no valida");
		}else if(tipo == BATTLEROYALE && (pokemonElegido < 0  || pokemonElegido >= pokemons.length || pokemons[pokemonElegido].getHealth() <= 0)) {
			System.out.println("Entrada no valida");
		} else if(tipo == PALACIO_SANGRIENTO && (pokemonElegido < 0  || pokemonElegido >= pokemonsBattle.length || pokemonsBattle[pokemonElegido].getHealth() <= 0)) {
			System.out.println("Entrada no valida");
		}
		
		
		
		
		} // FIN DEL BUCLE
		
		return pokemonElegido;
	} // FIN DEL METODO
	
	
	// AMPLIACION LIBRE
	
	private static void palacioSangriento(){
		scanner.nextLine();
		int contadorDeRondas = 0;
		initPokemonsBattle();
		System.out.println("Ponle un nombre a tu pokemon");
		jugador.setName(scanner.nextLine());
		jugador.setHealth(301);
		
		while(jugador.getHealth() > 0) {
			
			int contrincante = eligeUnPokemon("" , PALACIO_SANGRIENTO, 9);
			
				Battle.initBattle(jugador, pokemonsBattle[contrincante]);
				if(jugador.getHealth() > 0) {
					contadorDeRondas++;	
				}
				
			
			
		}
		System.out.println("Tu pokemon ha ganado " + contadorDeRondas + " combates");
	}
	
	private static void showPokemonsPalacioSangriento() {

		StringBuilder sb = new StringBuilder();
		

		sb.append("\tNOMBRE");
		sb.append("  \t\tFUERZA");
		sb.append("\tVELOCIDAD");
		sb.append("  SALUD\n");
		sb.append("-----------------------------------------------------------------\n");
		
		sb.append("Tu \t");		
		sb.append(jugador.getName());
		if(jugador.getName().length() <= 5) {
			sb.append("\t");
		}
		sb.append("  \t\t  ");
		sb.append(jugador.getStrength());
		sb.append("\t   ");
		sb.append(jugador.getSpeed());
		sb.append("\t    ");
		sb.append(jugador.getHealth());
		sb.append("\n");
		
		
		for(int i = 0;
				i < pokemonsBattle.length;
				i++) {
			if(pokemonsBattle[i].getHealth() > 0) {
				sb.append(i + 1);
				sb.append(". \t");
				sb.append(pokemonsBattle[i].getName());
				if(pokemonsBattle[i].getName().length() <= 5) {
					sb.append("\t");
				}
				sb.append("  \t\t  ");
				sb.append(pokemonsBattle[i].getStrength());
				sb.append("\t   ");
				sb.append(pokemonsBattle[i].getSpeed());
				sb.append("\t    ");
				sb.append(pokemonsBattle[i].getHealth());
				sb.append("\n");	
			}
			
			
		}
		
		
		
		
		System.out.println(sb.toString());
	}
	
}
