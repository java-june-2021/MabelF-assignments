public class StringManipulator {
    public static String trimAndConcat(String a, String b) {
        return a.trim() + b.trim();
    }

    public static Integer getIndexOrNull(String str, char c) {
        return str.indexOf(c) != -1 ? str.indexOf(c) : null ;
    }

    public static Integer getIndexOrNull(String a, String b) {
        return a.indexOf(b) != -1 ? a.indexOf(b) : null ;
    }

    /**
     * Get a substring using a starting and ending index, and concatenate that with the second string 
     * input to our method. Feel free to use the substring method of the String class.
     */
    public static String concatSubstring(String first, int start, int end, String second) {
        return first.substring(start, end) + second;
    }
}