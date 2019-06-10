public class OffByN implements CharacterComparator {
    public int offN;
    public OffByN(int N) {
        offN = N;
    }
    @Override
    public boolean equalChars(char x, char y) {
        if(x - y == offN || y - x == offN) {
            return true;
        } else {
            return false;
        }
    }
}
