package input;

import java.util.ArrayList;
import java.util.Collections;

public class RandomNumber {
  public int [] generateRandomNumber(int from, int to){
    int [] result = new int[to-from+1];
    ArrayList<Integer> temp = new ArrayList<Integer>();
    for (int i=0;i<=to-from;i++){
      temp.add(i+from);
    }
    Collections.shuffle(temp);
    for (int i=0;i<=to-from;i++){
      result[i]=temp.get(i);
    }
    return result;
  }
}
