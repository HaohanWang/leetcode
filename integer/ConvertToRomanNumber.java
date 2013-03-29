package integer;

public class ConvertToRomanNumber {
  
  public static void main(String args[]){
    int n = 2327;
    System.out.println(new ConvertToRomanNumber().binaryToRoman(n));
  }
  
  // Parallel arrays used in the conversion process.
  private final String[] RCODE = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX",
      "V", "IV", "I" };

  private final int[] BVAL = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

  // =========================================================== binaryToRoman
  public String binaryToRoman(int binary) {
    if (binary <= 0 || binary >= 4000) {
      throw new NumberFormatException("Value outside roman numeral range.");
    }
    String roman = ""; // Roman notation will be accumualated here.

    // Loop from biggest value to smallest, successively subtracting,
    // from the binary value while adding to the roman representation.
    for (int i = 0; i < RCODE.length; i++) {
      while (binary >= BVAL[i]) {
        binary -= BVAL[i];
        roman += RCODE[i];
      }
    }
    return roman;
  }
}
