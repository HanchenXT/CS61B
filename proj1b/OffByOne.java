public class OffByOne implements CharacterComparator{
    
    // This method customized the comparison method.  Returns true if x and y is off-by-1.
    // Examples: 'a' and 'b' are off-by-1; 'c' and 'd' are off-by-1.
    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        if (diff == 1) {
            return true;
        } else {return false;}
    }
}
