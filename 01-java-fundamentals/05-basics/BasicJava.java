import java.util.ArrayList;
import java.util.Arrays;
public class BasicJava {
    public static void print1To255() {
        for (int i = 1; i <= 255; i++) {
            System.out.println(i);
        }
    }


    public static void print1To255Odd() {
        for (int i = 1; i <= 255; i++) {
            if (i % 2 == 1) {
                System.out.println(i);
            }
        }
    }


    public static void printSum() {
        int numSoFar = 0;
        for (int i = 0; i <= 255; i++) {
            numSoFar += i;
            System.out.println("New Number: " + i + " Sum: " + numSoFar);
        }
    }

    public static void iterateArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void findMax(int[] arr) {
        int maxSoFar = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxSoFar) {
                maxSoFar = arr[i];
            }
        }
        if (arr.length > 0) {
            System.out.println(maxSoFar);
        }
    }

    public static void findAvg(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println((double) sum / arr.length);
    }

    public static ArrayList<Integer> arrayWithOdds() {
        ArrayList<Integer> y = new ArrayList<>();
        for (int i = 1; i <= 255; i++) {
            if (i % 2 == 1) {
                y.add(i);
            }
        }
        return y;
    }

    public static void numGreaterThan(int[] arr, int y) {
        int numGreaterThan = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > y) {
                numGreaterThan++;
            }
        }
        System.out.println(numGreaterThan);
    }

    public static void squareArrayInPlace(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= arr[i];
        }
    }

    public static void elimNegsInPlace(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                arr[i] = 0;
            }
        }
    }

    public static int[] maxMinAvg(int[] arr) {
        int minSoFar = Integer.MAX_VALUE;
        int maxSoFar = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxSoFar) {
                maxSoFar = arr[i];
            }
            if (arr[i] < minSoFar) {
                minSoFar = arr[i];
            }
            sum += arr[i];
        }
        return new int[]{maxSoFar, minSoFar, sum/arr.length};
    }

    public static void shiftArray(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            arr[i-1] = arr[i];
        }
        arr[arr.length - 1] = 0;
    }


    public static void main(String[] args) {
        print1To255();
        print1To255Odd();
        printSum();
        iterateArray(new int[] {1, -2, 4, 5, 82, 9});
        findMax(new int[] {1, -2, 4, 5, 82, 9, 0});
        findAvg(new int[] {1, 2, 3, 4, 5, 6});
        System.out.println(arrayWithOdds());
        numGreaterThan(new int[] {1, 2, 3, 4, 5, 6}, 3); 
        int[] input1 = new int[] {1, 2, 3, 4, 5, 6};
        squareArrayInPlace(input1);
        System.out.println(Arrays.toString(input1));
        int[] input2 = new int[] {1, -2, 3, 4, 5, 6};
        elimNegsInPlace(input2);
        System.out.println(Arrays.toString(input2));
        int[] input3 = new int[] {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(maxMinAvg(input3)));
        int[] input4 = new int[] {1, 2, 3, 4, 5, 6};
        shiftArray(input4);
        System.out.println(Arrays.toString(input4));
    }
}