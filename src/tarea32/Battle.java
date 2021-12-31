package tarea32;

public class Battle {
	

	public static void initBattle(Pokemon pokemon1, Pokemon pokemon2) {

		while (pokemon1.getHealth() > 0 && pokemon2.getHealth() > 0) {

			if(pokemon1.getSpeed() > pokemon2.getSpeed()) {
				
				ataque(pokemon1, pokemon2);
				System.out.println(narracionAtaque(pokemon1.getName(), pokemon2.getName(), pokemon1.getStrength(), pokemon2.getHealth()));
					
					if(pokemon2.getHealth() <= 0) {
						System.out.println(narracionPerdido(pokemon2.getName()));
					}
					
					else {
						
						ataque(pokemon2, pokemon1);
						System.out.println(narracionAtaque(pokemon2.getName(), pokemon1.getName(), pokemon2.getStrength(), pokemon1.getHealth()));
						
						if(pokemon1.getHealth() <= 0) {
							System.out.println(narracionPerdido(pokemon1.getName()));
						}
					}
				
			}else {
				
					ataque(pokemon2, pokemon1);
					System.out.println(narracionAtaque(pokemon2.getName(), pokemon1.getName(), pokemon2.getStrength(), pokemon1.getHealth()));
						
						if(pokemon1.getHealth() <= 0) {
							System.out.println(narracionPerdido(pokemon1.getName()));
						}
						
						else {
							
							ataque(pokemon1, pokemon2);
							System.out.println(narracionAtaque(pokemon1.getName(), pokemon2.getName(), pokemon1.getStrength(), pokemon2.getHealth()));
							
							if(pokemon2.getHealth() <= 0) {
								System.out.println(narracionPerdido(pokemon2.getName()));
							}
						}
				
			
			}
		} // FIN DEL BUCLE
			
	} // FIN DEL METODO INITBATTLE

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
	}

}
