package com.codingdojo.java.zookeeper1;

public class GorillaTest {

	
	/** 
	 *  Create a GorillaTest class to instantiate a gorilla and have it throw three things, 
	 *  eat bananas twice, and climb once.
	 * @param args
	 */
	public static void main(String[] args) {
		Gorilla myGorilla = new Gorilla();
		myGorilla.displayEnergy();
		myGorilla.throwSomething();
		myGorilla.throwSomething();
		myGorilla.throwSomething();
		// Should be -15
		
		myGorilla.eatBananas();
		myGorilla.eatBananas();
		// Should be +5
		
		myGorilla.climb();
		// Should be -5
		
		myGorilla.displayEnergy();
	}

}
