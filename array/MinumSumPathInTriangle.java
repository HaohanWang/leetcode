package array;

import java.util.ArrayList;
import java.util.List;

public class MinumSumPathInTriangle {
  public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
    // Start typing your Java solution below
    // DO NOT write main() function
    for (int i=triangle.size()-2;i>=0;i--){
        ArrayList<Integer> l = triangle.get(i);
        ArrayList<Integer> b = triangle.get(i+1);
        for (int j=0;j<=l.size()-1;j++){
            int item = l.get(j)+Math.max(b.get(j), b.get(j+1));
            l.set(j,item);
        }
        triangle.set(i, l);
    }
    return triangle.get(0).get(0);
}
}
