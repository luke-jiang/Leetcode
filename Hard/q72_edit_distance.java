// [DP]

/** Given two words word1 and word2, find the minimum number of operations
  * required to convert word1 to word2.
  *
  * You have the following 3 operations permitted on a word:
  * 1. Insert a character
  * 2. Delete a character
  * 3. Replace a character
  */


class Solution1 {
    // dist[i,j] := edit distance between word1[0, i] and word2[0, j]
    // eventually return dist[word1.length-1, word2.length-1]

    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dist = new int[len1+1][len2+1];
        for (int i = 0; i < len1+1; i++) {
            dist[i][0] = i;
        }
        for (int i = 0; i < len2+1; i++) {
            dist[0][i] = i;
        }

        for (int i = 1; i < len1+1; i++) {
            for (int j = 1; j < len2+1; j++) {
                int x = dist[i-1][j-1];
                int y = dist[i][j-1];
                int z = dist[i-1][j];
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dist[i][j] = Math.min(x, 1+Math.min(y, z));
                } else {
                    dist[i][j] = 1 + Math.min(x, Math.min(y, z));
                }
            }
        }
        return dist[len1][len2];
    }
}


class Solution2 {
    // memoization
    // dist[i,j] := edit distance between word1[0, i] and word2[0, j]
    // eventually return dist[word1.length-1, word2.length-1]
    int[][] dist;
    int len1;
    int len2;
    String w1;
    String w2;

    public int minDistance(String word1, String word2) {
        len1 = word1.length();
        len2 = word2.length();
        w1 = word1;
        w2 = word2;
        dist = new int[len1][len2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                dist[i][j] = -1;
            }
        }
        return get(len1-1, len2-1);
    }

    private int get(int i, int j) {
        if (i < 0 && j < 0) return 0;
        if (i < 0 && j >= 0) return j+1;
        if (i >= 0 && j < 0) return i+1;

        if (dist[i][j] != -1) return dist[i][j];

        if (w1.charAt(i) == w2.charAt(j)) {
            dist[i][j] = Math.min(get(i-1,j-1), 1 + Math.min(get(i,j-1), get(i-1,j)));
        } else {
            dist[i][j] = 1 + Math.min(get(i-1,j-1), Math.min(get(i,j-1), get(i-1,j)));
        }
        return dist[i][j];
    }
}
