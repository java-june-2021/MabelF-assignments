package com.codingdojo.java.zookeeper1;

public class Gorilla extends Mammal {
	
	public void throwSomething() {
		System.out.println("The gorilla has thrown something and lost 5 energy!");
		this.energyLevel -= 5;
	}
	
	public void eatBananas() {
		System.out.println("The gorilla has eaten a banana and gained 10 energy!");
		this.energyLevel += 10;
	}
	
	public void climb() {
		System.out.println("The gorilla has climbed a tree and lost 10 energy!");
		this.energyLevel -= 10;
	}

}
