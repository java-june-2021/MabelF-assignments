import java.util.Collections;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class PuzzleJava {
    /**
     * ● Create an array with the following values: 3,5,1,2,7,9,8,13,25,32. Print the sum of all numbers in the array. Also have the function return an array that only includes numbers that are greater than 10 (e.g. when you pass the array above, it should return an array with the values of 13,25,32)

● Create an array with the following values: Nancy, Jinichi, Fujibayashi, Momochi, Ishikawa. Shuffle the array and print the name of each person. Have the method also return an array with names that are longer than 5 characters.

● Create an array that contains all 26 letters of the alphabet (this array must have 26 values). Shuffle the array and, after shuffling, display the last letter from the array. Have it also display the first letter of the array. If the first letter in the array is a vowel, have it display a message.

To shuffle a collection, you can use the shuffle method of the Collections class. Collections Class documentation
● Generate and return an array with 10 random numbers between 55-100.

To get a random integer, you can use the nextInt method of the Random class. Random Class documentation
● Generate and return an array with 10 random numbers between 55-100 and have it be sorted (showing the smallest number in the beginning). Display all the numbers in the array. Next, display the minimum value in the array as well as the maximum value.

To sort a collection, you can use the sort method of the Collections class.
● Create a random string that is 5 characters long.

● Generate an array with 10 random strings that are each 5 characters long
     */
    public static int[] sumAndGreaterThan10() {
        int[] arr = new int[]{3,5,1,2,7,9,8,13,25,32};
        int[] arrGreater10 = new int[arr.length];
        int sum = 0;
        int numGreaterThan10 = 0;
        int insertIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] > 10) {
                arrGreater10[insertIdx] = arr[i];
                numGreaterThan10++;
                insertIdx++;
            }
        }
        System.out.println(sum);
        return Arrays.copyOfRange(arrGreater10, 0, numGreaterThan10);
    }

    public static String[] shuffleAndGreaterThan5() {
        List<String> names = Arrays.asList("Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa");
        ArrayList<String> longerThan5 = new ArrayList<>();
        Collections.shuffle(names); // Inplace
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).length() > 5) {
                longerThan5.add(names.get(i));
            }
            System.out.println(names.get(i));
        }
        return null;
    }

    public static void alphabetShuffle() {
        String alphabetString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        List<String> alphabet = new ArrayList<>(Arrays.asList(alphabetString.split("")));
        Collections.shuffle(alphabet);
        System.out.println(alphabet.get(0));
        System.out.println(alphabet.get(alphabet.size() - 1));
        switch (alphabet.get(0)) {
            case "A":
            case "E":
            case "I":
            case "O":
            case "U":
                System.out.println("First element is a vowel!");
        }
    }

    /**
     * Generate and return an array with 10 random numbers between 55-100.
     */
    public static int[] tenRandomNumbers55To100() {
        Random myRandomGen = new Random();
        int[] randomNums = new int[10];
        for (int i = 0; i < 10; i++) {
            randomNums[i] = myRandomGen.nextInt(45) + 55;
        }
        return randomNums;
    }

    public static void tenRandomNumbers55To100Sorted() {
        Random myRandomGen = new Random();
        List<Integer> randomNums = new ArrayList<>(); //Aslist doesnt work on integers
        for (int i = 0; i < 10; i++) {
            randomNums.add(myRandomGen.nextInt(45) + 55);
        }
        Collections.sort(randomNums); // Ascending
        
        System.out.println(randomNums);
        System.out.println("Minimum is: " + randomNums.get(0));
        System.out.println("Maximum is: " + randomNums.get(9));
    }

    public static String random5CharString() {
        Random myRandomGen = new Random();
        String base = "";
        for (int i = 0; i < 5; i++) {
            base += "ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(myRandomGen.nextInt(26));
        }
        return base;
    }

    public static String[] tenRandomStrings() {
        String[] randomStrings = new String[10];
        for (int i = 0; i < 10; i++) {
            randomStrings[i] = random5CharString();
        }
        return randomStrings;
    }

    public static void main(String[] args) {
        // System.out.println(Arrays.toString(sumAndGreaterThan10()));
        // shuffleAndGreaterThan5();
        // alphabetShuffle();
        // System.out.println(Arrays.toString(tenRandomNumbers55To100()));
        // tenRandomNumbers55To100Sorted();
        // System.out.println(random5CharString());
        System.out.println(Arrays.toString(tenRandomStrings()));
    }
}