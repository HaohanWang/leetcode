package string;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {
  public static void main(String args[]) {
    String s1 = "12345";
    String s2 = "12345";
    System.out.println(new MultiplyStrings().multiply(s1, s2));
  }

  /**
   * Given two numbers represented as strings, return multiplication of the numbers as a string.
   * Note: The numbers can be arbitrarily large and are non-negative. Analysis: This problem is kind
   * of easy, our steps are: 
   * 1) convert the two input strings into charArray 
   * 2) Digit by digit, multiply it for example, 123456789 * 987654321 when we are in the fifth digit in A, which is 5
   * We use 5 to multply all digits in B, it is, 5*1, 5*2,... and so on. And store them into a list
   * 3) convert this list to a string, and then return 
   * Important points: 
   * 1) 0s: When one digit in A or B is 0, we must could skip it and set the position be 0 
   * 2) Carray: we must make sure if
   * carry>0, set the last digit be carry
   * 
   * @param num1
   * @param num2
   * @return
   */
  public String multiply(String num1, String num2) {
    // Start typing your Java solution below
    // DO NOT write main() function
    // check these two input strings
    if (num1 == "" || num2 == "")
      return "0";
    if (num1.compareTo("0") == 0 || num2.compareTo("0") == 0)
      return "0";
    if (num1.compareTo("1") == 0)
      return num2;
    if (num2.compareTo("1") == 0)
      return num1;
    // initialize list
    char[] num_1 = num1.toCharArray();
    char[] num_2 = num2.toCharArray();
    List<Integer> list = initialize_list(num_1.length + num_2.length);
    for (int i = num_1.length - 1; i >= 0; i--) {
      int carry = 0;
      int start = num_1.length - 1 - i;
      // convert char to int
      int digit_in_1 = Character.getNumericValue(num_1[i]);
      // check whether this digit==0
      if (digit_in_1 == 0) {
        if (list.get(start) == -1)
          list.set(start, 0);
        continue;
      }
      for (int j = num_2.length - 1; j >= 0; j--) {
        // compute this digit
        // convert char to int
        int digit_in_2 = Character.getNumericValue(num_2[j]);
        // get our target position
        int position = start + (num_2.length - 1 - j);
        int multi = digit_in_1 * digit_in_2 + carry;
        // check if this digit has some num
        if (list.get(position) != -1)
          multi = multi + list.get(position);
        int digit = multi % 10;
        carry = multi / 10;
        // update the list
        list.set(position, digit);
      }
      if (carry > 0) {
        if (list.get(start + num_2.length) == -1)
          list.set(start + num_2.length, carry);
        else
          list.set(start + num_2.length, (list.get(start + num_2.length) + carry));
      }
    }
    // convert list to string
    String return_string = "";
    for (int i = list.size() - 1; i >= 0; i--)
      if (list.get(i) != -1)
        return_string = return_string + Integer.toString(list.get(i));
    return return_string;
  }

  public List<Integer> initialize_list(int length) {
    List<Integer> list = new ArrayList<Integer>();
    for (int i = 0; i < length; i++)
      list.add(-1);
    return list;
  }
}
