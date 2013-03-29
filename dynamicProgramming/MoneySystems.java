/*
ID:haohanw1
PROG:money
LANG:JAVA
 */
package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class money {
  public static void main(String args[]) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader in = new BufferedReader(new FileReader("money.in"));
    // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("money.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    StringTokenizer st = new StringTokenizer(in.readLine());
    // Get line, break into tokens
    int N = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());
    int[] coin = new int[N + 1];
    st = new StringTokenizer(in.readLine());
    for (int i = 1; i <= N; i++) {
      coin[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(coin);
    int[][] way = new int[N + 1][V + 1];
    for (int i = 1; i <= N; i++) {
      way[i][0] = 1;
    }
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= V; j++) {
        if (j - coin[i] >= 0) {
          way[i][j] = way[i - 1][j] + way[i][j - coin[i]];
        } else {
          way[i][j] = way[i - 1][j];
        }
      }
    }

    // out.println(i1 + i2); // output result
    System.out.println(way[N][V]);
    out.println(way[N][V]);
    out.close(); // close the output file
    System.out.println("end");
    System.exit(0); // don't omit this!
  }
}
