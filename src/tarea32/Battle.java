package tarea32;

public class Battle {
	
	public static void initBattle(Pokemon pokemon1, Pokemon pokemon2) {
		final boolean PRIMER_POKEMON = true;
		final boolean SEGUNDO_POKEMON = false;
		boolean turno;
		if (pokemon1.getSpeed() >= pokemon2.getSpeed()) {
			turno = PRIMER_POKEMON;	
		}else {
			turno = SEGUNDO_POKEMON;
		}
		
		
		while (pokemon1.getHealth() > 0 && pokemon2.getHealth() > 0) {
			
			if(turno == PRIMER_POKEMON) {
					
					ataque(pokemon1, pokemon2);
					turno = SEGUNDO_POKEMON;
						if(pokemon2.getHealth() <= 0) {
							System.out.println(narracionPerdido(pokemon2.getName()));
						}
				
			} else if(turno == SEGUNDO_POKEMON) {
				
				ataque(pokemon2, pokemon1);
					turno = PRIMER_POKEMON;
					if(pokemon1.getHealth() <= 0) {
						System.out.println(narracionPerdido(pokemon1.getName()));
					}
			}
			
		} //FIN DEL BUCLE
	
	} // FIN DEL METODO
		

	private static String narracionAtaque(String nombrePokemonAtaca, String nombrePokemonRecibe, int fuerza,
			int saludRestante) {
		StringBuilder sb = new StringBuilder();
		sb.append(nombrePokemonAtaca);
		sb.append(" conmienza el ataque contra ");
		sb.append(nombrePokemonRecibe);
		sb.append("\n");
		sb.append(nombrePokemonAtaca);
		sb.append(" daña ");
		sb.append(fuerza);
		sb.append(" a ");
		sb.append(nombrePokemonRecibe);
		sb.append(" y a ");
		sb.append(nombrePokemonRecibe);
		sb.append(" le quedan ");
		sb.append(saludRestante);
		sb.append(" puntos de vida.\n");
		sb.append("--------------------------------------------------------");

		return sb.toString();
	}

	private static String narracionPerdido(String nombrePerdedor) {

		StringBuilder sb = new StringBuilder();

		sb.append(nombrePerdedor);
		sb.append(" ha perdido el combate");
		sb.append("\n--------------------------------------------------------");

		return sb.toString();

	}
	
	private static void ataque(Pokemon ataca, Pokemon recibe) {
		int nuevaSalud = recibe.getHealth() - ataca.getStrength();
		recibe.setHealth(nuevaSalud);
		System.out.println(narracionAtaque(ataca.getName(), recibe.getName(), ataca.getStrength(), recibe.getHealth()));
	}

}
