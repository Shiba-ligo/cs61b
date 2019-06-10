import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    @Test
    public void testPalindrome1() {
        assertTrue(palindrome.isPalindrome("a"));
    }

    @Test
    public void testPalindrome2() {
        assertTrue(palindrome.isPalindrome("AcA"));
    }

    @Test
    public void testPalindrome3() {
        assertFalse(palindrome.isPalindrome("Aca"));
    }

    @Test
    public void testPalindrome4() {
        assertTrue(palindrome.isPalindrome("sttts"));
    }


    /** unit tests for isPalindrome with OffByOne. */
    @Test
    public void testPalindromeOffByOne1() {
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("a", cc));
    }

    @Test
    public void testPalindromeOffByOne2() {
        CharacterComparator cc = new OffByOne();
        assertFalse(palindrome.isPalindrome("AcA", cc));
    }

   


    /** unit tests for isPalindrome with OffByN. */
    @Test
    public void testPalindromeOffByN1() {
        CharacterComparator cc = new OffByN(5);
        assertTrue(palindrome.isPalindrome("a", cc));
    }

    @Test
    public void testPalindromeOffByN2() {
        CharacterComparator cc = new OffByN(5);
        assertTrue(palindrome.isPalindrome("acf", cc));
    }



}
