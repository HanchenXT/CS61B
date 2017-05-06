public class OffByN implements CharacterComparator {
    
    public int N; 
    
    /// Constructor
    public OffByN (int n) {
        this.N = n;
    }
    
    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        if (diff == N) {
            return true;
        } else {return false;}
    }

}
