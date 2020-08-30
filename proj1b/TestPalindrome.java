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
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("a"));
        assertFalse(palindrome.isPalindrome("car"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome(","));
        assertFalse(palindrome.isPalindrome("a!"));
    }

    @Test
    public void testNewIsPalindrome() {
        CharacterComparator offbyone = new OffByOne();
        assertFalse(palindrome.isPalindrome("Ab", offbyone));
        assertTrue(palindrome.isPalindrome("acdb", offbyone));
        assertFalse(palindrome.isPalindrome("ac", offbyone));
        assertTrue(palindrome.isPalindrome("", offbyone));
        assertTrue(palindrome.isPalindrome(".", offbyone));
        assertFalse(palindrome.isPalindrome("a.", offbyone));
    }
}
