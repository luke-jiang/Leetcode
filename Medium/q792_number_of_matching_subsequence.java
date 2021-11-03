class Solution {
    public class Element {
        String s;
        int index;
        public Element(String s, int index) {
            this.s = s; this.index = index;
        }
    }
    
    List<Element>[] heads = new ArrayList[26];
    
    public int numMatchingSubseq(String s, String[] words) {
        for (int i = 0; i < heads.length; i++) {
            heads[i] = new ArrayList<>();
        }
        for (String w : words) {
            heads[w.charAt(0) - 'a'].add(new Element(w, 0));
        }
        int res = 0;
        for (char c : s.toCharArray()) {
            List<Element> oldBucket = heads[c - 'a'];
            heads[c - 'a'] = new ArrayList<>();
            for (Element e : oldBucket) {
                e.index++;
                if (e.index == e.s.length()) {
                    res++;
                } else {
                    heads[e.s.charAt(e.index) - 'a'].add(e);
                }
            }
            oldBucket.clear();
        }
        return res;
    }
}
