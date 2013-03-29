package tree;

import java.util.LinkedList;
import java.util.List;
/**
 * 
 * @author haohanwang
 *
 */
public class MyTree {
  private MyTreeNode root = new MyTreeNode(0);
  private List<MyTreeNode> children = new LinkedList<MyTreeNode>();
  MyTree(MyTreeNode root) {
    this.setRoot(root);
  }

  MyTree(int a) {
    getRoot().val = a;
    getRoot().left = null;
    getRoot().right = null;
  }

  MyTree(String[] s) throws Exception {
    MyTreeNode[] temp = new MyTreeNode[s.length];
    if (s[0] == "#" || s[0] == "!") {
      System.out.println("cannot creat tree with a null root");
      throw (new Exception());
    }
    getRoot().val = Integer.parseInt(String.valueOf(s[0]));
    temp[0] = getRoot();
    for (int i = 0; i*2+1 <= s.length - 1; i++) {
      if (temp[i] != null) {
        if (s[i * 2 + 1] == "!") {
          break;
        } else if (s[i * 2 + 1] == "#") {
          temp[i].left = null;
        } else {
          temp[i].left=new MyTreeNode(Integer.parseInt(String.valueOf(s[i*2+1]))); 
          temp[i*2+1]=temp[i].left;
          children.add(temp[i].left);
        }
      }
      if (i*2+2<=s.length-1&&temp[i]!=null){
        if (s[i * 2 + 2] == "!") {
          break;
        } else if (s[i * 2 + 2] == "#") {
          temp[i].right = null;
        } else {
          temp[i].right= new MyTreeNode(Integer.parseInt(String.valueOf(s[i*2+2])));
          temp[i*2+2]=temp[i].right;
          children.add(temp[i].right);
        }
      }
    }
  }
  public void addNode(MyTreeNode m){
    LinkedList<MyTreeNode> queue = new LinkedList<MyTreeNode>();
    queue.add(getRoot());
    while (!queue.isEmpty()){
      MyTreeNode temp = queue.getFirst();
      if (temp.left==null){
        temp.left = m;
        break;
      } else {
        queue.add(temp.left);
      }
      if (temp.right==null){
        temp.right = m;
        break;
      } else {
        queue.add(temp.right);
      }
      queue.removeFirst();
    }
  }
  
  public void printLevelOrder(){
    LinkedList<MyTreeNode> queue = new LinkedList<MyTreeNode>();
    queue.add(getRoot());
    while (!queue.isEmpty()){
      MyTreeNode temp = queue.getFirst();
      if (temp!=null){
        System.out.print(temp.val+" ");
        queue.add(temp.left);
        queue.add(temp.right);
      } else{
        System.out.print("# ");
      }
      queue.removeFirst();
    }
  }
  
  public static void main(String args[]){
    String [] a = {"3","2", "5", "#", "2", "6", "!"};
    MyTree tree =null;
    try {
      tree = new MyTree(a);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    tree.printLevelOrder();
  }

  public MyTreeNode getRoot() {
    return root;
  }

  public void setRoot(MyTreeNode root) {
    this.root = root;
  }
}
