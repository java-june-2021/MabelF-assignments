package zoo;
public class Animal {

	private String name;
	private String species;
	private int strength;
	private int stamina;
	
	public Animal(String name, String species, int strength, int stamina) {
		super();
		this.name = name;
		this.species = species;
		this.strength = strength;
		this.stamina = stamina;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getStamina() {
		return stamina;
	}
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

}
