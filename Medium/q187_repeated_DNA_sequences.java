// [Sliding Window + HashSet, Rabin-Karp]


// KEY:
// how to perform a window slice of size 10 in O(1).
// answer: rolling hash.
// algorithm:
/*
  convert string of chars to string of ints using a pre-defined mapping.
  a := number of unique characters in the string
  L := window size
  ci := digit at i
  h0 = sum {i = 0 to L-1 : ci * a^(L-1-i) }     // encode the string into a number of base a.
  h1 = (h0 * 4 - c0 * a^L) + c_{L+1}
*/


class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int L = 10;
        int n = s.length();

        if (n <= L) {
            return new ArrayList<>();
        }

        int a = 4;
        int aL = (int) Math.pow(a, L);

        // map characters to ints
        Map<Character, Integer> toInt = new HashMap<>();
        toInt.put('A', 0);
        toInt.put('C', 1);
        toInt.put('G', 2);
        toInt.put('T', 3);

        // convert string of chars to string of integers
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = toInt.get(s.charAt(i));
        }

        int h = 0;
        Set<Integer> seen = new HashSet<>();
        Set<String> output = new HashSet<>();

        for (int start = 0; start < n - L + 1; start++) {
            if (start != 0) {
                // hash updating for h1 case
                h = h * a - nums[start - 1] * aL + nums[start + L - 1];
            } else {
                // find h0
                for (int i = 0; i < L; i++) {
                    h = h * a + nums[i];
                }
            }
            if (seen.contains(h)) {
                output.add(s.substring(start, start + L));
            }
            seen.add(h);
        }

        return new ArrayList<>(output);
    }
}
