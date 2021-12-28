package tarea32;

import java.util.Scanner;

public class App {

	private static final int NUM_POKEMONS = 5;
	private static Pokemon[] pokemons = new Pokemon[NUM_POKEMONS];
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
	
	private static void initCombat() {
		
		
		
		showPokemons();
		System.out.println("Elige el primer pokemon");
		int primerPokemon = scanner.nextInt() - 1;
		System.out.println("Elige el segundo pokemon");
		int segundoPokemon = scanner.nextInt() - 1;
		Battle.initBattle(pokemons[primerPokemon], pokemons[segundoPokemon]);
		
		
		
	}
	
public static void main(String[] args) {
        
        int eleccion = 1;
        
        while(eleccion != 3) {
        
            System.out.println("Elija la opci�n");
            System.out.println("1. Utilizar los pokemon del juego");
            System.out.println("2. Crear los pokemons aleatoriamente");
            System.out.println("3. Salir");
        
            eleccion = scanner.nextInt();
            
            switch(eleccion) {
            
            case 1: initPokemons();
                    initCombat();
                    break;
            case 2: initPokemonsRandomly();
                    initCombat();
                    break;
            case 3: System.out.println("Hasta luego");
            
                
            
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
}
