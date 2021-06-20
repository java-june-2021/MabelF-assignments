package com.codingdojo.java.zookeeper1;

public class BatTest {

	public static void main(String[] args) {
		Bat myBat = new Bat();
		myBat.displayEnergy();
		myBat.attackTown();
		myBat.attackTown();
		myBat.attackTown();
		
		myBat.eatHumans();
		myBat.eatHumans();
		
		myBat.fly();
		myBat.fly();
		myBat.displayEnergy();
	}

}
