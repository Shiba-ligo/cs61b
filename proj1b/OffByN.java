public class OffByN implements CharacterComparator {
    private int offN;
    public OffByN(int N) {
        offN = N;
    }
    @Override
    public boolean equalChars(char x, char y) {
        return x - y == offN || y - x == offN;
    }
}
