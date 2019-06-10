public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> palin = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i += 1) {
            palin.addLast(word.charAt(i));
        }
        return palin;
    }

    private boolean isPalindromeHelper(Deque<Character> word) {
        if (word.size() < 2) {
            return true;
        } else {
            return word.removeFirst() == word.removeLast() && isPalindromeHelper(word);
        }
    }

    public boolean isPalindrome(String word) {
        Deque wordInDeque = wordToDeque(word);
        return isPalindromeHelper(wordInDeque);
    }
    private boolean isPalindromeHelper2(Deque<Character> word, CharacterComparator cc) {
        if (word.size() < 2) {
            return true;
        } else {
            return cc.equalChars(word.removeFirst(), word.removeLast())
                    && isPalindromeHelper2(word, cc);
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque wordInDeque = wordToDeque(word);
        return isPalindromeHelper2(wordInDeque, cc);
    }
}
