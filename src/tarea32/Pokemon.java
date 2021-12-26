package tarea32;

public class Pokemon {

	private static final int INITIAL_HEALTH = 301;
	private static final int INITIAL_STRENGTH = 51;
	private static final int INITIAL_SPEED = 201;
	private int health;
	private int strength;
	private int speed;
	private String name;
	
	public Pokemon() {
		this.health = (int)(Math.random() * INITIAL_HEALTH);
		this.strength = (int)(Math.random() * INITIAL_STRENGTH);
		this.speed = (int)(Math.random() * INITIAL_SPEED);
		this.name = "";
	}
	
	public Pokemon(int health, int strength, int speed, String name) {
	
		this.health = health;
		this.strength = strength;
		this.speed = speed;
		this.name = name;
		
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public int getStrength() {
		return this.strength;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setHealth(int health) {
	this.health = health;	
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}
