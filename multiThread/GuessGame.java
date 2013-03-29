package multiThread;

public class GuessGame {
  public static int result = 0;

  public static int target = 0;

  public static boolean correct = false;

  public static int direction = 0;

  public static int guess = 0;

  public static int judge = 1;

  public Guess guesser = new Guess();

  public Judge judger = new Judge();

  public static void main(String args[]) {
    target = (int) (Math.random() * 100);
    GuessGame gg = new GuessGame();
    gg.guesser.start();
    gg.judger.start();
  }

  class Guess implements Runnable {
    Thread t = new Thread(this, "guess");

    public void run() {
      while (!correct) {
        while (judge == guess) {
          // System.out.println("I am waiting for you....");
        }
        // try {
        // Thread.sleep(10);
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }
        if (direction == 0) {
          result = (int) (Math.random() * 100);
          System.out.println("Guess a result that is " + result);
        } else if (direction < 0) {
          result = (int) (Math.random() * result);
          System.out.println("Guess Nuumber " + guess + " Guess a result that is " + result);
        } else {
          result = (int) (Math.random() * (100 - result)) + result;
          System.out.println("Guess Nuumber " + guess + " Guess a result that is " + result);
        }
        guess += 1;
      }
    }

    public void start() {
      // TODO Auto-generated method stub
      t.setPriority(2);
      t.start();
    }
  }

  class Judge implements Runnable {
    Thread t = new Thread(this, "judge");

    public void run() {
      while (!correct) {
        while (guess < judge) {
          // System.out.println("Common on Guess");
        }
        // try {
        // Thread.sleep(10);
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }
        if (result == target) {
          correct = true;
          System.out.println("Your Guess is correct, Yeah!!");
        } else if (result > target) {
          direction = -1;
          System.out.println("Guess less");
        } else {
          direction = 1;
          System.out.println("Guess more");
        }
        judge += 1;
      }
    }

    public void start() {
      t.setPriority(2);
      t.start();
    }
  }
}
