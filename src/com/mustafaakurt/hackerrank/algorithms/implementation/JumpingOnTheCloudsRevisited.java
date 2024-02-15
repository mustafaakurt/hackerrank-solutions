package com.mustafaakurt.hackerrank.algorithms.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JumpingOnTheCloudsRevisited {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c, int k) {
        int energy = 100;
        int current = 0;
        do {
            current = (current + k) % c.length;
            if (c[current] == 0) {
                energy -= 1;
            } else {
                energy -= 3;
            }
        } while (current != 0);

        return energy;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
