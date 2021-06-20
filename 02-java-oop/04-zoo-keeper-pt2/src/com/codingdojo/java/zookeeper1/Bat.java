package com.codingdojo.java.zookeeper1;

public class Bat extends Mammal {

	public Bat() {
		energyLevel = 300;
	}
	
	
	/**
	 * For the fly() method, print the sound a bat taking off and decrease its energy by 50.
	 */
	public void fly() {
		System.out.println("Bat has flown: Flap flap flap");
		energyLevel -= 50;
	}

	
	/**
	 * For the eatHumans() method, print the so- well, never mind, just increase its energy by 25.
	 */
	public void eatHumans() {
		System.out.println("Bat has eaten human: c r u n c h");
		energyLevel += 25;
	}
	
	
	/**
	 * For the attackTown() method, print the sound of a town on fire and decrease its energy by 100.
	 */
	public void attackTown() {
		System.out.println("Bat has attacked town: sizzle ");
		energyLevel -= 100;
	}
	
	
}
