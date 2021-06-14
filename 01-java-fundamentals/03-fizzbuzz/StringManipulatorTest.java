public class StringManipulatorTest {
    public static void main(String[] args) {
        // Prep
        StringManipulator manipulator = new StringManipulator();

        // Test1
        String str = manipulator.trimAndConcat("    Hello               ","     Ninjas    ");
        System.out.println(str); 


        // Test2
        char letter = 'o';
        Integer a = manipulator.getIndexOrNull("Coding", letter);
        Integer b = manipulator.getIndexOrNull("Hello World", letter);
        Integer c = manipulator.getIndexOrNull("lksdjflskdfjlksdjf", letter);
        System.out.println(a); // 1
        System.out.println(b); // 4
        System.out.println(c); // null

                
        String word = "Hello";
        String subString = "ello";
        String notSubString = "Dojo";
        Integer a1 = manipulator.getIndexOrNull(word, subString);
        Integer b1 = manipulator.getIndexOrNull(word, notSubString);
        System.out.println(a1); // 1
        System.out.println(b1); // null

        // Test 4
        String word4 = manipulator.concatSubstring("abcdefghijklmnop", 1, 2, "world");
        System.out.println(word4); // eworld

        
    }
}