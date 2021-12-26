package tarea32;

public class Battle {

	public static void initBattle(Pokemon pokemon1, Pokemon pokemon2) {

		while (pokemon1.getHealth() != 0 && pokemon2.getHealth() != 0) {

			if (pokemon1.getSpeed() > pokemon2.getSpeed()) {

				pokemon2.setHealth(pokemon2.getHealth() - pokemon1.getStrength());
				narracionAtaque(pokemon1.getName(), pokemon2.getName(), pokemon1.getStrength(), pokemon2.getHealth());

				if (pokemon2.getHealth() > 0) {

					pokemon1.setHealth(pokemon1.getHealth() - pokemon2.getStrength());
					narracionAtaque(pokemon2.getName(), pokemon1.getName(), pokemon2.getStrength(),
							pokemon1.getHealth());

				} else {
					System.out.println(narracionPerdido(pokemon2.getName()));
				}

			} else {

				pokemon1.setHealth(pokemon1.getHealth() - pokemon2.getStrength());
				narracionAtaque(pokemon2.getName(), pokemon1.getName(), pokemon2.getStrength(), pokemon1.getHealth());

				if (pokemon1.getHealth() > 0) {

					pokemon2.setHealth(pokemon2.getHealth() - pokemon1.getStrength());
					narracionAtaque(pokemon1.getName(), pokemon2.getName(), pokemon1.getStrength(),
							pokemon2.getHealth());

				} else {

					System.out.println(narracionPerdido(pokemon1.getName()));
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
		sb.append(" vida.\n");
		sb.append("--------------------------------------------------------");

		return sb.toString();
	}

	private static String narracionPerdido(String nombrePerdedor) {

		StringBuilder sb = new StringBuilder();

		sb.append(nombrePerdedor);
		sb.append(" ha perdido el combate");

		return sb.toString();

	}

}
