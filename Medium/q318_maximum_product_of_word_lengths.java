class Solution1 {
    int[][] dict;

    public int maxProduct(String[] words) {
        if (words.length == 0) return 0;

        dict = new int[words.length][4];
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            dict[i][0] = w.length();
            for (int j = 0; j < w.length(); j++) {
                int index = w.charAt(j) - 'a';
                int pointer = index / 9 + 1;
                int offset = index % 9;
                dict[i][pointer] = dict[i][pointer] | (1 << offset);
            }
        }

        int[] dp = new int[words.length];
        for (int i = 1; i < words.length; i++) {
            dp[i] = dp[i-1];
            for (int j = 0; j < i; j++) {
                if ((dict[i][1] & dict[j][1]) == 0 &&
                    (dict[i][2] & dict[j][2]) == 0 &&
                    (dict[i][3] & dict[j][3]) == 0) {
                    dp[i] = Math.max(dp[i], dict[i][0] * dict[j][0]);
                }
            }
        }
        return dp[words.length-1];
    }
}

class Solution2 {
    int[][] dict;

    public int maxProduct(String[] words) {
        if (words.length == 0) return 0;

        dict = new int[words.length][27];
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            for (int j = 0; j < w.length(); j++) {
                int index = w.charAt(j) - 'a' + 1;
                dict[i][index]++;
            }
            dict[i][0] = w.length();
        }

        int[] dp = new int[words.length];
        for (int i = 1; i < words.length; i++) {
            dp[i] = dp[i-1];
            for (int j = 0; j < i; j++) {
                if (!collide(i, j)) {
                    dp[i] = Math.max(dp[i], dict[i][0] * dict[j][0]);
                }
            }
        }
        return dp[words.length-1];
    }

    private boolean collide(int i, int j) {
        int[] dicti = dict[i];
        int[] dictj = dict[j];
        for (int k = 1; k < 27; k++) {
            if (dicti[k] > 0 && dictj[k] > 0) return true;
        }
        return false;
    }
}
