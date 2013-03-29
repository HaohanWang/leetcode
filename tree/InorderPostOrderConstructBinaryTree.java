package tree;

public class InorderPostOrderConstructBinaryTree {
  public MyTreeNode buildTree(int[] inorder, int[] postorder) {
    // Start typing your Java solution below
    // DO NOT write main() function
    MyTreeNode root = buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    return root;
  }

  public MyTreeNode buildTree(int[] inorder, int[] postorder, int startIn, int endIn, int startPos,
          int endPos) {
    if (startPos > endPos) {
      return null;
    }
    MyTreeNode root = new MyTreeNode(postorder[endPos]);
    for (int i = 0; i <= inorder.length - 1; i++) {
      if (inorder[i] == root.val) {
        int rightLength = endIn - i;
        root.left = buildTree(inorder, postorder, startIn, i - 1, startPos, endPos - 1
                - rightLength);
        root.right = buildTree(inorder, postorder, i + 1, endIn, endPos - rightLength, endPos - 1);
      }
    }
    return root;
  }
}
