class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> pg = new ArrayList<>();
        pg.add(new ArrayList<>());
        int len = -1;
        int row = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            len += word.length() + 1;
            if (len > maxWidth) {
                row++;
                pg.add(new ArrayList<>());
                len = word.length();
            }
            pg.get(pg.size()-1).add(word);
        }
        
        // System.out.println(pg);
        
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < pg.size(); i++) {
            List<String> line = pg.get(i);
            int missing = maxWidth;
            for (String word : line) missing -= word.length();
            if (line.size() == 1) { // single word, left justified
                sb.append(line.get(0));
                for (int j = 0; j < missing; j++) {
                    sb.append(' ');
                }
            } else if (i < pg.size() - 1) {
                int spaces = missing / (line.size() - 1);
                int extra = missing % (line.size() - 1);
                sb.append(line.get(0));
                for (int j = 1; j < line.size(); j++) {
                    for (int k = 0; k < spaces + (extra > 0 ? 1 : 0); k++) {
                        sb.append(' ');
                    }
                    sb.append(line.get(j));
                    extra--;
                }
            } else { // last line, left justified
                for (int j = 0; j < line.size(); j++) {
                    sb.append(line.get(j));
                    if (missing > 0) {
                        sb.append(' ');
                        missing--;
                    }
                }
                for (int j = 0; j < missing; j++) {
                    sb.append(' ');
                }
            }
            res.add(sb.toString());
            sb.setLength(0);
        }
        return res;
    }
}
