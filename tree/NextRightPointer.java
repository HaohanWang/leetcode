package tree;

import java.util.ArrayList;
import java.util.List;

public class NextRightPointer {
  public void connect(TreeLinkNode root) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (root != null) {
      List<TreeLinkNode> q = new ArrayList<TreeLinkNode>();
      int level = 1;
      q.add(root);
      int i = 0;
      while (q.size() != i) {
        if (i == Math.pow(2, level) - 2) {
          level++;
          q.get(i).next = null;
        } else {
          q.get(i).next = q.get(i + 1);
        }
        if (q.get(i).left != null) {
          q.add(q.get(i).left);
        }
        if (q.get(i).right != null) {
          q.add(q.get(i).right);
        }
        i++;
      }
    }
  }
  /**
   * Two better solutions
void connect(Node* p) {
  if (p == NULL)
    return;
  if (p->leftChild == NULL || p->rightChild == NULL)
    return;
  Node* rightSibling;
  Node* p1 = p;
  while (p1) {
    if (p1->nextRight)
      rightSibling = p1->nextRight->leftChild;
    else
      rightSibling = NULL;
    p1->leftChild->nextRight = p1->rightChild;
    p1->rightChild->nextRight = rightSibling;
    p1 = p1->nextRight;
  }
  connect(p->leftChild);
}

void connect(Node* p) {
  if (!p) return;
  if (p->leftChild)
  p->leftChild->nextRight = p->rightChild;
  if (p->rightChild)
    p->rightChild->nextRight = (p->nextRight) ?
                               p->nextRight->leftChild :
                               NULL;
  connect(p->leftChild);
  connect(p->rightChild);
}
   */
  
}
