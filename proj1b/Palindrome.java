public class Palindrome {
    
    // Return a Deque where the characters in the deque appear in the same order as in the word
    public static Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new ArrayDequeSolution<Character>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            deque.addLast(c);
        }
        return deque;
    }
    
    // Return true if the given word is palindrome, and false otherwise
    public static boolean isPalindrome(String word) {
        
        // Generate a deque containing each character in the word
        Deque<Character> deque = wordToDeque(word);
        
        // Any word of length 1 or 0 is a palindrome
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        int ct = 0;
        for (int i = 0; i < word.length()/2; i++) {
            char f = deque.removeFirst();
            char l = deque.removeLast();
            if (f == l) {ct++;}
        }
        if (ct == word.length()/2) {
            return true;
            } else {
                return false;
            }
    }
    
    /* 
     * Return true if the word is palindrome according to the character comparison test
     * provided by the CharacterComparator passed in as argument cc
     */
    public static boolean isPalindrome(String word, CharacterComparator cc) {
        
        // Generate a deque containing each character in the word
        Deque<Character> deque = wordToDeque(word);
        
        // Any word of length 1 or 0 is a palindrome
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        int ct = 0;
        for (int i = 0; i < word.length()/2; i++) {
            char f = deque.removeFirst();
            char l = deque.removeLast();
            if (cc.equalChars(f, l)) {ct++;}
        }
        if (ct == word.length()/2) {
            return true;
            } else {
                return false;
            }
        
    }
    
    public static void main(String[] args) {
        // Simple test wordToDeque
        String word = "raceedfcar";
        Deque<Character> deque = wordToDeque(word);
        deque.printDeque();
        System.out.println(isPalindrome(word));
        
    }

}
