package input;

import java.util.Scanner;

public class SystemPause {
  public void pause(){
    Scanner in = new Scanner(System.in);
    System.out.println("Press any key to continue...");
    String a = in.nextLine();
  }
}
