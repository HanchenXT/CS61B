/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    public static void main(String[] args) {
        
        // Uncomment to find all the padlindromes equal or longer than 4
        /*
        int minLength = 4;
        In in = new In("word.txt");

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && Palindrome.isPalindrome(word)) {
                System.out.println(word);
            }
        }
        */
        
        // Uncomment to find all the off-by-1 padlindromes equal or longer than 4
        /*
        OffByOne offby1 = new OffByOne();
        int minLength = 4;
        In in = new In("word.txt");

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && Palindrome.isPalindrome(word, offby1)) {
                System.out.println(word);
            }
        }
        */
        
        // Uncomment to find all the off-by-N padlindromes equal or longer than 4. In this case, N = 5
        /*
        OffByN offby5 = new OffByN(5);
        int minLength = 4;
        In in = new In("word.txt");

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && Palindrome.isPalindrome(word, offby5)) {
                System.out.println(word);
            }
        }
        */
    }
} 
