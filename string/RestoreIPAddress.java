package string;

import java.util.ArrayList;

/**
 * @deprecateds
 * @author haohanwang
 *
 */

public class RestoreIPAddress {
  public static void main(String args[]){
    String s = "25525511135";
    ArrayList<String> result= new RestoreIPAddress().restoreIpAddresses(s);
    for (String ss: result){
      System.out.println(ss);
    }
  }
  public ArrayList<String> restoreIpAddresses(String s) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<String> result = new ArrayList<String>();
    if (s.length() == 0 || s.length() >= 13)
      return result;
    long ip = Long.parseLong(s);
    for (long i = 10; i <= 1000; i = i * 10) {
      long four = ip % i;
      long forth = ip / i;
      if (four <= 255) {
        for (long j = 10; j <= 1000; j = j * 10) {
          long three = forth % j;
          long third = forth / i;
          if (three <= 255) {
            for (long m = 10; m <= 1000; m = m * 10) {
              long two = third % m;
              long second = third / m;
              if (two <= 255) {
                for (long t = 10; t <= 1000; t = t * 10) {
                  long one = second % t;
                  if (one <= 255) {
                    result.add(Long.toString(one) + "." +Long.toString(two) + "." + Long.toString(three) + "."
                            + Long.toString(four));
                  }
                }
              }
            }
          }
        }
      }
    }
    return result;
  }
}
