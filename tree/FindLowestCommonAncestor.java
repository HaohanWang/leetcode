package tree;

public class FindLowestCommonAncestor {
  public static void main(String args[]) {
    String[] a = { "3", "2", "5", "6", "7", "8", "4" ,"1","#","#","10","11","#","#", "13", "!"};
    MyTree tree = null;
    try {
      tree = new MyTree(a);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    MyTreeNode p = new MyTreeNode(7);
    MyTreeNode q = new MyTreeNode(6);
    MyTreeNode lca = new FindLowestCommonAncestor().findLCA(tree.getRoot(), p, q);
    System.out.println(lca.val);
  }

  public MyTreeNode findLCA(MyTreeNode root, MyTreeNode p, MyTreeNode q) {
    if (root == null)
      return null;
    if (root.val == p.val || root.val == q.val)
      return root;
    MyTreeNode lc = findLCA(root.left, p, q);
    MyTreeNode rc = findLCA(root.right, p, q);
    if (lc != null && rc != null)
      return root;
    if (lc == null) {
      return rc;
    } else {
      return lc;
    }
  }
}
