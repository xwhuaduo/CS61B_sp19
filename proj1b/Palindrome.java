public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> res = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            res.addLast(word.charAt(i));
        }
        return res;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> word1 = wordToDeque(word);
        return isPalindromeRecursion(word1);
    }

    private boolean isPalindromeRecursion(Deque<Character> q) {
        if (q.size() <= 1) {
            return true;
        }

        if (q.removeFirst() == q.removeLast()) {
            return isPalindromeRecursion(q);
        }
        return false;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> word1 = wordToDeque(word);
        return isNewPalindromeRecursion(word1, cc);
    }

    private boolean isNewPalindromeRecursion(Deque<Character> q, CharacterComparator cc) {
        if (q.size() <= 1) {
            return true;
        }

        if (cc.equalChars(q.removeFirst(), q.removeLast())) {
            return isNewPalindromeRecursion(q, cc);
        }
        return false;
    }
}

