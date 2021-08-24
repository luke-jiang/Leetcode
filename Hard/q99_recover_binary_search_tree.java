
/** Two elements of a binary search tree (BST) are swapped by mistake.
  * Recover the tree without changing its structure.
  */

class Solution1 {
    List<Integer> tosort;
    List<Integer> sorted;
    List<TreeNode> pointers;

    public void recoverTree(TreeNode root) {
        tosort = new ArrayList<>();
        sorted = new ArrayList<>();
        pointers = new ArrayList<>();
        inorder(root);

        Collections.sort(sorted);

        int fst = -1;
        int snd = -1;

        for (int i = 0; i < sorted.size(); i++) {
            if ((int) sorted.get(i) != (int) tosort.get(i)) {
                if (fst == -1) fst = i;
                else snd = i;
            }
        }

        int tmp = pointers.get(fst).val;
        pointers.get(fst).val = pointers.get(snd).val;
        pointers.get(snd).val = tmp;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        tosort.add(node.val);
        sorted.add(node.val);
        pointers.add(node);
        inorder(node.right);
    }
}


class Solution2 {
  // sorting is not necessary
    List<Integer> tosort;
    List<TreeNode> pointers;

    public void recoverTree(TreeNode root) {
        tosort = new ArrayList<>();
        pointers = new ArrayList<>();
        inorder(root);

        int fst = -1;
        int snd = -1;

        for (int i = 0; i < tosort.size()-1; i++) {
            int x = tosort.get(i);
            int y = tosort.get(i+1);
            if (fst == -1 && x > y) {
                fst = i;
                snd = i + 1;
            } else if (x > y) {
                snd = i + 1;
            }
        }

        int tmp = pointers.get(fst).val;
        pointers.get(fst).val = pointers.get(snd).val;
        pointers.get(snd).val = tmp;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        tosort.add(node.val);
        pointers.add(node);
        inorder(node.right);
    }
}

class Solution3 {
    List<TreeNode> nodes;

    public void recoverTree(TreeNode root) {
        nodes = new ArrayList<>();
        inorder(root);

        // indices of the wrong nodes
        int fst = -1;
        int snd = -1;

        for (int i = 0; i < nodes.size()-1; i++) {
            int x = nodes.get(i).val;
            int y = nodes.get(i+1).val;
            if (fst == -1 && x > y) {
                fst = i;
                snd = i + 1;
            } else if (x > y) {
                snd = i + 1;
            }
        }

        // swap the values
        int tmp = nodes.get(fst).val;
        nodes.get(fst).val = nodes.get(snd).val;
        nodes.get(snd).val = tmp;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        nodes.add(node);
        inorder(node.right);
    }
}
