// [Sorting/BFS]

/** You are asked to cut off all the trees in a forest for a golf event. The forest is represented as an m x n matrix. In this matrix:
  * 0 means the cell cannot be walked through.
  * 1 represents an empty cell that can be walked through.
  * A number greater than 1 represents a tree in a cell that can be walked through, and this number is the tree's height.

  * In one step, you can walk in any of the four directions: north, east, south, and west. If you are standing in a cell with a tree, you can choose whether to cut it off.
  * You must cut off the trees in order from shortest to tallest. When you cut off a tree, the value at its cell becomes 1 (an empty cell).
  * Starting from the point (0, 0), return the minimum steps you need to walk to cut off all the trees. If you cannot cut off all the trees, return -1.

  * You are guaranteed that no two trees have the same height, and there is at least one tree needs to be cut off.
  */

// first sort the trees based on their heights, then use BFS to search for min distance for each pair of trees.
class Solution {
    public class Element {
        int x;
        int y;
        int val;
        public Element(int x, int y, int val) {
            this.x = x; this.y = y; this.val = val;
        }
        public String toString() {
            return "(" + x + "," + y + "," + val + ")";
        }
    }
    int m;
    int n;
    int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int cutOffTree(List<List<Integer>> forest) {
        List<Element> trees = new ArrayList<>();
        m = forest.size();
        n = forest.get(0).size();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int height = forest.get(i).get(j);
                if (height > 1) {
                    trees.add(new Element(i, j, height));
                }
            }
        }
        Collections.sort(trees, new Comparator<Element>(){
            @Override
            public int compare(Element a, Element b) {
                return a.val - b.val;
            }
        });
        // System.out.println(trees);
        Element prev = new Element(0, 0, 0);
        int res = 0;
        for (Element tree : trees) {
            int dist = getDist(forest, prev, tree);
            if (dist == -1) return -1;
            res += dist;
            prev = tree;
        }
        return res;
    }
    
    private int getDist(List<List<Integer>> forest, Element from, Element to) {
        Queue<Element> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        q.add(from);
        visited[from.x][from.y] = true;
        int level = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                Element curr = q.remove();
                if (curr.x == to.x && curr.y == to.y) {
                    return level;
                }
                for (int[] d : dirs) {
                    int x1 = d[0] + curr.x;
                    int y1 = d[1] + curr.y;
                    if (x1 < 0 || x1 >= m || y1 < 0 || y1 >= n) continue;
                    if (visited[x1][y1] || forest.get(x1).get(y1) < 1) continue;
                    q.add(new Element(x1, y1, forest.get(x1).get(y1)));
                    visited[x1][y1] = true;
                }
            }
            level++;
        }
        return -1;
    }
}
