package com.codingdojo.java.zookeeper1;

public class Mammal {
	protected int energyLevel; // Will rely on the 0-argument constructor to set this to 0 (default int value)

	public int displayEnergy() {
		System.out.println("Energy level is: " + energyLevel);
		return energyLevel;
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
