public class MaxProduct {
    public static void main(String[] args) {
        String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(maxProduct(words));
    }

        public static int maxProduct(String[] words) {

            int max = 0;
            for(int i = 0;i < words.length;i++) {
                String word1 = words[i];

                for(int j = i + 1;j < words.length;j++) {
                    String word2 = words[j];
                    boolean res = f(word1, word2);
                    if (res) {
                    }
                    else {
                        int len1 = word1.length();
                        int len2 = word2.length();
                        int val = len1 * len2;
                        max = Math.max(val, max);
                    }
                }
            }

            return max;
        }

        public static boolean f(String word1, String word2) {
            for(int i = 0;i < word1.length();i++) {
                char ch = word1.charAt(i);
                for (int j = 0; j < word2.length(); j++) {
                    char ch2 = word2.charAt(j);
                    if (ch == ch2) {
                        return true;
                    }
                }
            }

            return false;
        }
}
