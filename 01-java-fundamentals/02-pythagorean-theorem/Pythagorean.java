public class Pythagorean {
    /**
     * The hypotenuse is the side across from the right angle. Calculate the value of c given legA and legB
     */
    public double calculateHypotenuse(int legA, int legB) {
        return Math.sqrt(Math.pow(legA, 2) + Math.pow(legB, 2));
    }
}

