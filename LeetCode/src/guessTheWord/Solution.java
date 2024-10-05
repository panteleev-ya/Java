package guessTheWord;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        new Solution().findSecretWord(new String[]{
                        "gaxckt", "trlccr", "jxwhkz", "ycbfps", "peayuf",
                        "yiejjw", "ldzccp", "nqsjoa", "qrjasy", "pcldos",
                        "acrtag", "buyeia", "ubmtpj", "drtclz", "zqderp",
                        "snywek", "caoztp", "ibpghw", "evtkhl", "bhpfla",
                        "ymqhxk", "qkvipb", "tvmued", "rvbass", "axeasm",
                        "qolsjg", "roswcb", "vdjgxx", "bugbyv", "zipjpc",
                        "tamszl", "osdifo", "dvxlxm", "iwmyfb", "wmnwhe",
                        "hslnop", "nkrfwn", "puvgve", "rqsqpq", "jwoswl",
                        "tittgf", "evqsqe", "aishiv", "pmwovj", "sorbte",
                        "hbaczn", "coifed", "hrctvp", "vkytbw", "dizcxz",
                        "arabol", "uywurk", "ppywdo", "resfls", "tmoliy",
                        "etriev", "oanvlx", "wcsnzy", "loufkw", "onnwcy",
                        "novblw", "mtxgwe", "rgrdbt", "ckolob", "kxnflb",
                        "phonmg", "egcdab", "cykndr", "lkzobv", "ifwmwp",
                        "jqmbib", "mypnvf", "lnrgnj", "clijwa", "kiioqr",
                        "syzebr", "rqsmhg", "sczjmz", "hsdjfp", "mjcgvm",
                        "ajotcx", "olgnfv", "mjyjxj", "wzgbmg", "lpcnbj",
                        "yjjlwn", "blrogv", "bdplzs", "oxblph", "twejel",
                        "rupapy", "euwrrz", "apiqzu", "ydcroj", "ldvzgq",
                        "zailgu", "xgqpsr", "wxdyho", "alrplq", "brklfk"
                },
                new Master("hbaczn")
        );
    }

    public static class Master {
        private final String secretWord;

        public Master(String secretWord) {
            this.secretWord = secretWord;
        }

        public int guess(String word) {
            return countMatches(word, secretWord);
        }

        private int countMatches(String word, String other) {
            int matches = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == other.charAt(i)) {
                    matches++;
                }
            }
            return matches;
        }
    }

    public void findSecretWord(String[] words, Master master) {
        List<String> wordlist = new ArrayList<>(Arrays.asList(words));

        // Initialize weights for each position (0 to 5) in the words
        List<Map<Character, Integer>> weights = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            weights.add(new HashMap<>());
        }

        // Count occurrences of characters at each position
        for (String word : wordlist) {
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                Map<Character, Integer> positionWeights = weights.get(i);
                positionWeights.merge(c, 1, Integer::sum);
            }
        }

        // Sort the wordlist based on how common the letters in each word are,
        // so we can reduce more amount of candidates each time we check a word
        wordlist.sort((word1, word2) -> {
            int score1 = 0;
            int score2 = 0;
            for (int i = 0; i < word1.length(); i++) {
                Map<Character, Integer> positionWeights = weights.get(i);
                score1 += positionWeights.getOrDefault(word1.charAt(i), 0);
                score2 += positionWeights.getOrDefault(word2.charAt(i), 0);
            }
            return Integer.compare(score1, score2);
        });

        // Loop while the wordlist has words
        while (!wordlist.isEmpty()) {
            // Get the word from the end of the sorted list
            // with most common characters across all candidates
            String word = wordlist.remove(wordlist.size() - 1);

            int matches = master.guess(word);

            // Filter out words that do not have exactly 'matches' number of matching characters,
            // because if word.compareTo(secret) != word.compareTo(candidate) -> candidate is not
            // a secret word. If it was, then we would have `word.compareTo(secret) != word.compareTo(secret)`,
            // which makes no sense
            List<String> newWordlist = new ArrayList<>();
            for (String other : wordlist) {
                if (matches == countMatches(word, other)) {
                    newWordlist.add(other);
                }
            }

            // Update the wordlist with the filtered one
            wordlist = newWordlist;
        }
    }

    // Counts exact matches between word and other
    private int countMatches(String word, String other) {
        int matches = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == other.charAt(i)) {
                matches++;
            }
        }
        return matches;
    }
}