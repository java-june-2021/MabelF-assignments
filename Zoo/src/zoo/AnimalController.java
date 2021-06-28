package zoo;

import java.util.ArrayList;

public class AnimalController {
	public static void main(String[] args) {
		System.out.println("Hello spring tool suite rocks");
		
		Animal matt = new Animal("Matt", "Human", 95, 100);
		Animal lion = new Animal("Larry", "Lion", 500, 100);
		
		ArrayList<Animal> myAnimals = new ArrayList<Animal>();
		myAnimals.add(matt);
		myAnimals.add(lion);
		
		for (Animal a : myAnimals) {
			System.out.println(a.getName());
		}
	}

}