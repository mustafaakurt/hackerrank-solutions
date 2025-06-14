package com.mustafaakurt.hackerrank.algorithms.implementation;

import java.io.*;

class Result {

    /*
     * Complete the 'pageCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER p
     */

    public static int pageCount(int n, int p) {
        int fromStart = calculateFromStart(p);
        int fromEnd = calculateFromEnd(n, p);

        return Math.min(fromStart, fromEnd);
    }

    private static int calculateFromStart(int p) {
        return p / 2;
    }

    private static int calculateFromEnd(int n, int p) {
        return (n / 2) - (p / 2);
    }

}

public class DrawingBook {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

